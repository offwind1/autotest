package com.mizholdings.me2.core.mod;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.core.user.Me2UserBase;
import com.mizholdings.me2.interfaces.api.UsrcollInterface;
import com.mizholdings.util.MODBase;
import com.mizholdings.util.PLJavaBean;
import com.mizholdings.util.Requests;

public class MODUsrcoll extends MODBase<MODUsrcoll> {
    public static UsrcollInterface usrCollInterface = Requests.getService(UsrcollInterface.class);

    public MODUsrcoll(Me2UserBase executor) {
        super(executor);
        interfaced = usrCollInterface;
    }


   
/**
 * 用户收藏列表
 *
 * @param javaBean list
 * @return
 */
public JSONObject list(PLJavaBean javaBean) {
    return exec("list", javaBean);
}


}