package your.pckage.namespace;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;

import android.widget.ViewSwitcher.ViewFactory;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
public class ImageSwitcherActivity extends Activity implements ViewFactory {
	 Integer[] imageIDs = {
		        R.drawable.pic10,
		        R.drawable.pic2,
		        R.drawable.pic8,
		        R.drawable.pic4,
		        R.drawable.pic1,
		        R.drawable.pic6,
		        R.drawable.dockedgrayrainy,
		        R.drawable.undockedblack,
		        R.drawable.undockedblackcloudy,
		        R.drawable.undockedblackfewshowers,
		        R.drawable.undockedblackwindy,
		        R.drawable.undockedbluewindy
		        };
	  public ImageSwitcher imageSwitcher;
	 static  String direction;
	  static int a = 0;
	  float xLast = 0;
      public static String Tag ="Hello";
      public void left()											//sliding left side
      {
      imageSwitcher.setInAnimation(this, R.anim.slide_in_right);  
      imageSwitcher.setOutAnimation(this, R.anim.slide_out_left);
      }
      public void right()											//sliding right side
      {
      imageSwitcher.setOutAnimation(this,R.anim.slide_out_right);					//slides image out  to right
      imageSwitcher.setInAnimation(this,R.anim.slide_in_left);								//slides image in from left
      }
    
      @Override
        public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        imageSwitcher = (ImageSwitcher) findViewById(R.id.switcher1);
        imageSwitcher.setFactory(this);								//calling makeView()
       
        imageSwitcher.setImageResource(imageIDs[a]);
     
        ImageButton btn2  = (ImageButton) findViewById(R.id.imageButton2);
        btn2.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
																		//  Left Button
				left();
				try
				{
					a--;
				imageSwitcher.setImageResource(imageIDs[a]);
				
	
				}
				catch (ArrayIndexOutOfBoundsException e)
				{
	
					a = 0;
					imageSwitcher.setImageResource(imageIDs[a]);
	
				}
			}
		});
        
        ImageButton btn1  = (ImageButton) findViewById(R.id.imageButton1);
        btn1.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
																		// Right Button
				right();
				try
				{
					a++;
					imageSwitcher.setImageResource(imageIDs[a]);
				
				}
				catch (ArrayIndexOutOfBoundsException e)
				{
					a = imageIDs.length - 1;
					imageSwitcher.setImageResource(imageIDs[a]);
				
				}
			}
		});
        }
    public View makeView()
        {
    	Log.i(Tag, "6");
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundColor(0xFF000000);
        imageView.setClickable(true);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setPadding(100, 100, 100, 100);
        imageView.setLayoutParams(new
        ImageSwitcher.LayoutParams(
        LayoutParams.WRAP_CONTENT,
        LayoutParams.WRAP_CONTENT));
        imageView.setOnTouchListener(new OnTouchListener() 
        {
			
			public boolean onTouch(View v, MotionEvent event) 
			{
				Log.i(Tag, "Touched");
				int motionevent = event.getAction();
				boolean drag = false;
				float x =  event.getX();
		
				float y =  event.getY();
				
				 
				  switch(event.getAction()){ 
	              case MotionEvent.ACTION_DOWN: 
	                   xLast = x; 
	                    
	                  drag = false; 
	                  break; 
	              case MotionEvent.ACTION_UP: 
	                   float xnew = event.getX();
	                   float ynew = event.getY();
	                  drag = true; 
	                 float one= xnew - xLast;		         	//action down - action up
			 if 	(	(one > 150) && (xnew > xLast))			//when swipes to the right 
				 {					
				 right();
					 try
					 {
						 a++;
					 imageSwitcher.setImageResource(imageIDs[a]);
					 
					 }
					 catch (ArrayIndexOutOfBoundsException e)
					 {
						 a= imageIDs.length-1;
						 imageSwitcher.setImageResource(imageIDs[a]);
						
					 }
				 }
				 else if ((one <-150) && (xnew < xLast))		//when swipes to the left
				 {
					 left(); 
				 
					 try
					 {
						
						 a--;
					 imageSwitcher.setImageResource(imageIDs[a]);
					 
					 }
					 catch (ArrayIndexOutOfBoundsException e)
					 {
					
						 ++a;
						 imageSwitcher.setImageResource(imageIDs[a]);
					
					 }
				 }
			 break; 
			  
				  }
				  
				  
				return true;
			}
		});
        
        return imageView;
        }
        
  
 
}
     

		
	

