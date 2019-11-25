package com.example.lession.data;

import com.example.lession.data.model.CategoryRepository;
import com.example.lession.data.model.GlobalRepository;
import com.example.lession.data.model.QuestionsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TriviaNetworkClient {
   @GET("/api.php")
    Call<QuestionsResponse> getQuisetions(
           @Query("amount") Integer amount,
           @Query("category") Integer category,
           @Query("difficulty") String difficulty
   );

   @GET("/api_count_global.php")
    Call<GlobalRepository> getGlobal();

   @GET("/api_category.php")
    Call<CategoryRepository> getCategory();
}
