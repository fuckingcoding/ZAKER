package mdzz.com.first_of_mdzz.ui.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import mdzz.com.first_of_mdzz.R;
import mdzz.com.first_of_mdzz.adapter.MyFragmentPaperAdapter;
import mdzz.com.first_of_mdzz.base.BaseFragment;
import mdzz.com.first_of_mdzz.ui.fragment.homechildfragment.ChoiceFragment;
import mdzz.com.first_of_mdzz.ui.fragment.homechildfragment.FriendFragment;
import mdzz.com.first_of_mdzz.ui.fragment.homechildfragment.TopicFragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseFragment {
    private Context mContext;
    private TabLayout tablayout;
    private List<Fragment> list_fragment;           //fragment的数据集合
    private List<String> list_title;                //TabLayout的名称集合
    private ViewPager viewpaper;
    private MyFragmentPaperAdapter myFragmentPaperAdapter; //定义适配器
    //将对应的三个Fragment，声明出来
    private TopicFragment topicFragment;
    private ChoiceFragment choiceFragment;
    private FriendFragment friendFragment;



    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext=context;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        initView(rootView);
        initData();
        initTabLayoutSet();
        return rootView;
    }

    private void initTabLayoutSet() {
        //设置TabLayout的模式
        tablayout.setTabMode(TabLayout.MODE_FIXED);
        //为TabLayout添加tab名称
        tablayout.addTab(tablayout.newTab().setText(list_title.get(0)));
        tablayout.addTab(tablayout.newTab().setText(list_title.get(1)));
        tablayout.addTab(tablayout.newTab().setText(list_title.get(2)));
        myFragmentPaperAdapter = new MyFragmentPaperAdapter(getChildFragmentManager(),list_fragment,list_title);
        viewpaper.setAdapter(myFragmentPaperAdapter);
        tablayout.setupWithViewPager(viewpaper);
        viewpaper.setOffscreenPageLimit(2);

    }

    private void initData() {
        //往Fragment数组中装入数据
        list_fragment.add(topicFragment);
        list_fragment.add(choiceFragment);
        list_fragment.add(friendFragment);

        //往TabLayout数组中放入名称
        list_title.add("话题");
        list_title.add("精选");
        list_title.add("好友圈");
    }

    private void initView(View rootView) {
        //初始化TabLayout组件
        tablayout = (TabLayout) rootView.findViewById(R.id.community_tablayout);
        //初始化ViewPaper
        viewpaper = (ViewPager) rootView.findViewById(R.id.community_viewpaper);

        //初始化Fragment的数组
        list_fragment = new ArrayList<>();
        //初始化TabLayout的名称
        list_title = new ArrayList<>();
        //初始化对应的三个Fragment
        topicFragment = new TopicFragment();
        choiceFragment = new ChoiceFragment();
        friendFragment = new FriendFragment();
    }

}
