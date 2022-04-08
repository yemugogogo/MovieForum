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

public class Blogfragment extends Fragment {
    @Nullable
    private TabLayout mTabs;
    private ViewPager mViewPager;


    //private tabd mTabd;
    private RelativeLayout mTaba;
    private RelativeLayout mTabb;
    private RelativeLayout mTabd;
    private RelativeLayout mTabc;

//    public Context mainContext;
//    public void setMainContext(Context mainContext) {
//        this.mainContext = mainContext;
//    }

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.e("jjjj", "onCreate called.");
        return inflater.inflate(R.layout.blog,null);

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        // Here is where we can get the context.
        Log.e("jjjj", "onAttach called.");
        mTabd = new tabd(context);
        mTabc = new tabc(context);
        mTabb = new tabb(context);
        mTaba = new taba(context);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Log.e("jjjj", "onViewCreated called.");


        super.onViewCreated(view, savedInstanceState);
        //Log.e("jjjj", String.valueOf(getView()));
        mTabs = (TabLayout) getView().findViewById(R.id.toptab);
        mViewPager = (ViewPager) getView().findViewById(R.id.viewpager);
        mViewPager.setAdapter(new SamplePagerAdapter());
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabs));
        mTabs.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));
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
            return "Item " + (position + 1);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            Object view = null;
            switch (position) {
                case 0:
                    Log.e("jjjj", "0");
                    view = mTaba;
                    container.addView(mTaba);
                    break;
                case 1:
                    //Log.e("jjjj", "1");
                    view = mTabb;
                    container.addView(mTabb);
                    break;
                case 2:
                    Log.e("jjjj", "2");
                    view = mTabc;
                    container.addView(mTabc);
                    break;
                case 3:
                    Log.e("jjjj", "3");
                    //mTabd.setMainContext(mainContext);
                    view = mTabd;
                    container.addView(mTabd);
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
