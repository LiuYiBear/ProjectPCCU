package com.example.chih.myapplication;


import android.app.Activity;
import android.support.annotation.NonNull;

/**
 * Created by user on 2018/9/8.
 */

public class ThemeUtil {
    public ThemeUtil() {
    }

    public static void setTheme(@NonNull Activity activity) {
        boolean isLight = PrefsUtils.read(activity, Config.THEME_CONFIG, true);
        if (isLight) activity.setTheme(R.style.ThemeLight);
        else activity.setTheme(R.style.ThemeDark);
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
