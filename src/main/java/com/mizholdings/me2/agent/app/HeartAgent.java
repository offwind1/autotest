package com.mizholdings.me2.agent.app;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.util.*;
import io.qameta.allure.Step;

public class HeartAgent extends MODBase<HeartAgent> {

    public HeartAgent(User executor) {
        super(executor);
    }


    
    /**
     * 课堂心跳
     *
     * @return json
     */
    @Step("课堂心跳")
    public JSONObject classroom(Parameter parameter) {
        return exec("classroom", parameter);
    }
    

}