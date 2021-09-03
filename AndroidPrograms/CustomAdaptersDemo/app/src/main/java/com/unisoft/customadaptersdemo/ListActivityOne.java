package com.unisoft.customadaptersdemo;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class ListActivityOne extends ListActivity {

    ListView list;
    String[] states;
    String[] descriptions;
    int[] images = {R.drawable.one,R.drawable.two,R.drawable.three,R.drawable.four,R.drawable.five,R.drawable.six,R.drawable.seven,R.drawable.eight,R.drawable.nine,R.drawable.ten,R.drawable.eleven,R.drawable.twelve,R.drawable.thirteen,R.drawable.fourteen,R.drawable.fifteen};
    ArrayList<State> data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_activity_one);
        list = getListView();
        states = getResources().getStringArray(R.array.states);
        descriptions = getResources().getStringArray(R.array.descriptions);
        generateData();
        //StateAdapterOne adapter = new StateAdapterOne(this,states,descriptions,images);
        //StateAdapterTwo adapter = new StateAdapterTwo(this,states,descriptions,images);
        //StateAdapterThree adapter = new StateAdapterThree(this,states,descriptions,images);
        StateAdapterFour adapter = new StateAdapterFour(this,data);
        setListAdapter(adapter);
    }

    private void generateData(){
        data = new ArrayList<State>();
        for(int i=0;i<states.length;i++){
            State state = new State(images[i],states[i],descriptions[i]);
            data.add(state);
        }
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        LinearLayout layout = (LinearLayout)v;
        TextView tv = (TextView) layout.findViewById(R.id.textView1);
        Toast.makeText(this,tv.getText().toString(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list_activity_one, menu);
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
