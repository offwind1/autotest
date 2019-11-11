package com.mizholdings.me2.core.mod;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.core.user.Me2UserBase;
import com.mizholdings.me2.interfaces.api.HeartInterface;
import com.mizholdings.util.MODBase;
import com.mizholdings.util.PLJavaBean;
import com.mizholdings.util.Requests;

public class MODHeart extends MODBase<MODHeart> {
    public static HeartInterface heartInterface = Requests.getService(HeartInterface.class);

    public MODHeart(Me2UserBase executor) {
        super(executor);
        interfaced = heartInterface;
    }


   
/**
 * 课堂心跳
 *
 * @param javaBean classroom
 * @return
 */
public JSONObject classroom(PLJavaBean javaBean) {
    return exec("classroom", javaBean);
}


}