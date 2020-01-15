package com.example.demo1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.sqlite.UserDao;

public class TwelfthActivity extends Activity{
	private EditText et1,et2,et3,et4,et5,et6;
	private RadioButton btn1;
	private Button btn2,btn3;
	private UserDao userDao;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.test24);
		PublicWay.activityList.add(this);
		userDao = new UserDao(this);
		et1 = (EditText) findViewById(R.id.et1);
		et2 = (EditText) findViewById(R.id.et2);
		et3 = (EditText) findViewById(R.id.et3);
		et4 = (EditText) findViewById(R.id.et4);
		et5 = (EditText) findViewById(R.id.et5);
		et6 = (EditText) findViewById(R.id.et6);
		btn1=(RadioButton)findViewById(R.id.male);
		btn2=(Button) findViewById(R.id.zhuce);
		btn3=(Button) findViewById(R.id.quit);
		btn2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				String username = et1.getText()+"";
				String sex;
				String birthday = et2.getText()+"";
				String place = et3.getText()+"";
				String email = et4.getText()+"";
				String password = et5.getText()+"";
				if (btn1.isChecked()) { 
					sex = "��";
		          } else {
		            sex = "Ů";
		          }
				if (username.equals(null) || username == ""
						|| password.equals(null) || password == "") {
					Toast.makeText(TwelfthActivity.this, "�û��������벻��Ϊ�գ�",
							Toast.LENGTH_SHORT).show();
				} else {
					String confirmPwd = et6.getText() + "";
					if (!password.equals(confirmPwd)) {
						Toast.makeText(TwelfthActivity.this, "�����������벻һ�£�",
								Toast.LENGTH_SHORT).show();
					} else {
						if (userDao.dbQueryOneByUsername(username) == null) {
							userDao.dbInsert(username,sex,birthday,place,email, password);
							Toast.makeText(
									TwelfthActivity.this,
									"ע��ɹ����û�����" + username + "�����룺" + password
											+ "�����μǣ�", Toast.LENGTH_SHORT)
									.show();
						} else {							
							Toast.makeText(TwelfthActivity.this, "���û��ѱ�ע��",
									Toast.LENGTH_SHORT).show();
						}
					}
				}
 
			}
		});
		btn3.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(TwelfthActivity.this,MainActivity.class);
				startActivity(intent);
			}
			});
}
}