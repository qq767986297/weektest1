package com.bawei.wangguanhua2020224.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.bawei.wangguanhua2020224.R;
import com.bawei.wangguanhua2020224.base.BaseActivity;

public class Main2Activity extends BaseActivity {


    private TextView tv;

    @Override
    protected int getLayoult() {
        return R.layout.activity_base;
    }

    @Override
    protected void initView() {
        tv = findViewById(R.id.tv_id);
    }

    @Override
    protected void getData() {
        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        tv.setText(id);
    }
}
