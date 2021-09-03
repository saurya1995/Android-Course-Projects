package com.kaushal.optionmenu;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class OptionsMenuActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		MenuInflater inflater =getMenuInflater();
		inflater.inflate(R.menu.optionsmenu, menu);
		
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch(item.getItemId()){
		case R.id.iauthor:
			Toast.makeText(getApplicationContext(), "Hi, It's me Kaushal", Toast.LENGTH_LONG).show();
			break;
		case R.id.iprefer:
			Toast.makeText(getApplicationContext(), "Preferences Clicked", Toast.LENGTH_LONG).show();
			break;
		case R.id.iexit:
			Toast.makeText(getApplicationContext(), "Exit Pressed", Toast.LENGTH_LONG).show();
			break;
		}
		
		return super.onOptionsItemSelected(item);
	}
    
}