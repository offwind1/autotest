package com.mizholdings.me2.agent.web;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.GlobalMe2;
import com.mizholdings.me2.interfaces.mizhumanage.ChangroupInterface;
import com.mizholdings.util.*;
import io.qameta.allure.Step;

public class ChanGroupAgent extends MODBase<ChanGroupAgent> {


    public static ChangroupInterface changroupInterface = Requests.getService(ChangroupInterface.class);

    public ChanGroupAgent(User executor) {
        super(executor);
        interfaced = changroupInterface;
    }


    @Step("渠道群管理")
    public JSONObject list() {
        return exec("list", Parameter.creat().add("pageSize", "10").add("currentPage", "1"));
    }

    @Step("渠道群添加")
    public JSONObject add(String grpName, String grpType, String codeUrl) {
        return exec("add", Parameter.creat()
                .add("grpName", grpName)
                .add("grpType", grpType)
                .add("codeTime", Common.getNowTime())
                .add("codeUrl", codeUrl));
    }

    public JSONObject add(String grpName, String grpType) {
        return add(grpName, grpType, GlobalMe2.getImageUrl());
    }

    public JSONObject add(String grpName) {
        return add(grpName, "分类");
    }

    @Step("渠道群编辑")
    public JSONObject edit(String grpId, String grpName, String grpType, String codeUrl) {
        return exec("add", Parameter.creat()
                .add("grpId", grpId)
                .add("grpName", grpName)
                .add("grpType", grpType)
                .add("codeTime", Common.getNowTime())
                .add("codeUrl", codeUrl));
    }

    public JSONObject edit(String grpId, String grpName, String grpType) {
        return edit(grpId, grpName, grpType, GlobalMe2.getImageUrl());
    }

    public JSONObject edit(String grpId, String grpName) {
        return edit(grpId, grpName, "分类2", GlobalMe2.getImageUrl());
    }

    @Step("渠道群删除chanGroup/del")
    public JSONObject del(String grpId) {
        return exec("del", Parameter.creat().add("grpId", grpId));
    }

}
