package com.mizholdings.me2.agent.app;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.util.*;
import io.qameta.allure.Step;

public class CompartmentAgent extends MODBase<CompartmentAgent> {

    public CompartmentAgent(User executor) {
        super(executor);
    }


    
    /**
     * 查询所有省和地市
     *
     * @return json
     */
    @Step("查询所有省和地市")
    public JSONObject alllist(Parameter parameter) {
        return exec("alllist", parameter);
    }
    
    /**
     * 查询省市列表
     *
     * @return json
     */
    @Step("查询省市列表")
    public JSONObject list(Parameter parameter) {
        return exec("list", parameter);
    }
    

}