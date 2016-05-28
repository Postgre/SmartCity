package com.smartcity.presenterImpl;

import android.text.TextUtils;

import com.smartcity.R;
import com.smartcity.application.MyApplication;
import com.smartcity.http.model.ScShopComment;
import com.smartcity.model.CommodityModel;
import com.smartcity.model.modelImpl.CommodityModelImpl;
import com.smartcity.presenter.BasePresenter;
import com.smartcity.view.AddCommentView;
import com.smartcity.view.CommentListView;

/**
 * Created by Yancy on 2016/5/27.
 * <p/>
 * 评论的控制器
 */
public class CommentPresenter implements BasePresenter {

    private AddCommentView addCommentView;
    private CommentListView commentListView;
    private CommodityModel commodityModel;

    private int pageNo;
    private String hasPicture;
    private static final int GOOD_TYPE = 0;
    private static final int PAGE_SIZE = 20;

    public static final int LOADING_TYPE_FRESH = 0x001;

    public static final int LOADING_TYPE_LOAD_MORE = 0x002;

    public CommentPresenter(CommentListView commentListView, String hasPicture) {
        initModel();
        this.hasPicture = hasPicture;
        this.commentListView = commentListView;
    }

    public CommentPresenter(AddCommentView addCommentView) {
        this.addCommentView = addCommentView;
        initModel();
    }

    public CommentPresenter() {
        initModel();
    }

    private void initModel() {
        commodityModel = new CommodityModelImpl();
    }

    //获取评论列表 刷新

    private boolean isFresh;

    public void freshen(String goodsId, String shopId) {
        hasMore = false;
        String apikey = MyApplication.getApikey();
        String id = MyApplication.getId();
        if (TextUtils.isEmpty(apikey) || TextUtils.isEmpty(id)) {
            commentListView.showToast(R.string.login_first);
            commentListView.startLogin();
            return;
        }
        if (!commodityModel.isNetState()) {
            commentListView.showToast(R.string.please_check_net);
            return;
        }
        commentListView.showLoading(null);
        pageNo = 1;
        if (!isFresh) {
            isFresh = true;
            commodityModel.getCommodityList(String.valueOf(GOOD_TYPE), shopId, goodsId, pageNo, PAGE_SIZE, hasPicture, apikey, new CommodityModelImpl.GetListCommentListener<ScShopComment>() {

                @Override
                public void getCommentSuccess(ScShopComment shopComment) {
                    isFresh = false;
                    commentListView.hideLoading();
                    commentListView.stopFresh();
                    if (null != shopComment.getData() && shopComment.getData().size() <= 0) {
                        commentListView.showToast(R.string.data_empty);
                    } else {
                        commentListView.setListData(LOADING_TYPE_FRESH, shopComment);
                    }
                }

                @Override
                public void getCommentError(String msg) {
                    isFresh = false;
                    commentListView.hideLoading();
                    commentListView.stopFresh();
                    commentListView.showToast(TextUtils.isEmpty(msg) ? "加载数据失败!" : msg);
                }
            });
        }

    }


    private boolean isLoadMore;

    private boolean hasMore;

    public void loadMore(String goodsId, String shopId) {
        String apikey = MyApplication.getApikey();
        String id = MyApplication.getId();
        if (TextUtils.isEmpty(apikey) || TextUtils.isEmpty(id)) {
            commentListView.showToast(R.string.login_first);
            commentListView.startLogin();
            return;
        }
        if (!commodityModel.isNetState()) {
            commentListView.showToast(R.string.please_check_net);
            return;
        }

        commentListView.showLoading(null);


        if (!hasMore) {
            if (!isLoadMore) {
                isLoadMore = true;
                commodityModel.getCommodityList(String.valueOf(GOOD_TYPE), shopId, goodsId, ++pageNo, PAGE_SIZE, hasPicture, apikey, new CommodityModelImpl.GetListCommentListener<ScShopComment>() {

                    @Override
                    public void getCommentSuccess(ScShopComment shopComment) {
                        isLoadMore = false;
                        commentListView.hideLoading();
                        commentListView.stopFresh();
                        if (null != shopComment.getData() && shopComment.getData().size() <= 0) {
                            commentListView.showToast(R.string.data_empty);
                        } else {
                            if (PAGE_SIZE > shopComment.getData().size()) {
                                hasMore = true;
                            }
                            commentListView.setListData(LOADING_TYPE_LOAD_MORE, shopComment);

                        }
                    }

                    @Override
                    public void getCommentError(String msg) {
                        commentListView.hideLoading();
                        isLoadMore = false;
                        commentListView.stopFresh();
                        commentListView.showToast(TextUtils.isEmpty(msg) ? "加载数据失败!" : msg);
                    }
                });
            }
        }

    }

    @Override
    public void start() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void stop() {

    }
}
