package com.mizholdings.me2.agent.app;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.util.*;
import io.qameta.allure.Step;

public class LebuAgent extends MODBase<LebuAgent> {

    public LebuAgent(User executor) {
        super(executor);
    }


    
    /**
     * url免密登陆通用接口
     *
     * @return json
     */
    @Step("url免密登陆通用接口")
    public JSONObject autoLogin(Parameter parameter) {
        return exec("autoLogin", parameter);
    }
    

}