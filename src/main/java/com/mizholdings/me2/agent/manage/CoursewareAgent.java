package com.mizholdings.me2.agent.manage;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.util.*;
import io.qameta.allure.Step;

public class CoursewareAgent extends MODBase<CoursewareAgent> {

    public CoursewareAgent(User executor) {
        super(executor);
    }


    
    /**
     * 转让课件
     *
     * @return json
     */
    @Step("转让课件")
    public JSONObject transferCourseware(Parameter parameter) {
        return exec("transferCourseware", parameter);
    }
    

}