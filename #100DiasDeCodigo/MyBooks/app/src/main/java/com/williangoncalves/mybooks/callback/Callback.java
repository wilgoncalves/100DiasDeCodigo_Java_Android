package com.williangoncalves.mybooks.callback;

import com.williangoncalves.mybooks.entity.BookEntity;

import java.util.List;

public interface Callback<T> {
    void onSuccess(T result);
}
