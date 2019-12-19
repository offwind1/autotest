package com.mizholdings.me2.agent.web;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.GlobalMe2;
import com.mizholdings.me2.M2TYPE;
import com.mizholdings.util.*;
import io.qameta.allure.Step;

public class CourseAgent extends MODBase<CourseAgent> {

    public CourseAgent(User executor) {
        super(executor);
    }



    /**
     * 编辑课件
     *
     * @param coursewareId   课件id
     * @param coursewareName 课件名称
     * @param privateType    是否公开
     * @return json
     */
    @Step("编辑课件")
    public JSONObject editCourseware(String coursewareId, String coursewareName, String privateType) {
        return exec("editCourseware", Parameter.creat()
                .add("coursewareId", coursewareId)
                .add("lessonTypeId", "0")
                .add("price", "0")
                .add("privateType", privateType)
                .add("gradeIds", "1")
                .add("faceImg", "http://images.mizholdings.com/sHJzAeLrWC0.png")
                .add("coursewareName", coursewareName));
    }

    @Step("编辑课件, 带学分")
    public JSONObject editCourseware(String coursewareId, String coursewareName, String privateType, String creditNum) {
        return exec("editCourseware", Parameter.creat()
                .add("coursewareId", coursewareId)
                .add("lessonTypeId", "0")
                .add("price", "0")
                .add("creditNum", creditNum)
                .add("privateType", privateType)
                .add("gradeIds", "1")
                .add("faceImg", "http://images.mizholdings.com/sHJzAeLrWC0.png")
                .add("coursewareName", coursewareName));
    }

    @Step("编辑课件 带知识点")
    public JSONObject editCourseware(String coursewareId, String coursewareName, String privateType, String knowledgeIds, String knowledgeName) {
        return exec("editCourseware", Parameter.creat()
                .add("coursewareId", coursewareId)
                .add("lessonTypeId", "0")
                .add("price", "0")
                .add("privateType", privateType)
                .add("gradeIds", "1")
                .add("knowledgeIds", knowledgeIds)
                .add("knowledgeName", knowledgeName)
                .add("faceImg", "http://images.mizholdings.com/sHJzAeLrWC0.png")
                .add("coursewareName", coursewareName));
    }

    public JSONObject editCourseware(String coursewareId, String coursewareName) {
        return editCourseware(coursewareId, coursewareName, "0");
    }

    @Step("用户购买资源列表")
    public JSONObject buylist(M2TYPE.GRADEID gradeId, M2TYPE.COURSEWARE_TYPE courseware_type, M2TYPE.LESSON_TYPE_ID lesson_type_id) {
        return exec("buylist", Parameter.creat()
                .add("currentPage", "1")
                .add("pageSize", "20")
                .add("gradeId", gradeId.value)
                .add("coursewareType", courseware_type.value)
                .add("lessonTypeId", lesson_type_id.value)
                .add("relationType", "1")
                .add("coursewareName", ""));
    }

    public JSONObject buylist() {
        return buylist(M2TYPE.GRADEID.ALL, M2TYPE.COURSEWARE_TYPE.ALL, M2TYPE.LESSON_TYPE_ID.ALL);
    }

    @Step("下架资源")
    public JSONObject banCourse(String coursewareId) {
        return exec("banCourse", Parameter.creat()
                .add("coursewareId", coursewareId));
    }

    @Step("购买资源")
    public JSONObject buyCourse(String courseId) {
        return exec("buyCourse", Parameter.creat().add("courseId", courseId));
    }

    @Step("自己创建的资源列表")
    public JSONObject mylist(M2TYPE.GRADEID gradeId, M2TYPE.COURSEWARE_TYPE courseware_type, M2TYPE.LESSON_TYPE_ID lesson_type_id) {
        return exec("mylist", Parameter.creat()
                .add("currentPage", "1")
                .add("pageSize", "20")
                .add("gradeId", gradeId.value)
                .add("coursewareType", courseware_type.value)
                .add("lessonTypeId", lesson_type_id.value)
                .add("relationType", "0")
                .add("coursewareName", ""));
    }

    public JSONObject mylist() {
        return mylist(M2TYPE.GRADEID.ALL, M2TYPE.COURSEWARE_TYPE.ALL, M2TYPE.LESSON_TYPE_ID.ALL);
    }

    @Step("根据课程id查询订单")
    public JSONObject getConsumByCourseId(String coursewareId) {
        return exec("getConsumByCourseId", Parameter.creat()
                .add("coursewareId", coursewareId)
                .add("currentPage", "1")
                .add("pageSize", "10"));
    }


    @Step("根据ID获取详情，自己创建的资源（有已审批的、未审批的）")
    public JSONObject getMyCosById(String coursewareId) {
        return exec("getMyCosById", Parameter.creat().add("coursewareId", coursewareId));
    }


