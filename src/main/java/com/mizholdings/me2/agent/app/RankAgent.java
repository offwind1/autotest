package com.mizholdings.me2.agent.app;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.util.*;
import io.qameta.allure.Step;

public class RankAgent extends MODBase<RankAgent> {

    public RankAgent(User executor) {
        super(executor);
    }


    
    /**
     * 名师，前三名
     *
     * @return json
     */
    @Step("名师，前三名")
    public JSONObject teacherTop(Parameter parameter) {
        return exec("teacherTop", parameter);
    }
    
    /**
     * 名师排行
     *
     * @return json
     */
    @Step("名师排行")
    public JSONObject teacherList(Parameter parameter) {
        return exec("teacherList", parameter);
    }
    
    /**
     * 课程，排行
     *
     * @return json
     */
    @Step("课程，排行")
    public JSONObject lessonList(Parameter parameter) {
        return exec("lessonList", parameter);
    }
    
    /**
     * 机构，排行
     *
     * @return json
     */
    @Step("机构，排行")
    public JSONObject orgList(Parameter parameter) {
        return exec("orgList", parameter);
    }
    
    /**
     * 查询明星老师的预约课
     *
     * @return json
     */
    @Step("查询明星老师的预约课")
    public JSONObject bespeak(Parameter parameter) {
        return exec("bespeak", parameter);
    }
    
    /**
     * 学习之星
     *
     * @return json
     */
    @Step("学习之星")
    public JSONObject studyStar(Parameter parameter) {
        return exec("studyStar", parameter);
    }
    

}