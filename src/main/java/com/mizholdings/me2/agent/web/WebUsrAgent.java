package com.mizholdings.me2.agent.web;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.interfaces.web.UsrInterface;
import com.mizholdings.me2.user.Me2UserBase;
import com.mizholdings.util.MODBase;
import com.mizholdings.util.Parameter;
import com.mizholdings.util.Requests;
import com.mizholdings.util.User;
import io.qameta.allure.Step;

public class WebUsrAgent extends MODBase<WebUsrAgent> {


    public static UsrInterface usrInterface = Requests.getService(UsrInterface.class);

    public WebUsrAgent(User executor) {
        super(executor);
        interfaced = usrInterface;
    }

    @Step("机构删除用户")
    public JSONObject orgDelTeacher(String jigou_userId, String teacherId) {
        return exec("orgDelTeacher", Parameter.creat()
                .add("teacherId", teacherId)
                .add("orgId", jigou_userId));
    }

    @Step("检验老师是否注册")
    public JSONObject checkTeacher(String phone) {
        return exec("checkTeacher", Parameter.creat().add("phone", phone));
    }

    public JSONObject orgDelTeacher(String teacherId) {
        return orgDelTeacher(executor.getUserId(), teacherId);
    }

    @Step("获取用户学分")
    public JSONObject getUserCreditId() {
        return exec("getUserCreditId");
    }


}
