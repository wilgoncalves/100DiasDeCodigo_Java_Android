package com.williangoncalves.mybooks.repository;

import android.content.Context;

import com.williangoncalves.mybooks.entity.BookEntity;

import java.util.ArrayList;
import java.util.List;

public class BookRepository {

    private final BookDAO dataBase;

    private BookRepository(Context context) {
        dataBase = BookDataBase.getInstance(context).bookDAO();
    }

    private static BookRepository instance;

    public static BookRepository getInstance(Context context) {
        synchronized (BookRepository.class) {
            if (instance == null) {
                instance = new BookRepository(context);
            }
        }
        return instance;
    }

    public List<BookEntity> getAllBooks() {
        return dataBase.getAllBooks();
    }

    public List<BookEntity> getFavoriteBooks() {
       return dataBase.getFavoriteBooks();
    }

    public BookEntity getBookById(int id) {
        return dataBase.getBookById(id);
    }

    public void toggleFavoriteStatus(int id) {
        BookEntity book = getBookById(id);
        book.setFavorite(!book.isFavorite());
        dataBase.update(book);
    }

    public boolean delete(int id) {
        return dataBase.delete(getBookById(id)) > 0;
    }

    public void loadInitialBooks() {
        dataBase.create(getInitialBooks());
    }

    private List<BookEntity> getInitialBooks() {
        List<BookEntity> initialBooks = new ArrayList<>();
        initialBooks.add(new BookEntity(1, "To Kill a Mockingbird", "Harper Lee", true, "Ficção"));
        initialBooks.add(new BookEntity(2, "Dom Casmurro", "Machado de Assis", false, "Romance"));
        initialBooks.add(new BookEntity(3, "O Hobbit", "J.R.R. Tolkien", true, "Fantasia"));
        initialBooks.add(new BookEntity(4, "Cem Anos de Solidão", "Gabriel García Márquez", false, "Romance"));
        initialBooks.add(new BookEntity(5, "O Pequeno Príncipe", "Antoine de Saint-Exupéry", false, "Fantasia"));
        initialBooks.add(new BookEntity(6, "Crime e Castigo", "Fiódor Dostoiévski", false, "Ficção policial"));
        initialBooks.add(new BookEntity(7, "Frankenstein", "Mary Shelley", false, "Terror"));
        initialBooks.add(new BookEntity(8, "Harry Potter e a Pedra Filosofal", "J.K. Rowling", false, "Fantasia"));
        initialBooks.add(new BookEntity(9, "Neuromancer", "William Gibson", false, "Cyberpunk"));
        initialBooks.add(new BookEntity(10, "Senhor dos Anéis", "J.R.R. Tolkien", false, "Fantasia"));
        initialBooks.add(new BookEntity(11, "Drácula", "Bram Stoker", false, "Terror"));
        initialBooks.add(new BookEntity(12, "Orgulho e Preconceito", "Jane Austen", false, "Romance"));
        initialBooks.add(new BookEntity(13, "Harry Potter e a Câmara Secreta", "J.K. Rowling", false, "Fantasia"));
        initialBooks.add(new BookEntity(14, "As Crônicas de Nárnia", "C.S. Lewis", false, "Fantasia"));
        initialBooks.add(new BookEntity(15, "O Código Da Vinci", "Dan Brown", false, "Mistério"));
        initialBooks.add(new BookEntity(16, "It: A Coisa", "Stephen King", false, "Terror"));
        initialBooks.add(new BookEntity(17, "Moby Dick", "Herman Melville", true, "Aventura"));
        initialBooks.add(new BookEntity(18, "O Nome do Vento", "Patrick Rothfuss", true, "Fantasia"));
        initialBooks.add(new BookEntity(19, "O Conde de Monte Cristo", "Alexandre Dumas", true, "Aventura"));
        initialBooks.add(new BookEntity(20, "Os Miseráveis", "Victor Hugo", false, "Romance"));

        return initialBooks;
    }
}
