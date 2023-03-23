package com.est.android_exam.dao;

import com.est.android_exam.models.User;

import java.util.ArrayList;
import java.util.List;

public class UserDaoMem implements UserDao {
    private List<User> users = new ArrayList<>();

    @Override
    public User signUp(String name, String phone, String email, String password, String confirmedPassword) {
        if (name.equals("") || phone.equals("") || email.equals("") || password.equals("") || confirmedPassword.equals("") )
            return null;

        if (!password.equals(confirmedPassword))
            return null;

        User user = new User(name, phone, email, password);

        users.add(user);

        return user;
    }

    @Override
    public User login(String email, String password) {

        for (User user : users)
            if(user.getEmail().equals(email) && user.getPassword().equals(password))
                return user;

        return null;
    }
}
