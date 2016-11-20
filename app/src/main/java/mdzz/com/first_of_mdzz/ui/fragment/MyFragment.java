package mdzz.com.first_of_mdzz.ui.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import mdzz.com.first_of_mdzz.R;
import mdzz.com.first_of_mdzz.base.BaseFragment;
import mdzz.com.first_of_mdzz.utils.ToastHelper;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyFragment extends BaseFragment implements View.OnClickListener{
    private TextView tv_news,tv_push,tv_club,tv_mark,tv_collect,tv_download,tv_set;


    public MyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_my, container, false);
        initView(rootView);
        return rootView;
    }



    private void initView(View rootView) {
        tv_news = (TextView) rootView.findViewById(R.id.news);
        tv_push = (TextView) rootView.findViewById(R.id.push);
        tv_club = (TextView) rootView.findViewById(R.id.zaker_club);
        tv_mark = (TextView) rootView.findViewById(R.id.mark);
        tv_collect = (TextView) rootView.findViewById(R.id.collect);
        tv_download = (TextView) rootView.findViewById(R.id.download);
        tv_set = (TextView) rootView.findViewById(R.id.set);
        tv_news.setOnClickListener(this);
        tv_push.setOnClickListener(this);
        tv_club.setOnClickListener(this);
        tv_mark.setOnClickListener(this);
        tv_collect.setOnClickListener(this);
        tv_download.setOnClickListener(this);
        tv_set.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.news:
                ToastHelper.showToast(getActivity(),"此功能暂未开放，敬请期待");
                break;
            case R.id.push:
                ToastHelper.showToast(getActivity(),"此功能暂未开放，敬请期待");
                break;
            case R.id.zaker_club:
                ToastHelper.showToast(getActivity(),"此功能暂未开放，敬请期待");
                break;
            case R.id.mark:
                ToastHelper.showToast(getActivity(),"此功能暂未开放，敬请期待");
                break;
            case R.id.collect:
                ToastHelper.showToast(getActivity(),"此功能暂未开放，敬请期待");
                break;
            case R.id.download:
                ToastHelper.showToast(getActivity(),"此功能暂未开放，敬请期待");
                break;
            case R.id.set:
                ToastHelper.showToast(getActivity(),"此功能暂未开放，敬请期待");
                break;

        }
    }
}
