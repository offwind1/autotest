package com.mizholdings.kacha.core;


import java.util.HashMap;
import java.util.Map;

public class Global {
    private static Map<String, Object> _data = new HashMap<>();
    public static void setData(String key, Object value) {
        _data.put(key, value);
    }


}
