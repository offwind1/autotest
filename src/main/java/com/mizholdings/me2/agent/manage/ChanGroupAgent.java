package com.mizholdings.me2.agent.manage;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.GlobalMe2;
import com.mizholdings.util.Common;
import com.mizholdings.util.MODBase;
import com.mizholdings.util.Parameter;
import com.mizholdings.util.User;
import io.qameta.allure.Step;

//import com.mizholdings.me2.interfaces.mizhumanage.ChangroupInterface;

public class ChanGroupAgent extends MODBase<ChanGroupAgent> {

//
//    public static ChangroupInterface changroupInterface = Requests.getService(ChangroupInterface.class);

    public ChanGroupAgent(User executor) {
        super(executor);
//        interfaced = changroupInterface;
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


    /**
     * 渠道群管理
     *
     * @return json
     */
    @Step("渠道群管理")
    public JSONObject list(Parameter parameter) {
        return exec("list", parameter);
    }

    /**
     * 渠道群添加
     *
     * @return json
     */
    @Step("渠道群添加")
    public JSONObject add(Parameter parameter) {
        return exec("add", parameter);
    }

    /**
     * 渠道群编辑
     *
     * @return json
     */
    @Step("渠道群编辑")
    public JSONObject edit(Parameter parameter) {
        return exec("edit", parameter);
    }

    /**
     * 渠道群删除
     *
     * @return json
     */
    @Step("渠道群删除")
    public JSONObject del(Parameter parameter) {
        return exec("del", parameter);
    }


}
