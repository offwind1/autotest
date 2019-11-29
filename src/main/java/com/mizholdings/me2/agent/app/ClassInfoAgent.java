package com.mizholdings.me2.agent.app;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.user.Me2UserBase;
import com.mizholdings.me2.interfaces.api.ClassInfoInterface;
import com.mizholdings.util.*;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;

public class ClassInfoAgent extends MODBase<ClassInfoAgent> {

    public static ClassInfoInterface classInfoInterface = Requests.getService(ClassInfoInterface.class);

    public ClassInfoAgent(User executor) {
        super(executor);
        interfaced = classInfoInterface;
    }

    /**
     * 老师点赞学生答案
     *
     * @param classroomId 课堂ID
     * @param accountIds  被点赞的学生云信ID集合(和userIds两者必须选择其中一个)
     * @return
     */
    @Step("老师点赞学生答案")
    public JSONObject laudStudent(String classroomId, String accountIds) {
        return exec("laudStudent", Parameter.creat()
                .add("classroomId", classroomId)
                .add("accountIds", accountIds));
    }

    /**
     * 快速开课
     *
     * @param classroomName 班级名称
     * @param classroomCode 开课code
     * @return
     */
    @Step("快速开课")
    public JSONObject quickStart(String classroomName, String classroomCode) {
        return exec("quickStart", Parameter.creat()
                .add("classroomName", classroomName)
                .add("classroomCode", classroomCode)
                .add("classroomChannel", "1")
                .add("interaction", "4")
                .add("isopenHeat", "1")
                .add("anonymous", "0")
                .add("appId", "dkzp6zxxh")
                .add("recorded", "1"));
    }

    /**
     * 课堂结束，保存信息
     *
     * @param classroomVideoId 课堂视频ID
     * @param cloudAccount     云信id
     * @return
     */
    @Step("课堂结束，保存信息")
    public JSONObject classroomEnd(String classroomVideoId, String cloudAccount) {
        return exec("classroomEnd", Parameter.creat()
                .add("classroomVideoId", classroomVideoId)
                .add("cloudAccount", cloudAccount));
    }

    /**
     * 获得课堂CODE
     *
     * @return
     */
    @Step("获得课堂CODE")
    public JSONObject getCode() {
        return exec("getCode");
    }


    /**
     * 根据课程ID获得课堂列表
     *
     * @param javaBean listByLessonId
     * @return
     */
    @Step("根据课程ID获得课堂列表")
    public JSONObject listByLessonId(PLJavaBean javaBean) {
        return exec("listByLessonId", javaBean);
    }

    /**
     * 拿到课堂附加资源列表
     *
     * @param classroomId 课节id
     * @return
     */
    @Step("拿到课堂附加资源列表")
    public JSONObject optionList(String classroomId) {
        return exec("optionList", Parameter.creat().add("classroomId", classroomId));
    }

    /**
     * 申请开课，添加视频表信息
     *
     * @return
     */
    @Step("申请开课，添加视频表信息")
    public JSONObject classroomStart(String classroomId) {
        return exec("classroomStart", Parameter.creat()
                .add("classroomId", classroomId)
                .add("classroomChannel", "1")
                .add("isopenHeat", "1")
                .add("appId", "dkzp6zxxh")
                .add("recorded", "2"));
    }


    /**
     * 用户加入课堂
     *
     * @param javaBean classroomAddUser
     * @return
     */
    @Step("用户加入课堂")
    public JSONObject classroomAddUser(PLJavaBean javaBean) {
        return exec("classroomAddUser", javaBean);
    }

    /**
     * 用户根据课堂CODE加入课堂
     *
     * @param javaBean classroomCodeAddUser
     * @return
     */
    @Step("用户根据课堂CODE加入课堂")
    public JSONObject classroomCodeAddUser(PLJavaBean javaBean) {
        return exec("classroomCodeAddUser", javaBean);
    }

