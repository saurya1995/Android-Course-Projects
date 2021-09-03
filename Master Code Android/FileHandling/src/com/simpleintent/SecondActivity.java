package com.simpleintent;

import java.io.*;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class SecondActivity extends Activity {
EditText e1;
Button b1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.second);
		e1=(EditText)findViewById(R.id.txtData);
		b1=(Button)findViewById(R.id.buttons);
		
		b1.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				
				try {
					File myFile = new File("/sdcard/mysdfile.txt");
					myFile.createNewFile();
					FileOutputStream fOut = new FileOutputStream(myFile);
					OutputStreamWriter myOutWriter = 
											new OutputStreamWriter(fOut);
					myOutWriter.append(e1.getText());
					myOutWriter.close();
					fOut.close();
					Toast.makeText(getBaseContext(),
							"Done writing SD 'mysdfile.txt'",
							Toast.LENGTH_SHORT).show();
				} catch (Exception e) {
					Toast.makeText(getBaseContext(), e.getMessage(),
							Toast.LENGTH_SHORT).show();
				}
				Intent intent=new Intent(getApplicationContext(), SimpleIntentActivity.class);
				startActivity(intent);
					
			}
			
			
		});
		
	}

}
