package lessonTest;

import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.ComboUtil;
import com.mizholdings.me2.Global;
import com.mizholdings.me2.Global_enum;
import com.mizholdings.me2.user.Jigou;
import com.mizholdings.me2.user.SuperAdmin;
import com.mizholdings.me2.user.UserBase;
import com.mizholdings.util.Common;
import com.mizholdings.util.Parameter;
import com.mizholdings.util.SampleAssert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * 课程库测试
 */
public class ClassLibraryTest {

    private Jigou jigou = Global.init().getOpenBiJigou();
    private Jigou other_jigou = Global.init().getFengBiJigou();
    private SuperAdmin superAdmin = Global.init().getSuperAdmin();
    private String lessonId;

    /**
     * 创建了课程库课程
     */
    @BeforeClass
    public void beforeClass() {
        lessonId = jigou.newLessonAndGetLessonId(Global_enum.CustRelease.CLASS_LIB);
        ComboUtil.applyLesson(Global.init().getSuperAdmin(), jigou, lessonId);
    }

    /**
     * 创建了课程库课程的机构本身，在自己的课程库中不会出现该课程
     */
    @Test(description = "机构本人查看课程库列表")
    public void stockList_test() {
        JSONObject object = jigou.getWeb().lessonAgent().stockList(jigou.getOrgId());
        object = Common.filder(object.getJSONObject("data").getJSONArray("list"), lessonId, "lessonId");

        if (ObjectUtil.isNotNull(object)) {
            throw new RuntimeException("创建了课程库课程的机构本身，在自己的课程库中不应该出现该课程");
        }
    }

    /**
     * 管理员查看课程库，搜索到该课程
     */
    @Test(description = "管理员查看课程库")
    public void stockList_superAdmin_test() {
        JSONObject object = superAdmin.getManage().lessonAgent().stockList();
        object = Common.filder(object.getJSONObject("data").getJSONArray("list"), lessonId, "lessonId");

        if (ObjectUtil.isNull(object)) {
            throw new RuntimeException("管理员查看课程库，未搜索到对应课程");
        }
    }

    /**
     * 另一个机构用户，搜索该课程
     */
    @Test(description = "机构查看课程库")
    public void stockList_jigou_test() {
        JSONObject object = other_jigou.getWeb().lessonAgent().stockList(other_jigou.getOrgId());
        object = Common.filder(object.getJSONObject("data").getJSONArray("list"), lessonId, "lessonId");

        if (ObjectUtil.isNull(object)) {
            throw new RuntimeException("机构查看课程库，未搜索到对应课程");
        }
    }

    /**
     * 管理员，添加课程后。管理员已选课程列表
     */
    @Test(description = "管理员，添加课程后。管理员已选课程列表", priority = 1)
    public void superAdmin_stockJoin_test() {
        JSONObject object = superAdmin.getManage().lessonAgent().stockJoin(lessonId);
        SampleAssert.assertCode200(object);

        object = superAdmin.getManage().lessonAgent().stockMy();
        SampleAssert.assertCode200(object);

        object = Common.filder(object.getJSONObject("data").getJSONArray("list"), lessonId, "lessonId");
        if (ObjectUtil.isNull(object)) {
            throw new RuntimeException("选课后，已选课列表中未找到该课程");
        }
    }


    /**
     * 另一个机构用户，添加课程后。已选课程列表
     */
    @Test(description = "机构用户，添加课程后。已选课程列表", priority = 1)
    public void Jigou_stockJoin_test() {
        JSONObject object = other_jigou.getWeb().lessonAgent().stockJoin(lessonId, other_jigou.getOrgId());
        SampleAssert.assertCode200(object);

        object = other_jigou.getWeb().lessonAgent().stockMy(other_jigou.getOrgId());
        SampleAssert.assertCode200(object);

        object = Common.filder(object.getJSONObject("data").getJSONArray("list"), lessonId, "lessonId");
        if (ObjectUtil.isNull(object)) {
            throw new RuntimeException("选课后，已选课列表中未找到该课程");
        }
    }


    /**
     * 管理员，添加课程后。八橙用户搜索课程
     */
    @Test(description = "管理员，添加课程后。八橙用户搜索课程", priority = 2)
    public void topMore_8cheng_test() {
        UserBase student = Global.init().getUserBase();

        JSONObject object = student.getApp().topAgent().topMore(Parameter.creat()
                .add("gradeId", "1")
                .add("topId", "1")
                .add("hotTop", "1")
                .add("page", "1")
        );

        object = Common.filder(object.getJSONArray("data"), lessonId, "lessonId");

        if (ObjectUtil.isNull(object)) {
            throw new RuntimeException("八橙用户未搜索到该课程");
        }
    }

    /**
     * 另一个机构用户，添加课程后。在课程管理界面，筛选课程库课程
     */
    @Test(description = "另一个机构用户，添加课程后。在课程管理界面，筛选课程库课程", priority = 2)
    public void filtrate_jigou_test() {
        JSONObject object = other_jigou.getWeb().lessonAgent().list_stock();

        object = Common.filder(object.getJSONObject("data").getJSONArray("list"), lessonId, "lessonId");
        if (ObjectUtil.isNull(object)) {
            throw new RuntimeException("筛选课程库课程，未搜索到该课程");
        }
    }


    /**
     * 另一个机构用户，添加课程后，该机构用户搜索课程
     */
    @Test(description = "另一个机构用户，添加课程后，该机构用户搜索课程", priority = 2)
    public void topMore_jigou_test() {
        UserBase student = Global.init().getUserBase();
        student.setOrgId(other_jigou.getOrgId());

        JSONObject object = student.getApp().topAgent().topMore(Parameter.creat()
                .add("gradeId", "1")
                .add("topId", "1")
                .add("hotTop", "1")
                .add("page", "1")
        );

        object = Common.filder(object.getJSONArray("data"), lessonId, "lessonId");

        if (ObjectUtil.isNull(object)) {
            throw new RuntimeException("机构用户未搜索到该课程");
        }
    }

    /**
     * 未加入的机构，机构用户无法搜索到该课程
     */
    @Test(description = "另一个机构用户，添加课程后，该机构用户搜索课程", priority = 2)
    public void topMore_other_jigou_test() {
        UserBase student = Global.init().getUserBase();
        student.setOrgId("9017");

        JSONObject object = student.getApp().topAgent().topMore(Parameter.creat()
                .add("gradeId", "1")
                .add("topId", "1")
                .add("hotTop", "1")
                .add("page", "1")
        );

        object = Common.filder(object.getJSONArray("data"), lessonId, "lessonId");

        if (ObjectUtil.isNotNull(object)) {
            throw new RuntimeException("未加入的机构，也搜索到了该课程");
        }
    }


}
