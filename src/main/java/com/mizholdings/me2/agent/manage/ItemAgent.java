package com.mizholdings.me2.agent.manage;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.util.*;
import io.qameta.allure.Step;

public class ItemAgent extends MODBase<ItemAgent> {

    public ItemAgent(User executor) {
        super(executor);
    }


    
    /**
     * 查询收费列表
     *
     * @return json
     */
    @Step("查询收费列表")
    public JSONObject list(Parameter parameter) {
        return exec("list", parameter);
    }
    
    /**
     * 添加收款项目
     *
     * @return json
     */
    @Step("添加收款项目")
    public JSONObject add(Parameter parameter) {
        return exec("add", parameter);
    }
    
    /**
     * 修改收款项目
     *
     * @return json
     */
    @Step("修改收款项目")
    public JSONObject update(Parameter parameter) {
        return exec("update", parameter);
    }
    
    /**
     * 查询收款项目信息
     *
     * @return json
     */
    @Step("查询收款项目信息")
    public JSONObject getById(Parameter parameter) {
        return exec("getById", parameter);
    }
    
    /**
     * 删除收款项目
     *
     * @return json
     */
    @Step("删除收款项目")
    public JSONObject delete(Parameter parameter) {
        return exec("delete", parameter);
    }
    

}