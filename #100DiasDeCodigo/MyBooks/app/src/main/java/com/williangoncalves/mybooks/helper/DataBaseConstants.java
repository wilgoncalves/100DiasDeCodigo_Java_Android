package com.williangoncalves.mybooks.helper;

public final class DataBaseConstants {

    private DataBaseConstants() { }

    public static final class BOOK {
        public static final String TABLE_NAME = "Book";

        public static final class COLUMNS {
            public static final String  ID = "Id";
            public static final String TITLE = "Title";
            public static final String AUTHOR = "Author";
            public static final String FAVORITE = "Favorite";
            public static final String GENRE = "Genre";
        }
    }
}
