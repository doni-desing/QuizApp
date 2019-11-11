package com.example.lession;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.lession.history.HistoryFragment;
import com.example.lession.settings.SettingsFragment;

public class FragmentPagerAdapter extends androidx.fragment.app.FragmentPagerAdapter {
    public FragmentPagerAdapter(@NonNull FragmentManager fm ) {
        super(fm);
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new MainFragment();
            case 1:
                return new HistoryFragment();
            case 2:
                return new SettingsFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
