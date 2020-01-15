package com.example.sqlite3;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DBHelper
{
    private static final String DATABASE_NAME="mydb2";
    private static final int DATABASE_VERSION=1;
    private static final String TABLE_NAME="zclb";
    private static final String[] COLUMNS=
    { "id","zcmc", "zcsm" };
    private String sql="";

    private DBOpenHelper helper;
    private SQLiteDatabase db;

    public DBHelper(Context context)
    {
        sql="create table " + TABLE_NAME + " (" + COLUMNS[0] + " integer primary key AUTOINCREMENT, " + COLUMNS[1] + " varchar(50)," + COLUMNS[2] +  " varchar(50));";
        helper=new DBOpenHelper(context, DATABASE_NAME, DATABASE_VERSION, TABLE_NAME, sql);
        db=helper.getWritableDatabase();
    }

    public void insert(Zclb data)
    {
        ContentValues values=new ContentValues();
        values.put(COLUMNS[1], data.getzcmc());
        values.put(COLUMNS[2], data.getzcsm());
        db.insert(TABLE_NAME, null, values);
    }

    public ArrayList<Zclb> find()
    {
        ArrayList<Zclb> list=new ArrayList<Zclb>();
        Zclb zclb=null;
        Cursor cursor=db.query(TABLE_NAME, COLUMNS, null, null, null, null, null);
        while(cursor.moveToNext())
        {
            zclb=new Zclb();
            zclb.setid(cursor.getInt(0));
            zclb.setzcmc(cursor.getString(1));
            zclb.setzcsm(cursor.getString(2));
            list.add(zclb);
        }
        cursor.close();
        return list;
    }
    public void delete(String id){ 
          SQLiteDatabase db = helper.getWritableDatabase();
    	  db.delete(TABLE_NAME, "id = ? ", new String[]{id}); 
    	 }  
	public int Size() {
		SQLiteDatabase db = helper.getWritableDatabase();
		String sql = "select count(*) from zclb where id>=0";
		Cursor cursor = db.rawQuery(sql, null);
		if (cursor.moveToNext())// 判断Cursor中是否有数据
		{
			return cursor.getInt(0);// 返回总记录数
		}
		return 0;// 如果没有数据，则返回0
	}
}
