package com.mizholdings.me2.agent.web;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.agent.app.FullschAgent;
import com.mizholdings.me2.interfaces.web.CourseWebInterface;
import com.mizholdings.me2.user.Me2UserBase;
import com.mizholdings.me2.user.serve.ServeBase;
import com.mizholdings.util.MODBase;
import com.mizholdings.util.Parameter;
import com.mizholdings.util.Requests;
import com.mizholdings.util.User;
import io.qameta.allure.Step;

public class WebCourseAgent extends MODBase<OrgInfoAgent> {


    public static CourseWebInterface courseWebInterface = Requests.getService(CourseWebInterface.class);

    public WebCourseAgent(User executor) {
        super(executor);
        interfaced = courseWebInterface;
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

    public JSONObject mylist(ServeBase.GRADEID gradeId, COURSEWARE_TYPE courseware_type, ServeBase.LESSON_TYPE_ID lesson_type_id) {
        return exec("mylist", Parameter.creat()
                .add("currentPage", "1")
                .add("pageSize", "20")
                .add("gradeId", gradeId.value)
                .add("coursewareType", courseware_type.value)
                .add("lessonTypeId", lesson_type_id.value)
                .add("relationType", "0")
                .add("coursewareName", ""));
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

    @Step("资源库列表")
    public JSONObject list() {
        return exec("list", Parameter.creat());
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

}
