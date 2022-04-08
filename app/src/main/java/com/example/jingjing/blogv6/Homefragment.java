package com.example.jingjing.blogv6;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.tabs.TabLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

public class Homefragment extends Fragment{
    @Nullable
    private TabLayout homeTabs;
    private ViewPager homeViewPager;




    //private tabd mTabd;
    private RelativeLayout homeTaba;
    private RelativeLayout homeTabb;
    private RelativeLayout homeTabc;
    private RelativeLayout homeTabd;

//    public Context mainContext;
//    public void setMainContext(Context mainContext) {
//        this.mainContext = mainContext;
//    }



    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.e("jjjj", "onCreate called.");
        return inflater.inflate(R.layout.home,null);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        // Here is where we can get the context.
        Log.e("jjjj", "onAttach called.");
        homeTaba = new hometaba(context);
        homeTabb = new hometabb(context);
        homeTabc = new hometabc(context);
        homeTabd = new hometabd(context);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Log.e("jjjj", "onViewCreated called.");


        super.onViewCreated(view, savedInstanceState);
        //Log.e("jjjj", String.valueOf(getView()));
        homeTabs = (TabLayout) getView().findViewById(R.id.toptab_home);
        homeViewPager = (ViewPager) getView().findViewById(R.id.viewpager_home);
        homeViewPager.setAdapter(new SamplePagerAdapter());
        homeViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(homeTabs));
        homeTabs.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(homeViewPager));
    }

    class SamplePagerAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return 4;
        }

        @Override
        public boolean isViewFromObject(View view, Object o) {
            return o == view;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return "Item" + (position + 1);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            Object view = null;
            switch (position) {
                case 0:
                    Log.e("jjjj", "excepted is 0");
                    Log.e("jjjj", "position is "+String.valueOf(position));
                    view = homeTaba;
                    container.addView(homeTaba);
                    break;
                case 1:
                    Log.e("jjjj", "excepted is 1");
                    Log.e("jjjj", "position is "+String.valueOf(position));
                    view = homeTabb;
                    container.addView(homeTabb);
                    break;
                case 2:
                    Log.e("jjjj", "excepted is 2");
                    Log.e("jjjj", "position is "+String.valueOf(position));

                    view = homeTabc;
                    container.addView(homeTabc);
                    break;
                case 3:
                    Log.e("jjjj", "excepted is 3");
                    Log.e("jjjj", "position is "+String.valueOf(position));
                    //mTabd.setMainContext(mainContext);
                    view = homeTabd;
                    container.addView(homeTabd);
                    break;
            }
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }
}
