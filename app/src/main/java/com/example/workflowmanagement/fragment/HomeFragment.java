package com.example.workflowmanagement.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.workflowmanagement.R;
import com.example.workflowmanagement.ViewTaskPagerAdapter;
import com.google.android.material.tabs.TabLayout;

public class HomeFragment extends Fragment {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private View view;
    private String[] tabTitle = new String[]{"Hôm nay","Tuần","Tháng"};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home,container,false);
        AnhXa();
        ViewTaskPagerAdapter adapter = new ViewTaskPagerAdapter(getChildFragmentManager(),
                FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        customTab();
        return view;

    }



    private void customTab() {
        int tabCount = tabLayout.getTabCount();
        for (int i = 0; i < tabCount; i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            tab.setCustomView(R.layout.custom_tab_task);
            View view = tab.getCustomView();
            TextView title = view.findViewById(R.id.text);
            title.setText(tabTitle[i]);
        }
    }
    private void AnhXa() {
        tabLayout = view.findViewById(R.id.tablayout1);
        viewPager = view.findViewById(R.id.viewpager);
    }
}