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
	// ���ݿ������
	private UserDao userDao;
	//���Բ���
	private LinearLayout linearLayout1;
	//���ذ�ť
	private Button btn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.test25);
		PublicWay.activityList.add(this);
		// ע�����
		userDao = new UserDao(this);
		btn = (Button) findViewById(R.id.btn);
		linearLayout1 = (LinearLayout) findViewById(R.id.linearLayout1);
		//����û���������������ʾ
		int userSize = userDao.dbGetUserSize();
		if (userSize > 0) {
			ArrayList<User> userList = userDao.dbQueryAll();//������е������û��ŵ�һ��ArrayList��
			TableLayout tableLayout1 = new TableLayout(this);//�½�һ����񲼾�
			tableLayout1.setStretchAllColumns(true);//�Զ���ȣ�ʹ����ں���ռ��100%
			//��ӡ��ͷ
			TableRow tableRow = new TableRow(this);//�½�һ��
			
			TextView textView = new TextView(this);//�½�һ��TextView
			textView.setTextSize(24);//��������
			textView.setText("�û���");
			tableRow.addView(textView);//�ŵ����У��Զ�����һ����Ԫ��
			
			textView = new TextView(this);
			textView.setTextSize(24);
			textView.setText("�Ա�");
			tableRow.addView(textView);
			
			textView = new TextView(this);
			textView.setTextSize(24);
			textView.setText("����");
			tableRow.addView(textView);
			
			textView = new TextView(this);
			textView.setTextSize(24);
			textView.setText("��ַ");
			tableRow.addView(textView);
			
			textView = new TextView(this);
			textView.setTextSize(24);
			textView.setText("����");
			tableRow.addView(textView);
			
			// �½�����TableRow��ӵ����TableLayout֮��
			tableLayout1.addView(tableRow, new TableLayout.LayoutParams(
					ViewGroup.LayoutParams.WRAP_CONTENT,
					ViewGroup.LayoutParams.MATCH_PARENT));
			
			//��ӡ�û���Ϣ
			for (int i = 0; i < userSize; i++) {
				User user = userList.get(i);
				// һ���û�ռ��һ��
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

				// �½���TableRow��ӵ�TableLayout
				tableLayout1.addView(tableRow, new TableLayout.LayoutParams(
						ViewGroup.LayoutParams.WRAP_CONTENT,
						ViewGroup.LayoutParams.MATCH_PARENT));
 
			}
			linearLayout1.addView(tableLayout1, 2);
		}
		//����MainActivity
		btn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(ThirteenthActivity.this,TenthActivity.class);
				startActivity(intent);
			}
			});
 
	}}