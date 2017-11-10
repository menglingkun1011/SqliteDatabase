package com.example.mirsmeng.slitedatabasedemo.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;

import java.io.File;

/**
 * Created by MirsMeng on 2017/11/10.
 */

public class MyOpenHelper extends SQLiteOpenHelper {

    private static final String name = Environment.getExternalStorageDirectory()+"/naive/std.db"; //数据库路径及名称

    public MyOpenHelper(Context context) {
        super(context, name, null, 1);
    }

    //当数据库第一次创建的时候调用，适合做创建表操作，如果数据库文件已经创建  则不会调用
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table student(_id integer primary key autoincrement,name varchar(20),age integer)");
        db.execSQL("insert into student(name,age) values('张三',23)");
        db.execSQL("insert into student(name,age) values('李四',28)");
    }
    //数据库升级是调用
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    //降级操作  谷歌不推荐我们使用  如果使用 要把super注释掉
    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        super.onDowngrade(db, oldVersion, newVersion);
    }

    public boolean delSuccess(){
        File file = new File(name);
        if(file.exists()){
            return file.delete();
        }
        return true;
    }
}
