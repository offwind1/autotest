package coursewareTest;

import com.mizholdings.me2.ComboUtil;
import com.mizholdings.me2.Global;
import com.mizholdings.me2.Global_enum;
import com.mizholdings.me2.user.Teacher;
import org.testng.annotations.Test;

public class coursewareTest {


    /**
     * 为课程添加课件
     * 查看web端和app端，获取课堂资源列表接口，是否正常
     */
    @Test
    public void test() {
        Teacher teacher = Global.init().getTeacher();

        String lessonId = teacher.newLessonAndGetLessonId(1);
        ComboUtil.applyLesson(Global.init().getSuperAdmin(), teacher, lessonId);

        teacher.getApp().courseAgent().uploadFile2(lessonId, "", Global_enum.COURSEWARE_TYPE.JIAO_AN);


    }

}
