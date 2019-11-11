package com.example.lession;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.lession1.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.ripple.RippleUtils;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private FragmentPagerAdapter adapter;
    private MainViewModel mainViewModel;
    private BottomNavigationView navView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new FragmentPagerAdapter(getSupportFragmentManager());
        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter( adapter);
        navView = findViewById(R.id.nav_view);

        init();
        clickPager();
        navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.bottomNavigation:
                        viewPager.setCurrentItem(0);
                        break;

                    case R.id.bottomNavigation1:
//                        navView.setBackgroundColor(getColor(R.color.colorAccent));
                        viewPager.setCurrentItem(1);
                        break;

                    case R.id.bottomNavigation2:
//                        navView.setBackgroundColor(getColor(R.color.colorAccent));
                        viewPager.setCurrentItem(2);
                        break;
                }
                return false;
            }
        });
    }

    public void init(){
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        mainViewModel.init();
        mainViewModel.title.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {

            }
        });
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mainViewModel.changeTitle();
            }
        }, 2000);

    }

    private void clickPager(){
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onPageSelected(int position) {
                navView.getMenu().getItem(position).setChecked(true);
//                navView.setItemRippleColor(ColorStateList.valueOf(getResources().getColor(R.color.purple)));
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}

