package com.unisoft.simpleutilities;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

import java.text.DecimalFormat;


public class CurrencyConverterActivity extends Activity implements CompoundButton.OnCheckedChangeListener {

    EditText etAmount, etValue;
    RadioButton rb1,rb2,rb3;
    DecimalFormat fmt;
    CheckBox cb1;
    Switch sw1;
    double tax=0;
    double vat=0;
    SeekBar sb1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency_converter);
        fmt = new DecimalFormat("0.00");
        fetchViews();
    }

    private void fetchViews() {
        etAmount = (EditText) findViewById(R.id.etAmount);
        etValue = (EditText) findViewById(R.id.etValue);
        rb1 = (RadioButton) findViewById(R.id.radioButton1);
        rb2 = (RadioButton) findViewById(R.id.radioButton2);
        rb3 = (RadioButton) findViewById(R.id.radioButton3);
        cb1 = (CheckBox) findViewById(R.id.checkBox1);
        sw1 = (Switch) findViewById(R.id.switch1);
        sb1 = (SeekBar) findViewById(R.id.seekBar1);

        rb1.setOnCheckedChangeListener(this);
        rb2.setOnCheckedChangeListener(this);
        rb3.setOnCheckedChangeListener(this);
        cb1.setOnCheckedChangeListener(this);
        sw1.setOnCheckedChangeListener(this);

        etAmount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                calculateAmount();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        sb1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                etAmount.setText(""+progress*1000);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void calculate(View v){
        calculateAmount();
    }

    void calculateAmount(){
        if(etAmount.getText().toString().equals("")){
            return;
        }
        double amount = Double.parseDouble(etAmount.getText().toString());
        double value = 0;
        if(rb1.isChecked()){
            value = amount/60.35;
        }else if(rb2.isChecked()){
            value = amount/92.70;
        }else if(rb3.isChecked()){
            value = amount/76.40;
        }

        value = value - value * tax/100 - value * vat/100;
        etValue.setText(fmt.format(value));
    }

    public void reset(View v){
        etAmount.setText("");
        etValue.setText("");
        etAmount.requestFocus();
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

        if(buttonView==cb1){
            if(isChecked)
                tax = 5.0;
            else
                tax=0;
        }
        if(buttonView==sw1){
            if(isChecked)
                vat = 4.0;
            else
                vat=0;
        }

        calculateAmount();
    }
}
