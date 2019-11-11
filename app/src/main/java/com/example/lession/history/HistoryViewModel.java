package com.example.lession.history;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HistoryViewModel extends ViewModel {
    private MutableLiveData<String > liveData ;

    public LiveData<String > getUsers(){
        if (liveData == null){
            liveData = new MutableLiveData<>();
        }
        return liveData;
    }
}
