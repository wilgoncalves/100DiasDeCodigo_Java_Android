package com.devmasterteam.tasks.service.repository;

import android.content.Context;

import com.devmasterteam.tasks.R;
import com.devmasterteam.tasks.service.constants.TaskConstants;
import com.devmasterteam.tasks.service.listener.APIListener;
import com.devmasterteam.tasks.service.model.PersonModel;
import com.devmasterteam.tasks.service.repository.remote.PersonService;
import com.devmasterteam.tasks.service.repository.remote.RetrofitClient;
import com.google.gson.Gson;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PersonRepository {

    private PersonService personService;
    private Context context;

    public PersonRepository(Context context) {
        this.personService = RetrofitClient.createService(PersonService.class);
        this.context = context;
    }

    public void create(String name, String email, String password){
        Call<PersonModel> call = this.personService.create(name, email, password, true);
        call.enqueue(new Callback<PersonModel>() {
            @Override
            public void onResponse(Call<PersonModel> call, Response<PersonModel> response) {
                PersonModel personModel = response.body();
                int code = response.code();
                String s = "";
            }

            @Override
            public void onFailure(Call<PersonModel> call, Throwable t) {
                String s = "";
            }
        });
    }

    public void login(String email, String password, final APIListener<PersonModel> listener) {
        Call<PersonModel> call = this.personService.login(email, password);
        call.enqueue(new Callback<PersonModel>() {
            @Override
            public void onResponse(Call<PersonModel> call, Response<PersonModel> response) {
                if (response.code() == TaskConstants.HTTP.SUCCESS) {
                    listener.onSuccess(response.body());
                } else {
                    try {
                        String json = response.errorBody().string();
                        String str = new Gson().fromJson(json, String.class);
                        listener.onFailure(str);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<PersonModel> call, Throwable t) {
                listener.onFailure(context.getString(R.string.error_unexpected));
            }
        });
    }
}
