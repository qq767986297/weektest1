package com.bawei.wangguanhua2020224.model;

import com.bawei.wangguanhua2020224.contract.ISerachContract;
import com.bawei.wangguanhua2020224.utils.NetUtils;

/**
 * Time: 2020/3/4
 * Author: 王冠华
 * Description:
 */
public class SerachModel implements ISerachContract.IModel {
    @Override
    public void onGetSerach(String url, final ISerachContract.ISearch iSearch) {
        NetUtils.getInstance().getJson(url, new NetUtils.ICallBack() {
            @Override
            public void onSuccess(String json) {
                iSearch.onGetSuccess(json);
            }

            @Override
            public void onFailer(String msg) {
                iSearch.onGetFailure(msg);
            }
        });
    }
}
