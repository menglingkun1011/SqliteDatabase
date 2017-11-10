package com.example.mirsmeng.slitedatabasedemo;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.mirsmeng.slitedatabasedemo.db.MyOpenHelper;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private SQLiteDatabase database;
    private MyOpenHelper myOpenHelper;
    private TextView tv;
    private StringBuilder sb = new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.tv);
        myOpenHelper = new MyOpenHelper(this);

    }
    //通过sql语句进行增删改查
    /*public void add(View v){
        database = myOpenHelper.getWritableDatabase();
        database.execSQL("insert into student(name,age) values(?,?)",new String[]{"乾坤","23"});
        queryData();
    }

    public void del(View v){
        database = myOpenHelper.getWritableDatabase();
        database.execSQL("delete from student where name=?",new String[]{"乾坤"});
        queryData();
    }

    public void query(View v){
        queryData();
    }

    public void update(View v){
        database = myOpenHelper.getWritableDatabase();
        database.execSQL("update student set age=? where name=?",new String[]{"66","李四"});
        database.close();
        queryData();
    }

    private void queryData() {
        database = myOpenHelper.getWritableDatabase();
        Cursor c = database.rawQuery("select * from student", null);
        sb.delete(0,sb.length());
        if(c!=null && c.getCount() > 0){
            while(c.moveToNext()){
                String str = "_id:"+c.getString(c.getColumnIndex("_id"))+",name:"+c.getString(c.getColumnIndex("name"))+",age:"+c.getInt(c.getColumnIndex("age"));
                Log.d(TAG, str);
                sb.append(str);
                sb.append("\n");
            }
            tv.setText("表中数据：\n"+sb);
            c.close();
        }
        database.close();
    }*/

    //通过android提供的api 进行增删改查
    public void add(View v){
        database = myOpenHelper.getWritableDatabase();
        Log.d(TAG, "数据库路径: "+database.getPath());
        ContentValues values = new ContentValues();
        values.put("name","乾坤");
        values.put("age",24);
        database.insert("student",null,values);
        database.close();
        queryData();
    }

    public void del(View v){
        database = myOpenHelper.getWritableDatabase();
        database.delete("student","name = ?",new String[]{"乾坤"});
        database.close();
        queryData();
    }

    public void query(View v){
        queryData();
    }

    public void update(View v){
        database = myOpenHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("age",66);
        database.update("student",values,"name = ?",new String[]{"乾坤"});
        database.close();
        queryData();
    }

    private void queryData() {
        database = myOpenHelper.getWritableDatabase();
        Cursor c = database.query("student",null,null,null,null,null,null);
        sb.delete(0,sb.length());
        if(c!=null && c.getCount() > 0){
            while(c.moveToNext()){
                String str = "_id:"+c.getString(c.getColumnIndex("_id"))+",name:"+c.getString(c.getColumnIndex("name"))+",age:"+c.getInt(c.getColumnIndex("age"));
                Log.d(TAG, str);
                sb.append(str);
                sb.append("\n");
            }
            tv.setText("表中数据：\n"+sb);
            c.close();
        }
        database.close();
    }
}
