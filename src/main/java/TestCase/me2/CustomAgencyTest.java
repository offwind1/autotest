package TestCase.me2;


import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.GlobalMe2;
import com.mizholdings.me2.agent.app.FullschAgent;
import com.mizholdings.me2.user.Me2Jigou;
import com.mizholdings.me2.user.Me2SuperAdmin;
import com.mizholdings.me2.user.Me2UserBase;
import com.mizholdings.me2.agent.web.OrgInfoAgent;
import com.mizholdings.util.Parameter;
import com.mizholdings.util.SampleAssert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Test(description = "定制机构相关测试")
public class CustomAgencyTest {

    private String orgId;
//    private String appname;

    private Me2Jigou jigou;
    private Me2SuperAdmin superAdmin;
    private Me2UserBase student;
    private Me2UserBase no_in_jigou_student;
    private Me2UserBase in_jigou_student;

    //    private OrgInfoAgent orgInfoAgent;
//    private String account = "robot0211";
//    private String name = "机器人0221";
//    private String password = "111111";
    private String userId = "4486400733531136";
//    private String jigou_userId = "4599212035689472";


    @BeforeClass
    public void beforeClass() {
        orgId = GlobalMe2.getFengBiOrgId();
//        appname = GlobalMe2.getFengBiAppname();

        jigou = GlobalMe2.init().getFengBiJigou();
        superAdmin = GlobalMe2.init().getSuperAdmin();
        student = GlobalMe2.init().getUserBase();//GlobalMe2.init().getUser();
//        orgInfoAgent = new OrgInfoAgent(jigou);

        no_in_jigou_student = GlobalMe2.init().getUserBase();
        in_jigou_student = GlobalMe2.init().getUserBase();

        studentJoinJigou(in_jigou_student);
    }

    @AfterClass
    public void afterClass() {
        studentQuitJigou(in_jigou_student);
    }

    public JSONObject studentJoinJigou(Me2UserBase student) {
        return jigou.orgInfoAgent().addStudentToOrg(student.getAccount());
    }

    public JSONObject studentQuitJigou(Me2UserBase student) {
        return jigou.webUsrAgent().orgDelTeacher(student.getUserId());
    }


    @Test(description = "1_1_1 机构加入用户")
    public void test1_1_1() {
        JSONObject object = studentJoinJigou(student);

        assert object.getJSONObject("data").getJSONArray("userList").stream().anyMatch(i -> {
            JSONObject o = (JSONObject) i;
            return student.getUserId().equals(o.getString("userId"));
        });
    }

    @Test(description = "1_1_2 机构踢出用户", dependsOnMethods = {"test1_1_1"})
    public void test1_1_2() {
        JSONObject object = studentQuitJigou(student);
        SampleAssert.assertCode200(object);
    }


    @Test(description = "1_2_1_1 非机构用户，无法登录全封闭app")
    public void test1_2_1_1() {
        JSONObject object = no_in_jigou_student.orgLogin(jigou.getOrgId());
        SampleAssert.assertEquals("您的账号不在授权范围内，请联系学校教务处!", object);
    }


    @Test(description = "1_2_1_2 机构用户，可以登录全封闭app")
    public void test1_2_1_2() {
        JSONObject object = in_jigou_student.orgLogin(jigou.getOrgId());
        SampleAssert.assertEquals("登陆成功", object);
    }

//    @Test(description = "1_2_2 用户加入多个机构")
//    public void test1_2_2() {
//        List<String> orgIds = Arrays.asList("8398", "8419");
//        List<String> teacherIds = Arrays.asList("4626467080113152", "4477878537112576");
//        List<Me2Jigou> jigous = new ArrayList<>();
//
//        for (String name : Arrays.asList("jigou003", "fsdfsd")) {
//            jigous.add(new Me2Jigou(name, name));
//        }
//
//        for (int i = 0; i < jigous.size(); i++) {
//            orgInfoAgent.setExecutor(jigous.get(i));
//            orgInfoAgent.addStudentToOrg(account, orgIds.get(i));
//        }
//
//        JSONObject object = Me2UserBase.Login(account, password);
//
//        for (int i = 0; i < jigous.size(); i++) {
//            orgInfoAgent.setExecutor(jigous.get(i));
//            orgInfoAgent.orgDelTeacher(teacherIds.get(i), userId);
//        }
//
//        if (!orgIds.get(1).equals(object.getJSONObject("data")
//                .getJSONArray("orgRelList").getJSONObject(0)
//                .getString("orgId"))) {
//
//            throw new RuntimeException("最后加入的机构应该排在第一个");
//        }
//    }


    /**
     * 学生首页搜索课程
     *
     * @param lessonName
     * @return
     */
    public JSONObject studentSearchLesson(Me2UserBase student, String lessonName) {
        JSONObject object = student.fullschAgent().searchAll2(lessonName, FullschAgent.TYPE.LESSON, FullschAgent.GRADEID.ONE);
        SampleAssert.assertResult0(object);
        return object;
    }

    public JSONObject studentSearchCourse(Me2UserBase student, String lessonName) {
        JSONObject object = student.fullschAgent().searchAll2(lessonName, FullschAgent.TYPE.COURSE, FullschAgent.GRADEID.ONE);
        SampleAssert.assertResult0(object);
        return object;
    }


    private String lessonId;
    private String lessonName;
    private String coursewareId;
    private String coursewareName;

    /**
     * 新增课程并审核
     *
     * @return
     */
    public String newLessonAndApply() {

        String lessonId = jigou.lessonAgent().newLessonAndGetLessonId();
        jigou.lessonAgent().apply(lessonId);
        superAdmin.lessonAgent().passLesson(lessonId);
        return lessonId;
    }

