package com.mizholdings.me2.agent.app;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.util.*;
import io.qameta.allure.Step;

public class OrgAgent extends MODBase<OrgAgent> {

    public OrgAgent(User executor) {
        super(executor);
    }


    
    /**
     * 查询机构/学校列表
     *
     * @return json
     */
    @Step("查询机构/学校列表")
    public JSONObject list(Parameter parameter) {
        return exec("list", parameter);
    }
    
    /**
     * 获取机构新闻
     *
     * @return json
     */
    @Step("获取机构新闻")
    public JSONObject msglist(Parameter parameter) {
        return exec("msglist", parameter);
    }
    
    /**
     * 新闻详情
     *
     * @return json
     */
    @Step("新闻详情")
    public JSONObject msgInfo(Parameter parameter) {
        return exec("msgInfo", parameter);
    }
    
    /**
     * 用户同意加入机构
     *
     * @return json
     */
    @Step("用户同意加入机构")
    public JSONObject joinOrg(Parameter parameter) {
        return exec("joinOrg", parameter);
    }
    
    /**
     * 添加机构
     *
     * @return json
     */
    @Step("添加机构")
    public JSONObject create(Parameter parameter) {
        return exec("create", parameter);
    }
    
    /**
     * 已经加入的机构列表
     *
     * @return json
     */
    @Step("已经加入的机构列表")
    public JSONObject joinList(Parameter parameter) {
        return exec("joinList", parameter);
    }
    
    /**
     * 退出机构
     *
     * @return json
     */
    @Step("退出机构")
    public JSONObject removeOrg(Parameter parameter) {
        return exec("removeOrg", parameter);
    }
    
    /**
     * 禁止添加
     *
     * @return json
     */
    @Step("禁止添加")
    public JSONObject disabled(Parameter parameter) {
        return exec("disabled", parameter);
    }
    

}