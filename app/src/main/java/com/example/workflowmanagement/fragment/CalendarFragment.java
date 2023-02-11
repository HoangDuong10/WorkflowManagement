package com.example.workflowmanagement.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;

import com.example.workflowmanagement.R;


public class CalendarFragment extends Fragment {

    View view ;
    CalendarView calendarView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_calendar,container,false);
        calendarView = (CalendarView) view.findViewById(R.id.calendar);
        calendarView.setFocusedMonthDateColor(android.R.color.black);
        return view;
    }
}