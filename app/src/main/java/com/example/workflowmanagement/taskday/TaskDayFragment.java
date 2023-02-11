package com.example.workflowmanagement.taskday;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.workflowmanagement.R;

import java.util.ArrayList;


public class TaskDayFragment extends Fragment {

    private ArrayList<Task1> arrayList;
    private Task1Adapter adapter;
    private ListView listView;
    private View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_task_day, container, false);
        anhxa();
        adapter = new Task1Adapter(getActivity(),arrayList,R.layout.item_task_day);
        listView.setAdapter(adapter);
        return view;
    }

    private void anhxa() {
        arrayList = new ArrayList<>();
        listView = (ListView) view.findViewById(R.id.lv_day);
        arrayList.add(new Task1("công việc 1"));
        arrayList.add(new Task1("công việc 2"));
        arrayList.add(new Task1("công việc 3"));
        arrayList.add(new Task1("công việc 4"));
        arrayList.add(new Task1("công việc 5"));
        arrayList.add(new Task1("công việc 6"));
    }

}