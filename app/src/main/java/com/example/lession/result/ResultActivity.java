package com.example.lession.result;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import com.example.lession1.R;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        ResultViewModel resultViewModel = ViewModelProviders.of(this).get(ResultViewModel.class);
        resultViewModel.getUsers().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {

            }
        });
    }
}
