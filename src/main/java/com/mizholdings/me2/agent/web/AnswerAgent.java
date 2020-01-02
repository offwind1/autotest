package com.mizholdings.me2.agent.web;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.M2TYPE;
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


    @Step("提交作业的班级列表")
    public JSONObject getWorkClassList(Parameter parameter) {
        return exec(Common.getMethodName(), parameter);
    }

    public JSONObject getWorkClassList(String answerCardId, String classroomId, String orgId) {
        return getWorkClassList(Parameter.creat()
                .add("answerCardId", answerCardId)
                .add("orgId", orgId)
                .add("classroomId", classroomId));
    }

    @Step("提交作业的学校列表")
    public JSONObject getWorkSchoolList(Parameter parameter) {
        return exec(Common.getMethodName(), parameter);
    }

    public JSONObject getWorkSchoolList(String answerCardId, String classroomId) {
        return getWorkSchoolList(Parameter.creat()
                .add("answerCardId", answerCardId)
                .add("classroomId", classroomId));
    }

    @Step("学生主观题批改")
    public JSONObject updateStudentSubjectiveItem(Parameter parameter) {
        return exec(Common.getMethodName(), parameter);
    }

    public JSONObject updateStudentSubjectiveItem(String answerCardId, String classroomId, String seq, String userId, M2TYPE.AnswerResult answerResult) {
        return updateStudentSubjectiveItem(Parameter.creat()
                .add("answerCardId", answerCardId)
                .add("classroomId", classroomId)
                .add("seq", seq)
                .add("userId", userId)
                .add("answerResult", answerResult.value)
        );
    }


    @Step("作业模块列表")
    public JSONObject getWorkList(Parameter parameter) {
        return exec(Common.getMethodName(), parameter);
    }

    @Step("作业统计结果")
    public JSONObject getWorkStatisticsList(Parameter parameter) {
        return exec(Common.getMethodName(), parameter);
    }


    public JSONObject getWorkStatisticsList(String answerCardId, String classroomId, String orgId) {
        return getWorkStatisticsList(Parameter.creat()
                .add("answerCardId", answerCardId)
                .add("classroomId", classroomId)
                .add("orgId", orgId)
                .add("classId", "")
        );
    }

    public JSONObject getWorkStatisticsList(String answerCardId, String classroomId, String orgId, String classId) {
        return getWorkStatisticsList(Parameter.creat()
                .add("answerCardId", answerCardId)
                .add("classroomId", classroomId)
                .add("orgId", orgId)
                .add("classId", classId)
        );
    }

    @Step("答题进度")
    public JSONObject getQuestionsSchedule(Parameter parameter) {
        return exec(Common.getMethodName(), parameter);
    }

    public JSONObject getQuestionsSchedule(String answerCardId, String classroomId, String orgId, String classId) {
        return getQuestionsSchedule(Parameter.creat()
                .add("answerCardId", answerCardId)
                .add("classroomId", classroomId)
                .add("classId", classId)
                .add("orgId", orgId)
        );
    }

    public JSONObject getQuestionsSchedule(String answerCardId, String classroomId, String orgId) {
        return getQuestionsSchedule(answerCardId, classroomId, orgId, "");
    }


    @Step("试题得分分析")
    public JSONObject answerAnalyze(Parameter parameter) {
        return exec(Common.getMethodName(), parameter);
    }

    public JSONObject answerAnalyze(String answerCardId, String classroomId, String orgId, String classId) {
        return answerAnalyze(Parameter.creat()
                .add("answerCardId", answerCardId)
                .add("classroomId", classroomId)
                .add("classId", classId)
                .add("orgId", orgId)
        );
    }

    public JSONObject answerAnalyze(String answerCardId, String classroomId, String orgId) {
        return answerAnalyze(answerCardId, classroomId, orgId, "");
    }

    @Step("学生主观题列表")
    public JSONObject getStudentSubjectiveItemList(Parameter parameter) {
        return exec(Common.getMethodName(), parameter);
    }

    public JSONObject getStudentSubjectiveItemList(String answerCardId, String classroomId, String orgId, String seq, String classId) {
        return getStudentSubjectiveItemList(Parameter.creat()
                .add("answerCardId", answerCardId)
                .add("classroomId", classroomId)
                .add("orgId", orgId)
                .add("seq", seq)
                .add("classId", classId)
        );
    }

    public JSONObject getStudentSubjectiveItemList(String answerCardId, String classroomId, String orgId, String seq) {
        return getStudentSubjectiveItemList(answerCardId, classroomId, orgId, seq, "");
    }


}