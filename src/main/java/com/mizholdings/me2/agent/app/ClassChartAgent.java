package com.mizholdings.me2.agent.app;

import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.M2TYPE;
import com.mizholdings.util.*;
import io.qameta.allure.Step;

public class ClassChartAgent extends MODBase<ClassChartAgent> {
    public ClassChartAgent(User executor) {
        super(executor);
    }

    /**
     * 到课统计
     *
     * @param classroomId 课堂ID
     * @return
     */
    @Step("到课统计")
    public JSONObject arrive(String classroomId) {
        return exec("arrive", Parameter.creat()
                .add("classroomId", classroomId));
    }

    /**
     * 回放记录-班级（总表）
     *
     * @return
     */
    @Step("回放记录-班级（总表）")
    public JSONObject getVideoList(String stuId, String startTime, String endTime) {
        return exec("getVideoList", Parameter.creat()
                .add("stuId", stuId)
                .add("startTime", startTime)
                .add("endTime", endTime));
    }

    /**
     * 回放记录-班级（总表） 搜索内容默认当天
     *
     * @param stuId 班级id
     * @return
     */
    @Step("回放记录-班级（总表） 搜索内容默认当天")
    public JSONObject getVideoList(String stuId) {
        return getVideoList(stuId, DateUtil.today(), DateUtil.today());
    }


    /**
     * 回放记录-班级（详情表）
     *
     * @return
     */
    @Step("回放记录-班级（详情表）")
    public JSONObject getVideoListClass(String lessonId, String stuId) {
        return exec("getVideoListClass", Parameter.creat()
                .add("lessonId", lessonId)
                .add("stuId", stuId)
        );
    }


    /**
     * 回放记录-学科（详情表）
     *
     * @param lessonId       班级Id
     * @param stuId          班级id
     * @param lesson_type_id 课程ID
     * @return
     */
    @Step("回放记录-学科（详情表）")
    public JSONObject getVideoLesTypeClass(String lessonId, String stuId, M2TYPE.LESSON_TYPE_ID lesson_type_id,
                                           String startTime, String endTime) {
        return exec("getVideoLesTypeClass", Parameter.creat()
                .add("lessonId", lessonId)
                .add("stuId", stuId)
                .add("lessonTypeId", lesson_type_id.value)
                .add("startTime", startTime)
                .add("endTime", endTime)
        );
    }

    public JSONObject getVideoLesTypeClass(String lessonId, String stuId, M2TYPE.LESSON_TYPE_ID lesson_type_id) {
        return getVideoLesTypeClass(lessonId, stuId, lesson_type_id, DateUtil.today(), DateUtil.today());
    }


    /**
     * 课堂互动列表
     *
     * @return json
     */
    @Step("课堂互动列表")
    public JSONObject interact(Parameter parameter) {
        return exec("interact", parameter);
    }

    /**
     * 到课统计
     *
     * @return json
     */
    @Step("到课统计")
    public JSONObject arrive(Parameter parameter) {
        return exec("arrive", parameter);
    }

    /**
     * 作业统计
     *
     * @return json
     */
    @Step("作业统计")
    public JSONObject homework(Parameter parameter) {
        return exec("homework", parameter);
    }

    /**
     * 答题进度
     *
     * @return json
     */
    @Step("答题进度")
    public JSONObject answer(Parameter parameter) {
        return exec("answer", parameter);
    }

    /**
     * 课堂统计导出XLS
     *
     * @return json
     */
    @Step("课堂统计导出XLS")
    public JSONObject export(Parameter parameter) {
        return exec("export", parameter);
    }

    /**
     * 导出XLS考勤概述
     *
     * @return json
     */
    @Step("导出XLS考勤概述")
    public JSONObject summary(Parameter parameter) {
        return exec("summary", parameter);
    }

    /**
     * 根据班级导出XLS
     *
     * @return json
     */
    @Step("根据班级导出XLS")
    public JSONObject exportByStuId(Parameter parameter) {
        return exec("exportByStuId", parameter);
    }

