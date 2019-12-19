package com.mizholdings.me2.agent.web;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.util.*;
import io.qameta.allure.Step;

public class TtiaoAgent extends MODBase<TtiaoAgent> {

    public TtiaoAgent(User executor) {
        super(executor);
    }


    
    /**
     * 获取课程价格
     *
     * @return json
     */
    @Step("获取课程价格")
    public JSONObject getLesson(Parameter parameter) {
        return exec("getLesson", parameter);
    }
    
    /**
     * 开始报名
     *
     * @return json
     */
    @Step("开始报名")
    public JSONObject enroll(Parameter parameter) {
        return exec("enroll", parameter);
    }
    
    /**
     * 查询订单支付状态
     *
     * @return json
     */
    @Step("查询订单支付状态")
    public JSONObject orderStatus(Parameter parameter) {
        return exec("orderStatus", parameter);
    }
    

}