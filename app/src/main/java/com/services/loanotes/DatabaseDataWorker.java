package com.services.loanotes;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.services.loanotes.LOANotesDBContract.UserInfoEntry;

public class DatabaseDataWorker {
    private SQLiteDatabase mDb;

    public DatabaseDataWorker(SQLiteDatabase db) {
        mDb = db;
    }

    public void insertUsers() {
        insertUser("Katiku Mutua", "mutuab@gmail.com", "+254758 591 758",
                "emirates");
        insertUser("Jim Wilson", "jim@wilson.com", "+254780 591 758",
                "emirates");
    }

    private void insertUser(String userName, String email, String phone, String password) {
        ContentValues values = new ContentValues();
        values.put(UserInfoEntry.COLUMN_USER_NAME, userName);
        values.put(UserInfoEntry.COLUMN_USER_EMAIL, email);
        values.put(UserInfoEntry.COLUMN_USER_PHONE, phone);
        values.put(UserInfoEntry.COLUMN_USER_PASS, password);

        long newRowId = mDb.insert(UserInfoEntry.TABLE_NAME, null, values);
    }
}
