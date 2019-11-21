package com.mizholdings.me2.mod;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.user.Me2UserBase;
import com.mizholdings.me2.interfaces.api.RankInterface;
import com.mizholdings.util.MODBase;
import com.mizholdings.util.PLJavaBean;
import com.mizholdings.util.Requests;

public class MODRank extends MODBase<MODRank> {
    public static RankInterface rankInterface = Requests.getService(RankInterface.class);

    public MODRank(Me2UserBase executor) {
        super(executor);
        interfaced = rankInterface;
    }


   
/**
 * 名师，前三名
 *
 * @param javaBean teacherTop
 * @return
 */
public JSONObject teacherTop(PLJavaBean javaBean) {
    return exec("teacherTop", javaBean);
}

/**
 * 名师排行
 *
 * @param javaBean teacherList
 * @return
 */
public JSONObject teacherList(PLJavaBean javaBean) {
    return exec("teacherList", javaBean);
}

/**
 * 课程，排行
 *
 * @param javaBean lessonList
 * @return
 */
public JSONObject lessonList(PLJavaBean javaBean) {
    return exec("lessonList", javaBean);
}

/**
 * 机构，排行
 *
 * @param javaBean orgList
 * @return
 */
public JSONObject orgList(PLJavaBean javaBean) {
    return exec("orgList", javaBean);
}

/**
 * 查询明星老师的预约课
 *
 * @param javaBean bespeak
 * @return
 */
public JSONObject bespeak(PLJavaBean javaBean) {
    return exec("bespeak", javaBean);
}

/**
 * 学习之星
 *
 * @param javaBean studyStar
 * @return
 */
public JSONObject studyStar(PLJavaBean javaBean) {
    return exec("studyStar", javaBean);
}


}