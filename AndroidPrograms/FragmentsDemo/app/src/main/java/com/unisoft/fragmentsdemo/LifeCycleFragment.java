package com.unisoft.fragmentsdemo;


import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class LifeCycleFragment extends Fragment {

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Log.i("LifeCycleFragment", "Fragment onAttach");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("LifeCycleFragment", "Fragment onCreate");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.i("LifeCycleFragment", "Fragment onCreateView");
        return inflater.inflate(R.layout.fragment_life_cycle, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i("LifeCycleFragment", "Fragment onActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i("LifeCycleFragment", "Fragment onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i("LifeCycleFragment", "Fragment onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i("LifeCycleFragment", "Fragment onPause");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i("LifeCycleFragment", "Fragment onSaveInstanceState");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i("LifeCycleFragment", "Fragment onStop");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("LifeCycleFragment", "Fragment onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i("LifeCycleFragment", "Fragment onDetach");
    }
}
