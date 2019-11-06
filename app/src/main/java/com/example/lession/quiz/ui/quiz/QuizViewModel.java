package com.example.lession.quiz.ui.quiz;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class QuizViewModel extends ViewModel {
    private MutableLiveData<String > liveData;

    public LiveData<String > getUsers(){
        if (liveData == null){
            liveData = new MutableLiveData<>();
            loadUsers();
        }
        return liveData;
    }

    private void loadUsers() {

    }
}
