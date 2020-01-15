package com.example.demo1;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.example.sqlite3.DBHelper;
import com.example.sqlite3.Zclb;
import com.example.sqlite5.DBHelper2;
import com.example.sqlite5.Zc;

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
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class FifthActivity extends Activity{
    private CheckBox ckb1,ckb2,ckb3;
    private Button btn3,btn4;
    private EditText et1,et2;
    private Spinner sp;
    private TextView tv,tv1,tv2;
    private ArrayList<String> arraylist = new ArrayList<String>();
    private String[] str;
    private String TypeResult;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.test19);
		PublicWay.activityList.add(this);
		tv=(TextView) findViewById(R.id.tv);
		btn3=(Button)findViewById(R.id.login);
		btn4=(Button)findViewById(R.id.quit);
		sp=(Spinner)findViewById(R.id.spinner);
		et1=(EditText)findViewById(R.id.zcje1);
		et2=(EditText)findViewById(R.id.zcje2);
		ckb1=(CheckBox)findViewById(R.id.ckb1);
		ckb2=(CheckBox)findViewById(R.id.ckb2);
		ckb3=(CheckBox)findViewById(R.id.ckb3);
		tv1=(TextView)findViewById(R.id.dateview);
		tv2=(TextView)findViewById(R.id.dateview2);
		if(tv1.getText().equals("")||tv2.getText().equals("")){
	    	 SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    	//获取当前时间
	    	Date date = new Date(System.currentTimeMillis());
	    	tv1.setText(simpleDateFormat.format(date));
	    	tv2.setText(simpleDateFormat.format(date));
	     }
		ArrayAdapter<String> adapter2;
		int Size =new DBHelper(FifthActivity.this).Size();
		List<Zclb> list=new DBHelper(FifthActivity.this).find();
		for(int i=0;i<Size;i++) {
			arraylist.add(list.get(i).getzcmc());
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
	   tv1.setOnClickListener(new OnClickListener() {
		           @Override
		           public void onClick(View v) {
		               AlertDialog.Builder localBuilder = new AlertDialog.Builder(FifthActivity.this);
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
               AlertDialog.Builder localBuilder = new AlertDialog.Builder(FifthActivity.this);
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
		btn3.setOnClickListener(new View.OnClickListener()
      {
		  int Size =new DBHelper2(FifthActivity.this).Size();
		  List<Zc> list=new DBHelper2(FifthActivity.this).find();
		  
          @Override
          public void onClick(View arg0)
          {
        	  tv.setText("");
        	  if(ckb1.isChecked()){
        		  if(ckb2.isChecked()){
        			  if(ckb3.isChecked()){
        				  if(et1.getText().toString()==null||et1.getText().toString().equals("")
  			        			|| et2.getText().toString()==null||et2.getText().toString().equals("")){
  			        		 Toast.makeText(FifthActivity.this, "查询金额不能为空", Toast.LENGTH_SHORT).show();
  			        	 }else{
        				  for(int i=0;i<Size;i++){
	        					    int jg1= list.get(i).getDate().compareTo(tv1.getText().toString());
	  					            int jg2= tv2.getText().toString().compareTo(list.get(i).getDate());
	  					            int jg3= Integer.valueOf(list.get(i).getZcje()).intValue()-Integer.valueOf(et1.getText().toString()).intValue();
			                        int jg4= Integer.valueOf(et2.getText().toString()).intValue()-Integer.valueOf(list.get(i).getZcje()).intValue();
								    if(jg1>0&&jg2>0&&jg3>0&&jg4>0&&list.get(i).getZclb().equals(TypeResult)){
		        						  tv.setText(tv.getText().toString() + list.get(i).getDate() + "      " + list.get(i).getZclb() + "      " + list.get(i).getZcje() + "      " + list.get(i).getBz()+"\n");
		        							Toast.makeText(FifthActivity.this, "查询数据如下", Toast.LENGTH_SHORT).show();	
		        					}}
    					}
        			  }else{
        				  for(int i=0;i<Size;i++){
        					  int jg1= list.get(i).getDate().compareTo(tv1.getText().toString());
  					          int jg2= tv2.getText().toString().compareTo(list.get(i).getDate());
							    if(jg1>0&&jg2>0&&list.get(i).getZclb().equals(TypeResult)){
	        						  tv.setText(tv.getText().toString() + list.get(i).getDate() + "      " + list.get(i).getZclb() + "      " + list.get(i).getZcje() + "      " + list.get(i).getBz()+"\n");
	        							Toast.makeText(FifthActivity.this, "查询数据如下", Toast.LENGTH_SHORT).show();	
	        					}
					}
        			  }
        		  }else{
        			  if(ckb3.isChecked()){
        				  if(et1.getText().toString()==null||et1.getText().toString().equals("")
  			        			|| et2.getText().toString()==null||et2.getText().toString().equals("")){
  			        		 Toast.makeText(FifthActivity.this, "查询金额不能为空", Toast.LENGTH_SHORT).show();
  			        	 }else{
        				  for(int i=0;i<Size;i++){
        					    int jg3= Integer.valueOf(list.get(i).getZcje()).intValue()-Integer.valueOf(et1.getText().toString()).intValue();
		                        int jg4= Integer.valueOf(et2.getText().toString()).intValue()-Integer.valueOf(list.get(i).getZcje()).intValue();
							    if(jg3>0&&jg4>0&&list.get(i).getZclb().equals(TypeResult)){
	        						  tv.setText(tv.getText().toString() + list.get(i).getDate() + "      " + list.get(i).getZclb() + "      " + list.get(i).getZcje() + "      " + list.get(i).getBz()+"\n");
	        							Toast.makeText(FifthActivity.this, "查询数据如下", Toast.LENGTH_SHORT).show();	
	        					}}
					}
        			  }else{
        				  for(int i=0;i<Size;i++){
								    if(list.get(i).getZclb().equals(TypeResult)){
		        						  tv.setText(tv.getText().toString() + list.get(i).getDate() + "      " + list.get(i).getZclb() + "      " + list.get(i).getZcje() + "      " + list.get(i).getBz()+"\n");
		        							Toast.makeText(FifthActivity.this, "查询数据如下", Toast.LENGTH_SHORT).show();	
		        					}
    					      }
        			  }
        		  }
        	  }
        	  else{
        		  if(ckb2.isChecked()){
        			         if(ckb3.isChecked()){
        			        	 if(et1.getText().toString()==null||et1.getText().toString().equals("")
         			        			|| et2.getText().toString()==null||et2.getText().toString().equals("")){
         			        		 Toast.makeText(FifthActivity.this, "查询金额不能为空", Toast.LENGTH_SHORT).show();
         			        	 }else{
        			        	 for(int i=0;i<Size;i++){
   	        					  int jg1= list.get(i).getDate().compareTo(tv1.getText().toString());
   	  					          int jg2= tv2.getText().toString().compareTo(list.get(i).getDate());
   	  					          int jg3= Integer.valueOf(list.get(i).getZcje()).intValue()-Integer.valueOf(et1.getText().toString()).intValue();
		                          int jg4= Integer.valueOf(et2.getText().toString()).intValue()-Integer.valueOf(list.get(i).getZcje()).intValue();
   								    if(jg1>0&&jg2>0&&jg3>0&&jg4>0){
   		        						  tv.setText(tv.getText().toString() + list.get(i).getDate() + "      " + list.get(i).getZclb() + "      " + list.get(i).getZcje() + "      " + list.get(i).getBz()+"\n");
   		        							Toast.makeText(FifthActivity.this, "查询数据如下", Toast.LENGTH_SHORT).show();	
   		        					}}
       				         	}
	        					}else{
	        						for(int i=0;i<Size;i++){
	  	        					  int jg1= list.get(i).getDate().compareTo(tv1.getText().toString());
	  	  					          int jg2= tv2.getText().toString().compareTo(list.get(i).getDate());
	  								    if(jg1>0&&jg2>0){
	  		        						  tv.setText(tv.getText().toString() + list.get(i).getDate() + "      " + list.get(i).getZclb() + "      " + list.get(i).getZcje() + "      " + list.get(i).getBz()+"\n");
	  		        							Toast.makeText(FifthActivity.this, "查询数据如下", Toast.LENGTH_SHORT).show();	
	  		        					}
	        					}
							
	        					}
        		    }else{
        			         if(ckb3.isChecked()){
        			        	 if(et1.getText().toString()==null||et1.getText().toString().equals("")
        			        			|| et2.getText().toString()==null||et2.getText().toString().equals("")){
        			        		 Toast.makeText(FifthActivity.this, "查询金额不能为空", Toast.LENGTH_SHORT).show();
        			        	 }else{
        				                 for(int i=0;i<Size;i++) {     				                	
        				             	    int jg3= Integer.valueOf(list.get(i).getZcje()).intValue()-Integer.valueOf(et1.getText().toString()).intValue();
  					                        int jg4= Integer.valueOf(et2.getText().toString()).intValue()-Integer.valueOf(list.get(i).getZcje()).intValue();
        			            			if(jg3>0&&jg4>0){
     				        	     		tv.setText(tv.getText().toString() + list.get(i).getDate() + "      " + list.get(i).getZclb() + "      " + list.get(i).getZcje() + "      " + list.get(i).getBz()+"\n");
        						         	Toast.makeText(FifthActivity.this, "查询数据如下", Toast.LENGTH_SHORT).show();	
        			                    	}	
        			        			}}
        			         }else{
        				                tv.setText("");
        	                         DBHelper2 helper=new DBHelper2(FifthActivity.this);
        	                        ArrayList<Zc> zcList=helper.find();
        	                        for(Zc info : zcList)
        	                       {
        	                           tv.setText(tv.getText().toString() + info.getDate() + "      " + info.getZclb() + "      " + info.getZcje() + "      " + info.getBz()+"\n");
        	                          }
        			  }
        		  }
        	  }
        	  
          }
      });
		btn4.setOnClickListener(new View.OnClickListener()
	      {
	          @Override
	          public void onClick(View arg0)
	          {
		Intent intent = new Intent(FifthActivity.this,SecondActivity.class);
		startActivity(intent);
	          }  });        
	}

}