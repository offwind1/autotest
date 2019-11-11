package com.mizholdings.me2.core.mod;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.core.user.Me2UserBase;
import com.mizholdings.me2.interfaces.web.WebUsrInterface;
import com.mizholdings.util.MODBase;
import com.mizholdings.util.PLJavaBean;
import com.mizholdings.util.Requests;

public class MODWebUsr extends MODBase<MODWebUsr> {
    public static WebUsrInterface webUsrInterface = Requests.getService(WebUsrInterface.class);

    public MODWebUsr(Me2UserBase executor) {
        super(executor);
        interfaced = webUsrInterface;
    }


    /**
     * 查询用户充值记录
     *
     * @param javaBean
     * @return
     */
    public JSONObject editUser(PLJavaBean javaBean) {
        return exec("editUser", javaBean);
    }
}
