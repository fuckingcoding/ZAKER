package mdzz.com.first_of_mdzz.ui.main.subscriber;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import mdzz.com.first_of_mdzz.R;
import mdzz.com.first_of_mdzz.adapter.NewsFragmntAdapter.SubAdapter;
import mdzz.com.first_of_mdzz.bean.subscibe.FashionBean;
import mdzz.com.first_of_mdzz.config.Constant;
import mdzz.com.first_of_mdzz.config.UrlConfig;
import mdzz.com.first_of_mdzz.ui.main.subscriber.SubItemMvp.SubItemFragmentContract;
import mdzz.com.first_of_mdzz.ui.main.subscriber.SubItemMvp.SubItemFragmentPresenter;
import mdzz.com.first_of_mdzz.ui.web.WebActivity;
import mdzz.com.first_of_mdzz.utils.DividerGridItemDecoration;

public class SubItemBaseActivity extends AppCompatActivity implements SubItemFragmentContract.ISubItemView,SubAdapter.IOnItemClickListener{
    private Context mContext=this;
    private RecyclerView recyclerView;

    private SubAdapter madapter;
    private GridLayoutManager mlayoutManager;

    private int mCurPage=1;
    private ImageView imageView_sub_top;
    private String url;
    private String mUrlString;

    private String weburl;

    private List<FashionBean.DataBean.ArticlesBean> list=new ArrayList<>();

    private Toolbar toolbar_SubItemActivity;

    private int mLastVisibleItem = 0;

    private SubItemFragmentContract.ISubItemPresenter presenter;

    private Toolbar toolbar_subactivity;
    private List<FashionBean.DataBean.ArticlesBean> articles;
    private String title;

    private String  itemurl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_item_base);
        presenter=new SubItemFragmentPresenter(this);

        Intent intent =getIntent();
        Bundle extras = intent.getExtras();
         title= extras.getString("title");
        initToolbar();
        initData();
        presenter.getBean(itemurl);
        innitview();



    }
    private void initToolbar() {
        toolbar_SubItemActivity=(Toolbar)findViewById(R.id.toolBar_sub_activity);
        setSupportActionBar(toolbar_SubItemActivity);
        ActionBar supportActionBar = getSupportActionBar();
        supportActionBar.setTitle(title);



    }
    private void initData() {
        if(title.toString().equals("时尚频道")){
            itemurl= UrlConfig.FashionUrl;
            toolbar_SubItemActivity.setLogo(R.mipmap.ic_fasion);
        }
        if(title.toString().equals("国内头条")){
            itemurl= UrlConfig.NewsLoadUrl;
            toolbar_SubItemActivity.setLogo(R.mipmap.ic_inland_news);
        }
        if(title.toString().equals("国际头条")){
            itemurl= UrlConfig.NesForeignUrl;
            toolbar_SubItemActivity.setLogo(R.mipmap.ic_international_news);
        }
        if(title.toString().equals("娱乐八卦")){
            itemurl= UrlConfig.YuLeUrl;
            toolbar_SubItemActivity.setLogo(R.mipmap.ic_bagua);
        }
        if(title.toString().equals("汽车频道")){
            itemurl= UrlConfig.CarUrl;
            toolbar_SubItemActivity.setLogo(R.mipmap.ic_car);
        }
        if(title.toString().equals("财经新闻")){
            itemurl= UrlConfig.MoneyUrl;
            toolbar_SubItemActivity.setLogo(R.mipmap.ic_money);
        }
        if(title.toString().equals("体育频道")){
            itemurl= UrlConfig.TiYuUrl;
            toolbar_SubItemActivity.setLogo(R.mipmap.ic_sports);
        }
        if(title.toString().equals("互联网")){
            itemurl= UrlConfig.IntUrl;
            toolbar_SubItemActivity.setLogo(R.mipmap.ic_internet);
        }
        if(title.toString().equals("电影资讯")){
            itemurl= UrlConfig.MovieUrl;
            toolbar_SubItemActivity.setLogo(R.mipmap.ic_movie);
        }




    }

    private void innitview() {
        //   ptrFrameLayout_main=(PtrFrameLayout)findViewById(R.id.ptrfragment_sub);
        imageView_sub_top=(ImageView)findViewById(R.id.imageview_subactivity_top);
        recyclerView=(RecyclerView)findViewById(R.id.recycleview_subactivity);
        //recycleview的基本设置
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerGridItemDecoration(mContext));
        //设置布局为竖直
        mlayoutManager=new GridLayoutManager(mContext,2);
        recyclerView.setLayoutManager(mlayoutManager);
        madapter=new SubAdapter(mContext,list,this);
        recyclerView.setAdapter(madapter);


//        //设置文字闪烁
//        StoreHouseHeader storeHouseHeader = new StoreHouseHeader(mContext);
//        storeHouseHeader.setBackgroundColor(Color.BLACK);
//        storeHouseHeader.initWithString("M D Z Z...", 40);
//
//        ptrFrameLayout_main.setHeaderView(storeHouseHeader);
//
//        ptrFrameLayout_main.addPtrUIHandler(storeHouseHeader);
//
//        //设置下拉刷新监听器
//        ptrFrameLayout_main.setPtrHandler(new PtrDefaultHandler() {
//            @Override
//            public void onRefreshBegin(PtrFrameLayout frame) {
//                mCurPage=1;
//                mUrlString = String.format(MyUrlContants.FashionUrl, mCurPage);
//                Log.i(TAG, "onRefreshBegin: "+mUrlString);
//
//
//                persenter.getFashionBean(MyUrlContants.FashionUrl);
//                mCurPage++;
//            }
//
//
//        });
        //设置RecyclerView的滚动监听，目的是实现上拉加载下一页
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
//                //判断是否该加载更多数据（1.屏幕处于停止状态；2.屏幕已经滑动到了item的最底端）
//                if (mLastVisibleItem == madapter.getItemCount() - 1 && newState == RecyclerView
//                        .SCROLL_STATE_IDLE) {
//                    mCurPage++;
//                    persenter.getFashionBean(MyUrlContants.FashionUrl);
//                    for (int i = 0; i <5 ; i++) {
//                        String url1= String.format(MyUrlContants.FashionUrl1,i);
//
//                        persenter.getFashionBean(url1);
//                    }

            //    }
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
    public void getData(FashionBean bean) {
         articles = bean.getData().getArticles();

        url=articles.get(2).getThumbnail_mpic();
        //Log.e("sss", "getData: "+url);
        Glide.with(mContext).load(url)
               // .placeholder(R.mipmap.ic_launcher)//设置站位图
                .error (R.mipmap.ic_load_error)//加载失败的图片
                .centerCrop()//拉伸属性
                .into(imageView_sub_top);
        imageView_sub_top.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                weburl=articles.get(2).getWeburl();
                Jump();
            }
        });
        if (mCurPage == 1) {
            madapter.reloadRecyclerView(articles, true);
        } else {
            madapter.reloadRecyclerView(articles, false);
        }
    }

    @Override
    public void onclick(int position) {
        weburl=articles.get(position).getWeburl();
        Jump();
    }

    private void Jump() {
        Intent intent = new Intent(mContext, WebActivity.class);
        Bundle bundle= new Bundle();
        bundle.putString(Constant.WEB_URL,weburl);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
