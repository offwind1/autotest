package com.mizholdings.me2.agent.web;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.interfaces.web.ClassroomInterface;
import com.mizholdings.me2.interfaces.web.UsrInterface;
import com.mizholdings.util.MODBase;
import com.mizholdings.util.Parameter;
import com.mizholdings.util.Requests;
import com.mizholdings.util.User;
import io.qameta.allure.Step;

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


}
