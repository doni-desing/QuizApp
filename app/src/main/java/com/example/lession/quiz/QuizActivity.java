package com.example.lession.quiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.lession1.R;

public class QuizActivity extends AppCompatActivity {

    private RecyclerView recyclerView;


    public static void start(Context context, int seekBarProgress, int niceSpinner1, int niceSpinner2){

        Intent ruturnIntent = new Intent(context, QuizActivity.class);
        ruturnIntent.putExtra("quiestion", niceSpinner1);
        ruturnIntent.putExtra("category", niceSpinner2);
        ruturnIntent.putExtra("difficulty", seekBarProgress);
        context.startActivity(ruturnIntent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_activity);
        recyclerView = findViewById(R.id.recycler_view);

        getIntent().getStringExtra("quiestion");

        QuizViewModel quizViewModel = ViewModelProviders.of(this).get(QuizViewModel.class);
        quizViewModel.getUsers().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {

            }
        });
        }
    }
