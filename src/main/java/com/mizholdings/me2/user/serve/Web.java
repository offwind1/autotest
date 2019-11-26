package com.mizholdings.me2.user.serve;

import com.mizholdings.me2.agent.web.*;
import com.mizholdings.me2.user.Me2UserBase;
import com.mizholdings.util.User;

public class Web extends ServeBase {

    private WebUsrAgent webUsrAgent;
    private WebCourseAgent webCourseAgent;
    private LessonAgent lessonAgent;
    private OrgInfoAgent orgInfoAgent;
    private Me2tikuAgent me2tikuAgent;
    private ClassroomAgent classroomAgent;
    private ItemAgent itemAgent;

    public Web(User user) {
        super(user);
    }

    public WebUsrAgent webUsrAgent() {
        return (WebUsrAgent) getAgent("webUsrAgent");
    }

    public WebCourseAgent webCourseAgent() {
        return (WebCourseAgent) getAgent("webCourseAgent");
    }

    public LessonAgent lessonAgent() {
        return (LessonAgent) getAgent("lessonAgent");
    }

    public OrgInfoAgent orgInfoAgent() {
        return (OrgInfoAgent) getAgent("orgInfoAgent");
    }

    public Me2tikuAgent me2tikuAgent() {
        return (Me2tikuAgent) getAgent("me2tikuAgent");
    }

    public ClassroomAgent classroomAgent() {
        return (ClassroomAgent) getAgent("classroomAgent");
    }

    public ItemAgent itemAgent() {
        return (ItemAgent) getAgent("itemAgent");
    }


}
