package com.mizholdings.me2.agent.web;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.util.*;
import io.qameta.allure.Step;

public class CourseTypeAgent extends MODBase<OrgInfoAgent> {



    public CourseTypeAgent(User executor) {
        super(executor);
    }

    /**
     * 资源类型分类
     *
     * @return json
     */
    @Step("资源类型分类")
    public JSONObject list() {
        return exec("list", Parameter.creat());
    }



}
