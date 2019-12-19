package TestCase.me2.normalTest;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.ComboUtil;
import com.mizholdings.me2.GlobalMe2;
import com.mizholdings.me2.user.Me2SuperAdmin;
import com.mizholdings.me2.user.Me2Teacher;
import com.mizholdings.me2.user.Me2UserBase;
import com.mizholdings.util.Common;
import com.mizholdings.util.Parameter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class answerTest {

    private Me2Teacher teacher;
    private Me2SuperAdmin superAdmin;
    private Me2UserBase student;

    private String lessonId = "b29b6de9ba2f4888bf13e2c5a767708d";
    private List<String> classroomIds = Arrays.asList("6e53217a19e5478c942b0f9a6109217e");
    private List<String> answerIds = Arrays.asList("8c2e11c151b94321b293b5118fe5e316",
            "b94539c13cfd4f308c4ca4c77ca4cdf3",
            "5a20a1cbed8742878cbd85ef7d0bd5f2");
    public String answerCardId = "71";
    public int k_count = 3;
    public int z_count = 3;


    @BeforeClass
    public void beforeClass() {
        teacher = new Me2Teacher("mzkg123", "654321");
        teacher = GlobalMe2.init().getTeacher();
//        superAdmin = GlobalMe2.init().getSuperAdmin();
//        student = GlobalMe2.init().getUserBase();
//        student = new Me2UserBase("robot0333", "111111", "app");
//        init(1);
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
//        JSONObject object = teacher.getWeb().answerAgent().addAnswerCard(lessonId, classroomIds.get(0), k_count, z_count, "自动创建的答题卡");
        JSONObject object = teacher.getWeb().answerAgent().addAnswerCard("483191cf718440f6888babce20a02fae",
                "94e4a8a0987247b0b97dc715b5381735 ", k_count, z_count, "自动创建的答题卡");
        answerCardId = Common.get(object.getJSONObject("data").getJSONObject("la"), "answerCardId");
    }

    @Test(description = "查看答题卡")
    public void answer_getAnswerCard_test() {
        JSONObject object = teacher.getWeb().answerAgent().getAnswerCard(lessonId, classroomIds.get(0), answerCardId);
        answerIds = Common.map(object.getJSONObject("data").getJSONObject("la").getJSONArray("subjectiveItemList"), "answerId");
    }

    @Test(description = "修改答题卡")
    public void answer_updateAnswerCard_test() {
        teacher.getWeb().answerAgent().updateAnswerCard(answerCardId, lessonId, classroomIds.get(0), k_count, z_count, "修改的答题卡");
    }

    @Test(description = "保存答题卡")
    public void answer_saveAnswerCard_test() {
//        JSONArray array = new JSONArray();
//        for (String answerId : answerIds) {
//            JSONObject object = new JSONObject();
//            object.put("answerId", answerId);
//            object.put("userAnswer", "A");
//            array.add(object);
//        }
        student.getApp().answerAgent().saveAnswerCard(lessonId, classroomIds.get(0), answerCardId, 3);
//        student.getApp().answerAgent().saveAnswerCard(Parameter.creat()
//                .add("lessonId", lessonId)
//                .add("classroomId", classroomIds.get(0))
//                .add("answerCardId", answerCardId)
//                .add("answerListJson", array.toJSONString())
//        );
    }

    @Test(description = "提交答题卡")
    public void answer_submitAnswerCard_test() {
        student.getApp().answerAgent().submitAnswerCard(lessonId, classroomIds.get(0), answerCardId, k_count);
    }

    @Test(description = "拍照上传")
    public void answer_photographUploading_test() {
        student.getApp().answerAgent().photographUploading(classroomIds.get(0), answerCardId, answerIds.get(0), GlobalMe2.getImageUrl());
    }

    @Test(description = "获取上传图片")
    public void answer_getPhotographUploading_test() {
        student.getApp().answerAgent().getPhotographUploading(classroomIds.get(0), answerIds.get(0));
    }

    @Test(description = "查看学生答题卡")
    public void answer_getStudentAnswerCard_test() {
        student.getApp().answerAgent().getStudentAnswerCard(answerCardId, lessonId, classroomIds.get(0));
    }


}
