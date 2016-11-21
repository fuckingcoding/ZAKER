package mdzz.com.first_of_mdzz.config;

/**
 * Created by acer on 2016/11/15.
 */

public class UrlConfig {
    //http://wl.myzaker.com/?_appid=AndroidPhone&_v=7.0.2&_version=7.02&c=columns&city=%E5%8C%97%E4%BA%AC
    public  static  final  String  BASE_URL ="http://wl.myzaker.com/";
    public static final String URL_REMEN ="c=columns";
    //http://wl.myzaker.com/?c=activity_list&city=beijing&p=0&size=20&category=1
    public static final String URL_YANYI ="http://wl.myzaker.com/?c=activity_list&city=beijing&p=0&size=20&category=1";
    public static final String URL_DUJIA ="http://wl.myzaker.com/?c=activity_list&p=0&city=beijing&size=20&category=4";
    public static  final String URL_DIANYING ="http://wl.myzaker.com/?_appid=AndroidPhone&_v=7.0.2&_version=7.02&c=movie_list&city=beijing";
    public static final String URL_MEISHI ="http://wl.myzaker.com/?c=activity_list&p=0&city=beijing&size=20&category=9";
    public static final String URL_HUODONG ="http://wl.myzaker.com/?c=activity_list&p=0&city=beijing&size=20&category=3";
    public static  final String URL_CITY ="http://wl.myzaker.com/?_appid=AndroidPhone&_v=7.0.2&_version=7.02&c=city_list&lat=39.913249&lng=116.403625";

    //社区话题的url
    public static final String HOME_URL="http://dis.myzaker.com/api/list_discussion.php?_appid=AndroidPhone&_bsize=720_1280&_city=dalian&_dev=160&_lat=4.9E-324&_lng=4.9E-324&_mac=00%3A21%3ACC%3A62%3A8B%3A10&_mcode=B567CB5B&_net=wifi&_nudid=8acb003a92b544fa&_os=4.4.2_GT-I9082&_os_name=GT-I9082&_udid=285500212046218&_v=7.0.2&_version=7.02&except_subscribe=N";

    //社区话题的BaseURL
    public static final String BASE_HOME_URL="http://dis.myzaker.com/";

    //社区精选的url
    public static final String CHOOSE_URL="http://dis.myzaker.com/api/get_post_selected.php?_appid=AndroidPhone&_bsize=720_1280&_city=dalian&_dev=160&_lat=4.9E-324&_lng=4.9E-324&_mac=00%3A21%3ACC%3A62%3A8B%3A10&_mcode=B567CB5B&_net=wifi&_nudid=8acb003a92b544fa&_os=4.4.2_GT-I9082&_os_name=GT-I9082&_udid=285500212046218&_v=7.0.2&_version=7.02";
    //社区的BASE url
    public static final String BASE_CHOOSE_URL="http://dis.myzaker.com/";

    //朋友圈url
    public static final String FRIEND_URL="http://sns.myzaker.com/daren_feeds.php?_appid=AndroidPhone&_bsize=720_1280&_city=%E5%8C%97%E4%BA%AC&_dev=160&_lat=39.913249&_lbs_city=%E5%8C%97%E4%BA%AC&_lbs_province=%E5%8C%97%E4%BA%AC%E5%B8%82&_lng=116.403625&_mac=DC%3A0E%3AA1%3A6E%3A9B%3A85&_mcode=85AA2339&_net=wifi&_nudid=b6441c6086ab3941&_os=4.4.2_VPhone&_os_name=VPhone&_province=%E5%8C%97%E4%BA%AC%E5%B8%82&_udid=864394102201417&_v=7.0.2&_version=7.02&s=1&uid=Doyen";

    //朋友圈Base url
    public static final String BASE_FRIEND_URL="http://sns.myzaker.com/";
    //********************以下为news个页面的URL*******************************************

