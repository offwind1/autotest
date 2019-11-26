package com.mizholdings.me2.agent.app;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.user.Me2UserBase;
import com.mizholdings.me2.interfaces.api.CardInterface;
import com.mizholdings.util.MODBase;
import com.mizholdings.util.PLJavaBean;
import com.mizholdings.util.Requests;
import com.mizholdings.util.User;

public class CardAgent extends MODBase<CardAgent> {
    public static CardInterface cardInterface = Requests.getService(CardInterface.class);

    public CardAgent(User executor) {
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