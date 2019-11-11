package com.mizholdings.kacha.core.mod;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.util.MODBase;
import com.mizholdings.kacha.core.user.KCUserBase;
import com.mizholdings.kacha.interfaces.ParenthoodInterface;
import com.mizholdings.kacha.playload.PLParenthood;
import com.mizholdings.util.Requests;
import io.qameta.allure.Step;

public class MODParenthood extends MODBase<MODParenthood> {

    public static ParenthoodInterface parenthoodInterface = Requests.getService(ParenthoodInterface.class);

    public MODParenthood(KCUserBase executor) {
        super(executor);
        this.interfaced = parenthoodInterface;
    }


    /**
     * 3.1.1 子女列表
     *
     * @param parenthood
     * @return
     */
    @Step("子女列表")
    public JSONObject childs(PLParenthood parenthood) {
        return exec("childs", parenthood);
    }


    /**
     * 3.1.2 添加子女
     *
     * @param parenthood
     * @return
     */
    @Step("添加子女")
    public JSONObject addChild(PLParenthood parenthood) {
        return exec("addChild", parenthood);
    }


    /**
     * 3.1.3 修改子女姓名
     *
     * @param parenthood
     * @return
     */
    @Step("修改子女姓名")
    public JSONObject updateChild(PLParenthood parenthood) {
        return exec("updateChild", parenthood);
    }


    /**
     * 3.1.4 解除亲子关系
     *
     * @param parenthood
     * @return
     */
    @Step("解除亲子关系")
    public JSONObject deleteChild(PLParenthood parenthood) {
        return exec("deleteChild", parenthood);
    }


    /**
     * 3.2.1 亲子绑定码
     *
     * @param parenthood
     * @return
     */
    @Step("亲子绑定码")
    public JSONObject bindCode(PLParenthood parenthood) {
        return exec("bindCode", parenthood);
    }

    /**
     * 3.2.2 亲子绑定
     *
     * @param parenthood
     * @return
     */
    @Step("亲子绑定")
    public JSONObject bindChild(PLParenthood parenthood) {
        return exec("bindChild", parenthood);
    }


    /**
     * 3.3.1 当前子女
     *
     * @param parenthood
     * @return
     */
    @Step("当前子女")
    public JSONObject currentChild(PLParenthood parenthood) {
        return exec("currentChild", parenthood);
    }


    /**
     * 3.3.2 获取当前子女
     *
     * @param
     * @return
     */
    @Step("获取当前子女")
    public JSONObject currentChild() {
        return exec("currentChild");
    }


}
