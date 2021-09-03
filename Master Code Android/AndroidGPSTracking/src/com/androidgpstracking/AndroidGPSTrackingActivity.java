package com.androidgpstracking;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
public class AndroidGPSTrackingActivity extends Activity {
Button btnShowLocation;
// GPSTracker class
GPSTracker gps;
@Override
public void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.main);
btnShowLocation = (Button) findViewById(R.id.button1);
// show location button click event
btnShowLocation.setOnClickListener(new View.OnClickListener() {
public void onClick(View arg0) {
// create class object
gps = new GPSTracker(AndroidGPSTrackingActivity.this);
// check if GPS enabled
if(gps.canGetLocation()){
double latitude = gps.getLatitude();
double longitude = gps.getLongitude();
//\n is for new line
Toast.makeText(getApplicationContext(), "Your Location is Latitude :"+latitude+" & Longitude "+longitude, Toast.LENGTH_SHORT).show();
}
		else{
// can't get location
// GPS or Network is not enabled
// Ask user to enable GPS/network in settings

}
}
});
}
}