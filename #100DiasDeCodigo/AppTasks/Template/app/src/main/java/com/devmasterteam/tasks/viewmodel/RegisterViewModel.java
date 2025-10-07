package com.devmasterteam.tasks.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.devmasterteam.tasks.service.listener.APIListener;
import com.devmasterteam.tasks.service.listener.Feedback;
import com.devmasterteam.tasks.service.model.PersonModel;
import com.devmasterteam.tasks.service.repository.PersonRepository;

public class RegisterViewModel extends AndroidViewModel {

    private final PersonRepository personRepository;

    private MutableLiveData<Feedback> mCreate = new MutableLiveData<>();
    public LiveData<Feedback> create = this.mCreate;

    public RegisterViewModel(@NonNull Application application) {
        super(application);
        this.personRepository = new PersonRepository(application);
    }

    public void create(String name, String email, String password) {
        this.personRepository.create(name, email, password, new APIListener<PersonModel>() {
            @Override
            public void onSuccess(PersonModel result) {
                result.setEmail(email);
                personRepository.saveUserData(result);
                mCreate.setValue(new Feedback());
            }

            @Override
            public void onFailure(String message) {
                mCreate.setValue(new Feedback(message));
            }
        });
    }

}