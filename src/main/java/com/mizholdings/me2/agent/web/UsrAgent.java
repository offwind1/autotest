package com.mizholdings.me2.agent.web;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.util.MODBase;
import com.mizholdings.util.Parameter;
import com.mizholdings.util.User;
import io.qameta.allure.Step;

public class UsrAgent extends MODBase<UsrAgent> {

//
//    public static UsrInterface usrInterface = Requests.getService(UsrInterface.class);

    public UsrAgent(User executor) {
        super(executor);
//        interfaced = usrInterface;
    }

    @Step("机构删除用户")
    public JSONObject orgDelTeacher(String jigou_userId, String teacherId, String deleteType) {
        return exec("orgDelTeacher", Parameter.creat()
                .add("teacherId", teacherId)
                .add("orgId", jigou_userId)
                .add("deleteType", deleteType)
        );
    }

    @Step("检验老师是否注册")
    public JSONObject checkTeacher(String phone) {
        return exec("checkTeacher", Parameter.creat().add("phone", phone));
    }

    public JSONObject orgDelTeacher(String teacherId) {
        return orgDelTeacher(executor.getUserId(), teacherId, "2");
    }

    public JSONObject orgDelStudent(String teacherId) {
        return orgDelTeacher(executor.getUserId(), teacherId, "1");
    }

    @Step("获取用户学分")
    public JSONObject getUserCreditId() {
        return exec("getUserCreditId");
    }


    /**
     * 机构列表
     *
     * @return json
     */
    @Step("机构列表")
    public JSONObject orgUserList(Parameter parameter) {
        return exec("orgUserList", parameter);
    }

    /**
     * 查询机构下老师信息
     *
     * @return json
     */
    @Step("查询机构下老师信息")
    public JSONObject orgTeacherInfo(Parameter parameter) {
        return exec("orgTeacherInfo", parameter);
    }

    /**
     * 代理商登陆
     *
     * @return json
     */
    @Step("代理商登陆")
    public JSONObject agentLogin(Parameter parameter) {
        return exec("agentLogin", parameter);
    }

    /**
     * 根据课程Id查学生信息
     *
     * @return json
     */
    @Step("根据课程Id查学生信息")
    public JSONObject lessonStudent(Parameter parameter) {
        return exec("lessonStudent", parameter);
    }

    /**
     * 验证登陆用户密码
     *
     * @return json
     */
    @Step("验证登陆用户密码")
    public JSONObject checkPassword(Parameter parameter) {
        return exec("checkPassword", parameter);
    }

    /**
     * 用户登陆
     *
     * @return json
     */
    @Step("用户登陆")
    public JSONObject login(Parameter parameter) {
        return exec("login", parameter);
    }

    /**
     * 获取登陆用户信息
     *
     * @return json
     */
    @Step("获取登陆用户信息")
    public JSONObject getInfo(Parameter parameter) {
        return exec("getInfo", parameter);
    }

    /**
     * 用户列表
     *
     * @return json
     */
    @Step("用户列表")
    public JSONObject list(Parameter parameter) {
        return exec("list", parameter);
    }

    /**
     * 根据用户ID获得用户信息
     *
     * @return json
     */
    @Step("根据用户ID获得用户信息")
    public JSONObject getUserById(Parameter parameter) {
        return exec("getUserById", parameter);
    }

    /**
     * 编辑用户信息
     *
     * @return json
     */
    @Step("编辑用户信息")
    public JSONObject editUser(Parameter parameter) {
        return exec("editUser", parameter);
    }

    /**
     * 认证审批
     *
     * @return json
     */
    @Step("认证审批")
    public JSONObject replyUser(Parameter parameter) {
        return exec("replyUser", parameter);
    }

    /**
     * 查询认证的用户
     *
     * @return json
     */
    @Step("查询认证的用户")
    public JSONObject applylist(Parameter parameter) {
        return exec("applylist", parameter);
    }