    @Step("根据ID获得资源子集,自己创建的资源（有已审批的、未审批的）")
    public JSONObject getMyChildListById(String coursewareId) {
        return exec("getMyChildListById", Parameter.creat().add("coursewareId", coursewareId));
    }

    @Step("推荐资源")
    public JSONObject recommendCourseware(String coursewareId, String order) {
        return exec("recommendCourseware", Parameter.creat()
                .add("coursewareId", coursewareId)
                .add("order", order)
                .add("startTime", Common.getNowTime())
                .add("endTime", Common.getEndTime(7))
                .add("coursewareImg", GlobalMe2.getImageUrl()));
    }

    public JSONObject recommendCourseware(String coursewareId) {
        return recommendCourseware(coursewareId, "1");
    }

    @Step("获取资源标签")
    public JSONObject getTags(String coursewareTags) {
        return exec("getTags", Parameter.creat().add("coursewareTags", coursewareTags));
    }

    /**
     * 提交审核
     *
     * @param beforeId 课件id
     * @return json
     */
    @Step("提交审核")
    public JSONObject applyCourse(String beforeId) {
        return exec("applyCourse", Parameter.creat()
                .add("beforeId", beforeId).add("authen", "2"));
    }

    @Step("审批资源列表")
    public JSONObject applylist(String coursewareName, M2TYPE.COURSEWARE_TYPE courseware_type,
                                M2TYPE.LESSON_TYPE_ID lesson_type_id, M2TYPE.PRIVATE_TYPE private_type,
                                M2TYPE.GRADEID gradeid, M2TYPE.PUB_TYPE pub_type) {
        return exec("applylist", Parameter.creat()
                .add("coursewareName", coursewareName)
                .add("coursewareType", courseware_type.value)
                .add("lessonTypeId", lesson_type_id.value)
                .add("privateType", private_type.value)
                .add("gradeId", gradeid.value)
                .add("pubType", pub_type.value)
        );
    }

    public JSONObject applylist() {
        return applylist("", M2TYPE.COURSEWARE_TYPE.ALL, M2TYPE.LESSON_TYPE_ID.ALL, M2TYPE.PRIVATE_TYPE.OPEN,
                M2TYPE.GRADEID.ALL, M2TYPE.PUB_TYPE.APPLY);
    }


    @Step("审批资源")
    public JSONObject replyCourse(String beforeId, M2TYPE.PUB_TYPE pub_type, String pubMsg) {
        return exec("replyCourse", Parameter.creat()
                .add("beforeId", beforeId)
                .add("pubType", pub_type.value)
                .add("pubMsg", pubMsg)
        );
    }

    public JSONObject replyCourse(String beforeId) {
        return replyCourse(beforeId, M2TYPE.PUB_TYPE.PASS, "");
    }

    @Step("根据ID，获得资源详情")
    public JSONObject getCourseById(String coursewareId) {
        return exec("getCourseById", Parameter.creat().add("coursewareId", coursewareId));
    }

    @Step("根据ID获得资源子集")
    public JSONObject getChildListById(String coursewareId) {
        return exec("getChildListById", Parameter.creat().add("coursewareId", coursewareId));
    }

    @Step("根据ID获得资源子集")
    public JSONObject delChild(String parentId, String childId, String oderNum) {
        return exec("delChild", Parameter.creat()
                .add("parentId", parentId)
                .add("childId", childId)
                .add("oderNum", oderNum)
        );
    }

    @Step("删除自己的资源(必须是未送审，或者已经审批过的)")
    public JSONObject delMyCourse(String beforeId) {
        return exec("delMyCourse", Parameter.creat().add("beforeId", beforeId));
    }

    @Step("添加资源_新增添加")
    public JSONObject addNewCourse(String parentId, String sourceURL, M2TYPE.COURSEWARE_TYPE courseware_type, String oderNum) {
        return exec("addNewCourse", Parameter.creat()
                .add("parentId", parentId)
                .add("sourceId", sourceURL)
                .add("coursewareType", courseware_type.value)
                .add("oderNum", oderNum)
                .add("buy", "0")
        );
    }

    @Step("添加资源_新增添加")
    public JSONObject addNewCourse(String parentId) {
        return addNewCourse(parentId, GlobalMe2.getImageUrl(), M2TYPE.COURSEWARE_TYPE.IMAGE, "1");
    }


    @Step("添加资源_从资源库选择添加")
    public JSONObject addOldCourse(String parentId, String sourceId, String oderNum) {
        return exec("addOldCourse", Parameter.creat()
                .add("parentId", parentId)
                .add("sourceId", sourceId)
                .add("oderNum", oderNum)
                .add("buy", "0")
        );
    }

