package TestCase.cross12;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.kacha.GlobalKC;
import com.mizholdings.kacha.user.KCSchooler;
import com.mizholdings.kacha.user.KCSuperAdmin;
import com.mizholdings.me2.core.user.Me2Jigou;
import com.myreport.Title;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * 一期二期打通测试
 */
@Epic("一期二期打通测试")
public class TestCross12Case {

    private KCSuperAdmin kcSurpeAdmin;
    private Me2Jigou me2Jigou;
    private KCSchooler kcSchooler;

    private String schoolId;
    private String schoolName;
    private String classId;

    @BeforeClass(description = "初始化账号")
    public void beforeClass() {
        kcSurpeAdmin = GlobalKC.init().getSuperAdmin();
        me2Jigou = new Me2Jigou("cross12", "111111");
        kcSchooler = new KCSchooler("cross12", "111111");

        schoolId = "8747";
        schoolName = "一期二期账号打通测试机构";

        init();
    }

    @Story("创建新的班级")
    public void init() {
        JSONObject addClass = me2Jigou.addClass(schoolName, schoolId, "测试课程");
        System.out.println(addClass);

        JSONObject classList = kcSchooler.classList(schoolId);
        int classId = classList.getJSONObject("data")
                .getJSONArray("list")
                .getJSONObject(0)
                .getInteger("classId");

        System.out.println(classId);

        JSONObject object = me2Jigou.classList(schoolName);
        int stuId = object.getJSONObject("data").getJSONArray("list")
                .getJSONObject(0).getInteger("stuId");
        System.out.println(object);

        Assert.assertEquals(classId, stuId);
        this.classId = String.valueOf(classId);
    }


    @Test
    @Title("二期修改个人信息，一期同步")
    public void test1() {
        JSONObject object = me2Jigou.editNickName(schoolName + "123");
        System.out.println(object);

        JSONObject userInfo = kcSchooler.getUserInfo();
        Assert.assertEquals(schoolName + "123",
                userInfo.getJSONObject("data").getString("name"));
        System.out.println(userInfo);

        me2Jigou.editNickName(schoolName);
    }


    @Test
    @Title("二期导入学生，同步到一期")
    public void test2() {
        String userId = "4486398101015552";

        JSONObject object = me2Jigou.joinClassByUserId(userId, classId);
        System.out.println(object);

        object = kcSchooler.classMembers(schoolId, classId);
        System.out.println(object);
        Assert.assertEquals(userId, object.getJSONArray("data").getJSONObject(0).getString("userId"));
        assert object.getJSONArray("data").getJSONObject(0).containsKey("name") : "用户列表没有name值";
    }

    @AfterClass
    public void afterClass() {
        JSONObject object = me2Jigou.delClass(classId);
        System.out.println(object);
    }


}
