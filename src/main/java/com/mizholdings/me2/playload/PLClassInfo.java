package com.mizholdings.me2.playload;

import com.mizholdings.util.PLJavaBean;
import lombok.Data;

@Data
public class PLClassInfo extends PLJavaBean {

    private String classroomId;
    private String userIds;
    private String accountIds;
    private String interaction;
    private String isopenHeat;
    private String anonymous;
    private String appId;
    private String recorded;
    private String classroomName;
    private String classroomCode;
    private String classroomChannel;
    private String classroomVideoId;
    private String cloudAccount;

    /**
     * 老师点赞学生答案
     *
     * @param classroomId string,课堂ID
     * @param accountIds  string,被点赞的学生云信ID集合(和userIds两者必须选择其中一个)
     */
    public void setLaudStudentByAccountIds(String classroomId, String accountIds) {
        this.classroomId = classroomId;
        this.accountIds = accountIds;
    }

    /**
     * 老师点赞学生答案
     *
     * @param classroomId string,课堂ID
     * @param userIds     string,被点赞的学生ID集合(和accountIds两者必须选择其中一个)
     */
    public void setLaudStudentByUserIds(String classroomId, String userIds) {
        this.classroomId = classroomId;
        this.userIds = userIds;
    }

    /**
     * 快速开课
     *
     * @param classroomCode
     */
    public void setQuickStart(String classroomCode) {
        this.classroomName = "接口测试课";
        this.classroomCode = classroomCode;
        this.interaction = "4";
        this.isopenHeat = "1";
        this.anonymous = "0";
        this.appId = "dkzp6zxxh";
        this.recorded = "1";
        this.classroomChannel = "1";
    }

    /**
     * 课堂结束，保存信息
     *
     * @param classroomVideoId
     * @param cloudAccount
     */
    public void setClassroomEnd(String classroomVideoId, String cloudAccount) {
        this.classroomVideoId = classroomVideoId;
        this.cloudAccount = cloudAccount;
    }

    private String lessonId;

    /**
     * 根据课程ID获得课堂列表
     *
     * @param lessonId string,课程ID
     */
    public void setListbylessonid(String lessonId) {
        this.lessonId = lessonId;

    }


    /**
     * 拿到课堂附加资源列表
     *
     * @param classroomId string,课堂ID
     */
    public void setOptionlist(String classroomId) {
        this.classroomId = classroomId;

    }

    private String vs;
    private String channel;

    /**
     * 申请开课，添加视频表信息
     *
     * @param classroomId string,课堂ID
     * @param isopenHeat  int,是否开启心跳，0开启，1不开启
     * @param vs          int,0可以开课，1不能开课(版本限制能不能开直播课)
     * @param appId       String,七牛连麦时使用APPID
     * @param recorded    int,是否录制，1录制，2不录制,默认不录制
     * @param channel     int,开课渠道,1安卓，2苹果，3PC端，4WEB端
     */
    public void setClassroomstart(String classroomId, String isopenHeat, String vs, String appId, String recorded, String channel) {
        this.classroomId = classroomId;
        this.isopenHeat = isopenHeat;
        this.vs = vs;
        this.appId = appId;
        this.recorded = recorded;
        this.channel = channel;

    }


    /**
     * 课堂结束，保存信息
     *
     * @param classroomVideoId string,视频ID
     * @param cloudAccount     string,老师云信账号(token无效时使用)
     */
    public void setClassroomend(String classroomVideoId, String cloudAccount) {
        this.classroomVideoId = classroomVideoId;
        this.cloudAccount = cloudAccount;

    }

    private String userId;

    /**
     * 用户加入课堂
     *
     * @param classroomId string,课程ID
     * @param userId      long,用户ID
     */
    public void setClassroomadduser(String classroomId, String userId) {
        this.classroomId = classroomId;
        this.userId = userId;

    }


    /**
     * 用户根据课堂CODE加入课堂
     *
     * @param classroomCode string,课程CODE
     * @param userId        long,用户ID
     */
    public void setClassroomcodeadduser(String classroomCode, String userId) {
        this.classroomCode = classroomCode;
        this.userId = userId;

    }


