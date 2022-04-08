package com.example.jingjing.blogv6;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.fragment.app.Fragment;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity
        implements BottomNavigationView.OnNavigationItemSelectedListener{

    //private Button button;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navigation =  findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);
        navigation.setSelectedItemId(R.id.navigation_home);
        Log.e("itspeter", "Do I get the user ?" + LoginActivity.user);

    }


    private boolean loadFragment(Fragment fragment){
        if(fragment != null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container,fragment)
                    .commit();

            return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment=null;
        //Blogfragment blogfragment;

        switch (item.getItemId()){
            case R.id.navigation_home:
                fragment=new Homefragment();
                break;
            case R.id.navigation_news:
                fragment=new Newsfragment();
                break;
            case R.id.navigation_blog:
                //blogfragment = new Blogfragment();
                //blogfragment.setMainContext(getApplicationContext());
                //fragment = (Fragment) blogfragment;
                fragment=new Blogfragment();
                break;
            case R.id.navigation_mine:
                fragment=new Minefragment();
                break;

        }
        return loadFragment(fragment);
    }
}