    public JSONObject addOldCourse(String parentId, String sourceId) {
        return addOldCourse(parentId, sourceId, "1");
    }

    @Step("资源库列表")
    public JSONObject list(String coursewareName, M2TYPE.COURSEWARE_TYPE courseware_type,
                           M2TYPE.LESSON_TYPE_ID lesson_type_id, M2TYPE.GRADEID gradeid,
                           M2TYPE.PRIVATE_TYPE private_type) {
        return exec("list", Parameter.creat()
                .add("coursewareName", coursewareName)
                .add("coursewareType", courseware_type.value)
                .add("lessonTypeId", lesson_type_id.value)
                .add("gradeId", gradeid.value)
                .add("privateType", private_type.value)
                .add("currentPage", "1")
                .add("pageSize", "15").add("reply", "1")
        );
    }

    public JSONObject list(String coursewareName) {
        return list(coursewareName, M2TYPE.COURSEWARE_TYPE.ALL, M2TYPE.LESSON_TYPE_ID.ALL, M2TYPE.GRADEID.ALL, M2TYPE.PRIVATE_TYPE.OPEN);
    }

    public JSONObject list() {
        return list("", M2TYPE.COURSEWARE_TYPE.ALL, M2TYPE.LESSON_TYPE_ID.ALL, M2TYPE.GRADEID.ALL, M2TYPE.PRIVATE_TYPE.OPEN);
    }

    public JSONObject list(M2TYPE.PRIVATE_TYPE private_type) {
        return list("", M2TYPE.COURSEWARE_TYPE.ALL, M2TYPE.LESSON_TYPE_ID.ALL, M2TYPE.GRADEID.ALL, private_type);
    }

    public JSONObject list(M2TYPE.GRADEID gradeid) {
        return list("", M2TYPE.COURSEWARE_TYPE.ALL, M2TYPE.LESSON_TYPE_ID.ALL, gradeid, M2TYPE.PRIVATE_TYPE.OPEN);
    }

    public JSONObject list(M2TYPE.LESSON_TYPE_ID lesson_type_id) {
        return list("", M2TYPE.COURSEWARE_TYPE.ALL, lesson_type_id, M2TYPE.GRADEID.ALL, M2TYPE.PRIVATE_TYPE.OPEN);
    }

    public JSONObject list(M2TYPE.COURSEWARE_TYPE courseware_type) {
        return list("", courseware_type, M2TYPE.LESSON_TYPE_ID.ALL, M2TYPE.GRADEID.ALL, M2TYPE.PRIVATE_TYPE.OPEN);
    }


    /**
     * 资源类型
     */
    public enum COURSEWARE_TYPE {
        ALL("0");
        public String value;

        private COURSEWARE_TYPE(String value) {
            this.value = value;
        }
    }



    /**
     * 下架资源
     *
     * @return json
     */
    @Step("下架资源")
    public JSONObject shutdownCourse(Parameter parameter) {
        return exec("shutdownCourse", parameter);
    }
    
    /**
     * 资源库列表
     *
     * @return json
     */
    @Step("资源库列表")
    public JSONObject list(Parameter parameter) {
        return exec("list", parameter);
    }
    
    /**
     * 初始化新增资源
     *
     * @return json
     */
    @Step("初始化新增资源")
    public JSONObject initCourse(Parameter parameter) {
        return exec("initCourse", parameter);
    }
    
    /**
     * 根据ID，获得资源详情
     *
     * @return json
     */
    @Step("根据ID，获得资源详情")
    public JSONObject getCourseById(Parameter parameter) {
        return exec("getCourseById", parameter);
    }
    
    /**
     * 根据ID获得资源子集
     *
     * @return json
     */
    @Step("根据ID获得资源子集")
    public JSONObject getChildListById(Parameter parameter) {
        return exec("getChildListById", parameter);
    }
    
    /**
     * 设置资源信息
     *
     * @return json
     */
    @Step("设置资源信息")
    public JSONObject editCourseware(Parameter parameter) {
        return exec("editCourseware", parameter);
    }
    
    /**
     * 删除子资源中一个
     *
     * @return json
     */
    @Step("删除子资源中一个")
    public JSONObject delChild(Parameter parameter) {
        return exec("delChild", parameter);
    }
    
    /**
     * 自己创建的资源列表
     *
     * @return json
     */
    @Step("自己创建的资源列表")
    public JSONObject mylist(Parameter parameter) {
        return exec("mylist", parameter);
    }
    
    /**
     * 用户购买资源列表
     *
     * @return json
     */
    @Step("用户购买资源列表")
    public JSONObject buylist(Parameter parameter) {
        return exec("buylist", parameter);
    }
    
