package com.bb;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.View;

public class view extends View {
Bitmap gball,aball;
float changingY;
float changingX;
	public view(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		gball= BitmapFactory.decodeResource(getResources(), R.drawable.ball);
		aball= BitmapFactory.decodeResource(getResources(), R.drawable.aball);
		changingY=0;
		changingX=0;
	}
	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		canvas.drawColor(Color.WHITE);
		canvas.drawBitmap(gball, changingX,(canvas.getHeight()/2), null);
		canvas.drawBitmap(aball, (canvas.getWidth()/2),changingY, null);
		if((changingX<(canvas.getWidth()))||(changingY<(canvas.getHeight())) ){
			changingY+=10;
			changingX +=10;
		
		}
		else{
			changingY=0;
			changingX=0;
		}
		invalidate();
	}

}
