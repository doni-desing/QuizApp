package com.example.lession;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.lession.quiz.QuizActivity;
import com.example.lession1.R;
import com.mrgames13.jimdo.splashscreen.App.SplashScreenBuilder;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        SplashScreenBuilder.Companion.getInstance(this)
                .setImage(R.drawable.image)
                .show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == SplashScreenBuilder.Companion.getSPLASH_SCREEN_FINISHED()) {
            if(resultCode == RESULT_OK) {
                //SplashScreen finished without manual canceling
            } else if(resultCode == RESULT_CANCELED) {
                //SplashScreen finished through manual canceling
            }
        }
    }
}
