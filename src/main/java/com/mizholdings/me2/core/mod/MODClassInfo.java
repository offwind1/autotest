package com.mizholdings.me2.core.mod;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.core.user.Me2UserBase;
import com.mizholdings.me2.interfaces.api.ClassInfoInterface;
import com.mizholdings.util.MODBase;
import com.mizholdings.util.PLJavaBean;
import com.mizholdings.util.Requests;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;

public class MODClassInfo extends MODBase<MODClassInfo> {

    public static ClassInfoInterface classInfoInterface = Requests.getService(ClassInfoInterface.class);

    public MODClassInfo(Me2UserBase executor) {
        super(executor);
        interfaced = classInfoInterface;
    }

    /**
     * 老师点赞学生答案
     *
     * @param javaBean
     * @return
     */
    public JSONObject laudStudent(PLJavaBean javaBean) {
        return exec("laudStudent", javaBean);
    }

    /**
     * 快速开课
     *
     * @param javaBean
     * @return
     */
    @Attachment("快速开课")
    public JSONObject quickStart(PLJavaBean javaBean) {
        return exec("quickStart", javaBean);
    }

    /**
     * 课堂结束，保存信息
     *
     * @param javaBean
     * @return
     */
    public JSONObject classroomEnd(PLJavaBean javaBean) {
        return exec("classroomEnd", javaBean);
    }

    /**
     * 获得课堂CODE
     *
     * @return
     */
    public JSONObject getCode() {
        return exec("getCode");
    }


    /**
     * 根据课程ID获得课堂列表
     *
     * @param javaBean listByLessonId
     * @return
     */
    public JSONObject listByLessonId(PLJavaBean javaBean) {
        return exec("listByLessonId", javaBean);
    }

    /**
     * 拿到课堂附加资源列表
     *
     * @param javaBean optionList
     * @return
     */
    public JSONObject optionList(PLJavaBean javaBean) {
        return exec("optionList", javaBean);
    }

    /**
     * 申请开课，添加视频表信息
     *
     * @param javaBean classroomStart
     * @return
     */
    public JSONObject classroomStart(PLJavaBean javaBean) {
        return exec("classroomStart", javaBean);
    }


    /**
     * 用户加入课堂
     *
     * @param javaBean classroomAddUser
     * @return
     */
    public JSONObject classroomAddUser(PLJavaBean javaBean) {
        return exec("classroomAddUser", javaBean);
    }

    /**
     * 用户根据课堂CODE加入课堂
     *
     * @param javaBean classroomCodeAddUser
     * @return
     */
    public JSONObject classroomCodeAddUser(PLJavaBean javaBean) {
        return exec("classroomCodeAddUser", javaBean);
    }

    /**
     * 用户退出课堂
     *
     * @param javaBean classroomRemoveUser
     * @return
     */
    public JSONObject classroomRemoveUser(PLJavaBean javaBean) {
        return exec("classroomRemoveUser", javaBean);
    }


    /**
     * 群组禁言
     *
     * @param javaBean muteTlistAll
     * @return
     */
    public JSONObject muteTlistAll(PLJavaBean javaBean) {
        return exec("muteTlistAll", javaBean);
    }

    /**
     * 回填课堂视频URL
     *
     * @param javaBean classVideo
     * @return
     */
    public JSONObject classVideo(PLJavaBean javaBean) {
        return exec("classVideo", javaBean);
    }

    /**
     * 拿到课堂的课件
     *
     * @param javaBean getCourse
     * @return
     */
    public JSONObject getCourse(PLJavaBean javaBean) {
        return exec("getCourse", javaBean);
    }

    /**
     * 获取7牛直播推流URL
     *
     * @param javaBean pushUrl
     * @return
     */
    public JSONObject pushUrl(PLJavaBean javaBean) {
        return exec("pushUrl", javaBean);
    }

    /**
     * 获取7牛直播观看URL
     *
     * @param javaBean pullUrl
     * @return
     */
    public JSONObject pullUrl(PLJavaBean javaBean) {
        return exec("pullUrl", javaBean);
    }

    /**
     * 课堂中用户举手
     *
     * @param javaBean handsUp
     * @return
     */
    public JSONObject handsUp(PLJavaBean javaBean) {
        return exec("handsUp", javaBean);
    }

    /**
     * 教师同意用户举手
     *
     * @param javaBean agreeHandsUp
     * @return
     */
    public JSONObject agreeHandsUp(PLJavaBean javaBean) {
        return exec("agreeHandsUp", javaBean);
    }

