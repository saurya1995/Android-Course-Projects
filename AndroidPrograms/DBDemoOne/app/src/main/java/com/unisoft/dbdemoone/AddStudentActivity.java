package com.unisoft.dbdemoone;

import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class AddStudentActivity extends Activity {
    SQLiteDatabase db;
    EditText t1,t2,t3,t4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);
        db = openOrCreateDatabase("unisoft",MODE_PRIVATE,null);
        db.execSQL("create table  if not exists Students(RollNumber Integer primary key not null, StudentName varchar(50), Email varchar(50), PhoneNumber varchar(20))");
        t1 = (EditText) findViewById(R.id.editText1);
        t2 = (EditText) findViewById(R.id.editText2);
        t3 = (EditText) findViewById(R.id.editText3);
        t4 = (EditText) findViewById(R.id.editText4);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        db.close();
    }

    public void saveRecord(View view){
        int rollNumber = Integer.parseInt(t1.getText().toString());
        String name = t2.getText().toString();
        String email = t3.getText().toString();
        String phone = t4.getText().toString();
        //String query = String.format("insert into Students values(%d,'%s','%s','%s')",rollNumber,name,email,phone);
        //db.execSQL(query);

        //Object[] arr = {rollNumber,name,email,phone};
        //db.execSQL("insert into Students values(?,?,?,?)",arr);

        ContentValues values = new ContentValues();
        values.put("RollNumber",rollNumber);
        values.put("StudentName",name);
        values.put("Email",email);
        values.put("PhoneNumber",phone);

        db.insert("Students",null,values);

        Toast.makeText(this,"Record Saved",Toast.LENGTH_SHORT).show();
        t1.setText("");
        t2.setText("");
        t3.setText("");
        t4.setText("");
        t1.requestFocus();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_student, menu);
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
