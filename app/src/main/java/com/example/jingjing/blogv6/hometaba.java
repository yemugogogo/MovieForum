package com.example.jingjing.blogv6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

class hometaba extends RelativeLayout {
    private Context myContext;
    private Context mainContext;
    private View view02;

    public hometaba(Context context) {
        super(context);
        myContext = context;
        view02 = LayoutInflater.from(myContext).inflate(R.layout.hometaba, null);
        addView(view02);


    }


}
