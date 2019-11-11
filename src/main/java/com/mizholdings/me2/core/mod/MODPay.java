package com.mizholdings.me2.core.mod;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.core.user.Me2UserBase;
import com.mizholdings.me2.interfaces.PayInterface;
import com.mizholdings.util.MODBase;
import com.mizholdings.util.PLJavaBean;
import com.mizholdings.util.Requests;

public class MODPay extends MODBase<MODPay> {
    public static PayInterface payInterface = Requests.getService(PayInterface.class);

    public MODPay(Me2UserBase executor) {
        super(executor);
        interfaced = payInterface;
    }


    /**
     * 获得充值图标
     *
     * @param javaBean rateList
     * @return
     */
    public JSONObject rateList(PLJavaBean javaBean) {
        return exec("rateList", javaBean);
    }

    /**
     * 用户充值
     *
     * @param javaBean usrRecharge
     * @return
     */
    public JSONObject usrRecharge(PLJavaBean javaBean) {
        return exec("usrRecharge", javaBean);
    }

    /**
     * 用户购买课程
     *
     * @param javaBean buyLesson
     * @return
     */
    public JSONObject buyLesson(PLJavaBean javaBean) {
        return exec("buyLesson", javaBean);
    }

    /**
     * 购买资源
     *
     * @param javaBean buyCourseware
     * @return
     */
    public JSONObject buyCourseware(PLJavaBean javaBean) {
        return exec("buyCourseware", javaBean);
    }

    /**
     * 获取Ping++支付凭证
     *
     * @param javaBean getPingxx
     * @return
     */
    public JSONObject getPingxx(PLJavaBean javaBean) {
        return exec("getPingxx", javaBean);
    }

    /**
     * 查询用户充值记录
     *
     * @param javaBean userTrans
     * @return
     */
    public JSONObject userTrans(PLJavaBean javaBean) {
        return exec("userTrans", javaBean);
    }

    /**
     * 获取提现账号
     *
     * @param javaBean drawAccount(删除，新接口查看“钱包”分组)
     * @return
     */
    public JSONObject drawAccount(PLJavaBean javaBean) {
        return exec("drawAccount(删除，新接口查看“钱包”分组)", javaBean);
    }

    /**
     * 提现申请
     *
     * @param javaBean drawApply(删除，新接口查看“钱包”分组)
     * @return
     */
    public JSONObject drawApply(PLJavaBean javaBean) {
        return exec("drawApply(删除，新接口查看“钱包”分组)", javaBean);
    }

    /**
     * 扫码支付（支付宝或微信）
     *
     * @param javaBean getPingxxScan
     * @return
     */
    public JSONObject getPingxxScan(PLJavaBean javaBean) {
        return exec("getPingxxScan", javaBean);
    }

    /**
     * 苹果支付成功后调用
     *
     * @param javaBean applePayReturn
     * @return
     */
    public JSONObject applePayReturn(PLJavaBean javaBean) {
        return exec("applePayReturn", javaBean);
    }

    /**
     * 获取充值图标
     *
     * @param javaBean rateListForWeb
     * @return
     */
    public JSONObject rateListForWeb(PLJavaBean javaBean) {
        return exec("rateListForWeb", javaBean);
    }

    /**
     * web微信充值
     *
     * @param javaBean webUsrRecharge
     * @return
     */
    public JSONObject webUsrRecharge(PLJavaBean javaBean) {
        return exec("webUsrRecharge", javaBean);
    }

    /**
     * 获取微信、支付宝二维码
     *
     * @param javaBean getNative
     * @return
     */
    public JSONObject getNative(PLJavaBean javaBean) {
        return exec("getNative", javaBean);
    }

    /**
     * 获得充值图标(IOS端)
     *
     * @param javaBean rateForApple
     * @return
     */
    public JSONObject rateForApple(PLJavaBean javaBean) {
        return exec("rateForApple", javaBean);
    }

    /**
     * 转换橙币，和橙时光(IOS)
     *
     * @param javaBean convertAmout
     * @return
     */
    public JSONObject convertAmout(PLJavaBean javaBean) {
        return exec("convertAmout", javaBean);
    }

}
