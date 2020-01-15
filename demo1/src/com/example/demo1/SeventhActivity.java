package com.example.demo1;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.example.sqlite2.DBHelper;
import com.example.sqlite2.Srlb;
import com.example.sqlite4.DBHelper2;
import com.example.sqlite4.Sr;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class SeventhActivity extends Activity{
	RadioButton btn3;
	private Button btn1,btn2;
	private TextView tv,tv1,tv2;
	private Spinner sp;
	private CheckBox ckb1,ckb2;
    private ArrayList<String> arraylist = new ArrayList<String>();
    private String[] str;
    private String TypeResult;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.test21);
		PublicWay.activityList.add(this);
		findView();
	}
	private void findView() {
		btn1=(Button)findViewById(R.id.login);
		btn2=(Button)findViewById(R.id.quit);
		btn3=(RadioButton)findViewById(R.id.zc);
		tv=(TextView)findViewById(R.id.tv);
		tv1=(TextView)findViewById(R.id.dateview);
		tv2=(TextView)findViewById(R.id.dateview2);
		sp=(Spinner)findViewById(R.id.spinner);
		ckb1=(CheckBox)findViewById(R.id.ckb1);
		ckb2=(CheckBox)findViewById(R.id.ckb2);
		MyListener listener = new MyListener();
        btn3.setOnClickListener(listener);
        ArrayAdapter<String> adapter2;
		int Size =new DBHelper(SeventhActivity.this).Size();
		List<Srlb> list=new DBHelper(SeventhActivity.this).find();
		for(int i=0;i<Size;i++) {
			arraylist.add(list.get(i).getsrmc());
		}
		str = arraylist.toArray(new String[0]);
	        adapter2=new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, str);
	        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	        sp.setAdapter(adapter2);
	        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
	        	@Override
	        	public void onItemSelected(AdapterView<?> parent,View arg1,int pos,long id){
	        		TypeResult = parent.getItemAtPosition(pos).toString();
	        		
	        	}
	        	@Override
	        	public void onNothingSelected(AdapterView<?> arg0){
	        		
	        	}
			});
	   if(tv1.getText().equals("")||tv2.getText().equals("")){
		    	 SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		    	//获取当前时间
		    	Date date = new Date(System.currentTimeMillis());
		    	tv1.setText(simpleDateFormat.format(date));
		    	tv2.setText(simpleDateFormat.format(date));
		     }
	   tv1.setOnClickListener(new OnClickListener() {
           @Override
           public void onClick(View v) {
               AlertDialog.Builder localBuilder = new AlertDialog.Builder(SeventhActivity.this);
               localBuilder.setTitle("选择时间");
               //
               final LinearLayout layout_alert= (LinearLayout) getLayoutInflater().inflate(R.layout.test28, null);
               localBuilder.setView(layout_alert);
               localBuilder.setPositiveButton("确定", new DialogInterface.OnClickListener()
               {
                   public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                   {
                       DatePicker datepicker1= (DatePicker) layout_alert.findViewById(R.id.in_datepicker);
                       int y=datepicker1.getYear();
                       int m=datepicker1.getMonth()+1;
                       int d=datepicker1.getDayOfMonth();
                       System.out.println("y:"+y+" m:"+m+" d:"+d);
                       tv1.setText(y+"-"+m+"-"+d); //  获取时间
                   }
               }).setNegativeButton("取消", new DialogInterface.OnClickListener()
               {
                   public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                   {
 
                   }
               }).create().show();
           }
       });
tv2.setOnClickListener(new OnClickListener() {
   @Override
   public void onClick(View v) {
       AlertDialog.Builder localBuilder = new AlertDialog.Builder(SeventhActivity.this);
       localBuilder.setTitle("选择时间");
       //
       final LinearLayout layout_alert= (LinearLayout) getLayoutInflater().inflate(R.layout.test28, null);
       localBuilder.setView(layout_alert);
       localBuilder.setPositiveButton("确定", new DialogInterface.OnClickListener()
       {
           public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
           {
               DatePicker datepicker1= (DatePicker) layout_alert.findViewById(R.id.in_datepicker);
               int y=datepicker1.getYear();
               int m=datepicker1.getMonth()+1;
               int d=datepicker1.getDayOfMonth();
               System.out.println("y:"+y+" m:"+m+" d:"+d);
               tv2.setText(y+"-"+m+"-"+d); //  获取时间
           }
       }).setNegativeButton("取消", new DialogInterface.OnClickListener()
       {
           public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
           {

           }
       }).create().show();
   }
});
btn1.setOnClickListener(new OnClickListener(){
	  int Size =new DBHelper2(SeventhActivity.this).Size();
	  List<Sr> list=new DBHelper2(SeventhActivity.this).find();
	 @Override
	   public void onClick(View v) {
		 tv.setText("");
		 float num2=0;
		 float num3=0;
		 float num4=0;
		 float num5=0;
		if(ckb1.isChecked()){
			if(ckb2.isChecked()){
				for(int i=0;i<Size;i++){
					int jg1= list.get(i).getDate().compareTo(tv1.getText().toString());
			        int jg2= tv2.getText().toString().compareTo(list.get(i).getDate());
				    if(list.get(i).getSrlb().equals(TypeResult)&&jg1>0&&jg2>0){
				    	float num1 = Integer.valueOf(list.get(i).getSrje()).intValue();
	                    num5+=num1;
	                    tv.setText("总收入金额为"+num5+"\n"); 				
	                    Toast.makeText(SeventhActivity.this, "查询数据如下", Toast.LENGTH_SHORT).show();	
					}
		      }
			}else{
				 for(int i=0;i<Size;i++){
					    if(list.get(i).getSrlb().equals(TypeResult)){
					    	float num1 = Integer.valueOf(list.get(i).getSrje()).intValue();
		                    num4+=num1;
		                    tv.setText("总收入金额为"+num4+"\n"); 				
		                    Toast.makeText(SeventhActivity.this, "查询数据如下", Toast.LENGTH_SHORT).show();	
 					}
			      }
			}
		}else{
			if(ckb2.isChecked()){
				for(int i=0;i<Size;i++){
					    int jg1= list.get(i).getDate().compareTo(tv1.getText().toString());
				        int jg2= tv2.getText().toString().compareTo(list.get(i).getDate());
					    if(jg1>0&&jg2>0){
					    	float num1 = Integer.valueOf(list.get(i).getSrje()).intValue();
		                    num3+=num1;
		                    tv.setText("总收入金额为"+num3+"\n");
		    		        Toast.makeText(SeventhActivity.this, "查询数据如下", Toast.LENGTH_SHORT).show();	
    					}
				}
			}else{
				for(int i=0;i<Size;i++) {
					float num1 = Integer.valueOf(list.get(i).getSrje()).intValue();
                    num2+=num1;
     	     		}
				tv.setText("总收入金额为"+num2+"\n");
		        Toast.makeText(SeventhActivity.this, "查询数据如下", Toast.LENGTH_SHORT).show();	
			}
		} 	 		 
	 }
});
btn2.setOnClickListener(new OnClickListener(){
	 @Override
	   public void onClick(View v) {
		 Intent intent = new Intent(SeventhActivity.this,SecondActivity.class);
			startActivity(intent);
	 }
});
	}
	public class MyListener implements View.OnClickListener{
		@Override
		public void onClick(View v){
		if (btn3.isChecked()) { 
			Intent intent = new Intent(SeventhActivity.this,EleventhActivity.class);
			startActivity(intent);
          } 
	}
	}
	}
	