package com.mizholdings.util;

import com.alibaba.fastjson.JSONObject;
import org.testng.Assert;

public class SampleAssert {

    public static void assertEquals(String string, JSONObject object) {
        assert string.equals(object.getString("msg")) : string + "==" + object.getString("msg");
    }

    public static void assertResult(String string, JSONObject object) {
        assert string.equals(object.getString("result")) : "result: " + object.getString("result") + " " + object.getString("msg");
    }

    public static void assertTrue(Boolean bool, String msg) {
        assert bool : msg;
    }

    public static void assertFalse(Boolean bool, String msg) {
        assert !bool : msg;
    }

    public static void assertCode200(JSONObject object) {
        assert "200".equals(object.getString("code")) : "code:" + object.getString("code");
    }

    public static void assertResult0(JSONObject object) {
        assert "0".equals(object.getString("result")) : "result:" + object.getString("result");
    }



}
