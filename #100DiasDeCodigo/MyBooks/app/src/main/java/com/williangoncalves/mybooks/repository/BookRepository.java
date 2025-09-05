package com.williangoncalves.mybooks.repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.williangoncalves.mybooks.entity.BookEntity;
import com.williangoncalves.mybooks.helper.DataBaseConstants;

import java.util.ArrayList;
import java.util.List;

public class BookRepository {

    private final BookDataBaseHelper dataBase;

    private BookRepository(Context context) {
        dataBase = new BookDataBaseHelper(context);
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

    public List<BookEntity> getBooks() {
        List<BookEntity> list = new ArrayList<>();
        SQLiteDatabase db = dataBase.getReadableDatabase();

        Cursor cursor = db.query(DataBaseConstants.BOOK.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                null);

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndexOrThrow(DataBaseConstants.BOOK.COLUMNS.ID));
                String title = cursor.getString(cursor.getColumnIndexOrThrow(DataBaseConstants.BOOK.COLUMNS.TITLE));
                String author = cursor.getString(cursor.getColumnIndexOrThrow(DataBaseConstants.BOOK.COLUMNS.AUTHOR));
                String genre = cursor.getString(cursor.getColumnIndexOrThrow(DataBaseConstants.BOOK.COLUMNS.GENRE));
                boolean favorite = cursor.getInt(cursor.getColumnIndexOrThrow(DataBaseConstants.BOOK.COLUMNS.FAVORITE)) == 1;

                list.add(new BookEntity(id, title, author, favorite, genre));
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return list;
    }

    public List<BookEntity> getFavoriteBooks() {
        List<BookEntity> list = new ArrayList<>();
        SQLiteDatabase db = dataBase.getReadableDatabase();

        Cursor cursor = db.query(DataBaseConstants.BOOK.TABLE_NAME,
                null,
                DataBaseConstants.BOOK.COLUMNS.FAVORITE + " = ? ",
                new String[]{"1"},
                null,
                null,
                null);

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndexOrThrow(DataBaseConstants.BOOK.COLUMNS.ID));
                String title = cursor.getString(cursor.getColumnIndexOrThrow(DataBaseConstants.BOOK.COLUMNS.TITLE));
                String author = cursor.getString(cursor.getColumnIndexOrThrow(DataBaseConstants.BOOK.COLUMNS.AUTHOR));
                String genre = cursor.getString(cursor.getColumnIndexOrThrow(DataBaseConstants.BOOK.COLUMNS.GENRE));
                boolean favorite = cursor.getInt(cursor.getColumnIndexOrThrow(DataBaseConstants.BOOK.COLUMNS.FAVORITE)) == 1;

                list.add(new BookEntity(id, title, author, favorite, genre));
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return list;
    }

    public BookEntity getBookById(int id) {
        BookEntity book = null;
        SQLiteDatabase db = dataBase.getReadableDatabase();

        Cursor cursor = db.query(DataBaseConstants.BOOK.TABLE_NAME,
                null,
                DataBaseConstants.BOOK.COLUMNS.ID + " = ? ",
                new String[]{String.valueOf(id)},
                null,
                null,
                null);

        if (cursor.moveToFirst()) {
            String title = cursor.getString(cursor.getColumnIndexOrThrow(DataBaseConstants.BOOK.COLUMNS.TITLE));
            String author = cursor.getString(cursor.getColumnIndexOrThrow(DataBaseConstants.BOOK.COLUMNS.AUTHOR));
            String genre = cursor.getString(cursor.getColumnIndexOrThrow(DataBaseConstants.BOOK.COLUMNS.GENRE));
            boolean favorite = cursor.getInt(cursor.getColumnIndexOrThrow(DataBaseConstants.BOOK.COLUMNS.FAVORITE)) == 1;

            book = new BookEntity(id, title, author, favorite, genre);
        }

        cursor.close();
        db.close();

        return book;
    }

    public void toggleFavoriteStatus(int id) {
        BookEntity book = getBookById(id);
        SQLiteDatabase db = dataBase.getWritableDatabase();

        int newFavoriteStatus = book.isFavorite() ? 0 : 1;
        ContentValues values = new ContentValues();
        values.put(DataBaseConstants.BOOK.COLUMNS.FAVORITE, newFavoriteStatus);

        db.update(DataBaseConstants.BOOK.TABLE_NAME,
                values,
                DataBaseConstants.BOOK.COLUMNS.ID + " = ? ",
                new String[]{String.valueOf(id)});
    }

    public boolean delete(int id) {
        SQLiteDatabase db = dataBase.getWritableDatabase();
        int rowsDeleted = db.delete(DataBaseConstants.BOOK.TABLE_NAME,
                DataBaseConstants.BOOK.COLUMNS.ID + " = ? ",
                new String[]{String.valueOf(id)});

        return rowsDeleted > 0;
    }
}
