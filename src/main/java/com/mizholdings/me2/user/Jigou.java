package com.mizholdings.me2.user;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.util.Common;
import com.mizholdings.util.SampleAssert;

import java.util.List;
import java.util.stream.Collectors;

public class Jigou extends Teacher {

    public Jigou(String account, String password) {
        super(account, password);
    }

    /**
     * 新建新闻
     *
     * @return 返回新闻Id
     */
    public String creatMessage() {
        String msgName = Common.creatRandomString();
        getWeb().orgInfoAgent().insertMessage(msgName);
        JSONObject object = getWeb().orgInfoAgent().orgMessageList();
        List<Object> list = object.getJSONObject("data").getJSONArray("list").stream().filter(i -> {
            JSONObject o = (JSONObject) i;
            return msgName.equals(o.getString("messageName"));
        }).collect(Collectors.toList());
        assert list.size() > 0;
        return ((JSONObject) list.get(0)).getString("messageId");
    }

    @Override
    public String getOrgId() {
        return this.object.getJSONObject("data").getString("orgId");
    }

    /**
     * 添加教师
     */
    public String addTeacher(String phone) {
        JSONObject object = web.usrAgent().checkTeacher(phone);
        SampleAssert.assertEquals("已注册", object);

        String nickname = object.getJSONObject("data").getJSONObject("userInfo").getString("nickname");
        String userId = object.getJSONObject("data").getJSONObject("userInfo").getString("userId");

        object = web.orgInfoAgent().addTeacher(nickname, getOrgId(), phone, userId);
        SampleAssert.assertCode200(object);
        return userId;
    }

    /**
     * 删除教师
     *
     * @param userId 用户id
     */
    public void delTeacher(String userId) {
        JSONObject object = web.usrAgent().orgDelTeacher(getUserId(), userId);
        SampleAssert.assertCode200(object);
    }


    public JSONObject studentJoinJigou(UserBase student) {
        return web.orgInfoAgent().addStudentToOrg(student.getAccount());
    }

    public JSONObject studentQuitJigou(UserBase student) {
        return web.usrAgent().orgDelTeacher(student.getUserId());
    }

}
