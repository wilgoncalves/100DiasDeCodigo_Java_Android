package com.devmasterteam.tasks.service.repository;

import android.content.Context;

import com.devmasterteam.tasks.R;
import com.google.gson.Gson;

import okhttp3.ResponseBody;

public class BaseRepository {

    Context context;

    public BaseRepository(Context context) {
        this.context = context;
    }

    public String handleFailure(ResponseBody response) {
        try {
            return new Gson().fromJson(response.string(), String.class);
        } catch (Exception e) {
            return context.getString(R.string.error_unexpected);
        }
    }
}
