package com.mizholdings.me2.agent.web;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.util.MODBase;
import com.mizholdings.util.Parameter;
import com.mizholdings.util.Requests;
import com.mizholdings.util.User;
import io.qameta.allure.Step;

public class ItemAgent extends MODBase<ItemAgent> {


//    public static ItemInterface itemInterface = Requests.getService(ItemInterface.class);

    public ItemAgent(User executor) {
        super(executor);
//        interfaced = itemInterface;
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

    /**
     * 查询收费列表
     *
     * @return json
     */
    @Step("查询收费列表")
    public JSONObject list(Parameter parameter) {
        return exec("list", parameter);
    }

    /**
     * 添加收款项目
     *
     * @return json
     */
    @Step("添加收款项目")
    public JSONObject add(Parameter parameter) {
        return exec("add", parameter);
    }

    /**
     * 修改收款项目
     *
     * @return json
     */
    @Step("修改收款项目")
    public JSONObject update(Parameter parameter) {
        return exec("update", parameter);
    }

    /**
     * 查询收款项目信息
     *
     * @return json
     */
    @Step("查询收款项目信息")
    public JSONObject getById(Parameter parameter) {
        return exec("getById", parameter);
    }

    /**
     * 删除收款项目
     *
     * @return json
     */
    @Step("删除收款项目")
    public JSONObject delete(Parameter parameter) {
        return exec("delete", parameter);
    }



}
