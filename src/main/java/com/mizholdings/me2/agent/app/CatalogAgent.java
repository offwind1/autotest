package com.mizholdings.me2.agent.app;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.util.*;
import io.qameta.allure.Step;

public class CatalogAgent extends MODBase<CatalogAgent> {

    public CatalogAgent(User executor) {
        super(executor);
    }


    
    /**
     * 查询用户的试题
     *
     * @return json
     */
    @Step("查询用户的试题")
    public JSONObject list(Parameter parameter) {
        return exec("list", parameter);
    }
    
    /**
     * 根据试题ID查询题目
     *
     * @return json
     */
    @Step("根据试题ID查询题目")
    public JSONObject quesByCatalogId(Parameter parameter) {
        return exec("quesByCatalogId", parameter);
    }
    

}