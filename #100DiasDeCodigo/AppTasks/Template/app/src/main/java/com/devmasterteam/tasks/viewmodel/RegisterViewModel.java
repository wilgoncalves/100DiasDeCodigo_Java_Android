package com.devmasterteam.tasks.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.devmasterteam.tasks.service.repository.PersonRepository;

public class RegisterViewModel extends AndroidViewModel {

    private PersonRepository personRepository = new PersonRepository();

    public RegisterViewModel(@NonNull Application application) {
        super(application);
    }

    public void create(String name, String email, String password) {
        this.personRepository.create(name, email, password);
    }

}