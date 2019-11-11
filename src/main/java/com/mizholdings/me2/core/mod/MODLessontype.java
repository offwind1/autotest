package com.mizholdings.me2.core.mod;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.core.user.Me2UserBase;
import com.mizholdings.me2.interfaces.LessonTypeInterface;
import com.mizholdings.util.MODBase;
import com.mizholdings.util.PLJavaBean;
import com.mizholdings.util.Requests;

public class MODLessontype extends MODBase<MODLessontype> {
    public static LessonTypeInterface lessonTypeInterface = Requests.getService(LessonTypeInterface.class);

    public MODLessontype(Me2UserBase executor) {
        super(executor);
        interfaced = lessonTypeInterface;
    }


   
/**
 * 查询学科列表
 *
 * @param javaBean list
 * @return
 */
public JSONObject list(PLJavaBean javaBean) {
    return exec("list", javaBean);
}

/**
 * 查询用户选择的学科列表
 *
 * @param javaBean userlist
 * @return
 */
public JSONObject userlist(PLJavaBean javaBean) {
    return exec("userlist", javaBean);
}

/**
 * 学科编辑保存
 *
 * @param javaBean savelist
 * @return
 */
public JSONObject savelist(PLJavaBean javaBean) {
    return exec("savelist", javaBean);
}


}