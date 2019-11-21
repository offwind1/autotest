package com.mizholdings.me2.agent.web;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.interfaces.web.LessonInterface;
import com.mizholdings.util.*;
import io.qameta.allure.Step;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class LessonAgent extends MODBase<LessonAgent> {

    public static LessonInterface lessonInterface = Requests.getService(LessonInterface.class);

    class PubType {
        public static final String PASS = "9";
        public static final String NOPASS = "3";
    }


    public LessonAgent(User executor) {
        super(executor);
        interfaced = lessonInterface;
    }


    /**
     * userListByAccount
     *
     * @param javaBean
     * @return
     */
    public JSONObject userListByAccount(PLJavaBean javaBean) {
        return exec("userListByAccount", javaBean);
    }

    public JSONObject joinClassByUserId(PLJavaBean javaBean) {
        return exec("joinClassByUserId", javaBean);
    }

    /**
     * 审核通过课程
     *
     * @param lessonId 课程id
     * @return
     */
    public JSONObject passLesson(String lessonId) {
        JSONObject object = lessonReply(lessonId, PubType.PASS);
        SampleAssert.assertCode200(object);
        return object;
    }

    /**
     * 审核课程
     *
     * @param lessonId 课程id
     * @param pubType  审核标识
     * @return json
     */
    @Step("审核课程")
    public JSONObject lessonReply(String lessonId, String pubType) {
        return exec("lessonReply", Parameter.creat()
                .add("lessonId", lessonId)
                .add("pubType", pubType)
                .add("pubMsg", ""));
    }

    public Boolean applyLesson(String lessonId) {
        JSONObject object = apply(lessonId);
        SampleAssert.assertCode200(object);
        return true;
    }

    /**
     * 提交审核
     *
     * @param lessonId 课程id
     * @return json对象
     */
    @Step("提交审核")
    public JSONObject apply(String lessonId) {
        return exec("apply", Parameter.creat().add("lessonId", lessonId));
    }

    /**
     * 新建课程并返回课程ID
     *
     * @return 新建的课程id
     */
    public String newLessonAndGetLessonId() {
        String name = UUID.randomUUID().toString().replace("-", "").substring(0, 4);
        JSONObject object = addLesson(name);
        SampleAssert.assertCode200(object);
        object = list(name);
        SampleAssert.assertCode200(object);

        List<Object> list = object.getJSONObject("data").getJSONArray("list").stream().filter(i -> {
            JSONObject o = (JSONObject) i;
            return name.equals(o.getString("lessonName"));
        }).collect(Collectors.toList());

        assert list.size() > 0;

        return ((JSONObject) list.get(0)).getString("lessonId");
    }

    /**
     * 所有课程列表
     *
     * @return json
     */
    public JSONObject list() {
        return list("");
    }

    /**
     * 根据课程名称，搜索课程列表
     *
     * @param lessonName 课程名称
     * @return json
     */
    @Step("课程列表")
    public JSONObject list(String lessonName) {
        return exec("list", Parameter.creat()
                .add("lessonName", lessonName)
                .add("lessonTypeId", "0")
                .add("priceType", "")
                .add("recommend", "")
                .add("currentPage", "1")
                .add("pageSize", "10")
                .add("lessonTerm", "0")
                .add("org", "0"));
    }

    /**
     * 新增课程
     *
     * @param lessonName 课程名称
     * @return json
     */
    public JSONObject addLesson(String lessonName) {
        return addLesson(lessonName, 2);
    }

    /**
     * 新增课程
     *
     * @return json
     */
    public JSONObject addLesson() {
        return addLesson("新增课程", 2);
    }

    /**
     * 新增课程
     *
     * @param lessonName     课程名称
     * @param classroomCount 课节数量
     * @return json
     */
    @Step("新增课程")
    public JSONObject addLesson(String lessonName, int classroomCount) {
        JSONArray array = new JSONArray();
        for (int i = 0; i < classroomCount; i++) {
            JSONObject object = new JSONObject();
            object.put("interaction", 4);
            object.put("startTime", Common.getEndTime(i));
            object.put("classroomId", 1);
            array.add(object);
        }

        Parameter P = Parameter.creat()
                .add("lessonId", "")
                .add("gradeIds", "1")
                .add("gradeNames", "一年级")
                .add("lessonTypeId", "1")
                .add("startTime", Common.getNowTime())
                .add("endTime", Common.getEndTime(7))
                .add("tryLook", "0")
                .add("apply", "0")
                .add("lessonTerm", "1")
                .add("lessonName", lessonName)
                .add("faceImg", "http://images.mizholdings.com/bh4nopY6Mea.png")
                .add("classroomCount", String.valueOf(classroomCount))
                .add("classTime", "60")
                .add("classroomPrice", "0")
                .add("discount", String.valueOf(10 * classroomCount))
                .add("free", "1")
                .add("lessRemark", "<p>简介</p>")
                .add("lessonTag", "")
                .add("classInfo", array.toJSONString())
                .add("studentCount", "200")
                .add("price", "1")
                .add("buyType", "0")
                .add("custRelease", "1");
        return exec("add", P);
    }

}
