package com.mizholdings.me2.playload;

import com.mizholdings.util.PLJavaBean;
import lombok.Data;

@Data
public class PLGrade extends PLJavaBean {
    private String orgName;
    private String gradeId;
    private String className;
    private String rankNum;
    private String gradeName;
    private String orgId;
    private String stuId;


    /**
     * 添加班级
     *
     * @param orgName
     * @param orgId
     * @param className
     */
    public void setAddClass(String orgName, String orgId, String className) {
        this.orgName = orgName;
        this.gradeId = "1";
        this.className = className;
        this.rankNum = "2019";
        this.gradeName = "一年级";
        this.orgId = orgId;
    }

    public void setDelClass(String stuId) {
        this.stuId = stuId;
    }


    public void setClassList(String orgName) {
        this.orgName = orgName;
    }


    /**
     * 年级列表（绑定学科）
     *
     * @param orgId int,机构ID
     */
    public void setGradelist(String orgId) {
        this.orgId = orgId;

    }


    /**
     * 根据机构ID查询年级和学科列表
     *
     * @param orgId int,机构ID
     */
    public void setListbyorgid(String orgId) {
        this.orgId = orgId;

    }


}
