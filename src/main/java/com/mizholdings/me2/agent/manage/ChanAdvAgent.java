package com.mizholdings.me2.agent.manage;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.util.MODBase;
import com.mizholdings.util.Parameter;
import com.mizholdings.util.User;
import io.qameta.allure.Step;

public class ChanAdvAgent extends MODBase<ChanAdvAgent> {



    public ChanAdvAgent(User executor) {
        super(executor);
    }

    /**
     * 渠道广告列表
     *
     * @return json
     */
    @Step("渠道广告列表")
    public JSONObject list(Parameter parameter) {
        return exec("list", parameter);
    }

    /**
     * 添加新广告
     *
     * @return json
     */
    @Step("添加新广告")
    public JSONObject add(Parameter parameter) {
        return exec("add", parameter);
    }

    /**
     * 广告编辑
     *
     * @return json
     */
    @Step("广告编辑")
    public JSONObject edit(Parameter parameter) {
        return exec("edit", parameter);
    }

    /**
     * 广告删除
     *
     * @return json
     */
    @Step("广告删除")
    public JSONObject del(Parameter parameter) {
        return exec("del", parameter);
    }

}
