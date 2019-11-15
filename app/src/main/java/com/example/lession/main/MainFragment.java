package com.example.lession.main;

import androidx.annotation.RequiresApi;

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

       View view = LayoutInflater.from(getContext()).inflate(R.layout.main_fragment,container, false);
        seekBar = view.findViewById(R.id.seekBar);
        textView = view.findViewById(R.id.view_seek);
        niceSpinner = view.findViewById(R.id.niceSpinner);
        niceSpinner1 = view.findViewById(R.id.difficuly_spin);

        return view;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekBar.setMax(50);
                seekBar.setMin(5);
                seekBar.setProgress(0);

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
}
