package com.simpleintent;

import java.io.File;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SimpleIntentActivity extends Activity {
    /** Called when the activity is first created. */
    Button b1,b2,b3;
    
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        b1=(Button)findViewById(R.id.button1);
        b2=(Button)findViewById(R.id.button2);
        b3=(Button)findViewById(R.id.button3);
        
        
        
        b1.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				File file = new File("/sdcard/mysdfile.txt");
				if(file.exists())
				{
					Toast.makeText(getBaseContext(), "File already exists. Delete the file first.",
							Toast.LENGTH_SHORT).show();
				}else{
					Intent intent=new Intent(getApplicationContext(), SecondActivity.class);
					startActivity(intent);
					
			}
				
			}
		});
        
        b2.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				File file = new File("/sdcard/mysdfile.txt");
				if(file.exists())
				{
					Intent intent=new Intent(getApplicationContext(), SecondButtonActivity.class);
					startActivity(intent);
						
				}
				else{
					Toast.makeText(getBaseContext(), "File does not exists. Create a new File.",
							Toast.LENGTH_SHORT).show();
				}
			
				
			}
		});
        
        
        
        
        b3.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				File file = new File("/sdcard/mysdfile.txt");
				file.delete();	
				if(file.exists())
				{
					Toast.makeText(getBaseContext(), "Error : File is not deleted.",
							Toast.LENGTH_SHORT).show();
				}else{
				Toast.makeText(getBaseContext(), "File Deleted Sucessfully !!!",
						Toast.LENGTH_SHORT).show();
			}}
		});
        
        
    }
}