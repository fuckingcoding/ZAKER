package mdzz.com.first_of_mdzz.ui.fragment;


import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import mdzz.com.first_of_mdzz.R;
import mdzz.com.first_of_mdzz.adapter.FunRecyclerAdapter;
import mdzz.com.first_of_mdzz.adapter.MyVpInfiniteAdapter;
import mdzz.com.first_of_mdzz.adapter.WeekAdapter;
import mdzz.com.first_of_mdzz.base.BaseFragment;
import mdzz.com.first_of_mdzz.bean.fun.BannerBean;
import mdzz.com.first_of_mdzz.bean.fun.ColumnsBean;
import mdzz.com.first_of_mdzz.bean.fun.DisplayBean;
import mdzz.com.first_of_mdzz.bean.fun.InfoBean;
import mdzz.com.first_of_mdzz.bean.fun.ItemsBean;
import mdzz.com.first_of_mdzz.bean.fun.PlayBean;
import mdzz.com.first_of_mdzz.bean.fun.PromoteBean;
import mdzz.com.first_of_mdzz.bean.week.WeekBean;
import mdzz.com.first_of_mdzz.bean.week.WeekendsBean;
import mdzz.com.first_of_mdzz.config.Constant;
import mdzz.com.first_of_mdzz.database.PreUtils;
import mdzz.com.first_of_mdzz.http.HttpUtils;
import mdzz.com.first_of_mdzz.ui.funguide.FunGuideActivity;
import mdzz.com.first_of_mdzz.ui.main.FunFragmentContract;
import mdzz.com.first_of_mdzz.ui.main.FunFragmentPresenter;
import mdzz.com.first_of_mdzz.utils.SpacesItemDecoration;
import mdzz.com.first_of_mdzz.utils.ToastHelper;
import mdzz.com.first_of_mdzz.utils.UIManager;


/**
 * A simple {@link Fragment} subclass.
 */

