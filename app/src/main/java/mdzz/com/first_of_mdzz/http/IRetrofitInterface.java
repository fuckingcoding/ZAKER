package mdzz.com.first_of_mdzz.http;

import java.util.Map;

import mdzz.com.first_of_mdzz.bean.week.WeekBean;
import mdzz.com.first_of_mdzz.bean.fun.PlayBean;
import mdzz.com.first_of_mdzz.bean.position.PositionBean;
import mdzz.com.first_of_mdzz.bean.subscibe.FashionBean;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Created by acer on 2016/11/15.
 */

public interface IRetrofitInterface {

   //http://wl.myzaker.com/?_appid=AndroidPhone&_v=7.0.2&_version=7.02&c=city_list&lat=39.913249&lng=116.403625
    //http://wl.myzaker.com/?_appid=AndroidPhone&_v=7.0.2&_version=7.02&c=columns&city=%E5%8C%97%E4%BA%AC
    @GET("?")
    Observable<PlayBean> getPlayBean(@QueryMap Map<String ,String> map);




    //http://iphone.myzaker.com/zaker/news.php?_appid=AndroidPhone&_bsize=1080_1920&_version=7.02&app_id=12
    @GET
    Observable<FashionBean> getFashionBean(@Url String s);


    @GET("?")
     Observable<PositionBean> getPositionBean(@QueryMap Map<String,String> map);


   //http://wl.myzaker.com/?c=activity_list&city=beijing&p=0&size=20&category=4

     @GET("?")
     Observable<WeekBean> getWeekBean(@QueryMap Map<String,String> map);


   // http://wl.myzaker.com/?c=movie_list
    //@GET(?)

}
