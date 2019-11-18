package com.mizholdings.kacha.playload;

import com.mizholdings.util.PLJavaBean;
import lombok.Data;

@Data
public class PLSchool extends PLJavaBean {

    private String classId;
    private String childId;
    private String schoolId;
    private String type;
    private String subjectId;
    private String startTime;
    private String endTime;
    private String year;
    private String years;
    private String ownerPhone;
    private String pageSize;
    private String pageNum;
    private String className;
    private String phone;
    private String name;
    private String uqid;
    private String gradeId;
    private String adminId;
    private String des;
    private String filename;
    private String OldClassId;
    private String userId;
    private String subjectName;
    private String isAdmin;
    private String isPush;
    private String schoolName;
    private String province;
    private String city;
    private String area;
    private String phaseId;
    private String effStart;
    private String effEnd;
    private String address;
    private String masterName;
    private String upperLimit;
    private String schoolType;
    private String managerNames;
    private String managerPhones;
    private String roleName;


    /**
     * 4.1.1 学生加入班级
     *
     * @param classId int 班级id
     * @param childId 子女id 不填时 自己添加进班级
     */
    public void setClassStudentJoin(String classId, String childId) {
        this.classId = classId;
        this.childId = childId;
    }

    /**
     * 4.1.2 退出班级
     *
     * @param classId int 班级id
     * @param childId 子女id 不填时 自己退出进班级
     */
    public void setClassStudentExit(String classId, String childId) {
        this.classId = classId;
        this.childId = childId;
    }


    /**
     * 4.1.3 成员列表
     *
     * @param schoolId 学校ID
     * @param classId  班级ID
     * @param type     : 1-教师 3-学生 无-全部
     */
    public void setClassMembers(String schoolId, String classId, String type) {
        this.schoolId = schoolId;
        this.classId = classId;
        this.type = type;
    }

    /**
     * 4.1.4 超级管理员页面学生数据
     *
     * @param classId   班级ID
     * @param subjectId 学科
     */
    public void setClassMembersForSA(String classId, String subjectId) {
        this.classId = classId;
        this.subjectId = subjectId;
        startTime = "";
        endTime = "";
    }

    /**
     * 4.2.1 班级信息
     *
     * @param classId 班级id
     */
    public void setClassDetail(String classId) {
        this.classId = classId;
    }

    /**
     * 4.2.2 班级信息
     *
     * @param schoolId   学校id
     * @param year       年
     * @param ownerPhone 电话号
     */
    public void setClassDetail(String schoolId, String year, String ownerPhone) {
        this.schoolId = schoolId;
        this.year = year;
        this.ownerPhone = ownerPhone;
    }

    /**
     * 4.2.3班级信息返回
     *
     * @param classId 班级ID
     */
    public void setClassInfo(String classId) {
        this.classId = classId;
    }


    /**
     * 4.2.4 班级列表
     *
     * @param schoolId  学校ID
     * @param className 分页大小
     * @param pageNum   页码
     * @param pageSize  班级名称（模糊）
     */
    public void setClassList(String schoolId, String className,
                             String pageNum, String pageSize) {
        this.schoolId = schoolId;
        this.className = className;
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }

    public void setClassList(String schoolId) {
        this.schoolId = schoolId;
//        this.className = className;
        this.pageNum = "1";
        this.pageSize = "9999";
    }


    /**
     * 4.3 班级教师
     *
     * @param name  string 教师姓名
     * @param phone 教师电话号码
     * @param year  学年
     */
    public void setClassDetailOwner(String name, String phone, String year) {
        this.name = name;
        this.phone = phone;
        this.year = year;
    }

    /**
     * 4.3.1教师星标收藏
     *
     * @param uqid 题目ID
     * @param type （0-新增收藏 1-取消收藏）
     */
    public void setClassTeacherCollect(String uqid, String type) {
        this.uqid = uqid;
        this.type = type;
    }

    /**
     * 4.3.2 新建班级
     *
     * @param schoolId  学校ID
     * @param className 班级名称
     * @param gradeId   年级ID
     * @param years     学届
     * @param adminId   班主任ID
     * @param des       描述
     */
    public void setClassManageCreat(String schoolId, String className,
                                    String gradeId, String years,
                                    String adminId, String des) {
        this.schoolId = schoolId;
        this.className = className;
        this.gradeId = gradeId;
        this.years = years;
        this.adminId = adminId;
        this.des = des;
    }

    public void setClassManageCreat(String schoolId, String className) {
        this.schoolId = schoolId;
        this.className = className;
        this.gradeId = "9";
        this.years = "2019";
//        this.adminId = adminId;
//        this.des = des;
    }

