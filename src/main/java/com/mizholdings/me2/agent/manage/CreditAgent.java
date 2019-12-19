package com.mizholdings.me2.agent.manage;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.util.*;
import io.qameta.allure.Step;

public class CreditAgent extends MODBase<CreditAgent> {

    public CreditAgent(User executor) {
        super(executor);
    }


    
    /**
     * 添加学分信息
     *
     * @return json
     */
    @Step("添加学分信息")
    public JSONObject addCreditInfo(Parameter parameter) {
        return exec("addCreditInfo", parameter);
    }
    
    /**
     * 根据用户查询学分
     *
     * @return json
     */
    @Step("根据用户查询学分")
    public JSONObject creditList(Parameter parameter) {
        return exec("creditList", parameter);
    }
    
    /**
     * 用户积分记录
     *
     * @return json
     */
    @Step("用户积分记录")
    public JSONObject userCredit(Parameter parameter) {
        return exec("userCredit", parameter);
    }
    
    /**
     * 获取用户学分信息
     *
     * @return json
     */
    @Step("获取用户学分信息")
    public JSONObject getCreditByUserId(Parameter parameter) {
        return exec("getCreditByUserId", parameter);
    }
    
    /**
     * 修改学分信息
     *
     * @return json
     */
    @Step("修改学分信息")
    public JSONObject editCreditInfo(Parameter parameter) {
        return exec("editCreditInfo", parameter);
    }
    
    /**
     * 修改积分
     *
     * @return json
     */
    @Step("修改积分")
    public JSONObject editUserCredit(Parameter parameter) {
        return exec("editUserCredit", parameter);
    }
    
    /**
     * 查询课程列表
     *
     * @return json
     */
    @Step("查询课程列表")
    public JSONObject creditLessonList(Parameter parameter) {
        return exec("creditLessonList", parameter);
    }
    
    /**
     * 学分资源列表
     *
     * @return json
     */
    @Step("学分资源列表")
    public JSONObject creditCourseList(Parameter parameter) {
        return exec("creditCourseList", parameter);
    }
    

}