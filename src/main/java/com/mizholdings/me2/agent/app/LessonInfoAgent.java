package com.mizholdings.me2.agent.app;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.util.*;
import io.qameta.allure.Step;

public class LessonInfoAgent extends MODBase<LessonInfoAgent> {

//    public static LessonInfoInterface lessonInfoInterface = Requests.getService(LessonInfoInterface.class);

    public LessonInfoAgent(User executor) {
        super(executor);
//        interfaced = lessonInfoInterface;
    }

    /**
     * 我的课程
     *
     * @param lessonName 课程名称
     * @param lessonTerm 课程类型 0查询所有，1课程，2微课
     * @return
     */
    @Step("我的课程")
    public JSONObject myLesson(String lessonName, LessonTerm lessonTerm) {
        return exec("myLesson", Parameter.creat()
                .add("page", "1")
                .add("lessonName", "")
                .add("lessonTerm", lessonTerm.value));
    }

    /**
     * 我的课程 不进行名称搜索
     *
     * @param lessonTerm
     * @return
     */
    public JSONObject myLesson(LessonTerm lessonTerm) {
        return myLesson("", lessonTerm);
    }


    /**
     * 点赞课程
     *
     * @param lessonId 课程id
     * @return
     */
    @Step("点赞课程")
    public JSONObject likedLesson(String lessonId) {
        return exec("likedLesson", Parameter.creat().add("lessonId", lessonId));
    }


    /**
     * 课程详情
     *
     * @param lessonId 课程id
     * @return
     */
    @Step("课程详情")
    public JSONObject lessonInfo(String lessonId) {
        return exec("lessonInfo", Parameter.creat().add("lessonId", lessonId));
    }

    /**
     * 查询用户课程列表
     *
     * @param userId 用户id
     * @return
     */
    @Step("查询用户课程列表")
    public JSONObject usrLesson(String userId) {
        return exec("usrLesson", Parameter.creat().add("userId", userId).add("page", "1"));
    }

    /**
     * 更新视频回放，观看时长
     *
     * @param timeLong         long,观看时长（秒）
     * @param lessonId         string,课程ID
     * @param classroomId      string,课堂ID
     * @param classroomVideoId string,课堂视频ID
     * @return
     */
    @Step("更新视频回放，观看时长")
    public JSONObject updateVideoTime(String timeLong, String lessonId, String classroomId, String classroomVideoId) {
        return exec("updateVideoTime", Parameter.creat()
                .add("timeLong", timeLong)
                .add("lessonId", lessonId)
                .add("classroomId", classroomId)
                .add("classroomVideoId", classroomVideoId));
    }


    public JSONObject getVideoRecord(String classroomId, String classroomVideoId) {
        return exec("getVideoRecord", Parameter.creat()
                .add("classroomId", classroomId)
                .add("classroomVideoId", classroomVideoId));
    }


    /**
     * 课程分类
     */
    public enum LessonTerm {
        ALL("0"), LESSON("1"), QUICK("2");

        public String value;

        private LessonTerm(String value) {
            this.value = value;
        }
    }




    /**
     * 查询用户时候拥有该课程
     *
     * @return json
     */
    @Step("查询用户时候拥有该课程")
    public JSONObject existPays(Parameter parameter) {
        return exec("existPays", parameter);
    }

    /**
     * 相关推荐
     *
     * @return json
     */
    @Step("相关推荐")
    public JSONObject relatedList(Parameter parameter) {
        return exec("relatedList", parameter);
    }

    /**
     * 选课中心筛选条件
     *
     * @return json
     */
    @Step("选课中心筛选条件")
    public JSONObject screen(Parameter parameter) {
        return exec("screen", parameter);
    }

    /**
     * 课程列表
     *
     * @return json
     */
    @Step("课程列表")
    public JSONObject list(Parameter parameter) {
        return exec("list", parameter);
    }

    /**
     * 课程详情
     *
     * @return json
     */
    @Step("课程详情")
    public JSONObject lessonInfo(Parameter parameter) {
        return exec("lessonInfo", parameter);
    }

