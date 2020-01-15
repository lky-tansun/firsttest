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

public class MainActivity extends Activity implements OnClickListener{
	Button btn1,btn2,btn3;
	EditText e1,e2;
	private UserDao userDao;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.test14);
        findView();       
	}
	private void findView() {
		userDao = new UserDao(this);
		btn1=(Button) findViewById(R.id.login);
		btn2=(Button) findViewById(R.id.quit);
		btn3=(Button) findViewById(R.id.zhuce);
	    btn1.setOnClickListener(this);
	    e1=(EditText) findViewById(R.id.name);
		e2=(EditText) findViewById(R.id.password);
		PublicWay.activityList.add(this);
		btn2.setOnClickListener(new Button.OnClickListener(){
	    	@Override
	    	public void onClick(View v) {
	    	// TODO Auto-generated method stub
	    	finish();
	    	}
	    	});
		btn3.setOnClickListener(new Button.OnClickListener(){
	    	@Override
	    	public void onClick(View v) {
	    	// TODO Auto-generated method stub
	        Intent intent = new Intent(MainActivity.this,TwelfthActivity.class);
			startActivity(intent);
	    	}
	    	});
	}
	   public void onClick(View v) {
	   
		    String username = e1.getText()+"";
			String password = e2.getText()+"";
			if (username.equals(null) || username == ""
					|| password.equals(null) || password == "") {
				Toast.makeText(MainActivity.this, "用户名或密码不得为空！",
						Toast.LENGTH_SHORT).show();
			} else {
				User user = userDao.dbQueryOneByUsername(username);
				if (userDao.dbQueryOneByUsername(username) == null) {
					Toast.makeText(MainActivity.this, "此用户不存在！",
							Toast.LENGTH_SHORT).show();
				} else {
					if (!user.getPassword().equals(password)) {
						Toast.makeText(MainActivity.this, "密码错误！",
								Toast.LENGTH_SHORT).show();
					} else {
						Intent intent = new Intent(MainActivity.this,SecondActivity.class);
						startActivity(intent);
					}
				}
			}
			
    }
	   
}