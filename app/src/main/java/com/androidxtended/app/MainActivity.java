package com.androidxtended.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String USER_EXTRA = "userName";

    private FakeThirdPartyService fakeThirdPartyService;
    private String userName;
    private String result = "";
    private boolean resultWritten = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView userNameTextView = (TextView) findViewById(R.id.userName);
        userName = getIntent().getStringExtra(USER_EXTRA);
        userNameTextView.setText(this.userName);

        findViewById(R.id.sendOpinionButton).setOnClickListener(this);

        fakeThirdPartyService = new FakeThirdPartyService();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (resultWritten) {
            getMenuInflater().inflate(R.menu.menu_main, menu);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //noinspection SimplifiableIfStatement
        if (item.getItemId() == R.id.action_settings) {
            shareOpinion();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(final View view) {
        if (view.getId() == R.id.sendOpinionButton) {
            String opinion = ((EditText) findViewById(R.id.opinion)).getText().toString();

            result = fakeThirdPartyService.buildOpinion(userName, opinion);
            TextView resultTextView = (TextView) findViewById(R.id.result);
            resultTextView.setText(result);
            resultTextView.setVisibility(View.VISIBLE);
            resultWritten = true;
            invalidateOptionsMenu();
        }
    }

    private void shareOpinion() {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, result);
        sendIntent.setType("text/plain");
        startActivity(sendIntent);
    }
}
