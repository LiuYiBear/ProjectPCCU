package com.example.chih.myapplication;

import java.util.ArrayList;
import java.util.HashMap;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.TextView;

public class eatStoreDataGameSlect extends BaseAdapter {
    Context context;
    ArrayList<HashMap<String, String>> listData;
    //记录checkbox的状态
    HashMap<Integer, Boolean> state = new HashMap<Integer, Boolean>();

    //构造函数
    public eatStoreDataGameSlect(ArrayList<HashMap<String, String>> listData) {
//        this.context = context;
        this.listData = listData;
    }

    @Override
    public int getCount() {
// TODO Auto-generated method stub
        return listData.size();
    }

    @Override
    public Object getItem(int position) {
// TODO Auto-generated method stub
        return listData.get(position);
    }

    @Override
    public long getItemId(int position) {
// TODO Auto-generated method stub
        return position;
    }

    // 重写View
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
// TODO Auto-generated method stub

        LayoutInflater mInflater = LayoutInflater.from(context);
        CheckBox check = (CheckBox) convertView.findViewById(R.id.checkBox);
        check.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {
// TODO Auto-generated method stub
                if (isChecked) {
                    state.put(position, isChecked);
                } else {
                    state.remove(position);
                }
            }
        });
        check.setChecked((state.get(position) == null ? false : true));
        return convertView;
    }


}
