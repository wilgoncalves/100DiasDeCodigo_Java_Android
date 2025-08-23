package com.williangoncalves.mvvm;

import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    public String login(String name) {
        if (name.isEmpty()) {
            return "Falha!";
        } else {
            return "Sucesso!";
        }
    }
}
