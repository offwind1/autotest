package com.mizholdings.me2.core.mod;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.core.user.Me2UserBase;
import com.mizholdings.me2.interfaces.api.UsrtagInterface;
import com.mizholdings.util.MODBase;
import com.mizholdings.util.PLJavaBean;
import com.mizholdings.util.Requests;

public class MODUsrtag extends MODBase<MODUsrtag> {
    public static UsrtagInterface usrTagInterface = Requests.getService(UsrtagInterface.class);

    public MODUsrtag(Me2UserBase executor) {
        super(executor);
        interfaced = usrTagInterface;
    }


   
/**
 * 查询用户标签
 *
 * @param javaBean list
 * @return
 */
public JSONObject list(PLJavaBean javaBean) {
    return exec("list", javaBean);
}

/**
 * 添加用户标签
 *
 * @param javaBean addUsrTag
 * @return
 */
public JSONObject addUsrTag(PLJavaBean javaBean) {
    return exec("addUsrTag", javaBean);
}


}