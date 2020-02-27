package com.bawei.wangguanhua2020224.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;

import com.bawei.wangguanhua2020224.R;
import com.bawei.wangguanhua2020224.adapter.BeanBaseAdapter;
import com.bawei.wangguanhua2020224.base.BaseActivity;
import com.bawei.wangguanhua2020224.bean.BannerBean;
import com.bawei.wangguanhua2020224.bean.Bean;
import com.bawei.wangguanhua2020224.bean.ListBean;
import com.bawei.wangguanhua2020224.contract.IHomeContract;
import com.bawei.wangguanhua2020224.presenter.HomePresenter;
import com.bumptech.glide.Glide;
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
    private GridView lv;
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
        //轮播图
        String bannerurl="http://mobile.bwstudent.com/small/commodity/v1/bannerShow";
        //列表
        String listurl="http://mobile.bwstudent.com/small/commodity/v1/commodityList";
        //传入接口地址
        homePresenter.getBanner(bannerurl);
        homePresenter.getList(listurl);
    }

    @Override
    public void getBanner(String url) {
            //Gson解析
        Gson gson = new Gson();
        BannerBean bean = gson.fromJson(url, BannerBean.class);
        //获取到json中Banner数据集合
        final List<BannerBean.ResultBean> result = bean.getResult();
        //设置数据
        xb.setBannerData(result);
        //加载图片
        xb.loadImage(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, Object model, View view, int position) {
                //获取到对应角标
                BannerBean.ResultBean resultBean = result.get(position);
                //得到图片地址
                String imageUrl = resultBean.getImageUrl();
                //Glide加载图片
                Glide.with(getApplicationContext()).load(imageUrl).into((ImageView) view);

            }
        });
    }

    @Override
    public void getList(String url) {
        //创建品质生活的bean对象，并把请求的Json数据转换成对象
        //gson解析
        Gson gson = new Gson();
        ListBean listBean = gson.fromJson(url, ListBean.class);
        ListBean.ResultBean result = listBean.getResult();
        ListBean.ResultBean.PzshBean pzsh = result.getPzsh();
        //获取到品质生活的集合
        final List<ListBean.ResultBean.PzshBean.CommodityListBeanX> commodityList = pzsh.getCommodityList();
        //创建适配器
        BeanBaseAdapter bba = new BeanBaseAdapter(this, commodityList);
        lv.setAdapter(bba);
        //设置条目点击事件
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //获取点击当前对象
                ListBean.ResultBean.PzshBean.CommodityListBeanX beanX = commodityList.get(position);
                int commodityId = beanX.getCommodityId();
                //把商品的id传递到新界面用文本展示
                Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
                intent.putExtra("id",commodityId+"");
                startActivity(intent);
            }
        });
    }
}