    /**
     * 用户退出课堂
     *
     * @param javaBean classroomRemoveUser
     * @return
     */
    @Step("用户退出课堂")
    public JSONObject classroomRemoveUser(PLJavaBean javaBean) {
        return exec("classroomRemoveUser", javaBean);
    }


    /**
     * 群组禁言
     *
     * @param javaBean muteTlistAll
     * @return
     */
    @Step("群组禁言")
    public JSONObject muteTlistAll(PLJavaBean javaBean) {
        return exec("muteTlistAll", javaBean);
    }

    /**
     * 回填课堂视频URL
     *
     * @param javaBean classVideo
     * @return
     */
    @Step("回填课堂视频URL")
    public JSONObject classVideo(PLJavaBean javaBean) {
        return exec("classVideo", javaBean);
    }

    /**
     * 拿到课堂的课件
     *
     * @param javaBean getCourse
     * @return
     */
    @Step("拿到课堂的课件")
    public JSONObject getCourse(PLJavaBean javaBean) {
        return exec("getCourse", javaBean);
    }

    /**
     * 获取7牛直播推流URL
     *
     * @param javaBean pushUrl
     * @return
     */
    @Step("获取7牛直播推流URL")
    public JSONObject pushUrl(PLJavaBean javaBean) {
        return exec("pushUrl", javaBean);
    }

    /**
     * 获取7牛直播观看URL
     *
     * @param javaBean pullUrl
     * @return
     */
    @Step("获取7牛直播观看URL")
    public JSONObject pullUrl(PLJavaBean javaBean) {
        return exec("pullUrl", javaBean);
    }

    /**
     * 课堂中用户举手
     *
     * @param javaBean handsUp
     * @return
     */
    @Step("课堂中用户举手")
    public JSONObject handsUp(PLJavaBean javaBean) {
        return exec("handsUp", javaBean);
    }

    /**
     * 教师同意用户举手
     *
     * @param javaBean agreeHandsUp
     * @return
     */
    @Step("教师同意用户举手")
    public JSONObject agreeHandsUp(PLJavaBean javaBean) {
        return exec("agreeHandsUp", javaBean);
    }

    /**
     * 7牛连麦——创建连麦房间
     *
     * @param javaBean qiniuCreateRoom
     * @return
     */
    @Step("7牛连麦——创建连麦房间")
    public JSONObject qiniuCreateRoom(PLJavaBean javaBean) {
        return exec("qiniuCreateRoom", javaBean);
    }

    /**
     * 7牛连麦——获得鉴权
     *
     * @param javaBean qiniuRoomToken
     * @return
     */
    @Step("7牛连麦——获得鉴权")
    public JSONObject qiniuRoomToken(PLJavaBean javaBean) {
        return exec("qiniuRoomToken", javaBean);
    }

    /**
     * 7牛连麦——连麦房间观看地址
     *
     * @param javaBean qiniuRoomUrl
     * @return
     */
    @Step("7牛连麦——连麦房间观看地址")
    public JSONObject qiniuRoomUrl(PLJavaBean javaBean) {
        return exec("qiniuRoomUrl", javaBean);
    }

    /**
     * 获得七牛连麦的APP列表
     *
     * @param javaBean rtcAppList
     * @return
     */
    @Step("获得七牛连麦的APP列表")
    public JSONObject rtcAppList(PLJavaBean javaBean) {
        return exec("rtcAppList", javaBean);
    }

    /**
     * 课堂结束，保存信息(白板服务器调用)
     *
     * @param javaBean whiteHouseEnd
     * @return
     */
    @Step("课堂结束，保存信息(白板服务器调用)")
    public JSONObject whiteHouseEnd(PLJavaBean javaBean) {
        return exec("whiteHouseEnd", javaBean);
    }

    /**
     * 查询课堂类型和资料
     *
     * @param javaBean classroomInfo
     * @return
     */
    @Step("查询课堂类型和资料")
    public JSONObject classroomInfo(PLJavaBean javaBean) {
        return exec("classroomInfo", javaBean);
    }

