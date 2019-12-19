package com.mizholdings.me2.agent.app;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mizholdings.util.MODBase;
import com.mizholdings.util.Parameter;
import com.mizholdings.util.User;
import io.qameta.allure.Step;

public class AnswerAgent extends MODBase<AnswerAgent> {

    public AnswerAgent(User executor) {
        super(executor);
    }


    /**
     * 查看学生答题卡
     *
     * @return json
     */
    @Step("查看学生答题卡")
    public JSONObject getStudentAnswerCard(Parameter parameter) {
        return exec("getStudentAnswerCard", parameter);
    }

    @Step("查看学生答题卡")
    public JSONObject getStudentAnswerCard(String answerCardId, String lessonId, String classroomId) {
        return getStudentAnswerCard(Parameter.creat()
                .add("answerCardId", answerCardId)
                .add("lessonId", lessonId)
                .add("classroomId", classroomId)
        );
    }

    /**
     * 保存答题卡
     *
     * @return json
     */
    @Step("保存答题卡")
    public JSONObject saveAnswerCard(Parameter parameter) {
        return exec("saveAnswerCard", parameter);
    }

    public JSONObject saveAnswerCard(String lessonId, String classroomId, String answerCardId, int count) {
        return saveAnswerCard(Parameter.creat()
                .add("lessonId", lessonId)
                .add("classroomId", classroomId)
                .add("answerCardId", answerCardId)
                .add("answerListJson", creatAnswerCard(count))
        );
    }

    private final String[] abcd = {"A", "B", "C", "D"};

    private String getABCD(int index) {
        return abcd[index % abcd.length];
    }

    private String creatAnswerCard(int count) {
        JSONArray array = new JSONArray();
        for (int i = 0; i < count; i++) {
            JSONObject object = new JSONObject();
            object.put("answerId", String.valueOf(i + 1));
            object.put("userAnswer", getABCD(i));
            array.add(object);
        }
        return array.toJSONString();
    }


    /**
     * 获取上传图片
     *
     * @return json
     */
    @Step("获取上传图片")
    public JSONObject getPhotographUploading(Parameter parameter) {
        return exec("getPhotographUploading", parameter);
    }

    public JSONObject getPhotographUploading(String classroomId, String answerCardId) {
        return getPhotographUploading(Parameter.creat()
                .add("classroomId", classroomId)
                .add("answerCardId", answerCardId)
        );
    }

    /**
     * 拍照上传
     *
     * @return json
     */
    @Step("拍照上传")
    public JSONObject photographUploading(Parameter parameter) {
        return exec("photographUploading", parameter);
    }

    public JSONObject photographUploading(String classroomId, String answerCardId, String answerId, String picture) {
        return photographUploading(Parameter.creat()
                .add("classroomId", classroomId)
                .add("answerCardId", answerCardId)
                .add("answerId", answerId)
                .add("picture", picture)
        );
    }

    /**
     * 提交答题卡
     *
     * @return json
     */
    @Step("提交答题卡")
    public JSONObject submitAnswerCard(Parameter parameter) {
        return exec("submitAnswerCard", parameter);
    }

    public JSONObject submitAnswerCard(String lessonId, String classroomId, String answerCardId, int count) {
        return submitAnswerCard(Parameter.creat()
                .add("lessonId", lessonId)
                .add("classroomId", classroomId)
                .add("answerCardId", answerCardId)
                .add("answerListJson", creatAnswerCard(count))
        );
    }
}