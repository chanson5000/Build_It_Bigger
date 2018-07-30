package com.nverno.jokeactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {

    private static final String JOKE_STRING = "JOKE_STRING";
    TextView mTextViewJokeString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.joke_activity);
        mTextViewJokeString = findViewById(R.id.text_joke_string);

        Intent parentIntent = getIntent();
        if (parentIntent != null && parentIntent.hasExtra(JOKE_STRING)) {

            Bundle bundle = parentIntent.getExtras();
            if (bundle != null) {
                mTextViewJokeString.setText(bundle.getString(JOKE_STRING));
            }
        } else {
            mTextViewJokeString.setText("No joke!");
        }

    }

}