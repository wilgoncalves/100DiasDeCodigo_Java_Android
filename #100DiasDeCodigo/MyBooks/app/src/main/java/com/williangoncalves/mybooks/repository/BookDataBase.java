package com.williangoncalves.mybooks.repository;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.williangoncalves.mybooks.entity.BookEntity;

@Database(entities = {BookEntity.class}, version = 1)
public abstract class BookDataBase extends RoomDatabase {

    public abstract BookDAO bookDAO();

    private static final String NAME = "BookDB";

    private static BookDataBase instance;

    public static BookDataBase getInstance(Context context) {
        synchronized (BookDataBase.class) {
            if (instance == null) {
                instance= Room.databaseBuilder(context, BookDataBase.class, NAME)
                        .addCallback(MyBooksDBCallBack.creation)
                        .addMigrations(Migrations.migrationFromV1ToV2)
                        .allowMainThreadQueries()
                        .build();
            }
        }
        return instance;
    }

    private static class MyBooksDBCallBack {
        private static final RoomDatabase.Callback creation = new Callback() {
            @Override
            public void onCreate(@NonNull SupportSQLiteDatabase db) {
                super.onCreate(db);
            }
        };
    }

    private static class Migrations {
        private static final Migration migrationFromV1ToV2 = new Migration(1, 2) {
            @Override
            public void migrate(@NonNull SupportSQLiteDatabase db) {
                super.migrate(db);
            }
        };
    }
}
