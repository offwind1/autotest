package com.mizholdings.kacha.box;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mizholdings.kacha.GlobalKC;
import com.mizholdings.kacha.mod.MODWrongBook;
import com.mizholdings.kacha.user.KCParent;
import com.mizholdings.kacha.playload.PLWrongbook;
import com.mizholdings.util.SampleAssert;
import lombok.Data;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class SLOTWrongBook {
    private KCParent executor;
    private MODWrongBook modWrongBook;
    private String childId;

    public SLOTWrongBook(KCParent executor) {
        this.executor = executor;
        modWrongBook = new MODWrongBook(executor);
        childId = executor.currentChild();
    }

    /**
     * 上传页面
     */
    public JSONObject uploadPage() {
        PLWrongbook plWrongbook = new PLWrongbook();
        plWrongbook.setPage(GlobalKC.init().properties.getProperty("kacha.page.url"), childId);

        JSONObject object = modWrongBook.page(plWrongbook);
        return object;
    }

    /**
     * 题目学科选择器
     *
     * @return
     */
    public JSONObject questionSelector() {
        PLWrongbook plWrongbook = new PLWrongbook();
        plWrongbook.setQuestionSelector("10", childId);
        return modWrongBook.questionSelector(plWrongbook);
    }

    /**
     * 查看错题列表
     *
     * @return
     */
    public JSONObject getQuestions() {
        PLWrongbook plWrongbook = new PLWrongbook();
        plWrongbook.setQuestions("10", childId);
        return modWrongBook.questions(plWrongbook);
    }

    /**
     * 获取页面列表
     *
     * @return
     */
    public JSONObject getPages() {
        PLWrongbook plWrongbook = new PLWrongbook();
        plWrongbook.setPages("10", childId, "1", "10");
        return modWrongBook.pages(plWrongbook);
    }

    /**
     * 作业报告
     *
     * @return
     */
    public JSONObject getReportQuerychildreprotgz() {
        PLWrongbook plWrongbook = new PLWrongbook();
        plWrongbook.setReportQuerychildreprotgz(childId);
        return modWrongBook.reportQuerychildreprotgz(plWrongbook);
    }

    /**
     * 提交报告
     *
     * @return
     */
    public JSONObject getCommitReport() {
        PLWrongbook plWrongbook = new PLWrongbook();
        plWrongbook.setCommitReport(childId);
        return modWrongBook.commitReport(plWrongbook);
    }

    /**
     * 查看错题详情
     *
     * @param wrongId 错题id
     * @return
     */
    public JSONObject getQuestionDetail(String wrongId) {
        PLWrongbook plWrongbook = new PLWrongbook();
        plWrongbook.setQuestionDetail(wrongId);
        return modWrongBook.questionDetail(plWrongbook);
    }

    // 获取当前子女的错题列表
    public JSONObject getCurrentChildQuestions() {
        PLWrongbook plWrongbook = new PLWrongbook();
        plWrongbook.setQuestions("10", executor.currentChild());

        JSONObject object = modWrongBook.questions(plWrongbook);
        SampleAssert.assertEquals("查询成功", object);
        Assert.assertTrue(object.getJSONObject("data").getJSONArray("list") != null);

        return object;
    }



}
