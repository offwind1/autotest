package com.mizholdings.me2.agent.web;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.util.*;
import io.qameta.allure.Step;

public class QiniuAgent extends MODBase<QiniuAgent> {

    public QiniuAgent(User executor) {
        super(executor);
    }


    
    /**
     * 获得uptoken
     *
     * @return json
     */
    @Step("获得uptoken")
    public JSONObject getUptoken(Parameter parameter) {
        return exec("getUptoken", parameter);
    }
    
    /**
     * 添加课堂视频转码
     *
     * @return json
     */
    @Step("添加课堂视频转码")
    public JSONObject addClassVideoTranscoding(Parameter parameter) {
        return exec("addClassVideoTranscoding", parameter);
    }
    
    /**
     * 添加课件资源转码
     *
     * @return json
     */
    @Step("添加课件资源转码")
    public JSONObject addCoursewareTranscoding(Parameter parameter) {
        return exec("addCoursewareTranscoding", parameter);
    }
    

}