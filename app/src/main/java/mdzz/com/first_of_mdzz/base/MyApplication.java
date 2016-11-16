package mdzz.com.first_of_mdzz.base;

import android.app.Application;

/**
 * Created by acer on 2016/11/15.
 */

public class MyApplication extends Application{




    public static MyApplication app;

    public MyApplication() {

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

//        Glide.get(this).register(GlideUrl.class
//                , InputStream.class, new OkHttpUrlLoader.Factory(OkHttpClientHelper.getOkHttpSingletonInstance()));

    }
}
