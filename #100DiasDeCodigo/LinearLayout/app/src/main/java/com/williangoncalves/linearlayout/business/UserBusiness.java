package com.williangoncalves.linearlayout.business;

public class UserBusiness {

    public boolean isValid(String email, String password) {
        return !email.isEmpty() && !password.isEmpty();
    }
}
