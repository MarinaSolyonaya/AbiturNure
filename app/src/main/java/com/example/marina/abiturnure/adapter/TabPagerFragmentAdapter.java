package com.example.marina.abiturnure.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.marina.abiturnure.fragment.AbstractTabFragment;
import com.example.marina.abiturnure.fragment.BlogFragment;
import com.example.marina.abiturnure.fragment.NewsFragment;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Marina on 31.08.2017.
 */

public class TabPagerFragmentAdapter extends FragmentPagerAdapter {

    private Map<Integer,AbstractTabFragment> tabs;
    private Context context;

    public TabPagerFragmentAdapter (Context context, FragmentManager fm){
        super(fm);
        this.context = context;
        initTabMap(context);

    }


    @Override
    public CharSequence getPageTitle(int position) {

        return tabs.get(position).getTitle();
    }

    @Override
    public Fragment getItem(int position) {

        return tabs.get(position);
    }

    @Override
    public int getCount() {
        return tabs.size();
    }

    private void initTabMap(Context context) {
        tabs = new HashMap<>();
        tabs.put(0, NewsFragment.getInstance(context));
        tabs.put(1, BlogFragment.getInstance(context));
    }
}
