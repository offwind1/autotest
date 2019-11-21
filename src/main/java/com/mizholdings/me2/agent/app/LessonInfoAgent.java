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
     * @param javaBean
     * @return
     */
    public JSONObject myLesson(PLJavaBean javaBean) {
        return exec("myLesson", javaBean);
    }

    /**
     * 点赞课程
     *
     * @param javaBean
     * @return
     */
    public JSONObject likedLesson(PLJavaBean javaBean) {
        return exec("likedLesson", javaBean);
    }


    /**
     * 相关推荐
     *
     * @param javaBean relatedList
     * @return
     */
    public JSONObject relatedList(PLJavaBean javaBean) {
        return exec("relatedList", javaBean);
    }

    /**
     * 选课中心筛选条件
     *
     * @param javaBean screen
     * @return
     */
    public JSONObject screen(PLJavaBean javaBean) {
        return exec("screen", javaBean);
    }

    /**
     * 课程列表
     *
     * @param javaBean list
     * @return
     */
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
    public JSONObject studyLesson(PLJavaBean javaBean) {
        return exec("studyLesson", javaBean);
    }


    /**
     * 取消点赞
     *
     * @param javaBean rmlikedLesson
     * @return
     */
    public JSONObject rmlikedLesson(PLJavaBean javaBean) {
        return exec("rmlikedLesson", javaBean);
    }

    /**
     * 收藏课程
     *
     * @param javaBean keepLesson
     * @return
     */
    public JSONObject keepLesson(PLJavaBean javaBean) {
        return exec("keepLesson", javaBean);
    }

    /**
     * 取消收藏
     *
     * @param javaBean rmkeepLesson
     * @return
     */
    public JSONObject rmkeepLesson(PLJavaBean javaBean) {
        return exec("rmkeepLesson", javaBean);
    }

    /**
     * 查询课程评论
     *
     * @param javaBean lessonScore
     * @return
     */
    public JSONObject lessonScore(PLJavaBean javaBean) {
        return exec("lessonScore", javaBean);
    }

    /**
     * 获取退课款项
     *
     * @param javaBean retreat
     * @return
     */
    public JSONObject retreat(PLJavaBean javaBean) {
        return exec("retreat", javaBean);
    }

    /**
     * 退课申请
     *
     * @param javaBean refundApply
     * @return
     */
    public JSONObject refundApply(PLJavaBean javaBean) {
        return exec("refundApply", javaBean);
    }

    /**
     * 查询退课状态
     *
     * @param javaBean refundStatus
     * @return
     */
    public JSONObject refundStatus(PLJavaBean javaBean) {
        return exec("refundStatus", javaBean);
    }

    /**
     * 我创建的课程
     *
     * @param javaBean myCreateLesson
     * @return
     */
    public JSONObject myCreateLesson(PLJavaBean javaBean) {
        return exec("myCreateLesson", javaBean);
    }

    /**
     * 删除私课
     *
     * @param javaBean delLesson
     * @return
     */
    public JSONObject delLesson(PLJavaBean javaBean) {
        return exec("delLesson", javaBean);
    }

    /**
     * 新增视频回放记录
     *
     * @param javaBean setVideoRecord
     * @return
     */
    public JSONObject setVideoRecord(PLJavaBean javaBean) {
        return exec("setVideoRecord", javaBean);
    }

    /**
     * 根据视频id查询播放量
     *
     * @param javaBean getTotalPlays
     * @return
     */
    public JSONObject getTotalPlays(PLJavaBean javaBean) {
        return exec("getTotalPlays", javaBean);
    }

    /**
     * 免费课程列表
     *
     * @param javaBean freeList
     * @return
     */
    public JSONObject freeList(PLJavaBean javaBean) {
        return exec("freeList", javaBean);
    }

    /**
     * 我的课程(我购买的)PC
     *
     * @param javaBean myLessonPC
     * @return
     */
    public JSONObject myLessonPC(PLJavaBean javaBean) {
        return exec("myLessonPC", javaBean);
    }

    /**
     * 更新视频回放，观看时长
     *
     * @param javaBean updateVideoTime
     * @return
     */
    public JSONObject updateVideoTime(PLJavaBean javaBean) {
        return exec("updateVideoTime", javaBean);
    }

}
