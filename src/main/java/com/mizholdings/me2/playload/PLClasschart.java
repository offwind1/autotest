package com.mizholdings.me2.playload;

import com.mizholdings.util.PLJavaBean;
import lombok.Data;

@Data
public class PLClasschart extends PLJavaBean {

    private String classroomId;

    /**
     * 课堂互动列表
     *
     * @param classroomId string,课堂ID
     */
    public void setInteract(String classroomId) {
        this.classroomId = classroomId;

    }


    /**
     * 到课统计
     *
     * @param classroomId string,课堂ID
     */
    public void setArrive(String classroomId) {
        this.classroomId = classroomId;

    }


    /**
     * 作业统计
     *
     * @param classroomId string,课堂ID
     */
    public void setHomework(String classroomId) {
        this.classroomId = classroomId;

    }


    /**
     * 答题进度
     *
     * @param classroomId string,课堂ID
     */
    public void setAnswer(String classroomId) {
        this.classroomId = classroomId;

    }

    private String stuId;

    /**
     * 课堂统计导出XLS
     *
     * @param classroomId string,课堂ID
     * @param stuId       int,班级ID
     */
    public void setExport(String classroomId, String stuId) {
        this.classroomId = classroomId;
        this.stuId = stuId;

    }


    /**
     * 导出XLS考勤概述
     *
     * @param classroomId string,课堂ID
     */
    public void setSummary(String classroomId) {
        this.classroomId = classroomId;

    }

    private String orgId;
    private String startTime;
    private String endTime;

    /**
     * 根据班级导出XLS
     *
     * @param stuId     班级id
     * @param orgId     机构id
     * @param startTime 开始时间
     * @param endTime   结束时间
     */
    public void setExportbystuid(String stuId, String orgId, String startTime, String endTime) {
        this.stuId = stuId;
        this.orgId = orgId;
        this.startTime = startTime;
        this.endTime = endTime;

    }


    /**
     * 根据时间班级查询考勤信息
     *
     * @param orgId     int 机构id
     * @param stuId     int 班级ID
     * @param startTime String 需要查询的开始时间 格式yyyy-MM-dd
     * @param endTime   String 需要查询的结束时间 格式yyyy-MM-dd
     */
    public void setGetattendancebystuid(String orgId, String stuId, String startTime, String endTime) {
        this.orgId = orgId;
        this.stuId = stuId;
        this.startTime = startTime;
        this.endTime = endTime;

    }

    private String lessonId;

    /**
     * 根据时间班级查询考勤详细信息(学生考勤)
     *
     * @param lessonId  String 课程id
     * @param startTime String 需要查询的开始时间 格式yyyy-MM-dd
     * @param endTime   String 需要查询的结束时间 格式yyyy-MM-dd
     */
    public void setGetattendanceinfobystuid(String lessonId, String startTime, String endTime) {
        this.lessonId = lessonId;
        this.startTime = startTime;
        this.endTime = endTime;

    }

    private String lessonTypeId;

    /**
     * 学科考勤（总表）
     *
     * @param lessonTypeId int,学科ID
     * @param lessonId     string,课程ID
     * @param startTime    string,开始时间
     * @param endTime      string,结束时间
     */
    public void setGetlessontypedili(String lessonTypeId, String lessonId, String startTime, String endTime) {
        this.lessonTypeId = lessonTypeId;
        this.lessonId = lessonId;
        this.startTime = startTime;
        this.endTime = endTime;

    }


    /**
     * 学科考勤（班级表）
     *
     * @param lessonId string,课程ID
     * @param stuId    string,班级ID
     */
    public void setGetlessontypediliclass(String lessonId, String stuId) {
        this.lessonId = lessonId;
        this.stuId = stuId;

    }


    /**
     * 学科考勤XLS文件导出
     *
     * @param lessonTypeId int,学科ID
     * @param lessonId     string,课程ID
     * @param startTime    string,开始时间
     * @param endTime      string,结束时间
     */
    public void setExportbylestype(String lessonTypeId, String lessonId, String startTime, String endTime) {
        this.lessonTypeId = lessonTypeId;
        this.lessonId = lessonId;
        this.startTime = startTime;
        this.endTime = endTime;

    }


    /**
     * 回放记录-班级（总表）
     *
     * @param stuId     int,班级ID，没有班级传入0
     * @param startTime string,开始日期
     * @param endTime   string,结束日期
     */
    public void setGetvideolist(String stuId, String startTime, String endTime) {
        this.stuId = stuId;
        this.startTime = startTime;
        this.endTime = endTime;

    }


    /**
     * 回放记录-班级（详情表）
     *
     * @param stuId    int,班级ID，没有班级传入0
     * @param lessonId string,课程ID
     */
    public void setGetvideolistclass(String stuId, String lessonId) {
        this.stuId = stuId;
        this.lessonId = lessonId;

    }


    private String stuName;

    /**
     * 视频回看统计导出
     *
     * @param stuId     int,班级ID，没有班级传入0
     * @param stuName   string,班级名
     * @param startTime string,开始时间
     * @param endTime   string,结束时间
     */
    public void setExportbyvideo(String stuId, String stuName, String startTime, String endTime) {
        this.stuId = stuId;
        this.stuName = stuName;
        this.startTime = startTime;
        this.endTime = endTime;

    }


    /**
     * 回放记录-学科（列表）
     *
     * @param lessonTypeId int,学科ID
     * @param lessonId     string,课程ID
     * @param startTime    string,开始日期
     * @param endTime      string,结束日期
     */
    public void setGetvideolestype(String lessonTypeId, String lessonId, String startTime, String endTime) {
        this.lessonTypeId = lessonTypeId;
        this.lessonId = lessonId;
        this.startTime = startTime;
        this.endTime = endTime;

    }


    /**
     * 回放记录-学科（详情表）
     *
     * @param lessonTypeId int,学科ID
     * @param lessonId     string,课程ID
     * @param startTime    string,开始日期
     * @param endTime      string,结束日期
     */
    public void setGetvideolestypeclass(String lessonTypeId, String lessonId, String startTime, String endTime) {
        this.lessonTypeId = lessonTypeId;
        this.lessonId = lessonId;
        this.startTime = startTime;
        this.endTime = endTime;

    }


    /**
     * 回放记录-学科-导出
     *
     * @param lessonTypeId int,学科ID
     * @param lessonId     string,课程ID
     * @param startTime    string,开始日期
     * @param endTime      string,结束日期
     */
    public void setExportbyvideotype(String lessonTypeId, String lessonId, String startTime, String endTime) {
        this.lessonTypeId = lessonTypeId;
        this.lessonId = lessonId;
        this.startTime = startTime;
        this.endTime = endTime;

    }


}