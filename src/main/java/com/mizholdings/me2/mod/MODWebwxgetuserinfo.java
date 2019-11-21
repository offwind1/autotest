package com.mizholdings.me2.mod;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.user.Me2UserBase;
import com.mizholdings.me2.interfaces.api.WebwxgetuserinfoInterface;
import com.mizholdings.util.MODBase;
import com.mizholdings.util.PLJavaBean;
import com.mizholdings.util.Requests;

public class MODWebwxgetuserinfo extends MODBase<MODWebwxgetuserinfo> {
    public static WebwxgetuserinfoInterface webWxGetUserInfoInterface = Requests.getService(WebwxgetuserinfoInterface.class);

    public MODWebwxgetuserinfo(Me2UserBase executor) {
        super(executor);
        interfaced = webWxGetUserInfoInterface;
    }


    /**
     * 网页微信用户信息
     *
     * @param javaBean webWxGetUserInfo
     * @return
     */
    public JSONObject webWxGetUserInfo(PLJavaBean javaBean) {
        return exec("webWxGetUserInfo", javaBean);
    }


}