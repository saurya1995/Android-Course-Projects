package com.unisoft.fragmentsdemo;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


public class FragmentLifeCycleActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("LifeCycleActivity", "Activity onCreate");
        setContentView(R.layout.activity_fragment_life_cycle);

    }

    @Override
    public void onAttachFragment(Fragment fragment) {
        super.onAttachFragment(fragment);
        Log.i("LifeCycleActivity", "Activity onAttachFragment");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("LifeCycleActivity", "Activity onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("LifeCycleActivity", "Activity onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("LifeCycleActivity", "Activity onPause");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i("LifeCycleActivity", "Activity onSaveInstanceState");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("LifeCycleActivity", "Activity onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("LifeCycleActivity", "Activity onDestroy");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_fragment_life_cycle, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
