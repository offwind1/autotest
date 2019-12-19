package com.mizholdings.me2.agent.manage;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.util.*;
import io.qameta.allure.Step;

public class TopPageAgent extends MODBase<TopPageAgent> {

    public TopPageAgent(User executor) {
        super(executor);
    }


    
    /**
     * 推荐内容
     *
     * @return json
     */
    @Step("推荐内容")
    public JSONObject recommend(Parameter parameter) {
        return exec("recommend", parameter);
    }
    
    /**
     * 推荐列表
     *
     * @return json
     */
    @Step("推荐列表")
    public JSONObject topPageList(Parameter parameter) {
        return exec("topPageList", parameter);
    }
    
    /**
     * 修改推荐项
     *
     * @return json
     */
    @Step("修改推荐项")
    public JSONObject edit(Parameter parameter) {
        return exec("edit", parameter);
    }
    
    /**
     * 撤销推荐
     *
     * @return json
     */
    @Step("撤销推荐")
    public JSONObject delTopPage(Parameter parameter) {
        return exec("delTopPage", parameter);
    }
    

}