package com.example.mirsmeng.slitedatabasedemo.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by MirsMeng on 2017/11/10.
 */

public class MyOpenHelper extends SQLiteOpenHelper {

    public MyOpenHelper(Context context) {
        super(context, "std.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table student(_id integer primary key autoincrement,name varchar(20),age integer)");
        db.execSQL("insert into student(name,age) values('张三',23)");
        db.execSQL("insert into student(name,age) values('李四',28)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
