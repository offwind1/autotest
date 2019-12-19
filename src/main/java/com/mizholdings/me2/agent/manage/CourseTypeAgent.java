package com.mizholdings.me2.agent.manage;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.util.*;
import io.qameta.allure.Step;

public class CourseTypeAgent extends MODBase<CourseTypeAgent> {

    public CourseTypeAgent(User executor) {
        super(executor);
    }


    
    /**
     * 资源类型分类
     *
     * @return json
     */
    @Step("资源类型分类")
    public JSONObject list(Parameter parameter) {
        return exec("list", parameter);
    }
    

}