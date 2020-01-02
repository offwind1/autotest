package com.mizholdings.me2.creater;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.ComboUtil;
import com.mizholdings.me2.Global;
import com.mizholdings.me2.user.SuperAdmin;
import com.mizholdings.me2.user.Teacher;
import com.mizholdings.util.Common;

public class LessonCreater {

    private static SuperAdmin superAdmin = Global.init().getSuperAdmin();

    public static String CreatLesson(Teacher teacher, int classRoomCount) {
        //新建课程
        String lessonId = teacher.newLessonAndGetLessonId(classRoomCount);
        //提交审核
        ComboUtil.applyLesson(superAdmin, teacher, lessonId);
        return lessonId;
    }

    public static String CreatLesson(Teacher teacher) {
        return CreatLesson(teacher, 4);
    }
}
