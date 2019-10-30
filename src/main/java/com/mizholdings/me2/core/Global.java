package com.mizholdings.me2.core;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.model.User;

import java.util.HashMap;
import java.util.Map;

public class Global {
    private static Map<String, Object> _data = new HashMap<>();
    public static User teacher;

    public static void setData(String key, Object value) {
        _data.put(key, value);
    }

    public static void setTeacher(JSONObject object) {
        teacher = new User();
        teacher.setToken(object.getString("token"));
        teacher.setOrgId(object.getJSONObject("data").getInteger("orgId"));
        teacher.setUserId(object.getJSONObject("data").getString("userId"));
    }
}
