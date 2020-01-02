package answerTest;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.ComboUtil;
import com.mizholdings.me2.Global;
import com.mizholdings.me2.user.SuperAdmin;
import com.mizholdings.me2.user.Teacher;
import com.mizholdings.me2.user.UserBase;
import com.mizholdings.util.Common;
import com.mizholdings.util.SampleAssert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class normalAnswerTest {

    private Teacher teacher;
    private SuperAdmin superAdmin;
    private UserBase student;

    private String lessonId;
    private List<String> classroomIds;
    private List<String> answerIds;

    //    private List<String> answerIds;
    public String answerCardId;
    public String student_answerCardId;

    public int k_count = 3;
    public int z_count = 2;


    @BeforeClass
    public void beforeClass() {
        teacher = Global.init().getTeacher();
        superAdmin = Global.init().getSuperAdmin();
        student = Global.init().getUserBase();
        init(1);
    }

    public void init(int classRoomCount) {
        //新建课程
        lessonId = teacher.newLessonAndGetLessonId(classRoomCount);
        //提交审核
        ComboUtil.applyLesson(superAdmin, teacher, lessonId);
        //新建视频
        //获取classroomId
        JSONObject object = teacher.getWeb().classroomAgent().listByLessonId(lessonId);
        classroomIds = Common.map(object.getJSONObject("data").getJSONArray("list"), "classroomId");
//        student.getApp().payAgent().buyLesson();
        ComboUtil.studentBuyLesson(student, lessonId);
    }

    @Test(description = "创建答题卡")
    public void answer_addAnswerCard_test() {
        JSONObject object = teacher.getWeb().answerAgent().addAnswerCard(lessonId, classroomIds.get(0), k_count, z_count, "自动创建的答题卡");
        SampleAssert.assertResult0(object);
        SampleAssert.assertEquals(object.getJSONObject("data").getJSONObject("la"), "answerCount", String.valueOf(k_count + z_count));
        answerCardId = Common.get(object.getJSONObject("data").getJSONObject("la"), "answerCardId");
    }

    @Test(description = "查看答题卡", dependsOnMethods = {"answer_addAnswerCard_test"})
    public void answer_getAnswerCard_test() {
        JSONObject object = teacher.getWeb().answerAgent().getAnswerCard(lessonId, classroomIds.get(0), answerCardId);
        SampleAssert.assertResult0(object);
//        answerIds = Common.map(object.getJSONObject("data").getJSONObject("la").getJSONArray("subjectiveItemList"), "answerId");
    }

    @Test(description = "修改答题卡", dependsOnMethods = {"answer_getAnswerCard_test"})
    public void answer_updateAnswerCard_test() {
        JSONObject object = teacher.getWeb().answerAgent().updateAnswerCard(answerCardId, lessonId, classroomIds.get(0), k_count, z_count, "修改的答题卡");
        SampleAssert.assertResult0(object);
        answerCardId = Common.get(object.getJSONObject("data").getJSONObject("la"), "answerCardId");
    }

    @Test(description = "查看学生答题卡", dependsOnMethods = {"answer_updateAnswerCard_test"})
    public void answer_getStudentAnswerCard_test() {
        JSONObject object = student.getApp().answerAgent().getStudentAnswerCard(answerCardId, lessonId, classroomIds.get(0));
        SampleAssert.assertResult0(object);
        student_answerCardId = Common.get(object.getJSONObject("data").getJSONObject("la"), "answerCardId");

        List<String> list = Common.map(object.getJSONObject("data").getJSONObject("la").getJSONArray("subjectiveItemList"), "answerId");
        List<String> list_ = Common.map(object.getJSONObject("data").getJSONObject("la").getJSONArray("objectiveItemList"), "answerId");
        list.addAll(list_);
        answerIds = list;
    }

    @Test(description = "保存答题卡", dependsOnMethods = {"answer_getStudentAnswerCard_test"})
    public void answer_saveAnswerCard_test() {
        JSONObject object = student.getApp().answerAgent().saveAnswerCard(lessonId, classroomIds.get(0), student_answerCardId, answerIds);
        SampleAssert.assertResult0(object);
    }

    @Test(description = "提交答题卡", dependsOnMethods = {"answer_saveAnswerCard_test"})
    public void answer_submitAnswerCard_test() {
        JSONObject object = student.getApp().answerAgent().submitAnswerCard(lessonId, classroomIds.get(0), student_answerCardId, answerIds);
        SampleAssert.assertResult0(object);
    }

    @Test(description = "拍照上传", dependsOnMethods = {"answer_submitAnswerCard_test"})
    public void answer_photographUploading_test() {
        JSONObject object = student.getApp().answerAgent().photographUploading(classroomIds.get(0), student_answerCardId, answerIds.get(answerIds.size() - 1), Global.getImageUrl());
        SampleAssert.assertResult0(object);
    }

    @Test(description = "获取上传图片", dependsOnMethods = {"answer_photographUploading_test"})
    public void answer_getPhotographUploading_test() {
        JSONObject object = student.getApp().answerAgent().getPhotographUploading(classroomIds.get(0), student_answerCardId);
        SampleAssert.assertResult0(object);
    }


}
