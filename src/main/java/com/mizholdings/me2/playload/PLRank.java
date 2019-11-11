package com.mizholdings.me2.playload;

import com.mizholdings.util.PLJavaBean;
import lombok.Data;

@Data
public class PLRank extends PLJavaBean {

    private String orderType;

    /**
     * 名师排行
     *
     * @param orderType int,排序方式：1综合，2学生，3课程
     */
    public void setTeacherlist(String orderType) {
        this.orderType = orderType;

    }


    /**
     * 课程，排行
     *
     * @param orderType int,排序方式：1综合，2人气
     */
    public void setLessonlist(String orderType) {
        this.orderType = orderType;

    }


    /**
     * 机构，排行
     *
     * @param orderType int,排序方式：1综合，2教师，3课程
     */
    public void setOrglist(String orderType) {
        this.orderType = orderType;

    }

    private String userId;
    private String year;
    private String month;

    /**
     * 查询明星老师的预约课
     *
     * @param userId long,用户ID
     * @param year   int,年份
     * @param month  int,月份
     */
    public void setBespeak(String userId, String year, String month) {
        this.userId = userId;
        this.year = year;
        this.month = month;

    }


}