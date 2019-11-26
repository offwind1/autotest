package com.mizholdings.me2.user.serve;

import com.mizholdings.me2.agent.app.*;
import com.mizholdings.me2.user.Me2UserBase;
import com.mizholdings.util.User;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class App extends ServeBase {
    private LessonInfoAgent lessonInfoAgent;
    private CourseAgent courseAgent;
    private MobileAgent mobileAgent;
    private VoteAgent voteAgent;
    private FullschAgent fullschAgent;
    private CardAgent cardAgent;
    private TopAgent topAgent;
    private PayAgent payAgent;
    private ClassInfoAgent classInfoAgent;
    private IntegAgent integAgent;

    public App(User user) {
        super(user);
    }


    public LessonInfoAgent lessonInfoAgent() {
        return (LessonInfoAgent) getAgent("lessonInfoAgent");
    }

    public CourseAgent courseAgent() {
        return (CourseAgent) getAgent("courseAgent");
    }

    public FullschAgent fullschAgent() {
        return (FullschAgent) getAgent("fullschAgent");
    }

    public VoteAgent voteAgent() {
        return (VoteAgent) getAgent("voteAgent");
    }

    public MobileAgent mobileAgent() {
        return (MobileAgent) getAgent("mobileAgent");
    }

    public CardAgent cardAgent() {
        return (CardAgent) getAgent("cardAgent");
    }

    public TopAgent topAgent() {
        return (TopAgent) getAgent("topAgent");
    }

    public ClassInfoAgent classInfoAgent() {
        return (ClassInfoAgent) getAgent("classInfoAgent");
    }

    public PayAgent payAgent() {
        return (PayAgent) getAgent("payAgent");
    }

    public IntegAgent integAgent() {
        return (IntegAgent) getAgent("integAgent");
    }


}
