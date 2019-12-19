package com.mizholdings.me2.agent.web;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.util.MODBase;
import com.mizholdings.util.Parameter;
import com.mizholdings.util.Requests;
import com.mizholdings.util.User;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;

public class OrgInfoAgent extends MODBase<OrgInfoAgent> {



    public OrgInfoAgent(User executor) {
        super(executor);
    }

    @Step("分页列表")
    public JSONObject list(String orgName) {
        return exec("list", Parameter.creat()
                .add("orgName", orgName)
                .add("currentPage", "1")
                .add("pageSize", "10")
        );
    }

    @Step("根据ID拿到机构orgInfo/getOrgById")
    public JSONObject getOrgById(String orgId) {
        return exec("getOrgById", Parameter.creat().add("orgId", orgId));
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


    /**
     * 验证账号重复
     *
     * @return json
     */
    @Step("验证账号重复")
    public JSONObject accountCheck(Parameter parameter) {
        return exec("accountCheck", parameter);
    }

    /**
     * 分页列表
     *
     * @return json
     */
    @Step("分页列表")
    public JSONObject list(Parameter parameter) {
        return exec("list", parameter);
    }

    /**
     * 根据ID拿到机构
     *
     * @return json
     */
    @Step("根据ID拿到机构")
    public JSONObject getOrgById(Parameter parameter) {
        return exec("getOrgById", parameter);
    }

    /**
     * 添加机构
     *
     * @return json
     */
    @Step("添加机构")
    public JSONObject insert(Parameter parameter) {
        return exec("insert", parameter);
    }

    /**
     * 更新机构信息
     *
     * @return json
     */
    @Step("更新机构信息")
    public JSONObject editOrg(Parameter parameter) {
        return exec("editOrg", parameter);
    }

    /**
     * 查询认证机构
     *
     * @return json
     */
    @Step("查询认证机构")
    public JSONObject applylist(Parameter parameter) {
        return exec("applylist", parameter);
    }

    /**
     * 认证机构审批
     *
     * @return json
     */
    @Step("认证机构审批")
    public JSONObject replyOrg(Parameter parameter) {
        return exec("replyOrg", parameter);
    }

    /**
     * 机构用户注册
     *
     * @return json
     */
    @Step("机构用户注册")
    public JSONObject orgSignUp(Parameter parameter) {
        return exec("orgSignUp", parameter);
    }

    /**
     * 验证机构名称重复
     *
     * @return json
     */
    @Step("验证机构名称重复")
    public JSONObject orgNameCheck(Parameter parameter) {
        return exec("orgNameCheck", parameter);
    }

    /**
     * 修改机构审核信息
     *
     * @return json
     */
    @Step("修改机构审核信息")
    public JSONObject editOrgAuthen(Parameter parameter) {
        return exec("editOrgAuthen", parameter);
    }

    /**
     * 机构添加教师
     *
     * @return json
     */
    @Step("机构添加教师")
    public JSONObject addTeacher(Parameter parameter) {
        return exec("addTeacher", parameter);
    }

    /**
     * 获取待审批机构消息列表
     *
     * @return json
     */
    @Step("获取待审批机构消息列表")
    public JSONObject orgMessageList(Parameter parameter) {
        return exec("orgMessageList", parameter);
    }

    /**
     * 审批机构新闻
     *
     * @return json
     */
    @Step("审批机构新闻")
    public JSONObject replyOrgMessage(Parameter parameter) {
        return exec("replyOrgMessage", parameter);
    }

    /**
     * 根据id获取机构新闻详情
     *
     * @return json
     */
    @Step("根据id获取机构新闻详情")
    public JSONObject getMessageById(Parameter parameter) {
        return exec("getMessageById", parameter);
    }



    /**
     * 新增新闻
     *
     * @return json
     */
    @Step("新增新闻")
    public JSONObject insertMessage(Parameter parameter) {
        return exec("insertMessage", parameter);
    }

    /**
     * 修改新闻
     *
     * @return json
     */
    @Step("修改新闻")
    public JSONObject editMessage(Parameter parameter) {
        return exec("editMessage", parameter);
    }

    /**
     * 删除新闻
     *
     * @return json
     */
    @Step("删除新闻")
    public JSONObject delMessage(Parameter parameter) {
        return exec("delMessage", parameter);
    }

    /**
     * 新闻提交审核
     *
     * @return json
     */
    @Step("新闻提交审核")
    public JSONObject applyMessage(Parameter parameter) {
        return exec("applyMessage", parameter);
    }


    /**
     * 机构添加学生
     *
     * @return json
     */
    @Step("机构添加学生")
    public JSONObject addStudentToOrg(Parameter parameter) {
        return exec("addStudentToOrg", parameter);
    }

    /**
     * 推荐机构
     *
     * @return json
     */
    @Step("推荐机构")
    public JSONObject recommendOrg(Parameter parameter) {
        return exec("recommendOrg", parameter);
    }

    /**
     * 机构学生列表
     *
     * @return json
     */
    @Step("机构学生列表")
    public JSONObject orgStudentList(Parameter parameter) {
        return exec("orgStudentList", parameter);
    }



}
