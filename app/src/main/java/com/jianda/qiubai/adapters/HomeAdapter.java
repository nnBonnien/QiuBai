package com.jianda.qiubai.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Administrator on 15-12-30.
 */
public class HomeAdapter extends FragmentPagerAdapter{
    private List<Fragment> list;

    public HomeAdapter(FragmentManager fm, List<Fragment> list) {
        super(fm);
        this.list = list;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String ret="无标题";

        switch(position){
            case 0:
                ret="隔壁";
                break;
            case 1:
                ret="已粉";
                break;
        }
        return ret;
    }
}
