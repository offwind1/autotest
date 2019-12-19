package com.mizholdings.me2.agent.web;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.util.*;
import io.qameta.allure.Step;

public class AgentAgent extends MODBase<AgentAgent> {

    public AgentAgent(User executor) {
        super(executor);
    }


    
    /**
     * 代理商充值查询
     *
     * @return json
     */
    @Step("代理商充值查询")
    public JSONObject recordList(Parameter parameter) {
        return exec("recordList", parameter);
    }
    
    /**
     * 查询代理商信息
     *
     * @return json
     */
    @Step("查询代理商信息")
    public JSONObject getAgentInfoById(Parameter parameter) {
        return exec("getAgentInfoById", parameter);
    }
    
    /**
     * 根据账号查询代理商下的用户
     *
     * @return json
     */
    @Step("根据账号查询代理商下的用户")
    public JSONObject getAgentUserByaAccount(Parameter parameter) {
        return exec("getAgentUserByaAccount", parameter);
    }
    
    /**
     * 代理商给用户充值
     *
     * @return json
     */
    @Step("代理商给用户充值")
    public JSONObject rechargeToUser(Parameter parameter) {
        return exec("rechargeToUser", parameter);
    }
    
    /**
     * 获取ping++支付凭证
     *
     * @return json
     */
    @Step("获取ping++支付凭证")
    public JSONObject getPingxx(Parameter parameter) {
        return exec("getPingxx", parameter);
    }
    
    /**
     * 轮训检查充值结果
     *
     * @return json
     */
    @Step("轮训检查充值结果")
    public JSONObject getRechargeResult(Parameter parameter) {
        return exec("getRechargeResult", parameter);
    }
    
    /**
     * 修改代理商信息
     *
     * @return json
     */
    @Step("修改代理商信息")
    public JSONObject edit(Parameter parameter) {
        return exec("edit", parameter);
    }
    
    /**
     * 检验代理商原密码是否正确
     *
     * @return json
     */
    @Step("检验代理商原密码是否正确")
    public JSONObject checkPassword(Parameter parameter) {
        return exec("checkPassword", parameter);
    }
    
    /**
     * 代理商管理
     *
     * @return json
     */
    @Step("代理商管理")
    public JSONObject agentList(Parameter parameter) {
        return exec("agentList", parameter);
    }
    
    /**
     * 新增代理商
     *
     * @return json
     */
    @Step("新增代理商")
    public JSONObject addAgentUser(Parameter parameter) {
        return exec("addAgentUser", parameter);
    }
    
    /**
     * 检验代理商信息重复
     *
     * @return json
     */
    @Step("检验代理商信息重复")
    public JSONObject checkAgent(Parameter parameter) {
        return exec("checkAgent", parameter);
    }
    
    /**
     * 根据代理商id获取代理商信息
     *
     * @return json
     */
    @Step("根据代理商id获取代理商信息")
    public JSONObject getAgentUserById(Parameter parameter) {
        return exec("getAgentUserById", parameter);
    }
    
    /**
     * 修改代理商密码
     *
     * @return json
     */
    @Step("修改代理商密码")
    public JSONObject changePassword(Parameter parameter) {
        return exec("changePassword", parameter);
    }
    
    /**
     * 查看代理商下的用户
     *
     * @return json
     */
    @Step("查看代理商下的用户")
    public JSONObject agentUserList(Parameter parameter) {
        return exec("agentUserList", parameter);
    }
    
    /**
     * 删除代理商
     *
     * @return json
     */
    @Step("删除代理商")
    public JSONObject deleteAgentUser(Parameter parameter) {
        return exec("deleteAgentUser", parameter);
    }
    
    /**
     * 修改代理商账户
     *
     * @return json
     */
    @Step("修改代理商账户")
    public JSONObject editAgentBank(Parameter parameter) {
        return exec("editAgentBank", parameter);
    }

    /**
     * 代理商提现
     *
     * @return json
     */
    @Step("代理商提现")
    public JSONObject agentDrawcash(Parameter parameter) {
        return exec("agentDrawcash", parameter);
    }
    
    /**
     * 获取代理商折扣区间
     *
     * @return json
     */
    @Step("获取代理商折扣区间")
    public JSONObject getAgentDiscountById(Parameter parameter) {
        return exec("getAgentDiscountById", parameter);
    }
    

}