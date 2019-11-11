package com.mizholdings.me2.playload;

import com.mizholdings.util.PLJavaBean;
import lombok.Data;

@Data
public class PLBank extends PLJavaBean {

    private String paypwd;

    /**
     * 设置支付密码
     *
     * @param paypwd string,支付密码
     */
    public void setPaypwd(String paypwd) {
        this.paypwd = paypwd;

    }

    private String accountId;
    private String amount;

    /**
     * 申请提现
     *
     * @param accountId int,账户ID
     * @param amount    int,提款金额
     * @param paypwd    string,支付密码
     */
    public void setDrawapply(String accountId, String amount, String paypwd) {
        this.accountId = accountId;
        this.amount = amount;
        this.paypwd = paypwd;

    }


    private String bankId;
    private String userName;
    private String bankAccount;
    private String verifycode;

    /**
     * 绑定银行卡
     *
     * @param bankId      int,银行ID
     * @param userName    string,开户人姓名
     * @param bankAccount string,银行账号
     * @param verifycode  string,手机验证码
     */
    public void setBinding(String bankId, String userName, String bankAccount, String verifycode) {
        this.bankId = bankId;
        this.userName = userName;
        this.bankAccount = bankAccount;
        this.verifycode = verifycode;

    }


    /**
     * 解除银行卡绑定
     *
     * @param accountId int,银行账户ID
     * @param paypwd    string,支付密码
     */
    public void setRmbinding(String accountId, String paypwd) {
        this.accountId = accountId;
        this.paypwd = paypwd;

    }


}