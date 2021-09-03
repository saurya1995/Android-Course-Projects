package com.unisoft.activitylifecycle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends Activity {
    TextView tv;
    int count = 0;
    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_main);
        Log.d("ActivityLifeCycle","Main Actvity Created");
        tv = (TextView) findViewById(R.id.textView1);
        if(bundle != null){
            count = bundle.getInt("count",0);
            tv.setText("Count = "+count);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("ActivityLifeCycle","Main Actvity Started");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("ActivityLifeCycle","Main Actvity Resumed");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("ActivityLifeCycle","Main Actvity Paused");
    }

    @Override
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("count",count);
        Log.d("ActivityLifeCycle","Main Actvity Save Instance State");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("ActivityLifeCycle","Main Actvity Stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("ActivityLifeCycle","Main Actvity Destroy");
    }

    public void doWork(View v){
        startActivity(new Intent(this,ChildActivity.class));
    }

    public void doCount(View v){
        count++;
        tv.setText("Count = "+count);
    }
}
