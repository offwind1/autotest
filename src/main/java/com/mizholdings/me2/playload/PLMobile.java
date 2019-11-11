package com.mizholdings.me2.playload;

import lombok.Data;

@Data
public class PLMobile {

    private String account;
    private String password;
    private String phone;
    private String verifycode;
    private String longitude;
    private String latitude;
    private String loginMode;
    private String userId;
    private String machine;
    private String proType;


    /**
     * @param account    string,用户账号(手机号/账号/邮箱)
     * @param password   string,登陆密码
     * @param phone      string,用户手机号(手机号/邮箱)
     * @param verifycode string,手机验证码
     * @param longitude  double,经度
     * @param latitude   double,纬度
     * @param loginMode  int,登录方式，1苹果，2安卓，3电脑端
     * @param userId     Long,用户ID，如选定用户时需要传入，不选定为Null
     * @param machine    string,用户登陆设备
     */
    public void setLogin(String account,
                         String password,
                         String phone,
                         String verifycode,
                         String longitude,
                         String latitude,
                         String loginMode,
                         String userId,
                         String machine,
                         String proType
    ) {
        this.account = account;
        this.password = password;
        this.phone = phone;
        this.verifycode = verifycode;
        this.longitude = longitude;
        this.latitude = latitude;
        this.loginMode = loginMode;
        this.userId = userId;
        this.machine = machine;
        this.proType = proType;
    }

    /**
     * 账号密码登录
     *
     * @param account  账号
     * @param password 密码
     */
    public void setLogin(String account, String password) {
        this.account = account;
        this.password = password;
        this.phone = "";
        this.verifycode = "";
        this.loginMode = "1";
        this.machine = "AUTOTEST";
        this.proType = "ykdebug";
        this.longitude = "";
        this.latitude = "";
    }

    private String type;

    /**
     * 获取验证码(手机/邮箱)
     *
     * @param phone string,手机号/或者邮箱
     * @param type  int,int 验证码类型，1注册，2找回密码，3登陆,4修改手机号,5提现申请,6绑定银行卡,7修改手机的新手机号(需要判断是否数据库已存在)8微信用户绑定手机号
     */
    public void setPhonecode(String phone, String type) {
        this.phone = phone;
        this.type = type;

    }


    /**
     * token自动登陆
     *
     * @param machine string,登陆设备
     */
    public void setTokenlogin(String machine) {
        this.machine = machine;

    }

    private String safeQuesId;
    private String quesAnswer;
    private String platform;
    private String recommandId;

    /**
     * 用户注册(手机号/账号/邮箱)
     *
     * @param account     string,账号
     * @param password    string,密码
     * @param safeQuesId  int,安全问题ID
     * @param quesAnswer  string,安全问题答案
     * @param phone       string,手机号/邮箱
     * @param verifycode  string,验证码
     * @param platform    int,来源，1苹果，2安卓，3电脑端
     * @param recommandId Long,推荐人ID（非必填）
     */
    public void setUserregister(String account, String password, String safeQuesId, String quesAnswer, String phone, String verifycode, String platform, String recommandId) {
        this.account = account;
        this.password = password;
        this.safeQuesId = safeQuesId;
        this.quesAnswer = quesAnswer;
        this.phone = phone;
        this.verifycode = verifycode;
        this.platform = platform;
        this.recommandId = recommandId;

    }


    /**
     * 忘记密码
     *
     * @param phone      string,手机号/邮箱
     * @param verifycode string,验证码
     * @param password   string,新密码
     * @param account    string,账号
     * @param safeQuesId int,安全问题ID
     * @param quesAnswer string,安全问题答案
     * @param userId     Long,用户ID，有多个用户时，需要返回此字段
     */
    public void setFindpassword(String phone, String verifycode, String password, String account, String safeQuesId, String quesAnswer, String userId) {
        this.phone = phone;
        this.verifycode = verifycode;
        this.password = password;
        this.account = account;
        this.safeQuesId = safeQuesId;
        this.quesAnswer = quesAnswer;
        this.userId = userId;

    }

    private String oldContact;
    private String newContact;
    private String newCode;

    /**
     * 修改手机号或者邮箱
     *
     * @param oldContact string,旧手机号/旧邮箱
     * @param verifycode string,旧手机验证码
     * @param newContact string,新手机号/新邮箱
     * @param type       int,1修改手机号，2修改邮箱
     * @param newCode    string,新手机验证码
     */
    public void setUpdatecontact(String oldContact, String verifycode, String newContact, String type, String newCode) {
        this.oldContact = oldContact;
        this.verifycode = verifycode;
        this.newContact = newContact;
        this.type = type;
        this.newCode = newCode;

    }

    private String nickname;
    private String birthday;
    private String age;
    private String sex;
    private String userPhone;
    private String qq;
    private String email;
    private String orgId;
    private String department;
    private String gradeId;
    private String mySign;
    private String photoPath;

