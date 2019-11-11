package com.mizholdings.me2.playload;

import com.mizholdings.util.PLJavaBean;
import lombok.Data;

@Data
public class PLWebwxgetuserinfo extends PLJavaBean {

    private String code;
    private String proType;

    /**
     * 网页微信用户信息
     *
     * @param code    string,微信code
     * @param proType string,项目名
     */
    public void setWebwxgetuserinfo(String code, String proType) {
        this.code = code;
        this.proType = proType;

    }


}