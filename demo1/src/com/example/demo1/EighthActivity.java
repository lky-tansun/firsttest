package com.example.demo1;


import java.util.ArrayList;

import com.example.sqlite3.DBHelper;
import com.example.sqlite3.Zclb;

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


public class EighthActivity extends Activity{
	private RadioButton btn1;
	private EditText et1,et2,et3;
	private TextView list;
	private DBHelper Dao;
	private Button btn3,btn4,btn5,btn6;
	@Override
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.test27);
		PublicWay.activityList.add(this);
		Dao =new DBHelper(this);
		final int size=Dao.Size();
		btn1=(RadioButton)findViewById(R.id.sr);
		btn3=(Button)findViewById(R.id.btn1);
		btn4=(Button)findViewById(R.id.btn2);
		btn5=(Button)findViewById(R.id.btn3);
		btn6=(Button)findViewById(R.id.btn4);
		MyListener listener = new MyListener();
        btn1.setOnClickListener(listener);
        list=(TextView) findViewById(R.id.list);
        et1=(EditText) findViewById(R.id.et1);
        et2=(EditText) findViewById(R.id.et2);
        et3=(EditText) findViewById(R.id.et3);
        list.setText("");
        DBHelper helper=new DBHelper(EighthActivity.this);
        final  ArrayList<Zclb> zclbList=helper.find();
        list.setText("序号" + "                  "+"支出名称" + "                  " + "支出说明" + "\n");
        for(int i = 0; i < size; i++)
        {   
        	Zclb zclb = zclbList.get(i);
        	
            list.setText(list.getText().toString() +zclb.getid()
            		+"                              "+ zclb.getzcmc() + "                              " 
            		+ zclb.getzcsm()+ "\n");
            //给View做tag标记
        }
        btn3.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View arg0)
            {
            	String mc = et1.getText()+"";
            	if(mc.equals(null) || mc ==""||mc==null){
            		Toast.makeText(EighthActivity.this, "支出名称不能为空", Toast.LENGTH_SHORT).show();
            	}else{
                Zclb info=null;
                DBHelper helper=new DBHelper(EighthActivity.this);
                info=new Zclb();
                info.setzcmc(et1.getText().toString());
                info.setzcsm(et2.getText().toString());
                helper.insert(info);
                et1.setText("");
                et2.setText("");
                Toast.makeText(EighthActivity.this, "添加成功!", Toast.LENGTH_SHORT).show();
            }}
        });
        btn4.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View arg0)
            {
            	Intent intent = new Intent(EighthActivity.this,EighthActivity.class);
				startActivity(intent);
            }
        });
        btn5.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(EighthActivity.this,SecondActivity.class);
				startActivity(intent);
			}
			});
        btn6.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Dao.delete(et3.getText().toString());
				Toast.makeText(EighthActivity.this, "删除成功！",
						Toast.LENGTH_SHORT).show();
			}
			});
	}public class MyListener implements View.OnClickListener{
			@Override
			public void onClick(View v){
			if (btn1.isChecked()) { 
				Intent intent = new Intent(EighthActivity.this,FourteenthActivity.class);
				startActivity(intent);
	          } 
		}
		}
		}
