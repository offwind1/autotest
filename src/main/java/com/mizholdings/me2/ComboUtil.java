package com.mizholdings.me2;

import com.mizholdings.me2.agent.web.LessonAgent;
import com.mizholdings.me2.user.SuperAdmin;
import com.mizholdings.me2.user.Teacher;
import com.mizholdings.me2.user.UserBase;

public class ComboUtil {

    public static String applyLesson(SuperAdmin superAdmin, Teacher teacher) {
        String lessonId = teacher.newLessonAndGetLessonId(LessonAgent.FreeType.NO_FREE);
        applyLesson(superAdmin, teacher, lessonId);
        return lessonId;
    }

    public static void applyLesson(SuperAdmin superAdmin, Teacher teacher, String lessonId) {
        teacher.getWeb().lessonAgent().apply(lessonId);
        superAdmin.getManage().lessonAgent().passLesson(lessonId);
    }

    public static void studentBuyLesson(UserBase student, String lesson){
        student.getApp().payAgent().getPingxx(lesson);
    }


}
