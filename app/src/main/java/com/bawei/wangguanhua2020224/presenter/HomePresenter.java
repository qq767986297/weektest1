package com.bawei.wangguanhua2020224.presenter;

import com.bawei.wangguanhua2020224.contract.IHomeContract;
import com.bawei.wangguanhua2020224.model.HomeModel;

/**
 * Time: 2020/2/24
 * Author: 王冠华
 * Description:
 * 创建HomePresenter并且实现接口,用来完成M和V之间交互
 */
public class HomePresenter implements IHomeContract.IPresenter {
    //调用View接口
    IHomeContract.IView mView;
    HomeModel model;
    //构造方法
    public HomePresenter(IHomeContract.IView view){
        mView=view;
        //实例化HomeModel
        model=new HomeModel();
    }
    @Override
    public void getBanner(String url) {
        //调用model层方法
       model.getBanner(url, new IHomeContract.IBannerCallBack() {
           //获取轮播图数据
           @Override
           public void onGetBanner(String str) {
               mView.getBanner(str);
           }
       });
    }

    @Override
    public void getList(String url) {
        //调用model层方法
        model.getList(url, new IHomeContract.IListCallBack() {
            //获取列表数据
            @Override
            public void onGetList(String str) {
                mView.getList(str);
            }
        });
    }
}
