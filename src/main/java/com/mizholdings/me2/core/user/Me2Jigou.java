package com.mizholdings.me2.core.user;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.core.mod.MODGrade;
import com.mizholdings.me2.core.mod.MODLesson;
import com.mizholdings.me2.core.mod.MODWebUsr;
import com.mizholdings.me2.playload.*;

public class Me2Jigou extends Me2Teacher {

    private MODGrade modGrade;
    private MODWebUsr modWebUsr;
    private MODLesson modLesson;

    public Me2Jigou(String account, String password) {
        super(account, password);
        modGrade = new MODGrade(this);
        modWebUsr = new MODWebUsr(this);
        modLesson = new MODLesson(this);
    }

    /**
     * 添加班级
     *
     * @param orgName
     * @param orgId
     * @param className
     * @return
     */
    public JSONObject addClass(String orgName, String orgId, String className) {
        PLGrade plGrade = new PLGrade();
        plGrade.setAddClass(orgName, orgId, className);
        return modGrade.addClass(plGrade);
    }

    /**
     * 删除班级
     *
     * @param stuId
     * @return
     */
    public JSONObject delClass(String stuId) {
        PLGrade plGrade = new PLGrade();
        plGrade.setDelClass(stuId);
        return modGrade.delClass(plGrade);
    }

    /**
     * 获取班级列表
     *
     * @return
     */
    public JSONObject classList(String orgName) {
        PLGrade plGrade = new PLGrade();
        plGrade.setClassList(orgName);
        return modGrade.classList(plGrade);
    }

    /**
     * 编辑昵称
     *
     * @param nickName
     * @return
     */
    public JSONObject editNickName(String nickName) {
        PLWebUsr plWebUsr = new PLWebUsr();
        plWebUsr.setNickname(nickName);
        return modWebUsr.editUser(plWebUsr);
    }

    public JSONObject joinClassByUserId(String userIds, String stuId) {
        PLLesson plLesson = new PLLesson();
        plLesson.setJoinClassByUserId(userIds, stuId);
        return modLesson.joinClassByUserId(plLesson);
    }

}
