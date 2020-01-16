package com.mizholdings.util;


import java.util.Map;

/**
 * 可提取的
 * 通过
 */
public interface Extractable {
    Map<String, String> getMap();

    Map<String, Object> getObjectMap();

    Parameter build();
}
