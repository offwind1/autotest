package professionalTest;


import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.Global;
import com.mizholdings.me2.agent.app.FullschAgent;
import com.mizholdings.me2.agent.web.LessonAgent;
import com.mizholdings.me2.user.Jigou;
import com.mizholdings.me2.user.SuperAdmin;
import com.mizholdings.me2.user.UserBase;
import com.mizholdings.me2.user.serve.ServeBase;
import com.mizholdings.util.Parameter;
import com.mizholdings.util.SampleAssert;
import org.testng.annotations.*;

import java.util.UUID;

@Test(description = "定制机构相关测试")
public class CustomAgencyTest {
    private Jigou jigou;
    private SuperAdmin superAdmin;
    private UserBase student;
    private UserBase no_in_jigou_student;
    private UserBase in_jigou_student;

    @BeforeClass
    public void beforeClass() {
        jigou = Global.init().getFengBiJigou();
        superAdmin = Global.init().getSuperAdmin();
        student = Global.init().getUserBase();

        no_in_jigou_student = Global.init().getUserBase();
        in_jigou_student = Global.init().getUserBase();

        studentJoinJigou(in_jigou_student);
    }

    @AfterClass
    public void afterClass() {
        studentQuitJigou(in_jigou_student);
    }

    public JSONObject studentJoinJigou(UserBase student) {
        return jigou.getWeb().orgInfoAgent().addStudentToOrg(student.getAccount());
    }

    public JSONObject studentQuitJigou(UserBase student) {
        return jigou.getWeb().usrAgent().orgDelTeacher(student.getUserId());
    }

