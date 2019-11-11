package com.mizholdings.me2.core.mod;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.core.user.Me2UserBase;
import com.mizholdings.me2.interfaces.api.BankInterface;
import com.mizholdings.util.MODBase;
import com.mizholdings.util.PLJavaBean;
import com.mizholdings.util.Requests;

public class MODBank extends MODBase<MODBank> {
    public static BankInterface bankInterface = Requests.getService(BankInterface.class);

    public MODBank(Me2UserBase executor) {
        super(executor);
        interfaced = bankInterface;
    }


   
/**
 * 银行列表
 *
 * @param javaBean list
 * @return
 */
public JSONObject list(PLJavaBean javaBean) {
    return exec("list", javaBean);
}

/**
 * 获取提现账号
 *
 * @param javaBean drawAccount
 * @return
 */
public JSONObject drawAccount(PLJavaBean javaBean) {
    return exec("drawAccount", javaBean);
}

/**
 * 设置支付密码
 *
 * @param javaBean paypwd
 * @return
 */
public JSONObject paypwd(PLJavaBean javaBean) {
    return exec("paypwd", javaBean);
}

/**
 * 申请提现
 *
 * @param javaBean drawApply
 * @return
 */
public JSONObject drawApply(PLJavaBean javaBean) {
    return exec("drawApply", javaBean);
}

/**
 * 绑定银行卡
 *
 * @param javaBean binding
 * @return
 */
public JSONObject binding(PLJavaBean javaBean) {
    return exec("binding", javaBean);
}

/**
 * 解除银行卡绑定
 *
 * @param javaBean rmBinding
 * @return
 */
public JSONObject rmBinding(PLJavaBean javaBean) {
    return exec("rmBinding", javaBean);
}

/**
 * 用户钱包主界面
 *
 * @param javaBean userWallet
 * @return
 */
public JSONObject userWallet(PLJavaBean javaBean) {
    return exec("userWallet", javaBean);
}

/**
 * 用户直播界面数据
 *
 * @param javaBean userDirect
 * @return
 */
public JSONObject userDirect(PLJavaBean javaBean) {
    return exec("userDirect", javaBean);
}


}