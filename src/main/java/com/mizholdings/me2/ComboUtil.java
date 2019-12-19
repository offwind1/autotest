package com.mizholdings.me2;

import com.mizholdings.me2.agent.web.LessonAgent;
import com.mizholdings.me2.user.Me2SuperAdmin;
import com.mizholdings.me2.user.Me2Teacher;
import com.mizholdings.me2.user.Me2UserBase;

public class ComboUtil {

    public static String applyLesson(Me2SuperAdmin superAdmin, Me2Teacher teacher) {
        String lessonId = teacher.newLessonAndGetLessonId(LessonAgent.FreeType.NO_FREE);
        applyLesson(superAdmin, teacher, lessonId);
        return lessonId;
    }

    public static void applyLesson(Me2SuperAdmin superAdmin, Me2Teacher teacher, String lessonId) {
        teacher.getWeb().lessonAgent().apply(lessonId);
        superAdmin.getManage().lessonAgent().passLesson(lessonId);
    }

    public static void studentBuyLesson(Me2UserBase student, String lesson){
        student.getApp().payAgent().getPingxx(lesson);
    }


}
