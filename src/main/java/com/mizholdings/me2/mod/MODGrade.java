package com.mizholdings.me2.mod;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.user.Me2UserBase;
import com.mizholdings.me2.interfaces.GradeInterface;
import com.mizholdings.util.MODBase;
import com.mizholdings.util.PLJavaBean;
import com.mizholdings.util.Requests;

public class MODGrade extends MODBase<MODGrade> {
    public static GradeInterface gradeInterface = Requests.getService(GradeInterface.class);

    public MODGrade(Me2UserBase executor) {
        super(executor);
        interfaced = gradeInterface;
    }


    /**
     * 添加教师
     *
     * @param javaBean
     * @return
     */
    public JSONObject addClass(PLJavaBean javaBean) {
        return exec("addClass", javaBean);
    }

    /**
     * 删除班级
     *
     * @param javaBean
     * @return
     */
    public JSONObject delClass(PLJavaBean javaBean) {
        return exec("delClass", javaBean);
    }

    /**
     * 获取班级列表
     *
     * @return
     */
    public JSONObject classList(PLJavaBean javaBean) {
        return exec("classList", javaBean);
    }


    /**
     * 查询年级列表
     *
     * @param javaBean list
     * @return
     */
    public JSONObject list(PLJavaBean javaBean) {
        return exec("list", javaBean);
    }

    /**
     * 查询年级列表(标签类型)
     *
     * @param javaBean taglist
     * @return
     */
    public JSONObject taglist(PLJavaBean javaBean) {
        return exec("taglist", javaBean);
    }

    /**
     * 年级列表（绑定学科）
     *
     * @param javaBean gradelist
     * @return
     */
    public JSONObject gradelist(PLJavaBean javaBean) {
        return exec("gradelist", javaBean);
    }

    /**
     * 根据机构ID查询年级和学科列表
     *
     * @param javaBean listByOrgId
     * @return
     */
    public JSONObject listByOrgId(PLJavaBean javaBean) {
        return exec("listByOrgId", javaBean);
    }



}
