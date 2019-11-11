package com.mizholdings.me2.core.mod;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.core.user.Me2UserBase;
import com.mizholdings.me2.interfaces.AdvertInterface;
import com.mizholdings.me2.interfaces.api.ClassInfoInterface;
import com.mizholdings.util.MODBase;
import com.mizholdings.util.PLJavaBean;
import com.mizholdings.util.Requests;

public class MODAdvert extends MODBase<MODAdvert> {
    public static AdvertInterface advertInterface = Requests.getService(AdvertInterface.class);

    public MODAdvert(Me2UserBase executor) {
        super(executor);
        interfaced = advertInterface;
    }


    /**
     * 获取弹窗广告
     *
     * @param  javaBean getAlertAdvert
     * @return
     */
    public JSONObject getAlertAdvert(PLJavaBean javaBean) {
        return exec("getAlertAdvert", javaBean);
    }


    /**
     * 广告列表
     *
     * @param javaBean list
     * @return
     */
    public JSONObject list(PLJavaBean javaBean) {
        return exec("list", javaBean);
    }

    /**
     * 添加广告
     *
     * @param javaBean add
     * @return
     */
    public JSONObject add(PLJavaBean javaBean) {
        return exec("add", javaBean);
    }

    /**
     * 根据ID拿到广告详情
     *
     * @param javaBean getAdvertById
     * @return
     */
    public JSONObject getAdvertById(PLJavaBean javaBean) {
        return exec("getAdvertById", javaBean);
    }

    /**
     * 广告编辑
     *
     * @param javaBean edit
     * @return
     */
    public JSONObject edit(PLJavaBean javaBean) {
        return exec("edit", javaBean);
    }

    /**
     * 删除广告
     *
     * @param javaBean del
     * @return
     */
    public JSONObject del(PLJavaBean javaBean) {
        return exec("del", javaBean);
    }



}
