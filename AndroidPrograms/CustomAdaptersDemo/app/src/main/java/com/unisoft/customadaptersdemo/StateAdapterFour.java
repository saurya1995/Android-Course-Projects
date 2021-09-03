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

import java.util.ArrayList;

public class StateAdapterFour extends BaseAdapter {

    ArrayList<State> list;
    LayoutInflater inflater;

    public StateAdapterFour(Context context, ArrayList<State> list){
        this.list = list;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
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
        State state = list.get(position);
        holder.getImageView().setImageResource(state.getImageId());
        holder.getTextView1().setText(state.getName());
        holder.getTextView2().setText(state.getDescription());
        return view;
    }
}
