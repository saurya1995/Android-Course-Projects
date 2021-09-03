package com.unisoft.dialogsdemo;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.widget.DatePicker;

import java.util.Calendar;
import java.util.Date;

public class DateDialog extends DialogFragment implements DatePickerDialog.OnDateSetListener {
    DateChangeListener listener;
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Calendar cal = Calendar.getInstance();
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int month = cal.get(Calendar.MONTH);
        int year = cal.get(Calendar.YEAR);
        return new DatePickerDialog(getActivity(),this,year,month,day);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if(activity instanceof DateChangeListener){
            listener = (DateChangeListener)activity;
        }
    }

    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        Calendar cal = Calendar.getInstance();
        cal.set(year,monthOfYear,dayOfMonth);
        Date d = cal.getTime();
        listener.dateChanged(d);
    }

    public interface DateChangeListener
    {
        public void dateChanged(Date d);
    }
}
