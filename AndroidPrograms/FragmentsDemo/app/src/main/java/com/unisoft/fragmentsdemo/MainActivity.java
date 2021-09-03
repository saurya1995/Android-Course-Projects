package com.unisoft.fragmentsdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void doWork(View v){
        switch(v.getId()){
            case R.id.button1:
                startActivity(new Intent(this,StaticFragmentActivity.class));
                break;
            case R.id.button2:
                startActivity(new Intent(this,DynamicFragmentActivity.class));
                break;
            case R.id.button3:
                startActivity(new Intent(this,FragmentLifeCycleActivity.class));
                break;
            case R.id.button4:
                startActivity(new Intent(this,FragmentCommunicationActivity.class));
                break;
            case R.id.button5:
                startActivity(new Intent(this,MasterDetailActivity.class));
                break;
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
