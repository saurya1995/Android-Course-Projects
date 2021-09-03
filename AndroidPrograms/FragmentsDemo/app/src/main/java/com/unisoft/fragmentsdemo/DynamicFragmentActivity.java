package com.unisoft.fragmentsdemo;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class DynamicFragmentActivity extends Activity {

    FragmentManager manager;
    int index=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_fragment);
        manager = getFragmentManager();

        StaticFragmentOne f1 = new StaticFragmentOne();
        FragmentTransaction trans = manager.beginTransaction();
        trans.replace(R.id.fragmentContainer,f1);
        trans.commit();
    }

    public void addFragment(View view){
        if(index==1) {
            StaticFragmentTwo f1 = new StaticFragmentTwo();
            FragmentTransaction trans = manager.beginTransaction();
            trans.replace(R.id.fragmentContainer, f1);
            trans.addToBackStack("");
            trans.commit();
            index=2;
        }else{
            StaticFragmentOne f1 = new StaticFragmentOne();
            FragmentTransaction trans = manager.beginTransaction();
            trans.replace(R.id.fragmentContainer, f1);
            trans.addToBackStack("");
            trans.commit();
            index=1;
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_dynamic, menu);
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
