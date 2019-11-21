package com.mizholdings.me2.mod;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.user.Me2UserBase;
import com.mizholdings.me2.interfaces.api.CatalogInterface;
import com.mizholdings.util.MODBase;
import com.mizholdings.util.PLJavaBean;
import com.mizholdings.util.Requests;

public class MODCatalog extends MODBase<MODCatalog> {
    public static CatalogInterface catalogInterface = Requests.getService(CatalogInterface.class);

    public MODCatalog(Me2UserBase executor) {
        super(executor);
        interfaced = catalogInterface;
    }


   
/**
 * 查询用户的试题
 *
 * @param javaBean list
 * @return
 */
public JSONObject list(PLJavaBean javaBean) {
    return exec("list", javaBean);
}

/**
 * 根据试题ID查询题目
 *
 * @param javaBean quesByCatalogId
 * @return
 */
public JSONObject quesByCatalogId(PLJavaBean javaBean) {
    return exec("quesByCatalogId", javaBean);
}


}