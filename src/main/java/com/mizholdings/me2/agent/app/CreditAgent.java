package com.mizholdings.me2.agent.app;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.user.Me2UserBase;
import com.mizholdings.me2.interfaces.api.CreditInterface;
import com.mizholdings.util.*;

public class CreditAgent extends MODBase<CreditAgent> {
    public static CreditInterface creditInterface = Requests.getService(CreditInterface.class);

    public CreditAgent(User executor) {
        super(executor);
        interfaced = creditInterface;
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


}