    /**
     * 修改用户信息
     *
     * @param nickname   string,昵称
     * @param birthday   string,生日
     * @param age        int,年龄
     * @param sex        string,性别 M为男性, F为女性, 默认 -
     * @param userPhone  string,手机
     * @param qq         string,QQ
     * @param email      string,邮箱
     * @param orgId      int,学校/机构ID
     * @param department string,院级/部门
     * @param gradeId    int,年级ID
     * @param mySign     string,个性签名
     * @param photoPath  string，图片全路径：http://images.mizholdings.com/aaa.png
     */
    public void setUpdateuserinfo(String nickname, String birthday, String age, String sex, String userPhone, String qq, String email, String orgId, String department, String gradeId, String mySign, String photoPath) {
        this.nickname = nickname;
        this.birthday = birthday;
        this.age = age;
        this.sex = sex;
        this.userPhone = userPhone;
        this.qq = qq;
        this.email = email;
        this.orgId = orgId;
        this.department = department;
        this.gradeId = gradeId;
        this.mySign = mySign;
        this.photoPath = photoPath;

    }

    private String userCode;
    private String accid;

    /**
     * 根据用户CODE，获得云信ID
     *
     * @param userCode string,用户CODE 可选
     * @param accid    string,用户云信ID 可选
     */
    public void setUserbycode(String userCode, String accid) {
        this.userCode = userCode;
        this.accid = accid;

    }


    /**
     * 根据ID获得用户信息
     *
     * @param userId Long,用户ID
     */
    public void setUserinfobyid(String userId) {
        this.userId = userId;

    }


    /**
     * 收藏用户
     *
     * @param userId long,被收藏用户ID
     */
    public void setKeepuser(String userId) {
        this.userId = userId;

    }


    /**
     * 取消收藏
     *
     * @param userId long,被收藏用户ID
     */
    public void setRmkeepuser(String userId) {
        this.userId = userId;

    }


    /**
     * 机构用户管理的教师列表
     *
     * @param userId Long,机构用户ID
     */
    public void setOrguserlist(String userId) {
        this.userId = userId;

    }

    private String oldPassword;
    private String newPassword;

    /**
     * 用户修改密码
     *
     * @param oldPassword string,旧密码,如果没有，可以为空字符串
     * @param newPassword string,新密码
     */
    public void setUpdatepassword(String oldPassword, String newPassword) {
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;

    }


    /**
     * 用户绑定手机(验证码类型为4)
     *
     * @param phone      string,手机号
     * @param verifycode string,验证码
     */
    public void setBingphone(String phone, String verifycode) {
        this.phone = phone;
        this.verifycode = verifycode;

    }

    private String access_token;
    private String openId;

    /**
     * 第三方登陆
     *
     * @param access_token string,请求第三方获得的token
     * @param openId       string,用户唯一标识code或者UID
     * @param type         int,1QQ登陆，2微信登陆，3微博登陆
     * @param longitude    double 经度
     * @param latitude     double,纬度
     * @param loginMode    int,登录方式，1安卓，2IOS，3电脑
     * @param machine      string,登陆设备
     * @param proType      string,用户所属项目（云课、良师选、云税校）
     * @param recommandId  long,推荐人ID（非必填）
     */
    public void setOtherlogin(String access_token, String openId, String type, String longitude, String latitude, String loginMode, String machine, String proType, String recommandId) {
        this.access_token = access_token;
        this.openId = openId;
        this.type = type;
        this.longitude = longitude;
        this.latitude = latitude;
        this.loginMode = loginMode;
        this.machine = machine;
        this.proType = proType;
        this.recommandId = recommandId;

    }

    private String uflag;

    /**
     * APP扫码，登录页面端
     *
     * @param uflag string,扫到的二维码
     */
    public void setLogin2(String uflag) {
        this.uflag = uflag;

    }


    private String page;

    /**
     * 机构用户/教师的课件(微课)
     *
     * @param userId long,用户ID
     * @param page   int,页码，从1开始
     */
    public void setOrgcourselist(String userId, String page) {
        this.userId = userId;
        this.page = page;

    }


    private String recommendId;

    /**
     * 分享页面注册
     *
     * @param phone       手机号
     * @param verifycode  验证码
     * @param recommendId 推荐人id
     */
    public void setShareuserregister(String phone, String verifycode, String recommendId) {
        this.phone = phone;
        this.verifycode = verifycode;
        this.recommendId = recommendId;

    }


    /**
     * 根据手机获取用户信息
     *
     * @param phone 用户电话
     */
    public void setGetuserinfobyphone(String phone) {
        this.phone = phone;

    }

    private String mizhuTime;

    /**
     * 增加用户的米猪时光
     *
     * @param mizhuTime Double, 为用户增加的米猪时光数值
     * @param userId    Long, 用户id
     */
    public void setGetmizhutime(String mizhuTime, String userId) {
        this.mizhuTime = mizhuTime;
        this.userId = userId;

    }

    private String authen;

    /**
     * ISO系统登陆
     *
     * @param account     string,账号
     * @param password    string,密码
     * @param email       string,邮箱
     * @param longitude   double 经度
     * @param latitude    double,纬度
     * @param machine     string,登陆机型
     * @param proType     string,用户所属项目（云课、良师选、云税校）
     * @param orgId       int,机构ID
     * @param recommandId long,推荐人ID（非必填）
     * @param authen      int,用户认证状态，0未认证，1审核中，2已认证
     */
    public void setApplelogin(String account, String password, String email, String longitude, String latitude, String machine, String proType, String orgId, String recommandId, String authen) {
        this.account = account;
        this.password = password;
        this.email = email;
        this.longitude = longitude;
        this.latitude = latitude;
        this.machine = machine;
        this.proType = proType;
        this.orgId = orgId;
        this.recommandId = recommandId;
        this.authen = authen;

    }


}
