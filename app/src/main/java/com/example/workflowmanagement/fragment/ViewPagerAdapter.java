package com.example.workflowmanagement.fragment;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new HomeFragment();
            case 1:
                return new RoomFragment();
            case 2:
                return  new CarFragment();
            case 3:
                return  new CalendarFragment();
            case 4:
                return new PersonalFragment();
            default:
                return  new HomeFragment();
        }

    }

    @Override
    public int getCount() {
        return 5;
    }
}
