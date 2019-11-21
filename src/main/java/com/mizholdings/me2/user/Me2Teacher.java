package com.mizholdings.me2.user;

import com.mizholdings.me2.agent.app.CourseAgent;
import com.mizholdings.me2.agent.web.WebCourseAgent;
import com.mizholdings.me2.agent.web.WebUsrAgent;

public class Me2Teacher extends Me2UserBase {

    private WebUsrAgent webUsrAgent;
    private WebCourseAgent webCourseAgent;

    public Me2Teacher(String account, String password) {
        super(account, password, "web");
    }


    public WebUsrAgent webUsrAgent() {
        return (WebUsrAgent) getAgent("webUsrAgent");
    }

    public WebCourseAgent webCourseAgent() {
        return (WebCourseAgent) getAgent("webCourseAgent");
    }


}