public class FunFragment extends BaseFragment
        implements View.OnClickListener,
        FunFragmentContract.IFunView,FunRecyclerAdapter.FunOnClickListener,WeekAdapter.WeekRecyclerClickListener {

   private Context mContext;
    private SwipeRefreshLayout refreshLayout,refreshLayout_second;
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private ViewPager viewPager;
    private ImageView imageView1,imageView2,imageView3;
    private RecyclerView recyclerView ,recyclerView_second;
    private TextView tv_city_ritht,tv_fun_left;
    private List<ImageView> list_imageview;
    private MyVpInfiniteAdapter adapter;
    private RecyclerView.LayoutManager manager;
    private LinearLayout mlinear_ad,lineartop;
    private  MyRunnable runnable;
    private Handler handler = new Handler();
    private List<WeekendsBean> list_weekends ;
    private List<ItemsBean> list_items; // recycler 的item
    private List<DisplayBean> list_display; // 三个固定的imageView
    private List<PromoteBean> list_promote; //轮播条
    private InfoBean infoBean; //下一条信息
    private List<ColumnsBean> list_col;//包含 list_items list_banner
    private  List<Object> list;
    private FunRecyclerAdapter funRecyclerAdapter;
    private WeekAdapter weekAdapter;
    private String cityname = "北京";
    private  String urlstring ;//跳转web的参数
    private  String title; // 跳转web的参数
    private int page =0;
    private int category ;
    private boolean  isHide;
    private List<SimpleTarget<Bitmap>> list_target;
    private boolean login;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
        login = PreUtils.readBoolean(mContext,"login");
        list = new ArrayList<>();
        list_weekends = new ArrayList<>();
        list_target= new ArrayList<>();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootview =inflater.inflate(R.layout.fragment_fun, container, false);

        return rootview;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        initData();


//
//        toolbar = (Toolbar) view.findViewById(R.id.toolbar);
//        setHasOptionsMenu(true);
//        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
//        ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
//        actionBar.setTitle("玩乐");



    }

    private void initOtherData() {
        FunFragmentPresenter presenter = new FunFragmentPresenter(this);
        Map<String, String> map = HttpUtils.getFunItemsMap(cityname,page,category);
        presenter.getWeekBean(map);
    }

    private void initMovieData(){
        FunFragmentPresenter presenter = new FunFragmentPresenter(this);
        Map<String, String> map = HttpUtils.getFunMoviewMap(cityname);
        presenter.getWeekBean(map);
    }

    private void initData() {
        list.clear();
        FunFragmentPresenter presenter = new FunFragmentPresenter(this);
        Map<String, String> map = HttpUtils.getPlayMap(cityname);
        presenter.getPlayBean(map);
    }


    private void initView(View view) {
        list_imageview = new ArrayList<>();
        collapsingToolbarLayout = (CollapsingToolbarLayout) view.findViewById(R.id.collapsing_fun);
        collapsingToolbarLayout.setTitleEnabled(false);

        refreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.refreshLayout);
        refreshLayout_second = (SwipeRefreshLayout) view.findViewById(R.id.refreshLayout_funsecond);
        imageView1 = (ImageView) view.findViewById(R.id.iv1_Funfrag);
        imageView2 = (ImageView) view.findViewById(R.id.iv2_Funfrag);
        imageView3 = (ImageView) view.findViewById(R.id.iv3_Funfrag);
        tv_city_ritht = (TextView) view.findViewById(R.id.tv_city_ritht);
        tv_fun_left = (TextView) view.findViewById(R.id.tv_fun_left);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView_Funfrag);
        recyclerView_second = (RecyclerView) view.findViewById(R.id.recyclerView_funsecond);
        viewPager = (ViewPager) view.findViewById(R.id.viewpager_Funfragment);
        mlinear_ad = (LinearLayout) view.findViewById(R.id.linear_ad);
        lineartop = (LinearLayout) view.findViewById(R.id.linear_top);
        for(int i =0;i<6;i++){
            final ImageView iv = new ImageView(mContext);
            iv.setTag(i);
            iv.setImageResource(R.mipmap.ic_mdzz);

            iv.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
          //  iv.setImageResource(R.mipmap.guide_loading_tag_46);
            iv.setScaleType(ImageView.ScaleType.FIT_XY);
            SimpleTarget<Bitmap> target = new SimpleTarget<Bitmap>() {
                @Override
                public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                    iv.setImageBitmap(resource);

                }
            };
            list_target.add(target);

            list_imageview .add(iv);
        }
        Log.e("TAG", "initView: "+list_imageview.size());

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initDot();
        initAdapter();
        initAdViewPager();
        initRecyclerView();
        initSwipeRefresh();
        imageView1.setOnClickListener(this);
        imageView2.setOnClickListener(this);
        imageView3.setOnClickListener(this);
        //tv_city_ritht.setOnClickListener(this);

            tv_city_ritht.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    if(login==true) {
                        refreshLayout_second.setRefreshing(false);
                        refreshLayout.setRefreshing(false);
                        Intent intent = new Intent(mContext, FunGuideActivity.class);
                        startActivityForResult(intent, Constant.REQUEST_FUN);
                    }else{
                        ToastHelper.showToast(mContext,"请先登录");
                    }
                }
            });
        }






    private void initSwipeRefresh() {
        refreshLayout .setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                initData();
            }
        });

        refreshLayout_second.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                initOtherData();
            }
        });
    }

    private void initAdapter() {
        adapter = new MyVpInfiniteAdapter(list_imageview);

        funRecyclerAdapter = new FunRecyclerAdapter(mContext,list,this);
        weekAdapter = new WeekAdapter(mContext,list_weekends,this);

    }
    private void initDot() {
        for (int i = 0; i < list_imageview.size()/2; i++) {

            ImageView iv = new ImageView(getActivity());
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            params.rightMargin = 10;
            iv.setLayoutParams(params);
            iv.setImageResource(R.drawable.ad_selector);
            if (i == 0) {
                iv.setSelected(true);
            }
            //TODO 轮播条的点击
            iv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });

            mlinear_ad.addView(iv);

        }
    }

    private void initAdViewPager() {
        viewPager.setAdapter(adapter);
        //匹配圆点和滚动页
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
            @Override
            public void onPageSelected( int position) {
                for(int i =0;i<list_imageview.size()/2;i++){
                    if(i==(position%list_imageview.size())){
                        //Log.e("TAG", "onPageSelected() returned: " + position%6);
                       mlinear_ad.getChildAt(i%(list_imageview.size()/2)).setSelected(true);
                    }else {
                        mlinear_ad.getChildAt(i%(list_imageview.size()/2)).setSelected(false);
                    }
                }
//                if(adinfo!=null){
//                    mtv_ad.setText(adinfo.getData().get(position%3).getName());
//                }
            }
            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

        viewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                switch (action){
                    case MotionEvent.ACTION_DOWN:
                        handler.removeCallbacks(runnable);
                        break;
                    case MotionEvent.ACTION_UP:
                        handler.postDelayed(runnable,4000);
                        break;
                }

                return false;
            }
        });

    }

    private void initRecyclerView() {
        manager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        recyclerView .setLayoutManager(manager);
        recyclerView.addItemDecoration(new SpacesItemDecoration(5));
        recyclerView.setAdapter(funRecyclerAdapter);
        recyclerView_second.setLayoutManager(new LinearLayoutManager(mContext,LinearLayoutManager.VERTICAL,false));
        recyclerView_second.addItemDecoration(new SpacesItemDecoration(5));
        recyclerView_second.setAdapter(weekAdapter);

    }

