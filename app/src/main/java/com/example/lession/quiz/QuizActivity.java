package com.example.lession.quiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.lession1.R;

public class QuizActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_activity);

        recyclerView = findViewById(R.id.recycler_view);

//        Intent ruturnIntent = getIntent();
//        ruturnIntent.getStringExtra("quiestion");
//        ruturnIntent.getStringExtra("category");
//        ruturnIntent.getStringExtra("difficulty");
//        setResult(RESULT_OK, ruturnIntent);
//        finish();

        QuizViewModel quizViewModel = ViewModelProviders.of(this).get(QuizViewModel.class);
        quizViewModel.getUsers().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {

            }
        });
        }
    }
