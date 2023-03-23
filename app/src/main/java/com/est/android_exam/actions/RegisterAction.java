package com.est.android_exam.actions;

import android.view.View;
import android.widget.Toast;

import com.est.android_exam.activities.RegisterActivity;
import com.est.android_exam.models.User;

public class RegisterAction implements View.OnClickListener {

    private RegisterActivity activity;

    public RegisterAction(RegisterActivity activity) {
        this.activity = activity;
    }

    @Override
    public void onClick(View view) {
        String name = activity.getName().getText().toString();
        String phone = activity.getPhone().getText().toString();
        String email = activity.getEmail().getText().toString();
        String password = activity.getPassword().getText().toString();
        String confirmedPass = activity.getConfirmedPassword().getText().toString();

        if (name.equals("") || phone.equals("") || email.equals("") || password.equals("") || confirmedPass.equals("") ) {
            Toast.makeText(activity, "all fields are required", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!password.equals(confirmedPass)) {
            Toast.makeText(activity, "password didn't match ", Toast.LENGTH_SHORT).show();
            return;
        }

        User user = activity.getServices().signUp(name, phone, email, password, confirmedPass);

        if (user == null)
            Toast.makeText(activity, "server error", Toast.LENGTH_SHORT).show();
        else {
            System.out.println(user.getName());
            Toast.makeText(activity, "hello", Toast.LENGTH_SHORT).show();
        }

    }
}
