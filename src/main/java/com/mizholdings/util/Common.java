package com.mizholdings.util;

import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class Common {
    private static Random random = new Random();
    private static final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static final String TEMP_STRING = "接口测试生成课";

    public static String getNowTime() {
        return format.format(new Date());
    }

    public static String getNowDay() {
        return DateUtil.today();
    }

    public static String getEndTime(int days) {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DAY_OF_MONTH, days);
        return format.format(c.getTime());
    }


    public static String creatRandomString() {
        return TEMP_STRING + DateUtil.format(DateUtil.date(), "yyyy-MM-dd_HH:mm");
//        return UUID.randomUUID().toString().replace("-", "").substring(0, 4);
    }

    public static JSONObject filder(JSONArray array, String key, String tag) {
        List<Object> list = array.stream().filter(i -> {
            JSONObject o = (JSONObject) i;
            return key.equals(o.getString(tag));
        }).collect(Collectors.toList());

        if (list.size() > 0) {
            return (JSONObject) list.get(0);
        }
        return null;
    }

    public static String get(JSONObject object, String key) {
        return object.getString(key);
    }

    public static String randomJoinFromList(String format, List<String> list) {
        Collections.shuffle(list);
        return String.join(format, list.subList(0, list.size() / 3));
    }

    public static JSONObject random(JSONArray array) {
        return array.getJSONObject(random.nextInt(array.size()));
    }

    public static List<String> map(JSONArray array, String tag) {
        return array.stream().map(i -> {
            JSONObject o = (JSONObject) i;
            return o.getString(tag);
        }).collect(Collectors.toList());
    }

    public static int range(int a, int b) {
        return a + random.nextInt(b - a);
    }

}
