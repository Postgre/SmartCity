package com.smartcity.presenter;

/**
 * Created by Administrator on 2016/5/25.
 */
public interface ApplyJoinCirclePresenter {
    void applyJoinCircle(String apikey, String applyCircleId, String applyUserId);
    void joinCircle(String apikey, String personCircleId, String personUserId);
}
