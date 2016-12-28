package com.example.assignmentfirst.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.assignmentfirst.R;
import com.example.assignmentfirst.adapter.SmallViewPagerAdapter;
import com.example.assignmentfirst.extras.Keys;

/**
 * Created by Inspiron on 12/27/2016.
 */

public class Home extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.home_layout,container,false);
    }

    private SmallViewPagerAdapter adapter;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private TextView text;
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        inializeViewPager(view);
    }

    private void inializeViewPager(View view) {
        tabLayout = (TabLayout)view.findViewById(R.id.tabLayout);
        viewPager = (ViewPager)view.findViewById(R.id.viewPager);
        setupViewPager();
        setupTabLayout(tabLayout);
    }



    private void setupViewPager()   {
        adapter = new SmallViewPagerAdapter(getActivity(),getChildFragmentManager());
        Fragment fragment1 = new ListStores();
        Fragment fragment2 = new MapStores();
        Bundle bundle = new Bundle();
        bundle.putString(Keys.StoreList,getArguments().getString(Keys.StoreList));
        fragment1.setArguments(bundle);
        fragment2.setArguments(bundle);
        adapter.addFragment(fragment1, "List View");
        adapter.addFragment(fragment2, "Map View");
        viewPager.setAdapter(adapter);
    }

    public void setupTabLayout(TabLayout tabLayout) {
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        tabLayout.setTabGravity(TabLayout.GRAVITY_CENTER);
        tabLayout.setupWithViewPager(viewPager);
        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            tab.setCustomView(adapter.getTabView(i));
        }
        tabLayout.requestFocus();
    }
}