//    @Override
//    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
//        super.onCreateOptionsMenu(menu, inflater);
//        inflater.inflate(R.menu.menu_play,menu);
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        if(item.getItemId()==R.id.city){
//
//
//           // UIManager.startSelectCity(mContext,cityname);
//        }
//
//        return super.onOptionsItemSelected(item);
//    }

    @Override
    public void onPause() {
        super.onPause();
        handler.removeCallbacks(runnable);
    }
    @Override
    public void onResume() {
        super.onResume();
        runnable = new MyRunnable();
      handler.postDelayed(runnable,4000);
    }
   private int size_col ;
    private int size_promote;
    //TODO 下载网络数据
    @Override
    public void getData(PlayBean bean) {

        infoBean = bean.getData().getInfo();
        String page = infoBean.getPage();
        String show_category = infoBean.getShow_category();
        Log.e("TAG", "iiiiiiiiii: "+page+show_category );
        //三个imageview
        list_display = bean.getData().getDisplay();
        Log.e("TAG", "getData: "+list_display.size());
        //轮播条
        list_promote= bean.getData().getPromote();
        size_promote =list_promote.size();
        Log.e("TAG", "list_promote: "+list_promote.size());
        list_col = bean.getData().getColumns();
        size_col = list_col.size();
        setImage();


        for(int i =0;i<size_col;i++){
           //日期的图片
           BannerBean banner = bean.getData().getColumns().get(i).getBanner();
           list.add(banner);
           //子项目的bean
           List<ItemsBean> itemsBeanList = bean.getData().getColumns().get(i).getItems();
           for(int j=0;j<itemsBeanList.size();j++){
              list.add(itemsBeanList.get(j));
               Log.e("TAG", "getData: "+list.size() );
           }

       }

        funRecyclerAdapter.notifyDataSetChanged();
        refreshLayout.setRefreshing(false);
        for(int i=0;i<6;i++){
            String image_url = list_promote.get(i).getPromotion_img();
            Toast.makeText(mContext,image_url,Toast.LENGTH_LONG);
            Log.i("TAG", "getData: "+i );
            Log.i("TAG", "getData: "+image_url);
            Glide.with(mContext).load(image_url).asBitmap().into(list_target.get(i));
            Glide.with(mContext).load(image_url).asBitmap().into(list_target.get(i+3));
        }

    }




    //TODO 五个子项目的bean
    @Override
    public void getWeekBean(WeekBean bean) {

        int size = bean.getData().getWeekends().size();
        if(size==0){
            ToastHelper.showToast(mContext,"找不到相关信息");
            recyclerView_second.setBackgroundColor(Color.WHITE);
        }

        list_weekends = bean.getData().getWeekends();
        weekAdapter.reloadRecyclerView(list_weekends,true);
        refreshLayout_second.setRefreshing(false);

    }

    private void setImage() {
        Glide.with(this).load(list_display.get(0).getPic().getM_url()).into(imageView1);
        Glide.with(this).load(list_display.get(1).getPic().getM_url()).into(imageView2);
        Glide.with(this).load(list_display.get(2).getPic().getM_url()).into(imageView3);



    }

    //recycler 点击事件
    @Override
    public void OnClick(int position) {

        Object object = list.get(position);
        if(object instanceof  ItemsBean){
            urlstring = ((ItemsBean) object).getArticle().getWeburl();
             title = ((ItemsBean) object).getTitle();
        }
        UIManager.startWebActivity(mContext,urlstring,title);
    }

    @Override
    public void onClick(View view) {


        switch (view.getId()){

            case R.id.iv1_Funfrag:
                urlstring=  list_display.get(0).getWeb().getUrl();
                Log.i("TAG", "onClick: "+urlstring);
                 title = list_display.get(0).getTitle();
                break;
            case R.id.iv2_Funfrag:
                urlstring =list_display.get(1).getWeb().getUrl();
                Log.i("TAG", "onClick2222: "+urlstring);
                title = list_display.get(1).getTitle();

                break;
            case R.id.iv3_Funfrag:
                urlstring =list_display.get(2).getWeb().getUrl();
                title = list_display.get(2).getTitle();

                break;


        }


       UIManager.startWebActivity(mContext,urlstring,title);
    }

    //子项页面的传值
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode== Constant.REQUEST_FUN &resultCode==Constant.RESULT_FUNGUIDE){
            //cityname = data.getStringExtra(Constant.KEY_FUN_CITY);
            cityname= PreUtils.readStrting(mContext,Constant.PRE_KEY);
            category = data.getIntExtra(Constant.KEY_FUN_URLINT, -1);
            if(TextUtils.isEmpty(cityname)){
                tv_city_ritht.setText("北京");
            }else{
                tv_city_ritht.setText(cityname);
            }


            setcategory();
            dataChange();


        }
    }

    private void setcategory() {
        switch (category){
            case 10:
                tv_fun_left.setText("电影");
            break;
            case 0:
                tv_fun_left.setText("玩乐");
                break;
            case 1 :
                tv_fun_left.setText("演艺");

                break;
            case 3:
                tv_fun_left.setText("活动");
                break;
            case 4:
                tv_fun_left.setText("度假");
                break;
            case 9:
                tv_fun_left.setText("美食");
                break;
        }
    }

    private void dataChange() {
        switch (category){
            case 10:
                isHide =true;
                hideView(isHide);
                initMovieData();
                break;
            case 0:
                isHide =false;
                hideView(isHide);
                break;
            default :
                isHide =true;
                hideView(isHide);
                initOtherData();
                break;
        }

    }
   //TODO weekadapter
    @Override
    public void onWeekItemClick(int position) {
        String url = list_weekends.get(position).getWeekend().getContent_url();
        String string =list_weekends.get(position).getTitle();

        UIManager.startWebActivity(mContext,url,string);
    }

    //轮播的runnable
    class MyRunnable implements  Runnable{

        @Override
        public void run() {
            int currentItem = viewPager.getCurrentItem();
            currentItem++;
            viewPager.setCurrentItem(currentItem);
            handler.postDelayed(runnable,2000);

        }
    }

    void hideView(boolean isHide){
        if(isHide){

            lineartop.setVisibility(View.GONE);
            refreshLayout.setVisibility(View.GONE);
            refreshLayout_second.setVisibility(View.VISIBLE);
        }else{
            lineartop.setVisibility(View.VISIBLE);
            refreshLayout.setVisibility(View.VISIBLE);
            refreshLayout_second.setVisibility(View.GONE);


        }

    }

}
