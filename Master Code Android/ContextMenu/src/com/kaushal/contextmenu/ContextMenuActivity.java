package com.kaushal.contextmenu;

import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ContextMenuActivity extends Activity {
	TextView tv1,tv2,tv3,tv4;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        tv1=(TextView)findViewById(R.id.tv1);
        tv2=(TextView)findViewById(R.id.tv2);
        tv3=(TextView)findViewById(R.id.tv3);
        tv4=(TextView)findViewById(R.id.tv4);
        registerForContextMenu(tv1);
        registerForContextMenu(tv2);
        registerForContextMenu(tv3);
        registerForContextMenu(tv4);
        
    }
    
    
    @Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		// TODO Auto-generated method stub
		super.onCreateContextMenu(menu, v, menuInfo);
		MenuInflater inflater=getMenuInflater();
		inflater.inflate(R.menu.contextmenu, menu);
	}
    
    
	@Override
	public boolean onContextItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		
		switch(item.getItemId()){
		case R.id.iedit:
			Toast.makeText(getApplicationContext(), "Edit Pressed", Toast.LENGTH_LONG).show();
			break;
		case R.id.idelete:
			Toast.makeText(getApplicationContext(), "Delete Pressed", Toast.LENGTH_LONG).show();
			break;
		case R.id.ishare:
			Toast.makeText(getApplicationContext(), "Share Pressed", Toast.LENGTH_LONG).show();
			break;
		
		}
		return true;
	}

	
    
}