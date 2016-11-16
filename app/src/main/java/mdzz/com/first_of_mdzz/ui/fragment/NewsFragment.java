package mdzz.com.first_of_mdzz.ui.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import mdzz.com.first_of_mdzz.R;
import mdzz.com.first_of_mdzz.adapter.Mainadapter;
import mdzz.com.first_of_mdzz.base.BaseFragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFragment extends BaseFragment {

    //数据源
    public static final String [] TABS={"热点","订阅","直播"};

    private List<Fragment> newsfragmentList=new ArrayList<>();

    private Mainadapter mainadapter;

    private ViewPager viewPager_newsFragment;

    private TabLayout tabLayout_newsFragment;

    private Toolbar toolbar_newsFragment;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_news, container, false);
        initViewPager(view);
        initTabLayout(view);
        initToolbar(view);
        return view;
    }
    private void initToolbar(View view) {
        toolbar_newsFragment=(Toolbar)view.findViewById(R.id.toolbar_newsfragment);

        toolbar_newsFragment.setSelected(true);

    }

    private void initTabLayout(View view) {
        tabLayout_newsFragment=(TabLayout)view.findViewById(R.id.tabLayout_newsFragment);
        tabLayout_newsFragment.setupWithViewPager(viewPager_newsFragment);

    }

    private void initViewPager(View view) {
        HotFragment hotFragment=new HotFragment();
        SubscriberFragment subscriberFragment=new SubscriberFragment();
        LiveFragment liveFragment=new LiveFragment();
        newsfragmentList.clear();
        newsfragmentList.add(hotFragment);
        newsfragmentList.add(subscriberFragment);
        newsfragmentList.add(liveFragment);

        viewPager_newsFragment=(ViewPager) view.findViewById(R.id.viewpager_newsfragment);
        mainadapter=new Mainadapter(getActivity().getSupportFragmentManager(),newsfragmentList,TABS);
        viewPager_newsFragment.setAdapter(mainadapter);
        viewPager_newsFragment.setOffscreenPageLimit(newsfragmentList.size()-1);
    }

}
