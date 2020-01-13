package jigouTest;

import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.Global;
import com.mizholdings.me2.user.Jigou;
import com.mizholdings.me2.user.SuperAdmin;
import com.mizholdings.me2.user.UserBase;
import com.mizholdings.util.Common;
import com.mizholdings.util.SampleAssert;
import org.testng.annotations.*;

import java.util.Arrays;
import java.util.List;

public class jigouAuthTestCase {

    /**
     * 全封闭用户，登录权限有限制
     * <p>
     * 非机构用户，无法登录机构app
     * <p>
     * 用户加入机构后，可以登录app
     */

    private Jigou fengbi = Global.init().getFengBiJigou();


    @Test(description = "非机构用户登录机构")
    public void not_in_login() {
        UserBase student = Global.init().getUserBase();
        student.setOrgId(fengbi.getOrgId());
        JSONObject object = student.login();
        SampleAssert.assertMsg("您的账号不在授权范围内，请联系学校教务处!", object);
    }

    /**
     * 用户未加入机构时，登录。
     * 返回信息应是 您的账号不在授权范围内，请联系学校教务处!
     */
    @Test(description = "用户加入 封闭机构后，登录")
    public void join_and_login() {
        UserBase student = Global.init().getUserBase();
        student.setOrgId(fengbi.getOrgId());

        // 未加入机构时，登录
        JSONObject object = student.login();
        SampleAssert.assertMsg("您的账号不在授权范围内，请联系学校教务处!", object);
        // 用户加入机构
        studentJoinJigou(student);
        // 成功登录
        object = student.login();
        // 用户退出机构
        studentQuitJigou(student);
        // 断言
        SampleAssert.assertMsg("查询成功", object);
    }

    private JSONObject studentJoinJigou(UserBase student) {
        return fengbi.getWeb().orgInfoAgent().addStudentToOrg(student.getAccount());
    }

    private JSONObject studentQuitJigou(UserBase student) {
        return fengbi.getWeb().usrAgent().orgDelStudent(student.getUserId());
    }






}
