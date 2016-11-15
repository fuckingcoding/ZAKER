package mdzz.com.first_of_mdzz.utils;

import android.os.Environment;

import com.yztc.appframe.App;

import java.io.File;

/**
 * Created by wanggang on 2016/11/14.
 *
 * 文件管理
 */

public class FileManger {



    public  static File getRootCacheFile(){
        if(Environment.getExternalStorageState()
                .equals(Environment.MEDIA_MOUNTED)){
            return App.app.getExternalCacheDir();
        }else {
            return App.app.getCacheDir();
        }
    }


    public static File getImageCacheFile(){
        return new File(getRootCacheFile(),"image");
    }


    public static File getHttpCache(){
        return new File(getRootCacheFile(),"http");
    }
}
