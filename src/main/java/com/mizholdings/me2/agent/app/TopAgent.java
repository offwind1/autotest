package com.mizholdings.me2.agent.app;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.agent.web.AdvertAgent;
import com.mizholdings.me2.user.Me2UserBase;
import com.mizholdings.me2.interfaces.api.TopInterface;
import com.mizholdings.me2.user.serve.ServeBase;
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
     * @param src_type it 链接类型 0链接 1推荐 2机构用户3名师4课程5课件资源6课堂
     * @return
     */
    public JSONObject advertList(AdvertAgent.SRC_TYPE src_type) {
        return exec("advertList", Parameter.creat().add("type", src_type.value)
        );
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

    public JSONObject v2topList(ServeBase.GRADEID gradeid, MADE_TYPE made_type) {
        return exec("v2topList", Parameter.creat()
                .add("gradeId", gradeid.value)
                .add("madeType", made_type.value));
    }

    public JSONObject v2topList(ServeBase.GRADEID gradeid) {
        return v2topList(gradeid, MADE_TYPE.NO_IN_JIGOU);
    }


    public enum MADE_TYPE {
        NO_IN_JIGOU("1", "非定制"),
        IN_JIGOU("2", "机构定制"),
        ;
        public String value;
        public String name;

        private MADE_TYPE(String value, String name) {
            this.value = value;
            this.name = name;
        }
    }


}