package com.mizholdings.me2.playload;

import com.mizholdings.util.PLJavaBean;
import lombok.Data;

@Data
public class PLVote extends PLJavaBean {

    private String classroomId;
    private String duration;
    private String multiSelect;
    private String voteEnd;
    private String voteContent;
    private String optionContent;
    private String voteKey;

    /**
     * 老师发起投票
     *
     * @param classroomId   string,课程ID
     * @param duration      int,投票时长（分钟）
     * @param multiSelect   int,题目类型,1多选，0单选，2填空题
     * @param voteEnd       int,投票是否结束,0结束，1未结束
     * @param voteContent   string,投票主题内容
     * @param optionContent string,投票选项，json字段（optionName,optionContent）
     * @param voteKey       String,投票所在页的KEY，前端要求加
     */
    public void setInsert(String classroomId, String duration, String multiSelect, String voteEnd, String voteContent, String optionContent, String voteKey) {
        this.classroomId = classroomId;
        this.duration = duration;
        this.multiSelect = multiSelect;
        this.voteEnd = voteEnd;
        this.voteContent = voteContent;
        this.optionContent = optionContent;
        this.voteKey = voteKey;

    }


    /**
     * 查询课堂中所有投票
     *
     * @param classroomId string,课程ID
     */
    public void setGetlist(String classroomId) {
        this.classroomId = classroomId;

    }

    private String voteId;
    private String optionIds;
    private String optionValues;

    /**
     * 提交投票结果
     *
     * @param voteId       string,投票ID
     * @param optionIds    string,选项ID集合，用逗号分隔
     * @param optionValues string,填空题,学生填写的答案集合，用逗号分隔
     */
    public void setSuboption(String voteId, String optionIds, String optionValues) {
        this.voteId = voteId;
        this.optionIds = optionIds;
        this.optionValues = optionValues;

    }


    /**
     * 获得投票用户列表
     *
     * @param voteId string,投票详情ID
     */
    public void setGetoptionuser(String voteId) {
        this.voteId = voteId;

    }


    /**
     * 结束投票
     *
     * @param voteId string,投票详情ID
     */
    public void setVoteend(String voteId) {
        this.voteId = voteId;

    }


}