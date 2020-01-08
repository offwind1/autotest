package coursewareTest;

import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.ComboUtil;
import com.mizholdings.me2.Global;
import com.mizholdings.me2.Global_enum;
import com.mizholdings.me2.user.Teacher;
import com.mizholdings.util.Common;
import com.mizholdings.util.Parameter;
import com.mizholdings.util.SampleAssert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class coursewareTest {

    private Teacher teacher = Global.init().getTeacher();
    private String classroomId;
    private String jiao_an_courId;
    private String image_courId;
    private String video_courId;
    private String office_courId;

    /**
     * 为课程添加课件
     * 查看web端和app端，获取课堂资源列表接口，是否正常
     * <p>
     * 步骤：
     * 1、新建课程
     * 2、获取课程的课堂id
     * 3、给课堂添加课件，图片、视频、教案（ppt）、OFFICE（word）各一
     */
    @BeforeClass
    public void beforeClass() {
        //1.新建课程
        String lessonId = teacher.newLessonAndGetLessonId(1);
        ComboUtil.applyLesson(Global.init().getSuperAdmin(), teacher, lessonId);

        //2.获取课堂id
        JSONObject object = teacher.getApp().lessonInfoAgent().lessonInfo(lessonId);
        SampleAssert.assertResult0(object);
        classroomId = object.getJSONObject("data").getJSONArray("classroomInfoList").getJSONObject(0).getString("classroomId");

        //3.添加课件
        object = teacher.getApp().courseAgent().uploadFile2(lessonId, classroomId, Global_enum.COURSEWARE_TYPE.JIAO_AN);
        SampleAssert.assertResult0(object);
        jiao_an_courId = object.getJSONObject("data").getString("coursewareId");

        object = teacher.getApp().courseAgent().uploadFile2(lessonId, classroomId, Global_enum.COURSEWARE_TYPE.IMAGE);
        SampleAssert.assertResult0(object);
        image_courId = object.getJSONObject("data").getString("coursewareId");

        object = teacher.getApp().courseAgent().uploadFile2(lessonId, classroomId, Global_enum.COURSEWARE_TYPE.VIDEO);
        SampleAssert.assertResult0(object);
        video_courId = object.getJSONObject("data").getString("coursewareId");

        object = teacher.getApp().courseAgent().uploadFile2(lessonId, classroomId, Global_enum.COURSEWARE_TYPE.OFFICE);
        SampleAssert.assertResult0(object);
        office_courId = object.getJSONObject("data").getString("coursewareId");
    }


    /**
     * 4、调用 获取课堂资源列表接口，查看各课件数据显示是否正常
     * 测试点：
     * 1、optionList 下资源列表数量为4
     * 2、optionList 的资源分别是，视频，图片，教案，文档
     * 3、laList、videoList、homeworkList 为空
     */
    @Test(description = "拿到课堂附加资源列表")
    public void optionList_test() {
        JSONObject object = teacher.getApp().classInfoAgent().optionList(classroomId);
        SampleAssert.assertResult0(object);

        String mag = "";

        if (object.getJSONObject("data").getJSONArray("optionList").size() != 4) {
            mag += "附加资源列表数大于4";
        }

        JSONObject jiaoan_object = Common.filder(object.getJSONObject("data").getJSONArray("optionList"), jiao_an_courId, "coursewareId");
        if (ObjectUtil.isNotNull(jiaoan_object)) {
            SampleAssert.assertEquals(jiaoan_object, "coursewareType", Global_enum.COURSEWARE_TYPE.JIAO_AN.value);
        } else {
            mag += "未找到教案、";
        }

        JSONObject image_object = Common.filder(object.getJSONObject("data").getJSONArray("optionList"), image_courId, "coursewareId");
        if (ObjectUtil.isNotNull(image_object)) {
            SampleAssert.assertEquals(image_object, "coursewareType", Global_enum.COURSEWARE_TYPE.IMAGE.value);
        } else {
            mag += "未找到IMAGE、";
        }

        JSONObject video_object = Common.filder(object.getJSONObject("data").getJSONArray("optionList"), video_courId, "coursewareId");
        if (ObjectUtil.isNotNull(video_object)) {
            SampleAssert.assertEquals(video_object, "coursewareType", Global_enum.COURSEWARE_TYPE.VIDEO.value);
        } else {
            mag += "未找到VIDEO、";
        }

        JSONObject office_object = Common.filder(object.getJSONObject("data").getJSONArray("optionList"), office_courId, "coursewareId");
        if (ObjectUtil.isNotNull(office_object)) {
            SampleAssert.assertEquals(office_object, "coursewareType", Global_enum.COURSEWARE_TYPE.OFFICE.value);
        } else {
            mag += "未找到OFFICE、";
        }

        if (mag.length() > 1) {
            throw new RuntimeException(mag);
        }

        if (ObjectUtil.isNotNull(object.getJSONObject("data").getJSONArray("homeworkList"))) {
            throw new RuntimeException("homeworkList 不为空");
        }

        if (ObjectUtil.isNotNull(object.getJSONObject("data").getJSONArray("videoList"))) {
            throw new RuntimeException("videoList 不为空");
        }

        if (ObjectUtil.isNotNull(object.getJSONObject("data").getJSONArray("laList"))) {
            throw new RuntimeException("laList 不为空");
        }
    }

    /**
     * 4、调用 查看课堂附件 接口，查看各课件数据显示是否正常
     * 测试点：
     * 1、coursewareList 下资源列表数量为4
     * 2、coursewareList 的资源分别是，视频，图片，教案，文档
     * 3、homeList、laList。为空
     */
    @Test(description = "拿到课堂附加资源列表")
    public void classroomOption_test() {
        JSONObject object = teacher.getWeb().classroomAgent().classroomOptions(Parameter.creat().add("classroomId", classroomId));

        SampleAssert.assertResult0(object);

        String mag = "";

        if (object.getJSONObject("data").getJSONArray("coursewareList").size() != 4) {
            mag += "附加资源列表数不等于4";
        }


        JSONObject jiaoan_object = Common.filder(object.getJSONObject("data").getJSONArray("coursewareList"), jiao_an_courId, "coursewareId");
        if (ObjectUtil.isNotNull(jiaoan_object)) {
            SampleAssert.assertEquals(jiaoan_object, "coursewareType", Global_enum.COURSEWARE_TYPE.JIAO_AN.value);
        } else {
            mag += "未找到教案、";
        }

        JSONObject image_object = Common.filder(object.getJSONObject("data").getJSONArray("coursewareList"), image_courId, "coursewareId");
        if (ObjectUtil.isNotNull(image_object)) {
            SampleAssert.assertEquals(image_object, "coursewareType", Global_enum.COURSEWARE_TYPE.IMAGE.value);
        } else {
            mag += "未找到IMAGE、";
        }

        JSONObject video_object = Common.filder(object.getJSONObject("data").getJSONArray("coursewareList"), video_courId, "coursewareId");
        if (ObjectUtil.isNotNull(video_object)) {
            SampleAssert.assertEquals(video_object, "coursewareType", Global_enum.COURSEWARE_TYPE.VIDEO.value);
        } else {
            mag += "未找到VIDEO、";
        }

        JSONObject office_object = Common.filder(object.getJSONObject("data").getJSONArray("coursewareList"), office_courId, "coursewareId");
        if (ObjectUtil.isNotNull(office_object)) {
            SampleAssert.assertEquals(office_object, "coursewareType", Global_enum.COURSEWARE_TYPE.OFFICE.value);
        } else {
            mag += "未找到OFFICE、";
        }

        if (mag.length() > 1) {
            throw new RuntimeException(mag);
        }

        if (ObjectUtil.isNotNull(object.getJSONObject("data").getJSONArray("homeworkList"))) {
            throw new RuntimeException("homeworkList 不为空");
        }

        if (ObjectUtil.isNotNull(object.getJSONObject("data").getJSONArray("laList"))) {
            throw new RuntimeException("laList 不为空");
        }

    }

}
