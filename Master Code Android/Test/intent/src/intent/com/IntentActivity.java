package intent.com;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class IntentActivity extends Activity {
    /** Called when the activity is first created. */
    Button btn;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        btn=(Button)findViewById(R.id.button1);
        LinearLayout l=(LinearLayout)findViewById(R.id.lay);
        btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent n=new Intent(IntentActivity.this,second.class);
				startActivity(n);
			}
		});
        l.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			Toast.makeText(getApplicationContext(), "u have cliked on activity", 500).show();	
			}
		});
        
        
    }
}