    /**
     * 用户消费记录查询
     *
     * @return json
     */
    @Step("用户消费记录查询")
    public JSONObject consumList(Parameter parameter) {
        return exec("consumList", parameter);
    }

    /**
     * 用户交易记录
     *
     * @return json
     */
    @Step("用户交易记录")
    public JSONObject transaction(Parameter parameter) {
        return exec("transaction", parameter);
    }

    /**
     * 提现申请
     *
     * @return json
     */
    @Step("提现申请")
    public JSONObject drawcash(Parameter parameter) {
        return exec("drawcash", parameter);
    }

    /**
     * 查询提现申请
     *
     * @return json
     */
    @Step("查询提现申请")
    public JSONObject applyCashList(Parameter parameter) {
        return exec("applyCashList", parameter);
    }

    /**
     * 提现申请审批
     *
     * @return json
     */
    @Step("提现申请审批")
    public JSONObject replyCash(Parameter parameter) {
        return exec("replyCash", parameter);
    }

    /**
     * 查询登陆用户信息和机构信息
     *
     * @return json
     */
    @Step("查询登陆用户信息和机构信息")
    public JSONObject usrOrgInfo(Parameter parameter) {
        return exec("usrOrgInfo", parameter);
    }

    /**
     * 查询登录用户交易记录
     *
     * @return json
     */
    @Step("查询登录用户交易记录")
    public JSONObject transList(Parameter parameter) {
        return exec("transList", parameter);
    }

    /**
     * 订单管理
     *
     * @return json
     */
    @Step("订单管理")
    public JSONObject consumListPage(Parameter parameter) {
        return exec("consumListPage", parameter);
    }

    /**
     * 检验老师是否注册
     *
     * @return json
     */
    @Step("检验老师是否注册")
    public JSONObject checkTeacher(Parameter parameter) {
        return exec("checkTeacher", parameter);
    }

    /**
     * 机构删除老师
     *
     * @return json
     */
    @Step("机构删除老师")
    public JSONObject orgDelTeacher(Parameter parameter) {
        return exec("orgDelTeacher", parameter);
    }

    /**
     * 查询老师下的学生
     *
     * @return json
     */
    @Step("查询老师下的学生")
    public JSONObject getStuByTeacher(Parameter parameter) {
        return exec("getStuByTeacher", parameter);
    }

    /**
     * 提现申请列表
     *
     * @return json
     */
    @Step("提现申请列表")
    public JSONObject drawcashList(Parameter parameter) {
        return exec("drawcashList", parameter);
    }

    /**
     * 用户管理
     *
     * @return json
     */
    @Step("用户管理")
    public JSONObject usrManage(Parameter parameter) {
        return exec("usrManage", parameter);
    }

    /**
     * 删除用户
     *
     * @return json
     */
    @Step("删除用户")
    public JSONObject delUser(Parameter parameter) {
        return exec("delUser", parameter);
    }

    /**
     * 用户认证
     *
     * @return json
     */
    @Step("用户认证")
    public JSONObject authenUser(Parameter parameter) {
        return exec("authenUser", parameter);
    }

    /**
     * 安全问题列表
     *
     * @return json
     */
    @Step("安全问题列表")
    public JSONObject safeQuestion(Parameter parameter) {
        return exec("safeQuestion", parameter);
    }

    /**
     * 添加用户
     *
     * @return json
     */
    @Step("添加用户")
    public JSONObject addNewUser(Parameter parameter) {
        return exec("addNewUser", parameter);
    }

    /**
     * 管理员登陆
     *
     * @return json
     */
    @Step("管理员登陆")
    public JSONObject manageLogin(Parameter parameter) {
        return exec("manageLogin", parameter);
    }

    /**
     * 修改用户米猪币或米猪时光
     *
     * @return json
     */
    @Step("修改用户米猪币或米猪时光")
    public JSONObject changeMoney(Parameter parameter) {
        return exec("changeMoney", parameter);
    }

