package com.example.lession;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    MutableLiveData<String> title = new MutableLiveData<>();
    public void init(){
        title.setValue("MAin Activity value");
        Log.d("ololo", "init: ");
    }
    public void changeTitle(){
        title.setValue("NEw title");
    }
    // TODO: Implement the ViewModel

    @Override
    protected void onCleared() {
        super.onCleared();
    }
}
