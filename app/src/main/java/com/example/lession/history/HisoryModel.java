package com.example.lession.history;

public class HisoryModel {
    String category,answer,Difficulty;

    public HisoryModel(String category, String answer, String difficulty) {
        this.category = category;
        this.answer = answer;
        Difficulty = difficulty;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getDifficulty() {
        return Difficulty;
    }

    public void setDifficulty(String difficulty) {
        Difficulty = difficulty;
    }
}
