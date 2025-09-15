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

public class LoginViewModel extends AndroidViewModel {

    private final PersonRepository personRepository;
    private MutableLiveData<Feedback> mLogin = new MutableLiveData<>();
    public LiveData<Feedback> login = this.mLogin;

    public LoginViewModel(@NonNull Application application) {
        super(application);
        this.personRepository = new PersonRepository(application);
    }

    public void login(final String email, String password) {
        this.personRepository.login(email, password, new APIListener<PersonModel>() {
            @Override
            public void onSuccess(PersonModel result) {
                mLogin.setValue(new Feedback());
            }

            @Override
            public void onFailure(String message) {
                mLogin.setValue(new Feedback(message));
            }
        });
    }

}