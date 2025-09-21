package com.devmasterteam.tasks.service.repository.remote;

import com.devmasterteam.tasks.service.constants.TaskConstants;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private final static String BASE_URL = "https://www.devmasterteam.com/CursoAndroidAPI/";
    private static Retrofit instance;
    private static String tokenKey = "";
    private static String personKey = "";

    private RetrofitClient() {
    }

    private static Retrofit getInstance() {

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request()
                        .newBuilder()
                        .addHeader(TaskConstants.SHARED.TOKEN_KEY, tokenKey)
                        .addHeader(TaskConstants.SHARED.PERSON_KEY, personKey)
                        .build();
                return chain.proceed(request);
            }
        });

        synchronized (RetrofitClient.class) {
            if (instance == null) {
                instance = new retrofit2.Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .client(httpClient.build())
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
            }
        }
        return instance;
    }

    public static <S> S createService(Class<S> sClass) {
        return getInstance().create(sClass);
    }

    public static void saveHeaders(String token, String person) {
        tokenKey = token;
        personKey = person;
    }
}
