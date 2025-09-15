package com.devmasterteam.tasks.service.listener;

public class Feedback {
    private boolean success = true;
    private String message = "";

    public Feedback() {}

    public Feedback(String str) {
        this.message = str;
        success = false;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public String getMessage() {
        return this.message;
    }
}
