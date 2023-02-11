package com.example.workflowmanagement.taskmonth;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.example.workflowmanagement.R;

import java.util.ArrayList;


public class TaskMonthFragment extends Fragment {

    private ArrayList<Task3> arrayList;
    private Task3Adapter adapter;
    private ListView listView;
    private View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_task_month, container, false);
        anhxa();
        adapter = new Task3Adapter(getActivity(),arrayList,R.layout.item_task_month);
        listView.setAdapter(adapter);
        return view;
    }

    private void anhxa() {
        arrayList = new ArrayList<>();
        listView = (ListView) view.findViewById(R.id.lv_day);
        arrayList.add(new Task3("công việc 13"));
        arrayList.add(new Task3("công việc 14"));
        arrayList.add(new Task3("công việc 15"));
        arrayList.add(new Task3("công việc 16"));
        arrayList.add(new Task3("công việc 17"));
        arrayList.add(new Task3("công việc 18"));
    }

}