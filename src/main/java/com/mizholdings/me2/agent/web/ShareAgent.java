package com.mizholdings.me2.agent.web;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.util.*;
import io.qameta.allure.Step;

public class ShareAgent extends MODBase<ShareAgent> {

    public ShareAgent(User executor) {
        super(executor);
    }


    
    /**
     * 分享资源
     *
     * @return json
     */
    @Step("分享资源")
    public JSONObject course(Parameter parameter) {
        return exec("course", parameter);
    }
    
    /**
     * 机构分享
     *
     * @return json
     */
    @Step("机构分享")
    public JSONObject org(Parameter parameter) {
        return exec("org", parameter);
    }
    
    /**
     * 课程分享
     *
     * @return json
     */
    @Step("课程分享")
    public JSONObject lesson(Parameter parameter) {
        return exec("lesson", parameter);
    }
    
    /**
     * 分享教师
     *
     * @return json
     */
    @Step("分享教师")
    public JSONObject teacher(Parameter parameter) {
        return exec("teacher", parameter);
    }
    

}