package com.unisoft.filestoragedemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;


public class TakeNoteActivity extends Activity {
    EditText name,content;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_note);

        name = (EditText)findViewById(R.id.name);
        content = (EditText)findViewById(R.id.content);
    }

    public void saveNote(View view){
        try{
            File f1 = getFilesDir();
            File file = new File(f1,name.getText().toString()+".note");
            FileOutputStream fos = new FileOutputStream(file);
            String text = content.getText().toString();
            fos.write(text.getBytes());
            fos.close();
            Toast.makeText(this, "Note Saved", Toast.LENGTH_SHORT).show();
            content.setText("");
            name.setText("");
            name.requestFocus();
        }catch(Exception ex){
            Toast.makeText(this,"Error : "+ex,Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_take_note, menu);
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

        if(id == R.id.viewNotes){
            startActivity(new Intent(this,ViewNotesActivity.class));
        }

        return super.onOptionsItemSelected(item);
    }
}
