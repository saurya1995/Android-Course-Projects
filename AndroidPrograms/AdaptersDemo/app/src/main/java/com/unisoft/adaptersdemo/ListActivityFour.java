package com.unisoft.adaptersdemo;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;


public class ListActivityFour extends ListActivity {
    ListView list;
    String[] states = {"Jammu and Kashmir","Himachal Pradesh","Punjab","Haryana","Uttarakhand","Uttar Pradesh","New Delhi","Rajasthan","Madhya Pradesh","Assam","Manipur","West Bengal","Maharashtra","Tamilnadu","Kerala"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_activity_four);
        list = getListView();
        //list.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        list.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        Arrays.sort(states);
        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_single_choice,states);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_multiple_choice,states);
        setListAdapter(adapter);
    }

    public void showData(View view){
        //int index = list.getCheckedItemPosition();
        //Toast.makeText(this, "Selected Item : "+states[index], Toast.LENGTH_SHORT).show();
        String items="";
        SparseBooleanArray arr = list.getCheckedItemPositions();
        for(int i=0;i<states.length;i++){
            if(arr.get(i)==true){
                items += states[i]+"\n";
            }
        }
        Toast.makeText(this, items, Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onListItemClick(ListView l, View view, int position, long id) {
        TextView tv = (TextView)view;
        Toast.makeText(this, tv.getText().toString(), Toast.LENGTH_SHORT).show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list_activity_four, menu);
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
