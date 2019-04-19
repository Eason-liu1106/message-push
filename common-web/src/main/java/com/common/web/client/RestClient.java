package com.common.web.client;


import common.argument.exception.constant.CommonException;
import common.argument.result.ResultEnity;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Map;

/**
 * @author JialinLiu
 * @date 2019/4/17 0017 14:18
 */
@Component
public class RestClient extends RestTemplate {
    protected static final Log log = LogFactory.getLog(RestClient.class);

    @SuppressWarnings({"unchecked", "rawtypes"})
    private HttpEntity setContentTypeToApplicationJson(Object params) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new HttpEntity(params, headers);
    }

    public ResultEnity postForJsonResult(String url, @Nullable Object params, Object... uriVariables) {

        ResultEnity ResultEnity = super.postForEntity(url, setContentTypeToApplicationJson(params), ResultEnity.class, uriVariables).getBody();

        if (ResultEnity.SUCCESS != ResultEnity.getCode()) {
            log.error("url: " + url + " call failure. code: " + ResultEnity.getCode() + ", return :" + ResultEnity.getData());
            throw new CommonException(ResultEnity.getCode(), ResultEnity.getMsg());
        }
        return ResultEnity;
    }

    public ResultEnity postForJsonResult(String url, @Nullable Object params, Map<String, ?> uriVariables) {
        ResultEnity ResultEnity = super.postForEntity(url, setContentTypeToApplicationJson(params), ResultEnity.class, uriVariables).getBody();

        if (ResultEnity.SUCCESS != ResultEnity.getCode()) {
            log.error("url: " + url + " call failure. code: " + ResultEnity.getCode() + ", return :" + ResultEnity.getData());

            throw new CommonException(ResultEnity.getCode(), ResultEnity.getMsg());
        }
        return ResultEnity;
    }

    public ResultEnity postForJsonResult(URI url, @Nullable Object params) {
        ResultEnity ResultEnity = super.postForEntity(url, setContentTypeToApplicationJson(params), ResultEnity.class).getBody();

        if (ResultEnity.SUCCESS != ResultEnity.getCode()) {
            log.error("url: " + url + " call failure. code: " + ResultEnity.getCode() + ", return :" + ResultEnity.getData());

            throw new CommonException(ResultEnity.getCode(), ResultEnity.getMsg());
        }
        return ResultEnity;
    }

    public ResultEnity getForJsonResult(URI url) {
        ResultEnity ResultEnity = super.getForEntity(url, ResultEnity.class).getBody();

        if (ResultEnity.SUCCESS != ResultEnity.getCode()) {
            log.error("url: " + url + " call failure. code: " + ResultEnity.getCode() + ", return :" + ResultEnity.getData());

            throw new CommonException(ResultEnity.getCode(), ResultEnity.getMsg());
        }
        return ResultEnity;
    }

    public ResultEnity getForJsonResult(String url, Object... uriVariables) {
        ResultEnity ResultEnity = super.getForEntity(url, ResultEnity.class, uriVariables).getBody();
        if (ResultEnity.SUCCESS != ResultEnity.getCode()) {
            log.error("url: " + url + " call failure. code: " + ResultEnity.getCode() + ", return :" + ResultEnity.getData());
            throw new CommonException(ResultEnity.getCode(), ResultEnity.getMsg());
        }
        return ResultEnity;
    }

    public ResultEnity getForJsonResult(String url, Map<String, ?> uriVariables) {
        ResultEnity ResultEnity = super.getForEntity(url, ResultEnity.class, uriVariables).getBody();

        if (ResultEnity.SUCCESS != ResultEnity.getCode()) {
            log.error("url: " + url + " call failure. code: " + ResultEnity.getCode() + ", return :" + ResultEnity.getData());
            throw new CommonException(ResultEnity.getCode(), ResultEnity.getMsg());
        }
        return ResultEnity;
    }

}
