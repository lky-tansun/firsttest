package com.example.demo1;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class NinthActivity extends Activity {
	Button jia,jian,cheng,chu,deng;
	private EditText txt1;
	private EditText txt2;
	private String x;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test23);
        PublicWay.activityList.add(this);
        deng= (Button)findViewById(R.id.deng);
        jia= (Button)findViewById(R.id.jia);
        jian= (Button)findViewById(R.id.jian);
        cheng= (Button)findViewById(R.id.cheng);
        chu= (Button)findViewById(R.id.chu);
        txt1 = (EditText)findViewById(R.id.num1);
        txt2 = (EditText)findViewById(R.id.num2); 
        MyListener listener = new MyListener();
        jia.setOnClickListener(listener);
		jian.setOnClickListener(listener);
		cheng.setOnClickListener(listener);
		chu.setOnClickListener(listener);
		deng.setOnClickListener(listener);
        }
        public class MyListener implements View.OnClickListener{
    		@Override
    		public void onClick(View v){
    			switch(v.getId()){
    			case R.id.jia:
    				x="+";
    				break;
    			case R.id.jian:
    				x="-";
    				break;
    			case R.id.cheng:
    				x="*";
    				break;
    			case R.id.chu:
    				x="/";
    				break;
    			case R.id.deng:
    				String a=txt1.getText().toString();
    			    String b=txt2.getText().toString();
    			    float num1 = Integer.valueOf(a).intValue();
    		        float num2 = Integer.valueOf(b).intValue();
    		        if (x=="+"){
    		        	num1 +=num2;  
    		        }
    		        else if (x=="-"){
    		        	num1 -=num2;
    		        }
    		        else if (x=="*"){
    		        	num1 *=num2;
    		        }
    		        else if (x=="/"){
    		        	num1 /=num2;
    		        }
    				a = String.valueOf(num1);
    			    TextView textView = (TextView) findViewById(R.id.result);
    			    textView.setText(a);
    				break;
    			}
    	}
        }
            
	}