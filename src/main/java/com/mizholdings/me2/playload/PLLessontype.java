package com.mizholdings.me2.playload;

import com.mizholdings.util.PLJavaBean;
import lombok.Data;

@Data
public class PLLessontype extends PLJavaBean {

    private String parentId;
    private String typeName;
    private String gradeIds;

    /**
     * 查询学科列表
     *
     * @param parentId int,父级学科ID(选填)
     * @param typeName string,学科名称，用于模糊查询（选填）
     * @param gradeIds 年级id，多个之间逗号隔开
     */
    public void setList(String parentId, String typeName, String gradeIds) {
        this.parentId = parentId;
        this.typeName = typeName;
        this.gradeIds = gradeIds;

    }

    private String userTypeIds;

    /**
     * 学科编辑保存
     *
     * @param userTypeIds string,学科ID集合，用“，”隔开
     */
    public void setSavelist(String userTypeIds) {
        this.userTypeIds = userTypeIds;

    }


}