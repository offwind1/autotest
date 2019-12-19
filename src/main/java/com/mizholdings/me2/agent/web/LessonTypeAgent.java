package com.mizholdings.me2.agent.web;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.util.*;
import io.qameta.allure.Step;

public class LessonTypeAgent extends MODBase<LessonTypeAgent> {

    public LessonTypeAgent(User executor) {
        super(executor);
    }


    
    /**
     * 查询学科分类
     *
     * @return json
     */
    @Step("查询学科分类")
    public JSONObject list(Parameter parameter) {
        return exec("list", parameter);
    }
    

}