    public void newCourseAndApply() {
        JSONObject object = jigou.courseAgent().uploadFile();
        coursewareName = UUID.randomUUID().toString().replace("-", "").substring(0, 4);
        coursewareId = object.getJSONObject("data").getString("coursewareId");

        object = jigou.webCourseAgent().editCourseware(coursewareId, coursewareName);
        SampleAssert.assertCode200(object);
        object = jigou.webCourseAgent().applyCourse(coursewareId);
        SampleAssert.assertCode200(object);
    }

    @BeforeGroups(description = "新建课程", groups = {"new_lesson"})
    public void beforeGroup_new_lesson() throws InterruptedException {
        // 生成课程
        lessonId = newLessonAndApply();
        JSONObject object = student.lessonInfoAgent().lessonInfo(lessonId);
        lessonName = object.getJSONObject("data").getString("lessonName");
        //等待5秒
        Thread.sleep(5000);
    }

    @Test(description = "1_2_3_1 非机构用户首页搜索课程", groups = {"new_lesson"})
    public void test1_2_3_1() {
        //搜索课程，orgid=0
        JSONObject object = studentSearchLesson(no_in_jigou_student, lessonName);

        //效验
        if (object.getJSONObject("data").getJSONArray("reusltList").stream().anyMatch(i -> {
            JSONObject o = (JSONObject) i;
            return lessonId.equals(o.getString("lessonId"));
        })) {
            throw new RuntimeException("全封闭的课程依旧可以在开放app中搜索到");
        }
    }

    @Test(description = "1_2_3_2 机构用户首页搜索课程", groups = {"new_lesson"})
    public void test1_2_3_2() {
        //设置机构Id
        in_jigou_student.setOrgId(jigou.getOrgId());
        //搜索课程
        JSONObject object = studentSearchLesson(in_jigou_student, lessonName);
        //效验
        if (object.getJSONObject("data").getJSONArray("reusltList").stream().allMatch(i -> {
            JSONObject o = (JSONObject) i;
            return !lessonId.equals(o.getString("lessonId"));
        })) {
            throw new RuntimeException("机构用户首页没有搜索到该课程");
        }
    }

    @Test(description = "1_2_3_3 非机构用户查询机构课程详情", groups = {"new_lesson"})
    public void test1_2_3_3() {
        JSONObject object = no_in_jigou_student.lessonInfoAgent().usrLesson(jigou.getUserId());

        if (object.getJSONArray("data").stream().anyMatch(i -> {
            JSONObject o = (JSONObject) i;
            return lessonId.equals(o.getString("lessonId"));
        })) {
            throw new RuntimeException("在机构详情的课程界面，依旧可以搜索到该课程");
        }
    }

    @Test(description = "1_2_3_4 机构用户查询机构课程详情", groups = {"new_lesson"})
    public void test1_2_3_4() {
        in_jigou_student.setOrgId(jigou.getOrgId());
        JSONObject object = in_jigou_student.lessonInfoAgent().usrLesson(jigou.getUserId());

        if (object.getJSONArray("data").stream().allMatch(i -> {
            JSONObject o = (JSONObject) i;
            return !lessonId.equals(o.getString("lessonId"));
        })) {
            throw new RuntimeException("机构用户搜索不到相关课程");
        }
    }


    @BeforeGroups(description = "新建课件", groups = {"new_course"})
    public void beforeGroup_new_course() {
        newCourseAndApply();
    }


    @Test(description = "1_2_4_5 非机构用户，首页搜索课件", groups = {"new_course"})
    public void test1_2_4_5() {
        JSONObject object = studentSearchCourse(no_in_jigou_student, coursewareName);

        if (object.getJSONObject("data").getJSONArray("reusltList").stream().anyMatch(i -> {
            JSONObject o = (JSONObject) i;
            return coursewareId.equals(o.getString("coursewareId"));
        })) {
            throw new RuntimeException("非机构用户，搜索到了全封闭机构的课件！");
        }
    }

    @Test(description = "1_2_4_6 机构用户，首页搜索课件", groups = {"new_course"})
    public void test1_2_4_6() {
        in_jigou_student.setOrgId(jigou.getOrgId());
        JSONObject object = studentSearchCourse(in_jigou_student, coursewareName);

        if (object.getJSONObject("data").getJSONArray("reusltList").stream().allMatch(i -> {
            JSONObject o = (JSONObject) i;
            return !coursewareId.equals(o.getString("coursewareId"));
        })) {
            throw new RuntimeException("机构用户，没有搜索到了全封闭机构的课件！");
        }
    }


    @Test(description = "1_2_4_7 非机构用户查看机构课件详情", groups = {"new_course"})
    public void test1_2_4_7() {
        JSONObject object = no_in_jigou_student.mobileAgent().orgCourseList(jigou.getUserId());

        if (object.getJSONArray("data").stream().anyMatch(i -> {
            JSONObject o = (JSONObject) i;
            return coursewareId.equals(o.getString("oldInfoId"));
        })) {
            throw new RuntimeException("在机构详情的课件界面，依旧可以搜到该课件");
        }
    }

    @Test(description = "1_2_4_8 机构用户查看机构课件详情", groups = {"new_course"})
    public void test1_2_4_8() {
        in_jigou_student.setOrgId(jigou.getOrgId());
        JSONObject object = in_jigou_student.mobileAgent().orgCourseList(jigou.getUserId());

        if (object.getJSONArray("data").stream().allMatch(i -> {
            JSONObject o = (JSONObject) i;
            return !coursewareId.equals(o.getString("oldInfoId"));
        })) {
            throw new RuntimeException("机构用户没有在机构课件详情列表中，查看到相关课件");
        }
    }


}
