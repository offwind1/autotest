package com.mizholdings.kacha.playload;

import com.mizholdings.util.PLJavaBean;

public class PLVip extends PLJavaBean {

    private String userId;

    /**
     * 13.1.1 会员信息
     *
     * @param userId：用户ID
     */
    public void setOpVipinfo(String userId) {
        this.userId = userId;

    }

    private String childId;

    /**
     * 13.1.2 获得价格信息
     *
     * @param childId：子女ID
     */
    public void setOpPrice(String childId) {
        this.childId = childId;

    }

    private String openId;
    private String price;
    private String orderDetails;

    /**
     * 13.2.1 vip微信小程序支付
     *
     * @param *openId：小程序用户ID
     * @param *childId：子女ID
     * @param *price：金额
     * @param *orderDetails（商品详情）
     */
    public void setOpWxpay(String openId, String childId, String price, String orderDetails) {
        this.openId = openId;
        this.childId = childId;
        this.price = price;
        this.orderDetails = orderDetails;

    }

}
