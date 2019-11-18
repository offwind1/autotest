package TestCase.kacha.wrongbook;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.kacha.GlobalKC;
import com.mizholdings.kacha.box.SLOTWrongBook;
import com.mizholdings.kacha.mod.MODWrongBook;
import com.mizholdings.kacha.user.KCParent;
import com.mizholdings.util.SampleAssert;
import com.mizholdings.util.Warehouse;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestWrongBookCase {

    private KCParent parent;
    private SLOTWrongBook slotWrongBook;
    private MODWrongBook modWrongBook;

    @BeforeClass
    public void beforeClass() {
        parent = GlobalKC.init().getParent();
//        slotWrongBook = new SLOTWrongBook(parent);
        modWrongBook = new MODWrongBook(parent);
    }


    @Test(description = "5_1_1 上传页面+提交错题")
    public void test5_1_1() {

        JSONObject object = modWrongBook.page(GlobalKC.getImageUrl(), GlobalKC.getChildId());
        SampleAssert.assertEquals("上传成功!", object);

        object = modWrongBook.commit(object, GlobalKC.getChildId());
        SampleAssert.assertEquals("上传成功!", object);
    }

    @Test(description = "5_1_4  题目学科选择器")
    public void test5_1_4() {
        modWrongBook.questionSelector("10", GlobalKC.getChildId());

    }

    private String wrongId;

    @Test(description = "5_1_5 查看错题列表")
    public void test5_1_5() {
        JSONObject object = modWrongBook.questions("10", GlobalKC.getChildId());
        wrongId = object.getJSONObject("data").getJSONArray("list").getJSONObject(0).getString("wrongId");
    }

    @Test(description = "5_1_6 查看错题详情", dependsOnMethods = {"test5_1_5"})
    public void test5_1_6() {
        modWrongBook.questionDetail(wrongId);
    }

    @Test(description = "5_1_2 提交报告")
    public void test5_1_2() {
        modWrongBook.commitReport(GlobalKC.getChildId());
    }

    @Test(description = "5_1_3 作业报告")
    public void test5_1_3() {
        modWrongBook.reportQuerychildreprotgz(GlobalKC.getChildId());
    }

    @Test(description = "5_1_7 查看页面列表")
    public void test5_1_7() {
        modWrongBook.pages("10", GlobalKC.getChildId());
    }

}
