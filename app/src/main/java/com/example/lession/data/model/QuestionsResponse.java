package com.example.lession.data.model;

import com.example.lession.model.Quiztions;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class QuestionsResponse {
    @SerializedName("response_code")
    private int responseCode;

    private List<Quiztions> results;

    public QuestionsResponse(int responseCode, List<Quiztions> results) {
        this.responseCode = responseCode;
        this.results = results;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public List<Quiztions> getResults() {
        return results;
    }

    public void setResults(List<Quiztions> results) {
        this.results = results;
    }

}
