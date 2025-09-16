package com.devmasterteam.tasks.service.model;

import androidx.room.Entity;

import com.google.gson.annotations.SerializedName;

public class PriorityModel {

    @SerializedName("Id")
    private int id;

    @SerializedName("Description")
    private String description;
}
