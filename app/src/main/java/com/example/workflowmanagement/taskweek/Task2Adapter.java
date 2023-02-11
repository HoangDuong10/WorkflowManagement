package com.example.workflowmanagement.taskweek;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.workflowmanagement.R;

import java.util.ArrayList;

public class Task2Adapter extends BaseAdapter {
    private Context context;
    private ArrayList<Task2> arrayList;
    private int layout;

    public Task2Adapter(Context context, ArrayList<Task2> arrayList, int layout) {
        this.context = context;
        this.arrayList = arrayList;
        this.layout = layout;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }
    public class viewHolder{
        TextView textView;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        viewHolder holder = new viewHolder();

        if(view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout,null);
            holder.textView = view.findViewById(R.id.text);
            view.setTag(holder);
        }else{
            holder = (viewHolder) view.getTag();
        }
        Task2 task1 = arrayList.get(i);
        holder.textView.setText(task1.getName());
        return view;
    }
}
