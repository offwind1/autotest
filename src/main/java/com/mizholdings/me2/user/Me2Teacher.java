package com.mizholdings.me2.user;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.agent.web.LessonAgent;
import com.mizholdings.me2.user.serve.Me2tiku;
import com.mizholdings.me2.user.serve.Web;
import com.mizholdings.me2.user.serveInterface.tikuInterface;
import com.mizholdings.me2.user.serveInterface.webInterface;
import com.mizholdings.util.Common;
import com.mizholdings.util.SampleAssert;

import java.util.List;
import java.util.stream.Collectors;

public class Me2Teacher extends Me2UserBase implements webInterface, tikuInterface {
    protected Web web;
    protected Me2tiku tiku;

    public Me2Teacher(String account, String password) {
        super(account, password, "web");
        web = new Web(this);
        tiku = new Me2tiku(this);
    }

    public Web getWeb() {
        return web;
    }

    public Me2tiku getTiku() {
        return tiku;
    }

    public String newLessonAndGetLessonId(LessonAgent.FreeType free) {
        return newLessonAndGetLessonId(free, 0, 2);
    }

    public String newLessonAndGetLessonId(int classRoomCount) {
        return newLessonAndGetLessonId(LessonAgent.FreeType.FREE, 0, classRoomCount);
    }

    public String newLessonAndGetLessonId(LessonAgent.FreeType free, int startDay, int classRoomCount) {
        String name = Common.creatRandomString();
        JSONObject object = web.lessonAgent().addLesson(name, classRoomCount, free, startDay);
        SampleAssert.assertCode200(object);
        object = web.lessonAgent().list(name);
        SampleAssert.assertCode200(object);

        List<Object> list = object.getJSONObject("data").getJSONArray("list").stream().filter(i -> {
            JSONObject o = (JSONObject) i;
            return name.equals(o.getString("lessonName"));
        }).collect(Collectors.toList());

        assert list.size() > 0;
        return ((JSONObject) list.get(0)).getString("lessonId");
    }

    public String newCourseAndApply() {
        JSONObject object = app.courseAgent().uploadFile();
        return object.getJSONObject("data").getString("coursewareId");
    }

    public String newCourseAndApply(String courseName) {
        String coursewareId = newCourseAndApply();

        object = web.courseAgent().editCourseware(coursewareId, courseName);
        SampleAssert.assertCode200(object);
        object = web.courseAgent().applyCourse(coursewareId);
        SampleAssert.assertCode200(object);

        return coursewareId;
    }

    public String newCourseAndApply(String courseName, String creditNum) {
        String coursewareId = newCourseAndApply();

        object = web.courseAgent().editCourseware(coursewareId, courseName, "0", creditNum);
        SampleAssert.assertCode200(object);
        object = web.courseAgent().applyCourse(coursewareId);
        SampleAssert.assertCode200(object);

        return coursewareId;
    }


    public JSONObject quickStart() {
        JSONObject object = app.classInfoAgent().getCode();
        String code = object.getJSONObject("data").getString("classroomCode");
        return app.classInfoAgent().quickStart(Common.creatRandomString(), code);
    }

}
