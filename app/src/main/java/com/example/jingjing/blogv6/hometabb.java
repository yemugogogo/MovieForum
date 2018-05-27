package com.example.jingjing.blogv6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

class hometabb extends RelativeLayout {
    private Context myContext;
    private Context mainContext;
    private View view02;
    public hometabb(Context context) {
        super(context);
        myContext = context;
        view02 = LayoutInflater.from(myContext).inflate(R.layout.hometabb, null);
        addView(view02);
    }
}
