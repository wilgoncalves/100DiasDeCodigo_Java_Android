package com.williangoncalves.mybooks.repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.williangoncalves.mybooks.entity.BookEntity;
import com.williangoncalves.mybooks.helper.DataBaseConstants;

import java.util.ArrayList;
import java.util.List;

public class BookDataBaseHelper extends SQLiteOpenHelper {

    private static final int VERSION = 1;
    private static final String NAME = "BookDB";

    public BookDataBaseHelper(Context context) {
        super(context, NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createBookTable = "CREATE TABLE " + DataBaseConstants.BOOK.TABLE_NAME + " (" +
                DataBaseConstants.BOOK.COLUMNS.ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                DataBaseConstants.BOOK.COLUMNS.TITLE + " TEXT NOT NULL, " +
                DataBaseConstants.BOOK.COLUMNS.AUTHOR + " TEXT NOT NULL, " +
                DataBaseConstants.BOOK.COLUMNS.FAVORITE + " INTEGER NOT NULL, " +
                DataBaseConstants.BOOK.COLUMNS.GENRE + " TEXT NOT NULL" +
                ");";

        db.execSQL(createBookTable);

        insertBooks(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DataBaseConstants.BOOK.TABLE_NAME);
        onCreate(db);
    }

    private void insertBooks(SQLiteDatabase db) {
        List<BookEntity> listBooks = getInitialBooks();

        for (BookEntity book : listBooks) {
            ContentValues values = new ContentValues();
            values.put(DataBaseConstants.BOOK.COLUMNS.TITLE, book.getTitle());
            values.put(DataBaseConstants.BOOK.COLUMNS.AUTHOR, book.getAuthor());
            values.put(DataBaseConstants.BOOK.COLUMNS.GENRE, book.getGenre());
            values.put(DataBaseConstants.BOOK.COLUMNS.FAVORITE, book.isFavorite() ? 1 : 0);

            db.insert(DataBaseConstants.BOOK.TABLE_NAME, null, values);
        }


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
