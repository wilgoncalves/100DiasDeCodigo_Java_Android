package com.williangoncalves.mybooks.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.williangoncalves.mybooks.entity.BookEntity;
import com.williangoncalves.mybooks.repository.BookRepository;

import java.util.List;

public class HomeViewModel extends AndroidViewModel {

    private final BookRepository bookRepository = BookRepository.getInstance(getApplication().getApplicationContext());
    private final MutableLiveData<List<BookEntity>> _books = new MutableLiveData<>();
    public final LiveData<List<BookEntity>> books = _books;

    public HomeViewModel(@NonNull Application application) {
        super(application);

        if (bookRepository.getAllBooks().isEmpty()) {
            bookRepository.loadInitialBooks();
        }
    }

    public void getBooks() {
        _books.setValue(bookRepository.getAllBooks());
    }

    public void toggleFavoriteStatus(int id) {
        bookRepository.toggleFavoriteStatus(id);
        getBooks();
    }
}