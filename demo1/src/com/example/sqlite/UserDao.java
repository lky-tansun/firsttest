package com.example.sqlite;

import java.util.ArrayList;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.example.sqlite.*;
 
public class UserDao {
	private DBOpenHelper dbOpenHelper;// ����DBOpenHelper����
	private SQLiteDatabase sqliteDatabase;// ����SQLiteDatabase����
 
	public UserDao(Context context)// ���幹�캯��
	{
		dbOpenHelper = new DBOpenHelper(context, null, null, 0);// ��ʼ��DBOpenHelper����
	}
 
	// �����û�����
	public void dbInsert(String username, String sex,String birthday,String place,String email,String password) {
		sqliteDatabase = dbOpenHelper.getWritableDatabase();// �Զ�д���������ݿ⣬��������д��getReadableDatabase()��ֻ��
		String sql = "insert into t_user(username,sex,birthday,place,email,password,isDel) values (?,?,?,?,?,?,0)";
		// ���ݹ�����username��password�ֱ�˳���滻����sql��������?���Զ�ת�����ͣ���ͬ������׸��
		Object bindArgs[] = new Object[] { username,sex,birthday,place,email, password };
		// ִ�������޷���ֵ��sql���
		sqliteDatabase.execSQL(sql, bindArgs);
	}
 
	// ��������ж���������
	public int dbGetUserSize() {
		sqliteDatabase = dbOpenHelper.getWritableDatabase();
		String sql = "select count(*) from t_user where isDel=0";
		Cursor cursor = sqliteDatabase.rawQuery(sql, null);
		if (cursor.moveToNext())// �ж�Cursor���Ƿ�������
		{
			return cursor.getInt(0);// �����ܼ�¼��
		}
		return 0;// ���û�����ݣ��򷵻�0
	}
 
	// �����û��������û�
	public User dbQueryOneByUsername(String username) {
		sqliteDatabase = dbOpenHelper.getWritableDatabase();
		String sql = "select * from t_user where username=? and isDel=0";
		String[] selectionArgs = new String[] { username };
		Cursor cursor = sqliteDatabase.rawQuery(sql, selectionArgs);
		if (cursor.moveToNext())// �ж�Cursor���Ƿ�������
		{
			User user = new User();
			user.setUsername(cursor.getString(cursor.getColumnIndex("username")));
			user.setPassword(cursor.getString(cursor.getColumnIndex("password")));
			return user;// ����һ���û���ǰ̨
		}
		return null;// û�з���null
	}
 
	// �����û������޸�����
	public void dbUpdatePassword(String username, String newPassword) {
		sqliteDatabase = dbOpenHelper.getWritableDatabase();
		String sql = "update t_user set password=? where username=? and isDel=0";
		Object bindArgs[] = new Object[] { newPassword, username };
		sqliteDatabase.execSQL(sql, bindArgs);
	}
 
	// ��ѯ�����û�
	public ArrayList<User> dbQueryAll() {
		ArrayList<User> userArrayList = new ArrayList<User>();
		sqliteDatabase = dbOpenHelper.getWritableDatabase();
		String sql = "select * from t_user where isDel=0";
		Cursor cursor = sqliteDatabase.rawQuery(sql, null);
		// �α��ͷ����β
		for (cursor.moveToFirst(); !(cursor.isAfterLast()); cursor.moveToNext()) {
			if (cursor.getInt(cursor.getColumnIndex("isDel")) != 1) {
				User user = new User();
				user.setUsername(cursor.getString(cursor
						.getColumnIndex("username")));
				user.setsex(cursor.getString(cursor
						.getColumnIndex("sex")));
				user.setbirthday(cursor.getString(cursor
						.getColumnIndex("birthday")));
				user.setplace(cursor.getString(cursor
						.getColumnIndex("place")));
				user.setemail(cursor.getString(cursor
						.getColumnIndex("email")));
				userArrayList.add(user);
			}
		}
		return userArrayList;
	}
 
}