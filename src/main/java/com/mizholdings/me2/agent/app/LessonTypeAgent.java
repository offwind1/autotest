package com.mizholdings.me2.agent.app;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.util.*;
import io.qameta.allure.Step;

public class LessonTypeAgent extends MODBase<LessonTypeAgent> {

    public LessonTypeAgent(User executor) {
        super(executor);
    }


    
    /**
     * 查询学科列表
     *
     * @return json
     */
    @Step("查询学科列表")
    public JSONObject list(Parameter parameter) {
        return exec("list", parameter);
    }
    
    /**
     * 查询用户选择的学科列表
     *
     * @return json
     */
    @Step("查询用户选择的学科列表")
    public JSONObject userlist(Parameter parameter) {
        return exec("userlist", parameter);
    }
    
    /**
     * 学科编辑保存
     *
     * @return json
     */
    @Step("学科编辑保存")
    public JSONObject savelist(Parameter parameter) {
        return exec("savelist", parameter);
    }
    

}