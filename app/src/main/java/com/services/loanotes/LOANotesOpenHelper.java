package com.services.loanotes;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class LOANotesOpenHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "loanotes.db";
    public static final int DATABASE_VERSION = 1;

    public LOANotesOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(LOANotesDBContract.UserInfoEntry.SQL_CREATE_TABLE);
        DatabaseDataWorker worker = new DatabaseDataWorker(sqLiteDatabase);
        worker.insertUsers();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
