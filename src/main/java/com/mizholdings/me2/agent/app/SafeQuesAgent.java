package com.mizholdings.me2.agent.app;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.util.*;
import io.qameta.allure.Step;

public class SafeQuesAgent extends MODBase<SafeQuesAgent> {

    public SafeQuesAgent(User executor) {
        super(executor);
    }


    
    /**
     * 安全问题列表
     *
     * @return json
     */
    @Step("安全问题列表")
    public JSONObject list(Parameter parameter) {
        return exec("list", parameter);
    }
    

}