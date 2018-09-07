package com.rajsuvariya.joketeller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;

public class JokeTellerActivity extends AppCompatActivity {

    public static final String JOKE_KEY = "_Joke_Key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_teller);

        TextView tvJoke = findViewById(R.id.tv_joke);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String joke = null;
        if (extras != null && extras.containsKey(JOKE_KEY)) {
            joke = extras.getString(JOKE_KEY);
        }
        if (TextUtils.isEmpty(joke)) {
            tvJoke.setText(R.string.no_joke_error);
        } else {
            tvJoke.setText(joke);
        }
    }
}
