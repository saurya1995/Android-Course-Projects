package asd.dsa;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;

public class AdditionActivity extends Activity {
	Button b1;
	EditText e1,e2;
	TextView tv;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        b1=(Button)findViewById(R.id.button1);
        e1=(EditText)findViewById(R.id.editText1);
        e2=(EditText)findViewById(R.id.editText2);
        tv=(TextView)findViewById(R.id.textView1);
        b1.setOnClickListener(new OnClickListener() {
			
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				try{
					int i,j,z;
					i=Integer.parseInt(e1.getText().toString());
					j=Integer.parseInt(e2.getText().toString());
					z=i+j;
					tv.setText("Result : "+z);
				}
			catch(Exception e)
			{
				
				Toast.makeText(getApplicationContext(), "Please Verify your Inputs",Toast.LENGTH_LONG).show();
			}
			
			}
		});
    }
}