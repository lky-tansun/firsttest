package com.example.demo1;


import java.util.ArrayList;

import com.example.sqlite2.DBHelper;
import com.example.sqlite2.Srlb;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;


public class FourteenthActivity extends Activity{
	private RadioButton btn2;
	private EditText et1,et2,et3;
	private TextView list;
	private DBHelper Dao;
	private Button btn3,btn4,btn5,btn6;
	@Override
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.test26);
		PublicWay.activityList.add(this);
		Dao =new DBHelper(this);
		final int size=Dao.Size();
		btn2=(RadioButton)findViewById(R.id.zc);
		btn3=(Button)findViewById(R.id.btn1);
		btn4=(Button)findViewById(R.id.btn2);
		btn5=(Button)findViewById(R.id.btn3);
		btn6=(Button)findViewById(R.id.btn4);
		MyListener listener = new MyListener();
        btn2.setOnClickListener(listener);
        list=(TextView) findViewById(R.id.list);
        et1=(EditText) findViewById(R.id.et1);
        et2=(EditText) findViewById(R.id.et2);
        et3=(EditText) findViewById(R.id.et3);
        list.setText("");
        DBHelper helper=new DBHelper(FourteenthActivity.this);
        final  ArrayList<Srlb> srlbList=helper.find();
        list.setText("序号" + "                  "+"收入名称" + "                  " + "收入说明" + "\n");
        for(int i = 0; i < size; i++)
        {   
        	Srlb srlb = srlbList.get(i);
        	
            list.setText(list.getText().toString() +srlb.getid()
            		+"                              "+ srlb.getsrmc() + "                              " 
            		+ srlb.getsrsm()+ "\n");
            //给View做tag标记
        }
        btn3.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View arg0)
            {
            	String mc = et1.getText()+"";
            	if(mc.equals(null) || mc ==""||mc==null){
            		Toast.makeText(FourteenthActivity.this, "收入名称不能为空", Toast.LENGTH_SHORT).show();
            	}else{
                Srlb info=null;
                DBHelper helper=new DBHelper(FourteenthActivity.this);
                info=new Srlb();
                info.setsrmc(et1.getText().toString());
                info.setsrsm(et2.getText().toString());
                helper.insert(info);
                et1.setText("");
                et2.setText("");
                Toast.makeText(FourteenthActivity.this, "添加成功!", Toast.LENGTH_SHORT).show();
            }}
        });
        btn4.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View arg0)
            {
            	Intent intent = new Intent(FourteenthActivity.this,FourteenthActivity.class);
				startActivity(intent);
            }
        });
        btn5.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(FourteenthActivity.this,SecondActivity.class);
				startActivity(intent);
			}
			});
        btn6.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Dao.delete(et3.getText().toString());
				Toast.makeText(FourteenthActivity.this, "删除成功！",
						Toast.LENGTH_SHORT).show();
			}
			});
	}
	public class MyListener implements View.OnClickListener{
		@Override
		public void onClick(View v){
		if (btn2.isChecked()) { 
			Intent intent = new Intent(FourteenthActivity.this,EighthActivity.class);
			startActivity(intent);
          } 
	}
	}
	}
