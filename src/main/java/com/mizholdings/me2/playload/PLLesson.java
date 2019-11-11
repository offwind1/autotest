package com.mizholdings.me2.playload;

import com.mizholdings.util.PLJavaBean;

public class PLLesson extends PLJavaBean {


    private String accountStr;
    private String stuId;
    private String userIds;


    public void setUserListByAccount(String accountStr) {
        this.accountStr = accountStr;

    }

    public void setJoinClassByUserId(String userIds, String stuId) {
        this.userIds = userIds;
        this.stuId = stuId;

    }


}
