package com.example.jingjing.blogv6;

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

    public tabd(Context context) {
        super(context);
        View view = LayoutInflater.from(context).inflate(R.layout.tabd, null);
        addView(view);
        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openest();
                Log.e("jjj", "onClick registered for tabd class");
            }
        });
    }

    public void openest() {
        Log.e("ooo", "Button clicked");
        button.setText("I'm clicked!");
    }
}
