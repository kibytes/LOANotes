package com.services.loanotes;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.services.loanotes.LOANotesDBContract.UserInfoEntry;

import java.util.ArrayList;

public class DataManager {

    public static ArrayList<LOAUser> users;

    public LOAUser loadFromDatabase(LOANotesOpenHelper dbHelper) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        final String[] userInfo = {
                UserInfoEntry.COLUMN_USER_NAME,
                UserInfoEntry.COLUMN_USER_EMAIL,
                UserInfoEntry.COLUMN_USER_PHONE,
                UserInfoEntry.COLUMN_USER_PASS
        };
        Cursor userInfoCursor = db.query(UserInfoEntry.TABLE_NAME, userInfo, null, null, null,
                null, null);

        if (userInfoCursor != null) {
           userInfoCursor.moveToFirst();
        } else { return null; }
        return new LOAUser(userInfoCursor.getString(0), userInfoCursor.getString(1),
                userInfoCursor.getString(2), userInfoCursor.getString(3));
    }
}
