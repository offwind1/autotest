package com.mizholdings.me2.agent.app;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.util.*;
import io.qameta.allure.Step;

public class CreditAgent extends MODBase<CreditAgent> {
//    public static CreditInterface creditInterface = Requests.getService(CreditInterface.class);

    public CreditAgent(User executor) {
        super(executor);
//        interfaced = creditInterface;
    }


    /**
     * 学生学习资源，获取学分
     *
     * @return
     */
    public JSONObject addByCourse(String coursewareId) {
        return exec("addByCourse", Parameter.creat().add("coursewareId", coursewareId));
    }


    /**
     * 学生学习课堂，老师指定学分
     *
     * @param classroomId 课堂id
     * @param useIds      用户id
     * @param creditNum   发放分数
     * @return
     */
    public JSONObject addByClassroom(String classroomId, String useIds, String creditNum) {
        return exec("addByClassroom", Parameter.creat()
                .add("classroomId", classroomId).add("useIds", useIds).add("creditNum", creditNum));
    }

    /**
     * 用户查询自己的学分
     *
     * @return
     */
    public JSONObject getCreditList() {
        return exec("getCreditList", Parameter.creat().add("page", "1"));
    }


    /**
     * 学生学习资源，获取学分
     *
     * @return json
     */
    @Step("学生学习资源，获取学分")
    public JSONObject addByCourse(Parameter parameter) {
        return exec("addByCourse", parameter);
    }

    /**
     * 学生学习课堂，老师指定学分
     *
     * @return json
     */
    @Step("学生学习课堂，老师指定学分")
    public JSONObject addByClassroom(Parameter parameter) {
        return exec("addByClassroom", parameter);
    }

    /**
     * 用户查询自己的学分
     *
     * @return json
     */
    @Step("用户查询自己的学分")
    public JSONObject getCreditList(Parameter parameter) {
        return exec("getCreditList", parameter);
    }

}