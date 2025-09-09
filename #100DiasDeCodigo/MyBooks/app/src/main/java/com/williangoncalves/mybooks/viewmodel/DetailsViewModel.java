package com.williangoncalves.mybooks.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.williangoncalves.mybooks.callback.Callback;
import com.williangoncalves.mybooks.entity.BookEntity;
import com.williangoncalves.mybooks.repository.BookRepository;

public class DetailsViewModel extends AndroidViewModel {

    private final BookRepository bookRepository = BookRepository.getInstance(getApplication().getApplicationContext());
    private final MutableLiveData<BookEntity> _book = new MutableLiveData<>();
    public final LiveData<BookEntity> book = _book;

    private final MutableLiveData<Boolean> _bookDeleted = new MutableLiveData<>();
    public final LiveData<Boolean> bookDeleted = _bookDeleted;

    public DetailsViewModel(@NonNull Application application) {
        super(application);
    }

    public void getBookById(int id) {
        bookRepository.getBookById(id, new Callback<BookEntity>() {
            @Override
            public void onSuccess(BookEntity result) {
                _book.postValue(result);
            }
        });
    }

    public void toggleFavoriteStatus(int id) {
        bookRepository.toggleFavoriteStatus(id, new Callback<Void>() {
            @Override
            public void onSuccess(Void result) {
            }
        });
    }

    public void delete(int id) {
        bookRepository.delete(id, new Callback<Boolean>() {
            @Override
            public void onSuccess(Boolean result) {
                _bookDeleted.postValue(result);
            }
        });
    }
}