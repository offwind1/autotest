package com.mizholdings.me2.core.mod;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.core.user.Me2UserBase;
import com.mizholdings.me2.interfaces.api.VoteInterface;
import com.mizholdings.util.MODBase;
import com.mizholdings.util.PLJavaBean;
import com.mizholdings.util.Requests;

public class MODVote extends MODBase<MODVote> {
    public static VoteInterface voteInterface = Requests.getService(VoteInterface.class);

    public MODVote(Me2UserBase executor) {
        super(executor);
        interfaced = voteInterface;
    }


   
/**
 * 老师发起投票
 *
 * @param javaBean insert
 * @return
 */
public JSONObject insert(PLJavaBean javaBean) {
    return exec("insert", javaBean);
}

/**
 * 查询课堂中所有投票
 *
 * @param javaBean getList
 * @return
 */
public JSONObject getList(PLJavaBean javaBean) {
    return exec("getList", javaBean);
}

/**
 * 提交投票结果
 *
 * @param javaBean subOption
 * @return
 */
public JSONObject subOption(PLJavaBean javaBean) {
    return exec("subOption", javaBean);
}

/**
 * 获得投票用户列表
 *
 * @param javaBean getOptionUser
 * @return
 */
public JSONObject getOptionUser(PLJavaBean javaBean) {
    return exec("getOptionUser", javaBean);
}

/**
 * 结束投票
 *
 * @param javaBean voteEnd
 * @return
 */
public JSONObject voteEnd(PLJavaBean javaBean) {
    return exec("voteEnd", javaBean);
}


}