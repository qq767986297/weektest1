package com.bawei.wangguanhua2020224.utils;

import android.content.Context;

import java.io.PrintWriter;
import java.io.Writer;

/**
 * Time: 2020/3/6
 * Author: 王冠华
 * Description:
 */
public class CarshHandler implements Thread.UncaughtExceptionHandler {
    //单例模式
    private static CarshHandler carshHandler=new CarshHandler();
    private Thread.UncaughtExceptionHandler handler;

    public CarshHandler() {
    }
    public static CarshHandler getInstance(){
        return carshHandler;
    }
    //得到全局上下文
    public void  init(Context context){
        handler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }
    @Override
    public void uncaughtException(Thread t, Throwable e) {

    }

    public String save2File(Throwable ex){
        StringBuffer sb = new StringBuffer();
       return null;
    }

}
