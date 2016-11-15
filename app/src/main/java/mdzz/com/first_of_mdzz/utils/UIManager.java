package mdzz.com.first_of_mdzz.utils;

import android.content.Context;
import android.content.Intent;

import mdzz.com.first_of_mdzz.ui.main.MainActivity;


/**
 * Created by wanggang on 2016/11/14.
 */

public class UIManager {

    //打开界面  路由界面
    public static void startMain(Context context,
                                 int code,
                                 String name){
        Intent intent=new Intent();
        intent.setClass(context,MainActivity.class);
        intent.putExtra("code",code);
        intent.putExtra("name",name);
        context.startActivity(intent);
    }


}
