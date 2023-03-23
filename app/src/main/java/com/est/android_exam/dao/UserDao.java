package com.est.android_exam.dao;

import com.est.android_exam.models.User;

public interface UserDao {

    User signUp(String name, String phone, String email, String password, String confirmedPassword);
    User login(String email, String password);

}
