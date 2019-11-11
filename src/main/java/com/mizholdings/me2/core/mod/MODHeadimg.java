package com.mizholdings.me2.core.mod;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.core.user.Me2UserBase;
import com.mizholdings.me2.interfaces.api.HeadimgInterface;
import com.mizholdings.util.MODBase;
import com.mizholdings.util.PLJavaBean;
import com.mizholdings.util.Requests;

public class MODHeadimg extends MODBase<MODHeadimg> {
    public static HeadimgInterface headImgInterface = Requests.getService(HeadimgInterface.class);

    public MODHeadimg(Me2UserBase executor) {
        super(executor);
        interfaced = headImgInterface;
    }


   
/**
 * 头像列表
 *
 * @param javaBean list
 * @return
 */
public JSONObject list(PLJavaBean javaBean) {
    return exec("list", javaBean);
}


}