package mdzz.com.first_of_mdzz.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by My on 2016/11/15.
 */

public class MyFragmentPaperAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragmentList;
    private List<String> listtitle;

    public MyFragmentPaperAdapter(FragmentManager fm, List<Fragment> fragmentList, List<String> listtitle) {
        super(fm);
        this.fragmentList=fragmentList;
        this.listtitle=listtitle;

    }



    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return listtitle.get(position);
    }
}
