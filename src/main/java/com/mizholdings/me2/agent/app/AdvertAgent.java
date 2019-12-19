package com.mizholdings.me2.agent.app;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.util.*;
import io.qameta.allure.Step;

public class AdvertAgent extends MODBase<AdvertAgent> {

    public AdvertAgent(User executor) {
        super(executor);
    }


    
    /**
     * 获取弹窗广告
     *
     * @return json
     */
    @Step("获取弹窗广告")
    public JSONObject getAlertAdvert(Parameter parameter) {
        return exec("getAlertAdvert", parameter);
    }
    

}