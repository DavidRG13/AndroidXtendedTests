package com.androidxtended.app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.calculateButton).setOnClickListener(this);
    }

    @Override
    public void onClick(final View view) {
        if (view.getId() == R.id.calculateButton) {
            int number1 = Integer.parseInt(((EditText) findViewById(R.id.numero1)).getText().toString());
            int number2 = Integer.parseInt(((EditText) findViewById(R.id.numero2)).getText().toString());

            ((TextView) findViewById(R.id.result)).setText(String.valueOf(number1 + number2));
        }
    }
}
