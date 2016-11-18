package mdzz.com.first_of_mdzz.ui.fragment.homechildfragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import mdzz.com.first_of_mdzz.R;
import mdzz.com.first_of_mdzz.adapter.MyCommicountBaseAdapter;
import mdzz.com.first_of_mdzz.bean.home.TopicBean;
import mdzz.com.first_of_mdzz.config.UrlConfig;
import mdzz.com.first_of_mdzz.http.HttpCallInterface;
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
public class TopicFragment extends Fragment {
    private ListView listView;
    private List<TopicBean.DataBean.ListBean> list=new ArrayList<>(); //必须实例化之后才能赋值
    private MyCommicountBaseAdapter myCommicountBaseAdapter;


    public TopicFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        initData();

        View rootView= inflater.inflate(R.layout.fragment_topic, container, false);

        initView(rootView);

        return rootView;

    }
    private void initView(View rootView) {
        listView = (ListView) rootView.findViewById(R.id.fragment_topic_listview);
        myCommicountBaseAdapter = new MyCommicountBaseAdapter(list,getActivity());
        listView.setAdapter(myCommicountBaseAdapter);

    }

    private void initData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(UrlConfig.BASE_HOME_URL)
                .client(new OkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        HttpCallInterface httpCallInterface = retrofit.create(HttpCallInterface.class);
        Observable<TopicBean> getmdzz = httpCallInterface.getmdzz(UrlConfig.HOME_URL);
        getmdzz.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<TopicBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(TopicBean topicBean) {
                        list .addAll(topicBean.getData().getList());//把对应的数据都加在数组中
                        Log.e("TAG", "onNext: "+list.size() );
                        myCommicountBaseAdapter.notifyDataSetChanged();


                    }
                });

    }


}
