package com.mizholdings.me2.agent.web;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.interfaces.web.CreditInterface;
import com.mizholdings.me2.user.Me2UserBase;
import com.mizholdings.util.*;
import io.qameta.allure.Step;

public class CreditAgent extends MODBase<CreditAgent> {
    public static CreditInterface creditInterface = Requests.getService(CreditInterface.class);

    public CreditAgent(User executor) {
        super(executor);
        interfaced = creditInterface;
    }

    @Step("添加学分信息")
    public JSONObject addCreditInfo(String creditName, String creditIcon) {
        return exec("addCreditInfo", Parameter.creat()
                .add("creditName", creditName)
                .add("creditIcon", creditIcon));

    }

    @Step("根据用户查询学分")
    public JSONObject creditList(Parameter parameter) {
        return exec("creditList", parameter
                .add("currentPage", "1")
                .add("pageSize", "100"));
    }

    public JSONObject creditList() {
        return creditList(Parameter.creat());
    }

    public JSONObject creditListByCourseId(String coursewareId) {
        return creditList(Parameter.creat().add("coursewareId", coursewareId));
    }

    public JSONObject creditListByLessonId(String lessonId) {
        return creditList(Parameter.creat().add("lessonId", lessonId));
    }

    @Step("用户积分记录")
    public JSONObject userCredit(String userId, String creditId) {
        return exec("userCredit", Parameter.creat()
                .add("userId", userId)
                .add("creditId", creditId));
    }

    @Step("获取用户学分信息")
    public JSONObject getCreditByUserId() {
        return exec("getCreditByUserId");
    }

    @Step("修改学分信息")
    public JSONObject editCreditInfo(String creditId, String creditIcon, String creditName) {
        return exec("editCreditInfo", Parameter.creat()
                .add("creditId", creditId)
                .add("creditIcon", creditIcon)
                .add("creditName", creditName));
    }

    @Step("修改积分")
    public JSONObject editUserCredit(String userId, String creditId, String num) {
        return exec("editUserCredit", Parameter.creat()
                .add("userId", userId)
                .add("creditId", creditId)
                .add("num", num));
    }

    @Step("查询课程列表")
    public JSONObject creditLessonList() {
        return exec("creditLessonList", Parameter.creat()
                .add("currentPage", "1")
                .add("pageSize", "10"));
    }

    @Step("学分资源列表")
    public JSONObject creditCourseList() {
        return exec("creditCourseList", Parameter.creat()
                .add("currentPage", "1")
                .add("pageSize", "10"));
    }
}