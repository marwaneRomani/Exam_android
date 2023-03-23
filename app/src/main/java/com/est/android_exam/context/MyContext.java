package com.est.android_exam.context;

import android.app.Application;

import com.est.android_exam.business.DefaultService;
import com.est.android_exam.business.Services;
import com.est.android_exam.dao.UserDaoMem;

public class MyContext extends Application {

    private Services services;

    @Override
    public void onCreate() {
        super.onCreate();
        services = new DefaultService(new UserDaoMem());
    }


    public Services getServices() {
        return services;
    }
}
