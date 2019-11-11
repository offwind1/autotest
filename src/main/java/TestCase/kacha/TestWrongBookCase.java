package TestCase.kacha;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.kacha.core.GlobalKC;
import com.mizholdings.kacha.core.mod.MODWrongBook;
import com.mizholdings.kacha.core.slot.SLOTWrongBook;
import com.mizholdings.kacha.core.user.KCParent;
import com.mizholdings.kacha.playload.PLWrongbook;
import com.mizholdings.util.SampleAssert;
import com.myreport.Title;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestWrongBookCase {

    private KCParent parent;
    private SLOTWrongBook slotWrongBook;

    @BeforeClass
    public void beforeClass() {
        parent = GlobalKC.init().getParent();
        slotWrongBook = new SLOTWrongBook(parent);
    }


    @Test(description = "上传页面 + 提交错题")
    public void test1() {
        // 上传页面
        JSONObject object = slotWrongBook.uploadPage();
        SampleAssert.assertEquals("上传成功!", object);

        //提交错题
        JSONObject jsonObject = slotWrongBook.commitWrongQuestionByJsonObject(object);
        SampleAssert.assertEquals("上传成功!", jsonObject);
    }


    @Test(description = "题目学科选择器")
    public void test3() {
        JSONObject object = slotWrongBook.questionSelector();
        SampleAssert.assertEquals("查询成功", object);
    }


    @Test(description = "查看错题列表 + 查看错题详情")
    public void test4() {
        // 查看错题列表
        JSONObject object = slotWrongBook.getQuestions();
        SampleAssert.assertEquals("查询成功", object);
        Assert.assertTrue(object.getJSONObject("data").getJSONArray("list") != null);
        String wrongId = object.getJSONObject("data").getJSONArray("list").getJSONObject(0).getString("wrongId");

        // 查看错题详情
        object = slotWrongBook.getQuestionDetail(wrongId);
        SampleAssert.assertEquals("查询成功", object);
    }

    @Test(description = "查看页面列表")
    public void test5() {
        JSONObject object = slotWrongBook.getPages();
        SampleAssert.assertEquals("查询成功", object);
    }


    @Test(description = "作业报告")
    public void test6() {
        JSONObject object = slotWrongBook.getReportQuerychildreprotgz();
        SampleAssert.assertEquals("查询成功！", object);
        System.out.println(object);
    }

    @Test(description = "提交报告")
    public void test7() {
        JSONObject object = slotWrongBook.getCommitReport();
        SampleAssert.assertEquals("上传成功!", object);
        System.out.println(object);
    }


}
