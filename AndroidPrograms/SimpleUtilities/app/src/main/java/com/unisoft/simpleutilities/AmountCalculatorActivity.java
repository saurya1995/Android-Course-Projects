package com.unisoft.simpleutilities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class AmountCalculatorActivity extends Activity {

    EditText etPrinciple, etRate, etYear;
    TextView tvInterest, tvAmount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amount_calculator);

        fetchViews();
    }

    private void fetchViews() {
        etPrinciple = (EditText) findViewById(R.id.etPrinciple);
        etRate = (EditText) findViewById(R.id.etRate);
        etYear = (EditText) findViewById(R.id.etYear);



        tvInterest = (TextView) findViewById(R.id.tvInterest);
        tvAmount = (TextView) findViewById(R.id.tvAmount);


    }

    public void calculate(View v){
        double p = Double.parseDouble(etPrinciple.getText().toString());
        double r = Double.parseDouble(etRate.getText().toString());
        double y = Double.parseDouble(etYear.getText().toString());
        double si = (p*r*y)/100;
        double amt = p+si;

        tvInterest.setText("Simple Interest : "+si);
        tvAmount.setText("Amount : "+amt);
    }

    public void reset(View v){
        etPrinciple.setText("");
        etRate.setText("");
        etYear.setText("");
        tvInterest.setText("Simple Interest");
        tvAmount.setText("Amount");
        etPrinciple.requestFocus();
    }
}
