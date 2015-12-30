package com.jianda.qiubai.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Administrator on 15-12-30.
 */
public class ShakeAdapter extends FragmentPagerAdapter {

    private List<Fragment> list;

    public ShakeAdapter(FragmentManager fm, List<Fragment> list) {
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
                ret="专享";
                break;
            case 1:
                ret="视频";
                break;
            case 2:
                ret="纯文";
                break;
            case 3:
                ret="纯图";
                break;
            case 4:
                ret="精华";
                break;
            case 5:
                ret="最新";
                break;
        }
        return ret;
    }
}
