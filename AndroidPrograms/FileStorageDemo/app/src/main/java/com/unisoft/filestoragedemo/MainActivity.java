package com.unisoft.filestoragedemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;


public class MainActivity extends Activity {
    EditText et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et = (EditText) findViewById(R.id.editText);
    }

    public void saveFile(View view){
        //Method 1 - Save a file in the root folder of app internal storage
        /*
        try{
            FileOutputStream fos = openFileOutput("message.txt",MODE_PRIVATE);
            String content = et.getText().toString();
            fos.write(content.getBytes());
            fos.close();
            Toast.makeText(this,"File Saved",Toast.LENGTH_SHORT).show();
            et.setText("");
        }catch(Exception ex){
            Toast.makeText(this,"Error : "+ex,Toast.LENGTH_SHORT).show();
        }*/
        //Method 2 - Save a file in a sub folder of the root folder of app internal storage
        /*
        try{
            //File f1 = getFilesDir();
            File f1 = getCacheDir();
            File f2 = new File(f1,"test");
            if(!f2.exists()){
                f2.mkdir();
            }
            File file = new File(f2,"note.txt");
            FileOutputStream fos = new FileOutputStream(file);
            String content = et.getText().toString();
            fos.write(content.getBytes());
            fos.close();
            Toast.makeText(this,"File Saved",Toast.LENGTH_SHORT).show();
            et.setText("");
        }catch(Exception ex){
            Toast.makeText(this,"Error : "+ex,Toast.LENGTH_SHORT).show();
        }*/

        //Method 3 : Save a file in private folder of external storage
/*
        String state = Environment.getExternalStorageState();
        if(state.equals(Environment.MEDIA_MOUNTED)){
            File f1 = getExternalFilesDir("/");
            //File f1 = getExternalCacheDir();
            File f2 = new File(f1,"demo");
            if(!f2.exists()){
                f2.mkdir();
            }
            try{
                File file = new File(f2,"note.txt");
                FileOutputStream fos = new FileOutputStream(file);
                String content = et.getText().toString();
                fos.write(content.getBytes());
                fos.close();
                Toast.makeText(this,"File Saved",Toast.LENGTH_SHORT).show();
                et.setText("");
            }catch(Exception ex){
                Toast.makeText(this,"Error : "+ex,Toast.LENGTH_SHORT).show();
            }
        }*/
        String state = Environment.getExternalStorageState();
        if(state.equals(Environment.MEDIA_MOUNTED)){
            File f1 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC);
            try{
                File file = new File(f1,"note.txt");
                FileOutputStream fos = new FileOutputStream(file);
                String content = et.getText().toString();
                fos.write(content.getBytes());
                fos.close();
                Toast.makeText(this,"File Saved",Toast.LENGTH_SHORT).show();
                et.setText("");
            }catch(Exception ex){
                Toast.makeText(this,"Error : "+ex,Toast.LENGTH_SHORT).show();
            }
        }

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        else if(id==R.id.note){
            startActivity(new Intent(this,TakeNoteActivity.class));
        }

        return super.onOptionsItemSelected(item);
    }
}
