package TestCase.me2.professionalTest;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.GlobalMe2;
import com.mizholdings.me2.user.Me2Teacher;
import com.mizholdings.me2.playload.PLInteg;
import com.mizholdings.me2.user.Me2UserBase;
import com.mizholdings.util.SampleAssert;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * // * 积分测试
 * //
 */
//@Epic("积分测试class")
public class TestIntegCase {

    private Me2UserBase student;
    private Me2Teacher teacher;
    private String classroomId;
    private String classroomVideoId;
    private String teacherCloudeAccount;
    private String lessonId;

    @BeforeClass(description = "初始化")
    public void beforeClass() {
        student = GlobalMe2.init().getUserBase();
        teacher = GlobalMe2.init().getTeacher();

        JSONObject object = teacher.quickStart();
        SampleAssert.assertEquals("开课成功！", object);

        classroomId = object.getJSONObject("data").getJSONObject("classroomInfo").getString("classroomId");
        classroomVideoId = object.getJSONObject("data").getString("classroomVideoId");
        teacherCloudeAccount = object.getJSONObject("data").getJSONObject("classroomInfo").getString("teacherCloudeAccount");
        lessonId = object.getJSONObject("data").getJSONObject("classroomInfo").getString("lessonId");
    }

    @AfterClass(description = "结束课程")
    @Story("结束课程")
    public void afterClass() {
        JSONObject object = teacher.getApp().classInfoAgent().classroomEnd(classroomVideoId, teacherCloudeAccount);
        SampleAssert.assertEquals("回填成功！", object);
        System.out.println(object);
    }


    @Test(description = "讲师同意举手,获得1积分")
    public void test1() {
        //获取当前学生的积分
        JSONObject studentUserInfo = student.getApp().mobileAgent().userInfo();
        int studentInteg = studentUserInfo.getJSONObject("data").getInteger("integ");

        JSONObject object = teacher.getApp().integAgent().execute(student.getCloudUsrAccount());
        SampleAssert.assertEquals("执行成功", object);

        //获取学生积分记录
        object = student.getApp().payAgent().userTrans();

        //查看记录中，第一个是获取积分信息
        Assert.assertEquals("积分:讲师同意举手,获得1积分",
                object.getJSONArray("data")
                        .getJSONObject(0)
                        .getString("remark"));

        //获取举手后，学生的积分
        studentUserInfo = student.getApp().mobileAgent().userInfo();
        int temp = studentUserInfo.getJSONObject("data").getInteger("integ");

        //之后的积分，比之前的积分大了1
        Assert.assertTrue((studentInteg + 1) == temp);
    }

    //    //有效开课每次，获得5积分
//    //有效听课每次，获得5积分
//    //开课时长>90分钟，获得12积分
//    //开课时长>90分钟，获得12积分
//    //开课40分钟>时长>20分钟，获得3积分
//    //充值米猪时光赠送积分
//    //修改资料获得5积分
//    //购买获得1积分
//
//
    //课堂文字、拖图片互动 获得3积分
    @Test(description = "课堂文字、拖图片互动 获得3积分")
    public void test7() throws InterruptedException {
        //获取当前学生的积分
        JSONObject studentUserInfo = student.getApp().mobileAgent().userInfo();
        int studentInteg = studentUserInfo.getJSONObject("data").getInteger("integ");

        JSONObject object = teacher.getApp().integAgent().words(student.getCloudUsrAccount());
        SampleAssert.assertEquals("执行成功", object);

        //休眠2秒
        Thread.sleep(1000 * 2);

        //获取学生积分记录
        //查看记录中，第一个是获取积分信息
        object = student.getApp().payAgent().userTrans();
        Assert.assertEquals("积分:课堂文字、图片互动,获得3积分",
                object.getJSONArray("data")
                        .getJSONObject(0)
                        .getString("remark"));

        //获取举手后，学生的积分
        studentUserInfo = student.getApp().mobileAgent().userInfo();
        int temp = studentUserInfo.getJSONObject("data").getInteger("integ");

        System.out.println(temp);
        //之后的积分，比之前的积分大了3
        Assert.assertTrue((studentInteg + 3) == temp);

    }

    //点赞获得1积分
    @Test(description = "点赞获得1积分")
    public void test8() throws InterruptedException {
        //获取当前教师的积分
        JSONObject studentUserInfo = teacher.getApp().mobileAgent().userInfo();
        int teacherInteg = studentUserInfo.getJSONObject("data").getInteger("integ");

        //学生点赞课程
        JSONObject object = student.getApp().lessonInfoAgent().likedLesson(lessonId);
        SampleAssert.assertEquals("点赞课程成功", object);

        //休眠2秒
        Thread.sleep(1000 * 2);

        //获取积分记录
        //查看记录中，第一个是获取积分信息
        object = teacher.getApp().payAgent().userTrans();
        System.out.println(object);
        Assert.assertEquals("积分:点赞,获得1积分",
                object.getJSONArray("data")
                        .getJSONObject(0)
                        .getString("remark"));

        //点赞后， 教师的积分
        studentUserInfo = teacher.getApp().mobileAgent().userInfo();
        int temp = studentUserInfo.getJSONObject("data").getInteger("integ");
        //之后的积分，比之前的积分大了1
        Assert.assertTrue((teacherInteg + 1) == temp);

    }

    //课堂被点赞(只能三次)
    @Test(description = "学生课堂被点赞（小红花），积分增加（有效执行3次，每次间隔2秒）")
    public void test9() throws InterruptedException {
        //获取当前学生的积分
        JSONObject studentUserInfo = student.getApp().mobileAgent().userInfo();
        int studentInteg = studentUserInfo.getJSONObject("data").getInteger("integ");

        //执行4次点赞
        for (int i = 0; i < 5; i++) {
            JSONObject object = teacher.getApp().classInfoAgent().laudStudent(classroomId, student.getCloudUsrAccount());
            SampleAssert.assertEquals("执行成功", object);
            //休眠2秒
            Thread.sleep(1000 * 2);
        }

        //获取学生积分记录
        //查看记录中，第一个是获取积分信息
        JSONObject object = student.getApp().payAgent().userTrans();
        Assert.assertEquals("积分:课堂被点赞,获得1积分",
                object.getJSONArray("data")
                        .getJSONObject(0)
                        .getString("remark"));

        //获取举手后，学生的积分
        studentUserInfo = student.getApp().mobileAgent().userInfo();
        int temp = studentUserInfo.getJSONObject("data").getInteger("integ");

        //之后的积分，比之前的积分大了3
        Assert.assertTrue((studentInteg + 3) == temp);

    }


}
