package com.bawei.wangguanhua2020224.base;

import android.app.Application;
import android.content.Context;

import com.bawei.wangguanhua2020224.utils.CarshHandler;
import com.tencent.bugly.Bugly;

/**
 * Time: 2020/3/6
 * Author: 王冠华
 * Description:
 */
public class App extends Application {

    private Context mcontext;

    @Override
    public void onCreate() {
        super.onCreate();
        mcontext = getApplicationContext();
        //传入全局上下文
        CarshHandler.getInstance().init(mcontext);
        Bugly.init(mcontext,"wang0306",true);

    }

}
