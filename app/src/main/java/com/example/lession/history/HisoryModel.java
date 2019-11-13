package com.example.lession.history;

public class HisoryModel {
    String category,answer,Difficulty;
    int data;

    public HisoryModel(String category, String answer, String difficulty, int data) {
        this.category = category;
        this.answer = answer;
        Difficulty = difficulty;
        this.data = data;
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
