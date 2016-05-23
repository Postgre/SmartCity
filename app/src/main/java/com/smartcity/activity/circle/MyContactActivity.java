package com.smartcity.activity.circle;


import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.netease.nim.uikit.contact.ContactsCustomization;
import com.netease.nim.uikit.contact.ContactsFragment;
import com.netease.nim.uikit.contact.core.item.AbsContactItem;
import com.netease.nim.uikit.contact.core.item.ItemTypes;
import com.netease.nim.uikit.contact.core.model.ContactDataAdapter;
import com.netease.nim.uikit.contact.core.viewholder.AbsContactViewHolder;
import com.netease.nim.uikit.recent.RecentContactsCallback;
import com.netease.nim.uikit.recent.RecentContactsFragment;
import com.netease.nimlib.sdk.NIMClient;
import com.netease.nimlib.sdk.msg.MsgService;
import com.netease.nimlib.sdk.msg.attachment.MsgAttachment;
import com.netease.nimlib.sdk.msg.model.IMMessage;
import com.netease.nimlib.sdk.msg.model.RecentContact;
import com.smartcity.R;
import com.smartcity.base.BaseActivity;
import com.smartcity.yx.contact.activity.AddFriendActivity;
import com.smartcity.yx.contact.activity.BlackListActivity;
import com.smartcity.yx.main.activity.SystemMessageActivity;
import com.smartcity.yx.main.activity.TeamListActivity;
import com.smartcity.yx.main.helper.SystemMessageUnreadManager;
import com.smartcity.yx.main.reminder.ReminderId;
import com.smartcity.yx.main.reminder.ReminderItem;
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
import butterknife.OnClick;

/**
 * Created by Administrator on 2016/5/17.
 */
public class MyContactActivity extends BaseActivity {


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
    private ContactsFragment contactsFragment;

    @Override
    public void init() {

        titleTv.setText("通讯录");
        rightImag.setVisibility(View.VISIBLE);
        rightImag.setBackgroundResource(R.mipmap.add_friend);
        right_img2.setVisibility(View.GONE);

        addFragment();

        contactsFragment.setContactsCustomization(new ContactsCustomization() {
            @Override
            public Class<? extends AbsContactViewHolder<? extends AbsContactItem>> onGetFuncViewHolderClass() {
                return FuncItem.FuncViewHolder.class;
            }

            @Override
            public List<AbsContactItem> onGetFuncItems() {
                return FuncItem.provide();
            }

            @Override
            public void onFuncItemClick(AbsContactItem item) {
                FuncItem.handle(MyContactActivity.this, item);
            }
        });
    }

    /**
     * ******************************** 功能项定制 ***********************************
     */
    public final static class FuncItem extends AbsContactItem {
        static final FuncItem VERIFY = new FuncItem();
        static final FuncItem NORMAL_TEAM = new FuncItem();
        static final FuncItem ADVANCED_TEAM = new FuncItem();
        static final FuncItem BLACK_LIST = new FuncItem();
        static final FuncItem MY_COMPUTER = new FuncItem();

        @Override
        public int getItemType() {
            return ItemTypes.FUNC;
        }

        @Override
        public String belongsGroup() {
            return null;
        }

        public static final class FuncViewHolder extends AbsContactViewHolder<FuncItem> {
            private ImageView image;
            private TextView funcName;
            private TextView unreadNum;

            @Override
            public View inflate(LayoutInflater inflater) {
                View view = inflater.inflate(R.layout.func_contacts_item, null);
                this.image = (ImageView) view.findViewById(R.id.img_head);
                this.funcName = (TextView) view.findViewById(R.id.tv_func_name);
                this.unreadNum = (TextView) view.findViewById(R.id.tab_new_msg_label);
                return view;
            }

            @Override
            public void refresh(ContactDataAdapter contactAdapter, int position, FuncItem item) {
                if (item == VERIFY) {
                    funcName.setText("验证提醒");
                    image.setImageResource(R.mipmap.icon_verify_remind);
                    image.setScaleType(ImageView.ScaleType.FIT_XY);
                    int unreadCount = SystemMessageUnreadManager.getInstance().getSysMsgUnreadCount();
                    updateUnreadNum(unreadCount);

                    ReminderManager.getInstance().registerUnreadNumChangedCallback(new ReminderManager.UnreadNumChangedCallback() {
                        @Override
                        public void onUnreadNumChanged(ReminderItem item) {
                            if (item.getId() != ReminderId.CONTACT) {
                                return;
                            }

                            updateUnreadNum(item.getUnread());
                        }
                    });
                } else if (item == NORMAL_TEAM) {
                    funcName.setText("讨论组");
                    image.setImageResource(R.mipmap.ic_secretary);
                } else if (item == ADVANCED_TEAM) {
                    funcName.setText("高级群");
                    image.setImageResource(R.mipmap.ic_advanced_team);
                } else if (item == BLACK_LIST) {
                    funcName.setText("黑名单");
                    image.setImageResource(R.mipmap.ic_black_list);
                } else if (item == MY_COMPUTER) {
//                    funcName.setText("我的电脑");
//                    image.setImageResource(R.drawable.ic_my_computer);
                }

                if (item != VERIFY) {
                    image.setScaleType(ImageView.ScaleType.FIT_XY);
                    unreadNum.setVisibility(View.GONE);
                }
            }

            private void updateUnreadNum(int unreadCount) {
                // 2.*版本viewholder复用问题
                if (unreadCount > 0 && funcName.getText().toString().equals("验证提醒")) {
                    unreadNum.setVisibility(View.VISIBLE);
                    unreadNum.setText("" + unreadCount);
                } else {
                    unreadNum.setVisibility(View.GONE);
                }
            }
        }

        static List<AbsContactItem> provide() {
            List<AbsContactItem> items = new ArrayList<AbsContactItem>();
            items.add(VERIFY);
            items.add(NORMAL_TEAM);
            items.add(ADVANCED_TEAM);
            items.add(BLACK_LIST);
//            items.add(MY_COMPUTER);

            return items;
        }

        static void handle(Context context, AbsContactItem item) {
            if (item == VERIFY) {
                SystemMessageActivity.start(context);
            } else if (item == NORMAL_TEAM) {
                TeamListActivity.start(context, ItemTypes.TEAMS.NORMAL_TEAM);
            } else if (item == ADVANCED_TEAM) {
                TeamListActivity.start(context, ItemTypes.TEAMS.ADVANCED_TEAM);
            } else if (item == MY_COMPUTER) {
//                SessionHelper.startP2PSession(context, DemoCache.getAccount());
            } else if (item == BLACK_LIST) {
                BlackListActivity.start(context);
            }
        }
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_newchat_main;
    }

    private void addFragment() {
        FragmentManager fm = getSupportFragmentManager();

        FragmentTransaction ft = fm.beginTransaction();
        hideFragment(ft);

        if (contactsFragment != null) {
            ft.show(contactsFragment);
        } else {
            contactsFragment = new ContactsFragment();
            ft.add(R.id.fragment_container, contactsFragment);
        }
        ft.commit();

    }

    //切换时隐藏fragment;
    private void hideFragment(FragmentTransaction ft) {

        if (contactsFragment != null) {
            ft.hide(contactsFragment);
        }

    }


    @OnClick({R.id.back_img, R.id.right_imag, R.id.right_img2})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_img:
                finish();
                break;

            case R.id.right_imag://添加好友
                AddFriendActivity.start(MyContactActivity.this);

                break;
        }
    }

}