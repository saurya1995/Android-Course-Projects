package com.animation;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class AnimationActivity extends Activity {
    /** Called when the activity is first created. */
	ImageView animation;

	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
      
        animation=(ImageView)findViewById(R.id.imageView1);
        animation.setBackgroundResource(R.drawable.list);
	
    }

	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		// TODO Auto-generated method stub
		super.onWindowFocusChanged(hasFocus);
		AnimationDrawable frameAnimation=(AnimationDrawable)animation.getBackground();
		if(hasFocus){
			frameAnimation.start();
		}
		else{
			frameAnimation.stop();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		getMenuInflater().inflate(R.menu.menu,menu);
		return super.onCreateOptionsMenu(menu);
	
	}
	
}