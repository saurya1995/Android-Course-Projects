package com.lifecycle;

import android.app.Activity;
import android.os.Bundle;


import android.widget.Toast;

public class LifecycleActivity extends Activity {

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Toast.makeText(getBaseContext(), "In the onCreate() event",
				Toast.LENGTH_SHORT).show();
       
    }

	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		Toast.makeText(getBaseContext(), "In the onStart() event",
				Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
		Toast.makeText(getBaseContext(), "In the onRestart() event",
				Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Toast.makeText(getBaseContext(), "In the onResume() event",
				Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		Toast.makeText(getBaseContext(), "In the onPause() event",
				Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		Toast.makeText(getBaseContext(), "In the onStop() event",
				Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Toast.makeText(getBaseContext(), "In the onDestroy() event",
				Toast.LENGTH_SHORT).show();}
	
	
	
	
    
}