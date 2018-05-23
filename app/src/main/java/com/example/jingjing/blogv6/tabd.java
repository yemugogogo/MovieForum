package com.example.jingjing.blogv6;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class tabd extends RelativeLayout {
    private Button button;
    private Context myContext;
    private View view01;
    private View view02;
    //private Activity originalActivity;

    //public void setActivity(Activity source) {
    //    originalActivity = source;
    //}

    public tabd(Context context) {
        super(context);
        myContext = context;
        view01 = LayoutInflater.from(myContext).inflate(R.layout.tabd, null);
        //view01 = LayoutInflater.from(myContext).inflate(R.layout.activity_test, null);

        addView(view01);

        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openest();
                Log.e("ooo", "onClick registered for tabd class");
            }
        });
    }

    public void openest() {
        Log.e("kkk", "Button clicked");
        //removeAllViews();
        //addView(view02);

        Intent intent = new Intent(myContext, test.class);
        myContext.startActivity(intent);
        //button.setText("I'm clicked!");
    }
}
