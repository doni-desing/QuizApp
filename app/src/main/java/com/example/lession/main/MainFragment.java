package com.example.lession.main;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.ViewModelProviders;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.lession.quiz.QuizActivity;
import com.example.lession1.R;

import org.angmarch.views.NiceSpinner;

public class MainFragment extends Fragment {

    private TextView textView;
    private TextView quistion;
    private TextView difficulty;
    private TextView category;
    private SeekBar seekBar;
    private Button button;
    private NiceSpinner niceSpinner;
    private NiceSpinner niceSpinner1;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.main_fragment, container, false);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        seekBar = getView().findViewById(R.id.seekBar);
        textView = getView().findViewById(R.id.view_seek);
        niceSpinner = getView().findViewById(R.id.spinner);
        niceSpinner1 = getView().findViewById(R.id.difficuly_spin);

        seekBar.setMax(50);
        seekBar.setMin(5);
        seekBar.setProgress(0);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textView.setText("" + progress + "");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                textView.setText("start");
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

            button = getView().findViewById(R.id.btn_onClick);
            quistion = getView().findViewById(R.id.question);
            difficulty = getView().findViewById(R.id.difficuly);
            category = getView().findViewById(R.id.categary);

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    QuizActivity.start(getContext(), seekBar.getProgress()
                    ,niceSpinner.getSelectedIndex(), niceSpinner1.getSelectedIndex());
                }
            });
        }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1){
            if (resultCode == Activity.RESULT_OK){

            }
        }
    }
}
