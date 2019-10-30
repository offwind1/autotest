package com.mizholdings.util;

import com.alibaba.fastjson.JSONObject;
import org.testng.Assert;

public class SampleAssert {

    public static void assertEquals(String string, JSONObject object) {
        Assert.assertEquals(string, object.getString("msg"));
    }

}
