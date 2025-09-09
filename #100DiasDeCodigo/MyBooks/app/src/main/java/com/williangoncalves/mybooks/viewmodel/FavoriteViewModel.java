package com.williangoncalves.mybooks.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.williangoncalves.mybooks.callback.Callback;
import com.williangoncalves.mybooks.entity.BookEntity;
import com.williangoncalves.mybooks.repository.BookRepository;

import java.util.List;

public class FavoriteViewModel extends AndroidViewModel {

    private final BookRepository bookRepository = BookRepository.getInstance(getApplication().getApplicationContext());
    private final MutableLiveData<List<BookEntity>> _books = new MutableLiveData<>();
    public final LiveData<List<BookEntity>> books = _books;

    public FavoriteViewModel(@NonNull Application application) {
        super(application);
    }

    public void getBooks() {
        bookRepository.getFavoriteBooks(new Callback<List<BookEntity>>() {
            @Override
            public void onSuccess(List<BookEntity> result) {
                _books.postValue(result);
            }
        });
    }

    public void toggleFavoriteStatus(int id) {
        bookRepository.toggleFavoriteStatus(id, new Callback<Void>() {
            @Override
            public void onSuccess(Void result) {
                getBooks();
            }
        });
    }
}