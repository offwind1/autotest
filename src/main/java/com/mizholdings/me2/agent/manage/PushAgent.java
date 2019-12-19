package com.mizholdings.me2.agent.manage;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.util.*;
import io.qameta.allure.Step;

public class PushAgent extends MODBase<PushAgent> {

    public PushAgent(User executor) {
        super(executor);
    }


    
    /**
     * 查询标签列表
     *
     * @return json
     */
    @Step("查询标签列表")
    public JSONObject tagList(Parameter parameter) {
        return exec("tagList", parameter);
    }
    
    /**
     * 添加标签
     *
     * @return json
     */
    @Step("添加标签")
    public JSONObject addTag(Parameter parameter) {
        return exec("addTag", parameter);
    }
    
    /**
     * 根据id查询标签详情
     *
     * @return json
     */
    @Step("根据id查询标签详情")
    public JSONObject getTagById(Parameter parameter) {
        return exec("getTagById", parameter);
    }
    
    /**
     * 修改标签信息
     *
     * @return json
     */
    @Step("修改标签信息")
    public JSONObject edit(Parameter parameter) {
        return exec("edit", parameter);
    }
    
    /**
     * 删除标签
     *
     * @return json
     */
    @Step("删除标签")
    public JSONObject deleteById(Parameter parameter) {
        return exec("deleteById", parameter);
    }
    
    /**
     * 推送列表
     *
     * @return json
     */
    @Step("推送列表")
    public JSONObject pushList(Parameter parameter) {
        return exec("pushList", parameter);
    }
    
    /**
     * 新增推送
     *
     * @return json
     */
    @Step("新增推送")
    public JSONObject addPush(Parameter parameter) {
        return exec("addPush", parameter);
    }
    
    /**
     * 审批推送
     *
     * @return json
     */
    @Step("审批推送")
    public JSONObject applyPush(Parameter parameter) {
        return exec("applyPush", parameter);
    }
    
    /**
     * 删除推送
     *
     * @return json
     */
    @Step("删除推送")
    public JSONObject deletePush(Parameter parameter) {
        return exec("deletePush", parameter);
    }
    
    /**
     * 根据推送id获取推送信息
     *
     * @return json
     */
    @Step("根据推送id获取推送信息")
    public JSONObject getPushById(Parameter parameter) {
        return exec("getPushById", parameter);
    }
    
    /**
     * 推送消息
     *
     * @return json
     */
    @Step("推送消息")
    public JSONObject pushMessage(Parameter parameter) {
        return exec("pushMessage", parameter);
    }
    

}