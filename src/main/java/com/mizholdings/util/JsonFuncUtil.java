package com.mizholdings.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sun.org.apache.regexp.internal.RE;
import org.testng.annotations.IFactoryAnnotation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * 基于com.alibaba.fastjson的，工具函数
 */
public class JsonFuncUtil {


    /**
     * 筛选
     * 从array中，以一定的规则进行筛选
     */
    public static Optional<List<Object>> filter(JSONArray array, final String value, final String key) {
        return filter(array, o -> {
            if (o instanceof JSONObject) {
                return value.equals(((JSONObject) o).getString(key));
            }
            return false;
        });
    }

    /**
     * 筛选
     * 从array中，以一定的规则进行筛选
     */
    public static Optional<List<Object>> filter(JSONArray array, Predicate<Object> executor) {
        List<Object> list = array.stream().filter(executor::test).collect(Collectors.toList());
        return Optional.of(list);
    }

    /**
     * 提取
     * 从array中，提取第一个满足条件的对象
     */
    public static Optional<JSONObject> extract(JSONArray array, final String value, final String key) {
        return head(filter(array, value, key).orElse(new ArrayList<>()));
    }

    /**
     * 提取
     * 从array中，提取第一个满足条件的对象
     */
    public static Optional<JSONObject> extract(JSONArray array, Predicate<Object> executor) {
        return head(filter(array, executor).orElse(new ArrayList<>()));
    }

    /**
     * 取出列表中第一个对象
     */
    private static Optional<JSONObject> head(List list) {
        if (list.size() > 0) {
            Object o = list.get(0);
            if (o instanceof JSONObject) {
                return Optional.of((JSONObject) o);
            }
        }
        return Optional.empty();
    }

}
