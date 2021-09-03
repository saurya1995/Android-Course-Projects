package com.unisoft.fragmentsdemo;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.app.Fragment;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class ButtonFragment extends Fragment implements View.OnClickListener {

    Button b1;
    int count = 0;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_button, container, false);
    }

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if(bundle != null){
            count = bundle.getInt("count",0);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("count",count);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        b1 = (Button) getActivity().findViewById(R.id.button1);
        b1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        count++;
        Activity ac = getActivity();
        if(ac instanceof CounterListener){
            CounterListener cl = (CounterListener)ac;
            cl.updateCount(count);
        }
        /*
        FragmentCommunicationActivity ac = (FragmentCommunicationActivity) getActivity();
        ac.updateCount(count);*/
        /*
        FragmentManager manager = getActivity().getFragmentManager();
        MessageFragment f = (MessageFragment) manager.findFragmentById(R.id.fragment2);
        f.updateCount(count);*/
    }

    public interface CounterListener
    {
        public void updateCount(int count);
    }
}
