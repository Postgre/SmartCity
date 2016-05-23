package com.smartcity.fragment.chw;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.smartcity.R;
import com.smartcity.activity.chw.twentyfourhour.TwentyFourHourActivity;
import com.smartcity.activity.chw.wyx.CoolActivity;
import com.smartcity.activity.circle.NewChatMainActivity;
import com.smartcity.base.BaseFragment;
import com.smartcity.customview.CircleLayout;
import com.smartcity.customview.CircleMenuLayout;

import butterknife.Bind;

public class ChwFragment extends BaseFragment {
    private static final String TAG = ChwFragment.class.getName();
    private static final String[] mItemTexts = {"我要炫", "呼叫服务", "白送白玩", "泡圈聊天", "粉旗帜", "粉账号"};
    private static final int[] mItemImgs = new int[]{R.mipmap.woyaoxuan, R.mipmap.huhuanfuwu, R.mipmap.baisongbaiwan, R.mipmap.paoquanliaotian, R.mipmap.fenqizhi, R.mipmap.fenzhanghu};
    public static boolean circle = false;
    @Bind(R.id.id_menulayout)
    CircleMenuLayout mCircleMenuLayout;
    @Bind(R.id.tv_city)
    TextView tv_city;
    private CircleLayout circleMenu;
    private FragmentTransaction mTransaction;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        initView();
        return view;
    }

    @Override
    protected void initAllMembersView(Bundle savedInstanceState) {

    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void init() {

    }

    private void initView() {
        mCircleMenuLayout.setMenuItemIconsAndTexts(mItemImgs, mItemTexts);
        mCircleMenuLayout.setOnMenuItemClickListener(new CircleMenuLayout.OnMenuItemClickListener() {

            @Override
            public void itemClick(View view, int pos) {
                switch (pos) {
                    case 0://"我要炫"
                        Intent intent = new Intent(getActivity(), CoolActivity.class);
                        startActivity(intent);
                        break;
                    case 1://"呼叫服务"
                        break;
                    case 2://"白送白玩"
                        break;
                    case 3: //"泡圈聊天"
                        Intent intent2 = new Intent(getActivity(), NewChatMainActivity.class);
                        startActivity(intent2);
                        break;
                    case 5:// "粉旗帜"
                        break;
                    case 6://"粉账号"
                        break;
                }
            }

            @Override
            public void itemCenterClick(View view) {
                Intent intent = new Intent(getActivity(), TwentyFourHourActivity.class);
                startActivity(intent);

            }
        });
        mCircleMenuLayout.rotateOneCircle();
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_chw;
    }

}