package com.mizholdings.me2.agent.web;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.Global_enum;
import com.mizholdings.util.*;
import io.qameta.allure.Step;

public class LessonAgent extends MODBase<LessonAgent> {

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

    public LessonAgent() {
        super();
    }

    public LessonAgent(User executor) {
        super(executor);
    }

    public static void main(String... args) throws ClassNotFoundException {
        System.out.println(LessonAgent.class.getName());
        Class.forName("com.mizholdings.me2.agent.web.LessonAgent");
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

    public JSONObject addLesson(String lessonName, FreeType free) {
        return addLesson(lessonName, 2, free);
    }

    public JSONObject addLesson(String lessonName, int classroomCount, FreeType free) {
        return addLesson(lessonName, classroomCount, free, 0);
    }

    public JSONObject addLesson(String lessonName, int classroomCount, FreeType free, int startDay) {
        return addLesson(lessonName, classroomCount, free, startDay, Global_enum.CustRelease.NORMAL);
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
    public JSONObject addLesson(String lessonName, int classroomCount, FreeType free, int startDay, Global_enum.CustRelease custRelease) {
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
                .add("custRelease", custRelease.value);
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

    @Step("根据课程id拿到课堂视频")
    public JSONObject getVideo(String lessonId) {
        return exec("getVideo", Parameter.creat().add("lessonId", lessonId));
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


    @Step("根据班级ID添加学生")
    public JSONObject studentByClassId(String lessonId, String stuId) {
        return exec("studentByClassId", Parameter.creat()
                .add("lessonId", lessonId).add("stuId", stuId));
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


    /**
     * 课程绑定知识点
     *
     * @return json
     */
    @Step("课程绑定知识点")
    public JSONObject bangdingKnowledge(Parameter parameter) {
        return exec("bangdingKnowledge", parameter);
    }

    /**
     * 课程分页列表
     *
     * @return json
     */
    @Step("课程分页列表")
    public JSONObject list(Parameter parameter) {
        return exec("list", parameter);
    }

    /**
     * 课程新增
     *
     * @return json
     */
    @Step("课程新增")
    public JSONObject add(Parameter parameter) {
        return exec("add", parameter);
    }

    /**
     * 根据ID获得课程信息
     *
     * @return json
     */
    @Step("根据ID获得课程信息")
    public JSONObject getLessonInfoById(Parameter parameter) {
        return exec("getLessonInfoById", parameter);
    }

    /**
     * 根据课程ID拿到评论（一级）
     *
     * @return json
     */
    @Step("根据课程ID拿到评论（一级）")
    public JSONObject getLessonScoreById(Parameter parameter) {
        return exec("getLessonScoreById", parameter);
    }

    /**
     * 编辑课程
     *
     * @return json
     */
    @Step("编辑课程")
    public JSONObject edit(Parameter parameter) {
        return exec("edit", parameter);
    }

    /**
     * 根据课程ID，删除课程
     *
     * @return json
     */
    @Step("根据课程ID，删除课程")
    public JSONObject delLessonInfoById(Parameter parameter) {
        return exec("delLessonInfoById", parameter);
    }

    /**
     * 老师回复评论
     *
     * @return json
     */
    @Step("老师回复评论")
    public JSONObject teacherScore(Parameter parameter) {
        return exec("teacherScore", parameter);
    }

    /**
     * 老师删除评论
     *
     * @return json
     */
    @Step("老师删除评论")
    public JSONObject delScore(Parameter parameter) {
        return exec("delScore", parameter);
    }

    /**
     * 根据课程id拿到课堂视频
     *
     * @return json
     */
    @Step("根据课程id拿到课堂视频")
    public JSONObject getVideo(Parameter parameter) {
        return exec("getVideo", parameter);
    }

    /**
     * 下架课程
     *
     * @return json
     */
    @Step("下架课程")
    public JSONObject banLesson(Parameter parameter) {
        return exec("banLesson", parameter);
    }

    /**
     * 冻结课程
     *
     * @return json
     */
    @Step("冻结课程")
    public JSONObject freezeLesson(Parameter parameter) {
        return exec("freezeLesson", parameter);
    }

    /**
     * 课程提交审批
     *
     * @return json
     */
    @Step("课程提交审批")
    public JSONObject apply(Parameter parameter) {
        return exec("apply", parameter);
    }

    /**
     * 课程评论列表
     *
     * @return json
     */
    @Step("课程评论列表")
    public JSONObject scoreList(Parameter parameter) {
        return exec("scoreList", parameter);
    }

    /**
     * 审核评论
     *
     * @return json
     */
    @Step("审核评论")
    public JSONObject replyScore(Parameter parameter) {
        return exec("replyScore", parameter);
    }

    /**
     * 推荐课程
     *
     * @return json
     */
    @Step("推荐课程")
    public JSONObject recommendLesson(Parameter parameter) {
        return exec("recommendLesson", parameter);
    }

    /**
     * 关闭课程
     *
     * @return json
     */
    @Step("关闭课程")
    public JSONObject lessonClose(Parameter parameter) {
        return exec("lessonClose", parameter);
    }

    /**
     * 老师添加学生
     *
     * @return json
     */
    @Step("老师添加学生")
    public JSONObject addTeacherStudent(Parameter parameter) {
        return exec("addTeacherStudent", parameter);
    }

    /**
     * 添加cc课程
     *
     * @return json
     */
    @Step("添加cc课程")
    public JSONObject addCCLesson(Parameter parameter) {
        return exec("addCCLesson", parameter);
    }

    /**
     * 我购买的课程
     *
     * @return json
     */
    @Step("我购买的课程")
    public JSONObject myLesson(Parameter parameter) {
        return exec("myLesson", parameter);
    }

    /**
     * 新增视频回放记录
     *
     * @return json
     */
    @Step("新增视频回放记录")
    public JSONObject setVideoRecord(Parameter parameter) {
        return exec("setVideoRecord", parameter);
    }

    /**
     * 根据视频id查询播放量
     *
     * @return json
     */
    @Step("根据视频id查询播放量")
    public JSONObject getTotalPlays(Parameter parameter) {
        return exec("getTotalPlays", parameter);
    }

    /**
     * 上传导入学生1
     *
     * @return json
     */
    @Step("上传导入学生1")
    public JSONObject uploadFile(Parameter parameter) {
        return exec("uploadFile", parameter);
    }

    /**
     * 加入班级，根据导入文件
     *
     * @return json
     */
    @Step("加入班级，根据导入文件")
    public JSONObject joinClassByFile(Parameter parameter) {
        return exec("joinClassByFile", parameter);
    }

    /**
     * 加入班级，根据用户ID
     *
     * @return json
     */
    @Step("加入班级，根据用户ID")
    public JSONObject joinClassByUserId(Parameter parameter) {
        return exec("joinClassByUserId", parameter);
    }

    /**
     * 根据班级ID添加学生
     *
     * @return json
     */
    @Step("根据班级ID添加学生")
    public JSONObject studentByClassId(Parameter parameter) {
        return exec("studentByClassId", parameter);
    }

    /**
     * 根据账号，查询用户
     *
     * @return json
     */
    @Step("根据账号，查询用户")
    public JSONObject userListByAccount(Parameter parameter) {
        return exec("userListByAccount", parameter);
    }

    /**
     * 返回课程中的班级
     *
     * @return json
     */
    @Step("返回课程中的班级")
    public JSONObject groupByClass(Parameter parameter) {
        return exec("groupByClass", parameter);
    }


    @Step("公共课程库")
    public JSONObject stockList(Parameter parameter) {
        return exec(Common.getMethodName(), parameter);
    }

    public JSONObject stockList(String orgId) {
        return stockList(Parameter.creat()
                .add("lessonName", "")
                .add("lessonTypeId", "0")
                .add("gradeId", "")
                .add("currentPage", "1")
                .add("pageSize", "12")
                .add("orgId", orgId)
        );
    }


    @Step("已选择的课程库")
    public JSONObject stockMy(Parameter parameter) {
        return exec(Common.getMethodName(), parameter);
    }

    public JSONObject stockMy(String orgId) {
        return stockMy(Global_enum.GRADEID.ALL, Global_enum.LESSON_TYPE_ID.ALL, orgId);
    }

    public JSONObject stockMy(Global_enum.GRADEID gradeId, Global_enum.LESSON_TYPE_ID lessonTypeId, String orgId) {
        return stockMy(Parameter.creat()
                .add("currentPage", "1")
                .add("lessonName", "")
                .add("pageSize", "12")
                .add("orgId", orgId)
                .add("gradeId", gradeId.value)
                .add("lessonTypeId", lessonTypeId.value)
        );
    }

    @Step("添加到我的课程库")
    public JSONObject stockJoin(Parameter parameter) {
        return exec(Common.getMethodName(), parameter);
    }

    public JSONObject stockJoin(String lessonIds, String orgId) {
        return stockJoin(Parameter.creat()
                .add("lessonIds", lessonIds)
                .add("orgId", orgId)
                .add("applyIds", "")
        );
    }


}
