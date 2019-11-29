package com.mizholdings.me2.user;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.agent.web.OrgInfoAgent;
import com.mizholdings.me2.mod.MODGrade;
import com.mizholdings.me2.agent.web.LessonAgent;
import com.mizholdings.me2.mod.MODWebUsr;
import com.mizholdings.me2.playload.*;
import com.mizholdings.util.Common;
import com.mizholdings.util.SampleAssert;

import java.util.List;
import java.util.stream.Collectors;

public class Me2Jigou extends Me2Teacher {
//    private LessonAgent lessonAgent;
//    private OrgInfoAgent orgInfoAgent;

    private MODGrade modGrade;
    private MODWebUsr modWebUsr;

    public Me2Jigou(String account, String password) {
        super(account, password);
        modGrade = new MODGrade(this);
    }

    /**
     * 新建新闻
     *
     * @return 返回新闻Id
     */
    public String creatMessage() {
        String msgName = Common.creatRandomString();
        getWeb().orgInfoAgent().insertMessage(msgName);
        JSONObject object = getWeb().orgInfoAgent().orgMessageList();
        List<Object> list = object.getJSONObject("data").getJSONArray("list").stream().filter(i -> {
            JSONObject o = (JSONObject) i;
            return msgName.equals(o.getString("messageName"));
        }).collect(Collectors.toList());
        assert list.size() > 0;
        return ((JSONObject) list.get(0)).getString("messageId");
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
        return getWeb().lessonAgent().joinClassByUserId(plLesson);
    }

    @Override
    public String getOrgId() {
        return this.object.getJSONObject("data").getString("orgId");
    }

    /**
     * 添加教师
     */
    public String addTeacher(String phone) {
        JSONObject object = web.webUsrAgent().checkTeacher(phone);
        SampleAssert.assertEquals("已注册", object);

        String nickname = object.getJSONObject("data").getJSONObject("userInfo").getString("nickname");
        String userId = object.getJSONObject("data").getJSONObject("userInfo").getString("userId");

        object = web.orgInfoAgent().addTeacher(nickname, getOrgId(), phone, userId);
        SampleAssert.assertCode200(object);
        return userId;
    }

    /**
     * 删除教师
     *
     * @param userId 用户id
     */
    public void delTeacher(String userId) {
        JSONObject object = web.webUsrAgent().orgDelTeacher(getUserId(), userId);
        SampleAssert.assertCode200(object);
    }


    public JSONObject studentJoinJigou(Me2UserBase student) {
        return web.orgInfoAgent().addStudentToOrg(student.getAccount());
    }

    public JSONObject studentQuitJigou(Me2UserBase student) {
        return web.webUsrAgent().orgDelTeacher(student.getUserId());
    }

}
