package com.example.demo1;

import com.example.sqlite.User;
import com.example.sqlite.UserDao;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TenthActivity extends Activity {
	private EditText et1,et2,et3,et4;
	private Button btn1,btn2,btn3;
	private UserDao userDao;
	 @Override
	 protected void onCreate(Bundle savedInstanceState) {
	 	super.onCreate(savedInstanceState);
		setContentView(R.layout.test16);
		PublicWay.activityList.add(this);
		userDao = new UserDao(this);
		et1 = (EditText) findViewById(R.id.et1);
		et2 = (EditText) findViewById(R.id.et2);
		et3 = (EditText) findViewById(R.id.et3);
		et4 = (EditText) findViewById(R.id.et4);
	    btn1 = (Button) findViewById(R.id.chaxun);
	    btn2 = (Button) findViewById(R.id.xiugai);
		btn3 = (Button) findViewById(R.id.quit);
		btn1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				String username = et1.getText().toString().trim();
				if (username.equals(null) || username == "") {
					Toast.makeText(TenthActivity.this, "�û�������Ϊ�գ�",
							Toast.LENGTH_SHORT).show();
				} else {
					User user = userDao.dbQueryOneByUsername(username);
					if (userDao.dbQueryOneByUsername(username) == null) {
						Toast.makeText(TenthActivity.this, "���û������ڣ�",
								Toast.LENGTH_SHORT).show();
					} else {
						if (!user.getUsername().equals(username)) {
							Toast.makeText(TenthActivity.this, "���û������ڣ�",
									Toast.LENGTH_SHORT).show();
						} else {
							Intent intent = new Intent(TenthActivity.this,ThirteenthActivity.class);
							startActivity(intent);
}
						}}
							} });
		
		btn2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				String username = et1.getText()+"";
				String password = et2.getText()+"";
				if (username.equals(null) || username == ""
						|| password.equals(null) || password == "") {
					Toast.makeText(TenthActivity.this, "�û��������벻��Ϊ�գ�",
							Toast.LENGTH_SHORT).show();
				} else {
					User user = userDao.dbQueryOneByUsername(username);
					if (userDao.dbQueryOneByUsername(username) == null) {
						Toast.makeText(TenthActivity.this, "���û������ڣ�",
								Toast.LENGTH_SHORT).show();
					} else {
						if (!user.getPassword().equals(password)) {
							Toast.makeText(TenthActivity.this, "�������",
									Toast.LENGTH_SHORT).show();
						} else {
							String newPwd = et3.getText()+"";
							String confirmNewPwd = et4.getText()+"";
							if (newPwd.equals(null) || newPwd == ""
									|| confirmNewPwd.equals(null) || confirmNewPwd == ""){
								Toast.makeText(TenthActivity.this, "�����벻��Ϊ��",
										Toast.LENGTH_SHORT).show();
							}else{
								if(!newPwd.equals(confirmNewPwd)) {
									Toast.makeText(TenthActivity.this, "�����������벻һ�£�",
											Toast.LENGTH_SHORT).show();
								} else {
									userDao.dbUpdatePassword(username, newPwd);
									Toast.makeText(TenthActivity.this,
											"�޸�����ɹ��������룺" + newPwd + "�����μǣ�",
											Toast.LENGTH_SHORT).show();
								}
							}
						}
					}
				}
			}
		});
		btn3.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(TenthActivity.this,SecondActivity.class);
				startActivity(intent);
			}
			});
	 }}