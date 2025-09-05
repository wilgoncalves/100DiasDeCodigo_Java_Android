//package com.williangoncalves.mybooks.repository;
//
//import android.content.ContentValues;
//import android.content.Context;
//import android.database.sqlite.SQLiteDatabase;
//import android.database.sqlite.SQLiteOpenHelper;
//
//import com.williangoncalves.mybooks.entity.BookEntity;
//import com.williangoncalves.mybooks.helper.DataBaseConstants;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class BookDataBaseHelper extends SQLiteOpenHelper {
//
//    private static final int VERSION = 1;
//    private static final String NAME = "BookDB";
//
//    public BookDataBaseHelper(Context context) {
//        super(context, NAME, null, VERSION);
//    }
//
//    @Override
//    public void onCreate(SQLiteDatabase db) {
//        String createBookTable = "CREATE TABLE " + DataBaseConstants.BOOK.TABLE_NAME + " (" +
//                DataBaseConstants.BOOK.COLUMNS.ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
//                DataBaseConstants.BOOK.COLUMNS.TITLE + " TEXT NOT NULL, " +
//                DataBaseConstants.BOOK.COLUMNS.AUTHOR + " TEXT NOT NULL, " +
//                DataBaseConstants.BOOK.COLUMNS.FAVORITE + " INTEGER NOT NULL, " +
//                DataBaseConstants.BOOK.COLUMNS.GENRE + " TEXT NOT NULL" +
//                ");";
//
//        db.execSQL(createBookTable);
//
//        insertBooks(db);
//    }
//
//    @Override
//    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        db.execSQL("DROP TABLE IF EXISTS " + DataBaseConstants.BOOK.TABLE_NAME);
//        onCreate(db);
//    }
//
//    private void insertBooks(SQLiteDatabase db) {
//        List<BookEntity> listBooks = getInitialBooks();
//
//        for (BookEntity book : listBooks) {
//            ContentValues values = new ContentValues();
//            values.put(DataBaseConstants.BOOK.COLUMNS.TITLE, book.getTitle());
//            values.put(DataBaseConstants.BOOK.COLUMNS.AUTHOR, book.getAuthor());
//            values.put(DataBaseConstants.BOOK.COLUMNS.GENRE, book.getGenre());
//            values.put(DataBaseConstants.BOOK.COLUMNS.FAVORITE, book.isFavorite() ? 1 : 0);
//
//            db.insert(DataBaseConstants.BOOK.TABLE_NAME, null, values);
//        }
//
//
//    }
//
//
//}
