package mdzz.com.first_of_mdzz.ui.main;

import mdzz.com.first_of_mdzz.bean.Weather.WeatherBean;
import mdzz.com.first_of_mdzz.config.UrlConfig;
import mdzz.com.first_of_mdzz.http.IRetrofitInterface;
import mdzz.com.first_of_mdzz.utils.OkHttp3Helper;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

/**
 * Created by apple on 16/11/21.
 * Eemil:635727195@qq.com
 */

public class MainActivityWeatherModel implements MainActivityWeatherContract.IWeatherModel {
    private Retrofit retrofit;
    @Override
    public Observable<WeatherBean> getBeanObservable(String city) {
        retrofit=new Retrofit.Builder()
                .baseUrl(UrlConfig.URL_WEATHER_BASE)
                .client(OkHttp3Helper.getOkHttpSingletonInstance())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return retrofit.create(IRetrofitInterface.class).getBeanObservable(city);
    }
}
