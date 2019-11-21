package com.mizholdings.me2.mod;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.user.Me2UserBase;
import com.mizholdings.me2.interfaces.api.UsrauthenInterface;
import com.mizholdings.util.MODBase;
import com.mizholdings.util.PLJavaBean;
import com.mizholdings.util.Requests;

public class MODUsrauthen extends MODBase<MODUsrauthen> {
    public static UsrauthenInterface usrAuthenInterface = Requests.getService(UsrauthenInterface.class);

    public MODUsrauthen(Me2UserBase executor) {
        super(executor);
        interfaced = usrAuthenInterface;
    }


   
/**
 * 用户认证
 *
 * @param javaBean addAuthen
 * @return
 */
public JSONObject addAuthen(PLJavaBean javaBean) {
    return exec("addAuthen", javaBean);
}

/**
 * 查询用户认证列表
 *
 * @param javaBean list
 * @return
 */
public JSONObject list(PLJavaBean javaBean) {
    return exec("list", javaBean);
}


}