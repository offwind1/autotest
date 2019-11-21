package com.mizholdings.me2.agent.web;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.interfaces.web.LessonInterface;
import com.mizholdings.me2.interfaces.web.OrginfoInterface;
import com.mizholdings.me2.interfaces.web.UsrInterface;
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
    @Attachment("获取机构下所有的学生")
    public JSONObject orgStudentList() {
        return exec("orgStudentList", Parameter.creat()
                .add("currentPage", "1")
                .add("pageSize", "100"));
    }
}
