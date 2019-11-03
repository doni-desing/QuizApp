package com.example.lession;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.example.lession.data.FragmentPagerAdapter;
import com.example.lession.settings.SettingsFragment;
import com.example.lession1.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private MainViewModel mainViewModel;
    private ViewPager viewPager;
        MenuItem prevMenuItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        getApplicationContext();
        setContentView(R.layout.activity_main);
        final ViewPager viewPager = findViewById(R.id.viewPager);
//        navigationView();

        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) );
        final TextView textView = findViewById(R.id.mainTextView);
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        mainViewModel.init();
        mainViewModel.title.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
textView.setText(s);
            }
        });
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
mainViewModel.changeTitle();
            }
        }, 2000);

        final FragmentPagerAdapter adapter = new FragmentPagerAdapter(getSupportFragmentManager());
        final BottomNavigationView navView = findViewById(R.id.nav_view);
//        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
//                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
//                .build();
//
//        NavController navController = Navigation.findNavController(this,R.id.mobile_navigation );
//        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
//        NavigationUI.setupWithNavController(navView, navController);
        navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.bottomNavigation:
                        viewPager.setCurrentItem(0);
                        break;

                    case R.id.bottomNavigation1:
                        viewPager.setCurrentItem(1);
                        break;

                    case R.id.bottomNavigation2:
                        viewPager.setCurrentItem(2);
                        break;
                }
                return false;
            }
        });
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
          if (prevMenuItem != null) {
              prevMenuItem.setCheckable(false);
          } else {
              navView.getMenu().getItem(1).setCheckable(false);
          }
                navView.getMenu().getItem(2).setCheckable(true);
          prevMenuItem = navView.getMenu().getItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

}
