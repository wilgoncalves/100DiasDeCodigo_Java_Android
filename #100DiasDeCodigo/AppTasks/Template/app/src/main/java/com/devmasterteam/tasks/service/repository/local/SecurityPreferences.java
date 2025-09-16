package com.devmasterteam.tasks.service.repository.local;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * SharedPreferences
 */
public class SecurityPreferences {

    private SharedPreferences sharedPreferences;
    public SecurityPreferences(Context context) {
        this.sharedPreferences = context.getSharedPreferences("TasksShared", Context.MODE_PRIVATE);
    }

    public void storeString(String key, String value) {
        this.sharedPreferences.edit().putString(key, value).apply();
    }

    public String getStoredString(String key) {
        return this.sharedPreferences.getString(key, "");
    }

    public void remove(String key) {
        this.sharedPreferences.edit().remove(key).apply();
    }
}