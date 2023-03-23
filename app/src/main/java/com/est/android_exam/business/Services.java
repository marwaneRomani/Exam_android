package com.est.android_exam.business;

import com.est.android_exam.models.User;

public interface Services {
    User signUp(String name, String phone, String email, String password, String confirmedPassword);
    User login(String email, String password);
}
