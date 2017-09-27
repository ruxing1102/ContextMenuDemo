package com.example.android.contextmenudemo;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ruxing on 2017/9/27.
 */

public class MyAdapter extends BaseAdapter {

    private Context context;
    private List<String> data;

    public MyAdapter(Context context, List<String> list) {
        this.context = context;
        this.data = list;
    }

    @Override
    public int getCount() {
        return data == null ? 0 : data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        MyHolder holder;
        if (view == null) {
            holder = new MyHolder();
            view = View.inflate(context, R.layout.item, null);
            holder.tv_content = (TextView) view.findViewById(R.id.tv_content);
            view.setTag(holder);
        } else {
            holder = (MyHolder) view.getTag();
        }
        holder.tv_content.setText(data.get(i));
        return view;
    }

    class MyHolder {
        private TextView tv_content;
    }
}
