package com.common.web.client;

import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;


@Configuration
@ConfigurationProperties(prefix = "resttemplate")
public class RestTemplateConfig {


    /**
     * 连接超时时间
     */

    protected int connectTimeoutMs;

    /**
     * 响应超时时间
     */

    protected int readTimeoutMs;

    @Bean
    @LoadBalanced
    RestClient restClient() {
//        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
//        requestFactory.setConnectTimeout(connectTimeoutMs);
//        requestFactory.setReadTimeout(readTimeoutMs);
//        RestClient restClient = new RestClient();
//        restClient.setRequestFactory(requestFactory);
//        return restClient;

        // 构造restTemplate
        RequestConfig config = RequestConfig
                .custom()
                .setConnectionRequestTimeout(connectTimeoutMs)
                .setConnectTimeout(connectTimeoutMs)
                .setSocketTimeout(readTimeoutMs)
                .build();
        HttpClientBuilder builder = HttpClientBuilder
                .create()
                .setDefaultRequestConfig(config)
                .setRetryHandler(new DefaultHttpRequestRetryHandler(5, false));
        HttpClient httpClient = builder.build();
        //使用httpClient创建一个ClientHttpRequestFactory的实现
        ClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
        //ClientHttpRequestFactory作为参数构造一个使用作为底层的RestTemplate
        RestClient restClient = new RestClient();
        restClient.setRequestFactory(requestFactory);
        return restClient;
    }
    
    @Bean
    RestClient outerRestClient() {
        // 构造restTemplate
        RequestConfig config = RequestConfig
                .custom()
                .setConnectionRequestTimeout(connectTimeoutMs)
                .setConnectTimeout(connectTimeoutMs)
                .setSocketTimeout(readTimeoutMs)
                .build();
        HttpClientBuilder builder = HttpClientBuilder
                .create()
                .setDefaultRequestConfig(config)
                .setRetryHandler(new DefaultHttpRequestRetryHandler(5, false));
        HttpClient httpClient = builder.build();
        //使用httpClient创建一个ClientHttpRequestFactory的实现
        ClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
        //ClientHttpRequestFactory作为参数构造一个使用作为底层的RestTemplate
        RestClient restClient = new RestClient();
        restClient.setRequestFactory(requestFactory);
        return restClient;
    }

    public int getConnectTimeoutMs() {
        return connectTimeoutMs;
    }

    public void setConnectTimeoutMs(int connectTimeoutMs) {
        this.connectTimeoutMs = connectTimeoutMs;
    }

    public int getReadTimeoutMs() {
        return readTimeoutMs;
    }

    public void setReadTimeoutMs(int readTimeoutMs) {
        this.readTimeoutMs = readTimeoutMs;
    }
}

