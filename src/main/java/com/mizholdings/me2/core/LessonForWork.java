package com.mizholdings.me2.core;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.interfaces.web.GradeInterface;
import com.mizholdings.me2.interfaces.web.LessonInterface;
import com.mizholdings.util.Requests;
import okhttp3.ResponseBody;
import org.testng.Assert;
import retrofit2.Call;

import java.text.SimpleDateFormat;
import java.util.*;

public class LessonForWork {
    private LessonInterface lessonInterface = Requests.getService(LessonInterface.class);
    private GradeInterface gradeInterface = Requests.getService(GradeInterface.class);

    public JSONObject getLessonTypeList(String token) {
        JSONObject object = Requests.getJson(lessonInterface.lessonType_list(token));
        Assert.assertEquals(200, java.util.Optional.ofNullable(object.getInteger("code")));
        return object;
    }


    public List<Object> getLessonObjectForRandom(String token, int len) {
        JSONObject object = getLessonTypeList(token);
        JSONArray list = object.getJSONObject("data").getJSONArray("list");
        Collections.shuffle(list);
        return list.subList(0, len);
    }

    public int getLessonTypeIdWithRandom(String token) {
        for (Object o : getLessonObjectForRandom(token, 1)) {
            JSONObject jsonObject = (JSONObject) o;
            return jsonObject.getInteger("typeId");
        }
        return 1;
    }

    public String getSimpleLesson(String token) {

        Date now = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Calendar c1 = Calendar.getInstance();
        c1.add(Calendar.DATE, 7);

        String lessonName = "测试课程" + ft.format(now);

        Call<ResponseBody> responseBodyCall = lessonInterface.add(token,
                "1",
                "一年级",
                1,
                lessonName,
                1,
                "",
                "",
                0,
                0,
                1,
                "http://images.mizholdings.com/VPkOMBaaZGU.png",
                ft.format(now),
                ft.format(c1.getTime()),
                2,
                0,
                60,
                "[{\"interaction\":4,\"startTime\":\"2019-09-02 13:57:32\",\"classroomId\":1},{\"interaction\":4,\"startTime\":\"2019-09-03 13:57:32\",\"classroomId\":1}]",
                200,
                1,
                20,
                0,
                1
        );

        JSONObject object = Requests.getJson(responseBodyCall);
        Assert.assertEquals("200", object.getString("code"));
        return lessonName;
    }


    public void addLesson(String token, String lessonName) {
        List<Object> objects = getGradeObjects(token, 3);
        String gradeIds = getGradeIds(objects);
        String gradeNames = getGradeNames(objects);
        int lessonTypeId = getLessonTypeIdWithRandom(token);

        Date now = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        Calendar c1 = Calendar.getInstance();
        c1.add(Calendar.DATE, 7);

        Call<ResponseBody> responseBodyCall = lessonInterface.add(token,
                gradeIds,
                gradeNames,
                lessonTypeId,
                lessonName,
                1,
                "",
                "",
                0,
                0,
                1,
                "http://images.mizholdings.com/VPkOMBaaZGU.png",
                ft.format(now),
                ft.format(c1.getTime()),
                2,
                0,
                60,
                "[{\"interaction\":4,\"startTime\":\"2019-09-02 13:57:32\",\"classroomId\":1},{\"interaction\":4,\"startTime\":\"2019-09-03 13:57:32\",\"classroomId\":1}]",
                200,
                1,
                20,
                0,
                1
        );

        JSONObject object = Requests.getJson(responseBodyCall);
        Assert.assertEquals("200", object.getString("code"));
    }


    public JSONObject getGradeList(String token) {
        JSONObject object = Requests.getJson(gradeInterface.grade_list(token));
        System.out.println(object);
//        Assert.assertEquals(Optional.of(0), object.getInteger("result"));
        assert 0 == object.getInteger("result");
        return object;
    }

    public List<Object> getGradeObjects(String token, int len) {
        JSONObject object = getGradeList(token);
        JSONArray gradeObjects = object.getJSONArray("data");
        Collections.shuffle(gradeObjects);
        return gradeObjects.subList(0, len);
    }

    public String getGradeIds(List<Object> gradeObjects) {
        ArrayList list = new ArrayList();
        for (Object o : gradeObjects) {
            JSONObject jsonObject = (JSONObject) o;
            list.add(jsonObject.getInteger("gradeId"));
        }
        String string = list.toString();
        return string.substring(1, string.length() - 1);
    }

    public String getGradeNames(List<Object> gradeObjects) {
        ArrayList list = new ArrayList();
        for (Object o : gradeObjects) {
            JSONObject jsonObject = (JSONObject) o;
            list.add(jsonObject.getInteger("gradeName"));
        }
        return String.join(",", list);
    }
}
