package com.bawei.wangguanhua2020224.base;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //加载布局
        setContentView(getLayoult());
        //找控件
        initView();
        //处理数据
        getData();
    }


    protected abstract int getLayoult();
    protected abstract void initView();
    protected abstract void getData();
}
