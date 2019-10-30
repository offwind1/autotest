package com.mizholdings.me2.cases;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.interfaces.UsrLogin;
import com.mizholdings.me2.core.Global;
import com.mizholdings.util.Requests;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;

public class BeforeTestCase {
    private UsrLogin service = Requests.getService(UsrLogin.class);

    @BeforeTest
    public void beforeTest() {
        Global.setTeacher(teacherLogin());
    }

    public JSONObject teacherLogin() {
        JSONObject object = Requests.getJson(service.user_login("cs0002", "111111"));
        Assert.assertEquals(object.getString("msg"), "登录成功!");
        return object;
    }

}

//持续 配置


