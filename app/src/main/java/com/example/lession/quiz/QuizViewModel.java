package com.example.lession.quiz;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.lession.App;
import com.example.lession.data.IQuizRepository;
import com.example.lession.data.core.SingleLiveEvent;
import com.example.lession.main.MainFragment;
import com.example.lession.model.Quiztions;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class QuizViewModel extends ViewModel {

    private IQuizRepository quizRepository = App.quizRepository;

    MutableLiveData<List<Quiztions>> questions = new MutableLiveData<>();
    MutableLiveData<Integer> currentQuestionPosition = new MutableLiveData<>();

    SingleLiveEvent<Void> finishEvent = new SingleLiveEvent<>();
    SingleLiveEvent<Integer> openResultEvent = new SingleLiveEvent<>();

    public void init(Integer amount, Integer categoryId, String difficulty) {
        currentQuestionPosition.setValue(0);

        App.quizRepository.getQuiz(amount, categoryId, difficulty, new IQuizRepository.OnQuizCallback() {
            @Override
            public void onSuccess(List<Quiztions> mQuestions) {
                if (mQuestions.size() != 0){
                    questions.setValue(mQuestions);
                }
            }

            @Override
            public void onFailure(Exception e) {

            }
        });
    }


    void onAnswerClick(int questionPosition, int answerPosition) {

        //TODO: Add answer position field to Question model and update on answer selected
    }

    public void back(){

        Integer position = currentQuestionPosition.getValue();
        if (currentQuestionPosition!= null){
            currentQuestionPosition.setValue(position - 1);
        } else {
        }
    }



    public void onSkipClick() {
        Integer currentPosition = currentQuestionPosition.getValue();
        if (currentPosition != null) {
            if (currentPosition == Objects.requireNonNull(questions.getValue()).size() - 1) {
                //TODO: Calculate result
                finishEvent.call();
            } else {
                currentQuestionPosition.setValue(currentPosition + 1);
            }
        }

    }

}
