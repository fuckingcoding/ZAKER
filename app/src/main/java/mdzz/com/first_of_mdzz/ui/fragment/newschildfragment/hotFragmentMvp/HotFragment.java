package mdzz.com.first_of_mdzz.ui.fragment.newschildfragment.hotFragmentMvp;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import mdzz.com.first_of_mdzz.R;
import mdzz.com.first_of_mdzz.adapter.HotRecycleAdapter;
import mdzz.com.first_of_mdzz.base.BaseFragment;
import mdzz.com.first_of_mdzz.bean.hot.HotBean;
import mdzz.com.first_of_mdzz.config.Constant;
import mdzz.com.first_of_mdzz.config.UrlConfig;
import mdzz.com.first_of_mdzz.ui.web.WebActivity;
import mdzz.com.first_of_mdzz.utils.DividerItemDecoration;

import static com.bumptech.glide.gifdecoder.GifHeaderParser.TAG;


/**
 * A simple {@link Fragment} subclass.
 */
public class HotFragment extends BaseFragment implements HotFragmentContract.IHotView, HotRecycleAdapter.IOnItemClickListener {
    private Context mContext;
    private HotFragmentPresenter presenter;
    private RecyclerView recyclerView_hotfragment;
    private HotRecycleAdapter hotRecycleAdapter;
    private LinearLayoutManager mlayoutManager;
    private List<HotBean> mTotalList = new ArrayList<>();
    private List<HotBean.DataBean.ArticlesBean> articles = new ArrayList<>();
    private HotBean.DataBean.InfoBean info;


    private String weburl;

    private int mLastVisibleItem = 0;
    private int mCurPage = 1;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;


    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        presenter = new HotFragmentPresenter(this);
        presenter.getBean(UrlConfig.Hot1Url);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_hot, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initRecycle(view);


    }

    private void initRecycle(View view) {
        recyclerView_hotfragment = (RecyclerView) view.findViewById(R.id.recyclerview_hotfragment);
        recyclerView_hotfragment.setHasFixedSize(true);
        recyclerView_hotfragment.setItemAnimator(new DefaultItemAnimator());
        recyclerView_hotfragment.addItemDecoration(new DividerItemDecoration(mContext,
                DividerItemDecoration.VERTICAL_LIST));

        mlayoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false);
        recyclerView_hotfragment.setLayoutManager(mlayoutManager);
        hotRecycleAdapter = new HotRecycleAdapter(mContext, articles, this);
        recyclerView_hotfragment.setAdapter(hotRecycleAdapter);
        recyclerView_hotfragment.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                //判断是否该加载更多数据（1.屏幕处于停止状态；2.屏幕已经滑动到了item的最底端）
                if (mLastVisibleItem == hotRecycleAdapter.getItemCount() - 1 && newState == RecyclerView
                        .SCROLL_STATE_IDLE) {

                     presenter.getBean(UrlConfig.HotNextUrl);

                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                //获取当前最低端的item的position
                mLastVisibleItem = mlayoutManager.findLastVisibleItemPosition();
            }
        });
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public void onStart() {
        super.onStart();

    }

    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    public void getData(HotBean bean) {
        //articles.clear();
        articles.addAll(bean.getData().getArticles());
        info = bean.getData().getInfo();

        // hotRecycleAdapter.reloadRecyclerView(articles,false);
        hotRecycleAdapter.notifyDataSetChanged();
    }

    @Override
    public void onclick(int position) {
        Log.e(TAG, "onclick: " + position);
        Log.e(TAG, "onclick: " + articles.size());
        weburl = articles.get(position).getWeburl();

        Log.e("www", "onclick: " + weburl);
        Jump();
    }

    private void Jump() {
        Intent intent = new Intent(mContext, WebActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString(Constant.WEB_URL, weburl);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
