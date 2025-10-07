package com.devmasterteam.tasks.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.devmasterteam.tasks.service.model.PersonModel;
import com.devmasterteam.tasks.service.repository.PersonRepository;

public class MainViewModel extends AndroidViewModel {

    private PersonRepository personRepository;

    private MutableLiveData<PersonModel> _userData = new MutableLiveData<>();
    public LiveData<PersonModel> userData = this._userData;

    public MainViewModel(@NonNull Application application) {
        super(application);
        this.personRepository = new PersonRepository(application);
    }

    public void logout() {
        this.personRepository.clearUserData();
    }

    public void loadUserData() {
        this._userData.setValue(this.personRepository.getUserData());
    }

}
