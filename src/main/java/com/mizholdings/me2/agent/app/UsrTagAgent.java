package com.mizholdings.me2.agent.app;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.util.*;
import io.qameta.allure.Step;

public class UsrTagAgent extends MODBase<UsrTagAgent> {

    public UsrTagAgent(User executor) {
        super(executor);
    }


    
    /**
     * 查询用户标签
     *
     * @return json
     */
    @Step("查询用户标签")
    public JSONObject list(Parameter parameter) {
        return exec("list", parameter);
    }
    
    /**
     * 添加用户标签
     *
     * @return json
     */
    @Step("添加用户标签")
    public JSONObject addUsrTag(Parameter parameter) {
        return exec("addUsrTag", parameter);
    }
    

}