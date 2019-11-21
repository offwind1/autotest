package com.mizholdings.me2.mod;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.user.Me2UserBase;
import com.mizholdings.me2.interfaces.CreditInterface;
import com.mizholdings.util.MODBase;
import com.mizholdings.util.PLJavaBean;
import com.mizholdings.util.Requests;

public class MODCredit extends MODBase<MODCredit> {
    public static CreditInterface creditInterface = Requests.getService(CreditInterface.class);

    public MODCredit(Me2UserBase executor) {
        super(executor);
        interfaced = creditInterface;
    }


   
/**
 * 学生学习资源，获取学分
 *
 * @param javaBean addByCourse
 * @return
 */
public JSONObject addByCourse(PLJavaBean javaBean) {
    return exec("addByCourse", javaBean);
}

/**
 * 学生学习课堂，老师指定学分
 *
 * @param javaBean addByClassroom
 * @return
 */
public JSONObject addByClassroom(PLJavaBean javaBean) {
    return exec("addByClassroom", javaBean);
}

/**
 * 用户查询自己的学分
 *
 * @param javaBean getCreditList
 * @return
 */
public JSONObject getCreditList(PLJavaBean javaBean) {
    return exec("getCreditList", javaBean);
}


}