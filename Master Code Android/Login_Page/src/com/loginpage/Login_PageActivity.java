package com.loginpage;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class Login_PageActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        final EditText e1,e2;
        Button b1;
        final TextView t1;
        e1=(EditText)findViewById(R.id.editText1);
        e2=(EditText)findViewById(R.id.editText2);
        b1=(Button)findViewById(R.id.button1);
        t1=(TextView)findViewById(R.id.textView1);
        
        b1.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
			if(e1.getText().toString().trim().equals("Android")&& e2.getText().toString().trim().equals("android"))
			{
				 setContentView(R.layout.intent);
				t1.setText("Login Successfull !!!");
				
			}
			else{
				t1.setText("Invalid Name / Password !!!");
			}
				
			}
		});
        
    }
}