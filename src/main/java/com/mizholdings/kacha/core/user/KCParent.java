package com.mizholdings.kacha.core.user;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.kacha.core.mod.MODParenthood;
import com.mizholdings.kacha.playload.PLParenthood;
import com.mizholdings.util.Env;
import io.qameta.allure.Step;
import org.testng.Assert;

/**
 * 父母
 */
public class KCParent extends KCUserBase {
    private MODParenthood modParenthood;
    private String currentChild;

    public KCParent(String account, String password) {
        super(Env.Kacha.BLUE_PIG, account, password);
        modParenthood = new MODParenthood(this);
    }

    private PLParenthood getPl() {
        return new PLParenthood();
    }


    public String currentChild() {
        if (currentChild == null) {
            JSONObject object = getCurrentChild();
            currentChild = object.getJSONObject("data").getString("id");
        }
        return currentChild;
    }

    /**
     * 查询当前子女
     *
     * @return
     */
    public JSONObject getCurrentChild() {
        return modParenthood.currentChild();
    }

    /**
     * 获取新子女的id
     *
     * @param childName
     * @return
     */
    public String getNewChildId(String childName) {
        JSONObject object = addChild(childName);

        return object.getJSONObject("data").getString("userId");
    }

    /**
     * 添加子女
     *
     * @param childName
     */
    public JSONObject addChild(String childName) {
        PLParenthood plParenthood = getPl();
        plParenthood.setAddchild(childName);
        JSONObject addChild = modParenthood.addChild(plParenthood);
        return addChild;
    }


    /**
     * 设置当前子女
     */
    public JSONObject setCurrentChild(String childId) {
        PLParenthood plParenthood = getPl();
        plParenthood.setCurrentchild(childId);
        return modParenthood.currentChild(plParenthood);
    }

    /**
     * 删除子女
     *
     * @param childId
     * @return
     */
    public JSONObject deleteChild(String childId) {
        PLParenthood plParenthood = getPl();
        plParenthood.setDeletechild(childId);
        return modParenthood.deleteChild(plParenthood);
    }

    /**
     * 查询子女列表
     *
     * @return
     */
    public JSONObject getChilds() {
        PLParenthood plParenthood = getPl();
        plParenthood.setChilds("2019");
        return modParenthood.childs(plParenthood);
    }

    /**
     * 生成绑定码
     *
     * @param child
     * @return
     */
    public JSONObject bindCode(String child) {
        PLParenthood plParenthood = getPl();
        plParenthood.setBindcode(child);
        return modParenthood.bindCode(plParenthood);
    }

    /**
     * 通过绑定码，绑定子女
     *
     * @param code
     * @return
     */
    public JSONObject bindChild(String code) {
        PLParenthood plParenthood = getPl();
        plParenthood.setBindchild(code);
        return modParenthood.bindChild(plParenthood);
    }


}
