package com.mizholdings.me2.agent.app;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.user.Me2UserBase;
import com.mizholdings.me2.interfaces.api.TopInterface;
import com.mizholdings.util.*;

public class TopAgent extends MODBase<TopAgent> {
    public static TopInterface topInterface = Requests.getService(TopInterface.class);

    public TopAgent(User executor) {
        super(executor);
        interfaced = topInterface;
    }


    /**
     * 主页轮播广告
     *
     * @param javaBean advertList
     * @return
     */
    public JSONObject advertList(PLJavaBean javaBean) {
        return exec("advertList", javaBean);
    }

    /**
     * 学科列表
     *
     * @param javaBean usrMenu
     * @return
     */
    public JSONObject usrMenu(PLJavaBean javaBean) {
        return exec("usrMenu", javaBean);
    }

    /**
     * 查询主页列表项
     *
     * @param javaBean topList
     * @return
     */
    public JSONObject topList(PLJavaBean javaBean) {
        return exec("topList", javaBean);
    }

    /**
     * 主页，加载更多
     *
     * @param javaBean topMore
     * @return
     */
    public JSONObject topMore(PLJavaBean javaBean) {
        return exec("topMore", javaBean);
    }

    /**
     * 选课中心主页
     *
     * @param javaBean chooseList
     * @return
     */
    public JSONObject chooseList(PLJavaBean javaBean) {
        return exec("chooseList", javaBean);
    }

    /**
     * 导引页接口
     *
     * @param javaBean bootpage
     * @return
     */
    public JSONObject bootpage(PLJavaBean javaBean) {
        return exec("bootpage", javaBean);
    }

    /**
     * 资源库主页
     *
     * @param javaBean coursList
     * @return
     */
    public JSONObject coursList(PLJavaBean javaBean) {
        return exec("coursList", javaBean);
    }

    /**
     * 选课中心，加载更多
     *
     * @param javaBean chooseMore
     * @return
     */
    public JSONObject chooseMore(PLJavaBean javaBean) {
        return exec("chooseMore", javaBean);
    }

    /**
     * 资源库，加载更多
     *
     * @param javaBean coursMore
     * @return
     */
    public JSONObject coursMore(PLJavaBean javaBean) {
        return exec("coursMore", javaBean);
    }

    /**
     * 查询直播课
     *
     * @param javaBean playLesson
     * @return
     */
    public JSONObject playLesson(PLJavaBean javaBean) {
        return exec("playLesson", javaBean);
    }

    /**
     * 最近将要直播的10堂课
     *
     * @param javaBean minTimeLesson
     * @return
     */
    public JSONObject minTimeLesson(PLJavaBean javaBean) {
        return exec("minTimeLesson", javaBean);
    }

    /**
     * 搜索推荐
     *
     * @param javaBean getSearchCem
     * @return
     */
    public JSONObject getSearchCem(PLJavaBean javaBean) {
        return exec("getSearchCem", javaBean);
    }

    /**
     * 机构新闻更多
     *
     * @return
     */
    public JSONObject v2OrgMsgList() {
        return exec("v2OrgMsgList", Parameter.creat()
                .add("page", "1"));
    }
}