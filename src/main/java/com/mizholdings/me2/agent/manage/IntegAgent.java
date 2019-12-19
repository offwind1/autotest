package com.mizholdings.me2.agent.manage;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.util.*;
import io.qameta.allure.Step;

public class IntegAgent extends MODBase<IntegAgent> {

    public IntegAgent(User executor) {
        super(executor);
    }


    
    /**
     * 查询积分规则列表
     *
     * @return json
     */
    @Step("查询积分规则列表")
    public JSONObject integList(Parameter parameter) {
        return exec("integList", parameter);
    }
    
    /**
     * 新增积分规则
     *
     * @return json
     */
    @Step("新增积分规则")
    public JSONObject add(Parameter parameter) {
        return exec("add", parameter);
    }
    
    /**
     * 根据积分规则id查询积分规则信息
     *
     * @return json
     */
    @Step("根据积分规则id查询积分规则信息")
    public JSONObject getIntegById(Parameter parameter) {
        return exec("getIntegById", parameter);
    }
    
    /**
     * 修改积分规则
     *
     * @return json
     */
    @Step("修改积分规则")
    public JSONObject editIntegRule(Parameter parameter) {
        return exec("editIntegRule", parameter);
    }
    
    /**
     * 删除积分规则
     *
     * @return json
     */
    @Step("删除积分规则")
    public JSONObject delIntegRule(Parameter parameter) {
        return exec("delIntegRule", parameter);
    }
    
    /**
     * 用户积分查询
     *
     * @return json
     */
    @Step("用户积分查询")
    public JSONObject userIntegList(Parameter parameter) {
        return exec("userIntegList", parameter);
    }
    
    /**
     * 修改用户积分
     *
     * @return json
     */
    @Step("修改用户积分")
    public JSONObject editInteg(Parameter parameter) {
        return exec("editInteg", parameter);
    }
    

}