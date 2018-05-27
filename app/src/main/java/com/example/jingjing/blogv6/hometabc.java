package com.example.jingjing.blogv6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

class hometabc extends RelativeLayout {
    private Context myContext;
    private Context mainContext;
    private View view02;
    public hometabc(Context context) {
        super(context);
        myContext = context;
        view02 = LayoutInflater.from(myContext).inflate(R.layout.hometabc, null);
        addView(view02);
    }
}
