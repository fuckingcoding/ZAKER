package mdzz.com.first_of_mdzz.ui.fragment.homechildfragment;


import android.graphics.Canvas;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import mdzz.com.first_of_mdzz.R;
import mdzz.com.first_of_mdzz.adapter.MyRecyclerAdapter;
import mdzz.com.first_of_mdzz.bean.home.ChoiceBean;
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
public class ChoiceFragment extends Fragment {
    private RecyclerView recyclerView;
    private List<ChoiceBean.DataBean.PostsBean> posts=new ArrayList<>();
    private MyRecyclerAdapter myrecyclerAdapter;



    public ChoiceFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        initData();
        View rootView = inflater.inflate(R.layout.fragment_choice, container, false);

        initView(rootView);


        return rootView;
    }
    private void initData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(UrlConfig.BASE_CHOOSE_URL)
                .client(new OkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        HttpCallInterface httpCallInterface = retrofit.create(HttpCallInterface.class);
        Observable<ChoiceBean> getnmsl = httpCallInterface.getnmsl(UrlConfig.CHOOSE_URL);
        getnmsl.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ChoiceBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(ChoiceBean choiceBean) {
                        posts.addAll(choiceBean.getData().getPosts());
                        myrecyclerAdapter.notifyDataSetChanged();
                    }
                });
    }

    private void initView(View rootView) {
        //初始化recycleView
        myrecyclerAdapter = new MyRecyclerAdapter(posts,getActivity());
        recyclerView = (RecyclerView) rootView.findViewById(R.id.fragment_choice_recyclerview);
        recyclerView.addItemDecoration(new SpacesItemDecoration(10));
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(myrecyclerAdapter);
    }

}
