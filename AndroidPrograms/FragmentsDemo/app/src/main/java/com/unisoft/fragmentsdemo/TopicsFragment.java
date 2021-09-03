package com.unisoft.fragmentsdemo;
import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class TopicsFragment extends ListFragment {
    String[] topics;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_topics, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        topics = getResources().getStringArray(R.array.topics);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,topics);
        setListAdapter(adapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Activity ac = getActivity();
        if(ac instanceof TopicChangeListener){
            TopicChangeListener tcl = (TopicChangeListener)ac;
            tcl.updateDetails(position);
        }
    }

    public interface TopicChangeListener{
        public void updateDetails(int index);
    }
}