    /**
     * 获取验证码
     *
     * @return json
     */
    @Step("获取验证码")
    public JSONObject phoneCode(Parameter parameter) {
        return exec("phoneCode", parameter);
    }

    /**
     * 检验验证码
     *
     * @return json
     */
    @Step("检验验证码")
    public JSONObject checkPhoneCode(Parameter parameter) {
        return exec("checkPhoneCode", parameter);
    }

    /**
     * 用户收支明细查询
     *
     * @return json
     */
    @Step("用户收支明细查询")
    public JSONObject incomeList(Parameter parameter) {
        return exec("incomeList", parameter);
    }

    /**
     * 课程课件交易记录
     *
     * @return json
     */
    @Step("课程课件交易记录")
    public JSONObject lessonCourseList(Parameter parameter) {
        return exec("lessonCourseList", parameter);
    }

    /**
     * 冻结列表
     *
     * @return json
     */
    @Step("冻结列表")
    public JSONObject freezeList(Parameter parameter) {
        return exec("freezeList", parameter);
    }

    /**
     * 冻结用户资金
     *
     * @return json
     */
    @Step("冻结用户资金")
    public JSONObject freezeCoin(Parameter parameter) {
        return exec("freezeCoin", parameter);
    }

    /**
     * 解冻米猪币
     *
     * @return json
     */
    @Step("解冻米猪币")
    public JSONObject unFreezeCoin(Parameter parameter) {
        return exec("unFreezeCoin", parameter);
    }

    /**
     * 管理员审批退课
     *
     * @return json
     */
    @Step("管理员审批退课")
    public JSONObject managerApply(Parameter parameter) {
        return exec("managerApply", parameter);
    }

    /**
     * 银行列表
     *
     * @return json
     */
    @Step("银行列表")
    public JSONObject bankList(Parameter parameter) {
        return exec("bankList", parameter);
    }

    /**
     * 扫码登陆
     *
     * @return json
     */
    @Step("扫码登陆")
    public JSONObject scanLogin(Parameter parameter) {
        return exec("scanLogin", parameter);
    }

    /**
     * 查看用户提现列表
     *
     * @return json
     */
    @Step("查看用户提现列表")
    public JSONObject userDrawcashList(Parameter parameter) {
        return exec("userDrawcashList", parameter);
    }

    /**
     * 审批提现申请
     *
     * @return json
     */
    @Step("审批提现申请")
    public JSONObject drawcashReply(Parameter parameter) {
        return exec("drawcashReply", parameter);
    }

    /**
     * 获取用户学分id
     *
     * @return json
     */
    @Step("获取用户学分id")
    public JSONObject getUserCreditId(Parameter parameter) {
        return exec("getUserCreditId", parameter);
    }

    /**
     * 米猪币账户管理
     *
     * @return json
     */
    @Step("米猪币账户管理")
    public JSONObject mizhuCoinBillManage(Parameter parameter) {
        return exec("mizhuCoinBillManage", parameter);
    }

    /**
     * 老师查询学生
     *
     * @return json
     */
    @Step("老师查询学生")
    public JSONObject teacherSearchUser(Parameter parameter) {
        return exec("teacherSearchUser", parameter);
    }

    /**
     * 定制机构用户登录
     *
     * @return json
     */
    @Step("定制机构用户登录")
    public JSONObject orgUserLogin(Parameter parameter) {
        return exec("orgUserLogin", parameter);
    }

    /**
     * 新用户领取课程
     *
     * @return json
     */
    @Step("新用户领取课程")
    public JSONObject reverseLesson(Parameter parameter) {
        return exec("reverseLesson", parameter);
    }

    /**
     * 合并账号
     *
     * @return json
     */
    @Step("合并账号")
    public JSONObject accountMerge(Parameter parameter) {
        return exec("accountMerge", parameter);
    }


}
