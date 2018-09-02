package com.example.chih.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class eat_store_myadapter extends BaseAdapter {
    private LayoutInflater adapterLayoutInflater;

    public eat_store_myadapter(){

    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        TagView tag;
        tag = new TagView(
                (ImageView)view.findViewById(R.id.eatAdapterImage),
                (TextView)view.findViewById(R.id.eatAdapterText1),
                (TextView)view.findViewById(R.id.eatAdapterText2),
                (TextView)view.findViewById(R.id.eatAdapterText3));
        view.setTag(tag);
        return view;
    }

    public class TagView{
        ImageView image;
        TextView text1;
        TextView text2;
        TextView text3;

        public TagView(ImageView image, TextView text1, TextView text2, TextView text3){
            this.image = image;
            this.text1 = text1;
            this.text2 = text2;
            this.text3 = text3;

        }
    }
}
