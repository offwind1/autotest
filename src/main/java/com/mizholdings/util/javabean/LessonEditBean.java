package com.mizholdings.util.javabean;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.Global;
import com.mizholdings.me2.Global_enum;
import com.mizholdings.util.Common;
import com.mizholdings.util.Extractable;
import com.mizholdings.util.Parameter;
import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;

@Data
public class LessonEditBean implements Extractable {
    private List<Global_enum.GRADEID> gradeIds = new ArrayList<Global_enum.GRADEID>() {{
        add(Global_enum.GRADEID.ONE);
    }};
    private Global_enum.LESSON_TYPE_ID lesson_type_id = Global_enum.LESSON_TYPE_ID.CHI;
    private String lessonTerm = "1";
    private String lessonName = Common.creatRandomString();
    private String faceImg = Global.getImageUrl();
    private int classroomCount = 1;
    private String classTime = "60";
    private String classroomPrice = "0";
    private Global_enum.FREE_TYPE free = Global_enum.FREE_TYPE.FREE;
    private String studentCount = "200";
    private Global_enum.CustRelease custRelease = Global_enum.CustRelease.NORMAL;
    private int startDay = 0;

    public List<Global_enum.GRADEID> getGrade() {
        return gradeIds;
    }

    public String getGradeIds() {
        return gradeIds.stream().map(i -> {
            return i.value;
        }).collect(Collectors.joining(","));
    }

    public String getGradeNames() {
        return gradeIds.stream().map(i -> {
            return i.gradeName;
        }).collect(Collectors.joining(","));
    }

    public void addGradeId(Global_enum.GRADEID gradeid) {
        if (!gradeIds.contains(gradeid)) {
            gradeIds.add(gradeid);
        }
    }

    public JSONArray getArray() {
        JSONArray array = new JSONArray();
        for (int i = 0; i < classroomCount; i++) {
            JSONObject object = new JSONObject();
            object.put("interaction", 4);
            object.put("startTime", Common.getEndTime(startDay + i));
            object.put("classroomId", 1);
            array.add(object);
        }
        return array;
    }

    public Parameter build() {
        return Parameter.creat()
                .add("gradeIds", getGradeIds())
                .add("gradeNames", getGradeNames())
                .add("lessonTypeId", lesson_type_id.value)
                .add("startTime", Common.getEndTime(startDay))
                .add("endTime", Common.getEndTime(startDay + 7))
                .add("tryLook", "0")
                .add("lessonTerm", lessonTerm)
                .add("lessonName", lessonName)
                .add("faceImg", faceImg)
                .add("classroomCount", String.valueOf(classroomCount))
                .add("classTime", classTime)
                .add("classroomPrice", classroomPrice)
                .add("discount", String.valueOf(10 * classroomCount))
                .add("free", free.value)
                .add("classInfo", getArray().toJSONString())
                .add("studentCount", studentCount)
                .add("custRelease", custRelease.value);
    }

    @Override
    public Map<String, String> getMap() {
        return build().getMap();
    }

    @Override
    public Map<String, Object> getObjectMap() {
        return build().getObjectMap();
    }

}
