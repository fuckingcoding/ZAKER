package mdzz.com.first_of_mdzz.http;

import java.util.Map;

import mdzz.com.first_of_mdzz.bean.fun.PlayBean;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by acer on 2016/11/15.
 */

public interface IRetrofitInterface {


    //http://wl.myzaker.com/?_appid=AndroidPhone&_v=7.0.2&_version=7.02&c=columns&city=%E5%8C%97%E4%BA%AC
    @GET("?")
    Observable<PlayBean> getPlayBean(@QueryMap Map<String ,String> map);
}
