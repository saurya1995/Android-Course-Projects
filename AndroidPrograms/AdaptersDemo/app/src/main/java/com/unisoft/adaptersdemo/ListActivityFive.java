package com.unisoft.adaptersdemo;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;


public class ListActivityFive extends ListActivity {
    ListView list;
    String[] states;
    ArrayList<String> items;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_activity_five);
        list = getListView();
        states = getResources().getStringArray(R.array.states);
        Arrays.sort(states);
        items = new ArrayList<String>();
        for(String str : states){
            items.add(str);
        }
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,items);
        setListAdapter(adapter);
        registerForContextMenu(list);
    }

    @Override
    protected void onListItemClick(ListView l, View view, int position, long id) {
        TextView tv = (TextView)view;
        Toast.makeText(this, tv.getText().toString(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.context_menu_list_activity_five, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)item.getMenuInfo();
        switch (item.getItemId()){
            case R.id.add:
                break;
            case R.id.update:
                break;
            case R.id.delete:
                items.remove(info.position);
                adapter.notifyDataSetChanged();
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list_activity_five, menu);
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