    public  final static  String BaseUrl="http://iphone.myzaker.com/";
    //时尚
    public  final  static String FashionUrl="http://iphone.myzaker.com" +
            "/zaker/news.php?_appid=AndroidPhone&_bsize=1080_1920&_version=7.02&app_id=12";
    // 头条国内
    public  final static  String NewsLoadUrl=" http://iphone.myzaker.com/zaker/news.php?_appid=AndroidPhone&_bsize=1080_1920&_version=7.02&app_id=1";
    // 头条国际
    public  final static  String NesForeignUrl="http://iphone.myzaker.com/zaker/news.php?_appid=AndroidPhone&_bsize=1080_1920&_version=7.02&app_id=2";
    // 娱乐八卦中的娱乐
    public  final static  String YuLeUrl=" http://iphone.myzaker.com/zaker/news.php?_appid=AndroidPhone&_bsize=1080_1920&_version=7.02&app_id=9";
    // 汽车频道
    public  final static  String CarUrl=" http://iphone.myzaker.com/zaker/news.php?_appid=AndroidPhone&_bsize=1080_1920&_version=7.02&app_id=7";
    // 财经新闻
    public  final static  String MoneyUrl="http://iphone.myzaker.com/zaker/news.php?_appid=AndroidPhone&_bsize=1080_1920&_version=7.02&app_id=4";
    // 科技频道下的互联网
    public  final static  String IntUrl="http://iphone.myzaker.com/zaker/news.php?_appid=AndroidPhone&_bsize=1080_1920&_version=7.02&app_id=5";
    // 体育
    public  final static  String TiYuUrl=" http://iphone.myzaker.com/zaker/news.php?_appid=AndroidPhone&_bsize=1080_1920&_version=7.02&app_id=8";
    // 电影
    public  final static  String MovieUrl="http://iphone.myzaker.com/zaker/news.php?_appid=AndroidPhone&_bsize=1080_1920&_version=7.02&app_id=15";


    //hot
    public final static String HotUrl="http://hotphone.myzaker.com/daily_hot_new.php?_appid=AndroidPhone&_bsize=1080_1920&_city=beijing&_dev=18&_lat=38.895039&_lbs_city=%E5%A4%A7%E8%BF%9E&_lbs_province=%E8%BE%BD%E5%AE%81%E7%9C%81&_lng=121.544741&_mac=c0%3Aee%3Afb%3A47%3Ae1%3Aa7&_mcode=DF8F0C00&_net=wifi&_nudid=8912d2847acc785d&_os=5.1.1_ONEA2001&_os_name=ONEA2001&_province=22&_udid=867271028756970&_v=7.0.2&_version=7.02&act=pre&last_time=1479563489";

    public final static String Hot1Url="http://hotphone.myzaker.com/daily_hot_new.php?_appid=AndroidPhone&_bsize=720_1280&_city=ganzhou&_dev=160&_lat=39.913249&_lbs_city=%E5%8C%97%E4%BA%AC&_lbs_province=%E5%8C%97%E4%BA%AC%E5%B8%82&_lng=116.403625&_mac=DC%3A0E%3AA1%3A6E%3A9B%3A85&_mcode=85AA2339&_net=wifi&_nudid=b6441c6086ab3941&_os=4.4.2_VPhone&_os_name=VPhone&_province=03&_udid=864394102201417&_v=7.0.2&_version=7.02";
    //***************************************************************

    //综合体育url
    public static final String SPORT_URL="http://dis.myzaker.com/api/get_post.php?_appid=AndroidPhone&_bsize=720_1280&_city=%E5%8C%97%E4%BA%AC&_dev=160&_lat=39.91325&_lbs_city=%E5%8C%97%E4%BA%AC&_lbs_province=%E5%8C%97%E4%BA%AC%E5%B8%82&_lng=116.403625&_mac=DC%3A0E%3AA1%3A6E%3A9B%3A85&_mcode=85AA2339&_net=wifi&_nudid=b6441c6086ab3941&_os=4.4.2_VPhone&_os_name=VPhone&_province=%E5%8C%97%E4%BA%AC%E5%B8%82&_udid=864394102201417&_v=7.0.2&_version=7.02&discussion_id=246&sort_type=last_comment";
    //综合体育Base url
    public static final String BASE_SPORT_URL="http://dis.myzaker.com/";

