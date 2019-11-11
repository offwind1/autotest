package com.mizholdings.me2.playload;

import com.mizholdings.util.PLJavaBean;
import lombok.Data;

@Data
public class PLLebu extends PLJavaBean {

    private String uniqueId;
    private String nickname;

    /**
     * url免密登陆通用接口
     *
     * @param uniqueId String, 第三方平台用户唯一id
     * @param nickname String, 用户昵称
     */
    public void setAutologin(String uniqueId, String nickname) {
        this.uniqueId = uniqueId;
        this.nickname = nickname;

    }


}