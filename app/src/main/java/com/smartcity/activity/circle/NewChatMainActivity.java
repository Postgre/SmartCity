package com.smartcity.activity.circle;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.netease.nim.uikit.recent.RecentContactsCallback;
import com.netease.nim.uikit.recent.RecentContactsFragment;
import com.netease.nimlib.sdk.NIMClient;
import com.netease.nimlib.sdk.msg.MsgService;
import com.netease.nimlib.sdk.msg.attachment.MsgAttachment;
import com.netease.nimlib.sdk.msg.model.IMMessage;
import com.netease.nimlib.sdk.msg.model.RecentContact;
import com.smartcity.R;
import com.smartcity.base.BaseActivity;
import com.smartcity.yx.main.reminder.ReminderManager;
import com.smartcity.yx.session.SessionHelper;
import com.smartcity.yx.session.extension.GuessAttachment;
import com.smartcity.yx.session.extension.RTSAttachment;
import com.smartcity.yx.session.extension.SnapChatAttachment;
import com.smartcity.yx.session.extension.StickerAttachment;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016/5/17.
 */
public class NewChatMainActivity extends BaseActivity {


    @Bind(R.id.back_img)
    ImageView backImg;
    @Bind(R.id.fragment_container)
    FrameLayout fragmentContainer;
    @Bind(R.id.title_tv)
    TextView titleTv;
    @Bind(R.id.right_imag)
    ImageView rightImag;
    @Bind(R.id.right_img2)
    ImageView right_img2;
    private RecentContactsFragment recentContactsFragment;

    @Override
    public void init() {

        titleTv.setText("聊天");

        addFragment();

        recentContactsFragment.setCallback(new RecentContactsCallback() {
            @Override
            public void onRecentContactsLoaded() {

            }

            @Override
            public void onUnreadCountChange(int unreadCount) {
                ReminderManager.getInstance().updateSessionUnreadNum(unreadCount);
            }

            @Override
            public void onItemClick(RecentContact recent) {
                // 回调函数，以供打开会话窗口时传入定制化参数，或者做其他动作
                switch (recent.getSessionType()) {
                    case P2P:
                        SessionHelper.startP2PSession(NewChatMainActivity.this, recent.getContactId());
                        break;
                    case Team:
                        SessionHelper.startTeamSession(NewChatMainActivity.this, recent.getContactId());
                        break;
                    default:
                        break;
                }
            }

            @Override
            public String getDigestOfAttachment(MsgAttachment attachment) {

                // 设置自定义消息的摘要消息，展示在最近联系人列表的消息缩略栏上
                // 当然，你也可以自定义一些内建消息的缩略语，例如图片，语音，音视频会话等，自定义的缩略语会被优先使用。
                if (attachment instanceof GuessAttachment) {
                    GuessAttachment guess = (GuessAttachment) attachment;
                    return guess.getValue().getDesc();
                } else if (attachment instanceof RTSAttachment) {
                    return "[白板]";
                } else if (attachment instanceof StickerAttachment) {
                    return "[贴图]";
                } else if (attachment instanceof SnapChatAttachment) {
                    return "[阅后即焚]";
                }
                return null;
            }

            @Override
            public String getDigestOfTipMsg(RecentContact recent) {

                String msgId = recent.getRecentMessageId();
                List<String> uuids = new ArrayList<>(1);
                uuids.add(msgId);
                List<IMMessage> msgs = NIMClient.getService(MsgService.class).queryMessageListByUuidBlock(uuids);
                if (msgs != null && !msgs.isEmpty()) {
                    IMMessage msg = msgs.get(0);
                    Map<String, Object> content = msg.getRemoteExtension();
                    if (content != null && !content.isEmpty()) {
                        return (String) content.get("content");
                    }
                }
                return null;
            }
        });
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_newchat_main;
    }

    private void addFragment() {
        FragmentManager fm = getSupportFragmentManager();

        FragmentTransaction ft = fm.beginTransaction();
        hideFragment(ft);

        if (recentContactsFragment != null) {
            ft.show(recentContactsFragment);
        } else {
            recentContactsFragment = new RecentContactsFragment();
            ft.add(R.id.fragment_container, recentContactsFragment);
        }
        ft.commit();

    }

    //切换时隐藏fragment;
    private void hideFragment(FragmentTransaction ft) {

        if (recentContactsFragment != null) {
            ft.hide(recentContactsFragment);
        }

    }


    @OnClick({R.id.back_img,R.id.right_imag, R.id.right_img2})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_img:
                finish();
                break;

            case R.id.right_imag://朋友圈
                Intent i = new Intent(this,Lift_ContentActivity.class);
                startActivity(i);


                break;
            case R.id.right_img2://通讯录
                Intent intent = new Intent(this,MyContactActivity.class);
                startActivity(intent);
                break;
        }
    }

}