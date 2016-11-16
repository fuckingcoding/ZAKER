package mdzz.com.first_of_mdzz.ui.fragment;


import android.os.Bundle;
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
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import mdzz.com.first_of_mdzz.R;
import mdzz.com.first_of_mdzz.adapter.MyVpInfiniteAdapter;
import mdzz.com.first_of_mdzz.base.BaseFragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class FunFragment extends BaseFragment {

    private SwipeRefreshLayout refreshLayout;
    private ViewPager viewPager;
    private ImageView imageView1,imageView2,imageView3;
    private RecyclerView recyclerView ;
    private List<View> list_imageview;
    private MyVpInfiniteAdapter adapter;
    private RecyclerView.LayoutManager manager  ;


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


//        toolbar = (Toolbar) view.findViewById(R.id.toolbar);
//        setHasOptionsMenu(true);
//        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
//        ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
//        actionBar.setTitle("lalala");
//        toolbar.setTitle("玩乐");


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
         initAdapter();
        initAdViewPager();
        initRecyclerView();

    }
    private void initAdapter() {
        adapter = new MyVpInfiniteAdapter(list_imageview);

    }

    private void initAdViewPager() {
        //viewPager.setAdapter(adapter);

    }

    private void initRecyclerView() {
        manager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        recyclerView .setLayoutManager(manager);
      //  recyclerView.setAdapter();

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

}
