package com.mizholdings.me2.agent.app;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.util.*;
import io.qameta.allure.Step;

public class UsrCollAgent extends MODBase<UsrCollAgent> {

    public UsrCollAgent(User executor) {
        super(executor);
    }


    
    /**
     * 用户收藏列表
     *
     * @return json
     */
    @Step("用户收藏列表")
    public JSONObject list(Parameter parameter) {
        return exec("list", parameter);
    }
    

}