package com.mizholdings.me2.playload;

import com.mizholdings.util.PLJavaBean;
import lombok.Data;

@Data
public class PLCourse extends PLJavaBean {
    private String coursewareName;
    private String page;
    private String orgId;

    /**
     * 资源列表
     *
     * @param coursewareName string,资源名称
     * @param page           int,页码
     * @param orgId          int,机构ID
     */
    public void setList(String coursewareName, String page, String orgId) {
        this.coursewareName = coursewareName;
        this.page = page;
        this.orgId = orgId;

    }

    private String coursewareId;

    /**
     * 资源详情
     *
     * @param coursewareId string,资源ID
     */
    public void setCoursewareinfo(String coursewareId) {
        this.coursewareId = coursewareId;

    }


    /**
     * 获得资源评论列表
     *
     * @param page         int,页码
     * @param coursewareId string.资源ID
     */
    public void setCoursescore(String page, String coursewareId) {
        this.page = page;
        this.coursewareId = coursewareId;

    }

    private String resourceId;
    private String userComment;
    private String coursewareScore;

    /**
     * 资源评论
     *
     * @param resourceId      string,回复评论ID
     * @param userComment     string,评论内容
     * @param coursewareScore int,资源评分
     * @param coursewareId    string,资源ID
     */
    public void setScore(String resourceId, String userComment, String coursewareScore, String coursewareId) {
        this.resourceId = resourceId;
        this.userComment = userComment;
        this.coursewareScore = coursewareScore;
        this.coursewareId = coursewareId;

    }


    /**
     * 点赞资源
     *
     * @param coursewareId string,资源ID
     */
    public void setLikedcourse(String coursewareId) {
        this.coursewareId = coursewareId;

    }


    /**
     * 取消点赞
     *
     * @param coursewareId string,资源ID
     */
    public void setRmlikedcourse(String coursewareId) {
        this.coursewareId = coursewareId;

    }


    /**
     * 收藏资源
     *
     * @param coursewareId string,资源ID
     */
    public void setKeepcourse(String coursewareId) {
        this.coursewareId = coursewareId;

    }


    /**
     * 取消收藏
     *
     * @param coursewareId string,资源ID
     */
    public void setRmkeepcourse(String coursewareId) {
        this.coursewareId = coursewareId;

    }


    /**
     * 相关推荐
     *
     * @param coursewareId String,资源ID
     */
    public void setRelatedlist(String coursewareId) {
        this.coursewareId = coursewareId;

    }

    private String lessonTypeId;
    private String courseTypes;

    /**
     * 我的资源
     *
     * @param coursewareName string,资源名称
     * @param page           int,页码
     * @param lessonTypeId   int,学科ID
     * @param courseTypes    String,资源类型ID集合，用逗号分隔
     */
    public void setMylist(String coursewareName, String page, String lessonTypeId, String courseTypes) {
        this.coursewareName = coursewareName;
        this.page = page;
        this.lessonTypeId = lessonTypeId;
        this.courseTypes = courseTypes;

    }


    /**
     * 课堂中，更换课件时，课件详情
     *
     * @param coursewareId string,课件ID
     */
    public void setInfobyclassroom(String coursewareId) {
        this.coursewareId = coursewareId;

    }


    /**
     * 单纯查询子资源列表
     *
     * @param coursewareId string,资源ID
     */
    public void setChildlist(String coursewareId) {
        this.coursewareId = coursewareId;

    }

    private String sourceUrl;

    /**
     * 上传ppt
     *
     * @param coursewareName 课件名称
     * @param sourceUrl      课件rul
     */
    public void setUploadppt(String coursewareName, String sourceUrl) {
        this.coursewareName = coursewareName;
        this.sourceUrl = sourceUrl;

    }


    /**
     * 我创建的资源列表
     *
     * @param page int,页码
     */
    public void setMycreate(String page) {
        this.page = page;

    }


    /**
     * 查询我购买的资源列表
     *
     * @param page int,页码
     */
    public void setMybuy(String page) {
        this.page = page;

    }


    /**
     * 上传图片文件
     *
     * @param sourceUrl 文件地址 用逗号分割
     */
    public void setUploadfile(String sourceUrl) {
        this.sourceUrl = sourceUrl;

    }

    private String pageNum;
    private String pageSize;

    /**
     * 我的资源PC
     *
     * @param pageNum  int,页码
     * @param pageSize int，显示数量
     */
    public void setMybuypc(String pageNum, String pageSize) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;

    }


}