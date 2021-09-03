package com.kaushal.camera;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class CameraActivity extends Activity {
	Button pic;
	ImageView image;
	Uri toimage;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        pic=(Button)findViewById(R.id.bpic);
        image=(ImageView)findViewById(R.id.ivpic);
        pic.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i= new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
				startActivityForResult(i,1);
			}
		});
    }
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if(resultCode==RESULT_OK){
			toimage=data.getData();
			image.setImageURI(toimage);
		}
		
		
	}
    
    
}