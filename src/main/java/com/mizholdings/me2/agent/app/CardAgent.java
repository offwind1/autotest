package com.mizholdings.me2.agent.app;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.util.MODBase;
import com.mizholdings.util.Parameter;
import com.mizholdings.util.User;
import io.qameta.allure.Step;

public class CardAgent extends MODBase<CardAgent> {
    public CardAgent(User executor) {
        super(executor);
    }


    /**
     * 试听卡兑换
     *
     * @return json
     */
    @Step("试听卡兑换")
    public JSONObject exchange(Parameter parameter) {
        return exec("exchange", parameter);
    }



}