    /**
     * 课程评论
     *
     * @return json
     */
    @Step("课程评论")
    public JSONObject score(Parameter parameter) {
        return exec("score", parameter);
    }

    /**
     * 查询用户课程列表
     *
     * @return json
     */
    @Step("查询用户课程列表")
    public JSONObject usrLesson(Parameter parameter) {
        return exec("usrLesson", parameter);
    }

    /**
     * 我要听课，我要上课的日历列表
     *
     * @return json
     */
    @Step("我要听课，我要上课的日历列表")
    public JSONObject studyLesson(Parameter parameter) {
        return exec("studyLesson", parameter);
    }

    /**
     * 点赞课程
     *
     * @return json
     */
    @Step("点赞课程")
    public JSONObject likedLesson(Parameter parameter) {
        return exec("likedLesson", parameter);
    }

    /**
     * 取消点赞
     *
     * @return json
     */
    @Step("取消点赞")
    public JSONObject rmlikedLesson(Parameter parameter) {
        return exec("rmlikedLesson", parameter);
    }

    /**
     * 收藏课程
     *
     * @return json
     */
    @Step("收藏课程")
    public JSONObject keepLesson(Parameter parameter) {
        return exec("keepLesson", parameter);
    }

    /**
     * 取消收藏
     *
     * @return json
     */
    @Step("取消收藏")
    public JSONObject rmkeepLesson(Parameter parameter) {
        return exec("rmkeepLesson", parameter);
    }

    /**
     * 查询课程评论
     *
     * @return json
     */
    @Step("查询课程评论")
    public JSONObject lessonScore(Parameter parameter) {
        return exec("lessonScore", parameter);
    }

    /**
     * 我的课程
     *
     * @return json
     */
    @Step("我的课程")
    public JSONObject myLesson(Parameter parameter) {
        return exec("myLesson", parameter);
    }

    /**
     * 获取退课款项
     *
     * @return json
     */
    @Step("获取退课款项")
    public JSONObject retreat(Parameter parameter) {
        return exec("retreat", parameter);
    }

    /**
     * 退课申请
     *
     * @return json
     */
    @Step("退课申请")
    public JSONObject refundApply(Parameter parameter) {
        return exec("refundApply", parameter);
    }

    /**
     * 查询退课状态
     *
     * @return json
     */
    @Step("查询退课状态")
    public JSONObject refundStatus(Parameter parameter) {
        return exec("refundStatus", parameter);
    }

    /**
     * 我创建的课程
     *
     * @return json
     */
    @Step("我创建的课程")
    public JSONObject myCreateLesson(Parameter parameter) {
        return exec("myCreateLesson", parameter);
    }

    /**
     * 删除私课
     *
     * @return json
     */
    @Step("删除私课")
    public JSONObject delLesson(Parameter parameter) {
        return exec("delLesson", parameter);
    }

    /**
     * 获取视频回放记录
     *
     * @return json
     */
    @Step("获取视频回放记录")
    public JSONObject getVideoRecord(Parameter parameter) {
        return exec("getVideoRecord", parameter);
    }

    /**
     * 根据视频id查询播放量
     *
     * @return json
     */
    @Step("根据视频id查询播放量")
    public JSONObject getTotalPlays(Parameter parameter) {
        return exec("getTotalPlays", parameter);
    }

    /**
     * 免费课程列表
     *
     * @return json
     */
    @Step("免费课程列表")
    public JSONObject freeList(Parameter parameter) {
        return exec("freeList", parameter);
    }

    /**
     * 我的课程(我购买的)PC
     *
     * @return json
     */
    @Step("我的课程(我购买的)PC")
    public JSONObject myLessonPC(Parameter parameter) {
        return exec("myLessonPC", parameter);
    }

    /**
     * 更新视频回放，观看时长
     *
     * @return json
     */
    @Step("更新视频回放，观看时长")
    public JSONObject updateVideoTime(Parameter parameter) {
        return exec("updateVideoTime", parameter);
    }


}
