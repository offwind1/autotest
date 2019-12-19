package com.mizholdings.me2.agent.me2tiku;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.agent.web.OrgInfoAgent;
import com.mizholdings.util.MODBase;
import com.mizholdings.util.Parameter;
import com.mizholdings.util.User;
import io.qameta.allure.Step;

public class Me2tikuAgent extends MODBase<OrgInfoAgent> {

    public Me2tikuAgent(User executor) {
        super(executor);
    }

    /**
     * 获取章节
     *
     * @return
     */
    @Step("获取章节")
    public JSONObject queryChaptersTree() {
        return exec("queryChaptersTree");
    }

    /**
     * 获取知识点
     *
     * @param gradeId   年级
     * @param subjectId 学科
     * @return
     */
    @Step("获取知识点")
    public JSONObject queryKnowledgeList(String gradeId, String subjectId) {
        return exec("queryKnowledgeList", Parameter.creat()
                .add("gradeId", gradeId)
                .add("token", executor.getBookToken())
                .add("subjectId", subjectId).getObjectMap());
    }

    public JSONObject queryKnowledgeList() {
        return queryKnowledgeList("1", "1");
    }

}
