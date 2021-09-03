package intent.com;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class second extends Activity{
EditText ed;
Button btn;
@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setContentView(R.layout.second1);
	ed=(EditText)findViewById(R.id.editText1);
btn=(Button)findViewById(R.id.button1);
btn.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		//ed.setText("U HAVE CLIKED BUTTON");
		Intent nn=new Intent(second.this,IntentActivity.class);
		startActivity(nn);
	}
});




}

}
