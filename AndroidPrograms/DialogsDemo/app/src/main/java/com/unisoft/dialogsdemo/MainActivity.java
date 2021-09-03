package com.unisoft.dialogsdemo;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;


public class MainActivity extends Activity implements DialogInterface.OnClickListener, DateDialog.DateChangeListener {

    AlertDialog.Builder builder;
    AlertDialog dialog;
    String[] topics;
    String items="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        topics = getResources().getStringArray(R.array.topics);
    }

    public void doWork(View v){
        switch(v.getId()){
            case R.id.button1:
                builder = new AlertDialog.Builder(this);
                builder.setTitle("Welcome");
                builder.setMessage("This is a Simple\nAlter Dialog");
                builder.setNegativeButton("Got It", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.setCancelable(false);
                dialog = builder.create();
                dialog.show();
                break;
            case R.id.button2:
                builder = new AlertDialog.Builder(this);
                builder.setTitle("Confirm");
                builder.setMessage("Do you wish to delete the record.");
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.setPositiveButton("Go Ahead", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this,"Record Deleted",Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setCancelable(false);
                dialog = builder.create();
                dialog.show();
                break;
            case R.id.button3:
                builder = new AlertDialog.Builder(this);
                builder.setTitle("Confirm");
                builder.setMessage("Do you wish to delete the record.");
                builder.setNegativeButton("No Way", this);
                builder.setNeutralButton("Cancel",this);
                builder.setPositiveButton("Go Ahead", this);
                builder.setCancelable(false);
                dialog = builder.create();
                dialog.show();
                break;
            case R.id.button4:
                builder = new AlertDialog.Builder(this);
                builder.setTitle("Pick a Topic");
                builder.setSingleChoiceItems(topics,0,new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        Toast.makeText(MainActivity.this,topics[which],Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("Go Away", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.setCancelable(false);
                dialog = builder.create();
                dialog.show();
                break;
            case R.id.button5:
                builder = new AlertDialog.Builder(this);
                builder.setTitle("Select Topics");

                builder.setMultiChoiceItems(topics,null,new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        items += topics[which]+",";
                    }
                });
                builder.setPositiveButton("Done", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        Toast.makeText(MainActivity.this,items,Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setCancelable(false);
                dialog = builder.create();
                dialog.show();
                break;
            case R.id.button6:
                /*
                builder = new AlertDialog.Builder(this);
                builder.setTitle("Select Topics");
                builder.setView(R.layout.dialog_custom);
                builder.setPositiveButton("Close", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.setCancelable(false);
                dialog = builder.create();
                dialog.show();*/

                /*
                Toast t = new Toast(this);
                t.setView(getLayoutInflater().inflate(R.layout.dialog_custom,null));
                t.setGravity(Gravity.TOP,0,0);
                t.setDuration(Toast.LENGTH_SHORT);
                t.show();*/
                /*
                ProgressDialog pd = new ProgressDialog(this);
                pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                pd.setProgress(20);
                pd.setTitle("File Download");
                pd.show();*/
                /*
                MyDialog d = new MyDialog();
                d.show(getFragmentManager(),"");*/

                DateDialog d = new DateDialog();
                d.show(getFragmentManager(),"");

                break;
        }
    }
    @Override
    public void onClick(DialogInterface dialog, int which) {
        switch(which){
            case DialogInterface.BUTTON_NEGATIVE:
                dialog.dismiss();
                Toast.makeText(MainActivity.this,"Operation Aborted",Toast.LENGTH_SHORT).show();
                break;
            case DialogInterface.BUTTON_NEUTRAL:
                Toast.makeText(MainActivity.this,"Cancelled",Toast.LENGTH_SHORT).show();
                dialog.dismiss();
                break;
            case DialogInterface.BUTTON_POSITIVE:
                Toast.makeText(MainActivity.this,"Record Deleted",Toast.LENGTH_SHORT).show();
                dialog.dismiss();
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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


    @Override
    public void dateChanged(Date d) {
        SimpleDateFormat fmt = new SimpleDateFormat("dd-MMMM-yyyy");
        String str = fmt.format(d);
        TextView tv = (TextView) findViewById(R.id.textView1);
        tv.setText(str);
    }
}
