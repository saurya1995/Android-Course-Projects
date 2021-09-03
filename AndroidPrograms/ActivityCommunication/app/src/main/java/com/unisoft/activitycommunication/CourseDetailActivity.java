package com.unisoft.activitycommunication;

import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;


public class CourseDetailActivity extends Activity {
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_detail);

        Intent intent = getIntent();
        String course = intent.getStringExtra("course");
        Typeface font = Typeface.createFromAsset(getAssets(),"fonts/Pacifico.ttf");
        tv = (TextView) findViewById(R.id.textView1);
        tv.setTypeface(font);
        showDetails(course);
    }

    public void showDetails(String course){

        //tv.setText(course);
        if(course.equals("Java")){
            loadDataFromRaw();
        }else if(course.equals("Android")){
            loadDataFromAsset();
        }
    }
    private void loadDataFromRaw() {
        try {
            InputStream is = getResources().openRawResource(R.raw.java);
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            StringBuffer content = new StringBuffer();
            String line = reader.readLine();
            while (line != null) {
                content.append(line+"\n");
                line = reader.readLine();
            }

            tv.setText(content.toString());
        }catch(Exception ex){}
    }
    private void loadDataFromAsset() {
       // AssetManager manager = getAssets();
       // manager.open("android.html");
        try {
            InputStream is = getAssets().open("android.html");
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            StringBuffer content = new StringBuffer();
            String line = reader.readLine();
            while (line != null) {
                content.append(line+"\n");
                line = reader.readLine();
            }

            tv.setText(Html.fromHtml(content.toString()));
        }catch(Exception ex){}
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_course_detail, menu);
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
