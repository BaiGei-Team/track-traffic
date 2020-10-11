package com.track.traffic.rpc.utils;

import com.alibaba.fastjson.JSON;
import com.track.traffic.common.exception.HttpException;
import com.track.traffic.common.utils.ValidatorUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.DefaultRedirectStrategy;
import org.apache.http.impl.client.HttpClients;
import org.springframework.http.HttpStatus;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Objects;

/**
 * Created by SoulW on 2020/10/11.
 *
 * @author SoulW
 * @since 2020/10/11 15:39
 */
public class HttpClientUtils {

    /**
     * 默认超时时间
     */
    private static final int TIMEOUT = Integer.parseInt(System.getProperty("HttpClientUtils.timeout", "10000"));
    /**
     * 缓存大小
     */
    private static final int BUF_SIZE = 1024;
    /**
     * 默认请求客户端
     */
    private static final HttpClient CLIENT = HttpClients.custom()
            .setMaxConnTotal(200)
            .setMaxConnPerRoute(32)
            .setDefaultRequestConfig(RequestConfig.custom()
                    .setConnectTimeout(TIMEOUT)
                    .setSocketTimeout(TIMEOUT)
                    .setConnectTimeout(TIMEOUT)
                    .build())
            .build();

    /**
     * 执行Get请求
     *
     * @param url 请求参数
     * @return 结果
     */
    public static String get(String url) {
        return get(url, String.class);
    }

    /**
     * 执行Get请求
     *
     * @param url 请求参数
     * @param ref 反序列化类型
     * @param <T> 类型
     * @return 结果
     */
    public static <T> T get(String url, Class<T> ref) {
        ValidatorUtils.checkNotNull(url, "request url is null");
        ValidatorUtils.checkNotNull(ref, "ref is null");
        try {
            HttpGet get = new HttpGet(url);
            HttpResponse resp = CLIENT.execute(get);
            byte[] respBytes = readResult(resp);
            return deserialize(ref, respBytes);
        } catch (IOException e) {
            throw new HttpException("HttpClientUtils.get() error, url=" + url + ", ref=" + ref, e);
        }
    }

    /**
     * 执行Post请求
     *
     * @param url     请求参数
     * @param data    数据对象
     * @param respRef 响应类型
     * @param <T>     类型
     * @return 结果
     */
    public static <T> T post(@Nonnull String url,
                             @Nullable Map<String, String> header,
                             @Nonnull Object data,
                             @Nonnull Class<T> respRef) {
        ValidatorUtils.checkNotNull(url, "request url is null");
        ValidatorUtils.checkNotNull(data, "post data is null");
        ValidatorUtils.checkNotNull(respRef, "response ref is null");
        try {
            // 构造请求对象
            HttpPost post = new HttpPost(url);
            // 写入头信息
            post.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/85.0.4183.121 Safari/537.36");
            post.addHeader("Connection", "closed");
            post.addHeader("Cache-Control", "no-cache");
            post.addHeader("Content-Type", ContentType.APPLICATION_JSON.toString());
            post.addHeader("Accept", "*/*;charset=UTF-8");
            MapUtils.emptyIfNull(header)
                    .forEach(post::addHeader);
            // 写入BODY信息
            post.setEntity(new ByteArrayEntity(JSON.toJSONBytes(data), ContentType.APPLICATION_JSON));
            HttpResponse resp = CLIENT.execute(post);
            byte[] respBytes = readResult(resp);
            return deserialize(respRef, respBytes);
        } catch (IOException e) {
            throw new HttpException("HttpClientUtils.post() error, url=" + url + ", header=" + header + ", data=" + data + ", respRef=" + respRef, e);
        }
    }

    @SuppressWarnings("unchecked")
    private static <T> T deserialize(@Nonnull Class<T> respRef, byte[] respBytes) {
        if (Objects.isNull(respBytes) || respBytes.length == 0) {
            return null;
        }
        if (String.class == respRef) {
            return (T) new String(respBytes, StandardCharsets.UTF_8);
        } else {
            return JSON.parseObject(respBytes, respRef);
        }
    }

    private static byte[] readResult(HttpResponse resp) throws IOException {
        // 响应码检查
        checkRespCode(resp);
        // 读取Entity
        HttpEntity entity = resp.getEntity();
        if (Objects.isNull(entity)) {
            return new byte[0];
        }
        // 读取响应流
        InputStream content = entity.getContent();
        if (Objects.isNull(content)) {
            return new byte[0];
        }
        // 读取数据
        ByteArrayOutputStream out = new ByteArrayOutputStream(BUF_SIZE);
        byte[] buf = new byte[BUF_SIZE];
        int offset = -1;
        while ((offset = content.read(buf, 0, buf.length)) != -1) {
            out.write(buf, 0, offset);
        }
        return out.toByteArray();
    }

    private static void checkRespCode(HttpResponse resp) {
        // 入参检查
        if (Objects.isNull(resp) || Objects.isNull(resp.getStatusLine())) {
            throw new HttpException("response is null");
        }
        // 校验响应码
        StatusLine statusLine = resp.getStatusLine();
        if (Objects.isNull(statusLine) ||
                statusLine.getStatusCode() < HttpStatus.OK.value() ||
                statusLine.getStatusCode() >= HttpStatus.BAD_REQUEST.value()) {
            throw new HttpException("response code error, code=" + statusLine.getStatusCode() + ", errorMsg=" + statusLine.getReasonPhrase());
        }
    }
}
