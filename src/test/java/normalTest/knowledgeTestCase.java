package normalTest;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.Global;
import com.mizholdings.me2.M2TYPE;
import com.mizholdings.me2.agent.web.LessonAgent;
import com.mizholdings.me2.user.SuperAdmin;
import com.mizholdings.me2.user.Teacher;
import com.mizholdings.util.Common;
import com.mizholdings.util.SampleAssert;
import io.qameta.allure.Allure;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class knowledgeTestCase {

    private Teacher teacher;
    private SuperAdmin superAdmin;


    @BeforeClass()
    public void beforeClass() {
        teacher = Global.init().getTeacher();
        superAdmin = Global.init().getSuperAdmin();
    }

    private String knowledgeIds;
    private String knowledgeNames;

    @Test(description = "3_1_1 获取知识点")
    public void test3_1_1() {
        JSONObject object = teacher.getTiku().me2tikuAgent().queryKnowledgeList();
        List<String> idList = new ArrayList<>();
        List<String> nameList = new ArrayList<>();

        List<String> tempId = new ArrayList<>();
        List<String> tempName = new ArrayList<>();

        getKnowledgeId(object.getJSONArray("data"), idList, nameList);
        Random random = new Random();

        for (int i = 0; i < 3; i++) {
            int n = random.nextInt(idList.size());
            tempId.add(idList.get(n));
            tempName.add(nameList.get(n));
        }

        knowledgeIds = String.join(",", tempId);
        knowledgeNames = String.join(",", tempName);
    }

    public void getKnowledgeId(JSONArray array, List<String> idList, List<String> nameList) {
        for (Object i : array) {
            JSONObject o = (JSONObject) i;
            if (o.containsKey("id") && o.containsKey("name")) {
                idList.add(o.getString("id"));
                nameList.add(o.getString("name"));
            }

            if (o.containsKey("childList")) {
                getKnowledgeId(o.getJSONArray("childList"), idList, nameList);
            }
        }
    }

    private String lessonId;

    @Test(description = "3_2_1 课程添加知识点", dependsOnMethods = {"test3_1_1"})
    public void test3_2_1() {
        lessonId = teacher.newLessonAndGetLessonId(LessonAgent.FreeType.FREE);
        JSONObject object = teacher.getWeb().lessonAgent().bangdingKnowledge(lessonId, knowledgeIds);
        SampleAssert.assertMsg("知识点绑定成功!", object);
        object = teacher.getWeb().lessonAgent().list();
        object = Common.filder(object.getJSONObject("data").getJSONArray("list"), lessonId, "lessonId");

        Allure.addAttachment("lessonInfo", object.toJSONString());
        if (!knowledgeIds.equals(object.getString("knowledgeIds"))) {
            throw new RuntimeException("知识点不匹配");
        }
    }

    @Test(description = "3_3_1 课节添加知识点", dependsOnMethods = {"test3_1_1", "test3_2_1"})
    public void test3_3_1() {
        JSONObject object = teacher.getWeb().lessonAgent().getLessonInfoById(lessonId);
        String classroomId = object.getJSONObject("data").getJSONArray("classroomList").getJSONObject(0).getString("classroomId");
        object = teacher.getWeb().classroomAgent().bangdingKnowledge(classroomId, knowledgeIds);
        SampleAssert.assertMsg("知识点绑定成功!", object);

        object = teacher.getWeb().lessonAgent().getLessonInfoById(lessonId);
        object = Common.filder(object.getJSONObject("data").getJSONArray("classroomList"), classroomId, "classroomId");
        Allure.addAttachment("lessonInfo", object.toJSONString());
        if (!knowledgeIds.equals(object.getString("knowledgeIds"))) {
            throw new RuntimeException("知识点不匹配");
        }
    }

    @Test(description = "3_4_1 课件添加知识点", dependsOnMethods = {"test3_1_1"})
    public void test3_4_1() {
        String courseId = teacher.newCourseAndApply();
        JSONObject object = teacher.getWeb().courseAgent().editCourseware(courseId,
                Common.creatRandomString(), "0", knowledgeIds, knowledgeNames);
        object = teacher.getWeb().courseAgent().editCourseware(courseId, Common.creatRandomString(), "0", knowledgeIds, knowledgeNames);
        object = teacher.getWeb().courseAgent().mylist(M2TYPE.GRADEID.ONE, M2TYPE.COURSEWARE_TYPE.ALL, M2TYPE.LESSON_TYPE_ID.ALL);
        object = Common.filder(object.getJSONObject("data").getJSONArray("list"), courseId, "coursewareId");

        if (!object.containsKey("knowledgeIds") || !knowledgeIds.equals(object.getString("knowledgeIds"))) {
            throw new RuntimeException("知识点不匹配");
        }
    }


}
