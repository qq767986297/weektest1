package com.bawei.wangguanhua2020224.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.bawei.wangguanhua2020224.R;
import com.bawei.wangguanhua2020224.adapter.BeanBaseAdapter;
import com.bawei.wangguanhua2020224.base.BaseActivity;
import com.bawei.wangguanhua2020224.bean.Bean;
import com.bawei.wangguanhua2020224.contract.IHomeContract;
import com.bawei.wangguanhua2020224.presenter.HomePresenter;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;
import com.stx.xhb.xbanner.XBanner;

import java.util.List;

/**
 * Time: 2020/2/24
 * Author: 王冠华
 * Description:
 * 创建View并且实现接口,将数据传递给Presenter,UI效果展示
 */
public class MainActivity extends BaseActivity implements IHomeContract.IView {


    private XBanner xb;
    private ListView lv;
    private HomePresenter homePresenter;

    @Override
    protected int getLayoult() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        //找控件
        xb = findViewById(R.id.xb);
        lv = findViewById(R.id.lv);
    }

    @Override
    protected void getData() {
        //实例化Presenter
        homePresenter = new HomePresenter(this);
        //接口地址
        String path="http://blog.zhaoliang5156.cn/api/news/news_data.json";
        //传入接口地址
        homePresenter.getBanner(path);
        homePresenter.getList(path);
    }

    @Override
    public void getBanner(String url) {
            //Gson解析
        Gson gson = new Gson();
        Bean bean = gson.fromJson(url, Bean.class);
        List<Bean.ResultsBean> results = bean.getResults();
        final Bean.ResultsBean resultsBean = results.get(0);
        //获取到json中Banner数据集合
        final List<Bean.ResultsBean.BannerBean> bannerList = resultsBean.getBanner();
        //设置数据
        xb.setBannerData(bannerList);
        //加载图片
        xb.loadImage(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, Object model, View view, int position) {
                //获取到对应角标
                Bean.ResultsBean.BannerBean bannerBean = bannerList.get(position);
                //得到图片地址值
                String imageurl = bannerBean.getImageurl();
                //加载图片
                Picasso.get().load(imageurl).into((ImageView) view);
            }
        });
    }

    @Override
    public void getList(String url) {
        //Gson解析
        Gson gson = new Gson();
        Bean bean = gson.fromJson(url, Bean.class);
        List<Bean.ResultsBean> results = bean.getResults();
        Bean.ResultsBean bean1 = results.get(0);
        //获取到列表数据
        List<Bean.ResultsBean.NewsistBean> list = bean1.getNewsist();
        Log.i("xxx",url);
        //创建适配器
        BeanBaseAdapter bba = new BeanBaseAdapter(this, list);
        //设置适配器
        lv.setAdapter(bba);
    }
}