    /**
     * 用户退出课堂
     *
     * @param classroomId string,课程ID
     * @param userId      long,用户ID
     */
    public void setClassroomremoveuser(String classroomId, String userId) {
        this.classroomId = classroomId;
        this.userId = userId;

    }


    /**
     * 快速开课
     *
     * @param classroomName string,课堂名称
     * @param classroomCode string,课堂CODE
     * @param interaction   int,互动方式：0双向音视频、1单向音视频、2无音视频,3全屏推流,4音视频连麦,5七牛单向视频,9.CC的直播课类型
     * @param isopenHeat    是否开启心跳，0开启，1不开启
     * @param anonymous     int,讲师是否匿名，0匿名，1不匿名
     * @param vs            int,0可以开课，1不能开课(版本限制能不能开直播课)
     * @param appId         String,七牛连麦时使用APPID
     * @param recorded      int, 是否录制，1录制，2不录制,默认不录制
     * @param channel       int,开课渠道,1安卓，2苹果，3PC端，4WEB端
     */
    public void setQuickstart(String classroomName, String classroomCode, String interaction, String isopenHeat, String anonymous, String vs, String appId, String recorded, String channel) {
        this.classroomName = classroomName;
        this.classroomCode = classroomCode;
        this.interaction = interaction;
        this.isopenHeat = isopenHeat;
        this.anonymous = anonymous;
        this.vs = vs;
        this.appId = appId;
        this.recorded = recorded;
        this.channel = channel;

    }


    private String tid;
    private String mute;

    /**
     * 群组禁言
     *
     * @param tid  string,网易群ID
     * @param mute int, 禁言标识，0解禁，1禁言
     */
    public void setMutetlistall(String tid, String mute) {
        this.tid = tid;
        this.mute = mute;

    }

    private String videoPath;
    private String faceImg;

    /**
     * 回填课堂视频URL
     *
     * @param classroomVideoId string,视频ID
     * @param videoPath        string,视频URL
     * @param faceImg          string,封面的URL
     */
    public void setClassvideo(String classroomVideoId, String videoPath, String faceImg) {
        this.classroomVideoId = classroomVideoId;
        this.videoPath = videoPath;
        this.faceImg = faceImg;

    }


    /**
     * 拿到课堂的课件
     *
     * @param classroomId string,课堂ID
     */
    public void setGetcourse(String classroomId) {
        this.classroomId = classroomId;

    }

    private String streamKey;

    /**
     * 获取7牛直播观看URL
     *
     * @param streamKey string,直播流key
     */
    public void setPullurl(String streamKey) {
        this.streamKey = streamKey;

    }

    private String cloudUsrAccount;

    /**
     * 课堂中用户举手
     *
     * @param classroomId     string,课堂ID
     * @param cloudUsrAccount string,用户云信ID
     */
    public void setHandsup(String classroomId, String cloudUsrAccount) {
        this.classroomId = classroomId;
        this.cloudUsrAccount = cloudUsrAccount;

    }


    /**
     * 教师同意用户举手
     *
     * @param classroomId     string,课堂ID
     * @param cloudUsrAccount string,云信ID
     */
    public void setAgreehandsup(String classroomId, String cloudUsrAccount) {
        this.classroomId = classroomId;
        this.cloudUsrAccount = cloudUsrAccount;

    }


    /**
     * 老师点赞学生答案
     *
     * @param classroomId string,课堂ID
     * @param userIds     string,被点赞的学生ID集合(和accountIds两者必须选择其中一个)
     * @param accountIds  string,被点赞的学生云信ID集合(和userIds两者必须选择其中一个)
     */
    public void setLaudstudent(String classroomId, String userIds, String accountIds) {
        this.classroomId = classroomId;
        this.userIds = userIds;
        this.accountIds = accountIds;

    }

    private String roomName;
    private String userType;

    /**
     * 7牛连麦——获得鉴权
     *
     * @param roomName string,房间ID
     * @param userId   string,用户ID
     * @param userType int,用户权限：1管理员，2普通用户
     */
    public void setQiniuroomtoken(String roomName, String userId, String userType) {
        this.roomName = roomName;
        this.userId = userId;
        this.userType = userType;

    }


    /**
     * 7牛连麦——连麦房间观看地址
     *
     * @param roomName string,连麦房间ID
     */
    public void setQiniuroomurl(String roomName) {
        this.roomName = roomName;

    }


