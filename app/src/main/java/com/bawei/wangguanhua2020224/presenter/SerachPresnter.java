package com.bawei.wangguanhua2020224.presenter;

import com.bawei.wangguanhua2020224.contract.ISerachContract;
import com.bawei.wangguanhua2020224.model.SerachModel;

/**
 * Time: 2020/3/4
 * Author: 王冠华
 * Description:
 */
public class SerachPresnter implements ISerachContract.IPresenter {

    private final SerachModel model;
    private ISerachContract.IVew mview;
    public SerachPresnter(ISerachContract.IVew view) {
        model = new SerachModel();
        mview=view;
    }

    @Override
    public void onGetSearch(String url) {
        model.onGetSerach(url, new ISerachContract.ISearch() {
            @Override
            public void onGetSuccess(String json) {
                mview.onSearchSuccess(json);
            }

            @Override
            public void onGetFailure(String json) {
                mview.onSearchFailure(json);
            }
        });
    }
}
