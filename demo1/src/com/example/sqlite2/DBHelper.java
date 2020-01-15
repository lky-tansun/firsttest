package com.example.sqlite2;

import java.util.ArrayList;


import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DBHelper
{
    private  final String DATABASE_NAME="mydb";
    private  final int DATABASE_VERSION=1;
    private  final String TABLE_NAME="srlb";
    private  final String[] COLUMNS=
    { "id","srmc", "srsm" };
    private String sql="";

    private  DBOpenHelper helper;
    private  SQLiteDatabase db;

    public DBHelper(Context context)
    {
        sql="create table " + TABLE_NAME + " (" + COLUMNS[0] + " integer primary key AUTOINCREMENT, " + COLUMNS[1] + " varchar(50)," + COLUMNS[2] +  " varchar(50));";
        helper=new DBOpenHelper(context, DATABASE_NAME, DATABASE_VERSION, TABLE_NAME, sql);
        db=helper.getWritableDatabase();
    }

    public void insert(Srlb data)
    {
        ContentValues values=new ContentValues();
        values.put(COLUMNS[1], data.getsrmc());
        values.put(COLUMNS[2], data.getsrsm());
        db.insert(TABLE_NAME, null, values);
    }

    public  ArrayList<Srlb> find()
    {
        ArrayList<Srlb> list=new ArrayList<Srlb>();
        Srlb srlb=null;
        Cursor cursor=db.query(TABLE_NAME, COLUMNS, null, null, null, null, null);
        while(cursor.moveToNext())
        {
            srlb=new Srlb();
            srlb.setid(cursor.getInt(0));
            srlb.setsrmc(cursor.getString(1));
            srlb.setsrsm(cursor.getString(2));
            list.add(srlb);
        }
        cursor.close();
        return list;
    }
    public void delete(String id){ 
          SQLiteDatabase db = helper.getWritableDatabase();
    	  db.delete(TABLE_NAME, "id = ? ", new String[]{id}); 
    	 }  
	public  int Size() {
		SQLiteDatabase db = helper.getWritableDatabase();
		String sql = "select count(*) from srlb where id>=0";
		Cursor cursor = db.rawQuery(sql, null);
		if (cursor.moveToNext())// 判断Cursor中是否有数据
		{
			return cursor.getInt(0);// 返回总记录数
		}
		return 0;// 如果没有数据，则返回0
	}

}