    /**
     * 课堂结束，保存信息(白板服务器调用)
     *
     * @param classroomId String,课堂ID
     */
    public void setWhitehouseend(String classroomId) {
        this.classroomId = classroomId;

    }


    /**
     * 查询课堂类型和资料
     *
     * @param classroomCode string,课堂CODE
     * @param classroomId   string,课堂ID
     */
    public void setClassroominfo(String classroomCode, String classroomId) {
        this.classroomCode = classroomCode;
        this.classroomId = classroomId;

    }


    /**
     * 根据课堂CODE查询正在开课的
     *
     * @param classroomCode string,课堂CODE
     */
    public void setLessonbycode(String classroomCode) {
        this.classroomCode = classroomCode;

    }


    /**
     * 课堂重连
     *
     * @param classroomId string,课堂ID
     * @param vs          int,0可以开课，1不能开课(版本限制能不能开直播课)
     * @param appId       String,七牛连麦时使用APPID
     */
    public void setReconnect(String classroomId, String vs, String appId) {
        this.classroomId = classroomId;
        this.vs = vs;
        this.appId = appId;

    }


    /**
     * 课堂进行时，截取课堂封面
     *
     * @param classroomId      string,课堂ID
     * @param classroomVideoId string,课堂视频ID
     */
    public void setVideoface(String classroomId, String classroomVideoId) {
        this.classroomId = classroomId;
        this.classroomVideoId = classroomVideoId;

    }

    private String roomGroupId;
    private String answerType;
    private String questionIds;

    /**
     * PC端调用答题接口
     *
     * @param roomGroupId string,聊天室ID
     * @param answerType  int,开始/结束答题，1开始，0结束
     * @param questionIds string,题目ID集合，逗号分隔(开始答题时必传)
     */
    public void setPcanswer(String roomGroupId, String answerType, String questionIds) {
        this.roomGroupId = roomGroupId;
        this.answerType = answerType;
        this.questionIds = questionIds;

    }

    private String type;

    /**
     * 课堂时间
     *
     * @param classroomId string,课堂ID
     * @param type        int,课堂状态1.开始，2暂停
     */
    public void setTimeswitch(String classroomId, String type) {
        this.classroomId = classroomId;
        this.type = type;

    }

    /**
     * 管理员系统调用关闭课堂
     *
     * @param classroomId string,课堂ID
     */
    public void setAdminclassend(String classroomId) {
        this.classroomId = classroomId;

    }

    private String studentId;

    /**
     * 课堂中老师发起抢答
     *
     * @param classroomId string,课堂ID
     * @param studentId   long,学生ID（如学生抢答填入此字段）
     */
    public void setAnswerfirst(String classroomId, String studentId) {
        this.classroomId = classroomId;
        this.studentId = studentId;

    }

    private String revJson;

    /**
     * 校正用户考勤记录
     *
     * @param revJson JSON对象，[{ 	"userId": "1223", 	"lessonId": "37b313564f5e46ceb543bb5733b305a5", 	"classroomId": "a7520b2f61cd44debeada983991dd823", 	"checkTime": "2018-11-13 15:27:52" }, { 	"userId": "1223", 	"lessonId": "37b313564f5e46ceb543bb5733b305a5", 	"classroomId": "a7520b2f61cd44debeada983991dd823", 	"checkTime": "2018-11-13 15:27:52" }]
     */
    public void setRevise(String revJson) {
        this.revJson = revJson;

    }

    private String weburl;

    /**
     * web端白板url
     *
     * @param classroomId string,课堂ID
     * @param weburl      string,web端白板URL
     */
    public void setWeburl(String classroomId, String weburl) {
        this.classroomId = classroomId;
        this.weburl = weburl;

    }

    private String studyType;

    /**
     * 未来两周的待上课节
     *
     * @param studyType int, 1,学生身份，2老师身份
     */
    public void setWeekroom(String studyType) {
        this.studyType = studyType;

    }


    /**
     * 获取课堂用户列表
     *
     * @param classroomId string,课堂ID
     */
    public void setRoomuser(String classroomId) {
        this.classroomId = classroomId;

    }


}
