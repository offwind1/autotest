package com.mizholdings.me2.playload;

import com.mizholdings.util.PLJavaBean;
import lombok.Data;

@Data
public class PLFullsch extends PLJavaBean {

    private String keyword;
    private String page;
    private String type;
    private String orgId;

    /**
     * 全文检索
     *
     * @param keyword string,搜索的关键字
     * @param page    int,页码
     * @param type    int,不传入或0表示查询全部，1课程，2课件，3机构新闻，4广告
     * @param orgId   int,机构ID，非机构定制的传入0或者不传
     */
    public void setSearchall(String keyword, String page, String type, String orgId) {
        this.keyword = keyword;
        this.page = page;
        this.type = type;
        this.orgId = orgId;

    }

    private String gradeId;
    private String grade;

    /**
     * 首页搜索2
     *
     * @param keyword String 搜索关键字
     * @param page    int 页数
     * @param orgId   机构id
     * @param type    类型 1课程2课件3老师4机构
     * @param gradeId 年级id
     * @param grade   String 年级名称
     */
    public void setSearchall2(String keyword, String page, String orgId, String type, String gradeId, String grade) {
        this.keyword = keyword;
        this.page = page;
        this.orgId = orgId;
        this.type = type;
        this.gradeId = gradeId;
        this.grade = grade;

    }


}