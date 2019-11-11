package com.mizholdings.me2.core.mod;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.core.user.Me2UserBase;
import com.mizholdings.me2.interfaces.api.CompartmentInterface;
import com.mizholdings.util.MODBase;
import com.mizholdings.util.PLJavaBean;
import com.mizholdings.util.Requests;

public class MODCompartment extends MODBase<MODCompartment> {
    public static CompartmentInterface compartmentInterface = Requests.getService(CompartmentInterface.class);

    public MODCompartment(Me2UserBase executor) {
        super(executor);
        interfaced = compartmentInterface;
    }


   
/**
 * 查询省市列表
 *
 * @param javaBean list
 * @return
 */
public JSONObject list(PLJavaBean javaBean) {
    return exec("list", javaBean);
}

/**
 * 查询所有省和地市
 *
 * @param javaBean alllist
 * @return
 */
public JSONObject alllist(PLJavaBean javaBean) {
    return exec("alllist", javaBean);
}


}