package com.mizholdings.me2.cases;

import com.mizholdings.me2.interfaces.web.LessonInterface;
import com.mizholdings.me2.model.User;
import com.mizholdings.me2.core.Global;
import com.mizholdings.me2.core.LessonForWork;
import com.mizholdings.util.Requests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LessonTestCase {
    private LessonInterface lessonInterface = Requests.getService(LessonInterface.class);
    private User teacher;
    private LessonForWork lessonForWork = new LessonForWork();

    @BeforeClass
    public void beforeClass() {
        teacher = Global.teacher;
    }

    @Test
    public void addLesson(){

        lessonForWork.addLesson(teacher.getToken(), "累死我了");

    }


}
