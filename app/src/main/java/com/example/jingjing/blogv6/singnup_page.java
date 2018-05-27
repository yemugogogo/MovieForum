package com.example.jingjing.blogv6;

import android.support.v7.app.AppCompatActivity;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

import com.google.firebase.firestore.FirebaseFirestore;

public class singnup_page extends AppCompatActivity {
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    Button button_signup;
    AutoCompleteTextView userid;
    AutoCompleteTextView useraccount;
    AutoCompleteTextView userpassword;
}