    @Test
    public void test_temp() {
        in_jigou_student.setOrgId(jigou.getOrgId());
        studentSearchLesson(in_jigou_student, "风吹草低现牛羊");
        in_jigou_student.getApp().topAgent().topMore(Parameter.creat()
                .add("gradeId", "1")
                .add("topId", "1")
                .add("hotTop", "1")
                .add("page", "1")
        );
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
        SampleAssert.assertEquals("查询成功", object);
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
    public JSONObject studentSearchLesson(UserBase student, String lessonName) {
        JSONObject object = student.getApp().fullschAgent().searchAll2(lessonName, FullschAgent.TYPE.LESSON, ServeBase.GRADEID.ONE);
        SampleAssert.assertResult0(object);
        return object;
    }

    public JSONObject studentSearchCourse(UserBase student, String lessonName) {
        JSONObject object = student.getApp().fullschAgent().searchAll2(lessonName, FullschAgent.TYPE.COURSE, ServeBase.GRADEID.ONE);
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
        String lessonId = jigou.newLessonAndGetLessonId(LessonAgent.FreeType.NO_FREE);
        jigou.getWeb().lessonAgent().apply(lessonId);
        superAdmin.getManage().lessonAgent().passLesson(lessonId);
        return lessonId;
    }

    public void newCourseAndApply() {
        JSONObject object = jigou.getApp().courseAgent().uploadFile();
        coursewareName = UUID.randomUUID().toString().replace("-", "").substring(0, 4);
        coursewareId = object.getJSONObject("data").getString("coursewareId");

        object = jigou.getWeb().courseAgent().editCourseware(coursewareId, coursewareName);
        SampleAssert.assertCode200(object);
        object = jigou.getWeb().courseAgent().applyCourse(coursewareId);
        SampleAssert.assertCode200(object);
    }

    @BeforeGroups(description = "新建课程", groups = {"new_lesson"})
    public void beforeGroup_new_lesson() throws InterruptedException {
        // 生成课程
        lessonId = newLessonAndApply();
        JSONObject object = student.getApp().lessonInfoAgent().lessonInfo(lessonId);
        lessonName = object.getJSONObject("data").getString("lessonName");
        //等待5秒
        Thread.sleep(5000);
    }

    @Test(description = "1_3_1_1 非机构用户首页搜索课程", groups = {"new_lesson"})
    public void test1_3_1_1() {
        //搜索课程，orgid=0
        JSONObject object = studentSearchLesson(no_in_jigou_student, lessonName);

        //效验
        if (object.getJSONObject("data").getJSONArray("resultList").stream().anyMatch(i -> {
            JSONObject o = (JSONObject) i;
            return lessonId.equals(o.getString("lessonId"));
        })) {
            throw new RuntimeException("全封闭的课程依旧可以在开放app中搜索到" + lessonName + ":" + lessonId);
        }
    }

    @Test(description = "1_3_1_2 机构用户首页搜索课程", groups = {"new_lesson"})
    public void test1_3_1_2() {
        //设置机构Id
        in_jigou_student.setOrgId(jigou.getOrgId());
        //搜索课程
        JSONObject object = studentSearchLesson(in_jigou_student, lessonName);
        //效验
        if (object.getJSONObject("data").getJSONArray("resultList").stream().allMatch(i -> {
            JSONObject o = (JSONObject) i;
            return !lessonId.equals(o.getString("lessonId"));
        })) {
            throw new RuntimeException("机构用户首页没有搜索到该课程 " + lessonName + ":" + lessonId);
        }
    }

    @Test(description = "1_3_1_3 非机构用户查询机构课程详情", groups = {"new_lesson"})
    public void test1_3_1_3() {
        JSONObject object = no_in_jigou_student.getApp().lessonInfoAgent().usrLesson(jigou.getUserId());

        if (object.getJSONArray("data").stream().anyMatch(i -> {
            JSONObject o = (JSONObject) i;
            return lessonId.equals(o.getString("lessonId"));
        })) {
            throw new RuntimeException("在机构详情的课程界面，依旧可以搜索到该课程");
        }
    }

    @Test(description = "1_3_1_4 机构用户查询机构课程详情", groups = {"new_lesson"})
    public void test1_3_1_4() {
        in_jigou_student.setOrgId(jigou.getOrgId());
        JSONObject object = in_jigou_student.getApp().lessonInfoAgent().usrLesson(jigou.getUserId());

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


    @Test(description = "1_3_2_1 非机构用户，首页搜索课件", groups = {"new_course"})
    public void test1_3_2_1() {
        JSONObject object = studentSearchCourse(no_in_jigou_student, coursewareName);

        if (object.getJSONObject("data").getJSONArray("resultList").stream().anyMatch(i -> {
            JSONObject o = (JSONObject) i;
            return coursewareId.equals(o.getString("coursewareId"));
        })) {
            throw new RuntimeException("非机构用户，搜索到了全封闭机构的课件！");
        }
    }

    @Test(description = "1_3_2_2 机构用户，首页搜索课件", groups = {"new_course"})
    public void test1_3_2_2() {
        in_jigou_student.setOrgId(jigou.getOrgId());
        JSONObject object = studentSearchCourse(in_jigou_student, coursewareName);

        if (object.getJSONObject("data").getJSONArray("resultList").stream().allMatch(i -> {
            JSONObject o = (JSONObject) i;
            return !coursewareId.equals(o.getString("coursewareId"));
        })) {
            throw new RuntimeException("机构用户，没有搜索到了全封闭机构的课件！");
        }
    }


    @Test(description = "1_3_2_3 非机构用户查看机构课件详情", groups = {"new_course"})
    public void test1_3_2_3() {
        JSONObject object = no_in_jigou_student.getApp().mobileAgent().orgCourseList(jigou.getUserId());

        if (object.getJSONArray("data").stream().anyMatch(i -> {
            JSONObject o = (JSONObject) i;
            return coursewareId.equals(o.getString("oldInfoId"));
        })) {
            throw new RuntimeException("在机构详情的课件界面，依旧可以搜到该课件");
        }
    }

    @Test(description = "1_3_2_4 机构用户查看机构课件详情", groups = {"new_course"})
    public void test1_3_2_4() {
        in_jigou_student.setOrgId(jigou.getOrgId());
        JSONObject object = in_jigou_student.getApp().mobileAgent().orgCourseList(jigou.getUserId());

        if (object.getJSONArray("data").stream().allMatch(i -> {
            JSONObject o = (JSONObject) i;
            return !coursewareId.equals(o.getString("oldInfoId"));
        })) {
            throw new RuntimeException("机构用户没有在机构课件详情列表中，查看到相关课件");
        }
    }

    /**
     * 创建 新闻并审核通过
     *
     * @return
     */
    private String messageId;

    @BeforeGroups(groups = "new_message")
    public void creatMessageAndApply() {
        messageId = jigou.creatMessage();
        jigou.getWeb().orgInfoAgent().applyMessage(messageId);
        superAdmin.getManage().orgInfoAgent().replyOrgMessage(messageId);
    }

    @Test(description = "1_3_3_1 非机构用户，搜索新闻", groups = {"new_message"})
    public void test1_3_3_1() {
        JSONObject object = no_in_jigou_student.getApp().topAgent().v2OrgMsgList();
        if (object.getJSONObject("data").getJSONArray("orgMsgList").stream().anyMatch(i -> {
            JSONObject o = (JSONObject) i;
            return messageId.equals(o.getString("messageId"));
        })) {

            throw new RuntimeException("非机构用户可以搜索到新闻");
        }
    }

    @Test(description = "1_3_3_2 非机构用户，搜索新闻", groups = {"new_message"})
    public void test1_3_3_2() {
        in_jigou_student.setOrgId(jigou.getOrgId());
        JSONObject object = in_jigou_student.getApp().topAgent().v2OrgMsgList();
        if (object.getJSONObject("data").getJSONArray("orgMsgList").stream().allMatch(i -> {
            JSONObject o = (JSONObject) i;
            return !messageId.equals(o.getString("messageId"));
        })) {

            throw new RuntimeException("机构用户搜索新闻，未搜索到");
        }
    }

    private String teacher_userId;

    @BeforeGroups(groups = "new_teacher")
    public void beforeGroups_new_teacher() {
        try {
            teacher_userId = jigou.addTeacher("18766700055");
        } catch (Exception e) {
            jigou.delTeacher(teacher_userId);
            try {
                teacher_userId = jigou.addTeacher("18766700055");
            } catch (Exception a) {
                throw new RuntimeException(a);
            }
        }
    }

    @Test(description = "1_4_1 机构教师显示在机构教师列表中", groups = "new_teacher")
    public void test1_4_1() {

        JSONObject object = no_in_jigou_student.getApp().mobileAgent().orgUserList(jigou.getUserId());

        if (object.getJSONArray("data").stream().allMatch(i -> {
            JSONObject o = (JSONObject) i;
            return !teacher_userId.equals(o.getString("userId"));
        })) {
            throw new RuntimeException("机构教师没有显示在机构列表里");
        }
    }

    @AfterGroups(groups = "new_teacher")
    public void afterGroups_new_teacher() {
        jigou.delTeacher(teacher_userId);
    }

    @Test(description = "1_4_2 机构学生，不显示在机构教师列表中")
    public void test1_4_2() {
        JSONObject object = no_in_jigou_student.getApp().mobileAgent().orgUserList(jigou.getUserId());

        if (object.getJSONArray("data").stream().anyMatch(i -> {
            JSONObject o = (JSONObject) i;
            return in_jigou_student.getUserId().equals(o.getString("userId"));
        })) {

            throw new RuntimeException("机构用户管理的教师列表, 返回了学生的数据");
        }

    }


}
