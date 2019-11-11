package com.mizholdings.me2.playload;

import com.mizholdings.util.PLJavaBean;

public class PLInteg extends PLJavaBean {
    private String cloudUsrAccount;
    private String platform;

    /**
     * 积分增加(课堂举手，老师同意时调用)
     *
     * @param cloudUsrAccount string,云信accid
     * @param platform        int,来源，1苹果，2安卓，3电脑端
     */
    public void setExecute(String cloudUsrAccount, String platform) {
        this.cloudUsrAccount = cloudUsrAccount;
        this.platform = platform;
    }

    /**
     * 积分增加(课堂举手，老师同意时调用)
     * 默认电脑端
     *
     * @param cloudUsrAccount string,云信accid
     */
    public void setExecute(String cloudUsrAccount) {
        this.cloudUsrAccount = cloudUsrAccount;
        this.platform = "3";
    }

    /**
     * 课堂中第一次文字、图片互动
     *
     * @param cloudUsrAccount
     */
    public void setWords(String cloudUsrAccount) {
        this.cloudUsrAccount = cloudUsrAccount;
    }

}
