package com.smartcity.model;

import com.smartcity.model.modelImpl.SearchModelImpl;

/**
 * Created by Administrator on 2016/5/11.
 */
public interface SearchModel extends BaseModel {
    void loadSearchData(String apikey, String version, String data, SearchModelImpl.onLoadSearchListListener listener);
}
