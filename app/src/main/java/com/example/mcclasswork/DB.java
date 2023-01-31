package com.example.mcclasswork;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DB extends SQLiteOpenHelper
{

    public DB(Context context ) {
        super(context, "Sabaq1.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {


        String table2="create Table duarecord"+
                "(id int primary key," +
                "name Text," +
                "count Text," +
                "date Text)";

        db.execSQL(table2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP Table if exists duarecord");

    }

    public boolean insertStd(String name,String count,String date) {
        SQLiteDatabase mydb = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("count", count);
        contentValues.put("date", date);
        long result = mydb.insert("duarecord", null, contentValues);

        mydb.close();
        if(result==-1)
        {
            return false;
        }
        return true;

    }



    public ArrayList<Dua> getAllStudent()
    {
        ArrayList<Dua> list=new ArrayList<>();
        SQLiteDatabase mydb=this.getWritableDatabase();
        Cursor cursor=mydb.rawQuery("select * from duarecord",null);
        if(cursor.moveToFirst())
        {
            while(cursor.moveToNext())
            {
                Dua  q=new Dua();
                q.setName(cursor.getString(1));
                q.setCount(cursor.getString(2));
                q.setDate(cursor.getString(3));
                list.add(q);
            }
        }
        cursor.close();
        mydb.close();
        return list;
    }

}
