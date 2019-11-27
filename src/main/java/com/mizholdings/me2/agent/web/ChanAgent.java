package com.mizholdings.me2.agent.web;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.GlobalMe2;
import com.mizholdings.me2.interfaces.mizhumanage.ChanInterface;
import com.mizholdings.me2.interfaces.mizhumanage.ChanadvInterface;
import com.mizholdings.util.MODBase;
import com.mizholdings.util.Parameter;
import com.mizholdings.util.Requests;
import com.mizholdings.util.User;
import io.qameta.allure.Step;

public class ChanAgent extends MODBase<ChanAgent> {


    public static ChanInterface chanInterface = Requests.getService(ChanInterface.class);

    public ChanAgent(User executor) {
        super(executor);
        interfaced = chanInterface;
    }

    @Step("渠道信息列表")
    public JSONObject list() {
        return exec("list", Parameter.creat()
                .add("currentPage", "1")
                .add("pageSize", "10"));
    }

    @Step("渠道信息新增")
    public JSONObject add(String chnName, String linkMan, String chnAir, String faceUrl) {
        return exec("add", Parameter.creat()
                .add("chnName", chnName)
                .add("linkMan", linkMan)
                .add("chnAir", chnAir)
                .add("remark", "1")
                .add("faceUrl", faceUrl));
    }

    public JSONObject add(String chnName, String linkMan, String chnAir) {
        return add(chnName, linkMan, chnAir, GlobalMe2.getImageUrl());
    }

    public JSONObject add(String chnName) {
        return add(chnName, "linkMan", "chnAir", GlobalMe2.getImageUrl());
    }

    @Step("渠道信息编辑")
    public JSONObject edit(String chnId, String chnName, String linkMan, String chnAir, String faceUrl) {
        return exec("edit", Parameter.creat()
                .add("chnId", chnId)
                .add("chnName", chnName)
                .add("linkMan", linkMan)
                .add("chnAir", chnAir)
                .add("remark", "1")
                .add("faceUrl", faceUrl));
    }

    public JSONObject edit(String chnId, String chnName, String linkMan, String chnAir) {
        return edit(chnId, chnName, linkMan, chnAir, GlobalMe2.getImageUrl());
    }

    public JSONObject edit(String chnId, String chnName) {
        return edit(chnId, chnName, "linkMan", "chnAir", GlobalMe2.getImageUrl());
    }

    @Step("渠道绑定群")
    public JSONObject banding(String chnId, String grpIds) {
        return exec("banding", Parameter.creat()
                .add("chnId", chnId).add("grpIds", grpIds));
    }

    @Step("渠道信息删除")
    public JSONObject del(String chnId) {
        return exec("del", Parameter.creat().add("chnId", chnId));
    }

    @Step("渠道信息详情")
    public JSONObject info(String chnId) {
        return exec("info", Parameter.creat().add("chnId", chnId));
    }

}
