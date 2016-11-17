package mdzz.com.first_of_mdzz.ui.fragment;


import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import mdzz.com.first_of_mdzz.R;
import mdzz.com.first_of_mdzz.adapter.FunRecyclerAdapter;
import mdzz.com.first_of_mdzz.adapter.MyVpInfiniteAdapter;
import mdzz.com.first_of_mdzz.base.BaseFragment;
import mdzz.com.first_of_mdzz.bean.fun.BannerBean;
import mdzz.com.first_of_mdzz.bean.fun.ColumnsBean;
import mdzz.com.first_of_mdzz.bean.fun.DisplayBean;
import mdzz.com.first_of_mdzz.bean.fun.InfoBean;
import mdzz.com.first_of_mdzz.bean.fun.ItemsBean;
import mdzz.com.first_of_mdzz.bean.fun.PlayBean;
import mdzz.com.first_of_mdzz.bean.fun.PromoteBean;
import mdzz.com.first_of_mdzz.http.HttpUtils;
import mdzz.com.first_of_mdzz.ui.main.FunFragmentContract;
import mdzz.com.first_of_mdzz.ui.main.FunFragmentPresenter;


/**
 * A simple {@link Fragment} subclass.
 */
public class FunFragment extends BaseFragment implements FunFragmentContract.IFunView{
  private Context mContext;
    private SwipeRefreshLayout refreshLayout;
    private ViewPager viewPager;
    private ImageView imageView1,imageView2,imageView3;
    private RecyclerView recyclerView ;
    private List<View> list_imageview;
    private MyVpInfiniteAdapter adapter;
    private RecyclerView.LayoutManager manager;
    private LinearLayout mlinear_ad;
    private  MyRunnable runnable;
    private Handler handler = new Handler();

    private List<ItemsBean> list_items; // recycler 的item
    private List<DisplayBean> list_display; // 三个固定的imageView
    private List<PromoteBean> list_promote; //轮播条
    private InfoBean infoBean; //下一条信息
    private List<ColumnsBean> list_col;//包含 list_items list_banner
    private  List<Object> list;
    private FunRecyclerAdapter funRecyclerAdapter;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
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


//        toolbar = (Toolbar) view.findViewById(R.id.toolbar);
//        setHasOptionsMenu(true);
//        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
//        ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
//        actionBar.setTitle("lalala");
//        toolbar.setTitle("玩乐");


    }

    private void initData() {
        list = new ArrayList<>();
        FunFragmentPresenter presenter = new FunFragmentPresenter(this);
        Map<String, String> map = HttpUtils.getPlayMap("北京");
        presenter.getPlayBean(map);
    }


    private void initView(View view) {
        list_imageview = new ArrayList<>();
        initToolBar(view,R.id.toolbar,"玩乐",false);
        refreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.refresh_Funfragment);
        imageView1 = (ImageView) view.findViewById(R.id.iv1_Funfrag);
        imageView2 = (ImageView) view.findViewById(R.id.iv2_Funfrag);
        imageView3 = (ImageView) view.findViewById(R.id.iv3_Funfrag);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView_Funfrag);
        viewPager = (ViewPager) view.findViewById(R.id.viewpager_Funfragment);
        mlinear_ad = (LinearLayout) view.findViewById(R.id.linear_ad);
        for(int i =0;i<4;i++){
            ImageView iv = new ImageView(getActivity());
            iv.setTag(i);

            iv.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            iv.setImageResource(R.mipmap.guide_loading_tag_46);
            iv.setScaleType(ImageView.ScaleType.FIT_XY);
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

    }
    private void initAdapter() {
        adapter = new MyVpInfiniteAdapter(list_imageview);
        Log.e("TAG", "initAdapter: "+list.size());
        funRecyclerAdapter = new FunRecyclerAdapter(mContext,list);

    }
    private void initDot() {
        for (int i = 0; i < list_imageview.size(); i++) {

            ImageView iv = new ImageView(getActivity());
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            params.rightMargin = 10;
            iv.setLayoutParams(params);
            iv.setImageResource(R.drawable.ad_selector);
            if (i == 0) {
                iv.setSelected(true);
            }

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
                for(int i =0;i<list_imageview.size();i++){
                    if(i==(position%list_imageview.size())){
                        //Log.e("TAG", "onPageSelected() returned: " + position%6);
                       mlinear_ad.getChildAt(i%list_imageview.size()).setSelected(true);
                    }else {
                        mlinear_ad.getChildAt(i%list_imageview.size()).setSelected(false);
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
        recyclerView.setAdapter(funRecyclerAdapter);

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_play,menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

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
        Log.e("TAG", "list_promote: "+list_promote.size());
        list_col = bean.getData().getColumns();
        size_col = list_col.size();
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

}
