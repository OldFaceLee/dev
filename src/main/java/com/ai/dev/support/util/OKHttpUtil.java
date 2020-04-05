package com.ai.dev.support.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;

import java.util.Iterator;
import java.util.Map;

/**
 * @author: lixuejun
 * @date: Create in 2020/4/1 下午10:51
 * @description:
 */
@Slf4j
public class OKHttpUtil {

    private Response response = null;
    private Headers headers = null;
    private RequestBody requestBody = null;

    private OKHttpUtil(){}
    private static class Singleton{
        private static OKHttpUtil instance = new OKHttpUtil();
    }
    public static OKHttpUtil getInstance(){
        return Singleton.instance;
    }


    /**
     * 共用设置header的方法封装
     * @param headersParams
     * @return
     */
    private Headers setHeaders(Map<String, String> headersParams) {
        Headers.Builder headersbuilder = new Headers.Builder();
        if (headersParams != null) {
            Iterator<String> iterator = headersParams.keySet().iterator();
            String key = "";
            while (iterator.hasNext()) {
                key = iterator.next().toString();
                headersbuilder.add(key, headersParams.get(key));
                log.info(String.format("设置Headers其中[key] = [%s], [value] = [%s]", key, headersParams.get(key)));
            }
        }
        headers = headersbuilder.build();

        return headers;
    }

    /**
     * 共用方法设置requestBody
     * @param BodyParams
     * @return
     */
    private RequestBody SetRequestBody(Map<String, String> BodyParams){
        RequestBody body=null;
        FormBody.Builder formEncodingBuilder=new FormBody.Builder();
        if(BodyParams != null){
            Iterator<String> iterator = BodyParams.keySet().iterator();
            String key = "";
            while (iterator.hasNext()) {
                key = iterator.next().toString();
                formEncodingBuilder.add(key, BodyParams.get(key));
            }
        }
        body=formEncodingBuilder.build();
        return body;

    }

    /**
     * 返回共用的response.string
     * @param request
     * @return
     */
    private String response(Request request){
        String responseStr = null;
        try {
            response = OkHttpInstance.getClient().newCall(request).execute();
            int status = response.code();
            if (response.isSuccessful()) {
                log.info(String.format("[HTTP_CODE] = [%s]",status));
                responseStr = response.body().string();
                log.info(String.format("[RESPONSE_STRING] =%s",responseStr));
                return responseStr;
            }else {
                log.info(String.format("[HTTP_CODE] = [%s]",status));
                responseStr = response.body().string();
                log.info(String.format("[RESPONSE_STRING] =%s",responseStr));
                return responseStr;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (response != null) {
                log.info("response不为空，关闭response");
                response.close();
            }
        }
        return responseStr;
    }

    /**
     * post,传入stringJson
     * @param url
     * @param headers
     * @param jsonParams
     * @return
     */
    public JSONObject post(String url, Map<String,String> headers, String jsonParams){
        requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"),jsonParams);
        Request request = new Request.Builder()
                .url(url)
                .headers(setHeaders(headers))
                .post(requestBody)
                .build();
        log.info(String.format("[RequestURL] = %s", request.url()));
        log.info(String.format("[RequestHeader] = %s", JSON.toJSONString(headers)));
        log.info(String.format("[RequestBody] = %s",jsonParams));
        return JSONObject.parseObject(response(request));
    }

    /**
     * 直接传url,headers可为空
     * @param url
     * @param headerParams
     * @return
     */
    public JSONObject get(String url, Map<String, String> headerParams) {
        Request request = new Request.Builder()
                .url(url)
                .headers(setHeaders(headerParams))
                .build();
        log.info(String.format("[RequestURL] = %s", request.url()));
        log.info(String.format("[RequestHeader] = %s", JSON.toJSONString(headerParams)));
        return JSONObject.parseObject(response(request));
    }

}
