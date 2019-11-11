package com.mizholdings.me2.core.mod;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.core.user.Me2UserBase;
import com.mizholdings.me2.interfaces.api.CardInterface;
import com.mizholdings.util.MODBase;
import com.mizholdings.util.PLJavaBean;
import com.mizholdings.util.Requests;

public class MODCard extends MODBase<MODCard> {
    public static CardInterface cardInterface = Requests.getService(CardInterface.class);

    public MODCard(Me2UserBase executor) {
        super(executor);
        interfaced = cardInterface;
    }


   
/**
 * 试听卡兑换
 *
 * @param javaBean exchange
 * @return
 */
public JSONObject exchange(PLJavaBean javaBean) {
    return exec("exchange", javaBean);
}


}