package com.devmasterteam.tasks.service.repository.remote;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private final static String BASE_URL = "https://www.devmasterteam.com/CursoAndroidAPI/";

    private static Retrofit instance;

    private RetrofitClient() {
    }

    private static Retrofit getInstance() {
        synchronized (RetrofitClient.class) {
            if (instance == null) {
                instance = new retrofit2.Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
            }
        }
        return instance;
    }

    public static <S> S createService(Class<S> sClass) {
        return getInstance().create(sClass);
    }

}
