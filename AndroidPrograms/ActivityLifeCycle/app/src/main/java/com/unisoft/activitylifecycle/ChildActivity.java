package com.unisoft.activitylifecycle;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


public class ChildActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child);
        Log.d("ActivityLifeCycle", "Child Actvity Created");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("ActivityLifeCycle", "Child Actvity Started");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("ActivityLifeCycle","Child Actvity Resumed");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("ActivityLifeCycle","Child Actvity Paused");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("ActivityLifeCycle","Child Actvity Save Instance State");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("ActivityLifeCycle", "Child Actvity Stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("ActivityLifeCycle","Child Actvity Destroy");
    }
}
