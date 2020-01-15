package superAdminTest;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import com.mizholdings.me2.ComboUtil;
import com.mizholdings.me2.Global;
import com.mizholdings.me2.agent.web.LessonAgent;
import com.mizholdings.me2.user.SuperAdmin;
import com.mizholdings.me2.user.Teacher;
import com.mizholdings.util.Parameter;
import org.testng.annotations.Test;

/**
 * 管理员可以直接编辑课程，
 */
public class lessonEditTestCase {

    SuperAdmin superAdmin = Global.init().getSuperAdmin();

    @Test
    public void test() {
        Teacher teacher = Global.init().getTeacher();
        String lessonId = teacher.newLessonAndGetLessonId(2);
        ComboUtil.applyLesson(superAdmin, teacher, lessonId);

        JSONObject object = superAdmin.getManage().lessonAgent().edit(lessonId, 4);

        // todo 管理员添加的课程，默认生活状态通过

    }


    // todo 机构直播课管理

}
