package mdzz.com.first_of_mdzz.ui.main.homeactivity;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import mdzz.com.first_of_mdzz.R;
import mdzz.com.first_of_mdzz.adapter.MySportAdapter;
import mdzz.com.first_of_mdzz.bean.home.SportBean;
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

public class SportActivity extends AppCompatActivity {
    private SwipeRefreshLayout srl;
    private RecyclerView recyclerView;
    private List<SportBean.DataBean.PostsBean> posts = new ArrayList<>();
    private MySportAdapter msa;
    private int intExtra;
    private String url;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sport);
        Intent intent = getIntent();
        intExtra = intent.getIntExtra("1", 10);
        initView();
        initData();

        if(intExtra==0){
            recyclerView.setAdapter(msa);
            textView.setText("综合体育");
        }else if(intExtra==1){
            recyclerView.setAdapter(msa);
            textView.setText("数码脑残粉");
        }else if(intExtra==2){
            recyclerView.setAdapter(msa);
            textView.setText("电影圈");
        }else if(intExtra==3){
            recyclerView.setAdapter(msa);
            textView.setText("健身房");
        }else if(intExtra==4){
            recyclerView.setAdapter(msa);
            textView.setText("颤抖吧吃货");
        }else if(intExtra==5){
            recyclerView.setAdapter(msa);
            textView.setText("女神转型记");
        }else if(intExtra==6){
            recyclerView.setAdapter(msa);
            textView.setText("董小姐");
        }else if(intExtra==7){
            recyclerView.setAdapter(msa);
            textView.setText("汽车总动员");
        }else if(intExtra==8){
            recyclerView.setAdapter(msa);
            textView.setText("扎堆");
        }else if(intExtra==9){
            recyclerView.setAdapter(msa);
            textView.setText("我们就爱倒腾APP");
        }
    }

    private void initData() {
        switch (intExtra){
            case 0:
                url=UrlConfig.SPORT_URL;
                break;
            case 1:
                url=UrlConfig.PHONE_URL;
                break;
            case 2:
                url=UrlConfig.FILM_URL;
                break;
            case 3:
                url=UrlConfig.HEALTH_URL;
                break;
            case 4:
                url=UrlConfig.EAT_URL;
                break;
            case 5:
                url=UrlConfig.GIRLGOLD_URL;
                break;
            case 6:
                url=UrlConfig.MISSESD_URL;
                break;
            case 7:
                url=UrlConfig.CAR_URL;
                break;
            case 8:
                url=UrlConfig.ZHADUI_URL;
                break;
            case 9:
                url=UrlConfig.APP_URL;
                break;

        }

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(UrlConfig.BASE_SPORT_URL)
                .client(new OkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        HttpCallInterface httpCallInterface = retrofit.create(HttpCallInterface.class);
        Observable<SportBean> sport = httpCallInterface.getSport(url);
        sport.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<SportBean>() {
                    @Override
                    public void onCompleted() {
                        srl.setRefreshing(false);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(SportBean sportBean) {
                        posts.addAll(sportBean.getData().getPosts());
                        msa.notifyDataSetChanged();
                    }
                });


    }

    private void initView() {
        srl = (SwipeRefreshLayout) findViewById(R.id.topic_srl);
        textView = (TextView) findViewById(R.id.sport_toolbar_textview);
        recyclerView = (RecyclerView) findViewById(R.id.sport_rv);
        msa = new MySportAdapter(this,posts);
        recyclerView.addItemDecoration(new SpacesItemDecoration(10));
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        srl.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                initData();
            }
        });

    }
}
