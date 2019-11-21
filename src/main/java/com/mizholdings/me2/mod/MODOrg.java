package com.mizholdings.me2.mod;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.user.Me2UserBase;
import com.mizholdings.me2.interfaces.api.OrgInterface;
import com.mizholdings.util.MODBase;
import com.mizholdings.util.PLJavaBean;
import com.mizholdings.util.Requests;

public class MODOrg extends MODBase<MODOrg> {
    public static OrgInterface orgInterface = Requests.getService(OrgInterface.class);

    public MODOrg(Me2UserBase executor) {
        super(executor);
        interfaced = orgInterface;
    }


    /**
     * 查询机构/学校列表
     *
     * @param javaBean list
     * @return
     */
    public JSONObject list(PLJavaBean javaBean) {
        return exec("list", javaBean);
    }

    /**
     * 获取机构新闻
     *
     * @param javaBean msglist
     * @return
     */
    public JSONObject msglist(PLJavaBean javaBean) {
        return exec("msglist", javaBean);
    }

    /**
     * 新闻详情
     *
     * @param javaBean msgInfo
     * @return
     */
    public JSONObject msgInfo(PLJavaBean javaBean) {
        return exec("msgInfo", javaBean);
    }

    /**
     * 用户同意加入机构
     *
     * @param javaBean joinOrg
     * @return
     */
    public JSONObject joinOrg(PLJavaBean javaBean) {
        return exec("joinOrg", javaBean);
    }

    /**
     * 添加机构
     *
     * @param javaBean create
     * @return
     */
    public JSONObject create(PLJavaBean javaBean) {
        return exec("create", javaBean);
    }

    /**
     * 已经加入的机构列表
     *
     * @param javaBean joinList
     * @return
     */
    public JSONObject joinList(PLJavaBean javaBean) {
        return exec("joinList", javaBean);
    }

    /**
     * 退出机构
     *
     * @param javaBean removeOrg
     * @return
     */
    public JSONObject removeOrg(PLJavaBean javaBean) {
        return exec("removeOrg", javaBean);
    }

    /**
     * 禁止添加
     *
     * @param javaBean disabled
     * @return
     */
    public JSONObject disabled(PLJavaBean javaBean) {
        return exec("disabled", javaBean);
    }


}