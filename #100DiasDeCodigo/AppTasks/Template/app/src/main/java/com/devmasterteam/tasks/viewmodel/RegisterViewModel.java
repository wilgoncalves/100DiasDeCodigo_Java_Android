package com.devmasterteam.tasks.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.devmasterteam.tasks.service.listener.APIListener;
import com.devmasterteam.tasks.service.model.PersonModel;
import com.devmasterteam.tasks.service.repository.PersonRepository;

public class RegisterViewModel extends AndroidViewModel {

    private final PersonRepository personRepository;

    public RegisterViewModel(@NonNull Application application) {
        super(application);
        this.personRepository = new PersonRepository(application);
    }

    public void create(String name, String email, String password) {
        this.personRepository.create(name, email, password, new APIListener<PersonModel>() {
            @Override
            public void onSuccess(PersonModel result) {
                
            }

            @Override
            public void onFailure(String message) {

            }
        });
    }

}