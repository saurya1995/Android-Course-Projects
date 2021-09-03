package com.simpleintent;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class SecondButtonActivity extends Activity{
EditText e1;
Button b1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.secondbutton);
		e1=(EditText)findViewById(R.id.eeee);
		b1=(Button)findViewById(R.id.buttonona);
		
		
		try {
			File myFile = new File("/sdcard/mysdfile.txt");
			FileInputStream fIn = new FileInputStream(myFile);
			BufferedReader myReader = new BufferedReader(
					new InputStreamReader(fIn));
			String aDataRow = "";
			String aBuffer = "";
			while ((aDataRow = myReader.readLine()) != null) {
				aBuffer += aDataRow + "\n";
			}
			e1.setText(aBuffer);
			myReader.close();
		
		} catch (Exception e) {
			Toast.makeText(getBaseContext(), e.getMessage(),
					Toast.LENGTH_SHORT).show();
		}	
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
							"Text Modified on 'mysdfile.txt'",
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
