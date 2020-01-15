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
					Toast.makeText(TenthActivity.this, "用户名不得为空！",
							Toast.LENGTH_SHORT).show();
				} else {
					User user = userDao.dbQueryOneByUsername(username);
					if (userDao.dbQueryOneByUsername(username) == null) {
						Toast.makeText(TenthActivity.this, "此用户不存在！",
								Toast.LENGTH_SHORT).show();
					} else {
						if (!user.getUsername().equals(username)) {
							Toast.makeText(TenthActivity.this, "此用户不存在！",
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
					Toast.makeText(TenthActivity.this, "用户名或密码不得为空！",
							Toast.LENGTH_SHORT).show();
				} else {
					User user = userDao.dbQueryOneByUsername(username);
					if (userDao.dbQueryOneByUsername(username) == null) {
						Toast.makeText(TenthActivity.this, "此用户不存在！",
								Toast.LENGTH_SHORT).show();
					} else {
						if (!user.getPassword().equals(password)) {
							Toast.makeText(TenthActivity.this, "密码错误！",
									Toast.LENGTH_SHORT).show();
						} else {
							String newPwd = et3.getText()+"";
							String confirmNewPwd = et4.getText()+"";
							if (newPwd.equals(null) || newPwd == ""
									|| confirmNewPwd.equals(null) || confirmNewPwd == ""){
								Toast.makeText(TenthActivity.this, "新密码不能为空",
										Toast.LENGTH_SHORT).show();
							}else{
								if(!newPwd.equals(confirmNewPwd)) {
									Toast.makeText(TenthActivity.this, "两次输入密码不一致！",
											Toast.LENGTH_SHORT).show();
								} else {
									userDao.dbUpdatePassword(username, newPwd);
									Toast.makeText(TenthActivity.this,
											"修改密码成功！新密码：" + newPwd + "，请牢记！",
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