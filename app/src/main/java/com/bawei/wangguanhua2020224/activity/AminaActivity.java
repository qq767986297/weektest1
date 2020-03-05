package com.bawei.wangguanhua2020224.activity;

import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.widget.Button;
import android.widget.ImageView;

import com.bawei.wangguanhua2020224.R;
import com.bawei.wangguanhua2020224.base.BaseActivity;

public class AminaActivity extends BaseActivity {


    private Button bt;
    private ImageView iv;

    //关联布局
    @Override
    protected int getLayoult() {
        return R.layout.activity_amina;
    }
    //找控件
    @Override
    protected void initView() {
        bt = findViewById(R.id.bt);
        iv = findViewById(R.id.anim_iv);
    }

    @Override
    protected void getData() {
        //按钮点击事件
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ObjectAnimator设置动画图片,动画距离
                ObjectAnimator translationY = ObjectAnimator.ofFloat(iv, "translationY", 0, 800f);
                //设置动画时长
                translationY.setDuration(3000);
                //设置先后速度
                translationY.setInterpolator(new AccelerateInterpolator());
                //开启动画
                translationY.start();
            }
        });
    }
}
