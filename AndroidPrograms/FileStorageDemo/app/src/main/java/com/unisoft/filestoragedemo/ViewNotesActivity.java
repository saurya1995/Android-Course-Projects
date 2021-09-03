package com.unisoft.filestoragedemo;

import android.accounts.AccountManager;
import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class ViewNotesActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_notes);
        NotesAdapter adapter = new NotesAdapter();
        setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        LinearLayout layout = (LinearLayout)v;
        TextView tv = (TextView) layout.findViewById(R.id.textView1);
        String name = tv.getText().toString();
        showContent(name);
    }

    private void showContent(String name){
        try{
            //InputStream is = openFileInput(name);
            File dir = getFilesDir();
            File f = new File(dir,name);
            FileInputStream fi = new FileInputStream(f);
            byte[] arr = new byte[fi.available()];
            fi.read(arr);
            String content = new String(arr);
            Toast.makeText(this, content, Toast.LENGTH_SHORT).show();
        }catch(Exception ex){
            Toast.makeText(this, "Error : " + ex, Toast.LENGTH_SHORT).show();
        }
    }

    class NotesAdapter extends BaseAdapter{
        ArrayList<Note> list;
        SimpleDateFormat fmt;
        LayoutInflater inflater;
        public NotesAdapter(){
            fmt = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss a");
            list = new ArrayList<Note>();
            inflater = getLayoutInflater();
            File dir = getFilesDir();
            File[] arr = dir.listFiles(new FileFilter() {
                @Override
                public boolean accept(File fileName) {
                    if(fileName.getName().endsWith(".note"))
                        return true;
                    return false;
                }
            });
            for(File f : arr){
                Note note = new Note();
                note.setName(f.getName());
                Date d = new Date(f.lastModified());
                note.setLastModified(fmt.format(d));
                list.add(note);
            }
        }
        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view;
            if(convertView==null){
                view = inflater.inflate(R.layout.note_item,parent,false);
            }else{
                view = convertView;
            }
            TextView tv1 = (TextView) view.findViewById(R.id.textView1);
            TextView tv2 = (TextView) view.findViewById(R.id.textView2);
            Note note = list.get(position);
            tv1.setText(note.getName());
            tv2.setText(note.getLastModified());
            return view;
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_view_notes, menu);
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
