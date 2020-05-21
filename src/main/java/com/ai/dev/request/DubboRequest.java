package com.ai.dev.request;

import com.ai.dev.support.util.EntityUtil;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.utils.ReferenceConfigCache;
import org.apache.dubbo.rpc.service.GenericService;
import org.apache.http.util.EntityUtils;

import java.util.Date;
import java.util.HashMap;

/**
 * @author: lixuejun
 * @date: Create in 2020/4/1 下午11:18
 * @description:
 */

@Slf4j
public class DubboRequest {

    private DubboRequest(){}

    private static class Singleton{
        private static DubboRequest instance = new DubboRequest();
    }
    public static DubboRequest getInstance(){
        return Singleton.instance;
    }

    //com.ai.crm.third.rpc.avgexchangerate.IAvgExchangeRateSv:1.0.0
    //exchangeRate

    public void run(){
        String addr = "10.19.15.15:29181";
        String interfaceName = "com.ai.crm.third.rpc.avgexchangerate.IAvgExchangeRateSv:1.0.0";
        String methodName = "exchangeRate";
        String appName = "dev";
        System.out.println("测试："+this.doDubboRequest(addr,interfaceName,appName,methodName,""));
    }



    public String doDubboRequest(String registerZKAddress,String interfaceName,String applicationName,String methodName,String jsonParma){
        //ApplicationConfig为dubbo的配置文件信息
        ApplicationConfig applicationConfig = new ApplicationConfig();
        //设置一个名字
        applicationConfig.setName(applicationName);


        //注册中心对象配置
        RegistryConfig registryConfig = new RegistryConfig();
        //注册中心的地址
        registryConfig.setAddress(registerZKAddress);
        //如果服务端没有设置分组参数，调用时也不需要设置分组
        //registryConfig.setGroup("");
        registryConfig.setProtocol("zookeeper");
        registryConfig.setClient("zkclient");

        //与注册中心连接以及与提供者连接
        ReferenceConfig<GenericService> referenceConfig = new ReferenceConfig<GenericService>();
        referenceConfig.setApplication(applicationConfig);
        referenceConfig.setRegistry(registryConfig);
        //指定了调用的接口服务
        referenceConfig.setInterface(interfaceName);

        //声明为泛化接口
        referenceConfig.setGeneric(true);
        //建立缓存，减少客户端本地的开销
        ReferenceConfigCache cache = ReferenceConfigCache.getCache();
        GenericService genericService = cache.get(referenceConfig);


       // HashMap<String,Object> map = EntityUtil.getInstance().jsonToMap(jsonParma);
        Object result = genericService.$invoke(methodName,new String[]{"String","String","Date"},new Object[]{"CNY","CNY",new Date()});
        return JSON.toJSONString(result);
    }
}

