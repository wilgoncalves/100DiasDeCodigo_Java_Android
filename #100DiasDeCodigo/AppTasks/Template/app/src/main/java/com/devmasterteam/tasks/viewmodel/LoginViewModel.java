package com.devmasterteam.tasks.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.devmasterteam.tasks.service.listener.APIListener;
import com.devmasterteam.tasks.service.listener.Feedback;
import com.devmasterteam.tasks.service.model.PersonModel;
import com.devmasterteam.tasks.service.model.PriorityModel;
import com.devmasterteam.tasks.service.repository.PersonRepository;
import com.devmasterteam.tasks.service.repository.PriorityRepository;

import java.util.List;

public class LoginViewModel extends AndroidViewModel {

    private final PersonRepository personRepository;
    private PriorityRepository priorityRepository;

    private MutableLiveData<Feedback> mLogin = new MutableLiveData<>();
    public LiveData<Feedback> login = this.mLogin;

    private MutableLiveData<Boolean> mUserLogged = new MutableLiveData<>();
    public LiveData<Boolean> userLogged = this.mUserLogged;

    public LoginViewModel(@NonNull Application application) {
        super(application);
        this.personRepository = new PersonRepository(application);
        this.priorityRepository = new PriorityRepository(application);
    }

    public void login(final String email, String password) {
        this.personRepository.login(email, password, new APIListener<PersonModel>() {
            @Override
            public void onSuccess(PersonModel result) {
                // Salva os dados de login
                result.setEmail(email);
                personRepository.saveUserData(result);
                // Informa sucesso
                mLogin.setValue(new Feedback());
            }

            @Override
            public void onFailure(String message) {
                mLogin.setValue(new Feedback(message));
            }
        });
    }

    public void verifyUserLogged() {
        PersonModel model = this.personRepository.getUserData();
        boolean logged = !"".equals(model.getName());

        // Adiciona os headers
        this.personRepository.saveUserData(model);

        // Usuário não logado
        if (!logged) {
            this.priorityRepository.all(new APIListener<List<PriorityModel>>() {
                @Override
                public void onSuccess(List<PriorityModel> result) {
                    priorityRepository.save(result);
                }

                @Override
                public void onFailure(String message) {

                }
            });
        }

        this.mUserLogged.setValue(logged);
    }
}