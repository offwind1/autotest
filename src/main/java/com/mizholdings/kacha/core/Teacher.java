package com.mizholdings.kacha.core;

import com.mizholdings.util.Env;

public class Teacher extends User {

    public Teacher(String account, String password) {
        super(Env.Kacha.TEACHER, account, password);
    }

}
