package com.mizholdings.me2.agent.web;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.interfaces.web.CourseWebInterface;
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
                .add("privateType", "0")
                .add("gradeIds", "1")
                .add("faceImg", "http://images.mizholdings.com/sHJzAeLrWC0.png")
                .add("coursewareName", coursewareName));
    }

    public JSONObject editCourseware(String coursewareId, String coursewareName) {
        return editCourseware(coursewareId, coursewareName, "0");
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


}
