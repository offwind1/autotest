package com.mizholdings.me2.agent.app;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.util.*;
import io.qameta.allure.Step;

public class HeadImgAgent extends MODBase<HeadImgAgent> {

    public HeadImgAgent(User executor) {
        super(executor);
    }


    
    /**
     * 头像列表
     *
     * @return json
     */
    @Step("头像列表")
    public JSONObject list(Parameter parameter) {
        return exec("list", parameter);
    }
    

}