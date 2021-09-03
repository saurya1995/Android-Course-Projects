package com.bb;

import android.app.Activity;
import android.os.Bundle;


public class BBActivity extends Activity {
    /** Called when the activity is first created. */
	view myview;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    myview =new view(this);
    setContentView(myview);
    }
}