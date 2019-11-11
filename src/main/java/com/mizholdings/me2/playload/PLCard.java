package com.mizholdings.me2.playload;

import com.mizholdings.util.PLJavaBean;
import lombok.Data;

@Data
public class PLCard extends PLJavaBean {

    private String cardCode;
    private String phone;

    /**
     * 试听卡兑换
     *
     * @param cardCode string,卡号
     * @param phone    string,手机号（手机号和token必须传一个）
     */
    public void setExchange(String cardCode, String phone) {
        this.cardCode = cardCode;
        this.phone = phone;

    }


}