    /**
     * 根据时间班级查询考勤信息
     *
     * @return json
     */
    @Step("根据时间班级查询考勤信息")
    public JSONObject getAttendanceByStuId(Parameter parameter) {
        return exec("getAttendanceByStuId", parameter);
    }

    /**
     * 根据时间班级查询考勤详细信息(学生考勤)
     *
     * @return json
     */
    @Step("根据时间班级查询考勤详细信息(学生考勤)")
    public JSONObject getAttendanceInfoByStuId(Parameter parameter) {
        return exec("getAttendanceInfoByStuId", parameter);
    }

    /**
     * 学科考勤（总表）
     *
     * @return json
     */
    @Step("学科考勤（总表）")
    public JSONObject getLessonTypeDili(Parameter parameter) {
        return exec("getLessonTypeDili", parameter);
    }

    /**
     * 学科考勤（班级表）
     *
     * @return json
     */
    @Step("学科考勤（班级表）")
    public JSONObject getLessonTypeDiliClass(Parameter parameter) {
        return exec("getLessonTypeDiliClass", parameter);
    }

    /**
     * 学科考勤XLS文件导出
     *
     * @return json
     */
    @Step("学科考勤XLS文件导出")
    public JSONObject exportByLesType(Parameter parameter) {
        return exec("exportByLesType", parameter);
    }

    /**
     * 回放记录-班级（总表）
     *
     * @return json
     */
    @Step("回放记录-班级（总表）")
    public JSONObject getVideoList(Parameter parameter) {
        return exec("getVideoList", parameter);
    }

    /**
     * 回放记录-班级（详情表）
     *
     * @return json
     */
    @Step("回放记录-班级（详情表）")
    public JSONObject getVideoListClass(Parameter parameter) {
        return exec("getVideoListClass", parameter);
    }

    /**
     * 视频回看统计导出
     *
     * @return json
     */
    @Step("视频回看统计导出")
    public JSONObject exportByVideo(Parameter parameter) {
        return exec("exportByVideo", parameter);
    }

    /**
     * 回放记录-学科（列表）
     *
     * @return json
     */
    @Step("回放记录-学科（列表）")
    public JSONObject getVideoLesType(Parameter parameter) {
        return exec("getVideoLesType", parameter);
    }

    /**
     * 回放记录-学科（详情表）
     *
     * @return json
     */
    @Step("回放记录-学科（详情表）")
    public JSONObject getVideoLesTypeClass(Parameter parameter) {
        return exec("getVideoLesTypeClass", parameter);
    }

    /**
     * 回放记录-学科-导出
     *
     * @return json
     */
    @Step("回放记录-学科-导出")
    public JSONObject exportByVideoType(Parameter parameter) {
        return exec("exportByVideoType", parameter);
    }

    /**
     * 课堂考勤-教师（列表）
     *
     * @return json
     */
    @Step("课堂考勤-教师（列表）")
    public JSONObject getClassChartByTeacher(Parameter parameter) {
        return exec("getClassChartByTeacher", parameter);
    }

    /**
     * 回放记录-教师（列表）
     *
     * @return json
     */
    @Step("回放记录-教师（列表）")
    public JSONObject getVideoListByTeacher(Parameter parameter) {
        return exec("getVideoListByTeacher", parameter);
    }

    /**
     * 回放记录-教师（列表详情）
     *
     * @return json
     */
    @Step("回放记录-教师（列表详情）")
    public JSONObject getVideoListByTeacherDetail(Parameter parameter) {
        return exec("getVideoListByTeacherDetail", parameter);
    }

    /**
     * 导出回访记录-个人用户（教师）
     *
     * @return json
     */
    @Step("导出回访记录-个人用户（教师）")
    public JSONObject exportByVideoTeacher(Parameter parameter) {
        return exec("exportByVideoTeacher", parameter);
    }

    /**
     * WEB端考勤，课程下拉框
     *
     * @return json
     */
    @Step("WEB端考勤，课程下拉框")
    public JSONObject getUserLessonList(Parameter parameter) {
        return exec("getUserLessonList", parameter);
    }

}