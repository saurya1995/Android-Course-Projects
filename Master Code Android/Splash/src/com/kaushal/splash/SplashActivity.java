package com.kaushal.splash;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class SplashActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.main);
        Thread timer= new Thread(){
        	public void run(){
        		try{
        			sleep(5000);
        		}catch(InterruptedException e){
        			e.printStackTrace();
        		}finally{
        			Intent i=new Intent(getApplicationContext(),Main2.class);
        			startActivity(i);
        		}
        	}
        };timer.start();
    }
}