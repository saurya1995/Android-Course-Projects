package com.implicitintent;

import android.app.Activity;
import android.os.Bundle;
//import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
//import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
//import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class ImplicitIntentActivity extends Activity {
    /** Called when the activity is first created. */
	Button read,call,msg;
	EditText phone;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        read=(Button)findViewById(R.id.read);
        call=(Button)findViewById(R.id.call);
        msg=(Button)findViewById(R.id.sms);
        phone=(EditText)findViewById(R.id.phone);
        read.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent read1=new Intent();
				read1.setAction(android.content.Intent.ACTION_VIEW);
				read1.setData(ContactsContract.Contacts.CONTENT_URI);
				startActivity(read1);	
			}
		});
        call.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent call1=new Intent();
				call1.setAction(android.content.Intent.ACTION_CALL).setData(Uri.parse("tel:"+phone.getText()));
				startActivity(call1);	
			}
		});
        msg.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent sms=new Intent();
				sms.setAction(android.content.Intent.ACTION_VIEW);
				sms.setData(Uri.parse("smsto:"+phone.getText().toString()));
				startActivity(sms);	
			}
		});
    }
}