package com.services;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ServicesActivity extends Activity {
    /** Called when the activity is first created. */
   Button  buttonStart;
   Button buttonStop;
	
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    
    buttonStart = (Button) findViewById(R.id.buttonstart);
    buttonStop = (Button) findViewById(R.id.buttonstop);

    buttonStart.setOnClickListener(new OnClickListener() {
		
		
		public void onClick(View v) {
			// TODO Auto-generated method stub
			 Log.d("tag", "onClick: starting srvice");
		      startService(new Intent(ServicesActivity.this,serviceback.class));
		      }
	});
    buttonStop.setOnClickListener(new OnClickListener() {
		
		
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Log.d("TAG", "onClick: stopping srvice");
		      stopService(new Intent(ServicesActivity.this,serviceback.class));
		}
	});
  }

 
}