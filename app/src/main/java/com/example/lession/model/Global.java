package com.example.lession.model;

import com.google.gson.annotations.SerializedName;

public class Global {
    String total_num_of_questions;
    String total_num_of_pending_questions;
    String total_num_of_verified_questions;
    String total_num_of_rejected_questions;

    public Global(String total_num_of_questions, String total_num_of_pending_questions, String total_num_of_verified_questions, String total_num_of_rejected_questions) {
        this.total_num_of_questions = total_num_of_questions;
        this.total_num_of_pending_questions = total_num_of_pending_questions;
        this.total_num_of_verified_questions = total_num_of_verified_questions;
        this.total_num_of_rejected_questions = total_num_of_rejected_questions;
    }

    public String getTotal_num_of_questions() {
        return total_num_of_questions;
    }

    public void setTotal_num_of_questions(String total_num_of_questions) {
        this.total_num_of_questions = total_num_of_questions;
    }

    public String getTotal_num_of_pending_questions() {
        return total_num_of_pending_questions;
    }

    public void setTotal_num_of_pending_questions(String total_num_of_pending_questions) {
        this.total_num_of_pending_questions = total_num_of_pending_questions;
    }

    public String getTotal_num_of_verified_questions() {
        return total_num_of_verified_questions;
    }

    public void setTotal_num_of_verified_questions(String total_num_of_verified_questions) {
        this.total_num_of_verified_questions = total_num_of_verified_questions;
    }

    public String getTotal_num_of_rejected_questions() {
        return total_num_of_rejected_questions;
    }

    public void setTotal_num_of_rejected_questions(String total_num_of_rejected_questions) {
        this.total_num_of_rejected_questions = total_num_of_rejected_questions;
    }
}
