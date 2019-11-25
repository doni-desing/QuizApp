package com.example.lession;

import android.app.Application;

import com.example.lession.data.IQuizRepository;
import com.example.lession.data.QuizRepository;

public class App extends Application {

    public static IQuizRepository quizRepository;

    @Override
    public void onCreate() {
        super.onCreate();
        quizRepository = new QuizRepository();
    }

}

