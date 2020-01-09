package com.mizholdings.me2.agent.web;

import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mizholdings.util.*;
import io.qameta.allure.Step;

public class ItemAgent extends MODBase<ItemAgent> {


//    public static ItemInterface itemInterface = Requests.getService(ItemInterface.class);

    public ItemAgent(User executor) {
        super(executor);
//        interfaced = itemInterface;
    }

    @Step("查询收费列表")
    public JSONObject list() {
        return exec("list", Parameter.creat()
                .add("page", "1")
                .add("pageSize", "10")
        );
    }

    @Step("添加收款项目")
    public JSONObject add(String itemName, String loginTypes, String lessonIds) {
        return exec("add", Parameter.creat()
                .add("itemName", itemName)
                .add("introduce", "介绍")
                .add("loginTypes", loginTypes)
                .add("lessonIds", lessonIds));
    }

    private JSONArray lessonIdJson(String lessonIds) {
        JSONArray array = new JSONArray();

        int seq = 0;
        for (String lessonId : lessonIds.split(",")) {
            JSONObject object = new JSONObject();
            object.put("lessonId", lessonId);
            object.put("required", 0);
            object.put("seq", seq++);
            array.add(object);
        }
        return array;
    }

    public JSONObject add(String lessonIds) {
        return add(lessonIds, null);
    }

    public JSONObject add(String lessonIds, JSONArray itemDiscount) {
        String itemDiscountJson = "";
        if (ObjectUtil.isNotNull(itemDiscount)) {
            itemDiscountJson = itemDiscount.toJSONString();
        }

        return exec("add", Parameter.creat()
                .add("itemName", Common.getNowTime())
                .add("introduce", "介绍")
                .add("loginTypes", "2,3")
                .add("lessonIdJson", lessonIdJson(lessonIds).toJSONString())
                .add("itemDiscountJson", itemDiscountJson)
        );
    }


    @Step("修改收款项目")
    public JSONObject update(String itemId, String itemName, String loginTypes, String lessonIdJson, String itemDiscountJson) {
        return exec("update", Parameter.creat()
                .add("itemId", itemId)
                .add("itemName", itemName)
                .add("introduce", "介绍")
                .add("loginTypes", loginTypes)
                .add("lessonIdJson", lessonIdJson)
                .add("itemDiscountJson", itemDiscountJson)
        );
    }

    public JSONObject update(String itemId, String lessonIds) {
        return update(itemId, Common.getNowTime(), "2,3", lessonIdJson(lessonIds).toJSONString(), "");
    }

    public JSONObject update(String itemId, String lessonIds, JSONArray itemDiscountJson) {
        return update(itemId, Common.getNowTime(), "2,3", lessonIdJson(lessonIds).toJSONString(), itemDiscountJson.toJSONString());
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

    public JSONObject delete(String itemId) {
        return delete(Parameter.creat().add("itemId", itemId));
    }


}
