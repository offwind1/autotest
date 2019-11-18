package com.mizholdings.kacha.user;

import com.mizholdings.util.Env;

public class KCTeacher extends KCUserBase {

    public KCTeacher(String account, String password) {
        super(Env.Kacha.TEACHER, account, password);
    }




}
