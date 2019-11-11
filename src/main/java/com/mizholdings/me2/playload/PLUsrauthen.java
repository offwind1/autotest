package com.mizholdings.me2.playload;

import com.mizholdings.util.PLJavaBean;
import lombok.Data;

@Data
public class PLUsrauthen extends PLJavaBean {

    private String cardPhoto;
    private String userPhoto;
    private String cardNum;
    private String userName;

    /**
     * 用户认证
     *
     * @param cardPhoto string,身份证照片ID集合，用“，”隔开
     * @param userPhoto string,教师证照片
     * @param cardNum   string,身份证号
     * @param userName  string,用户真实姓名
     */
    public void setAddauthen(String cardPhoto, String userPhoto, String cardNum, String userName) {
        this.cardPhoto = cardPhoto;
        this.userPhoto = userPhoto;
        this.cardNum = cardNum;
        this.userName = userName;

    }


}