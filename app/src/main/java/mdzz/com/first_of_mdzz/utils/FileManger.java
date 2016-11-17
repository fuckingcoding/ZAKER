package mdzz.com.first_of_mdzz.utils;

import android.os.Environment;



import java.io.File;

import mdzz.com.first_of_mdzz.base.MyApplication;

/**
 * Created by wanggang on 2016/11/14.
 *
 * 文件管理
 */

public class FileManger {



    public  static File getRootCacheFile(){
        if(Environment.getExternalStorageState()
                .equals(Environment.MEDIA_MOUNTED)){
            return MyApplication.getInstance().getExternalCacheDir();
        }else {
            return MyApplication.getInstance().getCacheDir();
        }
    }


    public static File getImageCacheFile(){
        return new File(getRootCacheFile(),"image");
    }


    public static File getHttpCache(){
        return new File(getRootCacheFile(),"http");
    }
}
