package TestCase.kacha.report;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.kacha.GlobalKC;
import com.mizholdings.kacha.mod.MODReport;
import com.mizholdings.kacha.playload.PLReport;
import com.mizholdings.kacha.user.KCParent;
import com.mizholdings.kacha.user.KCSuperAdmin;
import com.mizholdings.util.SampleAssert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestReportCase {

    private KCParent parent;
    private KCSuperAdmin surpeAdmin;
    private MODReport modReport;

    @BeforeClass
    public void beforeClass() {
        parent = GlobalKC.init().getParent();
        surpeAdmin = GlobalKC.init().getSuperAdmin();

        modReport = new MODReport(surpeAdmin);
    }

    @Test(description = "7_1_1 查询数据报告详情")
    public void test7_1_1() {
        JSONObject object = modReport.dbQrdetail(GlobalKC.getClassId());
        SampleAssert.assertEquals("查询成功!", object);
    }


    @Test(description = "7_1_2 查询报告学生统计")
    public void test7_1_2() {
        JSONObject object = modReport.dbQrstudentcount(GlobalKC.getClassId());
        SampleAssert.assertEquals("查询成功!", object);
    }

    @Test(description = "7_1_3 查询校级报告")
    public void test7_1_3() {
        JSONObject object = modReport.dbSchooldatareport(GlobalKC.getSchoolId(), GlobalKC.getClassId());
        SampleAssert.assertEquals("查询成功!", object);
    }

    @Test(description = "7_1_4 查询班级报告")
    public void test7_1_4() {
        JSONObject object = modReport.dbClassdatareport(GlobalKC.getClassId());
        SampleAssert.assertEquals("查询成功!", object);
    }

    @Test(description = "7_1_5 查询学生提交情况")
    public void test7_1_5() {
        JSONObject object = modReport.dbQueryqrdetailforgz(GlobalKC.getClassId());
        SampleAssert.assertEquals("查询成功!", object);
    }

    @Test(description = "7_1_6  根据班级ID获取知识点列表")
    public void test7_1_6() {
        JSONObject object = modReport.dbKnowledgelist(GlobalKC.getClassId());
        SampleAssert.assertEquals("查询成功!", object);
    }

    @Test(description = "7_1_7 学生统计信息")
    public void test7_1_7() {
        JSONObject object = modReport.dbQueryqrstudentcountforgz(GlobalKC.getClassId());
        SampleAssert.assertEquals("查询成功!", object);
    }

    @Test(description = "7_1_8 题目统计信息")
    public void test7_1_8() {
        JSONObject object = modReport.dbQueryqrquestioncountforgz(GlobalKC.getClassId());
        SampleAssert.assertEquals("查询成功!", object);
    }

    @Test(description = "")
    public void test() {
        JSONObject object = modReport.dbQueryqrquestioncountforgz(GlobalKC.getClassId());
        SampleAssert.assertEquals("查询成功!", object);



    }


}
