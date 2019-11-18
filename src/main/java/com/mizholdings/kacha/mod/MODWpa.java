package com.mizholdings.kacha.mod;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.kacha.user.KCUserBase;
import com.mizholdings.kacha.interfaces.WpaInterface;
import com.mizholdings.util.MODBase;
import com.mizholdings.util.PLJavaBean;
import com.mizholdings.util.Requests;
import io.qameta.allure.Step;

public class MODWpa extends MODBase<MODWpa> {

    public static WpaInterface wpaInterface = Requests.getService(WpaInterface.class);

    public MODWpa(KCUserBase executor) {
        super(executor);
        this.interfaced = wpaInterface;
    }


    /**
     * 17.1.1 查询关注班级事件
     *
     * @param javaBean wpa
     * @return
     */
    @Step("17.1.1 查询关注班级事件")
    public JSONObject mappScanClass(PLJavaBean javaBean) {
        return exec("mappScanClass", javaBean);
    }


    /**
     * 17.1.2 消费关注班级事件
     *
     * @param javaBean wpa
     * @return
     */
    @Step("17.1.2 消费关注班级事件")
    public JSONObject mappScanConsume(PLJavaBean javaBean) {
        return exec("mappScanConsume", javaBean);
    }


    /**
     * 17.1.3 微信公众号班级二维码
     *
     * @param javaBean wpa
     * @return
     */
    @Step("17.1.3 微信公众号班级二维码")
    public JSONObject weixinWxcode(PLJavaBean javaBean) {
        return exec("weixinWxcode", javaBean);
    }


}
