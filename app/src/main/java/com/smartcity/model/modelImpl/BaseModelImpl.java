package com.smartcity.model.modelImpl;

import com.smartcity.application.MyApplication;
import com.smartcity.model.BaseModel;
import com.smartcity.utils.NetTool;

/**
 * Created by Yancy on 2016/5/23.
 */
public abstract class BaseModelImpl implements BaseModel {
    @Override
    public boolean isNetState() {
        return NetTool.isNetworkAvailable(MyApplication.getInstance());
    }
}
