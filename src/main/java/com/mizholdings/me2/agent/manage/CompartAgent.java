package com.mizholdings.me2.agent.manage;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.util.*;
import io.qameta.allure.Step;

public class CompartAgent extends MODBase<CompartAgent> {

    public CompartAgent(User executor) {
        super(executor);
    }


    
    /**
     * 省市列表
     *
     * @return json
     */
    @Step("省市列表")
    public JSONObject list(Parameter parameter) {
        return exec("list", parameter);
    }
    

}