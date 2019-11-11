package com.mizholdings.me2.playload;

import com.mizholdings.util.PLJavaBean;
import lombok.Data;

@Data
public class PLPay extends PLJavaBean {

    private String page;
    private String action;

    /**
     * @param page   int,分页，1为第一页
     * @param action int,动作(主动)：1充值，2提现，3购买，4转换，动作(被动)：5扣除，6收益，7奖励，8退回
     */
    public void setUserTrans(String page, String action) {
        this.page = page;
        this.action = action;
    }

    private String rateId;
    private String fromType;
    private String paypwd;

    /**
     * 用户充值
     *
     * @param rateId   string,充值图标ID
     * @param fromType int,充值方式，1银联，2支付宝，3微信，4米猪币
     * @param paypwd   string,支付密码
     */
    public void setUsrrecharge(String rateId, String fromType, String paypwd) {
        this.rateId = rateId;
        this.fromType = fromType;
        this.paypwd = paypwd;

    }

    private String userId;
    private String lessonId;
    private String consName;
    private String consPhone;
    private String consAddr;

    /**
     * 用户购买课程
     *
     * @param userId    long,用户ID
     * @param lessonId  string,课程ID
     * @param paypwd    string,支付密码
     * @param fromType  int,来源，1银联，2支付宝，3微信,4米猪币
     * @param consName  string,收货人
     * @param consPhone string,收货人手机号
     * @param consAddr  string,收货地址
     */
    public void setBuylesson(String userId, String lessonId, String paypwd, String fromType, String consName, String consPhone, String consAddr) {
        this.userId = userId;
        this.lessonId = lessonId;
        this.paypwd = paypwd;
        this.fromType = fromType;
        this.consName = consName;
        this.consPhone = consPhone;
        this.consAddr = consAddr;

    }

    private String coursewareId;

    /**
     * 购买资源
     *
     * @param userId       long,用户ID
     * @param coursewareId String,资源ID
     * @param paypwd       string,支付密码
     * @param fromType     int,来源，1银联，2支付宝，3微信,4米猪币
     * @param consName     string,收货人
     * @param consPhone    string,收货人手机号
     * @param consAddr     string,收货地址
     */
    public void setBuycourseware(String userId, String coursewareId, String paypwd, String fromType, String consName, String consPhone, String consAddr) {
        this.userId = userId;
        this.coursewareId = coursewareId;
        this.paypwd = paypwd;
        this.fromType = fromType;
        this.consName = consName;
        this.consPhone = consPhone;
        this.consAddr = consAddr;

    }

    private String channel;
    private String rateType;

    /**
     * 获取Ping++支付凭证
     *
     * @param rateId    string,充值标识（来源界面1=充值图标ID，购买课程=课程ID，购买资源=资源ID）
     * @param channel   string,支付渠道alipay,wx
     * @param rateType  int,充值来源界面，1充值界面充值，2课程界面充值，3课件资源界面充值,11购买课程，12购买课件
     * @param consName  string,收货人
     * @param consPhone string,收货人手机号
     * @param consAddr  string,收货地址
     */
    public void setGetpingxx(String rateId, String channel, String rateType, String consName, String consPhone, String consAddr) {
        this.rateId = rateId;
        this.channel = channel;
        this.rateType = rateType;
        this.consName = consName;
        this.consPhone = consPhone;
        this.consAddr = consAddr;

    }


    /**
     * 查询用户充值记录
     *
     * @param page   int,分页，1为第一页
     * @param action int,动作(主动)：1充值，2提现，3购买，4转换，动作(被动)：5扣除，6收益，7奖励，8退回
     */
    public void setUsertrans(String page, String action) {
        this.page = page;
        this.action = action;

    }

    private String accountId;
    private String bankUserName;
    private String bankOpen;
    private String bankAccount;
    private String verifycode;
    private String amount;

    /**
     * 提现申请
     *
     * @param accountId    int，银行账号ID，(已绑定)
     * @param bankUserName string,开户人(未绑定)
     * @param bankOpen     string,开户行(未绑定)
     * @param bankAccount  string,账号(未绑定)
     * @param verifycode   string,验证码
     * @param amount       int,提款金额
     */
    public void setDrawapply(String accountId, String bankUserName, String bankOpen, String bankAccount, String verifycode, String amount) {
        this.accountId = accountId;
        this.bankUserName = bankUserName;
        this.bankOpen = bankOpen;
        this.bankAccount = bankAccount;
        this.verifycode = verifycode;
        this.amount = amount;

    }

    private String userCode;
    private String platform;

    /**
     * 扫码支付（支付宝或微信）
     *
     * @param userCode string.用户ID加密后的字段
     * @param rateType int,充值类型，1充值界面充值，2课程界面充值，3课件资源界面充值
     * @param rateId   string,充值标识ID
     * @param platform int,来源，1苹果，2安卓，3电脑端
     */
    public void setGetpingxxscan(String userCode, String rateType, String rateId, String platform) {
        this.userCode = userCode;
        this.rateType = rateType;
        this.rateId = rateId;
        this.platform = platform;

    }

    private String applePayId;
    private String chargeId;
    private String receiptData;

    /**
     * 苹果支付成功后调用
     *
     * @param applePayId  string,充值项在applePay里的ID
     * @param chargeId    string,订单ID
     * @param receiptData string,验证支付是否成功的字段
     */
    public void setApplepayreturn(String applePayId, String chargeId, String receiptData) {
        this.applePayId = applePayId;
        this.chargeId = chargeId;
        this.receiptData = receiptData;

    }

    private String proType;

    /**
     * web微信充值
     *
     * @param userId   用户id
     * @param rateId   支付选项id
     * @param fromType 支付方式1微信2支付宝
     * @param proType  1测试2正式
     */
    public void setWebusrrecharge(String userId, String rateId, String fromType, String proType) {
        this.userId = userId;
        this.rateId = rateId;
        this.fromType = fromType;
        this.proType = proType;

    }


    /**
     * 获取微信、支付宝二维码
     *
     * @param lessonId String,课程id
     */
    public void setGetnative(String lessonId) {
        this.lessonId = lessonId;

    }

    private String convertType;
    private String amout;

    /**
     * 转换橙币，和橙时光(IOS)
     *
     * @param convertType int,1把币转为时光，2把时光转为币
     * @param amout       double,转换数量
     */
    public void setConvertamout(String convertType, String amout) {
        this.convertType = convertType;
        this.amout = amout;

    }


}
