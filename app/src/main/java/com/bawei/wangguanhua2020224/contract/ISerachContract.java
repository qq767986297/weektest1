package com.bawei.wangguanhua2020224.contract;

/**
 * Time: 2020/3/4
 * Author: 王冠华
 * Description:
 */
public interface ISerachContract {
    //v层接口
    interface IVew {
        void onSearchSuccess(String str);
        void onSearchFailure(String str);
    }
    //p层接口
    interface IPresenter{
        void onGetSearch(String url);
    }
    //v层接口
    interface IModel{
        void onGetSerach(String url,ISearch iSearch);
    }
    interface ISearch{
        void onGetSuccess(String json);
        void onGetFailure(String json);
    }
}
