package com.mizholdings.me2.mod;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.user.Me2UserBase;
import com.mizholdings.me2.interfaces.api.LebuInterface;
import com.mizholdings.util.MODBase;
import com.mizholdings.util.PLJavaBean;
import com.mizholdings.util.Requests;

public class MODLebu extends MODBase<MODLebu> {
    public static LebuInterface LebuInterface = Requests.getService(LebuInterface.class);

    public MODLebu(Me2UserBase executor) {
        super(executor);
        interfaced = LebuInterface;
    }


   
/**
 * url免密登陆通用接口
 *
 * @param javaBean autoLogin
 * @return
 */
public JSONObject autoLogin(PLJavaBean javaBean) {
    return exec("autoLogin", javaBean);
}


}