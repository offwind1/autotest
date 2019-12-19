package com.mizholdings.me2.agent.web;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.util.*;
import io.qameta.allure.Step;

public class GradeAgent extends MODBase<GradeAgent> {

    public GradeAgent(User executor) {
        super(executor);
    }


    
    /**
     * 年级列表，分页查询
     *
     * @return json
     */
    @Step("年级列表，分页查询")
    public JSONObject list(Parameter parameter) {
        return exec("list", parameter);
    }
    
    /**
     * 查询所有年级
     *
     * @return json
     */
    @Step("查询所有年级")
    public JSONObject allList(Parameter parameter) {
        return exec("allList", parameter);
    }
    
    /**
     * 添加班级
     *
     * @return json
     */
    @Step("添加班级")
    public JSONObject addClass(Parameter parameter) {
        return exec("addClass", parameter);
    }
    
    /**
     * 班级列表
     *
     * @return json
     */
    @Step("班级列表")
    public JSONObject classList(Parameter parameter) {
        return exec("classList", parameter);
    }
    
    /**
     * 编辑班级
     *
     * @return json
     */
    @Step("编辑班级")
    public JSONObject editClass(Parameter parameter) {
        return exec("editClass", parameter);
    }
    
    /**
     * 删除班级
     *
     * @return json
     */
    @Step("删除班级")
    public JSONObject delClass(Parameter parameter) {
        return exec("delClass", parameter);
    }
    
    /**
     * 查看班级中的学生
     *
     * @return json
     */
    @Step("查看班级中的学生")
    public JSONObject userByStuId(Parameter parameter) {
        return exec("userByStuId", parameter);
    }
    
    /**
     * 从年级中删除学生
     *
     * @return json
     */
    @Step("从年级中删除学生")
    public JSONObject delStudent(Parameter parameter) {
        return exec("delStudent", parameter);
    }
    

}