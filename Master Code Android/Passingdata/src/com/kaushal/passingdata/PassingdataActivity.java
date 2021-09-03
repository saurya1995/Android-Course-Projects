package com.kaushal.passingdata;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PassingdataActivity extends Activity {
	Button ok;
	EditText name;
	String data;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ok=(Button) findViewById(R.id.bok);
        name=(EditText) findViewById(R.id.etname);
        ok.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				data=name.getText().toString();
				Intent i=new Intent(getApplicationContext(),Quiz.class);
				Bundle packet=new Bundle();
				packet.putString("key", data);
				i.putExtras(packet);
				startActivity(i);
			}
		});
    }
    
}