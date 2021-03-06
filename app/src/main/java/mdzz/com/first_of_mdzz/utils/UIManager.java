package mdzz.com.first_of_mdzz.utils;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import java.net.PortUnreachableException;

import mdzz.com.first_of_mdzz.config.Constant;
import mdzz.com.first_of_mdzz.ui.main.MainActivity;
import mdzz.com.first_of_mdzz.ui.selectposition.SelectCityActivity;
import mdzz.com.first_of_mdzz.ui.web.WebActivity;


/**
 * Created by wanggang on 2016/11/14.
 */

public class UIManager {

    //跳转界面工具类
    public static void startMain(Context context,
                                 int code,
                                 String name){
        Intent intent=new Intent();
        intent.setClass(context,MainActivity.class);
        intent.putExtra("code",code);
        intent.putExtra("name",name);
        context.startActivity(intent);
    }

    public static void startSelectCity(Context context,
                                 String cityname){
        Intent intent=new Intent();
        intent.setClass(context,SelectCityActivity.class);
        intent.putExtra("name",cityname);
        context.startActivity(intent);
    }

    public static void startWebActivity(Context context ,String urlstring,@Nullable String title){
        Intent intent=new Intent();

        intent.setClass(context,WebActivity.class);
        intent.putExtra(Constant.WEB_URL,urlstring);
        if(title!=null){
            intent.putExtra(Constant.WEB_TITLE,title);
        }
        context.startActivity(intent);
    }



}
