package mdzz.com.first_of_mdzz.ui.fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import mdzz.com.first_of_mdzz.R;
import mdzz.com.first_of_mdzz.base.BaseFragment;
import mdzz.com.first_of_mdzz.database.PreUtils;
import mdzz.com.first_of_mdzz.ui.main.MainActivity;
import mdzz.com.first_of_mdzz.ui.main.MineReuseActivity;
import mdzz.com.first_of_mdzz.ui.main.login.LoginActivity;
import mdzz.com.first_of_mdzz.utils.UIManager;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyFragment extends BaseFragment implements View.OnClickListener{
    private TextView tv_news,tv_push,tv_club,tv_mark,tv_collect,tv_download,tv_set,text_username;
    private LinearLayout mlinearLayoutlogin,mlinearlayoutsuccess;
  private Context mContext ;
  private boolean isHide;
    private  String name;
    public MyFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext =context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        isHide = PreUtils.readBoolean(mContext,"login");
        name=PreUtils.readStrting(mContext,"username");

        Log.e("sss", "onCreateView: "+name );

        View rootView = inflater.inflate(R.layout.fragment_my, container, false);
        initView(rootView);
        return rootView;
    }



    private void initView(View rootView) {
        mlinearLayoutlogin=(LinearLayout)rootView.findViewById(R.id.linearlayout_my_login);
        mlinearlayoutsuccess=(LinearLayout)rootView.findViewById(R.id.linearlayout_my_loginsuccsh);
        tv_news = (TextView) rootView.findViewById(R.id.news);
        tv_push = (TextView) rootView.findViewById(R.id.push);
        tv_club = (TextView) rootView.findViewById(R.id.zaker_club);
        tv_mark = (TextView) rootView.findViewById(R.id.mark);
        text_username=(TextView)rootView.findViewById(R.id.text_username);
        tv_collect = (TextView) rootView.findViewById(R.id.collect);
        tv_download = (TextView) rootView.findViewById(R.id.download);
        tv_set = (TextView) rootView.findViewById(R.id.set);
        mlinearLayoutlogin.setOnClickListener(this);
        tv_news.setOnClickListener(this);
        tv_push.setOnClickListener(this);
        tv_club.setOnClickListener(this);
        tv_mark.setOnClickListener(this);
        tv_collect.setOnClickListener(this);
        tv_download.setOnClickListener(this);
        tv_set.setOnClickListener(this);

        hideView(isHide);
    }

    private void hideView(boolean  b) {
        if(b){
            mlinearLayoutlogin .setVisibility(View.INVISIBLE);
            mlinearlayoutsuccess.setVisibility(View.VISIBLE);

            text_username.setText(name);


        }

    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()){
            case R.id.news:
                intent.setClass(mContext,MineReuseActivity.class);
                intent.putExtra("1","消息中心");

                break;
            case R.id.push:
                intent.setClass(mContext,MineReuseActivity.class);
                intent.putExtra("1","推送资讯");

                break;
            case R.id.zaker_club:
                String url ="http://iphone.myzaker.com/zaker/hd_center.php";
                UIManager.startWebActivity(getActivity(),url,"ZAKER俱乐部");
                break;
            case R.id.mark:
                String url_two = "http://m.zkshop.myzaker.com/";
                UIManager.startWebActivity(getActivity(),url_two,"积分商城");
                break;
            case R.id.collect:
                intent.setClass(mContext,MineReuseActivity.class);
                intent.putExtra("1","我的收藏");

                break;
            case R.id.download:
                intent.setClass(mContext,MineReuseActivity.class);
                intent.putExtra("1","离线下载");
                //startActivity(intent);
                break;
            case R.id.set:

                PreUtils.writeBoolean(mContext, "login", false);


                mlinearlayoutsuccess.setVisibility(View.INVISIBLE);
                mlinearLayoutlogin.setVisibility(View.VISIBLE);
                intent.setClass(mContext, MainActivity.class);
                break;
            case R.id.linearlayout_my_login:
                intent.setClass(getContext(), LoginActivity.class);


        }
              startActivity(intent);
    }
}