    //数码脑残粉
    public static final String PHONE_URL="http://dis.myzaker.com/api/get_post.php?_appid=AndroidPhone&_bsize=720_1280&_city=%E5%8C%97%E4%BA%AC&_dev=160&_lat=39.91325&_lbs_city=%E5%8C%97%E4%BA%AC&_lbs_province=%E5%8C%97%E4%BA%AC%E5%B8%82&_lng=116.403625&_mac=DC%3A0E%3AA1%3A6E%3A9B%3A85&_mcode=85AA2339&_net=wifi&_nudid=b6441c6086ab3941&_os=4.4.2_VPhone&_os_name=VPhone&_province=%E5%8C%97%E4%BA%AC%E5%B8%82&_udid=864394102201417&_v=7.0.2&_version=7.02&discussion_id=156&sort_type=last_comment";
    //电影圈：
    public static final String FILM_URL="http://dis.myzaker.com/api/get_post.php?_appid=AndroidPhone&_bsize=720_1280&_city=%E5%8C%97%E4%BA%AC&_dev=160&_lat=39.91325&_lbs_city=%E5%8C%97%E4%BA%AC&_lbs_province=%E5%8C%97%E4%BA%AC%E5%B8%82&_lng=116.403625&_mac=DC%3A0E%3AA1%3A6E%3A9B%3A85&_mcode=85AA2339&_net=wifi&_nudid=b6441c6086ab3941&_os=4.4.2_VPhone&_os_name=VPhone&_province=%E5%8C%97%E4%BA%AC%E5%B8%82&_udid=864394102201417&_v=7.0.2&_version=7.02&discussion_id=168&sort_type=last_comment";

    //健身房
    public static final String HEALTH_URL="http://dis.myzaker.com/api/get_post.php?_appid=AndroidPhone&_bsize=720_1280&_city=%E5%8C%97%E4%BA%AC&_dev=160&_lat=39.91325&_lbs_city=%E5%8C%97%E4%BA%AC&_lbs_province=%E5%8C%97%E4%BA%AC%E5%B8%82&_lng=116.403625&_mac=DC%3A0E%3AA1%3A6E%3A9B%3A85&_mcode=85AA2339&_net=wifi&_nudid=b6441c6086ab3941&_os=4.4.2_VPhone&_os_name=VPhone&_province=%E5%8C%97%E4%BA%AC%E5%B8%82&_udid=864394102201417&_v=7.0.2&_version=7.02&discussion_id=215&sort_type=last_comment";

    //颤抖吧吃货
    public static final String EAT_URL="http://dis.myzaker.com/api/get_post.php?_appid=AndroidPhone&_bsize=720_1280&_city=%E5%8C%97%E4%BA%AC&_dev=160&_lat=39.91325&_lbs_city=%E5%8C%97%E4%BA%AC&_lbs_province=%E5%8C%97%E4%BA%AC%E5%B8%82&_lng=116.403625&_mac=DC%3A0E%3AA1%3A6E%3A9B%3A85&_mcode=85AA2339&_net=wifi&_nudid=b6441c6086ab3941&_os=4.4.2_VPhone&_os_name=VPhone&_province=%E5%8C%97%E4%BA%AC%E5%B8%82&_udid=864394102201417&_v=7.0.2&_version=7.02&discussion_id=2&sort_type=last_comment";

    //女神转型记
    public static final String GIRLGOLD_URL="http://dis.myzaker.com/api/get_post.php?_appid=AndroidPhone&_bsize=720_1280&_city=%E5%8C%97%E4%BA%AC&_dev=160&_lat=39.91325&_lbs_city=%E5%8C%97%E4%BA%AC&_lbs_province=%E5%8C%97%E4%BA%AC%E5%B8%82&_lng=116.403625&_mac=DC%3A0E%3AA1%3A6E%3A9B%3A85&_mcode=85AA2339&_net=wifi&_nudid=b6441c6086ab3941&_os=4.4.2_VPhone&_os_name=VPhone&_province=%E5%8C%97%E4%BA%AC%E5%B8%82&_udid=864394102201417&_v=7.0.2&_version=7.02&discussion_id=86&sort_type=last_comment";

