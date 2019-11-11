package com.mizholdings.me2.interfaces.web;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

import java.util.Map;

public interface UsrInterface {

    
/**
 * 代理商登陆
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/usr/agentLogin")
@FormUrlEncoded
Call<ResponseBody> agentLogin(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 查询机构下老师信息
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/usr/orgTeacherInfo")
@FormUrlEncoded
Call<ResponseBody> orgTeacherInfo(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 机构列表
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/usr/orgUserList")
@FormUrlEncoded
Call<ResponseBody> orgUserList(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 根据课程Id查学生信息
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/usr/lessonStudent")
@FormUrlEncoded
Call<ResponseBody> lessonStudent(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 验证登陆用户密码
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/usr/checkPassword")
@FormUrlEncoded
Call<ResponseBody> checkPassword(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 用户登陆
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/usr/login")
@FormUrlEncoded
Call<ResponseBody> login(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 获取登陆用户信息
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/usr/getInfo")
@FormUrlEncoded
Call<ResponseBody> getInfo(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 用户列表
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/usr/list")
@FormUrlEncoded
Call<ResponseBody> list(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 根据用户ID获得用户信息
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/usr/getUserById")
@FormUrlEncoded
Call<ResponseBody> getUserById(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 编辑用户信息
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/usr/editUser")
@FormUrlEncoded
Call<ResponseBody> editUser(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 认证审批
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/usr/replyUser")
@FormUrlEncoded
Call<ResponseBody> replyUser(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 查询认证的用户
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/usr/applylist")
@FormUrlEncoded
Call<ResponseBody> applylist(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 用户消费记录查询
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/usr/consumList")
@FormUrlEncoded
Call<ResponseBody> consumList(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 用户交易记录
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/usr/transaction")
@FormUrlEncoded
Call<ResponseBody> transaction(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 提现申请
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/usr/drawcash")
@FormUrlEncoded
Call<ResponseBody> drawcash(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 查询提现申请
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/usr/applyCashList")
@FormUrlEncoded
Call<ResponseBody> applyCashList(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 提现申请审批
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/usr/replyCash")
@FormUrlEncoded
Call<ResponseBody> replyCash(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 查询登陆用户信息和机构信息
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web//usr/usrOrgInfo")
@FormUrlEncoded
Call<ResponseBody> usrOrgInfo(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 查询登录用户交易记录
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web//usr/transList")
@FormUrlEncoded
Call<ResponseBody> transList(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 订单管理
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/usr/consumListPage")
@FormUrlEncoded
Call<ResponseBody> consumListPage(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 检验老师是否注册
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/usr/checkTeacher")
@FormUrlEncoded
Call<ResponseBody> checkTeacher(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 机构删除老师
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/usr/orgDelTeacher")
@FormUrlEncoded
Call<ResponseBody> orgDelTeacher(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 查询老师下的学生
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/usr/getStuByTeacher")
@FormUrlEncoded
Call<ResponseBody> getStuByTeacher(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 提现申请列表
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/usr/drawcashList")
@FormUrlEncoded
Call<ResponseBody> drawcashList(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 用户管理
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/usr/usrManage")
@FormUrlEncoded
Call<ResponseBody> usrManage(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 删除用户
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/usr/delUser")
@FormUrlEncoded
Call<ResponseBody> delUser(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 用户认证
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/usr/authenUser")
@FormUrlEncoded
Call<ResponseBody> authenUser(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 安全问题列表
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/usr/safeQuestion")
@FormUrlEncoded
Call<ResponseBody> safeQuestion(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 添加用户
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/usr/addNewUser")
@FormUrlEncoded
Call<ResponseBody> addNewUser(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 管理员登陆
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/usr/manageLogin")
@FormUrlEncoded
Call<ResponseBody> manageLogin(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 修改用户米猪币或米猪时光
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/usr/changeMoney")
@FormUrlEncoded
Call<ResponseBody> changeMoney(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 获取验证码
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/usr/phoneCode")
@FormUrlEncoded
Call<ResponseBody> phoneCode(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 检验验证码
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/usr/checkPhoneCode")
@FormUrlEncoded
Call<ResponseBody> checkPhoneCode(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 用户收支明细查询
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/usr/incomeList")
@FormUrlEncoded
Call<ResponseBody> incomeList(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 课程课件交易记录
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/usr/lessonCourseList")
@FormUrlEncoded
Call<ResponseBody> lessonCourseList(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 冻结列表
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/usr/freezeList")
@FormUrlEncoded
Call<ResponseBody> freezeList(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 冻结用户资金
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/usr/freezeCoin")
@FormUrlEncoded
Call<ResponseBody> freezeCoin(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 解冻米猪币
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/usr/unFreezeCoin")
@FormUrlEncoded
Call<ResponseBody> unFreezeCoin(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 银行列表
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/usr/bankList")
@FormUrlEncoded
Call<ResponseBody> bankList(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 扫码登陆
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/usr/scanLogin")
@FormUrlEncoded
Call<ResponseBody> scanLogin(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 查看用户提现列表
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/usr/userDrawcashList")
@FormUrlEncoded
Call<ResponseBody> userDrawcashList(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 审批提现申请
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/usr/drawcashReply")
@FormUrlEncoded
Call<ResponseBody> drawcashReply(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 获取用户学分id
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/usr/getUserCreditId")
@FormUrlEncoded
Call<ResponseBody> getUserCreditId(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 米猪币账户管理
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/usr/mizhuCoinBillManage")
@FormUrlEncoded
Call<ResponseBody> mizhuCoinBillManage(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 老师查询学生
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/usr/teacherSearchUser")
@FormUrlEncoded
Call<ResponseBody> teacherSearchUser(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 定制机构用户登录
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/usr/orgUserLogin")
@FormUrlEncoded
Call<ResponseBody> orgUserLogin(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 合并账号
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/usr/accountMerge")
@FormUrlEncoded
Call<ResponseBody> accountMerge(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    

}