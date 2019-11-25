package com.example.lession.data;

import com.example.lession.model.Category;
import com.example.lession.model.Global;
import com.example.lession.model.Quiztions;

import java.util.List;

public interface IQuizRepository {
    void getQuiz(Integer amount, Integer category, String difficulty, OnQuizCallback callback);

    interface OnQuizCallback {
        void onSuccess(List<Quiztions> questions);

        void onFailure(Exception e);

    }
    interface OnCategoryCallBack{
        void getCategory(List<Category> categories);
    }

    interface OnGlobal{
        void getGlobal(List<Global> globals);
    }

}
