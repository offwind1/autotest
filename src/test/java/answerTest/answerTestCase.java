package answerTest;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.ComboUtil;
import com.mizholdings.me2.Global;
import com.mizholdings.me2.Global_enum;
import com.mizholdings.me2.creater.LessonCreater;
import com.mizholdings.me2.user.Teacher;
import com.mizholdings.me2.user.UserBase;
import com.mizholdings.util.Common;
import com.mizholdings.util.SampleAssert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class answerTestCase {

    private Teacher teacher = Global.init().getTeacher();

    private String lessonId;
    private String answerCardId;
    private String classroomId;
    private String orgId;
    private String classId;
    int k_count = 4;
    int z_count = 1;
    int answer_student = 4;
    int no_answer_student = 1;

    @BeforeClass
    public void beforeClass() {
        lessonId = LessonCreater.CreatLesson(teacher);
        JSONObject object = teacher.getWeb().classroomAgent().listByLessonId(lessonId);
        List<String> classroomIds = Common.map(object.getJSONObject("data").getJSONArray("list"), "classroomId");
        classroomId = classroomIds.get(0);
    }

    @Test(description = "答题卡流程测试")
    public void test() {

        //新建答题卡, 四道选择题 答案ABCD, 一道主观题
        JSONObject object = teacher.getWeb().answerAgent().addAnswerCard(lessonId, classroomId, k_count, z_count, "自动创建的答题卡");
        SampleAssert.assertResult0(object);
        answerCardId = Common.get(object.getJSONObject("data").getJSONObject("la"), "answerCardId");

        //获取答题卡
        object = teacher.getWeb().answerAgent().getAnswerCard(lessonId, classroomId, answerCardId);
        SampleAssert.assertResult0(object);

        List<String> userIds = new ArrayList<>();
        for (int i = 0; i < answer_student; i++) {
            //4个学生答题，回答为全A，全B，全C，全D
            String name = student_submit_quest(i);
            userIds.add(name);
        }

        for (int i = 0; i < no_answer_student; i++) {
            //再一个学生加入课程，不进行答题
            UserBase student = Global.init().getUserBase();
            ComboUtil.studentBuyLesson(student, lessonId);
            userIds.add(student.getUserId());
        }

        //提交作业的学校列表
        orgId = getWorkSchoolList();

        //提交作业的班级列表
        classId = getWorkClassList();

        //作业统计结果
        object = getWorkStatisticsList();
        assert_getWorkStatisticsList(object);

        //答题进度
        object = getQuestionsSchedule(userIds);

        //试题得分分析
        object = answerAnalyze();

        //学生主观题列表
        object = getStudentSubjectiveItemList();

        //学生主观题批改
        updateStudentSubjectiveItem(object);
    }

    private void updateStudentSubjectiveItem(JSONObject data) {
        List<String> list = data.getJSONObject("data").getJSONArray("caauList").stream().map(i -> {
            JSONObject o = (JSONObject) i;
            return o.getJSONArray("uuiList").getJSONObject(0).getString("userId");
        }).collect(Collectors.toList());

        for (String userId : list) {
            JSONObject object = teacher.getWeb().answerAgent().updateStudentSubjectiveItem(answerCardId, classroomId,
                    String.valueOf(k_count + z_count), userId, Global_enum.AnswerResult.RIGHT);
            SampleAssert.assertResult0(object);
        }
    }

    private JSONObject getStudentSubjectiveItemList() {
        JSONObject object = teacher.getWeb().answerAgent().getStudentSubjectiveItemList(answerCardId, classroomId, orgId, String.valueOf(k_count + z_count), classId);
        SampleAssert.assertResult0(object);
        return object;
    }


    private JSONObject answerAnalyze() {
        //作业统计结果
        JSONObject object = teacher.getWeb().answerAgent().answerAnalyze(answerCardId, classroomId, orgId);
        SampleAssert.assertResult0(object);
        return object;
    }

    private JSONObject getWorkStatisticsList() {
        //作业统计结果
        JSONObject object = teacher.getWeb().answerAgent().getWorkStatisticsList(answerCardId, classroomId, orgId, classId);
        SampleAssert.assertResult0(object);
        assert_getWorkStatisticsList(object);
        return object;
    }

    private JSONObject getQuestionsSchedule(List<String> userIds) {
        //作业统计结果
        JSONObject object = teacher.getWeb().answerAgent().getQuestionsSchedule(answerCardId, classroomId, orgId, classId);
        SampleAssert.assertResult0(object);
        JSONArray array = object.getJSONObject("data").getJSONArray("answerUserList");

        //遍历用户
        for (int i = 0; i < array.size(); i++) {
            JSONObject o = array.getJSONObject(i);
            assert userIds.contains(o.getString("userId"));

            //遍历主观题
            for (int j = 0; j < k_count; j++) {
                JSONObject oo = o.getJSONArray("quersList").getJSONObject(j);

                String answerResult;
                String submitStatus;
                //获取用户是第几个
                int user_index = userIds.indexOf(o.getString("userId"));
                if (user_index < answer_student) {
                    //答题的学生
                    int user_answer = user_index % 4;
                    int answer = j % 4;
                    answerResult = user_answer == answer ? "0" : "2";
                    submitStatus = "1";
                } else {
                    //未答题的学生
                    answerResult = "-2";
                    submitStatus = "0";
                }

                System.out.println(user_index + ":" + k_count + ":" + answerResult + ":" + submitStatus + ":" + o.getString("userId"));
                SampleAssert.assertEquals(oo, "answerResult", answerResult);
                SampleAssert.assertEquals(oo, "submitStatus", submitStatus);
            }

            //遍历主观题
            for (int k = k_count; k < k_count + z_count; k++) {
                JSONObject oo = o.getJSONArray("quersList").getJSONObject(k);
                String answerResult;
                String submitStatus;
                //获取用户是第几个
                int user_index = userIds.indexOf(o.getString("userId"));
                if (user_index < answer_student) {
                    //答题的学生
                    answerResult = "-1";
                    submitStatus = "1";
                } else {
                    //未答题的学生
                    answerResult = "-2";
                    submitStatus = "0";
                }

                SampleAssert.assertEquals(oo, "answerResult", answerResult);
                SampleAssert.assertEquals(oo, "submitStatus", submitStatus);
            }
        }
        return object;
    }

    private String getWorkSchoolList() {
        //提交作业的学校列表
        JSONObject object = teacher.getWeb().answerAgent().getWorkSchoolList(answerCardId, classroomId);
        SampleAssert.assertResult0(object);
        return object.getJSONObject("data").getJSONArray("oiList").getJSONObject(0).getString("orgId");
    }

    private String getWorkClassList() {
        //提交作业的班级列表
        JSONObject object = teacher.getWeb().answerAgent().getWorkClassList(answerCardId, classroomId, orgId);
        SampleAssert.assertResult0(object);
        return object.getJSONObject("data").getJSONArray("crList").getJSONObject(0).getString("classId");
    }


    private void assert_getWorkStatisticsList(JSONObject object) {//, List<List<String>> students_answer, List<String> real_obj_list, List<String> real_sub_list) {
        SampleAssert.assertEquals(object.getJSONObject("data"), "studentsCount", String.valueOf(answer_student + no_answer_student));

        for (int i = 0; i < k_count; i++) {
            JSONObject o = object.getJSONObject("data").getJSONArray("caList").getJSONObject(i);
            int rightCount = answer_student / 4 + ((i % 4) < (answer_student % 4) ? 1 : 0);
            int wrongCount = answer_student - rightCount;
            int nullCount = 0;

            SampleAssert.assertEquals(o, "rightCount", String.valueOf(rightCount));
            SampleAssert.assertEquals(o, "wrongCount", String.valueOf(wrongCount));
            SampleAssert.assertEquals(o, "nullCount", String.valueOf(nullCount));
        }

        for (int i = k_count; i < k_count + z_count; i++) {
            JSONObject o = object.getJSONObject("data").getJSONArray("caList").getJSONObject(i);
            int nullCount = answer_student;
            SampleAssert.assertEquals(o, "nullCount", String.valueOf(nullCount));
        }
    }


    private String student_submit_quest(int index) {
        UserBase student = Global.init().getUserBase();
        ComboUtil.studentBuyLesson(student, lessonId);

        //查看答案
        JSONObject object = student.getApp().answerAgent().getStudentAnswerCard(answerCardId, lessonId, classroomId);
        SampleAssert.assertResult0(object);
        String answerId = object.getJSONObject("data").getJSONObject("la").getString("answerCardId");

        //提交
        List<String> list = Common.map(object.getJSONObject("data").getJSONObject("la").getJSONArray("subjectiveItemList"), "answerId");
        List<String> list_ = Common.map(object.getJSONObject("data").getJSONObject("la").getJSONArray("objectiveItemList"), "answerId");
        list.addAll(list_);
        object = student.getApp().answerAgent().submitAnswerCard(lessonId, classroomId, answerId, list, index);
        SampleAssert.assertResult0(object);

        //查看答案
        object = student.getApp().answerAgent().getStudentAnswerCard(answerCardId, lessonId, classroomId);
        SampleAssert.assertResult0(object);

        return student.getUserId();
    }


}
