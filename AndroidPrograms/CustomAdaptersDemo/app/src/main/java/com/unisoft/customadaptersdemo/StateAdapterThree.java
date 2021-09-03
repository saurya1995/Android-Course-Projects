package com.unisoft.customadaptersdemo;

import android.content.Context;
import android.media.Image;
import android.net.NetworkInfo;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class StateAdapterThree extends BaseAdapter {

    String[] states;
    String[] descriptions;
    int[] images;
    LayoutInflater inflater;

    public StateAdapterThree(Context context, String[] states, String[] descriptions, int[] images){
        this.states = states;
        this.descriptions = descriptions;
        this.images = images;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return states.length;
    }

    @Override
    public Object getItem(int position) {
        return states[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        ViewHolder holder;
        if(convertView==null){
            view = inflater.inflate(R.layout.custom_list_item,parent,false);
            ImageView iv = (ImageView) view.findViewById(R.id.imageView1);
            TextView tv1 = (TextView) view.findViewById(R.id.textView1);
            TextView tv2 = (TextView) view.findViewById(R.id.textView2);
            holder = new ViewHolder(iv,tv1,tv2);
            view.setTag(holder);
            Log.i("StateAdapterTwo","New Item Created");
        }else{
            view = convertView;
            holder = (ViewHolder) view.getTag();
            Log.i("StateAdapterTwo","Old Item Recycled");
        }

        holder.getImageView().setImageResource(images[position]);
        holder.getTextView1().setText(states[position]);
        holder.getTextView2().setText(descriptions[position]);
        return view;
    }
}
