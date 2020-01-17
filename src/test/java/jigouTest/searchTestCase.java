package jigouTest;

import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.Global;
import com.mizholdings.me2.Global_enum;
import com.mizholdings.me2.agent.app.FullschAgent;
import com.mizholdings.me2.user.Jigou;
import com.mizholdings.me2.user.UserBase;
import com.mizholdings.me2.user.serve.ServeBase;
import com.mizholdings.util.Common;
import com.mizholdings.util.SampleAssert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * 机构搜索相关的测试用例
 */
public class searchTestCase {

    private UserBase student = Global.init().getUserBase();
    private UserBase no_student = Global.init().getUserBase();
    private Jigou jigou = Global.init().getOpenBiJigou();

    @BeforeClass
    public void before() {
        student.setOrgId("8358");
        no_student.setOrgId("9017");
    }

    /**
     * 机构用户只能搜索到该机构下的机构
     * 课程、
     * 课件（开放的）、
     * 师资（包括 教师和学生。以认证和未认证区分、
     * 新闻（只能搜索到本机构的新闻
     * <p>
     * 以七檬机构为测试对象
     * orgId = 8358
     * 课程名：七檬测试课程
     * 课件名：找到我了吗
     * 学生名：机器人0222
     * 新闻： 七檬测试新闻
     */
    @Test(description = "机构搜索课程")
    public void search_lesson_test() {
        //lesson
        JSONObject object = student.getApp().fullschAgent().searchAll2("七檬测试课程", Global_enum.TYPE.LESSON, ServeBase.GRADEID.SEVEN);
        SampleAssert.assertResult0(object);
        object = Common.filder(object.getJSONObject("data").getJSONArray("resultList"), "七檬测试课程", "lessonName");
        if (ObjectUtil.isNull(object)) {
            throw new RuntimeException("本机构用户，未搜索到该课程");
        }

        object = no_student.getApp().fullschAgent().searchAll2("七檬测试课程", Global_enum.TYPE.LESSON, ServeBase.GRADEID.SEVEN);
        SampleAssert.assertResult0(object);
        object = Common.filder(object.getJSONObject("data").getJSONArray("resultList"), "七檬测试课程", "lessonName");
        if (ObjectUtil.isNotNull(object)) {
            throw new RuntimeException("其他机构用户，搜索到了该课程");
        }
    }

    @Test(description = "机构搜索课件")
    public void search_courseware_test() {
        //courseware
        JSONObject object = student.getApp().fullschAgent().searchAll2("找到我了吗", Global_enum.TYPE.COURSE, ServeBase.GRADEID.SEVEN);
        SampleAssert.assertResult0(object);
        object = Common.filder(object.getJSONObject("data").getJSONArray("resultList"), "找到我了吗", "coursewareName");
        if (ObjectUtil.isNull(object)) {
            throw new RuntimeException("本机构用户，未搜索到该课件");
        }

        object = no_student.getApp().fullschAgent().searchAll2("找到我了吗", Global_enum.TYPE.COURSE, ServeBase.GRADEID.SEVEN);
        SampleAssert.assertResult0(object);
        object = Common.filder(object.getJSONObject("data").getJSONArray("resultList"), "找到我了吗", "coursewareName");
        if (ObjectUtil.isNotNull(object)) {
            throw new RuntimeException("其他机构用户，搜索到了该课件");
        }
    }

    @Test(description = "机构搜索师资")
    public void search_teacher_test() {
        //teacher
        JSONObject object = student.getApp().fullschAgent().searchAll2("机器人0222", Global_enum.TYPE.TEACHER, ServeBase.GRADEID.SEVEN);
        SampleAssert.assertResult0(object);
        object = Common.filder(object.getJSONObject("data").getJSONArray("resultList"), "机器人0222", "userName");
        if (ObjectUtil.isNull(object)) {
            throw new RuntimeException("本机构用户，未搜索到该师资");
        }

        object = no_student.getApp().fullschAgent().searchAll2("机器人0222", Global_enum.TYPE.TEACHER, ServeBase.GRADEID.SEVEN);
        SampleAssert.assertResult0(object);
        object = Common.filder(object.getJSONObject("data").getJSONArray("resultList"), "机器人0222", "userName");
        if (ObjectUtil.isNotNull(object)) {
            throw new RuntimeException("其他机构用户，搜索到了该师资");
        }
    }


    @Test(description = "机构搜索新闻")
    public void search_message_test() {
        //message
        JSONObject object = student.getApp().fullschAgent().searchAll2("七檬测试新闻", Global_enum.TYPE.JIGOU, ServeBase.GRADEID.SEVEN);
        SampleAssert.assertResult0(object);
        object = Common.filder(object.getJSONObject("data").getJSONArray("resultList"), "七檬测试新闻", "messageName");
        if (ObjectUtil.isNull(object)) {
            throw new RuntimeException("本机构用户，未搜索到该新闻");
        }

        object = no_student.getApp().fullschAgent().searchAll2("七檬测试新闻", Global_enum.TYPE.JIGOU, ServeBase.GRADEID.SEVEN);
        SampleAssert.assertResult0(object);
        object = Common.filder(object.getJSONObject("data").getJSONArray("resultList"), "七檬测试新闻", "messageName");
        if (ObjectUtil.isNotNull(object)) {
            throw new RuntimeException("其他机构用户，搜索到了该新闻");
        }
    }


}
