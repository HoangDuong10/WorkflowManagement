package com.example.workflowmanagement.taskweek;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.example.workflowmanagement.R;

import java.util.ArrayList;


public class TaskWeekFragment extends Fragment {

    private ArrayList<Task2> arrayList;
    private Task2Adapter adapter;
    private ListView listView;
    private View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_task_week, container, false);
        anhxa();
        adapter = new Task2Adapter(getActivity(),arrayList,R.layout.item_task_week);
        listView.setAdapter(adapter);
        return view;
    }

    private void anhxa() {
        arrayList = new ArrayList<>();
        listView = (ListView) view.findViewById(R.id.lv_day);
        arrayList.add(new Task2("công việc 7"));
        arrayList.add(new Task2("công việc 8"));
        arrayList.add(new Task2("công việc 9"));
        arrayList.add(new Task2("công việc 10"));
        arrayList.add(new Task2("công việc 11"));
        arrayList.add(new Task2("công việc 12"));
    }

}