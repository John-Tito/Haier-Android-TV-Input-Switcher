package com.johntito.tvinputswitcher;

import android.util.Log;

/**
 * Log工具类
 */
public class LogUtil {
    //控制项目是否显示log
    private static final boolean isShowLog = true;
    private static final String mySign = "tvInputSwitcher";

    public static void i(String tag, String msg){
        if (isShowLog){
            Log.i(mySign +tag,msg);
        }
    }

    public static void i(Object tag, String msg){
        if (isShowLog){
            Log.i(mySign +tag.getClass().getSimpleName(),msg);
        }
    }
    public static void d(String tag, String msg){
        if (isShowLog){
            Log.d(mySign +tag, msg);
        }
    }

    public static void d(Object tag, String msg){
        if (isShowLog){
            Log.d(mySign +tag.getClass().getSimpleName(), msg);
        }
    }
    public static void w(String tag, String msg){
        if (isShowLog){
            Log.w(mySign +tag, msg);
        }
    }

    public static void w(Object tag, String msg){
        if (isShowLog){
            Log.w(mySign +tag.getClass().getSimpleName(), msg);
        }
    }
    public static void e(String tag, String msg){
        if (isShowLog){
            Log.e(mySign +tag, msg);
        }
    }

    public static void e(Object tag, String msg){
        if (isShowLog){
            Log.e(mySign +tag.getClass().getSimpleName(), msg);
        }
    }
}
