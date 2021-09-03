package com.unisoft.simpleutilities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void doWork(View v) {
        switch(v.getId()){
            case R.id.button1:
                //Toast.makeText(this,"New Activity Started",Toast.LENGTH_SHORT).show();
                Intent i1 = new Intent(this,ChildActivity.class);
                startActivity(i1);
                break;
            case R.id.button2:
                //Logcat
                Log.d("Simple Utilities","The Close button was clicked");
                finish();
                break;
            case R.id.button3:
                Intent i2 = new Intent(this,AmountCalculatorActivity.class);
                startActivity(i2);
                break;
            case R.id.button4:
                Intent i3 = new Intent(this,CurrencyConverterActivity.class);
                startActivity(i3);
                break;
        }
    }
}
/*
public class MainActivity extends Activity {

    Button b1,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = (Button) findViewById(R.id.button1);
        b2 = (Button) findViewById(R.id.button2);

        b1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "New Activity Started", Toast.LENGTH_SHORT).show();
            }
        });
        b2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
*/
/*
public class MainActivity extends Activity {

    Button b1,b2;
    Alpha a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = (Button) findViewById(R.id.button1);
        b2 = (Button) findViewById(R.id.button2);

        a = new Alpha();
        b1.setOnClickListener(a);
        b2.setOnClickListener(a);
    }
    class Alpha  implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.button1:
                    Toast.makeText(MainActivity.this, "New Activity Started", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.button2:
                    //Logcat
                    Log.d("Simple Utilities", "The Close button was clicked");
                    finish();
                    break;
            }
        }
    }

}
*/
/*
public class MainActivity extends Activity implements View.OnClickListener {

    Button b1,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = (Button) findViewById(R.id.button1);
        b2 = (Button) findViewById(R.id.button2);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.button1:
                Toast.makeText(this,"New Activity Started",Toast.LENGTH_SHORT).show();
                break;
            case R.id.button2:
                //Logcat
                Log.d("Simple Utilities","The Close button was clicked");
                finish();
                break;
        }
    }
}
*/
