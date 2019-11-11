package com.mizholdings.me2.core.mod;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.core.user.Me2UserBase;
import com.mizholdings.me2.interfaces.api.SafequesInterface;
import com.mizholdings.util.MODBase;
import com.mizholdings.util.PLJavaBean;
import com.mizholdings.util.Requests;

public class MODSafeques extends MODBase<MODSafeques> {
    public static SafequesInterface safeQuesInterface = Requests.getService(SafequesInterface.class);

    public MODSafeques(Me2UserBase executor) {
        super(executor);
        interfaced = safeQuesInterface;
    }


   
/**
 * 安全问题列表
 *
 * @param javaBean list
 * @return
 */
public JSONObject list(PLJavaBean javaBean) {
    return exec("list", javaBean);
}


}