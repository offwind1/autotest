package com.mizholdings.me2.user.serve;

import com.mizholdings.me2.agent.app.*;
import com.mizholdings.me2.user.Me2UserBase;
import com.mizholdings.util.User;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class App extends ServeBase {
    public App(User user) {
        super(user);
    }

    public LebuAgent LebuAgent() {
        return (LebuAgent) getAgent("LebuAgent");
    }

    public FullschAgent fullschAgent() {
        return (FullschAgent) getAgent("fullschAgent");
    }

    public CardAgent cardAgent() {
        return (CardAgent) getAgent("cardAgent");
    }

    public VoteAgent voteAgent() {
        return (VoteAgent) getAgent("voteAgent");
    }

    public ClassChartAgent classChartAgent() {
        return (ClassChartAgent) getAgent("classChartAgent");
    }

    public CreditAgent creditAgent() {
        return (CreditAgent) getAgent("creditAgent");
    }

    public BankAgent bankAgent() {
        return (BankAgent) getAgent("bankAgent");
    }

    public IntegAgent integAgent() {
        return (IntegAgent) getAgent("integAgent");
    }

    public RankAgent rankAgent() {
        return (RankAgent) getAgent("rankAgent");
    }

    public CatalogAgent catalogAgent() {
        return (CatalogAgent) getAgent("catalogAgent");
    }

    public QuesAgent quesAgent() {
        return (QuesAgent) getAgent("quesAgent");
    }

    public CourseAgent courseAgent() {
        return (CourseAgent) getAgent("courseAgent");
    }

    public UsrAuthenAgent usrAuthenAgent() {
        return (UsrAuthenAgent) getAgent("usrAuthenAgent");
    }

    public PayAgent payAgent() {
        return (PayAgent) getAgent("payAgent");
    }

    public GradeAgent gradeAgent() {
        return (GradeAgent) getAgent("gradeAgent");
    }

    public HeartAgent heartAgent() {
        return (HeartAgent) getAgent("heartAgent");
    }

    public ClassInfoAgent classInfoAgent() {
        return (ClassInfoAgent) getAgent("classInfoAgent");
    }

    public OrgAgent orgAgent() {
        return (OrgAgent) getAgent("orgAgent");
    }

    public LessonInfoAgent lessonInfoAgent() {
        return (LessonInfoAgent) getAgent("lessonInfoAgent");
    }

    public CompartmentAgent compartmentAgent() {
        return (CompartmentAgent) getAgent("compartmentAgent");
    }

    public TopAgent topAgent() {
        return (TopAgent) getAgent("topAgent");
    }

    public UsrTagAgent usrTagAgent() {
        return (UsrTagAgent) getAgent("usrTagAgent");
    }

    public HeadImgAgent headImgAgent() {
        return (HeadImgAgent) getAgent("headImgAgent");
    }

    public AdvertAgent advertAgent() {
        return (AdvertAgent) getAgent("advertAgent");
    }

    public LessonTypeAgent lessonTypeAgent() {
        return (LessonTypeAgent) getAgent("lessonTypeAgent");
    }

    public SafeQuesAgent safeQuesAgent() {
        return (SafeQuesAgent) getAgent("safeQuesAgent");
    }

    public UsrCollAgent usrCollAgent() {
        return (UsrCollAgent) getAgent("usrCollAgent");
    }

    public MobileAgent mobileAgent() {
        return (MobileAgent) getAgent("mobileAgent");
    }

    public AnswerAgent answerAgent() {
        return (AnswerAgent) getAgent("answerAgent");
    }


}
