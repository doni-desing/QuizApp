package com.example.lession.quiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.lession.model.Quiztions;
import com.example.lession.quiz.recyclerView.QuizAdapter;
import com.example.lession1.R;

import java.util.ArrayList;
import java.util.List;

public class QuizActivity extends AppCompatActivity implements QuizAdapter.QuizViewHolder.Listener {

    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private QuizAdapter mAdapter;
    private Button button;
    TextView name;
    private List<Quiztions> mQuestions;

    QuizViewModel mViewModel;


    public static void start(Context context, int seekBarProgress, int niceSpinner1, String niceSpinner2) {

        Intent ruturnIntent = new Intent(context, QuizActivity.class);
        ruturnIntent.putExtra("quiestion", niceSpinner1);
        ruturnIntent.putExtra("category", niceSpinner2);
        ruturnIntent.putExtra("difficulty", seekBarProgress);
        context.startActivity(ruturnIntent);
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_activity);

        progressBar = findViewById(R.id.progress_quiz);
        recyclerView = findViewById(R.id.recycler_view_quiz);
        button = findViewById(R.id.btn_skip);
        name = findViewById(R.id.bar1);

        mViewModel = ViewModelProviders.of(this).get(QuizViewModel.class);

        int amount = getIntent().getIntExtra("quiestion", 5);
        int category = getIntent().getIntExtra("category", 0);
        String difficulty = getIntent().getStringExtra("difficulty");

        mViewModel.init(amount, category, difficulty);
        initRecycler();
        initViewModel();
        buttonQuizSkip();
    }

    private void initViewModel() {
        mViewModel.questions.observe(this, new Observer<List<Quiztions>>() {
            @Override
            public void onChanged(List<Quiztions> quiztions) {
                Log.d("ololo", "onChanged: " + quiztions.size());
                mAdapter.setQuestions(quiztions);
            }
        });

        mViewModel.currentQuestionPosition.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer position) {
                recyclerView.smoothScrollToPosition(position);
                progressBar.setProgress(position + 1);

            }
        });
    }

    @SuppressLint("ClickableViewAccessibility")
    private void initRecycler() {
        mAdapter = new QuizAdapter(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        recyclerView.setAdapter(mAdapter);
        progressBar.setMax(10);
        recyclerView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });
    }

    private void buttonQuizSkip() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewModel.onSkipClick();
            }
        });
    }

    @Override
    public void onAnswerClick(int questionPosition, int answerPosition) {
        mViewModel.onAnswerClick(questionPosition, answerPosition);
    }

    public void onClickBack(View view) {
        mViewModel.back();
    }
}

