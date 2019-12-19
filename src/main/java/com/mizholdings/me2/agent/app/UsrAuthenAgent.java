package com.mizholdings.me2.agent.app;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.util.*;
import io.qameta.allure.Step;

public class UsrAuthenAgent extends MODBase<UsrAuthenAgent> {

    public UsrAuthenAgent(User executor) {
        super(executor);
    }


    
    /**
     * 用户认证
     *
     * @return json
     */
    @Step("用户认证")
    public JSONObject addAuthen(Parameter parameter) {
        return exec("addAuthen", parameter);
    }
    
    /**
     * 查询用户认证列表
     *
     * @return json
     */
    @Step("查询用户认证列表")
    public JSONObject list(Parameter parameter) {
        return exec("list", parameter);
    }
    

}