    /**
     * 4.3.3 新建班级
     *
     * @param schoolId 学校ID
     * @param year     对应学年
     * @param filename excle文件路径(符合导入模板)
     */
    public void setCreatManageCreatExcel(String schoolId, String year, String filename) {
        this.schoolId = schoolId;
        this.year = year;
        this.filename = filename;
    }

    /**
     * 4.3.4 更新班级
     *
     * @param classId:   班级ID
     * @param className: 班级名称
     * @param years:     学届
     * @param gradeId:   年级ID
     * @param adminId:   班主任ID
     * @param des:       描述
     */
    public void setClassManageUpdate(String classId, String className, String years, String gradeId, String adminId, String des) {
        this.classId = classId;
        this.className = className;
        this.years = years;
        this.gradeId = gradeId;
        this.adminId = adminId;
        this.des = des;

    }


    /**
     * 4.3.5 删除班级
     *
     * @param classId: 班级ID
     */
    public void setClassManageDelete(String classId) {
        this.classId = classId;

    }

    /**
     * 4.3.6 一键升级班级
     *
     * @param *OldClassId：原班级ID
     */
    public void setClassManagePromotion(String OldClassId) {
        this.OldClassId = OldClassId;

    }

    /**
     * 4.3.7 管理学生加班
     *
     * @param *userId：     用户ID
     * @param *classId：    班级ID
     * @param subjectName: 科目名称
     * @param isAdmin:     1-是 0-否
     */
    public void setClassManageUserJoin(String userId, String classId, String subjectName, String isAdmin) {
        this.userId = userId;
        this.classId = classId;
        this.subjectName = subjectName;
        this.isAdmin = isAdmin;

    }

    /**
     * 4.3.8 管理学生退班
     *
     * @param *userId：  用户ID
     * @param *classId： 班级ID
     */
    public void setClassManageUserExit(String userId, String classId) {
        this.userId = userId;
        this.classId = classId;

    }

    /**
     * 4.3.9 管理学生是否推送一错一练
     *
     * @param *userId：         学生ID
     * @param *classId：        班级ID
     * @param *isPush：是否推送（0-否 1-是）
     */
    public void setClassManageUserPushmarker(String userId, String classId, String isPush) {
        this.userId = userId;
        this.classId = classId;
        this.isPush = isPush;
    }


    /**
     * 4.4.1 学校可用学年
     *
     * @param *schoolId: 学校ID
     */
    public void setSchoolInfoYears(String schoolId) {
        this.schoolId = schoolId;

    }


    /**
     * 4.5.2 班级学科列表
     *
     * @param *classId：班级ID
     * @param *year：学年
     */
    public void setSchoolSubjectClass(String classId, String year) {
        this.classId = classId;
        this.year = year;

    }

    /**
     * 4.5.4任职为班主任的班级和学科列表（班主任和校管）
     *
     * @param *year：学年
     * @param *schoolId：学校Id
     */
    public void setSchoolClassUserTeachingclasses(String year, String schoolId) {
        this.year = year;
        this.schoolId = schoolId;

    }

    /**
     * 4.6.1 学校列表返回
     *
     * @param pageSize：   分页大小
     * @param pageNum:    页码
     * @param schoolName： 学校名称（模糊）
     * @param province:   省份
     * @param city:       城市
     * @param area:       区域
     * @param phaseId:    学段ID 1-小学 2-初中 3-高中 4-全学段
     */
    public void setSchoolInfoSchoollist(String pageSize, String pageNum, String schoolName, String province, String city, String area, String phaseId) {
        this.pageSize = pageSize;
        this.pageNum = pageNum;
        this.schoolName = schoolName;
        this.province = province;
        this.city = city;
        this.area = area;
        this.phaseId = phaseId;

    }

    public void setSchoolInfoSchoollist(String schoolName) {
        this.pageSize = "10";
        this.pageNum = "1";
        this.schoolName = schoolName;
    }

    /**
     * 4.6.2 学校信息返回
     *
     * @param schoolId: 学校ID
     */
    public void setSchoolInfoDetail(String schoolId) {
        this.schoolId = schoolId;

    }

    /**
     * 4.7.1 新建学校
     *
     * @param *schoolName:        学校名称
     * @param effStart:           生效时间
     * @param effEnd:             失效时间
     * @param province:           省份
     * @param city:               城市
     * @param area:               区域
     * @param address:            学校地址
     * @param masterName:         管理员姓名
     * @param phone:              管理员手机
     * @param des:                学校备注
     * @param phaseId:            学段ID 1-小学 2-初中 3-高中 4-全学段
     * @param upperLimit：累积使用人上限
     * @param schoolType：0-学校(默认) 1-机构
     */
    public void setSchoolManageCreate(String schoolName, String effStart, String effEnd, String province, String city, String area, String address, String masterName, String phone, String des, String phaseId, String upperLimit, String schoolType) {
        this.schoolName = schoolName;
        this.province = province;
        this.city = city;
        this.area = area;
        this.phone = phone;
        this.des = des;
        this.phaseId = phaseId;
        this.effStart = effStart;
        this.effEnd = effEnd;
        this.address = address;
        this.masterName = masterName;
        this.upperLimit = upperLimit;
        this.schoolType = schoolType;

    }

