package com.est.android_exam.actions;


import android.view.View;
import android.widget.Toast;

import com.est.android_exam.activities.MainActivity;
import com.est.android_exam.models.User;

public class AuthAction implements View.OnClickListener {

    private MainActivity activity;

    public AuthAction(MainActivity activity) {
        this.activity = activity;
    }

    @Override
    public void onClick(View view) {
        String email = activity.getEmail().getText().toString();
        String password = activity.getPassword().getText().toString();

        if (email.equals("") || password.equals("")) {
            Toast.makeText(activity, "all fields are required", Toast.LENGTH_SHORT).show();
            return;
        }

        User user = activity.getServices().login(email, password);

        if (user == null)
            Toast.makeText(activity, "user not found, please sign up", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(activity, "hello"  + user.getName() , Toast.LENGTH_SHORT).show();

    }
}
