package com.mizholdings.me2.agent.app;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.util.*;
import io.qameta.allure.Step;

public class ClassInfoAgent extends MODBase<ClassInfoAgent> {

//    public static ClassInfoInterface classInfoInterface = Requests.getService(ClassInfoInterface.class);

    public ClassInfoAgent(User executor) {
        super(executor);
//        interfaced = classInfoInterface;
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
     * 未来两周的待上课节
     *
     * @param studyType 1,学生身份，2老师身份
     * @return
     */
    @Step("未来两周的待上课节")
    public JSONObject weekRoom(StudyType studyType) {
        return exec("weekRoom", Parameter.creat().add("studyType", studyType.value));
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


    /**
     * 根据课程ID获得课堂列表
     *
     * @return json
     */
    @Step("根据课程ID获得课堂列表")
    public JSONObject listByLessonId(Parameter parameter) {
        return exec("listByLessonId", parameter);
    }

    /**
     * 拿到课堂附加资源列表
     *
     * @return json
     */
    @Step("拿到课堂附加资源列表")
    public JSONObject optionList(Parameter parameter) {
        return exec("optionList", parameter);
    }

    /**
     * 申请开课，添加视频表信息
     *
     * @return json
     */
    @Step("申请开课，添加视频表信息")
    public JSONObject classroomStart(Parameter parameter) {
        return exec("classroomStart", parameter);
    }

    /**
     * 课堂结束，保存信息
     *
     * @return json
     */
    @Step("课堂结束，保存信息")
    public JSONObject classroomEnd(Parameter parameter) {
        return exec("classroomEnd", parameter);
    }

    /**
     * 用户加入课堂
     *
     * @return json
     */
    @Step("用户加入课堂")
    public JSONObject classroomAddUser(Parameter parameter) {
        return exec("classroomAddUser", parameter);
    }

    /**
     * 用户根据课堂CODE加入课堂
     *
     * @return json
     */
    @Step("用户根据课堂CODE加入课堂")
    public JSONObject classroomCodeAddUser(Parameter parameter) {
        return exec("classroomCodeAddUser", parameter);
    }

    /**
     * 用户退出课堂
     *
     * @return json
     */
    @Step("用户退出课堂")
    public JSONObject classroomRemoveUser(Parameter parameter) {
        return exec("classroomRemoveUser", parameter);
    }

    /**
     * 获得课堂CODE
     *
     * @return json
     */
    @Step("获得课堂CODE")
    public JSONObject getCode(Parameter parameter) {
        return exec("getCode", parameter);
    }

    /**
     * 快速开课
     *
     * @return json
     */
    @Step("快速开课")
    public JSONObject quickStart(Parameter parameter) {
        return exec("quickStart", parameter);
    }

    /**
     * 群组禁言
     *
     * @return json
     */
    @Step("群组禁言")
    public JSONObject muteTlistAll(Parameter parameter) {
        return exec("muteTlistAll", parameter);
    }

    /**
     * 回填课堂视频URL
     *
     * @return json
     */
    @Step("回填课堂视频URL")
    public JSONObject classVideo(Parameter parameter) {
        return exec("classVideo", parameter);
    }

    /**
     * 拿到课堂的课件
     *
     * @return json
     */
    @Step("拿到课堂的课件")
    public JSONObject getCourse(Parameter parameter) {
        return exec("getCourse", parameter);
    }

    /**
     * 获取7牛直播推流URL
     *
     * @return json
     */
    @Step("获取7牛直播推流URL")
    public JSONObject pushUrl(Parameter parameter) {
        return exec("pushUrl", parameter);
    }

    /**
     * 获取7牛直播观看URL
     *
     * @return json
     */
    @Step("获取7牛直播观看URL")
    public JSONObject pullUrl(Parameter parameter) {
        return exec("pullUrl", parameter);
    }

    /**
     * 课堂中用户举手
     *
     * @return json
     */
    @Step("课堂中用户举手")
    public JSONObject handsUp(Parameter parameter) {
        return exec("handsUp", parameter);
    }

    /**
     * 教师同意用户举手
     *
     * @return json
     */
    @Step("教师同意用户举手")
    public JSONObject agreeHandsUp(Parameter parameter) {
        return exec("agreeHandsUp", parameter);
    }

    /**
     * 老师点赞学生答案
     *
     * @return json
     */
    @Step("老师点赞学生答案")
    public JSONObject laudStudent(Parameter parameter) {
        return exec("laudStudent", parameter);
    }

    /**
     * 7牛连麦——创建连麦房间
     *
     * @return json
     */
    @Step("7牛连麦——创建连麦房间")
    public JSONObject qiniuCreateRoom(Parameter parameter) {
        return exec("qiniuCreateRoom", parameter);
    }

    /**
     * 7牛连麦——获得鉴权
     *
     * @return json
     */
    @Step("7牛连麦——获得鉴权")
    public JSONObject qiniuRoomToken(Parameter parameter) {
        return exec("qiniuRoomToken", parameter);
    }

    /**
     * 7牛连麦——连麦房间观看地址
     *
     * @return json
     */
    @Step("7牛连麦——连麦房间观看地址")
    public JSONObject qiniuRoomUrl(Parameter parameter) {
        return exec("qiniuRoomUrl", parameter);
    }

    /**
     * 获得七牛连麦的APP列表
     *
     * @return json
     */
    @Step("获得七牛连麦的APP列表")
    public JSONObject rtcAppList(Parameter parameter) {
        return exec("rtcAppList", parameter);
    }

    public JSONObject rtcAppList() {
        return rtcAppList(Parameter.creat());
    }

    /**
     * 课堂结束，保存信息(白板服务器调用)
     *
     * @return json
     */
    @Step("课堂结束，保存信息(白板服务器调用)")
    public JSONObject whiteHouseEnd(Parameter parameter) {
        return exec("whiteHouseEnd", parameter);
    }

    /**
     * 查询课堂类型和资料
     *
     * @return json
     */
    @Step("查询课堂类型和资料")
    public JSONObject classroomInfo(Parameter parameter) {
        return exec("classroomInfo", parameter);
    }

    /**
     * 根据课堂CODE查询正在开课的
     *
     * @return json
     */
    @Step("根据课堂CODE查询正在开课的")
    public JSONObject lessonByCode(Parameter parameter) {
        return exec("lessonByCode", parameter);
    }

    /**
     * 查询是否存在正在开课的课堂
     *
     * @return json
     */
    @Step("查询是否存在正在开课的课堂")
    public JSONObject notClose(Parameter parameter) {
        return exec("notClose", parameter);
    }

    @Step("查询是否存在正在开课的课堂")
    public JSONObject notClose() {
        return notClose(Parameter.creat());
    }

    /**
     * 课堂重连
     *
     * @return json
     */
    @Step("课堂重连")
    public JSONObject reconnect(Parameter parameter) {
        return exec("reconnect", parameter);
    }

    /**
     * 课堂进行时，截取课堂封面
     *
     * @return json
     */
    @Step("课堂进行时，截取课堂封面")
    public JSONObject videoFace(Parameter parameter) {
        return exec("videoFace", parameter);
    }

    /**
     * PC端调用答题接口
     *
     * @return json
     */
    @Step("PC端调用答题接口")
    public JSONObject pcAnswer(Parameter parameter) {
        return exec("pcAnswer", parameter);
    }

    /**
     * 课堂时间
     *
     * @return json
     */
    @Step("课堂时间")
    public JSONObject timeSwitch(Parameter parameter) {
        return exec("timeSwitch", parameter);
    }

    /**
     * 获取老师当天要开得课堂列表
     *
     * @return json
     */
    @Step("获取老师当天要开得课堂列表")
    public JSONObject listByToday(Parameter parameter) {
        return exec("listByToday", parameter);
    }

    /**
     * 获取今天课堂列表
     *
     * @return json
     */
    @Step("获取今天课堂列表")
    public JSONObject roomToday(Parameter parameter) {
        return exec("roomToday", parameter);
    }

    public JSONObject roomToday() {
        return roomToday(Parameter.creat());
    }

    /**
     * 管理员系统调用关闭课堂
     *
     * @return json
     */
    @Step("管理员系统调用关闭课堂")
    public JSONObject adminClassEnd(Parameter parameter) {
        return exec("adminClassEnd", parameter);
    }

    /**
     * 课堂中老师发起抢答
     *
     * @return json
     */
    @Step("课堂中老师发起抢答")
    public JSONObject answerfirst(Parameter parameter) {
        return exec("answerfirst", parameter);
    }

    /**
     * 校正用户考勤记录
     *
     * @return json
     */
    @Step("校正用户考勤记录")
    public JSONObject revise(Parameter parameter) {
        return exec("revise", parameter);
    }

    /**
     * web端白板url
     *
     * @return json
     */
    @Step("web端白板url")
    public JSONObject weburl(Parameter parameter) {
        return exec("weburl", parameter);
    }

    /**
     * 未来两周的待上课节
     *
     * @return json
     */
    @Step("未来两周的待上课节")
    public JSONObject weekRoom(Parameter parameter) {
        return exec("weekRoom", parameter);
    }

    /**
     * 获取课堂用户列表
     *
     * @return json
     */
    @Step("获取课堂用户列表")
    public JSONObject roomUser(Parameter parameter) {
        return exec("roomUser", parameter);
    }

    @Step("切换主讲老师-手动")
    public JSONObject switchMasterByManu(Parameter parameter) {
        return exec(Common.getMethodName(), parameter);
    }

    public JSONObject switchMasterByManu(String classroomId, String masterId) {
        return switchMasterByManu(Parameter.creat()
                .add("classroomId", classroomId)
                .add("masterId", masterId)
        );
    }


    @Step("获取课堂老师列表")
    public JSONObject getClassroomTeacher(Parameter parameter) {
        return exec(Common.getMethodName(), parameter);
    }

    public JSONObject getClassroomTeacher(String classroomId) {
        return getClassroomTeacher(Parameter.creat().add("classroomId", classroomId));
    }


}
