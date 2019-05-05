package com.example.constructdemo.net;

import android.os.Environment;

import java.io.File;

public final class AppConstant {

    public static final int HTTP_TIME_OUT=66;//网络超时
    //设缓存有效期为1天
    public static final long CACHE_CONTROL_CACHE = 60 * 60 * 24 * 1;
    //Http缓存大小
    public static final int HTTP_MAX_CACHE_SIZE=300 * 1024 * 1024;

    public static final String BASE_URL="https://www.baidu.com/";
    public static final String DB_NAME="constant.db";

    //----path
    public final static String CACHE_FILE = "construct" + File.separator + "cache";
    public final static String HTTP_CACHE_PATH =
            Environment.getExternalStorageDirectory()
                    .getAbsoluteFile()
                    + File.separator
                    + CACHE_FILE
                    + File.separator
                    + "httpcache"
                    + File.separator;
    public final static String LOG_CACHE_PATH =
            Environment.getExternalStorageDirectory()
                    .getAbsoluteFile()
                    + File.separator
                    + CACHE_FILE
                    + File.separator
                    + "log"
                    + File.separator;


}
