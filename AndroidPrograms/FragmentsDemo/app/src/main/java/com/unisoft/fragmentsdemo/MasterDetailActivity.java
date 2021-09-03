package com.unisoft.fragmentsdemo;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class MasterDetailActivity extends Activity implements TopicsFragment.TopicChangeListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master_detail);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_master_detail, menu);
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

    @Override
    public void updateDetails(int index) {
        Fragment f = getFragmentManager().findFragmentById(R.id.detailsFragment);
        if(f != null && f.isVisible()){
            DetailsFragment df = (DetailsFragment)f;
            df.showDetails(index);
        }else{
            Intent intent = new Intent(this,DetailsActivity.class);
            intent.putExtra("index",index);
            startActivity(intent);
        }
    }
}
