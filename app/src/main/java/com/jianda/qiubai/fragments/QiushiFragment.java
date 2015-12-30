package com.jianda.qiubai.fragments;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jianda.qiubai.R;
import com.jianda.qiubai.adapters.ShakeAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class QiushiFragment extends Fragment {

    private ViewPager viewPager;
    private TabLayout tabLayout;

    public QiushiFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_qiushi2, container, false);

        viewPager = (ViewPager) view.findViewById(R.id.qiushi_viewpager);
        List<Fragment> fragments = new ArrayList<Fragment>();
        fragments.add(new ShareFragment());
        fragments.add(new VideoFragment());
        fragments.add(new OnlyWordFragment());
        fragments.add(new OnlyPictureFragment());
        fragments.add(new CreamFragment());
        fragments.add(new NewFragment());

        ShakeAdapter adapter = new ShakeAdapter(getChildFragmentManager(),fragments);
        viewPager.setAdapter(adapter);
        tabLayout = (TabLayout) view.findViewById(R.id.qiushi_tablayout);
        tabLayout.setupWithViewPager(viewPager);
        return view;
    }

}
