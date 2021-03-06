package mdzz.com.first_of_mdzz.ui.fragment.homechildfragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import mdzz.com.first_of_mdzz.R;
import mdzz.com.first_of_mdzz.adapter.MyFriendRecyclerAdapter;
import mdzz.com.first_of_mdzz.bean.home.FriendBean;
import mdzz.com.first_of_mdzz.config.UrlConfig;
import mdzz.com.first_of_mdzz.http.HttpCallInterface;
import mdzz.com.first_of_mdzz.utils.SpacesItemDecoration;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * A simple {@link Fragment} subclass.
 */
public class FriendFragment extends Fragment {
    private SwipeRefreshLayout srl;
    private RecyclerView recyclerView;
    private List<FriendBean.DataBean.ListBean> friendlist = new ArrayList<>();
    private MyFriendRecyclerAdapter adapter;
    private String nextUrl=UrlConfig.FRIEND_URL;
    private int lastVisibleItemPosition;


    public FriendFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        initData();
        View rootView = inflater.inflate(R.layout.fragment_friend, container, false);
        initView(rootView);
        return rootView;
    }
    private void initView(View rootView) {
        srl = (SwipeRefreshLayout) rootView.findViewById(R.id.friend_srl);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.fragment_friend_recyclerview);
        adapter = new MyFriendRecyclerAdapter(friendlist,getActivity());
        final LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if(lastVisibleItemPosition==adapter.getItemCount()-1&&newState==RecyclerView.SCROLL_STATE_IDLE){
                    initData();
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                lastVisibleItemPosition = layoutManager.findLastVisibleItemPosition();
            }
        });
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new SpacesItemDecoration(10));
        recyclerView.setAdapter(adapter);
        srl.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                initData();
            }
        });
    }

    private void initData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(UrlConfig.BASE_FRIEND_URL)
                .client(new OkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        HttpCallInterface httpCallInterface = retrofit.create(HttpCallInterface.class);
        Observable<FriendBean> getwsnd = httpCallInterface.getwsnd(nextUrl);
        getwsnd.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<FriendBean>() {
                    @Override
                    public void onCompleted() {
                        srl.setRefreshing(false);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(FriendBean friendBean) {
                        nextUrl = friendBean.getData().getInfo().getNextUrl();
                        friendlist.addAll(friendBean.getData().getList());
                        adapter.notifyDataSetChanged();


                    }
                });
    }

}
