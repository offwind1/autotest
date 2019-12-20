package TestCase.me2.professionalTest.answer;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.ComboUtil;
import com.mizholdings.me2.GlobalMe2;
import com.mizholdings.me2.user.Me2Jigou;
import com.mizholdings.me2.user.Me2SuperAdmin;
import com.mizholdings.me2.user.Me2Teacher;
import com.mizholdings.me2.user.Me2UserBase;
import com.mizholdings.util.Common;
import com.mizholdings.util.Parameter;
import com.mizholdings.util.SampleAssert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class answerTest {

    private Me2Teacher teacher;
    private Me2SuperAdmin superAdmin;
    private Me2UserBase student;


    @BeforeClass
    public void beforeClass() {
        teacher = new Me2Teacher("vta10000", "111111");
//        teacher = GlobalMe2.init().getTeacher();
//        superAdmin = GlobalMe2.init().getSuperAdmin();
//        student = GlobalMe2.init().getUserBase();
    }

    private String lessonId;
    private List<String> classroomIds;
//    private List<String> lessonIds;

    public void init1(int classRoomCount) {
        //新建课程
        lessonId = teacher.newLessonAndGetLessonId(classRoomCount);
        //提交审核
        ComboUtil.applyLesson(superAdmin, teacher, lessonId);
        //新建视频
        //获取classroomId
        JSONObject object = teacher.getWeb().classroomAgent().listByLessonId(lessonId);
        classroomIds = Common.map(object.getJSONObject("data").getJSONArray("list"), "classroomId");
    }


    @Test
    public void test() {
//        init1(2);

//        teacher.getWeb().usrAgent().getUserById("")

//        JSONObject object = teacher.getWeb().lessonAgent().myLesson(Parameter.creat().add("currentPage", "1").add("pageSize", "10"));
//        lessonIds = Common.map(object.getJSONObject("data").getJSONArray("list"), "lessonId");
//        JSONObject object;

//        for (String lessonId : lessonIds) {
        JSONObject object = teacher.getApp().lessonInfoAgent().lessonInfo("7aa4195c0cab4ee6b807a0502ca9e006");
        classroomIds = Common.map(object.getJSONObject("data").getJSONArray("classroomInfoList"), "classroomId");
        for (String classroomId : classroomIds) {
//            asdasdasd(lessonId, classroomId);
            teacher.getWeb().answerAgent().addAnswerCard("7aa4195c0cab4ee6b807a0502ca9e006", classroomId, 3, 3, "testCard");
        }
//        }
    }

    public void asdasdasd(String less, String clas) {
        String objectiveItemAnswer = "[{\"answerId\": 1,\"questionQtype\": 1,\"realAnswer\": \"A\"},{\"answerId\": 2,\"questionQtype\": 1,\"realAnswer\": \"B\"},{\"answerId\": 3,\"questionQtype\": 1, \"realAnswer\": \"C\"}]";
        String subjectiveItemAnswer = "[\"http://images.mizholdings.com/qqqYgRGeqpW.png,http://images.mizholdings.com/qqqYgRGeqpW.png\",\"http://images.mizholdings.com/qqqYgRGeqpW.png,http://images.mizholdings.com/qqqYgRGeqpW.png\",\"http://images.mizholdings.com/qqqYgRGeqpW.png,http://images.mizholdings.com/qqqYgRGeqpW.png\"]";


        JSONObject object = teacher.getWeb().answerAgent().addAnswerCard(Parameter.creat()
                .add("lessonId", less)
                .add("classroomId", clas)
                .add("objectiveItemCount", "3")
                .add("objectiveItemAnswer", objectiveItemAnswer)
                .add("subjectiveItemCount", "3")
                .add("subjectiveItemAnswer", subjectiveItemAnswer)
                .add("cardName", "testCard")
        );
    }


}