    /**
     * 根据课堂CODE查询正在开课的
     *
     * @param javaBean lessonByCode
     * @return
     */
    @Step("根据课堂CODE查询正在开课的")
    public JSONObject lessonByCode(PLJavaBean javaBean) {
        return exec("lessonByCode", javaBean);
    }

    /**
     * 查询是否存在正在开课的课堂
     *
     * @param javaBean notClose
     * @return
     */
    @Step("查询是否存在正在开课的课堂")
    public JSONObject notClose(PLJavaBean javaBean) {
        return exec("notClose", javaBean);
    }

    /**
     * 课堂重连
     *
     * @param javaBean reconnect
     * @return
     */
    @Step("课堂重连")
    public JSONObject reconnect(PLJavaBean javaBean) {
        return exec("reconnect", javaBean);
    }

    /**
     * 课堂进行时，截取课堂封面
     *
     * @param javaBean videoFace
     * @return
     */
    @Step("课堂进行时，截取课堂封面")
    public JSONObject videoFace(PLJavaBean javaBean) {
        return exec("videoFace", javaBean);
    }

    /**
     * PC端调用答题接口
     *
     * @param javaBean pcAnswer
     * @return
     */
    @Step("PC端调用答题接口")
    public JSONObject pcAnswer(PLJavaBean javaBean) {
        return exec("pcAnswer", javaBean);
    }

    /**
     * 课堂时间
     *
     * @param javaBean timeSwitch
     * @return
     */
    @Step("课堂时间")
    public JSONObject timeSwitch(PLJavaBean javaBean) {
        return exec("timeSwitch", javaBean);
    }

    /**
     * 获取老师当天要开得课堂列表
     *
     * @param javaBean listByToday
     * @return
     */
    @Step("获取老师当天要开得课堂列表")
    public JSONObject listByToday(PLJavaBean javaBean) {
        return exec("listByToday", javaBean);
    }

    /**
     * 获取今天课堂列表
     *
     * @param javaBean roomToday
     * @return
     */
    @Step("获取今天课堂列表")
    public JSONObject roomToday(PLJavaBean javaBean) {
        return exec("roomToday", javaBean);
    }

    /**
     * 管理员系统调用关闭课堂
     *
     * @param javaBean adminClassEnd
     * @return
     */
    @Step("管理员系统调用关闭课堂")
    public JSONObject adminClassEnd(PLJavaBean javaBean) {
        return exec("adminClassEnd", javaBean);
    }

    /**
     * 课堂中老师发起抢答
     *
     * @param javaBean answerfirst
     * @return
     */
    @Step("课堂中老师发起抢答")
    public JSONObject answerfirst(PLJavaBean javaBean) {
        return exec("answerfirst", javaBean);
    }

    /**
     * 校正用户考勤记录
     *
     * @param javaBean revise
     * @return
     */
    @Step("校正用户考勤记录")
    public JSONObject revise(PLJavaBean javaBean) {
        return exec("revise", javaBean);
    }

    /**
     * web端白板url
     *
     * @param javaBean weburl
     * @return
     */
    @Step("web端白板url")
    public JSONObject weburl(PLJavaBean javaBean) {
        return exec("weburl", javaBean);
    }

    /**
     * 未来两周的待上课节
     *
     * @param studyType 1,学生身份，2老师身份
     * @return
     */
    @Step("未来两周的待上课节")
    public JSONObject weekRoom(StudyType studyType) {
        return exec("weekRoom", Parameter.creat().add("studyType", studyType.value));
    }

    /**
     * 获取课堂用户列表
     *
     * @param javaBean roomUser
     * @return
     */
    @Step("获取课堂用户列表")
    public JSONObject roomUser(PLJavaBean javaBean) {
        return exec("roomUser", javaBean);
    }


    public enum StudyType {
        STUDENT("1"), TEACHER("2");
        public String value;

        private StudyType(String value) {
            this.value = value;
        }

        public String toString() {
            return this.value;
        }
    }

}
