package com.mizholdings.me2.agent.app;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.user.Me2UserBase;
import com.mizholdings.me2.interfaces.IntegInterface;
import com.mizholdings.util.*;

/**
 * 积分
 */
public class IntegAgent extends MODBase<IntegAgent> {

    public static IntegInterface integInterface = Requests.getService(IntegInterface.class);

    public IntegAgent(User executor) {
        super(executor);
        interfaced = integInterface;
    }

    /**
     * 积分增加(课堂举手，老师同意时调用)
     *
     * @param cloudUsrAccount 云信accid
     * @return
     */
    public JSONObject execute(String cloudUsrAccount) {
        return exec("execute", Parameter.creat()
                .add("cloudUsrAccount", cloudUsrAccount));
    }

    /**
     * 课堂中第一次文字、图片互动
     *
     * @param cloudUsrAccount 云信accid
     * @return
     */
    public JSONObject words(String cloudUsrAccount) {
        return exec("words", Parameter.creat().add("cloudUsrAccount", cloudUsrAccount));
    }

}
