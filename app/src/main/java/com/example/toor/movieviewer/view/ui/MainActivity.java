package com.example.toor.movieviewer.view.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.toor.movieviewer.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        this.showFragment(savedInstanceState);
    }

    private void showFragment(Bundle savedInstanceState){
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow();
        }
    }
}
