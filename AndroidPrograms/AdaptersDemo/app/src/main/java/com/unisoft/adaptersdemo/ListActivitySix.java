package com.unisoft.adaptersdemo;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;


public class ListActivitySix extends ListActivity {
    ListView list;
    ArrayList<Book> books;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_list_activity_six);
        //LayoutInflater inflater = getLayoutInflater();
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.activity_list_activity_six, null);
        setContentView(view);

        list = getListView();
        books = generateList();
        ArrayAdapter<Book> adapter = new ArrayAdapter<Book>(this,android.R.layout.simple_list_item_1,books);
        setListAdapter(adapter);
    }

    public ArrayList<Book> generateList(){
        ArrayList<Book> temp = new ArrayList<Book>();
        temp.add(new Book("Let Us C","Y Kanetkar",300));
        temp.add(new Book("Let Us C++","Y Kanetkar",400));
        temp.add(new Book("Let Us java","Y Kanetkar",500));
        temp.add(new Book("Let Us PHP","Y Kanetkar",600));
        temp.add(new Book("Let Us Android","Y Kanetkar",700));
        temp.add(new Book("Let Us SQL","Y Kanetkar",800));
        temp.add(new Book("Let Us Perl","Y Kanetkar",900));
        temp.add(new Book("Let Us Python","Y Kanetkar",100));
        return temp;
    }

    @Override
    protected void onListItemClick(ListView l, View view, int position, long id) {
        TextView tv = (TextView)view;
        Toast.makeText(this, tv.getText().toString(), Toast.LENGTH_SHORT).show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list_activity_six, menu);
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
