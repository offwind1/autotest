package com.mizholdings.me2.agent.manage;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.util.*;
import io.qameta.allure.Step;

public class ShoppingAgent extends MODBase<ShoppingAgent> {

    public ShoppingAgent(User executor) {
        super(executor);
    }


    
    /**
     * 商品加入购物车
     *
     * @return json
     */
    @Step("商品加入购物车")
    public JSONObject add(Parameter parameter) {
        return exec("add", parameter);
    }
    
    /**
     * 查询购物车列表
     *
     * @return json
     */
    @Step("查询购物车列表")
    public JSONObject list(Parameter parameter) {
        return exec("list", parameter);
    }
    
    /**
     * 删除商品
     *
     * @return json
     */
    @Step("删除商品")
    public JSONObject delete(Parameter parameter) {
        return exec("delete", parameter);
    }
    
    /**
     * 清空购物车
     *
     * @return json
     */
    @Step("清空购物车")
    public JSONObject deleteAll(Parameter parameter) {
        return exec("deleteAll", parameter);
    }
    

}