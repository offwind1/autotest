package com.mizholdings.me2.agent.web;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.GlobalMe2;
import com.mizholdings.util.Common;
import com.mizholdings.util.MODBase;
import com.mizholdings.util.Parameter;
import com.mizholdings.util.User;
import io.qameta.allure.Step;

public class AnswerAgent extends MODBase<AnswerAgent> {
    //    public static AdvertInterface advertInterface = Requests.getService(AdvertInterface.class);
    public AnswerAgent(User executor) {
        super(executor);
//        interfaced = advertInterface;
    }

    /**
     * 创建答题卡
     *
     * @return json
     */
    @Step("创建答题卡")
    public JSONObject addAnswerCard(Parameter parameter) {
        return exec("addAnswerCard", parameter);
    }

    private final String[] abcd = {"A", "B", "C", "D"};
    private final String[] tf = {"对", "错"};

    private String getABCD(int index) {
        return abcd[index % abcd.length];
    }

    private Parameter creatAnswerCardParam(String lessonId, String classroomId, int k_count, int z_count, String cardName) {
        if (k_count < 1) k_count = 1;
        if (z_count < 1) z_count = 1;

        JSONArray objectiveItemAnswer = new JSONArray();
        for (int i = 0; i < k_count; i++) {
            JSONObject object = new JSONObject();
            object.put("answerId", i + 1);
            object.put("questionQtype", 1);
            object.put("realAnswer", getABCD(i));
            objectiveItemAnswer.add(object);
        }
        JSONArray subjectiveItemAnswer = new JSONArray();
        for (int i = 0; i < z_count; i++) {
            subjectiveItemAnswer.add("http://images.mizholdings.com/qqqYgRGeqpW.png");
        }
        return Parameter.creat()
                .add("lessonId", lessonId)
                .add("classroomId", classroomId)
                .add("objectiveItemCount", String.valueOf(k_count))
                .add("objectiveItemAnswer", objectiveItemAnswer.toJSONString())
                .add("subjectiveItemCount", String.valueOf(z_count))
                .add("subjectiveItemAnswer", subjectiveItemAnswer.toJSONString())
                .add("cardName", cardName);
    }

    public JSONObject addAnswerCard(String lessonId, String classroomId, int k_count, int z_count, String cardName) {
//        creatAnswerCardParam(lessonId, classroomId, k_count, z_count, cardName);
        return addAnswerCard(creatAnswerCardParam(lessonId, classroomId, k_count, z_count, cardName));
    }

    /**
     * 创建答题卡
     *
     * @return json
     */
    @Step("删除答题卡")
    public JSONObject deleteAnswerCard(Parameter parameter) {
        return exec("deleteAnswerCard", parameter);
    }

    /**
     * 创建答题卡
     *
     * @return json
     */
    @Step("查看答题卡")
    public JSONObject getAnswerCard(Parameter parameter) {
        return exec("getAnswerCard", parameter);
    }

    public JSONObject getAnswerCard(String lessonId, String classroomId, String answerCardId) {
        return getAnswerCard(Parameter.creat()
                .add("lessonId", lessonId)
                .add("classroomId", classroomId)
                .add("answerCardId", answerCardId)
        );
    }

    /**
     * 创建答题卡
     *
     * @return json
     */
    @Step("修改答题卡")
    public JSONObject updateAnswerCard(Parameter parameter) {
        return exec("updateAnswerCard", parameter);
    }

    public JSONObject updateAnswerCard(String answerCardId, String lessonId, String classroomId, int k_count, int z_count, String cardName) {
        Parameter parameter = creatAnswerCardParam(lessonId, classroomId, k_count, z_count, cardName);

        return exec("updateAnswerCard", parameter.add("answerCardId", answerCardId));
    }

}