package com.unisoft.adaptersdemo;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;


public class ListActivityThree extends ListActivity {
    ListView list;
    String[] states;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_activity_two);
        list = getListView();
        states = getResources().getStringArray(R.array.states);
        Arrays.sort(states);
        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,states);
        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.list_item,states);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.list_item_with_image,R.id.textView1,states);
        setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView l, View view, int position, long id) {
        //TextView tv = (TextView)view;
        //Toast.makeText(this, tv.getText().toString(), Toast.LENGTH_SHORT).show();
        LinearLayout layout = (LinearLayout)view;
        TextView tv = (TextView) layout.findViewById(R.id.textView1);
        Toast.makeText(this, tv.getText().toString(), Toast.LENGTH_SHORT).show();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list_activity_three, menu);
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
