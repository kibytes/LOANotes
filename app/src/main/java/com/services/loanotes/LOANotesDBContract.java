package com.services.loanotes;

import android.provider.BaseColumns;

public final class LOANotesDBContract implements BaseColumns {
    private LOANotesDBContract() {}

    public static final class UserInfoEntry {
        public static final String TABLE_NAME = "user_info";
        public static final String COLUMN_USER_NAME = "full_name";
        public static final String COLUMN_USER_EMAIL = "email";
        public static final String COLUMN_USER_PHONE = "phone";
        public static final String COLUMN_USER_PASS = "password";

        // CREATE TABLE course_info (course_id, course_title)
        public static final String SQL_CREATE_TABLE =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        _ID + " INTEGER PRIMARY KEY, " +
                        COLUMN_USER_NAME + " TEXT NOT NULL, " +
                        COLUMN_USER_EMAIL + " TEXT UNIQUE NOT NULL, " +
                        COLUMN_USER_PHONE + " TEXT UNIQUE NOT NULL, " +
                        COLUMN_USER_PASS + "   TEXT NOT NULL)";
    }

    public static final class NoteInfoEntry implements BaseColumns {
        public static final String TABLE_NAME = "note_info";
        public static final String COLUMN_NOTE_TITLE = "note_title";
        public static final String COLUMN_NOTE_TEXT = "note_text";
        public static final String COLUMN_COURSE_ID = "course_id";

        public static final String SQL_CREATE_TABLE =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        _ID + " INTEGER PRIMARY KEY, " +
                        COLUMN_NOTE_TITLE + " TEXT NOT NULL, " +
                        COLUMN_NOTE_TEXT + " TEXT, " +
                        COLUMN_COURSE_ID + " TEXT NOT NULL)";
    }
}
