package com.mizholdings.me2.agent.web;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.util.*;
import io.qameta.allure.Step;

public class NewTagInfoAgent extends MODBase<NewTagInfoAgent> {

    public NewTagInfoAgent(User executor) {
        super(executor);
    }


    
    /**
     * 获取标签列表
     *
     * @return json
     */
    @Step("获取标签列表")
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
     * 删除标签
     *
     * @return json
     */
    @Step("删除标签")
    public JSONObject deleteTag(Parameter parameter) {
        return exec("deleteTag", parameter);
    }
    
    /**
     * 修改标签
     *
     * @return json
     */
    @Step("修改标签")
    public JSONObject editTag(Parameter parameter) {
        return exec("editTag", parameter);
    }
    

}