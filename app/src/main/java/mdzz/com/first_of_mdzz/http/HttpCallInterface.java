package mdzz.com.first_of_mdzz.http;


import mdzz.com.first_of_mdzz.bean.home.ChoiceBean;
import mdzz.com.first_of_mdzz.bean.home.FriendBean;
import mdzz.com.first_of_mdzz.bean.home.TopicBean;
import retrofit2.http.GET;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Created by My on 2016/11/15.
 */

public interface HttpCallInterface {

    /**
     * http://dis.myzaker.com/api/list_discussion.php?_appid=AndroidPhone&_bsize=720_1280&_dev=160&_lat=4.9E-324
     * &_lng=4.9E-324&_mac=00%3A21%3ACC%3A62%3A8B%3A10&_mcode=B567CB5B&_net=wifi&_nudid=8acb003a92b544fa&_os=
     * 4.4.2_GT-I9082&_os_name=GT-I9082&_udid=285500212046218&_v=7.0.2&_version=7.02&except_subscribe=N
     */




    /**
     * http://dis.myzaker.com/api/list_discussion.php?_appid=AndroidPhone&_bsize=720_1280&_dev=160&_lat=4.9E-324
     * &_lng=4.9E-324&_mac=00%3A21%3ACC%3A62%3A8B%3A10&_mcode=B567CB5B&_net=wifi&_nudid=8acb003a92b544fa&_os=
     * 4.4.2_GT-I9082&_os_name=GT-I9082&_udid=285500212046218&_v=7.0.2&_version=7.02&act=more_discussion&except_recommend=Y
     */

    @GET
    Observable<TopicBean> getmdzz(@Url String url);
    @GET
    Observable<ChoiceBean> getnmsl(@Url String url);
    @GET
    Observable<FriendBean> getwsnd(@Url String url);
}
