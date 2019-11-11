package com.mizholdings.me2.playload;

import com.mizholdings.util.PLJavaBean;
import lombok.Data;

@Data
public class PLCredit extends PLJavaBean {

    private String coursewareId;

    /**
     * 学生学习资源，获取学分
     *
     * @param coursewareId string,资料ID
     */
    public void setAddbycourse(String coursewareId) {
        this.coursewareId = coursewareId;

    }

    private String classroomId;
    private String useIds;
    private String creditNum;

    /**
     * 学生学习课堂，老师指定学分
     *
     * @param classroomId string,课堂ID
     * @param useIds      string,学生ID集合，逗号分隔
     * @param creditNum   double,获得的学分
     */
    public void setAddbyclassroom(String classroomId, String useIds, String creditNum) {
        this.classroomId = classroomId;
        this.useIds = useIds;
        this.creditNum = creditNum;

    }

    private String page;

    /**
     * 用户查询自己的学分
     *
     * @param page int,分页字段，页码，从1开始
     */
    public void setGetcreditlist(String page) {
        this.page = page;

    }


}