    /**
     * 添加资源_新增添加
     *
     * @return json
     */
    @Step("添加资源_新增添加")
    public JSONObject addNewCourse(Parameter parameter) {
        return exec("addNewCourse", parameter);
    }
    
    /**
     * 添加资源_从资源库选择添加
     *
     * @return json
     */
    @Step("添加资源_从资源库选择添加")
    public JSONObject addOldCourse(Parameter parameter) {
        return exec("addOldCourse", parameter);
    }
    
    /**
     * 根据ID获取详情，自己创建的资源（有已审批的、未审批的）
     *
     * @return json
     */
    @Step("根据ID获取详情，自己创建的资源（有已审批的、未审批的）")
    public JSONObject getMyCosById(Parameter parameter) {
        return exec("getMyCosById", parameter);
    }
    
    /**
     * 根据ID获得资源子集,自己创建的资源（有已审批的、未审批的）
     *
     * @return json
     */
    @Step("根据ID获得资源子集,自己创建的资源（有已审批的、未审批的）")
    public JSONObject getMyChildListById(Parameter parameter) {
        return exec("getMyChildListById", parameter);
    }
    
    /**
     * 根据ID获取详情，已购买的
     *
     * @return json
     */
    @Step("根据ID获取详情，已购买的")
    public JSONObject getBuyCosById(Parameter parameter) {
        return exec("getBuyCosById", parameter);
    }
    
    /**
     * 根据ID获得资源子集,已购买的
     *
     * @return json
     */
    @Step("根据ID获得资源子集,已购买的")
    public JSONObject getBuyChildListById(Parameter parameter) {
        return exec("getBuyChildListById", parameter);
    }
    
    /**
     * 资源送审
     *
     * @return json
     */
    @Step("资源送审")
    public JSONObject applyCourse(Parameter parameter) {
        return exec("applyCourse", parameter);
    }
    
    /**
     * 审批资源列表
     *
     * @return json
     */
    @Step("审批资源列表")
    public JSONObject applylist(Parameter parameter) {
        return exec("applylist", parameter);
    }
    
    /**
     * 审批资源
     *
     * @return json
     */
    @Step("审批资源")
    public JSONObject replyCourse(Parameter parameter) {
        return exec("replyCourse", parameter);
    }
    
    /**
     * 删除自己的资源(必须是未送审，或者已经审批过的)
     *
     * @return json
     */
    @Step("删除自己的资源(必须是未送审，或者已经审批过的)")
    public JSONObject delMyCourse(Parameter parameter) {
        return exec("delMyCourse", parameter);
    }
    
    /**
     * 购买资源
     *
     * @return json
     */
    @Step("购买资源")
    public JSONObject buyCourse(Parameter parameter) {
        return exec("buyCourse", parameter);
    }
    
    /**
     * 向教师推荐资源
     *
     * @return json
     */
    @Step("向教师推荐资源")
    public JSONObject courseForTeacher(Parameter parameter) {
        return exec("courseForTeacher", parameter);
    }
    
    /**
     * 根据课程id查询订单
     *
     * @return json
     */
    @Step("根据课程id查询订单")
    public JSONObject getConsumByCourseId(Parameter parameter) {
        return exec("getConsumByCourseId", parameter);
    }
    
    /**
     * 新增ppt
     *
     * @return json
     */
    @Step("新增ppt")
    public JSONObject uploadPpt(Parameter parameter) {
        return exec("uploadPpt", parameter);
    }
    
    /**
     * 下架资源
     *
     * @return json
     */
    @Step("下架资源")
    public JSONObject banCourse(Parameter parameter) {
        return exec("banCourse", parameter);
    }
    
    /**
     * 推荐资源
     *
     * @return json
     */
    @Step("推荐资源")
    public JSONObject recommendCourseware(Parameter parameter) {
        return exec("recommendCourseware", parameter);
    }
    
    /**
     * 获取资源标签
     *
     * @return json
     */
    @Step("获取资源标签")
    public JSONObject getTags(Parameter parameter) {
        return exec("getTags", parameter);
    }
    
    /**
     * 上传文件
     *
     * @return json
     */
    @Step("上传文件")
    public JSONObject uploadFile(Parameter parameter) {
        return exec("uploadFile", parameter);
    }
    
    /**
     * 资源转换状态回调地址 
     *
     * @return json
     */
    @Step("资源转换状态回调地址 ")
    public JSONObject courseCallback(Parameter parameter) {
        return exec("courseCallback", parameter);
    }
    
    /**
     * 根据ID删除子集资源
     *
     * @return json
     */
    @Step("根据ID删除子集资源")
    public JSONObject deleteMyChildListById(Parameter parameter) {
        return exec("deleteMyChildListById", parameter);
    }
    

}