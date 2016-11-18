package mdzz.com.first_of_mdzz.http;

import android.content.Context;
import android.webkit.CookieManager;

import java.net.CookiePolicy;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import mdzz.com.first_of_mdzz.config.UrlConfig;
import mdzz.com.first_of_mdzz.utils.FileManger;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by acer on 2016/11/15.
 */

public class HttpUtils {
    private static HttpUtils instance;
   private Retrofit retrofit ;
    private IRetrofitInterface retrofitInterface;
    private HttpUtils( ){
         init();
    }

    private void init( ) {
        retrofit =  new Retrofit.Builder()
                .baseUrl(UrlConfig.BASE_URL)
                .client(getClinet())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static HttpUtils getInstance( ) {
        if (instance == null) {
            instance = new HttpUtils();
        }
        return instance;
    }
    private OkHttpClient getClinet() {
        Cache cache = new Cache(FileManger.getHttpCache(), 20 * 1024 * 1024);

        OkHttpClient  mOkHttpClient = new OkHttpClient.Builder()
                .cache(cache)
                .connectTimeout(15, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS)
                .build();


        //开启响应缓存
       // mOkHttpClient.setCookieHandler(new CookieManager(null, CookiePolicy.ACCEPT_ORIGINAL_SERVER));

         return  mOkHttpClient;

    }



    private   Retrofit getRetrofit(){
           retrofit = new Retrofit.Builder()
                  .baseUrl(UrlConfig.BASE_URL)
                  .client(getClinet())
                  .addConverterFactory(GsonConverterFactory.create())
                  .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                  .build();
          return  retrofit;
      }

    public IRetrofitInterface  getRetrofitInterface(){
        if(retrofitInterface ==null){
             retrofitInterface = retrofit.create(IRetrofitInterface.class);
        }
        return retrofitInterface;
    }


    public static Map<String,String>getPlayMap(String city){
        //http://wl.myzaker.com/?_appid=AndroidPhone&_v=7.0.2&_version=7.02&c=columns&city=%E5%8C%97%E4%BA%AC
        Map<String,String> map = new Hashtable<>();
        map.put("_appid","AndroidPhone");
        map.put("_v","7.0.2");
        map.put("_version","7.02");
        map.put("c","columns");
        map.put("city",city);

        return map;

    }
    public static Map<String,String>getPositionMap(String city){
        //http://wl.myzaker.com/?_appid=AndroidPhone&_v=7.0.2&_version=7.02&c=city_list&lat=39.913249&lng=116.403625
        //可不拼接经纬度
        Map<String,String> map = new Hashtable<>();
        map.put("_appid","AndroidPhone");
        map.put("_v","7.0.2");
        map.put("_version","7.02");
        map.put("c","city_list");


        return map;

    }


}
