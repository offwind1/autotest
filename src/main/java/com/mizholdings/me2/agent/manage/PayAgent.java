package com.mizholdings.me2.agent.manage;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.util.*;
import io.qameta.allure.Step;

public class PayAgent extends MODBase<PayAgent> {

    public PayAgent(User executor) {
        super(executor);
    }


    
    /**
     * 网页JSAPI支付
     *
     * @return json
     */
    @Step("网页JSAPI支付")
    public JSONObject buyLessonUseJSAPI(Parameter parameter) {
        return exec("buyLessonUseJSAPI", parameter);
    }
    
    /**
     * 获取网页微信用户信息
     *
     * @return json
     */
    @Step("获取网页微信用户信息")
    public JSONObject webWxGetUserInfo(Parameter parameter) {
        return exec("webWxGetUserInfo", parameter);
    }
    
    /**
     * 微信H5充值
     *
     * @return json
     */
    @Step("微信H5充值")
    public JSONObject wxpayH5(Parameter parameter) {
        return exec("wxpayH5", parameter);
    }
    

}