package com.example.chih.myapplication;


import android.app.Activity;
import android.support.annotation.NonNull;



public class ThemeUtil {
    public ThemeUtil() {
    }

    public static void setTheme(@NonNull Activity activity) {
        boolean isLight = PrefsUtils.read(activity, Config.THEME_CONFIG, true);

        if (isLight ) // 使用布林運算子來判斷背景是哪一種
        {
            activity.setTheme(R.style.ThemeLight);  //背景爽朗 的
        }
        else
        {
            activity.setTheme(R.style.ThemeDark);  //背景明亮的
        }



    }


    public static void reCreate(@NonNull final Activity activity) {
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                activity.recreate();
            }
        });
    }
}

