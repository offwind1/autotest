package com.mizholdings.me2.agent.manage;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.Global;
import com.mizholdings.util.MODBase;
import com.mizholdings.util.Parameter;
import com.mizholdings.util.User;
import io.qameta.allure.Step;

public class ChanAgent extends MODBase<ChanAgent> {


//    public static ChanInterface chanInterface = Requests.getService(ChanInterface.class);

    public ChanAgent(User executor) {
        super(executor);
//        interfaced = chanInterface;
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
        return add(chnName, linkMan, chnAir, Global.getImageUrl());
    }

    public JSONObject add(String chnName) {
        return add(chnName, "linkMan", "chnAir", Global.getImageUrl());
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
        return edit(chnId, chnName, linkMan, chnAir, Global.getImageUrl());
    }

    public JSONObject edit(String chnId, String chnName) {
        return edit(chnId, chnName, "linkMan", "chnAir", Global.getImageUrl());
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

    /**
     * 渠道信息列表
     *
     * @return json
     */
    @Step("渠道信息列表")
    public JSONObject list(Parameter parameter) {
        return exec("list", parameter);
    }

    /**
     * 渠道信息新增
     *
     * @return json
     */
    @Step("渠道信息新增")
    public JSONObject add(Parameter parameter) {
        return exec("add", parameter);
    }

    /**
     * 渠道信息编辑
     *
     * @return json
     */
    @Step("渠道信息编辑")
    public JSONObject edit(Parameter parameter) {
        return exec("edit", parameter);
    }

    /**
     * 渠道信息删除
     *
     * @return json
     */
    @Step("渠道信息删除")
    public JSONObject del(Parameter parameter) {
        return exec("del", parameter);
    }

    /**
     * 渠道信息详情
     *
     * @return json
     */
    @Step("渠道信息详情")
    public JSONObject info(Parameter parameter) {
        return exec("info", parameter);
    }

    /**
     * 渠道绑定群
     *
     * @return json
     */
    @Step("渠道绑定群")
    public JSONObject banding(Parameter parameter) {
        return exec("banding", parameter);
    }

    /**
     * 用户通过渠道扫码进群
     *
     * @return json
     */
    @Step("用户通过渠道扫码进群")
    public JSONObject usrClick(Parameter parameter) {
        return exec("usrClick", parameter);
    }

}
