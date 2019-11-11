package com.mizholdings.me2.core.user;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.core.mod.MODClassInfo;
import com.mizholdings.me2.core.mod.MODLessonInfo;
import com.mizholdings.me2.core.mod.MODMobile;
import com.mizholdings.me2.interfaces.api.MobileInterface;
import com.mizholdings.me2.playload.PLClassInfo;
import com.mizholdings.me2.playload.PLLessonInfo;
import com.mizholdings.me2.playload.PLMobile;
import com.mizholdings.util.Funcs;
import com.mizholdings.util.Requests;
import io.qameta.allure.Step;

public class Me2Teacher extends Me2UserBase {

    public Me2Teacher(String account, String password) {
        super(account, password);
    }


    /**
     * 我的课程
     *
     * @return
     */
    public JSONObject myLesson() {
        PLLessonInfo plLessonInfo = new PLLessonInfo();
        plLessonInfo.setMyLesson("");
        return modLessonInfo.myLesson(plLessonInfo);
    }

    public JSONObject getCode() {
        return modClassInfo.getCode();
    }

    /**
     * 快速开课
     *
     * @return
     */
    public JSONObject quickStart() {
        JSONObject object = getCode();
        String code = object.getJSONObject("data").getString("classroomCode");

        PLClassInfo classInfo = new PLClassInfo();
        classInfo.setQuickStart(code);

        return modClassInfo.quickStart(classInfo);
    }


    /**
     * 课堂结束，保存信息
     *
     * @param classroomVideoId string,视频ID
     * @param cloudAccount     string,老师云信账号(token无效时使用)
     * @return
     */
    public JSONObject classroomEnd(String classroomVideoId, String cloudAccount) {
        PLClassInfo classInfo = new PLClassInfo();
        classInfo.setClassroomEnd(classroomVideoId, cloudAccount);
        return modClassInfo.classroomEnd(classInfo);
    }
}