    /**
     * 4.7.1 新建学校
     *
     * @param schoolName 学校名称
     */
    public void setSchoolManageCreate(String schoolName) {
        this.schoolName = schoolName;
    }

    /**
     * 4.7.2 更新学校
     *
     * @param *schoolId:          学校ID
     * @param schoolName:         学校名称
     * @param province:           省份
     * @param city:               城市
     * @param area:               区域
     * @param address:            学校地址
     * @param des:                学校备注
     * @param phaseId:            学段ID 1-小学 2-初中 3-高中 4-全学段
     * @param upperLimit：累积使用人上限
     * @param schoolType：0-学校(默认) 1-机构
     * @param managerNames:       校管姓名集合（注意和校管电话一一对应）
     * @param managerPhones:      校管电话集合
     * @param effStart：生效时间
     * @param effEnd：失效时间
     */
    public void setSchoolManageUpdate(String schoolId, String schoolName, String province, String city, String area, String address, String des, String phaseId, String upperLimit, String schoolType, String managerNames, String managerPhones, String effStart, String effEnd) {
        this.schoolId = schoolId;
        this.schoolName = schoolName;
        this.province = province;
        this.city = city;
        this.area = area;
        this.address = address;
        this.des = des;
        this.phaseId = phaseId;
        this.upperLimit = upperLimit;
        this.schoolType = schoolType;
        this.managerNames = managerNames;
        this.managerPhones = managerPhones;
        this.effStart = effStart;
        this.effEnd = effEnd;

    }

    /**
     * 4.7.2 更新学校
     *
     * @param schoolId   学校id
     * @param schoolName 学校名称
     */
    public void setSchoolManageUpdate(String schoolId, String schoolName) {
        this.schoolId = schoolId;
        this.schoolName = schoolName;
//        province = "E";
//        city = "E";
//        area = "E";
//        effStart = "2019/09/17";
//        effEnd = "2020/09/16";
        managerNames = "";
        managerPhones = "";
    }


    /**
     * 4.7.3 删除学校
     *
     * @param schoolId: 学校ID
     */
    public void setSchoolManageDelete(String schoolId) {
        this.schoolId = schoolId;

    }


    /**
     * 4.8.1 用户班级列表
     *
     * @param className: 班级名称（模糊搜索）
     */
    public void setSchoolUsersClass(String className) {
        this.className = className;

    }

    /**
     * 4.8.2 用户学校列表
     *
     * @param schoolName: 学校名称（模糊）
     */
    public void setSchoolUsersSchools(String schoolName) {
        this.schoolName = schoolName;

    }

    /**
     * 4.8.3用户登录返回个人信息
     *
     * @param schoolId： 学校ID
     * @param classId：  班级ID
     * @param pageSize： 分页大小
     * @param pageNum:  页码
     */
    public void setSchoolUsersPageuser(String schoolId, String classId, String pageSize, String pageNum) {
        this.schoolId = schoolId;
        this.classId = classId;
        this.pageSize = pageSize;
        this.pageNum = pageNum;

    }

    /**
     * 4.8.4 新建用户
     *
     * @param *name：     用户姓名
     * @param *phone：    手机号码
     * @param schoolId：  学校ID
     * @param classId：   班级ID
     * @param subjectId： 学科ID（当classId不空时生效）
     */
    public void setSchoolUsersCreat(String name, String phone, String schoolId, String classId, String subjectId) {
        this.name = name;
        this.phone = phone;
        this.schoolId = schoolId;
        this.classId = classId;
        this.subjectId = subjectId;

    }

    /**
     * 4.8.5 学校用户信息
     *
     * @param roleName：权限名
     * @param year:           学年
     * @param schoolType：学校类型 0 教学；1机构
     */
    public void setSchoolUsersMineSchools(String roleName, String year, String schoolType) {
        this.roleName = roleName;
        this.year = year;
        this.schoolType = schoolType;
    }


    /**
     * 4.9.1根据学校ID获取年级列表
     *
     * @param *schoolId：学校ID
     */
    public void setSchoolGradeList(String schoolId) {
        this.schoolId = schoolId;

    }


    /**
     * 4.9.2根据年级获取班级列表
     *
     * @param *schoolId：学校ID
     * @param *gradeId：学年ID
     */
    public void setSchoolGradeClass(String schoolId, String gradeId) {
        this.schoolId = schoolId;
        this.gradeId = gradeId;

    }
}
