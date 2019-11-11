package com.mizholdings.me2.core.mod;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.core.user.Me2UserBase;
import com.mizholdings.me2.interfaces.api.LessonInfoInterface;
import com.mizholdings.me2.interfaces.web.LessonInterface;
import com.mizholdings.util.MODBase;
import com.mizholdings.util.PLJavaBean;
import com.mizholdings.util.Requests;

public class MODLesson extends MODBase<MODLesson> {

    public static LessonInterface lessonInterface = Requests.getService(LessonInterface.class);

    public MODLesson(Me2UserBase executor) {
        super(executor);
        interfaced = lessonInterface;
    }

    /**
     * userListByAccount
     *
     * @param javaBean
     * @return
     */
    public JSONObject userListByAccount(PLJavaBean javaBean) {
        return exec("userListByAccount", javaBean);
    }

    public JSONObject joinClassByUserId(PLJavaBean javaBean) {
        return exec("joinClassByUserId", javaBean);
    }


}
