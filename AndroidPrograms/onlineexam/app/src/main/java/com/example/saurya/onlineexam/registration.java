package com.example.saurya.onlineexam;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class registration extends Activity {
    SQLiteDatabase db;
    EditText t1,t2,t3,t4,t5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        db = openOrCreateDatabase("saurya",MODE_PRIVATE,null);
        db.execSQL("create table  if not exists Students(RollNumber Integer primary key not null, StudentName varchar(50), Email varchar(50), PhoneNumber varchar(20))");
        t1 = (EditText) findViewById(R.id.editText1);
        t2 = (EditText) findViewById(R.id.editText2);
        t3 = (EditText) findViewById(R.id.editText3);
        t4 = (EditText) findViewById(R.id.editText4);
        t5 = (EditText) findViewById(R.id.editText5);
    }
    protected void onDestroy() {
        super.onDestroy();
        db.close();
    }
public void fxn(View v){
    switch (v.getId())
    {
        case R.id.button1:
            int userid = Integer.parseInt(t3.getText().toString());
            String firstname = t1.getText().toString();
            String lastname = t2.getText().toString();
            String password = t4.getText().toString();
            String confirmpassword = t5.getText().toString();
            //String query = String.format("insert into Students values(%d,'%s','%s','%s')",rollNumber,name,email,phone);
            //db.execSQL(query);

            //Object[] arr = {rollNumber,name,email,phone};
            //db.execSQL("insert into Students values(?,?,?,?)",arr);

            ContentValues values = new ContentValues();
            values.put("RollNumber",userid);
            values.put("StudentName",firstname);
            values.put("Email",lastname);
            values.put("PhoneNumber",confirmpassword);
            values.put("PhoneNumber",password);
            db.insert("Students",null,values);

            Toast.makeText(this, "Record Saved", Toast.LENGTH_SHORT).show();
            t1.setText("");
            t2.setText("");
            t3.setText("");
            t4.setText("");
            t1.requestFocus();
            break;
        case R.id.button2:
            Intent i1 = new Intent(this,MainActivity.class);
            startActivity(i1);
    }

}
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_registration, menu);
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
