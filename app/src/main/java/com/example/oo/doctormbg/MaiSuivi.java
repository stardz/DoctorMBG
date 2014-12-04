package com.example.oo.doctormbg;


import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;

public class MaiSuivi extends FragmentActivity implements ActionBar.TabListener {

    ViewPager viewPager=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_suivi);
        viewPager= (ViewPager) findViewById(R.id.pager);
        final ActionBar actionBar=getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        addTabs(actionBar);
        viewPager.setAdapter(new MySuiviAdapter(getSupportFragmentManager()));
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i2) {
                Log.d("VIVZ","onPageScrolled "+i+" "+v+" "+i2);
            }

            @Override
            public void onPageSelected(int i) {
                actionBar.setSelectedNavigationItem(i);
                Log.d("VIVZ","onPageSelected "+i);
            }

            @Override
            public void onPageScrollStateChanged(int i) {
                if(i== ViewPager.SCROLL_STATE_IDLE)
                Log.d("VIVZ","onPageScrollStateChanged scroll state idle "+i);
                if(i== ViewPager.SCROLL_STATE_DRAGGING)
                    Log.d("VIVZ","onPageScrollStateChanged scroll state dragging "+i);
                if(i== ViewPager.SCROLL_STATE_SETTLING)
                    Log.d("VIVZ","onPageScrollStateChanged scroll state settling "+i);
            }
        });

        }
    private void addTabs(ActionBar actionBar)
    {
        ActionBar.Tab tab1=actionBar.newTab();
        tab1.setText("Tab 1");
        tab1.setTabListener(this);

        ActionBar.Tab tab2=actionBar.newTab();
        tab2.setText("Tab 2");
        tab2.setTabListener(this);

        ActionBar.Tab tab3=actionBar.newTab();
        tab3.setText("Tab 3");
        tab3.setTabListener(this);

        actionBar.addTab(tab1);
        actionBar.addTab(tab2);
        actionBar.addTab(tab3);
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        viewPager.setCurrentItem(tab.getPosition());
//        Log.d("VIVZ","onTabSelected "+tab.getText());
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
//        Log.d("VIVZ","onTabUnselected "+tab.getText());
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {
//        Log.d("VIVZ","onTabReselected "+tab.getText());
    }
}

class MySuiviAdapter extends FragmentStatePagerAdapter
{

    public MySuiviAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        Fragment fragment=null;
        if(i==0)
        {
            fragment=new Suivi1();
        }
        if(i==1)
        {
            fragment=new Suivi2();
        }
        if(i==2)
        {
            fragment=new Suivi3();
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
