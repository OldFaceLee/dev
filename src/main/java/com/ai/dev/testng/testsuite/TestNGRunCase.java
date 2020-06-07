package com.ai.dev.testng.testsuite;
import java.util.Date;

import com.ai.dev.em.RestFulCaseEnum;
import com.ai.dev.mapper.vo.TpHttpCase;
import com.ai.dev.support.util.HttpClientUtil;
import com.ai.dev.support.util.Json2MapUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: lixuejun
 * @date: Create in 2020/5/26
 * @description:
 */
@Slf4j
public class TestNGRunCase{

    /**
     * 执行http类型的单个测试用例
     * @param tpHttpCase
     * @return
     */
    private String httpCaseRun(TpHttpCase tpHttpCase){
        String responseJson = null;
        Map<String,Object> header= Json2MapUtil.getInstance().jsonToMap(tpHttpCase.getHeader());
        Map<String,String> convert = new HashMap<>();
        header.forEach((k,v)->{
            convert.put(k,v.toString());
        });
        if(tpHttpCase.getRequestType().equals(RestFulCaseEnum.REQUEST_TYPE_GET.getValue())){
            JSONObject responseGet = HttpClientUtil.getInstance().get(tpHttpCase.getUri(),convert);
            responseJson = JSON.toJSONString(responseGet);
        } else if(tpHttpCase.getRequestType().equals(RestFulCaseEnum.REQUEST_TYPE_POST.getValue())){
            JSONObject responsePost = HttpClientUtil.getInstance().post(tpHttpCase.getUri(),convert,tpHttpCase.getRequestBody());
            responseJson = JSON.toJSONString(responsePost);
        }
        log.info("执行了testNG,返回的结果：" + responseJson);
        return responseJson;
    }

    @Test(dataProvider = "dp")
    public void runScript(String jsonParam){
        System.out.println(jsonParam);
//        this.httpCaseRun(tpHttpCase);
    }

    @DataProvider(name = "dp")
    public Object[][] dp(){
        TpHttpCase tpHttpCase = new TpHttpCase();
        tpHttpCase.setCaseId("TC005");
        tpHttpCase.setSystemName("testNG");
        tpHttpCase.setCaseName("通过testNG设置");
        tpHttpCase.setCaseDesc("描述testNG");
        tpHttpCase.setCaseGroups("组testNG");
        tpHttpCase.setRequestType(1);
        tpHttpCase.setUri("http://localhost:8080/testcase/restful/add");
        tpHttpCase.setPort(0);
        tpHttpCase.setHeader("{\"auth\":\"accessToken\"}");
        tpHttpCase.setRequestBody("{\"key\":\"value\"}");
        tpHttpCase.setCheckSql("select * from table");
        tpHttpCase.setExpectedResult("这就是期望的");
        tpHttpCase.setCreateUser("李学军");
        tpHttpCase.setCreateDate(new Date());
        tpHttpCase.setOperateUser("");
        tpHttpCase.setUpdateDate(new Date());
        tpHttpCase.setIsValid(0);

        return new Object[][]{
                {"我是李二"}

        };
    }
}
