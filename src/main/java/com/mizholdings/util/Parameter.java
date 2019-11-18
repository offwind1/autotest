package com.mizholdings.util;

import java.util.HashMap;
import java.util.Map;

public class Parameter {
    private Map<String, String> map = new HashMap<>();

    public static Parameter creat() {
        return new Parameter();
    }

    public Parameter add(String key, String value) {
        map.put(key, value);
        return this;
    }

    public Map<String, String> getMap() {
        return map;
    }

}
