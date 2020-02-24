package com.bawei.wangguanhua2020224.contract;

/**
 * Time: 2020/2/24
 * Author: 王冠华
 * Description:
 * 编写契约类,创建MVPg各接口
 */
public interface IHomeContract {
    //创建View接口
    interface IView{
        //获取Banner方法
        void getBanner(String url);
        //获取List方法
        void getList(String url);
    }
    //创建Presenter接口
    interface IPresenter{
        //获取Banner方法
        void getBanner(String url);
        //获取List方法
        void getList(String url);
    }
    //创建Model接口
    interface IModel{
        //创建方法参数包含接口
        void getBanner(String url,IBannerCallBack iBannerCallBack);
        void getList(String url,IListCallBack iListCallBack);
    }
    //创建Model关联网络工具类方法
    interface IBannerCallBack{
        void onGetBanner(String str);
    }
    interface IListCallBack{
        void onGetList(String str);
    }
}
