package com.unisoft.fragmentsdemo;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DetailsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_details, container, false);
    }

    public void showDetails(int index){
        String[] descriptions = getResources().getStringArray(R.array.description);
        TextView tv = (TextView) getActivity().findViewById(R.id.textView1);
        tv.setText(descriptions[index]);
    }
}
