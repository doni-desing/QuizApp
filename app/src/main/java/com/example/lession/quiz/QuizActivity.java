package com.example.lession.quiz;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.lession.quiz.ui.quiz.QuizFragment;

public class QuizActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, QuizFragment.newInstance())
                .commitNow();
        }
    }
}
