package com.mizholdings.kacha.core;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.kacha.interfaces.ParenthoodInterface;
import com.mizholdings.util.Env;
import com.mizholdings.util.Requests;

/**
 * 父母
 */
public class Parent extends User {

    ParenthoodInterface parenthoodInterface = Requests.getService(ParenthoodInterface.class);

    public Parent(String account, String password) {
        super(Env.Kacha.BLUE_PIG, account, password);
    }

    /**
     * 3.1.1 子女列表
     *
     * @return
     */
    public JSONObject getChilds() {
        return Requests.getJson(parenthoodInterface.getChilds(token, "2019"));
    }

    /**
     * 3.1.2 添加子女
     *
     * @param name
     * @return
     */
    public JSONObject addChild(String name) {
        return Requests.getJson(parenthoodInterface.addChilds(token, name));
    }

    /**
     * 3.1.3 修改子女姓名
     *
     * @param childId
     * @param name
     * @return
     */
    public JSONObject updateChild(String childId, String name) {
        return Requests.getJson(parenthoodInterface.updateChild(token, childId, name));
    }

    /**
     * 3.1.4 解除亲子关系
     *
     * @param childId
     * @return
     */
    public JSONObject deleteChild(String childId) {
        return Requests.getJson(parenthoodInterface.deleteChild(token, childId));
    }

    /**
     * 3.2.1 亲子绑定码
     *
     * @param childId
     * @return
     */
    public JSONObject bindCode(String childId) {
        return Requests.getJson(parenthoodInterface.bindCode(token, childId));
    }

    /**
     * 3.2.2 亲子绑定
     *
     * @param code
     * @return
     */
    public JSONObject bindChild(String code) {
        return Requests.getJson(parenthoodInterface.bindChild(token, code));
    }

    /**
     * 3.3.1 当前子女
     *
     * @param childId
     * @return
     */
    public JSONObject setCurrentChild(String childId) {
        return Requests.getJson(parenthoodInterface.setCurrentChild(token, childId));
    }

    /**
     * 3.3.2 获取当前子女
     *
     * @param childId
     * @return
     */
    public JSONObject getCurrentChild() {
        return Requests.getJson(parenthoodInterface.getCurrentChild(token));
    }


}
