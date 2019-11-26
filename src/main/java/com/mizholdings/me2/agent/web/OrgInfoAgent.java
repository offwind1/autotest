package com.mizholdings.me2.agent.web;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.interfaces.web.LessonInterface;
import com.mizholdings.me2.interfaces.web.OrginfoInterface;
import com.mizholdings.me2.interfaces.web.UsrInterface;
import com.mizholdings.me2.user.Me2UserBase;
import com.mizholdings.util.MODBase;
import com.mizholdings.util.Parameter;
import com.mizholdings.util.Requests;
import com.mizholdings.util.User;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;

public class OrgInfoAgent extends MODBase<OrgInfoAgent> {


    public static OrginfoInterface orginfoInterface = Requests.getService(OrginfoInterface.class);

    public OrgInfoAgent(User executor) {
        super(executor);
        interfaced = orginfoInterface;
    }

    @Step("机构添加学生")
    public JSONObject addStudentToOrg(String account, String orgId) {
        return exec("addStudentToOrg", Parameter.creat()
                .add("account", account)
                .add("orgId", orgId));
    }

    public JSONObject addStudentToOrg(String account) {
        return addStudentToOrg(account, executor.getOrgId());
    }

    @Step("机构学生列表")
    public JSONObject orgStudentList() {
        return exec("orgStudentList", Parameter.creat()
                .add("currentPage", "1")
                .add("pageSize", "100"));
    }


    @Step("新增新闻")
    public JSONObject insertMessage(String name) {
        return exec("insertMessage", Parameter.creat()
                .add("name", name)
                .add("faceImg", "http://images.mizholdings.com/MPSu2tvsSRy.png")
                .add("content", "<p></p>"));
    }

    @Step("获取新闻列表")
    public JSONObject orgMessageList() {
        return exec("orgMessageList", Parameter.creat()
                .add("currentPage", "1")
                .add("pageSize", "10"));
    }

    @Step("提交新闻")
    public JSONObject applyMessage(String messageId) {
        return exec("applyMessage", Parameter.creat().
                add("messageId", messageId));
    }

    @Step("审核新闻")
    public JSONObject replyOrgMessage(String messageId) {
        return exec("replyOrgMessage", Parameter.creat()
                .add("pubType", "2")
                .add("pubMsg", "")
                .add("messageId", messageId));
    }

    @Step("机构添加教师")
    public JSONObject addTeacher(String nickname, String orgId, String phone, String userId) {
        return exec("addTeacher", Parameter.creat()
                .add("nickname", nickname)
                .add("orgId", orgId)
                .add("phone", phone)
                .add("userId", userId)
                .add("signIn", "1"));
    }

}
