package com.est.android_exam.business;


import com.est.android_exam.dao.UserDaoMem;
import com.est.android_exam.models.User;

public class DefaultService implements Services {

    private UserDaoMem userDao;

    public DefaultService(UserDaoMem userDao) {
        this.userDao = userDao;
    }

    @Override
    public User signUp(String name, String phone, String email, String password, String confirmedPassword) {

        if (name.equals("") || phone.equals("") || email.equals("") || password.equals("") || confirmedPassword.equals("") )
            return null;

        if (!password.equals(confirmedPassword))
            return null;


        User user = userDao.signUp(name, phone, email, password, confirmedPassword);

        return user;
    }

    @Override
    public User login(String email, String password) {
        if (email.equals("") || password.equals(""))
            return null;

        User user = userDao.login(email, password);

        if (user == null)
            return null;

        if (user.getPassword().equals(password))
            return user;

        return null;
    }
}
