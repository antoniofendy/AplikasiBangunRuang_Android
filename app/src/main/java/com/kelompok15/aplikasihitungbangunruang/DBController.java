package com.kelompok15.aplikasihitungbangunruang;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBController extends SQLiteOpenHelper
{

    private static final String namaDatabase = "app_geometri.db";

    public DBController(@Nullable Context context, @Nullable SQLiteDatabase.CursorFactory factory, int version)
    {
        super(context, namaDatabase, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {
        sqLiteDatabase.execSQL("CREATE TABLE users (" +
                "user_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "username TEXT UNIQUE, " +
                "password TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1)
    {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS users;");
        onCreate(sqLiteDatabase);
    }

    public void insertUser(User user)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", user.getUsername());
        contentValues.put("password", user.getPassword());
        this.getWritableDatabase().insertOrThrow("users", "", contentValues);
    }

    public User auth(User user)
    {
        @SuppressLint("Recycle") Cursor cursor = this.getReadableDatabase().rawQuery(
                "SELECT * FROM users WHERE username = ? AND password = ?", new String[]{user.getUsername(), user.getPassword()}
        );

        if(cursor != null && cursor.moveToFirst() && cursor.getCount() > 0)
        {
            User result = new User(cursor.getInt(0), cursor.getString(1), cursor.getString(2));
            return result;
        }

        return null;
    }

//    public boolean checkUsernameAvailability(String username)
//    {
//        @SuppressLint("Recycle") Cursor cursor = this.getReadableDatabase().rawQuery(
//                "SELECT * FROM users WHERE username = ?", new String[]{username}
//        );
//
//        if(cursor != null && cursor.moveToFirst() && cursor.getCount() > 0)
//        {
//            return true;
//        }
//        return false;
//    }
}
