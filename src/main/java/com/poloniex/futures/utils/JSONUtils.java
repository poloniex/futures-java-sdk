package com.poloniex.futures.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.List;
import java.util.Map;

public class JSONUtils {

    public static <T> T toBean(String text, Class<T> clazz) {
        return JSON.parseObject(text, clazz);
    }

    public static <T> List<T> toList(JSONArray jsonArray, Class<T> clazz) {
        return JSON.parseArray(jsonArray.toJSONString(), clazz);
    }

    public static <T> List<T> toList(String text, Class<T> clazz) {
        return JSON.parseArray(text, clazz);
    }

    public static Map stringToCollect(String s) {
        Map m = JSONObject.parseObject(s);
        return m;
    }

    public static String toJSON(Object o) {
        return JSON.toJSONString(o);
    }
}
