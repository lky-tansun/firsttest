package com.example.demo1;

import java.util.ArrayList;

import com.example.sqlite.UserDao;
import com.example.sqlite.User;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
public class ThirteenthActivity extends Activity {
	// 数据库操作类
	private UserDao userDao;
	//线性布局
	private LinearLayout linearLayout1;
	//返回按钮
	private Button btn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.test25);
		PublicWay.activityList.add(this);
		// 注册组件
		userDao = new UserDao(this);
		btn = (Button) findViewById(R.id.btn);
		linearLayout1 = (LinearLayout) findViewById(R.id.linearLayout1);
		//求出用户的数量，并且显示
		int userSize = userDao.dbGetUserSize();
		if (userSize > 0) {
			ArrayList<User> userList = userDao.dbQueryAll();//查出表中的所有用户放到一个ArrayList中
			TableLayout tableLayout1 = new TableLayout(this);//新建一个表格布局
			tableLayout1.setStretchAllColumns(true);//自动宽度，使表格在横向占据100%
			//打印表头
			TableRow tableRow = new TableRow(this);//新建一行
			
			TextView textView = new TextView(this);//新建一个TextView
			textView.setTextSize(24);//设置字体
			textView.setText("用户名");
			tableRow.addView(textView);//放到行中，自动增加一个单元格
			
			textView = new TextView(this);
			textView.setTextSize(24);
			textView.setText("性别");
			tableRow.addView(textView);
			
			textView = new TextView(this);
			textView.setTextSize(24);
			textView.setText("生日");
			tableRow.addView(textView);
			
			textView = new TextView(this);
			textView.setTextSize(24);
			textView.setText("地址");
			tableRow.addView(textView);
			
			textView = new TextView(this);
			textView.setTextSize(24);
			textView.setText("邮箱");
			tableRow.addView(textView);
			
			// 新建的行TableRow添加到表格TableLayout之中
			tableLayout1.addView(tableRow, new TableLayout.LayoutParams(
					ViewGroup.LayoutParams.WRAP_CONTENT,
					ViewGroup.LayoutParams.MATCH_PARENT));
			
			//打印用户信息
			for (int i = 0; i < userSize; i++) {
				User user = userList.get(i);
				// 一个用户占据一行
				tableRow = new TableRow(this);
				
				textView = new TextView(this);
				textView.setTextSize(12);
				textView.setText(user.getUsername());
				tableRow.addView(textView);
				
				textView = new TextView(this);
				textView.setTextSize(12);
				textView.setText(user.getsex());
				tableRow.addView(textView);
				
				textView = new TextView(this);
				textView.setTextSize(12);
				textView.setText(user.getbirthday());
				tableRow.addView(textView);
				
				textView = new TextView(this);
				textView.setTextSize(12);
				textView.setText(user.getplace());
				tableRow.addView(textView);
				
				textView = new TextView(this);
				textView.setTextSize(12);
				textView.setText(user.getemail());
				tableRow.addView(textView);

				// 新建的TableRow添加到TableLayout
				tableLayout1.addView(tableRow, new TableLayout.LayoutParams(
						ViewGroup.LayoutParams.WRAP_CONTENT,
						ViewGroup.LayoutParams.MATCH_PARENT));
 
			}
			linearLayout1.addView(tableLayout1, 2);
		}
		//返回MainActivity
		btn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(ThirteenthActivity.this,TenthActivity.class);
				startActivity(intent);
			}
			});
 
	}}