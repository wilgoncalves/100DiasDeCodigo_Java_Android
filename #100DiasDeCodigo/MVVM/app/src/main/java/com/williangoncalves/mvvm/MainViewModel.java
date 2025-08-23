package com.williangoncalves.mvvm;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    // LiveData
    private MutableLiveData<String> _login = new MutableLiveData<>();

    public LiveData<String> loginMessage() {
        return _login;
    }

    public void login(String name) {
        if (name.isEmpty()) {
            _login.setValue("Falha!");
        } else {
            _login.setValue("Sucesso!");
        }
    }
}
