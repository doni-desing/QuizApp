package com.example.lession.data;

import android.util.Log;

import com.example.lession.data.model.CategoryRepository;
import com.example.lession.data.model.GlobalRepository;
import com.example.lession.data.model.QuestionsResponse;
import com.example.lession.model.Category;
import com.example.lession.model.Global;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class QuizRepository implements IQuizRepository, IQuizRepository.OnCategoryCallBack, IQuizRepository.OnGlobal {

    private Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://opentdb.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build();


    private TriviaNetworkClient triviaNetworkClient = retrofit.create(TriviaNetworkClient.class);

    @Override
    public void getQuiz(Integer amount, Integer category, String difficulty, final OnQuizCallback callback) {
        Call<QuestionsResponse> call = triviaNetworkClient.getQuisetions(
                amount, category, null

        );
        call.enqueue(new Callback<QuestionsResponse>() {
            @Override
            public void onResponse(Call<QuestionsResponse> call, Response<QuestionsResponse> response) {

                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        callback.onSuccess(response.body().getResults());

                    } else {
                        callback.onFailure(new Exception("Remote data source not initialized"));
                    }
                } else {
                    callback.onFailure(new Exception("Request failed: " + response.code()));
                }
            }

            @Override
            public void onFailure(Call<QuestionsResponse> call, Throwable t) {
                callback.onFailure(new Exception(t));

            }
        });
    }


    @Override
    public void getCategory(List<Category> categories) {
        Call<CategoryRepository> call = triviaNetworkClient.getCategory();
        call.enqueue(new Callback<CategoryRepository>() {
            @Override
            public void onResponse(Call<CategoryRepository> call, Response<CategoryRepository> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        Log.d("lolo", "onResponse: ");
                    }
                }
            }

            @Override
            public void onFailure(Call<CategoryRepository> call, Throwable t) {
                Log.d("kkkk", "onFailure: " + t.getMessage());
            }
        });
    }

    @Override
    public void getGlobal(List<Global> globals) {
        Call<GlobalRepository> call = triviaNetworkClient.getGlobal();
        call.enqueue(new Callback<GlobalRepository>() {
            @Override
            public void onResponse(Call<GlobalRepository> call, Response<GlobalRepository> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        Log.d("lolo", response.body().getGlobals().get("9").getTotal_num_of_questions());
                    }
                }
            }

            @Override
            public void onFailure(Call<GlobalRepository> call, Throwable t) {
                Log.d("kkkk", "onFailure: " + t.getMessage());
            }
        });
    }
}
