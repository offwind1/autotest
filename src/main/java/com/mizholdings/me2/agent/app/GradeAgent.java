package com.mizholdings.me2.agent.app;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.util.*;
import io.qameta.allure.Step;

public class GradeAgent extends MODBase<GradeAgent> {

    public GradeAgent(User executor) {
        super(executor);
    }


    
    /**
     * 查询年级列表
     *
     * @return json
     */
    @Step("查询年级列表")
    public JSONObject list(Parameter parameter) {
        return exec("list", parameter);
    }
    
    /**
     * 查询年级列表(标签类型)
     *
     * @return json
     */
    @Step("查询年级列表(标签类型)")
    public JSONObject taglist(Parameter parameter) {
        return exec("taglist", parameter);
    }
    
    /**
     * 年级列表（绑定学科）
     *
     * @return json
     */
    @Step("年级列表（绑定学科）")
    public JSONObject gradelist(Parameter parameter) {
        return exec("gradelist", parameter);
    }
    
    /**
     * 根据机构ID查询年级和学科列表
     *
     * @return json
     */
    @Step("根据机构ID查询年级和学科列表")
    public JSONObject listByOrgId(Parameter parameter) {
        return exec("listByOrgId", parameter);
    }
    

}