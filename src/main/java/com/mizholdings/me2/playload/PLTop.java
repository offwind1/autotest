package com.mizholdings.me2.playload;

import com.mizholdings.util.PLJavaBean;
import lombok.Data;

@Data
public class PLTop extends PLJavaBean {
    private String type;
    private String longitude;
    private String latitude;
    private String srcType;
    private String orgId;

    /**
     * 主页轮播广告
     *
     * @param type      int 广告类型 1横幅广告 2 弹窗广告
     * @param longitude string,经度（选填）
     * @param latitude  string,纬度（选填）
     * @param srcType   it 链接类型 0链接 1推荐 2机构用户3名师4课程5课件资源6课堂
     * @param orgId     int,机构ID
     */
    public void setAdvertlist(String type, String longitude, String latitude, String srcType, String orgId) {
        this.type = type;
        this.longitude = longitude;
        this.latitude = latitude;
        this.srcType = srcType;
        this.orgId = orgId;

    }

    private String gradeId;
    private String madeType;

    /**
     * 查询主页列表项
     *
     * @param gradeId  int,年级ID
     * @param orgId    int,机构ID
     * @param madeType int,订制类型，1非定制，2机构定制
     */
    public void setToplist(String gradeId, String orgId, String madeType) {
        this.gradeId = gradeId;
        this.orgId = orgId;
        this.madeType = madeType;

    }

    private String topId;
    private String hotTop;
    private String page;

    /**
     * 主页，加载更多
     *
     * @param gradeId int,年级ID
     * @param topId   int,用户点击主页哪一项的更多的ID
     * @param hotTop  int,推荐标识，主页分类对象中有此字段
     * @param page    int,页码
     * @param orgId   int,机构ID
     */
    public void setTopmore(String gradeId, String topId, String hotTop, String page, String orgId) {
        this.gradeId = gradeId;
        this.topId = topId;
        this.hotTop = hotTop;
        this.page = page;
        this.orgId = orgId;

    }


    /**
     * 选课中心主页
     *
     * @param gradeId  int,年级ID
     * @param orgId    int,机构ID
     * @param madeType int,订制类型，1非定制，2机构定制
     */
    public void setChooselist(String gradeId, String orgId, String madeType) {
        this.gradeId = gradeId;
        this.orgId = orgId;
        this.madeType = madeType;

    }


    /**
     * 资源库主页
     *
     * @param gradeId  int,年级ID
     * @param orgId    int,机构ID
     * @param madeType int,订制类型，1非定制，2机构定制
     */
    public void setCourslist(String gradeId, String orgId, String madeType) {
        this.gradeId = gradeId;
        this.orgId = orgId;
        this.madeType = madeType;

    }


    /**
     * 选课中心，加载更多
     *
     * @param gradeId int,年级ID
     * @param topId   int,用户点击主页哪一项的更多的ID
     * @param hotTop  int,推荐标识，主页分类对象中有此字段
     * @param page    int,页码
     * @param orgId   int,机构ID
     */
    public void setChoosemore(String gradeId, String topId, String hotTop, String page, String orgId) {
        this.gradeId = gradeId;
        this.topId = topId;
        this.hotTop = hotTop;
        this.page = page;
        this.orgId = orgId;

    }


    /**
     * 资源库，加载更多
     *
     * @param gradeId int,年级ID
     * @param topId   int,用户点击主页哪一项的更多的ID
     * @param hotTop  int,推荐标识，主页分类对象中有此字段
     * @param page    int,页码
     * @param orgId   int,机构ID
     */
    public void setCoursmore(String gradeId, String topId, String hotTop, String page, String orgId) {
        this.gradeId = gradeId;
        this.topId = topId;
        this.hotTop = hotTop;
        this.page = page;
        this.orgId = orgId;

    }


    /**
     * 查询直播课
     *
     * @param page  int,分页
     * @param orgId int,机构ID
     */
    public void setPlaylesson(String page, String orgId) {
        this.page = page;
        this.orgId = orgId;

    }


    /**
     * 最近将要直播的10堂课
     *
     * @param gradeId int, 年级ID
     * @param orgId   int，机构ID
     */
    public void setMintimelesson(String gradeId, String orgId) {
        this.gradeId = gradeId;
        this.orgId = orgId;

    }


    /**
     * 搜索推荐
     *
     * @param gradeId int 年级id
     */
    public void setGetsearchcem(String gradeId) {
        this.gradeId = gradeId;

    }


}