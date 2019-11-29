package com.mizholdings.me2.agent.web;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.interfaces.web.LessonInterface;
import com.mizholdings.me2.user.Me2UserBase;
import com.mizholdings.util.*;
import io.qameta.allure.Step;

import javax.print.DocFlavor;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class LessonAgent extends MODBase<LessonAgent> {

    public static LessonInterface lessonInterface = Requests.getService(LessonInterface.class);

    public enum PubType {
        PASS("9"), NOPASS("3");
        public String value;

        private PubType(String value) {
            this.value = value;
        }

        public String toString() {
            return this.value;
        }
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
    public JSONObject lessonReply(String lessonId, PubType pubType) {
        return exec("lessonReply", Parameter.creat()
                .add("lessonId", lessonId)
                .add("pubType", pubType.value)
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

//    /**
//     * 新建课程并返回课程ID
//     *
//     * @return 新建的课程id
//     */
//    public String newLessonAndGetLessonId() {
//        String name = UUID.randomUUID().toString().replace("-", "").substring(0, 4);
//        JSONObject object = addLesson(name);
//        SampleAssert.assertCode200(object);
//        object = list(name);
//        SampleAssert.assertCode200(object);
//
//        List<Object> list = object.getJSONObject("data").getJSONArray("list").stream().filter(i -> {
//            JSONObject o = (JSONObject) i;
//            return name.equals(o.getString("lessonName"));
//        }).collect(Collectors.toList());
//
//        assert list.size() > 0;
//
//        return ((JSONObject) list.get(0)).getString("lessonId");
//    }

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
    public JSONObject addLesson(String lessonName, FreeType free) {
        return addLesson(lessonName, 2, free);
    }

    public JSONObject addLesson(String lessonName, int classroomCount, FreeType free) {
        return addLesson(lessonName, classroomCount, free, 0);
    }


    /**
     * 新增课程
     *
     * @param lessonName     课程名称
     * @param classroomCount 课节数量
     * @param free           是否免费 0 免费 1 不免费
     * @return json
     */
    @Step("新增课程")
    public JSONObject addLesson(String lessonName, int classroomCount, FreeType free, int startDay) {
        JSONArray array = new JSONArray();
        for (int i = 0; i < classroomCount; i++) {
            JSONObject object = new JSONObject();
            object.put("interaction", 4);
            object.put("startTime", Common.getEndTime(startDay + i));
            object.put("classroomId", 1);
            array.add(object);
        }

        System.out.println(array);

        Parameter P = Parameter.creat()
                .add("gradeIds", "1")
                .add("gradeNames", "一年级")
                .add("lessonTypeId", "1")
                .add("startTime", Common.getEndTime(startDay))
                .add("endTime", Common.getEndTime(startDay + 7))
                .add("tryLook", "0")
                .add("lessonTerm", "1")
                .add("lessonName", lessonName)
                .add("faceImg", "http://images.mizholdings.com/bh4nopY6Mea.png")
                .add("classroomCount", String.valueOf(classroomCount))
                .add("classTime", "60")
                .add("classroomPrice", "0")
                .add("discount", String.valueOf(10 * classroomCount))
                .add("free", free.value)
                .add("classInfo", array.toJSONString())
                .add("studentCount", "200")
                .add("custRelease", "1");
        return exec("add", P);
    }

    /**
     * 课程绑定知识点
     *
     * @param lessonId     课程ID
     * @param knowledgeIds 知识点ID多个逗号分隔
     * @return
     */
    @Step("课程绑定知识点")
    public JSONObject bangdingKnowledge(String lessonId, String knowledgeIds) {
        return exec("bangdingKnowledge", Parameter.creat()
                .add("lessonId", lessonId).add("knowledgeIds", knowledgeIds));
    }

    @Step("根据ID获得课程信息")
    public JSONObject getLessonInfoById(String lessonId) {
        return exec("getLessonInfoById", Parameter.creat().add("lessonId", lessonId));
    }

    @Step("新增视频回放记录")
    public JSONObject setVideoRecord(String lessonId, String classroomId, String classroomVideoId) {
        return exec("setVideoRecord", Parameter.creat()
                .add("lessonId", lessonId)
                .add("classroomId", classroomId)
                .add("classroomVideoId", classroomVideoId));
    }

    @Step("老师添加学生")
    public JSONObject addTeacherStudent(String ids, String lessonId, String stuId) {
        return exec("addTeacherStudent", Parameter.creat()
                .add("ids", ids)
                .add("lessonId", lessonId)
                .add("stuId", stuId));
    }

    public JSONObject addTeacherStudent(String ids, String lessonId) {
        return addTeacherStudent(ids, lessonId, "");
    }


    public enum FreeType {
        FREE("0"), NO_FREE("1");
        public String value;

        private FreeType(String value) {
            this.value = value;
        }

        public String toString() {
            return this.value;
        }
    }
}
