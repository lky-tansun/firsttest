package com.example.sqlite4;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DBHelper2
{
    private static final String DATABASE_NAME="mydb3";
    private static final int DATABASE_VERSION=1;
    private static final String TABLE_NAME="sr";
    private static final String[] COLUMNS=
    { "date","srlb", "srje" ,"bz"};
    private String sql="";

    private DBOpenHelper helper;
    private SQLiteDatabase db;

    public DBHelper2(Context context)
    {
        sql="create table " + TABLE_NAME + " (" + COLUMNS[0] + " varchar(50), " + COLUMNS[1] + " varchar(50)," + COLUMNS[2] +  " varchar(50)," + COLUMNS[3] +  " varchar(50));";
        helper=new DBOpenHelper(context, DATABASE_NAME, DATABASE_VERSION, TABLE_NAME, sql);
        db=helper.getWritableDatabase();
    }

    public void insert(Sr data)
    {
        ContentValues values=new ContentValues();
        values.put(COLUMNS[0], data.getDate());
        values.put(COLUMNS[1], data.getSrlb());
        values.put(COLUMNS[2], data.getSrje());
        values.put(COLUMNS[3], data.getBz());
        db.insert(TABLE_NAME, null, values);
    }

    public ArrayList<Sr> find()
    {
        ArrayList<Sr> list=new ArrayList<Sr>();
        Sr sr=null;
        Cursor cursor=db.query(TABLE_NAME, COLUMNS, null, null, null, null, null);
        while(cursor.moveToNext())
        {
            sr=new Sr();
            sr.setDate(cursor.getString(0));
            sr.setSrlb(cursor.getString(1));
            sr.setSrje(cursor.getString(2));
            sr.setBz(cursor.getString(3));
            list.add(sr);
        }
        cursor.close();
        return list;
    }
	public  int Size() {
		SQLiteDatabase db = helper.getWritableDatabase();
		String sql = "select count(*) from sr where srje>=0";
		Cursor cursor = db.rawQuery(sql, null);
		if (cursor.moveToNext())// 判断Cursor中是否有数据
		{
			return cursor.getInt(0);// 返回总记录数
		}
		return 0;// 如果没有数据，则返回0
	}

}
