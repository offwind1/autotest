package com.mizholdings.kacha.mod;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.kacha.user.KCUserBase;
import com.mizholdings.kacha.interfaces.VipInterface;
import com.mizholdings.util.MODBase;
import com.mizholdings.util.PLJavaBean;
import com.mizholdings.util.Requests;
import io.qameta.allure.Step;

public class MODVip extends MODBase<MODVip> {

    public static VipInterface vipInterface = Requests.getService(VipInterface.class);

    public MODVip(KCUserBase executor) {
        super(executor);
        this.interfaced = vipInterface;
    }


    /**
     * 13.1.1 会员信息
     *
     * @param javaBean
     * @return
     */
    @Step("13.1.1 会员信息")
    public JSONObject opVipinfo(PLJavaBean javaBean) {
        return exec("opVipinfo", javaBean);
    }



    /**
     * 13.1.2 获得价格信息
     *
     * @param javaBean vip
     * @return
     */
    @Step("13.1.2 获得价格信息")
    public JSONObject opPrice(PLJavaBean javaBean) {
        return exec("opPrice", javaBean);
    }



    /**
     * 13.2.1 vip微信小程序支付
     *
     * @param javaBean vip
     * @return
     */
    @Step("13.2.1 vip微信小程序支付")
    public JSONObject opWxpay(PLJavaBean javaBean) {
        return exec("opWxpay", javaBean);
    }



}
