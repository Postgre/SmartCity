package com.smartcity.activity.circle;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;
import com.smartcity.R;
import com.smartcity.application.MyApplication;
import com.smartcity.base.BaseActivity;
import com.smartcity.http.model.CircleBean;
import com.smartcity.http.model.CircleByLabel;
import com.smartcity.http.model.LabelBean;
import com.smartcity.presenter.ApplyJoinCirclePresenter;
import com.smartcity.presenterImpl.ApplyJoinCirclePresenterImpl;
import com.smartcity.view.ICircleView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016/5/6.
 */
public class AllCircleDetailActivity extends BaseActivity implements ICircleView {

    @Bind(R.id.cr_detail)
    SimpleDraweeView crDetail;
    @Bind(R.id.cr_name)
    TextView crName;
    @Bind(R.id.cr_type_name)
    ImageView crTypeName;
    @Bind(R.id.cr_type)
    TextView crType;
    @Bind(R.id.ll_type)
    LinearLayout llType;
    @Bind(R.id.cr_num_img)
    ImageView crNumImg;
    @Bind(R.id.cr_num)
    TextView crNum;
    @Bind(R.id.ll_num)
    LinearLayout llNum;
    @Bind(R.id.tv_join)
    TextView tvJoin;

    @Bind(R.id.back_img)
    ImageView back_img;
    @Bind(R.id.title_tv)
    TextView title_tv;
    private int group;
    private String groupId;
    private String apikey;
    private String groupName;
    private ApplyJoinCirclePresenter joinCirclePresenter;
    private String userId;

    @Override
    public void init() {
        group = getIntent().getIntExtra("group", 0);
        groupId = getIntent().getStringExtra("groupId");
        groupName = getIntent().getStringExtra("groupName");
        apikey = MyApplication.getApikey();
        userId = MyApplication.getId();
        joinCirclePresenter = new ApplyJoinCirclePresenterImpl(this);


        back_img.setVisibility(View.VISIBLE);
        title_tv.setVisibility(View.VISIBLE);
        if (group == 1) {
            llType.setVisibility(View.GONE);
            title_tv.setText(groupName);
            crName.setText(groupName);
        } else {
            title_tv.setText("资料详情");
        }
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_allcircledetail;
    }


    @OnClick({R.id.back_img, R.id.tv_join})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_img:
                finish();
                break;
            case R.id.tv_join:
                if (group == 1) {
//                    joinCirclePresenter.joinCircle(apikey,groupId,userId);
                    joinCirclePresenter.joinCircle(apikey, "5", userId);//temp
                } else
                    Toast.makeText(this, "加入圈子成功", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void addCircles(List<CircleBean.CirDataEntity> circleList) {

    }

    @Override
    public void addCirclesByLabel(List<CircleByLabel.DataEntity> circleList) {

    }

    @Override
    public void CircleGroup(List<CircleBean.CirDataEntity> circleList) {

    }

    @Override
    public void addLabels(List<LabelBean.DataEntity> labelList) {

    }
}