    /**
     * 7牛连麦——创建连麦房间
     *
     * @param javaBean qiniuCreateRoom
     * @return
     */
    public JSONObject qiniuCreateRoom(PLJavaBean javaBean) {
        return exec("qiniuCreateRoom", javaBean);
    }

    /**
     * 7牛连麦——获得鉴权
     *
     * @param javaBean qiniuRoomToken
     * @return
     */
    public JSONObject qiniuRoomToken(PLJavaBean javaBean) {
        return exec("qiniuRoomToken", javaBean);
    }

    /**
     * 7牛连麦——连麦房间观看地址
     *
     * @param javaBean qiniuRoomUrl
     * @return
     */
    public JSONObject qiniuRoomUrl(PLJavaBean javaBean) {
        return exec("qiniuRoomUrl", javaBean);
    }

    /**
     * 获得七牛连麦的APP列表
     *
     * @param javaBean rtcAppList
     * @return
     */
    public JSONObject rtcAppList(PLJavaBean javaBean) {
        return exec("rtcAppList", javaBean);
    }

    /**
     * 课堂结束，保存信息(白板服务器调用)
     *
     * @param javaBean whiteHouseEnd
     * @return
     */
    public JSONObject whiteHouseEnd(PLJavaBean javaBean) {
        return exec("whiteHouseEnd", javaBean);
    }

    /**
     * 查询课堂类型和资料
     *
     * @param javaBean classroomInfo
     * @return
     */
    public JSONObject classroomInfo(PLJavaBean javaBean) {
        return exec("classroomInfo", javaBean);
    }

    /**
     * 根据课堂CODE查询正在开课的
     *
     * @param javaBean lessonByCode
     * @return
     */
    public JSONObject lessonByCode(PLJavaBean javaBean) {
        return exec("lessonByCode", javaBean);
    }

    /**
     * 查询是否存在正在开课的课堂
     *
     * @param javaBean notClose
     * @return
     */
    public JSONObject notClose(PLJavaBean javaBean) {
        return exec("notClose", javaBean);
    }

    /**
     * 课堂重连
     *
     * @param javaBean reconnect
     * @return
     */
    public JSONObject reconnect(PLJavaBean javaBean) {
        return exec("reconnect", javaBean);
    }

    /**
     * 课堂进行时，截取课堂封面
     *
     * @param javaBean videoFace
     * @return
     */
    public JSONObject videoFace(PLJavaBean javaBean) {
        return exec("videoFace", javaBean);
    }

    /**
     * PC端调用答题接口
     *
     * @param javaBean pcAnswer
     * @return
     */
    public JSONObject pcAnswer(PLJavaBean javaBean) {
        return exec("pcAnswer", javaBean);
    }

    /**
     * 课堂时间
     *
     * @param javaBean timeSwitch
     * @return
     */
    public JSONObject timeSwitch(PLJavaBean javaBean) {
        return exec("timeSwitch", javaBean);
    }

    /**
     * 获取老师当天要开得课堂列表
     *
     * @param javaBean listByToday
     * @return
     */
    public JSONObject listByToday(PLJavaBean javaBean) {
        return exec("listByToday", javaBean);
    }

    /**
     * 获取今天课堂列表
     *
     * @param javaBean roomToday
     * @return
     */
    public JSONObject roomToday(PLJavaBean javaBean) {
        return exec("roomToday", javaBean);
    }

    /**
     * 管理员系统调用关闭课堂
     *
     * @param javaBean adminClassEnd
     * @return
     */
    public JSONObject adminClassEnd(PLJavaBean javaBean) {
        return exec("adminClassEnd", javaBean);
    }

    /**
     * 课堂中老师发起抢答
     *
     * @param javaBean answerfirst
     * @return
     */
    public JSONObject answerfirst(PLJavaBean javaBean) {
        return exec("answerfirst", javaBean);
    }

    /**
     * 校正用户考勤记录
     *
     * @param javaBean revise
     * @return
     */
    public JSONObject revise(PLJavaBean javaBean) {
        return exec("revise", javaBean);
    }

    /**
     * web端白板url
     *
     * @param javaBean weburl
     * @return
     */
    public JSONObject weburl(PLJavaBean javaBean) {
        return exec("weburl", javaBean);
    }

    /**
     * 未来两周的待上课节
     *
     * @param javaBean weekRoom
     * @return
     */
    public JSONObject weekRoom(PLJavaBean javaBean) {
        return exec("weekRoom", javaBean);
    }

    /**
     * 获取课堂用户列表
     *
     * @param javaBean roomUser
     * @return
     */
    public JSONObject roomUser(PLJavaBean javaBean) {
        return exec("roomUser", javaBean);
    }


}
