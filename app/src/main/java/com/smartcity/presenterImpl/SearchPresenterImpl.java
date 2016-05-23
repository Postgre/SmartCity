package com.smartcity.presenterImpl;

import com.smartcity.config.Constant;
import com.smartcity.config.Url;
import com.smartcity.http.model.CircleBean;
import com.smartcity.model.SearchModel;
import com.smartcity.model.modelImpl.SearchModelImpl;
import com.smartcity.presenter.SearchPresenter;
import com.smartcity.utils.GsonUtils;
import com.smartcity.view.ISearchView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/5/12.
 */
public class SearchPresenterImpl implements SearchPresenter, SearchModelImpl.onLoadSearchListListener {

    private ISearchView iSearchView;
    private SearchModel searchModel;

    public SearchPresenterImpl(ISearchView iSearchView) {
        this.iSearchView = iSearchView;
        this.searchModel = new SearchModelImpl();
    }

    @Override
    public void getSearchData(String detailName, String sStartpage, String sPagerows) {
        if (!searchModel.isNetState()) {
            iSearchView.showToast("请检查网络连接!");
            return;
        }
        Map<String, Object> parm = new HashMap<>();
        parm.put("detailName", detailName);
        parm.put("sStartpage", sStartpage);
        parm.put("sPagerows", sPagerows);
        searchModel.loadSearchData(Constant.API_KEY, Url.GETCIRCLELIST, Constant.VERSION_CODE, GsonUtils.objectToJson(parm), this);
    }

    @Override
    public void onSuccess(List<CircleBean.CirDataEntity> list) {
        iSearchView.hideLoading();
        iSearchView.addList(list);
    }

    @Override
    public void onFailure(String msg) {
        iSearchView.hideLoading();
        iSearchView.showToast(msg);
    }
}
