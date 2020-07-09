package com.weaponreviewsteps.ui.main;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.weaponreviewsteps.Preliminary;
import com.weaponreviewsteps.R;
import com.weaponreviewsteps.Tab1;
import com.weaponreviewsteps.Tab2;
import com.weaponreviewsteps.Tab3;
import com.weaponreviewsteps.Tab4;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_Preliminary, R.string.tab_text_1, R.string.tab_text_2, R.string.tab_text_3, R.string.tab_text_4};
    private final Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0:
                Preliminary prelim = new Preliminary();
                        return prelim;
            case 1:
                Tab1 tab1 = new Tab1();
                return tab1;
            case 2:
                Tab2 tab2 = new Tab2();
                return tab2;
            case 3:
                Tab3 tab3 = new Tab3();
                return tab3;
            case 4:
                Tab4 tab4 = new Tab4();
                return tab4;
            default:
                return null;

        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return TAB_TITLES.length;
    }
}