package com.devmasterteam.tasks.service.repository;

import android.content.Context;

import com.devmasterteam.tasks.R;
import com.devmasterteam.tasks.service.constants.TaskConstants;
import com.devmasterteam.tasks.service.listener.APIListener;
import com.devmasterteam.tasks.service.model.PersonModel;
import com.devmasterteam.tasks.service.repository.local.SecurityPreferences;
import com.devmasterteam.tasks.service.repository.remote.PersonService;
import com.devmasterteam.tasks.service.repository.remote.RetrofitClient;
import com.google.gson.Gson;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PersonRepository extends BaseRepository {

    private PersonService personService;
    private SecurityPreferences securityPreferences;

    public PersonRepository(Context context) {
        super(context);
        this.personService = RetrofitClient.createService(PersonService.class);
        this.securityPreferences = new SecurityPreferences(context);
        this.context = context;
    }

    private void call(Call<PersonModel> call, APIListener<PersonModel> listener) {
        call.enqueue(new Callback<PersonModel>() {
            @Override
            public void onResponse(Call<PersonModel> call, Response<PersonModel> response) {
                if (response.code() == TaskConstants.HTTP.SUCCESS) {
                    listener.onSuccess(response.body());
                } else {
                    listener.onFailure(handleFailure(response.errorBody()));
                }
            }

            @Override
            public void onFailure(Call<PersonModel> call, Throwable t) {
                listener.onFailure(context.getString(R.string.error_unexpected));
            }
        });
    }

    public void create(String name, String email, String password, final APIListener<PersonModel> listener){

        if (!super.isConnectionAvailable()) {
            listener.onFailure(context.getString(R.string.error_internet_connection));
            return;
        }

        Call<PersonModel> call = this.personService.create(name, email, password, true);
        call(call, listener);
    }

    public void login(String email, String password, final APIListener<PersonModel> listener) {

        if (!super.isConnectionAvailable()) {
            listener.onFailure(context.getString(R.string.error_internet_connection));
            return;
        }

        Call<PersonModel> call = this.personService.login(email, password);
        call(call, listener);
    }

    public void saveUserData(PersonModel model) {
        this.securityPreferences.storeString(TaskConstants.SHARED.TOKEN_KEY, model.getToken());
        this.securityPreferences.storeString(TaskConstants.SHARED.PERSON_KEY, model.getPersonKey());
        this.securityPreferences.storeString(TaskConstants.SHARED.PERSON_NAME, model.getName());
        this.securityPreferences.storeString(TaskConstants.SHARED.PERSON_EMAIL, model.getEmail());

        RetrofitClient.saveHeaders(model.getToken(), model.getPersonKey());
    }

    public void clearUserData() {
        this.securityPreferences.remove(TaskConstants.SHARED.TOKEN_KEY);
        this.securityPreferences.remove(TaskConstants.SHARED.PERSON_KEY);
        this.securityPreferences.remove(TaskConstants.SHARED.PERSON_NAME);
    }

    public PersonModel getUserData() {
        PersonModel model = new PersonModel();
        model.setName(this.securityPreferences.getStoredString(TaskConstants.SHARED.PERSON_NAME));
        model.setToken(this.securityPreferences.getStoredString(TaskConstants.SHARED.TOKEN_KEY));
        model.setPersonKey(this.securityPreferences.getStoredString(TaskConstants.SHARED.PERSON_KEY));
        model.setEmail(this.securityPreferences.getStoredString(TaskConstants.SHARED.PERSON_EMAIL));

        return model;
    }
}
