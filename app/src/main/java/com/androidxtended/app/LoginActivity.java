package com.androidxtended.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        findViewById(R.id.loginButton).setOnClickListener(this);
    }

    @Override
    public void onClick(final View view) {
        if (view.getId() == R.id.loginButton) {
            EditText userNameInput = (EditText) findViewById(R.id.userName);
            String userName = userNameInput.getText().toString();
            if (userName.isEmpty()) {
                findViewById(R.id.userNameInvalid).setVisibility(View.VISIBLE);
            } else {
                Intent intent = new Intent(this, MainActivity.class);
                intent.putExtra(MainActivity.USER_EXTRA, userName);
                startActivity(intent);
            }
        }
    }
}
