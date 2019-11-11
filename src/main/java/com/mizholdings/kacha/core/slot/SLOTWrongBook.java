package com.mizholdings.kacha.core.slot;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mizholdings.kacha.core.GlobalKC;
import com.mizholdings.kacha.core.mod.MODWrongBook;
import com.mizholdings.kacha.core.user.KCParent;
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
     * 提交错题，通过 上传页面返回的JsonObject
     *
     * @param object jsonObject
     * @return
     */
    public JSONObject commitWrongQuestionByJsonObject(JSONObject object) {
        //提交错题
        String s = creat_wrongbook_data(object);
        return modWrongBook.commit(s);
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


    public String creat_wrongbook_data(JSONObject object) {
        String pageId = object.getJSONObject("data").getString("pageId");
        JSONArray array = object.getJSONObject("data").getJSONArray("questions");

        List<WrongQuestion> questions = new ArrayList<>();

        for (int i = 0; i < array.size(); i++) {
            JSONObject imagdata = array.getJSONObject(i)
                    .getJSONArray("areas")
                    .getJSONObject(0);

            WrongQuestion question = new WrongQuestion();
            question.setPage(pageId);
            question.setNum(String.valueOf(i));
            question.setX(imagdata.getString("x"));
            question.setY(imagdata.getString("y"));
            question.setY(imagdata.getString("y"));
            question.setWidth(imagdata.getString("width"));
            question.setHeight(imagdata.getString("height"));

            List<String> list = new ArrayList<>();
            list.add(imagdata.getString("imgUrl"));
            question.setQuestionUrls(list);
            question.setCollect("1");
            questions.add(question);
        }

        PageQuestion pageQuestion = new PageQuestion();
        pageQuestion.setPageId(pageId);
        pageQuestion.setQuestions(questions);

        List<PageQuestion> list = new ArrayList<>();
        list.add(pageQuestion);

        Commit commit = new Commit();
        commit.setPages(list);
        commit.setSubjectId("10");
        commit.setChildId(executor.currentChild());

        return JSONObject.toJSONString(commit);
    }

}


@Data
class Commit {
    private List<PageQuestion> pages;
    private String subjectId = "10";
    private String childId;
}

@Data
class PageQuestion {
    private String pageId;
    private List<WrongQuestion> questions;
}

@Data
class WrongQuestion {
    private String page;
    private String num;
    private String x;
    private String y;
    private String width;
    private String height;
    private List<String> questionUrls;
    private String collect;
}