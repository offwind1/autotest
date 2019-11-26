package com.mizholdings.me2.agent.web;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.interfaces.web.ClassroomInterface;
import com.mizholdings.me2.interfaces.web.ItemInterface;
import com.mizholdings.util.MODBase;
import com.mizholdings.util.Parameter;
import com.mizholdings.util.Requests;
import com.mizholdings.util.User;
import io.qameta.allure.Step;

public class ItemAgent extends MODBase<ItemAgent> {


    public static ItemInterface itemInterface = Requests.getService(ItemInterface.class);

    public ItemAgent(User executor) {
        super(executor);
        interfaced = itemInterface;
    }

    @Step("查询收费列表")
    public JSONObject list() {
        return exec("list");
    }

    @Step("查询收费列表")
    public JSONObject add(String itemName, String loginTypes, String lessonIds) {
        return exec("add", Parameter.creat()
                .add("itemName", itemName)
                .add("introduce", "介绍")
                .add("loginTypes", loginTypes)
                .add("lessonIds", lessonIds));
    }


    @Step("修改收款项目")
    public JSONObject update(String itemId, String itemName, String loginTypes, String lessonIds) {
        return exec("update", Parameter.creat()
                .add("itemId", itemId)
                .add("itemName", itemName)
                .add("introduce", "介绍")
                .add("loginTypes", loginTypes)
                .add("lessonIds", lessonIds));
    }

    @Step("查询收款项目信息")
    public JSONObject getById(String itemId) {
        return exec("getById", Parameter.creat()
                .add("itemId", itemId));
    }


}
