package com.example.assignmentfirst.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.assignmentfirst.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Inspiron on 12/27/2016.
 */

public class SmallViewPagerAdapter extends FragmentStatePagerAdapter {




    private Context mContext;
    private List<Fragment> mFragments = new ArrayList<>();
    private SparseArray<Fragment> mFragment = new SparseArray<>();
    private List<String> mFragmentTitles = new ArrayList<>();
    private List<Integer> mFragmentIcons = new ArrayList<>();
    private List<Integer> mFragmentCount = new ArrayList<>();
    FragmentManager mFragmentManage;


    public SmallViewPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        this.mContext = context;
        mFragmentManage = fm;
    }

    public void addFragment(Fragment fragment, String title, int drawable) {
        mFragments.add(fragment);
        mFragmentTitles.add(title);
        mFragmentIcons.add(drawable);
    }

    public void replaceFrgment(Fragment oldfragment, Fragment newFragment){
        int index = mFragments.indexOf(oldfragment);
        mFragments.remove(index);
        mFragments.add(index , newFragment);
        notifyDataSetChanged();
    }


    public void addFragment(Fragment fragment, String title) {
        mFragments.add(fragment);
        mFragmentTitles.add(title);
    }

    public void addFragment(Fragment fragment, int drawable) {
        mFragments.add(fragment);
        mFragmentIcons.add(drawable);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

//    @Override
//    public CharSequence getPageTitle(int position) {
//
//        return mFragmentTitles.get(position);
//    }

    public View getTabView(int position) {
        View tab = LayoutInflater.from(mContext).inflate(R.layout.tabbar_view, null);


        TextView tabText = (TextView) tab.findViewById(R.id.tabText);
        tabText.setText(mFragmentTitles.get(position));
        if (position == 0) {
            tab.setSelected(true);
        }
        return tab;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Fragment fragment = (Fragment) super.instantiateItem(container, position);
        mFragment.put(position, fragment);
        return fragment;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        mFragment.remove(position);
        super.destroyItem(container, position, object);
    }

    public Fragment getRegisteredFragment(int position) {
        return mFragment.get(position);
    }



}