package com.mizholdings.me2.user.serve;

import com.mizholdings.me2.agent.web.*;
import com.mizholdings.util.User;

import java.util.HashMap;
import java.util.Map;

public class Web extends ServeBase {

    public Web(User user) {
        super(user);
    }

    public ShoppingAgent shoppingAgent() {
        return (ShoppingAgent) getAgent("shoppingAgent");
    }

    public ItemAgent itemAgent() {
        return (ItemAgent) getAgent("itemAgent");
    }

    public TtiaoAgent ttiaoAgent() {
        return (TtiaoAgent) getAgent("ttiaoAgent");
    }

    public HlpAgent hlpAgent() {
        return (HlpAgent) getAgent("hlpAgent");
    }

    public PayAgent payAgent() {
        return (PayAgent) getAgent("payAgent");
    }

    public CreditAgent creditAgent() {
        return (CreditAgent) getAgent("creditAgent");
    }

    public AgentAgent agentAgent() {
        return (AgentAgent) getAgent("agentAgent");
    }

    public TopPageAgent topPageAgent() {
        return (TopPageAgent) getAgent("topPageAgent");
    }

    public AdvertAgent advertAgent() {
        return (AdvertAgent) getAgent("advertAgent");
    }

    public CoursewareAgent coursewareAgent() {
        return (CoursewareAgent) getAgent("coursewareAgent");
    }

    public CourseAgent courseAgent() {
        return (CourseAgent) getAgent("courseAgent");
    }

    public ShareAgent shareAgent() {
        return (ShareAgent) getAgent("shareAgent");
    }

    public CourseTypeAgent courseTypeAgent() {
        return (CourseTypeAgent) getAgent("courseTypeAgent");
    }

    public CompartAgent compartAgent() {
        return (CompartAgent) getAgent("compartAgent");
    }

    public OrgInfoAgent orgInfoAgent() {
        return (OrgInfoAgent) getAgent("orgInfoAgent");
    }

    public GradeAgent gradeAgent() {
        return (GradeAgent) getAgent("gradeAgent");
    }

    public QiniuAgent qiniuAgent() {
        return (QiniuAgent) getAgent("qiniuAgent");
    }

    public LessonTypeAgent lessonTypeAgent() {
        return (LessonTypeAgent) getAgent("lessonTypeAgent");
    }

    public ClassroomAgent classroomAgent() {
        return (ClassroomAgent) getAgent("classroomAgent");
    }

    public RefundAgent refundAgent() {
        return (RefundAgent) getAgent("refundAgent");
    }

    public LessonAgent lessonAgent() {
        return (LessonAgent) getAgent("lessonAgent");
    }

    public NewTagInfoAgent newTagInfoAgent() {
        return (NewTagInfoAgent) getAgent("newTagInfoAgent");
    }

    public UsrAgent usrAgent() {
        return (UsrAgent) getAgent("usrAgent");
    }

    public IntegAgent integAgent() {
        return (IntegAgent) getAgent("integAgent");
    }

    public PushAgent pushAgent() {
        return (PushAgent) getAgent("pushAgent");
    }

    public AnswerAgent answerAgent() {
        return (AnswerAgent) getAgent("answerAgent");
    }

}
