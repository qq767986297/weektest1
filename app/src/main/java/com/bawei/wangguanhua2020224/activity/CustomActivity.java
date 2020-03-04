package com.bawei.wangguanhua2020224.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.bawei.wangguanhua2020224.R;
import com.bawei.wangguanhua2020224.base.BaseActivity;
import com.bawei.wangguanhua2020224.contract.ISerachContract;
import com.bawei.wangguanhua2020224.custom.CustomViewGroup;
import com.bawei.wangguanhua2020224.presenter.SerachPresnter;

public class CustomActivity extends BaseActivity implements ISerachContract.IVew {


    private CustomViewGroup cvg;

    @Override
    protected int getLayoult() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        cvg = findViewById(R.id.cvg);
    }

    @Override
    protected void getData() {
        String path="http://mobile.bwstudent.com/small/commodity/v1/findCommodityByKeyword";
        SerachPresnter presnter = new SerachPresnter(this);
        presnter.onGetSearch(path);

    }

    @Override
    public void onSearchSuccess(String str) {
        Log.i("success",str);
    }

    @Override
    public void onSearchFailure(String str) {
        Log.i("fail",str);
    }
}
