package com.example.lession.model;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Quiztions {
    String category;
    String question;
    String difficulty;
    String type;

    @SerializedName("correct_answer")
    private String correctAnswer;

    @SerializedName("incorrect_answers")
    private List<String> incorrectAnswers;

    public Quiztions(String category, String quiestion, String difficulty, String typeString ,String correctAnswer, List<String> incorrectAnswers) {
        this.category = category;
        this.question = quiestion;
        this.difficulty = difficulty;
        this.type = type;
        this.correctAnswer = correctAnswer;
        this.incorrectAnswers = incorrectAnswers;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public List<String> getIncorrectAnswers() {
        return incorrectAnswers;
    }

    public void setIncorrectAnswers(List<String> incorrectAnswers) {
        this.incorrectAnswers = incorrectAnswers;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getQuiestion() {
        return question;
    }

    public void setQuiestion(String quiestion) {
        this.question = quiestion;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    @NonNull
    @Override
    public String toString() {
        return category + " " + question + " " + type + " " + difficulty;
    }
}
