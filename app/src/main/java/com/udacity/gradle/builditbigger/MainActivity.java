package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.nverno.jokeactivity.JokeActivity;
import com.udacity.gradle.builditbigger.util.GetJokeClickHandler;

public class MainActivity extends AppCompatActivity implements GetJokeClickHandler {
    private static final String JOKE_STRING = "JOKE_STRING";

    Button mButtonTellJoke;
    ProgressBar mLoadingIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButtonTellJoke = findViewById(R.id.button_tell_joke);
        mLoadingIndicator = findViewById(R.id.progress_bar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {
        showLoadingIndicator();
        new JokeEndpointAsyncTask().execute(this);
    }

    public void onResult(String result) {
        final Intent intent = new Intent(this, JokeActivity.class);
        intent.putExtra(JOKE_STRING, result);
        hideLoadingIndicator();
        startActivity(intent);
    }

    private void showLoadingIndicator() {
        if (mButtonTellJoke.getVisibility() == View.VISIBLE) {
            mButtonTellJoke.setVisibility(View.INVISIBLE);
        }
        if (mLoadingIndicator.getVisibility() == View.INVISIBLE) {
            mLoadingIndicator.setVisibility(View.VISIBLE);
        }
    }

    private void hideLoadingIndicator() {
        if (mLoadingIndicator.getVisibility() == View.VISIBLE) {
            mLoadingIndicator.setVisibility(View.INVISIBLE);
        }
        if (mButtonTellJoke.getVisibility() == View.INVISIBLE) {
            mButtonTellJoke.setVisibility(View.VISIBLE);
        }
    }
}
