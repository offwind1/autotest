package com.mizholdings.me2.core.mod;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.core.user.Me2UserBase;
import com.mizholdings.me2.interfaces.api.FullschInterface;
import com.mizholdings.util.MODBase;
import com.mizholdings.util.PLJavaBean;
import com.mizholdings.util.Requests;

public class MODFullsch extends MODBase<MODFullsch> {
    public static FullschInterface fullschInterface = Requests.getService(FullschInterface.class);

    public MODFullsch(Me2UserBase executor) {
        super(executor);
        interfaced = fullschInterface;
    }


   
/**
 * 全文检索
 *
 * @param javaBean searchAll
 * @return
 */
public JSONObject searchAll(PLJavaBean javaBean) {
    return exec("searchAll", javaBean);
}

/**
 * 首页搜索2
 *
 * @param javaBean searchAll2
 * @return
 */
public JSONObject searchAll2(PLJavaBean javaBean) {
    return exec("searchAll2", javaBean);
}


}