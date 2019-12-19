package com.mizholdings.me2.user;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.user.serve.App;
import com.mizholdings.me2.user.serveInterface.appInterface;
import com.mizholdings.util.*;
import com.mizholdings.util.requests.Request;
import io.qameta.allure.Step;

public class Me2UserBase extends User implements appInterface {
    protected JSONObject object;
    protected String account;
    protected String password;
    protected String cloudUsrAccount = "";
    protected App app;

    public Me2UserBase(String account, String password, String TAG) {
        this.account = account;
        this.password = password;

        if (TAG.equals("app")) {
            init(login());
        } else if (TAG.equals("web")) {
            webInit(webLogin());
        }

        app = new App(this);
    }

    public App getApp() {
        return app;
    }

    public static JSONObject Login(String account, String password) {

        return Request.go("app", "mobile", "login", Parameter.creat()
                .add("account", account)
                .add("password", password)
                .add("phone", "")
                .add("verifycode", "")
                .add("loginMode", "")
                .add("machine", "")
                .add("proType", "ykdebug")
                .add("longitude", "")
                .add("latitude", "")
                .getObjectMap()).json();
    }

    private void init(JSONObject object) {
        SampleAssert.assertEquals("查询成功", object);
        this.object = object;
        token = object.getJSONObject("data").getString("token");
        userId = object.getJSONObject("data").getString("userId");
        cloudUsrAccount = object.getJSONObject("data").getString("cloudUsrAccount");
        bookToken = object.getJSONObject("data").getString("booktoken");
    }

    private void webInit(JSONObject object) {
        SampleAssert.assertEquals("登录成功!", object);
        this.object = object;
        token = object.getString("token");
        userId = object.getJSONObject("data").getString("userId");
        bookToken = object.getJSONObject("data").getString("booktoken");
    }

    @Step("用户登陆(手机/邮箱/用户名) app")
    public JSONObject login() {
        return Request.go("app", "mobile", "login", Parameter.creat()
                .add("account", account)
                .add("password", password)
                .add("orgId", orgId)
                .add("phone", "")
                .add("verifycode", "")
                .add("loginMode", "")
                .add("machine", "")
                .add("proType", "ykdebug")
                .add("longitude", "")
                .add("latitude", "")
                .getObjectMap()).json();
    }

    @Step("用户登陆(手机/邮箱/用户名) web")
    public JSONObject webLogin() {
        return Request.go("web", "usr", "login", Parameter.creat()
                .add("userName", account)
                .add("password", password)
                .getObjectMap()).json();
    }

    public JSONObject orgLogin(String orgId) {
        setOrgId(orgId);
        JSONObject object = login();
        setOrgId("0");
        return object;
    }


    public String getAccount() {
        return account;
    }

    public String getCloudUsrAccount() {
        return cloudUsrAccount;
    }
}
