package mdzz.com.first_of_mdzz.http;

import android.content.Context;
import android.webkit.CookieManager;

import java.net.CookiePolicy;
import java.util.concurrent.TimeUnit;

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
    private HttpUtils(String urlstring){
         init(urlstring);
    }

    private void init(String urlstring) {
        retrofit =  new Retrofit.Builder()
                .baseUrl(urlstring)
                .client(getClinet())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static HttpUtils getInstance(String urlstring) {
        if (instance == null) {
            instance = new HttpUtils(urlstring);
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
                  .baseUrl("http://www.baidu.com/")
                  .client(new OkHttpClient())
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
}
