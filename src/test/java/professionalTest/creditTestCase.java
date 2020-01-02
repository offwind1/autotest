package professionalTest;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.Global;
import com.mizholdings.me2.user.Teacher;
import com.mizholdings.me2.user.UserBase;
import com.mizholdings.util.Common;
import com.mizholdings.util.SampleAssert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class creditTestCase {

    private Teacher no_credit_teacher;
    private Teacher teacher;
    private UserBase student;
    private String creditId;

    @BeforeClass()
    public void beforeClass() {
        no_credit_teacher = Global.init().getRandomTeacher();
        teacher = Global.init().getTeacher();
        student = Global.init().getUserBase();

        JSONObject object = teacher.getWeb().creditAgent().getCreditByUserId();
        creditId = object.getJSONObject("data").getJSONObject("info").getString("creditId");
    }

    @Test(description = "7_1 未创建学分的情况下，查询学分")
    public void test_7_1() {
        JSONObject object = no_credit_teacher.getWeb().creditAgent().creditList();
        SampleAssert.assertMsg("学分未创建!", object);
    }

    @Test(description = "7_2 未创建学分的情况下，获取用户学分信息")
    public void test_7_2() {
        JSONObject object = no_credit_teacher.getWeb().creditAgent().getCreditByUserId();
        SampleAssert.assertMsg("未查询到!", object);
    }

    @Test(description = "7_3 修改其他人的学分信息")
    public void test_7_3() {
        JSONObject object = no_credit_teacher.getWeb().creditAgent().editCreditInfo(creditId, Global.getImageUrl(), Common.creatRandomString());
        if ("200".equals(object.getString("code"))) {
            throw new RuntimeException("可以修改其他人的学分信息");
        }
    }

    @Test(description = "7_4 修改其他学分的积分")
    public void test_7_4() {
        JSONObject object = no_credit_teacher.getWeb().creditAgent().editUserCredit(student.getUserId(), creditId, "100");
        SampleAssert.assertMsg("修改失败", object);
    }

    @Test(description = "7_5 修改 不存在的学分信息")
    public void test_7_5() {
        JSONObject object = no_credit_teacher.getWeb().creditAgent().editCreditInfo("999", Global.getImageUrl(), Common.creatRandomString());
        SampleAssert.assertMsg("修改失败", object);
    }

    @Test(description = "7_6 给学生设置不存在的学分")
    public void test_7_6() {
        JSONObject object = no_credit_teacher.getWeb().creditAgent().editUserCredit(student.getUserId(), "999", "100");
        SampleAssert.assertMsg("修改失败", object);
    }

    @Test(description = "7_7 给学生设置学分为负")
    public void test_7_7() {
        JSONObject object = teacher.getWeb().creditAgent().editUserCredit(student.getUserId(), creditId, "-100");
        SampleAssert.assertMsg("修改失败", object);
    }

    //TODO /mizhu/web/credit/creditList 根据用户查询学分. 返回的班级数据，是如何定义的。一个学生可以有多个班级的话，这里返回的班级数据是怎么判断显示的

    //TODO 学生学习资源，获取学分credit/addByCourse (学生端调用
    //TODO 是否可以反复调用
    //TODO 是否可以对未设置学分的资源，调用该接口。接口返回是否正常
    //TODO 学生调用该接口（通过资源获取学分）后，是否可以通过 /credit/creditList 接口。查询到该学生的积分获取记录


}
