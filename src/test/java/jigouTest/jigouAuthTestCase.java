package jigouTest;

import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.Global;
import com.mizholdings.me2.user.Jigou;
import com.mizholdings.me2.user.SuperAdmin;
import com.mizholdings.me2.user.UserBase;
import com.mizholdings.util.Common;
import com.mizholdings.util.SampleAssert;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class jigouAuthTestCase {

    List<String> list = Arrays.asList("8628", "8587", "8398", "8419");

    @Test(description = "非机构用户登录")
    public void test1_2_1_1() {
        for (String orgId : list) {
            UserBase.orgLogin(orgId);
        }
    }

    private Jigou jigou = Global.init().getFengBiJigou();
    private UserBase student = Global.init().getUserBase();

    @Test(description = "机构加入用户", priority = -1)
    public void student_join_test() {
        JSONObject object = studentJoinJigou(student);

        assert object.getJSONObject("data").getJSONArray("userList").stream().anyMatch(i -> {
            JSONObject o = (JSONObject) i;
            return student.getUserId().equals(o.getString("userId"));
        });
    }

    @Test(description = "登录测试")
    public void login_test() {
        UserBase.Login(student.getAccount(), "111111", jigou.getOrgId());

    }


    @Test(description = "机构详情，教师列表")
    public void beforeGroups_new_teacher() {
        String teacher_userId = jigou.addTeacher("18766700055");
        JSONObject object = student.getApp().mobileAgent().orgUserList(jigou.getUserId());

        if (ObjectUtil.isNull(Common.filder(object.getJSONArray("data"), teacher_userId, "userId"))) {
            throw new RuntimeException("机构教师列表未查询到教师");
        }
        if (ObjectUtil.isNull(Common.filder(object.getJSONArray("data"), student.getUserId(), "userId"))) {
            throw new RuntimeException("机构用户管理的教师列表, 返回了学生的数据");
        }

        jigou.delTeacher(teacher_userId);
    }


    @Test(description = "机构踢出用户", priority = 2)
    public void student_delete_test() {
        JSONObject object = studentQuitJigou(student);
        SampleAssert.assertCode200(object);
    }


    private JSONObject studentJoinJigou(UserBase student) {
        return jigou.getWeb().orgInfoAgent().addStudentToOrg(student.getAccount());
    }

    private JSONObject studentQuitJigou(UserBase student) {
        return jigou.getWeb().usrAgent().orgDelStudent(student.getUserId());
    }

}
