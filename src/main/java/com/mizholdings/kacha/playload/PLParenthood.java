package com.mizholdings.kacha.playload;

import com.mizholdings.util.PLJavaBean;

public class PLParenthood extends PLJavaBean {
    private String year;
    private String name;
    private String childId;
    private String code;
    private String cAccount;
    private String cPassword;

    /**
     * 3.1.1 子女列表
     *
     * @param year：学年
     */
    public void setChilds(String year) {
        this.year = year;

    }


    /**
     * 3.1.2 添加子女
     *
     * @param name：姓名
     */
    public void setAddchild(String name) {
        this.name = name;

    }


    /**
     * 3.1.3 修改子女姓名
     *
     * @param childId：int
     * @param name：string
     */
    public void setUpdatechild(String childId, String name) {
        this.childId = childId;
        this.name = name;

    }


    /**
     * 3.1.4 解除亲子关系
     *
     * @param childId：int
     */
    public void setDeletechild(String childId) {
        this.childId = childId;

    }


    /**
     * 3.2.1 亲子绑定码
     *
     * @param childId：int
     */
    public void setBindcode(String childId) {
        this.childId = childId;

    }


    /**
     * 3.2.2 亲子绑定
     *
     * @param code:String
     */
    public void setBindchild(String code) {
        this.code = code;

    }


    /**
     * 3.2.3 亲子绑定
     *
     * @param cAccount:  子女账户
     * @param cPassword: 子女账户密码
     */
    public void setBindchild(String cAccount, String cPassword, String name) {
        this.cAccount = cAccount;
        this.cPassword = cPassword;
        this.name = name;
    }


    /**
     * 3.3.1 当前子女
     *
     * @param childId：int
     */
    public void setCurrentchild(String childId) {
        this.childId = childId;

    }


    /**
     * 3.3.2 获取当前子女
     */
    public void setCurrentchild() {

    }
}
