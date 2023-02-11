package com.example.workflowmanagement;

import android.widget.Switch;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.workflowmanagement.taskday.Task1;
import com.example.workflowmanagement.taskday.TaskDayFragment;
import com.example.workflowmanagement.taskmonth.TaskMonthFragment;
import com.example.workflowmanagement.taskweek.TaskWeekFragment;

public class ViewTaskPagerAdapter extends FragmentStatePagerAdapter {
    public ViewTaskPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new TaskDayFragment();
            case 1:
                return new TaskWeekFragment();
            case 2:
                return new TaskMonthFragment();
            default:
                return new TaskDayFragment();
        }

    }

    @Override
    public int getCount() {
        return 3;
    }
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title ="";
        switch (position){
            case 0:
                title = "Hôm nay";
                break;
            case 1 :
                title = "Tuần";
                break;
            case 2 :
                title = "Tháng";
        }
        return title;
    }

}
