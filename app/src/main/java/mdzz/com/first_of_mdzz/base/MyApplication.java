package mdzz.com.first_of_mdzz.base;

import android.app.Application;

import cn.bmob.v3.Bmob;

/**
 * Created by acer on 2016/11/15.
 */

public class MyApplication extends Application{




    public static MyApplication app;

    public MyApplication() {
         app =this;
    }

    public static MyApplication getInstance() {
        if (app == null) {
            app = new MyApplication();
        }
        return app;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        //第一：默认初始化
        Bmob.initialize(this, "24ff0409f444abe2e89021c28df839cc");

        //第二：自v3.4.7版本开始,设置BmobConfig,允许设置请求超时时间、文件分片上传时每片的大小、文件的过期时间(单位为秒)，
        //BmobConfig config =new BmobConfig.Builder(this)
        ////设置appkey
        //.setApplicationId("Your Application ID")
        ////请求超时时间（单位为秒）：默认15s
        //.setConnectTimeout(30)
        ////文件分片上传时每片的大小（单位字节），默认512*1024
        //.setUploadBlockSize(1024*1024)
        ////文件的过期时间(单位为秒)：默认1800s
        //.setFileExpiration(2500)
        //.build();
        //Bmob.initialize(config);
//        Glide.get(this).register(GlideUrl.class
//                , InputStream.class, new OkHttpUrlLoader.Factory(OkHttpClientHelper.getOkHttpSingletonInstance()));

    }
}
