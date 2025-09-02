package com.williangoncalves.mybooks.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.williangoncalves.mybooks.entity.BookEntity;
import com.williangoncalves.mybooks.repository.BookRepository;

public class DetailsViewModel extends ViewModel {

    private final BookRepository bookRepository = BookRepository.getInstance();
    private final MutableLiveData<BookEntity> _book = new MutableLiveData<>();
    public final LiveData<BookEntity> book = _book;

    private final MutableLiveData<Boolean> _bookDeleted = new MutableLiveData<>();
    public final LiveData<Boolean> bookDeleted = _bookDeleted;

    public void getBookById(int id) {
        _book.setValue(bookRepository.getBookById(id));
    }

    public void toggleFavoriteStatus(int id) {
        bookRepository.toggleFavoriteStatus(id);
    }

    public void delete(int id) {
        _bookDeleted.setValue(bookRepository.delete(id));
    }
}