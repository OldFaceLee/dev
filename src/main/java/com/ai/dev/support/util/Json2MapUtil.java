package com.ai.dev.support.util;

import com.alibaba.fastjson.JSONObject;

import java.util.*;

/**
 * @author: lixuejun
 * @date: Create in 2020/5/26
 * @description:
 */
public class Json2MapUtil {

    private Json2MapUtil(){}
    private static class Singleton{
        private static final Json2MapUtil instance =new Json2MapUtil();
    }
    public static Json2MapUtil getInstance(){
        return Singleton.instance;
    }

    public Map<String, Object> jsonToMap(String jsonStr) {
        Map<String, Object> map = new HashMap<>();
        JSONObject json = JSONObject.parseObject(jsonStr);
        for (Object k : json.keySet()) {
            Object v = json.get(k);
            if (v instanceof com.alibaba.fastjson.JSONArray) {
                List<Map<String, Object>> list = new ArrayList<>();
                Iterator it = ((com.alibaba.fastjson.JSONArray) v).iterator();
                while (it.hasNext()) {
                    Object json2 = it.next();
                    list.add(jsonToMap(json2.toString()));
                }
                map.put(k.toString(), list);
            } else {
                map.put(k.toString(), v);
            }
        }
        return map;
    }

}
