package com.mizholdings.me2.user;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.agent.app.*;
import com.mizholdings.me2.interfaces.web.UsrInterface;
import com.mizholdings.me2.interfaces.api.MobileInterface;
import com.mizholdings.me2.playload.PLMobile;
import com.mizholdings.util.*;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Me2UserBase extends User {
    public static MobileInterface mobileInterface = Requests.getService(MobileInterface.class);
    public static UsrInterface usrInterface = Requests.getService(UsrInterface.class);

    protected JSONObject object;
    protected String account;
    protected String password;

    private LessonInfoAgent lessonInfoAgent;
    private CourseAgent courseAgent;
    private MobileAgent mobileAgent;
    private VoteAgent voteAgent;
    private FullschAgent fullschAgent;
    private CardAgent cardAgent;

    public Me2UserBase(String account, String password, String TAG) {
        this.account = account;
        this.password = password;

        if (TAG.equals("app")) {
            init(login());
        } else if (TAG.equals("web")) {
            webInit(webLogin());
        }
    }

    public LessonInfoAgent lessonInfoAgent() {
        return (LessonInfoAgent) getAgent("lessonInfoAgent");
    }

    public CourseAgent courseAgent() {
        return (CourseAgent) getAgent("courseAgent");
    }

    public FullschAgent fullschAgent() {
        return (FullschAgent) getAgent("fullschAgent");
    }

    public VoteAgent voteAgent() {
        return (VoteAgent) getAgent("voteAgent");
    }

    public MobileAgent mobileAgent() {
        return (MobileAgent) getAgent("mobileAgent");
    }

    public CardAgent cardAgent() {
        return (CardAgent) getAgent("cardAgent");
    }


    public static JSONObject Login(String account, String password) {
        return Requests.getJson(mobileInterface.login(Parameter.creat()
                .add("account", account)
                .add("password", password)
                .add("phone", "")
                .add("verifycode", "")
                .add("loginMode", "")
                .add("machine", "")
                .add("proType", "ykdebug")
                .add("longitude", "")
                .add("latitude", "")
                .getMap()));
    }

    private void init(JSONObject object) {
        SampleAssert.assertEquals("登陆成功", object);
        this.object = object;
        token = object.getJSONObject("data").getString("token");
        userId = object.getJSONObject("data").getString("userId");
    }

    private void webInit(JSONObject object) {
        SampleAssert.assertEquals("登录成功!", object);
        this.object = object;
        token = object.getString("token");
        userId = object.getJSONObject("data").getString("userId");
    }

    @Step("用户登陆(手机/邮箱/用户名) app")
//    @Attachment("return")
    public JSONObject login() {
        return Requests.getJson(mobileInterface.login(Parameter.creat()
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
                .getMap()));
    }

    @Step("用户登陆(手机/邮箱/用户名) web")
//    @Attachment("return")
    public JSONObject webLogin() {
        return Requests.getJson(usrInterface.login(Parameter.creat()
                .add("userName", account)
                .add("password", password)
                .getMap()));
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
}
