package mdzz.com.first_of_mdzz.base;

import android.app.Application;
import android.content.Context;
import android.view.View;

import com.bumptech.glide.Glide;

import com.bumptech.glide.load.model.GlideUrl;

import java.io.InputStream;

import mdzz.com.first_of_mdzz.utils.OkHttpClientHelper;

/**
 * Created by acer on 2016/11/15.
 */

public class MyApplication extends Application{




    public static MyApplication app;

    private MyApplication() {

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
