package com.ai.dev.support.util;

/**
 * @author: lixuejun
 * @date: Create in 2020/3/26 下午7:48
 * @description:
 */
public class DateUtil {

    private DateUtil(){}
    private static class Singleton{
        private static DateUtil instance = new DateUtil();
    }
    public static DateUtil getInstance(){
        return Singleton.instance;
    }





}
