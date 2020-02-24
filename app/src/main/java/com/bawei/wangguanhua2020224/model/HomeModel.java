package com.bawei.wangguanhua2020224.model;

import com.bawei.wangguanhua2020224.contract.IHomeContract;
import com.bawei.wangguanhua2020224.utils.NetUtils;

/**
 * Time: 2020/2/24
 * Author: 王冠华
 * Description:
 * 创建Model类并且实现接口,用来关联网络工具类
 */
public class HomeModel implements IHomeContract.IModel {
    @Override
    public void getBanner(String url, final IHomeContract.IBannerCallBack iBannerCallBack) {
        //调用网络工具类
        NetUtils.getInstance().getJson(url, new NetUtils.ICallBack() {
            @Override
            public void onSuccess(String json) {
                //调用接口方法放入参数
                iBannerCallBack.onGetBanner(json);
            }

            @Override
            public void onFailer(String msg) {

            }
        });
    }

    @Override
    public void getList(String url, final IHomeContract.IListCallBack iListCallBack) {
        //调用网络工具类
        NetUtils.getInstance().getJson(url, new NetUtils.ICallBack() {
            @Override
            public void onSuccess(String json) {
                //调用接口方法放入参数
                iListCallBack.onGetList(json);
            }

            @Override
            public void onFailer(String msg) {

            }
        });
    }
}
