package com.williangoncalves.mybooks.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.williangoncalves.mybooks.entity.BookEntity;
import com.williangoncalves.mybooks.repository.BookRepository;

import java.util.List;

public class FavoriteViewModel extends ViewModel {

    private final BookRepository bookRepository = BookRepository.getInstance();
    private final MutableLiveData<List<BookEntity>> _books = new MutableLiveData<>();
    public final LiveData<List<BookEntity>> books = _books;

    public void getBooks() {
        _books.setValue(bookRepository.getFavoriteBooks());
    }

    public void toggleFavoriteStatus(int id) {
        bookRepository.toggleFavoriteStatus(id);
        getBooks();
    }
}