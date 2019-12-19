package com.mizholdings.me2.agent.app;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.util.*;
import io.qameta.allure.Step;

/**
 * 积分
 */
public class IntegAgent extends MODBase<IntegAgent> {

//    public static IntegInterface integInterface = Requests.getService(IntegInterface.class);

    public IntegAgent(User executor) {
        super(executor);
//        interfaced = integInterface;
    }

    /**
     * 积分增加(课堂举手，老师同意时调用)
     *
     * @param cloudUsrAccount 云信accid
     * @return
     */
    public JSONObject execute(String cloudUsrAccount) {
        return exec("execute", Parameter.creat()
                .add("cloudUsrAccount", cloudUsrAccount));
    }

    /**
     * 课堂中第一次文字、图片互动
     *
     * @param cloudUsrAccount 云信accid
     * @return
     */
    public JSONObject words(String cloudUsrAccount) {
        return exec("words", Parameter.creat().add("cloudUsrAccount", cloudUsrAccount));
    }


    /**
     * 积分增加(课堂举手，老师同意时调用)
     *
     * @return json
     */
    @Step("积分增加(课堂举手，老师同意时调用)")
    public JSONObject execute(Parameter parameter) {
        return exec("execute", parameter);
    }

    /**
     * 课堂中第一次文字、图片互动
     *
     * @return json
     */
    @Step("课堂中第一次文字、图片互动")
    public JSONObject words(Parameter parameter) {
        return exec("words", parameter);
    }



}
