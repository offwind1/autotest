package com.mizholdings.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class Common {
    private static final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    public static String getNowTime() {
        return format.format(new Date());
    }

    public static String getEndTime(int days) {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DAY_OF_MONTH, days);
        return format.format(c.getTime());
    }

    public static String creatRandomString() {
        return UUID.randomUUID().toString().replace("-", "").substring(0, 4);
    }

    public static JSONObject filder(JSONArray array, String key, String tag) {
        List<Object> list = array.stream().filter(i -> {
            JSONObject o = (JSONObject) i;
            return key.equals(o.getString(tag));
        }).collect(Collectors.toList());

        assert list.size() > 0;
        return (JSONObject) list.get(0);
    }


}
