package com.est.android_exam.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.est.android_exam.R;
import com.est.android_exam.actions.AuthAction;
import com.est.android_exam.business.Services;
import com.est.android_exam.context.MyContext;

public class MainActivity extends AppCompatActivity {
    private Services services;
    private EditText email;
    private EditText password;

    private TextView signUpLink;


    private Button login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyContext applicationContext = (MyContext) getApplicationContext();

        services = applicationContext.getServices();

        /** email and password */
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);
        signUpLink = findViewById(R.id.signUpLink);

        AuthAction authAction = new AuthAction(this);

        login.setOnClickListener(authAction);

        signUpLink.setOnClickListener(c -> {
            Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
            startActivity(intent);
        });
    }

    public Services getServices() {
        return services;
    }

    public void setServices(Services services) {
        this.services = services;
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

    public Button getLogin() {
        return login;
    }

    public void setLogin(Button login) {
        this.login = login;
    }

}
