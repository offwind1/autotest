package com.mizholdings.me2.core.mod;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.core.user.Me2UserBase;
import com.mizholdings.me2.interfaces.api.ClassChartInterface;
import com.mizholdings.util.MODBase;
import com.mizholdings.util.PLJavaBean;
import com.mizholdings.util.Requests;

public class MODClasschart extends MODBase<MODClasschart> {
    public static ClassChartInterface classChartInterface = Requests.getService(ClassChartInterface.class);

    public MODClasschart(Me2UserBase executor) {
        super(executor);
        interfaced = classChartInterface;
    }


    /**
     * 课堂互动列表
     *
     * @param javaBean interact
     * @return
     */
    public JSONObject interact(PLJavaBean javaBean) {
        return exec("interact", javaBean);
    }

    /**
     * 到课统计
     *
     * @param javaBean arrive
     * @return
     */
    public JSONObject arrive(PLJavaBean javaBean) {
        return exec("arrive", javaBean);
    }

    /**
     * 作业统计
     *
     * @param javaBean homework
     * @return
     */
    public JSONObject homework(PLJavaBean javaBean) {
        return exec("homework", javaBean);
    }

    /**
     * 答题进度
     *
     * @param javaBean answer
     * @return
     */
    public JSONObject answer(PLJavaBean javaBean) {
        return exec("answer", javaBean);
    }

    /**
     * 课堂统计导出XLS
     *
     * @param javaBean export
     * @return
     */
    public JSONObject export(PLJavaBean javaBean) {
        return exec("export", javaBean);
    }

    /**
     * 导出XLS考勤概述
     *
     * @param javaBean summary
     * @return
     */
    public JSONObject summary(PLJavaBean javaBean) {
        return exec("summary", javaBean);
    }

    /**
     * 根据班级导出XLS
     *
     * @param javaBean exportByStuId
     * @return
     */
    public JSONObject exportByStuId(PLJavaBean javaBean) {
        return exec("exportByStuId", javaBean);
    }

    /**
     * 根据时间班级查询考勤信息
     *
     * @param javaBean getAttendanceByStuId
     * @return
     */
    public JSONObject getAttendanceByStuId(PLJavaBean javaBean) {
        return exec("getAttendanceByStuId", javaBean);
    }

    /**
     * 根据时间班级查询考勤详细信息(学生考勤)
     *
     * @param javaBean getAttendanceInfoByStuId
     * @return
     */
    public JSONObject getAttendanceInfoByStuId(PLJavaBean javaBean) {
        return exec("getAttendanceInfoByStuId", javaBean);
    }

    /**
     * 学科考勤（总表）
     *
     * @param javaBean getLessonTypeDili
     * @return
     */
    public JSONObject getLessonTypeDili(PLJavaBean javaBean) {
        return exec("getLessonTypeDili", javaBean);
    }

    /**
     * 学科考勤（班级表）
     *
     * @param javaBean getLessonTypeDiliClass
     * @return
     */
    public JSONObject getLessonTypeDiliClass(PLJavaBean javaBean) {
        return exec("getLessonTypeDiliClass", javaBean);
    }

    /**
     * 学科考勤XLS文件导出
     *
     * @param javaBean exportByLesType
     * @return
     */
    public JSONObject exportByLesType(PLJavaBean javaBean) {
        return exec("exportByLesType", javaBean);
    }

    /**
     * 回放记录-班级（总表）
     *
     * @param javaBean getVideoList
     * @return
     */
    public JSONObject getVideoList(PLJavaBean javaBean) {
        return exec("getVideoList", javaBean);
    }

    /**
     * 回放记录-班级（详情表）
     *
     * @param javaBean getVideoListClass
     * @return
     */
    public JSONObject getVideoListClass(PLJavaBean javaBean) {
        return exec("getVideoListClass", javaBean);
    }

    /**
     * 视频回看统计导出
     *
     * @param javaBean exportByVideo
     * @return
     */
    public JSONObject exportByVideo(PLJavaBean javaBean) {
        return exec("exportByVideo", javaBean);
    }

    /**
     * 回放记录-学科（列表）
     *
     * @param javaBean getVideoLesType
     * @return
     */
    public JSONObject getVideoLesType(PLJavaBean javaBean) {
        return exec("getVideoLesType", javaBean);
    }

    /**
     * 回放记录-学科（详情表）
     *
     * @param javaBean getVideoLesTypeClass
     * @return
     */
    public JSONObject getVideoLesTypeClass(PLJavaBean javaBean) {
        return exec("getVideoLesTypeClass", javaBean);
    }

    /**
     * 回放记录-学科-导出
     *
     * @param javaBean exportByVideoType
     * @return
     */
    public JSONObject exportByVideoType(PLJavaBean javaBean) {
        return exec("exportByVideoType", javaBean);
    }


}