package com.example.happytravel.register;
import android.database.Cursor;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class OpenHelper extends SQLiteOpenHelper {
    private SQLiteDatabase db;
    public static final String CREATE_USER = "create table user ("
            + "id integer primary key autoincrement, "
            + "username text, "
            + "password text)";

    public OpenHelper(Context context){
        super(context,"db_test",null,1);
        db = getReadableDatabase();}


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USER);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS user");
        onCreate(db);
    }
    public void add(String username,String password){
        db.execSQL("INSERT INTO user (username,password) VALUES(?,?)",new Object[]{username,password});
    }
    public void delete(String username,String password){
        db.execSQL("DELETE FROM user WHERE username = AND password ="+username+password);
    }
    public void update(String password){
        db.execSQL("UPDATE user SET password = ?",new Object[]{password});
    }
    public ArrayList<User> getAllData(){

        ArrayList<User> list = new ArrayList<User>();
        Cursor cursor = db.query("user",null,null,null,null,null,"username DESC");
        while(cursor.moveToNext()){
            String username = cursor.getString(cursor.getColumnIndex("username"));
            String password = cursor.getString(cursor.getColumnIndex("password"));
            list.add(new User(username,password));
        }
        return list;
    }
}

