package com.mizholdings.me2.agent.app;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.interfaces.api.LessonInfoInterface;
import com.mizholdings.me2.user.Me2UserBase;
import com.mizholdings.util.*;
import io.qameta.allure.Step;

public class LessonInfoAgent extends MODBase<LessonInfoAgent> {

    public static LessonInfoInterface lessonInfoInterface = Requests.getService(LessonInfoInterface.class);

    public LessonInfoAgent(User executor) {
        super(executor);
        interfaced = lessonInfoInterface;
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
     * 相关推荐
     *
     * @param javaBean relatedList
     * @return
     */
    @Step("相关推荐")
    public JSONObject relatedList(PLJavaBean javaBean) {
        return exec("relatedList", javaBean);
    }

    /**
     * 选课中心筛选条件
     *
     * @param javaBean screen
     * @return
     */
    @Step("选课中心筛选条件")
    public JSONObject screen(PLJavaBean javaBean) {
        return exec("screen", javaBean);
    }

    /**
     * 课程列表
     *
     * @param javaBean list
     * @return
     */
    @Step("课程列表")
    public JSONObject list(PLJavaBean javaBean) {
        return exec("list", javaBean);
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
     * 课程评论
     *
     * @param javaBean score
     * @return
     */
    @Step("课程评论")
    public JSONObject score(PLJavaBean javaBean) {
        return exec("score", javaBean);
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
     * 我要听课，我要上课的日历列表
     *
     * @param javaBean studyLesson
     * @return
     */
    @Step("我要听课，我要上课的日历列表")
    public JSONObject studyLesson(PLJavaBean javaBean) {
        return exec("studyLesson", javaBean);
    }


    /**
     * 取消点赞
     *
     * @param javaBean rmlikedLesson
     * @return
     */
    @Step("取消点赞")
    public JSONObject rmlikedLesson(PLJavaBean javaBean) {
        return exec("rmlikedLesson", javaBean);
    }

    /**
     * 收藏课程
     *
     * @param javaBean keepLesson
     * @return
     */
    @Step("收藏课程")
    public JSONObject keepLesson(PLJavaBean javaBean) {
        return exec("keepLesson", javaBean);
    }

    /**
     * 取消收藏
     *
     * @param javaBean rmkeepLesson
     * @return
     */
    @Step("取消收藏")
    public JSONObject rmkeepLesson(PLJavaBean javaBean) {
        return exec("rmkeepLesson", javaBean);
    }

    /**
     * 查询课程评论
     *
     * @param javaBean lessonScore
     * @return
     */
    @Step("查询课程评论")
    public JSONObject lessonScore(PLJavaBean javaBean) {
        return exec("lessonScore", javaBean);
    }

    /**
     * 获取退课款项
     *
     * @param javaBean retreat
     * @return
     */
    @Step("获取退课款项")
    public JSONObject retreat(PLJavaBean javaBean) {
        return exec("retreat", javaBean);
    }

    /**
     * 退课申请
     *
     * @param javaBean refundApply
     * @return
     */
    @Step("退课申请")
    public JSONObject refundApply(PLJavaBean javaBean) {
        return exec("refundApply", javaBean);
    }

    /**
     * 查询退课状态
     *
     * @param javaBean refundStatus
     * @return
     */
    @Step("查询退课状态")
    public JSONObject refundStatus(PLJavaBean javaBean) {
        return exec("refundStatus", javaBean);
    }

    /**
     * 我创建的课程
     *
     * @param javaBean myCreateLesson
     * @return
     */
    @Step("我创建的课程")
    public JSONObject myCreateLesson(PLJavaBean javaBean) {
        return exec("myCreateLesson", javaBean);
    }

    /**
     * 删除私课
     *
     * @param javaBean delLesson
     * @return
     */
    @Step("删除私课")
    public JSONObject delLesson(PLJavaBean javaBean) {
        return exec("delLesson", javaBean);
    }

    /**
     * 新增视频回放记录
     *
     * @param javaBean setVideoRecord
     * @return
     */
    @Step("新增视频回放记录")
    public JSONObject setVideoRecord(PLJavaBean javaBean) {
        return exec("setVideoRecord", javaBean);
    }

    /**
     * 根据视频id查询播放量
     *
     * @param javaBean getTotalPlays
     * @return
     */
    @Step("根据视频id查询播放量")
    public JSONObject getTotalPlays(PLJavaBean javaBean) {
        return exec("getTotalPlays", javaBean);
    }

    /**
     * 免费课程列表
     *
     * @param javaBean freeList
     * @return
     */
    @Step("免费课程列表")
    public JSONObject freeList(PLJavaBean javaBean) {
        return exec("freeList", javaBean);
    }

    /**
     * 我的课程(我购买的)PC
     *
     * @param javaBean myLessonPC
     * @return
     */
    @Step("我的课程(我购买的)PC")
    public JSONObject myLessonPC(PLJavaBean javaBean) {
        return exec("myLessonPC", javaBean);
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


}
