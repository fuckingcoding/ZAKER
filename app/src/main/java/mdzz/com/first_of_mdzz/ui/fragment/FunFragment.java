package mdzz.com.first_of_mdzz.ui.fragment;


import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
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
import mdzz.com.first_of_mdzz.adapter.MyVpInfiniteAdapter;
import mdzz.com.first_of_mdzz.base.BaseFragment;
import mdzz.com.first_of_mdzz.bean.PlayBean;
import mdzz.com.first_of_mdzz.config.UrlConfig;
import mdzz.com.first_of_mdzz.http.HttpUtils;
import mdzz.com.first_of_mdzz.ui.main.FunFragmentContract;
import mdzz.com.first_of_mdzz.ui.main.FunFragmentPresenter;


/**
 * A simple {@link Fragment} subclass.
 */
public class FunFragment extends BaseFragment implements FunFragmentContract.IFunView{

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
    private List<PlayBean> list;


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
        //recyclerView.setAdapter();

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

    @Override
    public void getData(PlayBean bean) {
        Log.e("TAG", "getData: "+bean.getData().getDisplay().size());
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
