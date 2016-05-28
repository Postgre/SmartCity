package com.smartcity.fragment.life;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.smartcity.R;
import com.smartcity.base.BaseFragment;
import com.smartcity.http.model.ScShopComment;
import com.smartcity.presenterImpl.CommentPresenter;
import com.smartcity.pulltofresh.PullToRefreshBase;
import com.smartcity.pulltofresh.PullToRefreshRecycleView;
import com.smartcity.view.CommentListView;
import com.zhy.base.adapter.ViewHolder;
import com.zhy.base.adapter.recyclerview.CommonAdapter;

import java.util.List;

import butterknife.Bind;

/**
 * Created by Yancy on 2016/5/14.
 * 商品评论列表
 */
public class CommodityFragment extends BaseFragment implements CommentListView {

    private static int type;

    @Bind(R.id.commodity_recy_list)
    PullToRefreshRecycleView recyclerView;
    private CommonAdapter<ScShopComment.ScShopCommentList> adapter;
    private CommentPresenter presenter;


    public static BaseFragment newInstance(int postion) {
        CommodityFragment commodityFragment = new CommodityFragment();
        type = postion;
        Bundle args = new Bundle();
        commodityFragment.setArguments(args);
        return commodityFragment;
    }

    @Override
    protected void initAllMembersView(Bundle savedInstanceState) {
    }

    @Override
    protected void initViews() {

        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setMode(PullToRefreshBase.Mode.BOTH);
        recyclerView.setAdapter(adapter = new CommonAdapter<ScShopComment.ScShopCommentList>(getActivity(), R.layout.commodity_list_left, null) {

            @Override
            public void convert(ViewHolder viewHolder, ScShopComment.ScShopCommentList scShopCommentList) {
                viewHolder.setVisible(R.id.commodity_ll_container, type == 1);
            }

        });

        recyclerView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<RecyclerView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<RecyclerView> refreshView) {
                presenter.freshen("1","1");

            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<RecyclerView> refreshView) {
                presenter.loadMore("1","1");

            }
        });

        presenter = new CommentPresenter(this, String.valueOf(type));

        presenter.freshen("1","1");
    }

    @Override
    protected void init() {

    }


    @Override
    public int getLayoutId() {
        return R.layout.fragment_commodity;
    }

    @Override
    public void startLogin() {

    }

    @Override
    public void setListData(int type, ScShopComment shopComment) {
        if (CommentPresenter.LOADING_TYPE_FRESH == type) {
            List<ScShopComment.ScShopCommentList> lists = adapter.getmDatas();
            if (null == lists) {
                adapter.setDatas(shopComment.getData());
            } else {
                adapter.clearDatas();
                adapter.setDatas(shopComment.getData());
            }
        } else {
               //添加更多
        }
    }

    @Override
    public void stopFresh() {
        recyclerView.onRefreshComplete();
    }

    @Override
    public boolean isResh() {
        return recyclerView.isRefreshing();
    }

}
