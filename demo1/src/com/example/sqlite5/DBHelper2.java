package com.example.sqlite5;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DBHelper2
{
    private static final String DATABASE_NAME="mydb4";
    private static final int DATABASE_VERSION=1;
    private static final String TABLE_NAME="zc";
    private static final String[] COLUMNS=
    { "date","zclb", "zcje" ,"bz"};
    private String sql="";

    private DBOpenHelper helper;
    private SQLiteDatabase db;

    public DBHelper2(Context context)
    {
        sql="create table " + TABLE_NAME + " (" + COLUMNS[0] + " varchar(50), " + COLUMNS[1] + " varchar(50)," + COLUMNS[2] +  " varchar(50)," + COLUMNS[3] +  " varchar(50));";
        helper=new DBOpenHelper(context, DATABASE_NAME, DATABASE_VERSION, TABLE_NAME, sql);
        db=helper.getWritableDatabase();
    }

    public void insert(Zc data)
    {
        ContentValues values=new ContentValues();
        values.put(COLUMNS[0], data.getDate());
        values.put(COLUMNS[1], data.getZclb());
        values.put(COLUMNS[2], data.getZcje());
        values.put(COLUMNS[3], data.getBz());
        db.insert(TABLE_NAME, null, values);
    }

    public ArrayList<Zc> find()
    {
        ArrayList<Zc> list=new ArrayList<Zc>();
        Zc zc=null;
        Cursor cursor=db.query(TABLE_NAME, COLUMNS, null, null, null, null, null);
        while(cursor.moveToNext())
        {
            zc=new Zc();
            zc.setDate(cursor.getString(0));
            zc.setZclb(cursor.getString(1));
            zc.setZcje(cursor.getString(2));
            zc.setBz(cursor.getString(3));
            list.add(zc);
        }
        cursor.close();
        return list;
    }
	public  int Size() {
		SQLiteDatabase db = helper.getWritableDatabase();
		String sql = "select count(*) from zc where zcje>=0";
		Cursor cursor = db.rawQuery(sql, null);
		if (cursor.moveToNext())// 判断Cursor中是否有数据
		{
			return cursor.getInt(0);// 返回总记录数
		}
		return 0;// 如果没有数据，则返回0
	}
}