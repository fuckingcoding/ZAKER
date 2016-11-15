package mdzz.com.first_of_mdzz.utils;

import android.content.Context;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by acer on 2016/11/15.
 */

public class ToastHelper {

    private static Toast toast;
    private int time =Toast.LENGTH_SHORT;

    public static void showToast(Context context, String text,@Nullable int time) {
        if (toast == null) {
            toast = Toast.makeText(context, text, time);
        } else {
            toast.setText(text);
        }
        toast.show();
    }


    }



