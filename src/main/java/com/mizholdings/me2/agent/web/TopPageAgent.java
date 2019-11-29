package com.mizholdings.me2.agent.web;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.interfaces.mizhumanage.ChanadvInterface;
import com.mizholdings.me2.interfaces.web.ToppageInterface;
import com.mizholdings.util.MODBase;
import com.mizholdings.util.Parameter;
import com.mizholdings.util.Requests;
import com.mizholdings.util.User;
import io.qameta.allure.Step;

public class TopPageAgent extends MODBase<TopPageAgent> {

    public static ToppageInterface toppageInterface = Requests.getService(ToppageInterface.class);

    public TopPageAgent(User executor) {
        super(executor);
        interfaced = toppageInterface;
    }


    @Step("推荐内容topPage/recommend")
    public JSONObject recommend(String topId, String topType, String id, String listOrdery) {
        return exec("recommend", Parameter.creat()
                .add("topId", "").add("topType", topType).add("lessonId", id).add("listOrdery", listOrdery)
        );
    }


}
