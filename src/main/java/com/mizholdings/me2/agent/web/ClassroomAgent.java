package com.mizholdings.me2.agent.web;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.GlobalMe2;
import com.mizholdings.util.MODBase;
import com.mizholdings.util.Parameter;
import com.mizholdings.util.Requests;
import com.mizholdings.util.User;
import io.qameta.allure.Step;
import org.testng.annotations.Test;

public class ClassroomAgent extends MODBase<ClassroomAgent> {


//    public static ClassroomInterface classroomInterface = Requests.getService(ClassroomInterface.class);

    public ClassroomAgent(User executor) {
        super(executor);
//        interfaced = classroomInterface;
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

    @Step("根据课程ID，查询课节信息")
    public JSONObject listByLessonId(String lessonId) {
        return exec("listByLessonId", Parameter.creat()
                .add("lessonId", lessonId));
    }

    @Step("根据课程ID，查询课节信息")
    public JSONObject addClassVideo(String classroomId) {
        return exec("addClassVideo", Parameter.creat()
                .add("classroomId", classroomId)
                .add("faceImg", GlobalMe2.getImageUrl())
                .add("videoPath", GlobalMe2.getVideoPath())
        );
    }


    public JSONObject onlineListV2ByClassroomCode(String classroomCode) {
        return onlineListV2(Parameter.creat().add("classroomCode", classroomCode));
    }

    /**
     * 课节绑定知识点
     *
     * @return json
     */
    @Step("课节绑定知识点")
    public JSONObject bangdingKnowledge(Parameter parameter) {
        return exec("bangdingKnowledge", parameter);
    }

    /**
     * 根据课程ID，查询课节信息
     *
     * @return json
     */
    @Step("根据课程ID，查询课节信息")
    public JSONObject listByLessonId(Parameter parameter) {
        return exec("listByLessonId", parameter);
    }

    /**
     * 新增课节
     *
     * @return json
     */
    @Step("新增课节")
    public JSONObject add(Parameter parameter) {
        return exec("add", parameter);
    }

    /**
     * 根据课节ID，获得课节信息
     *
     * @return json
     */
    @Step("根据课节ID，获得课节信息")
    public JSONObject getClassroomById(Parameter parameter) {
        return exec("getClassroomById", parameter);
    }

    /**
     * 编辑课节
     *
     * @return json
     */
    @Step("编辑课节")
    public JSONObject edit(Parameter parameter) {
        return exec("edit", parameter);
    }

    /**
     * 申请发布
     *
     * @return json
     */
    @Step("申请发布")
    public JSONObject apply(Parameter parameter) {
        return exec("apply", parameter);
    }

    /**
     * 审批发布的申请
     *
     * @return json
     */
    @Step("审批发布的申请")
    public JSONObject reply(Parameter parameter) {
        return exec("reply", parameter);
    }

    /**
     * 根据课节ID删除记录
     *
     * @return json
     */
    @Step("根据课节ID删除记录")
    public JSONObject delClassroomById(Parameter parameter) {
        return exec("delClassroomById", parameter);
    }

    /**
     * 课节申请列表
     *
     * @return json
     */
    @Step("课节申请列表")
    public JSONObject applylist(Parameter parameter) {
        return exec("applylist", parameter);
    }

    /**
     * 直播课管理
     *
     * @return json
     */
    @Step("直播课管理")
    public JSONObject onlineList(Parameter parameter) {
        return exec("onlineList", parameter);
    }

    /**
     * 查看课堂附件
     *
     * @return json
     */
    @Step("查看课堂附件")
    public JSONObject classroomOptions(Parameter parameter) {
        return exec("classroomOptions", parameter);
    }

    /**
     * 新增课堂视频
     *
     * @return json
     */
    @Step("新增课堂视频")
    public JSONObject addClassVideo(Parameter parameter) {
        return exec("addClassVideo", parameter);
    }

    /**
     * 修改课堂视频
     *
     * @return json
     */
    @Step("修改课堂视频")
    public JSONObject editClassVideo(Parameter parameter) {
        return exec("editClassVideo", parameter);
    }

    /**
     * 删除课堂视频
     *
     * @return json
     */
    @Step("删除课堂视频")
    public JSONObject deleteClassVideo(Parameter parameter) {
        return exec("deleteClassVideo", parameter);
    }


}
