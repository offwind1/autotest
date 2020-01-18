package GetTestCase.LessonCreatFlow;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.Global;
import com.mizholdings.me2.user.SuperAdmin;
import com.mizholdings.me2.user.Teacher;
import com.mizholdings.util.JsonFuncUtil;
import com.mizholdings.util.SampleAssert;
import lombok.Data;

import java.util.Optional;

public class BaseTestCase {
    public static String lessonId;
    public static String classroomId;

    public static Teacher teacher = Global.init().getTeacher();
    public static SuperAdmin superAdmin = Global.init().getSuperAdmin();

    //pubType 0未提交，1提交审核，2审核未通过，9审核通过
    public static final String PUB_NO_APPLY = "0";
    public static final String PUB_APPLY = "1";
    public static final String PUB_APPLY_FALSE = "2";
    public static final String PUB_APPLY_PASS = "9";

    //state
    //0 未提交审核
    //2 课节待审核
    //3 审核以通过
    //4 课程未通过
    //10 课节未提交

    public static final String STATE_LESSON_NO_APPLY = "0";      //0 课程未提交审核
    public static final String STATE_LESSON_WAIT_APPLY = "1";    //1 课程带审核
    public static final String STATE_LESSON_APPLY_PASS = "3";    //3 课程审核以通过
    public static final String STATE_LESSON_APPLY_FALSE = "4";   //4 课程未通过

    public static final String STATE_CLASSROOM_NO_APPLY = "10";  //10课节未提交审核
    public static final String STATE_CLASSROOM_WAIT_APPLY = "2"; //2 课节待审核
//    public String STATE_CLASSROOM_APPLY_PASS = "3";
//    public String STATE_CLASSROOM_APPLY_FALSE = "4";

    /**
     * 教师端
     * 获取教师课程列表，并且通过 lessonId 筛选出对应的lesson JSON
     *
     * @param lessonId 课程id
     * @return 课程详情
     */
    public Optional<JSONObject> teacher_list(String lessonId) {
        JSONObject object = teacher.getWeb().lessonAgent().list();
        SampleAssert.assertCode200(object);
        return JsonFuncUtil.extract(object.getJSONObject("data").getJSONArray("list"), lessonId, "lessonId");
    }

    /**
     * 教师端
     * 通过lessonId 获取课程的详细信息
     * 返回INFO对象：
     * lessonInfo：课程详情
     * array：课时详情列表
     *
     * @param lessonId 课程id
     * @return info
     */
    public Info teacher_getLessonInfoById(String lessonId) {
        JSONObject object = teacher.getWeb().lessonAgent().getLessonInfoById(lessonId);
        SampleAssert.assertCode200(object);
        JSONObject lessonInfo = object.getJSONObject("data").getJSONObject("lessonInfo");
        JSONArray array = object.getJSONObject("data").getJSONArray("classroomList");
        return new Info(lessonInfo, array);
    }

    /**
     * 管理员
     * 获取管理员的课程列表，并且通过 lessonId 筛选出对应的lesson JSON
     *
     * @param lessonId 课程id
     * @return 课程详情
     */
    public Optional<JSONObject> superAdmin_list(String lessonId) {
        JSONObject object = superAdmin.getManage().lessonAgent().list();
        SampleAssert.assertCode200(object);
        return JsonFuncUtil.extract(object.getJSONObject("data").getJSONArray("list"), lessonId, "lessonId");
    }

    /**
     * 管理员
     * 通过lessonId 获取课程的详细信息
     * 返回INFO对象：
     * lessonInfo：课程详情
     * array：课时详情列表
     *
     * @param lessonId 课程id
     * @return info
     */
    public Info superAdmin_getLessonInfoById(String lessonId) {
        JSONObject object = superAdmin.getManage().lessonAgent().getLessonInfoById(lessonId);
        SampleAssert.assertCode200(object);
        JSONObject lessonInfo = object.getJSONObject("data").getJSONObject("lessonInfo");
        JSONArray array = object.getJSONObject("data").getJSONArray("classroomList");
        return new Info(lessonInfo, array);
    }

    private static void standard_assert(String target, String reality, String user, String lOrC, String describe) {
        assert target.equals(reality) : String.format("%s %s %s 应为 %s 实际为 %s", user, lOrC, describe, target, reality);
    }

    public static void ass_tls(String target, String reality) {
        standard_assert(target, reality, "教师", "课程", "state");
    }

    public static void ass_tlp(String target, String reality) {
        standard_assert(target, reality, "教师", "课程", "pubType");
    }

    public static void ass_tcp(String target, String reality) {
        standard_assert(target, reality, "教师", "课时", "pubType");
    }

    public static void ass_sls(String target, String reality) {
        standard_assert(target, reality, "管理员", "课程", "state");
    }

    public static void ass_slp(String target, String reality) {
        standard_assert(target, reality, "管理员", "课程", "pubType");
    }

    public static void ass_scp(String target, String reality) {
        standard_assert(target, reality, "管理员", "课时", "pubType");
    }

    @Data
    public class Info {
        public Optional<JSONObject> lessonInfo;
        public Optional<JSONArray> array;

        public Info(JSONObject lessonInfo, JSONArray array) {
            this.lessonInfo = Optional.ofNullable(lessonInfo);
            this.array = Optional.ofNullable(array);
        }
    }
}
