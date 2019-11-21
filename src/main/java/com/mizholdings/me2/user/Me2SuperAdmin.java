package com.mizholdings.me2.user;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.agent.web.LessonAgent;
import com.mizholdings.me2.interfaces.web.UsrInterface;
import com.mizholdings.util.*;
import io.qameta.allure.Step;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

import java.util.Map;

public class Me2SuperAdmin extends User {
    private LessonAgent lessonAgent;
    public static UsrInterface usrInterface = Requests.getService(UsrInterface.class);
    protected String token;

    public Me2SuperAdmin(String account, String password) {
        webInit(webLogin(account, password));
    }

    private void webInit(JSONObject object) {
        SampleAssert.assertEquals("登录成功!", object);
        token = object.getString("token");
    }

    @Step("管理员登录")
    public JSONObject webLogin(String account, String password) {
        return Requests.getJson(usrInterface.manageLogin(
                Parameter.creat()
                        .add("userName", account)
                        .add("password", password)
                        .getMap()
                )
        );
    }

    public LessonAgent lessonAgent() {
        return (LessonAgent) getAgent("lessonAgent");
    }


    public String getToken() {
        return token;
    }
}
