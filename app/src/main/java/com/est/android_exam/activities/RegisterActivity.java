package com.est.android_exam.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.est.android_exam.R;
import com.est.android_exam.actions.RegisterAction;
import com.est.android_exam.business.Services;
import com.est.android_exam.context.MyContext;

public class RegisterActivity extends AppCompatActivity {

    private Services services;
    private EditText name;
    private EditText phone;
    private EditText email;
    private EditText password;
    private EditText confirmedPassword;
    private TextView loginLink;
    private Button signUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        MyContext applicationContext = (MyContext) getApplicationContext();
        services = applicationContext.getServices();

        name = findViewById(R.id.name);
        phone = findViewById(R.id.phone);
        email = findViewById(R.id.remail);

        password = findViewById(R.id.registerPassword);
        confirmedPassword = findViewById(R.id.confirmPassword);

        loginLink = findViewById(R.id.loginpage);

        signUp = findViewById(R.id.signup);

        RegisterAction registerAction = new RegisterAction(this);

        signUp.setOnClickListener(registerAction);

        loginLink.setOnClickListener(c -> {
            Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });

    }

    public Services getServices() {
        return services;
    }

    public void setServices(Services services) {
        this.services = services;
    }

    public EditText getName() {
        return name;
    }

    public void setName(EditText name) {
        this.name = name;
    }

    public EditText getPhone() {
        return phone;
    }

    public void setPhone(EditText phone) {
        this.phone = phone;
    }

    public EditText getEmail() {
        return email;
    }

    public void setEmail(EditText email) {
        this.email = email;
    }

    public EditText getPassword() {
        return password;
    }

    public void setPassword(EditText password) {
        this.password = password;
    }

    public EditText getConfirmedPassword() {
        return confirmedPassword;
    }

    public void setConfirmedPassword(EditText confirmedPassword) {
        this.confirmedPassword = confirmedPassword;
    }

    public TextView getLoginLink() {
        return loginLink;
    }

    public void setLoginLink(TextView loginLink) {
        this.loginLink = loginLink;
    }

    public Button getSignUp() {
        return signUp;
    }

    public void setSignUp(Button signUp) {
        this.signUp = signUp;
    }
}