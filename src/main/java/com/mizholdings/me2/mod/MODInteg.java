package com.mizholdings.me2.mod;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.user.Me2UserBase;
import com.mizholdings.me2.interfaces.IntegInterface;
import com.mizholdings.util.MODBase;
import com.mizholdings.util.PLJavaBean;
import com.mizholdings.util.Requests;

/**
 * 积分
 */
public class MODInteg extends MODBase<MODInteg> {

    public static IntegInterface integInterface = Requests.getService(IntegInterface.class);

    public MODInteg(Me2UserBase executor) {
        super(executor);
        interfaced = integInterface;
    }

    /**
     * 积分增加(课堂举手，老师同意时调用)
     *
     * @param javaBean
     * @return
     */
    public JSONObject execute(PLJavaBean javaBean) {
        return exec("execute", javaBean);
    }

    /**
     * 课堂中第一次文字、图片互动
     *
     * @param javaBean
     * @return
     */
    public JSONObject words(PLJavaBean javaBean) {
        return exec("words", javaBean);
    }

}
