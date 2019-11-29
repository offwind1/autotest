package TestCase.me2.normalTest;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.GlobalMe2;
import com.mizholdings.me2.user.Me2SuperAdmin;
import com.mizholdings.me2.user.Me2Teacher;
import com.mizholdings.me2.user.Me2UserBase;
import com.mizholdings.util.Common;
import com.mizholdings.util.SampleAssert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class creditTestCase {
    private Me2Teacher teacher;
    private Me2UserBase student;
    private String creditId;

    @BeforeClass()
    public void beforeClass() {
        teacher = GlobalMe2.init().getTeacher();
        student = GlobalMe2.init().getUser();
    }

    @Test(description = "添加学分信息web/credit/addCreditInfo")
    public void test_credit_addCreditInfo() {
        JSONObject object = teacher.getWeb().creditAgent().addCreditInfo("喵喵", GlobalMe2.getImageUrl());
        SampleAssert.assertCode200(object);
    }

    @Test(description = "根据用户查询学分web/credit/creditList")
    public void test_credit_creditList() {
        JSONObject object = teacher.getWeb().creditAgent().creditList();
        SampleAssert.assertCode200(object);
    }

    @Test(description = "获取用户学分信息web/credit/getCreditByUserId")
    public void test_credit_getCreditByUserId() {
        JSONObject object = teacher.getWeb().creditAgent().getCreditByUserId();
        creditId = object.getJSONObject("data").getJSONObject("info").getString("creditId");
    }

    @Test(description = "用户积分记录web/credit/userCredit", dependsOnMethods = {"test_credit_getCreditByUserId"})
    public void test_credit_userCredit() {
        teacher.getWeb().creditAgent().userCredit(teacher.getUserId(), creditId);
    }

    @Test(description = "修改学分信息web/credit/editCreditInfo", dependsOnMethods = {"test_credit_getCreditByUserId"})
    public void test_credit_editCreditInfo() {
        JSONObject object = teacher.getWeb().creditAgent().editCreditInfo(creditId, GlobalMe2.getImageUrl(), "喵币");
        SampleAssert.assertCode200(object);
    }

    @Test(description = "修改积分web/credit/editUserCredit", dependsOnMethods = {"test_credit_getCreditByUserId"})
    public void test_credit_editUserCredit() {
        JSONObject object = teacher.getWeb().creditAgent().editUserCredit(student.getUserId(), creditId, "10");
        SampleAssert.assertCode200(object);
    }

    @Test(description = "查询课程列表web/credit/creditLessonList")
    public void test_credit_creditLessonList() {
        JSONObject object = teacher.getWeb().creditAgent().creditLessonList();
        SampleAssert.assertCode200(object);
    }

    @Test(description = "学分资源列表web/credit/creditCourseList")
    public void test_credit_creditCourseList() {
        JSONObject object = teacher.getWeb().creditAgent().creditCourseList();
        SampleAssert.assertCode200(object);
    }

    @Test(description = "学生学习资源，获取学分 app/credit/addByCourse")
    public void test_credit_addByCourse() {
        String coursewareId = teacher.newCourseAndApply(Common.creatRandomString(), "4");
        JSONObject object = student.getApp().creditAgent().addByCourse(coursewareId);
        SampleAssert.throwResult0(object);
    }

    @Test(description = "学生学习课堂，老师指定学分app/credit/addByClassroom")
    public void test_credit_addByClassroom() {
        JSONObject object = teacher.getApp().creditAgent().addByClassroom("c0e749cc33f94678a64dfee3eb92a8eb", student.getUserId(), "3");
        SampleAssert.throwMsg("获得学分成功", object);
    }

    @Test(description = "用户查询自己的学分app/credit/getCreditList")
    public void test_credit_getCreditList() {
        JSONObject object = student.getApp().creditAgent().getCreditList();
        SampleAssert.throwMsg("获得学分成功", object);
    }

}
