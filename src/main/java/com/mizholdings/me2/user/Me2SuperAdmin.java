package com.mizholdings.me2.user;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.user.serve.Manage;
import com.mizholdings.me2.user.serveInterface.manageInterface;
import com.mizholdings.util.*;
import com.mizholdings.util.requests.Request;
import io.qameta.allure.Step;

public class Me2SuperAdmin extends User implements manageInterface {
    protected Manage manage;

    public Me2SuperAdmin(String account, String password) {
        webInit(webLogin(account, password));
        manage = new Manage(this);
    }

    public Manage getManage() {
        return manage;
    }

    private void webInit(JSONObject object) {
        SampleAssert.assertEquals("登录成功!", object);
        token = object.getString("token");
    }

    @Step("管理员登录")
    public JSONObject webLogin(String account, String password) {
        return Request.go("manage", "usr", "manageLogin",
                Parameter.creat().add("userName", account).add("password", password).getObjectMap()
        ).json();
    }

    public String newChanGroup() {
        String grpName = Common.creatRandomString();
        manage.chanGroupAgent().add(grpName);
        JSONObject object = manage.chanGroupAgent().list();
        object = Common.filder(object.getJSONObject("data").getJSONArray("list"), grpName, "grpName");
        return object.getString("grpId");
    }

    public String newChan() {
        String chnName = Common.creatRandomString();
        manage.chanAgent().add(chnName);

        JSONObject object = manage.chanAgent().list();
        object = Common.filder(object.getJSONObject("data").getJSONArray("list"), chnName, "chnName");
        return object.getString("chnId");
    }
}
