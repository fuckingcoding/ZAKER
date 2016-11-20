package mdzz.com.first_of_mdzz.ui.fragment.newschildfragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import mdzz.com.first_of_mdzz.R;
import mdzz.com.first_of_mdzz.adapter.DragAdapter;
import mdzz.com.first_of_mdzz.adapter.MyViewPagerAdapter;
import mdzz.com.first_of_mdzz.base.BaseFragment;
import mdzz.com.first_of_mdzz.bean.subscibe.FashionBean;
import mdzz.com.first_of_mdzz.config.Constant;
import mdzz.com.first_of_mdzz.config.UrlConfig;
import mdzz.com.first_of_mdzz.ui.fragment.drag.DragItemCallBack;
import mdzz.com.first_of_mdzz.ui.fragment.drag.RecycleCallBack;
import mdzz.com.first_of_mdzz.ui.main.subscriber.SubItemBaseActivity;
import mdzz.com.first_of_mdzz.ui.main.subscriber.SubItemMvp.SubItemFragmentContract;
import mdzz.com.first_of_mdzz.ui.main.subscriber.SubItemMvp.SubItemFragmentPresenter;
import mdzz.com.first_of_mdzz.ui.web.WebActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class SubscriberFragment extends BaseFragment implements RecycleCallBack, SubItemFragmentContract.ISubItemView {


    private Context mContext;
    private RecyclerView mRecyclerView;
    private DragAdapter mAdapter;
    private ArrayList<String> mList;
    private ItemTouchHelper mItemTouchHelper;

    private SubItemFragmentPresenter presenter;
    private ViewPager mSubViewpager;
    private TextView adText;
    //上方View的集合
    private ImageView iv;
    private List<View> adViews;
    private MyViewPagerAdapter adAdapter;


    private List<FashionBean.DataBean.ArticlesBean> articles;
    private List<String> adimgurl = new ArrayList<>();

    private Handler adHandler = new Handler();
    private ADRunnable adRunnable;
    private String adurl;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_subscriber, container, false);

        mList = new ArrayList<>();

        mList.add("时尚频道");
        mList.add("国内头条");
        mList.add("国际头条");
        mList.add("娱乐八卦");
        mList.add("汽车频道");
        mList.add("财经新闻");
        mList.add("体育频道");
        mList.add("互联网");
        mList.add("电影资讯");


        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycleview_subscriberfragment);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        mAdapter = new DragAdapter(this, mList, mContext);
        mItemTouchHelper = new ItemTouchHelper(new DragItemCallBack(this));
        mItemTouchHelper.attachToRecyclerView(mRecyclerView);
        mRecyclerView.setAdapter(mAdapter);

        mSubViewpager = (ViewPager) view.findViewById(R.id.viewpager_subscribeframent);
        adText = (TextView) view.findViewById(R.id.ad_tv);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        presenter = new SubItemFragmentPresenter(this);
        presenter.getBean(UrlConfig.FashionUrl);
    }

    private void initAd() {
        initADItemView();

        initViewPager();

        adRunnable = new ADRunnable();

    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initAd();


    }

    //初始化AD的子View
    private void initADItemView() {
        adViews = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            ImageView iv = new ImageView(mContext);
            iv.setLayoutParams(new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
            )); //设置布局
            iv.setImageResource(R.mipmap.ic_mdzz); //设置图片资源
            adViews.add(iv);
        }
    }

    private void initViewPager() {

        adAdapter = new MyViewPagerAdapter(adViews);
        mSubViewpager.setOffscreenPageLimit(6);
        mSubViewpager.setAdapter(adAdapter);

        //ViewPager滑动监听
        mSubViewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int
                    positionOffsetPixels) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }

            @Override
            public void onPageSelected(int position) {

                //处理文字
                initADText(position);
            }
        });
        //触摸监听，按下的时候取消handler回调，松手的时候，重新开启
        mSubViewpager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction(); //获得动作
                switch (action) {
                    case MotionEvent.ACTION_DOWN: //按下
                        adHandler.removeCallbacks(adRunnable);
                        break;
                    case MotionEvent.ACTION_UP: //提前
                        adHandler.postDelayed(adRunnable, 2000);

                        break;
                }
                return false;
            }
        });
    }

    private void initADText(int position) {
        if (articles != null) {
            //获得当前ViewPager位置
            adText.setText(articles.get(position).getTitle());
        }
    }


    @Override
    public void itemOnClick(int position, View view) {
        if (view.getId() == R.id.del) {
            mList.remove(position);
            mAdapter.setData(mList);
            mAdapter.notifyItemRemoved(position);
        } else {
            String basetitle = mList.get(position).toString();

            //  Toast.makeText(mContext, "当前点击的是" +  basetitle, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getContext(), SubItemBaseActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("title", basetitle);
            intent.putExtras(bundle);
            startActivity(intent);
            mAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onMove(int from, int to) {
        synchronized (this) {
            if (from > to) {
                int count = from - to;
                for (int i = 0; i < count; i++) {
                    Collections.swap(mList, from - i, from - i - 1);
                }
            }
            if (from < to) {
                int count = to - from;
                for (int i = 0; i < count; i++) {
                    Collections.swap(mList, from + i, from + i + 1);
                }
            }
            mAdapter.setData(mList);
            mAdapter.notifyItemMoved(from, to);
            mAdapter.show.clear();
            mAdapter.show.put(to, to);
        }
    }


    @Override
    public void getData(FashionBean bean) {
        articles = bean.getData().getArticles();

        for (int i = 0; i < adViews.size(); i++) {
            //获得广告的ImageView
            ImageView adIv = (ImageView) adViews.get(i);
            //TODO 使用Picasso加载资
            Glide.with(mContext)
                    .load(articles.get(i+2).getThumbnail_pic())

                    .centerCrop()
                    .into(adIv);

            adText.setText(articles.get(i+2).getTitle());
            adurl = articles.get(i+2).getWeburl();
            adIv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(mContext, WebActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString(Constant.WEB_URL, adurl);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            });
        }


    }

    //广告轮播的任务
    class ADRunnable implements Runnable {
        @Override
        public void run() {
            int currentPosition = mSubViewpager.getCurrentItem(); //获得当前的位置
            currentPosition++;
            if (currentPosition > 2) {
                currentPosition = 0;
            }
            mSubViewpager.setCurrentItem(currentPosition);//重新设置位置
            //            adRunnable = new ADRunnable();
            adHandler.postDelayed(adRunnable, 2000);
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        adHandler.removeCallbacks(adRunnable);
    }

    @Override
    public void onResume() {
        super.onResume();
        adHandler.postDelayed(adRunnable, 2000);
    }
}
