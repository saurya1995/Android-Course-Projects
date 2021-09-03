package com.unisoft.activitycommunication;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.List;


public class BuiltInAppsActivity extends Activity {
    ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_built_in_apps);

        iv = (ImageView) findViewById(R.id.imageView1);
    }

    public void doWork(View v){
        switch(v.getId()){
            case R.id.button1:
                startActivity(new Intent(Intent.ACTION_DIAL));      //Implicit Intent
                break;
            case R.id.button2:
                Intent i1 = new Intent(Intent.ACTION_VIEW);
                String url = "http://www.unisoft.com";
                i1.setData(Uri.parse(url));
                startActivity(i1);
                break;
            case R.id.button3:
                Intent i2 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(i2,101);
                break;
            case R.id.button4:
                Uri location = Uri.parse("geo:78.234567,32.474834");
                Intent i4 = new Intent(Intent.ACTION_VIEW, location);
                PackageManager packageManager = getPackageManager();
                List<ResolveInfo> activities = packageManager.queryIntentActivities(i4, 0);
                boolean isIntentSafe = activities.size() > 0;
                if (isIntentSafe) {
                    startActivity(i4);
                }else{
                    Toast.makeText(this,"No Activity Found",Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==101){
            if(resultCode==RESULT_OK){
                Bitmap map = (Bitmap) data.getExtras().get("data");
                iv.setImageBitmap(map);
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_built_in_apps, menu);
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
