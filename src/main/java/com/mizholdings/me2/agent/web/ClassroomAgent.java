package com.mizholdings.me2.agent.web;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.interfaces.web.ClassroomInterface;
import com.mizholdings.me2.interfaces.web.UsrInterface;
import com.mizholdings.util.MODBase;
import com.mizholdings.util.Parameter;
import com.mizholdings.util.Requests;
import com.mizholdings.util.User;
import io.qameta.allure.Step;
import org.testng.annotations.Test;

public class ClassroomAgent extends MODBase<ClassroomAgent> {


    public static ClassroomInterface classroomInterface = Requests.getService(ClassroomInterface.class);

    public ClassroomAgent(User executor) {
        super(executor);
        interfaced = classroomInterface;
    }

    @Step("课节绑定知识点")
    public JSONObject bangdingKnowledge(String classroomId, String knowledgeIds) {
        return exec("bangdingKnowledge", Parameter.creat()
                .add("classroomId", classroomId)
                .add("knowledgeIds", knowledgeIds));
    }

    @Step("直播课管理（V2）")
    public JSONObject onlineListV2(Parameter parameter) {
        return exec("onlineListV2", parameter
                .add("pageSize", "100")
                .add("currentPage", "1"));
    }

    public JSONObject onlineListV2ByClassroomCode(String classroomCode) {
        return onlineListV2(Parameter.creat().add("classroomCode", classroomCode));
    }


}