    //董小姐
    public static final String MISSESD_URL="http://dis.myzaker.com/api/get_post.php?_appid=AndroidPhone&_bsize=720_1280&_city=%E5%8C%97%E4%BA%AC&_dev=160&_lat=39.91325&_lbs_city=%E5%8C%97%E4%BA%AC&_lbs_province=%E5%8C%97%E4%BA%AC%E5%B8%82&_lng=116.403625&_mac=DC%3A0E%3AA1%3A6E%3A9B%3A85&_mcode=85AA2339&_net=wifi&_nudid=b6441c6086ab3941&_os=4.4.2_VPhone&_os_name=VPhone&_province=%E5%8C%97%E4%BA%AC%E5%B8%82&_udid=864394102201417&_v=7.0.2&_version=7.02&discussion_id=83&sort_type=last_comment";

    //汽车总动员
    public static final String CAR_URL="http://dis.myzaker.com/api/get_post.php?_appid=AndroidPhone&_bsize=720_1280&_city=%E5%8C%97%E4%BA%AC&_dev=160&_lat=39.91325&_lbs_city=%E5%8C%97%E4%BA%AC&_lbs_province=%E5%8C%97%E4%BA%AC%E5%B8%82&_lng=116.403625&_mac=DC%3A0E%3AA1%3A6E%3A9B%3A85&_mcode=85AA2339&_net=wifi&_nudid=b6441c6086ab3941&_os=4.4.2_VPhone&_os_name=VPhone&_province=%E5%8C%97%E4%BA%AC%E5%B8%82&_udid=864394102201417&_v=7.0.2&_version=7.02&discussion_id=185&sort_type=last_comment";

    //扎堆
    public static final String ZHADUI_URL="http://dis.myzaker.com/api/get_post.php?_appid=AndroidPhone&_bsize=720_1280&_city=%E5%8C%97%E4%BA%AC&_dev=160&_lat=39.91325&_lbs_city=%E5%8C%97%E4%BA%AC&_lbs_province=%E5%8C%97%E4%BA%AC%E5%B8%82&_lng=116.403625&_mac=DC%3A0E%3AA1%3A6E%3A9B%3A85&_mcode=85AA2339&_net=wifi&_nudid=b6441c6086ab3941&_os=4.4.2_VPhone&_os_name=VPhone&_province=%E5%8C%97%E4%BA%AC%E5%B8%82&_udid=864394102201417&_v=7.0.2&_version=7.02&discussion_id=161&sort_type=last_comment";

    //我们就爱倒腾APP
    public static final String APP_URL="http://dis.myzaker.com/api/get_post.php?_appid=AndroidPhone&_bsize=720_1280&_city=%E5%8C%97%E4%BA%AC&_dev=160&_lat=39.91325&_lbs_city=%E5%8C%97%E4%BA%AC&_lbs_province=%E5%8C%97%E4%BA%AC%E5%B8%82&_lng=116.403625&_mac=DC%3A0E%3AA1%3A6E%3A9B%3A85&_mcode=85AA2339&_net=wifi&_nudid=b6441c6086ab3941&_os=4.4.2_VPhone&_os_name=VPhone&_province=%E5%8C%97%E4%BA%AC%E5%B8%82&_udid=864394102201417&_v=7.0.2&_version=7.02&discussion_id=178&sort_type=last_comment";



    // 天气预报url
    public static final String URL_WEATHER_BASE = "http://wthrcdn.etouch.cn/";
    public static final String URL_WEATHER_PATH = "weather_mini?";
    //例如：http://wthrcdn.etouch.cn/weather_mini?city=%E5%8C%97%E4%BA%AC
}
