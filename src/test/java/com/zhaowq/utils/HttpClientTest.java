package com.zhaowq.utils;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;

public class HttpClientTest {
    private static String key = "";

    @Test
    public void test() {
        // CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpClient httpClient = HttpUtils.createSSLClientDefault();
        HttpGet get = new HttpGet("https://95598.gd.csg.cn/");
        String result = null;
        try {
            CloseableHttpResponse response = httpClient.execute(get);
            result = EntityUtils.toString(response.getEntity(), "utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(result);
    }

    /**
     * 测试如何走代理
     */
    @Test
    public void test2() {
        // HttpClient
        CloseableHttpClient closeableHttpClient = HttpUtils.createSSLClientDefault();
        // 依次是代理地址，代理端口号，协议类型
        HttpHost proxy = new HttpHost("127.0.0.1", 8787, "http");
        RequestConfig config = RequestConfig.custom().setProxy(proxy).build();

        // 请求地址
        HttpGet httpGet = new HttpGet(
                "https://maps.googleapis.com/maps/api/geocode/json?latlng=28,4&key=" + key + "&result_type=country");
        httpGet.setConfig(config);
        try {
            CloseableHttpResponse response = closeableHttpClient.execute(httpGet);
            // getEntity()
            HttpEntity httpEntity = response.getEntity();
            if (httpEntity != null) {
                // 打印响应内容
                System.out.println("response:" + EntityUtils.toString(httpEntity, "UTF-8"));
            }
            // 释放资源
            closeableHttpClient.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
