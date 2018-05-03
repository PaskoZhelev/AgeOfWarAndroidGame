package com.pmz.ageofwar.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.pmz.ageofwar.R;

import org.androidannotations.annotations.EActivity;

@EActivity
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hideNavigationBar();
        setupButtons();
    }

    @Override
    protected void onResume() {
        super.onResume();
        hideNavigationBar();
    }

    private void hideNavigationBar() {
        this.getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
    }

    private void setupButtons(){

//        playButton =  findViewById(R.id.playBtn);
//        rulesButton =  findViewById(R.id.rulesBtn);
//
//        playButton.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View arg0) {
//
//                Intent myIntent = new Intent(MainActivity.this,
//                        SoloGameActivity.class);
//                startActivity(myIntent);
//            }
//        });
//
//
//
//        rulesButton.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View arg0) {
//
//                Intent myIntent = new Intent(MainActivity.this,
//                        RulesActivity.class);
//                startActivity(myIntent);
//            }
//        });
    }
}
