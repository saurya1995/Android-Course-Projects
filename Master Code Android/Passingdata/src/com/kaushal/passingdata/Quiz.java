package com.kaushal.passingdata;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Quiz extends Activity{
    String name;
    TextView display;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.quiz);
		display=(TextView)findViewById(R.id.tvdisplay);
		Bundle receive=new Bundle();
		receive=getIntent().getExtras();
		name=receive.getString("key");
		display.setText("Welcome "+name);
		
	}
    
}
