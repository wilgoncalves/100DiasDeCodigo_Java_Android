package com.devmasterteam.tasks.service.repository;

import com.devmasterteam.tasks.service.model.PersonModel;
import com.devmasterteam.tasks.service.repository.remote.PersonService;
import com.devmasterteam.tasks.service.repository.remote.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PersonRepository {

    private PersonService personService;

    public PersonRepository() {
        this.personService = RetrofitClient.createService(PersonService.class);
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

}
