package com.mizholdings.me2.user;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.agent.web.OrgInfoAgent;
import com.mizholdings.me2.mod.MODGrade;
import com.mizholdings.me2.agent.web.LessonAgent;
import com.mizholdings.me2.mod.MODWebUsr;
import com.mizholdings.me2.playload.*;

public class Me2Jigou extends Me2Teacher {
    private LessonAgent lessonAgent;
    private OrgInfoAgent orgInfoAgent;

    private MODGrade modGrade;
    private MODWebUsr modWebUsr;

    public Me2Jigou(String account, String password) {
        super(account, password);
        modGrade = new MODGrade(this);
    }

    public LessonAgent lessonAgent() {
        return (LessonAgent) getAgent("lessonAgent");
    }

    public OrgInfoAgent orgInfoAgent() {
        return (OrgInfoAgent) getAgent("orgInfoAgent");
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
        return lessonAgent().joinClassByUserId(plLesson);
    }

    @Override
    public String getOrgId() {
        return this.object.getJSONObject("data").getString("orgId");
    }
}
