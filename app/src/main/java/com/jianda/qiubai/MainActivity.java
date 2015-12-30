package com.jianda.qiubai;
// okhttp2.7.0   picasso
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.jianda.qiubai.adapters.HomeAdapter;
import com.jianda.qiubai.adapters.ShakeAdapter;
import com.jianda.qiubai.fragments.CreamFragment;
import com.jianda.qiubai.fragments.HomeFragment;
import com.jianda.qiubai.fragments.NewFragment;
import com.jianda.qiubai.fragments.OnlyPictureFragment;
import com.jianda.qiubai.fragments.OnlyWordFragment;
import com.jianda.qiubai.fragments.QiushiFragment;
import com.jianda.qiubai.fragments.ShareFragment;
import com.jianda.qiubai.fragments.VideoFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener   {

    private NavigationView menu;
    private DrawerLayout drawer;
    private ActionBarDrawerToggle toggle;
    private ViewPager pager;
    private List<Fragment> fragments;
    private TabLayout tab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawer = (DrawerLayout) findViewById(R.id.drawer);
        menu = (NavigationView) findViewById(R.id.menu);
        menu.setNavigationItemSelectedListener(this);
        //显示home
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //三条横线的Menu
        toggle = new ActionBarDrawerToggle(this, drawer, 0, 0);
        toggle.syncState();
//      由DrawerLayout控制Toggle
        drawer.setDrawerListener(toggle);

        pager = (ViewPager) findViewById(R.id.pager);

        fragments = new ArrayList<Fragment>();
        fragments.add(new ShareFragment());
        fragments.add(new VideoFragment());
        fragments.add(new OnlyWordFragment());
        fragments.add(new OnlyPictureFragment());
        fragments.add(new CreamFragment());
        fragments.add(new NewFragment());

        pager.setAdapter(new ShakeAdapter(getSupportFragmentManager(), fragments));
        tab = (TabLayout) findViewById(R.id.tab);
        tab.setupWithViewPager(pager);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //Toggle 控制 DrawerLayout
      if (toggle.onOptionsItemSelected(item))
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.item_1:

                break;
            case R.id.item_2:
                fragments.clear();

                fragments.add(new VideoFragment());
                fragments.add(new OnlyWordFragment());

                pager.setAdapter(new HomeAdapter(getSupportFragmentManager(), fragments));

                tab.setupWithViewPager(pager);
                break;
            case R.id.item_3:

                break;
            case R.id.item_4:
                break;
            case R.id.group_1:
                break;
            case R.id.group_2:
                break;
            case R.id.group_3:
                break;
            case R.id.group_4:
                break;
            case R.id.group_5:
//                pager.setAdapter(new MyAdapter(getSupportFragmentManager(), list));
                tab = (TabLayout) findViewById(R.id.tab);
                tab.setupWithViewPager(pager);
                break;
            case R.id.group_6:
                //退出应用
//                finishAffinity();
                ActivityCompat.finishAffinity(this);
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
      return true;
    }

}
