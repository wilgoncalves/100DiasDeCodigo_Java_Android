package com.devmasterteam.tasks.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.devmasterteam.tasks.service.repository.PersonRepository;

public class MainViewModel extends AndroidViewModel {

    private PersonRepository personRepository;

    public MainViewModel(@NonNull Application application) {
        super(application);
        this.personRepository = new PersonRepository(application);
    }

    public void logout() {
        this.personRepository.clearUserData();
    }

    public void loadUserData() {
    }

}
