package com.mizholdings.util;

import com.alibaba.fastjson.JSONObject;
import org.testng.Assert;

public class SampleAssert {

    public static boolean ifMsg(String string, JSONObject object) {
        return string.equals(object.getString("msg"));
    }

    public static boolean ifCode200(JSONObject object) {
        return "200".equals(object.getString("code"));
    }

    public static boolean ifResult0(JSONObject object) {
        return "0".equals(object.getString("result"));
    }

    private static void throwRuntimeException(JSONObject object) {
        throw new RuntimeException(object.getString("msg"));
    }

    public static void throwCode200(JSONObject object) {
        if (!ifCode200(object)) {
            throwRuntimeException(object);
        }
    }

    public static void throwResult0(JSONObject object) {
        if (!ifResult0(object)) {
            throwRuntimeException(object);
        }
    }

    public static void throwMsg(String string, JSONObject object) {
        if (!ifMsg(string, object)) {
            throw new RuntimeException(string + "!=" + object.getString("msg"));
        }
    }


    public static void assertEquals(String string, JSONObject object) {
        assert string.equals(object.getString("msg")) : string + "==" + object.getString("msg");
    }

    public static void assertMsg(String string, JSONObject object) {
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
