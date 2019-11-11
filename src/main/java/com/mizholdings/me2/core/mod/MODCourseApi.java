package com.mizholdings.me2.core.mod;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.core.user.Me2UserBase;
import com.mizholdings.me2.interfaces.api.CourseApiInterface;
import com.mizholdings.util.MODBase;
import com.mizholdings.util.PLJavaBean;
import com.mizholdings.util.Requests;

public class MODCourseApi extends MODBase<MODCourseApi> {
    public static CourseApiInterface courseInterface = Requests.getService(CourseApiInterface.class);

    public MODCourseApi(Me2UserBase executor) {
        super(executor);
        interfaced = courseInterface;
    }


    /**
     * 资源列表
     *
     * @param javaBean list
     * @return
     */
    public JSONObject list(PLJavaBean javaBean) {
        return exec("list", javaBean);
    }

    /**
     * 资源详情
     *
     * @param javaBean coursewareInfo
     * @return
     */
    public JSONObject coursewareInfo(PLJavaBean javaBean) {
        return exec("coursewareInfo", javaBean);
    }

    /**
     * 资源筛选条件
     *
     * @param javaBean screen
     * @return
     */
    public JSONObject screen(PLJavaBean javaBean) {
        return exec("screen", javaBean);
    }

    /**
     * 获得资源评论列表
     *
     * @param javaBean courseScore
     * @return
     */
    public JSONObject courseScore(PLJavaBean javaBean) {
        return exec("courseScore", javaBean);
    }

    /**
     * 资源评论
     *
     * @param javaBean score
     * @return
     */
    public JSONObject score(PLJavaBean javaBean) {
        return exec("score", javaBean);
    }

    /**
     * 点赞资源
     *
     * @param javaBean likedCourse
     * @return
     */
    public JSONObject likedCourse(PLJavaBean javaBean) {
        return exec("likedCourse", javaBean);
    }

    /**
     * 取消点赞
     *
     * @param javaBean rmlikedCourse
     * @return
     */
    public JSONObject rmlikedCourse(PLJavaBean javaBean) {
        return exec("rmlikedCourse", javaBean);
    }

    /**
     * 收藏资源
     *
     * @param javaBean keepCourse
     * @return
     */
    public JSONObject keepCourse(PLJavaBean javaBean) {
        return exec("keepCourse", javaBean);
    }

    /**
     * 取消收藏
     *
     * @param javaBean rmkeepCourse
     * @return
     */
    public JSONObject rmkeepCourse(PLJavaBean javaBean) {
        return exec("rmkeepCourse", javaBean);
    }

    /**
     * 相关推荐
     *
     * @param javaBean relatedList
     * @return
     */
    public JSONObject relatedList(PLJavaBean javaBean) {
        return exec("relatedList", javaBean);
    }

    /**
     * 我的资源
     *
     * @param javaBean mylist
     * @return
     */
    public JSONObject mylist(PLJavaBean javaBean) {
        return exec("mylist", javaBean);
    }

    /**
     * 课堂中，更换课件时，课件详情
     *
     * @param javaBean infoByClassroom
     * @return
     */
    public JSONObject infoByClassroom(PLJavaBean javaBean) {
        return exec("infoByClassroom", javaBean);
    }

    /**
     * 单纯查询子资源列表
     *
     * @param javaBean childList
     * @return
     */
    public JSONObject childList(PLJavaBean javaBean) {
        return exec("childList", javaBean);
    }

    /**
     * 上传ppt
     *
     * @param javaBean uploadPpt
     * @return
     */
    public JSONObject uploadPpt(PLJavaBean javaBean) {
        return exec("uploadPpt", javaBean);
    }

    /**
     * 我创建的资源列表
     *
     * @param javaBean myCreate
     * @return
     */
    public JSONObject myCreate(PLJavaBean javaBean) {
        return exec("myCreate", javaBean);
    }

    /**
     * 查询我购买的资源列表
     *
     * @param javaBean myBuy
     * @return
     */
    public JSONObject myBuy(PLJavaBean javaBean) {
        return exec("myBuy", javaBean);
    }

    /**
     * 上传图片文件
     *
     * @param javaBean uploadFile
     * @return
     */
    public JSONObject uploadFile(PLJavaBean javaBean) {
        return exec("uploadFile", javaBean);
    }

    /**
     * 我的资源PC
     *
     * @param javaBean myBuyPC
     * @return
     */
    public JSONObject myBuyPC(PLJavaBean javaBean) {
        return exec("myBuyPC", javaBean);
    }


}