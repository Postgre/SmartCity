package com.smartcity.activity.life;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;

import com.smartcity.R;
import com.smartcity.activity.LoginActivity;
import com.smartcity.http.model.AddressList;
import com.smartcity.presenterImpl.AddressPresenter;
import com.smartcity.utils.LogTool;
import com.smartcity.utils.UIUtils;
import com.smartcity.view.IAddressView;
import com.zhy.base.adapter.ViewHolder;
import com.zhy.base.adapter.recyclerview.CommonAdapter;

import butterknife.Bind;

public class LifeAddressListActivity extends LifeBaseActivity implements IAddressView {

    @Bind(R.id.address_list_container)
    ListView addressContainer;
    private AddressPresenter presenter;
    private com.zhy.base.adapter.abslistview.CommonAdapter<AddressList.LifeAddressModel> adapter;


    @Override
    protected void initViews() {

        lifeBg.setBackgroundColor(Color.WHITE);

     /*   LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        addressContainer.setLayoutManager(manager);
        addressContainer.setHasFixedSize(true);
        addressContainer.setAdapter(adapter = new CommonAdapter<AddressList.LifeAddressModel>(this, R.layout.life_address_item, null) {

            @Override
            public void convert(ViewHolder viewHolder, AddressList.LifeAddressModel lifeAddressModel) {

                viewHolder.setText(R.id.address_list_tv_name, lifeAddressModel.getName());
            }
        });*/
        addressContainer.setAdapter(adapter = new com.zhy.base.adapter.abslistview.CommonAdapter<AddressList.LifeAddressModel>(this, R.layout.life_address_item, null) {
            @Override
            public void convert(ViewHolder viewHolder, AddressList.LifeAddressModel lifeAddressModel) {
                viewHolder.setText(R.id.address_list_tv_name,lifeAddressModel.getName());
            }
        });
        presenter = new AddressPresenter(this);
    }

    @Override
    protected String getName() {
        return "地址列表";
    }

    @Override
    protected View getCenterView() {
        return null;
    }

    @Override
    protected View getRightView() {
        ImageView ivAdd = new ImageView(this);
        ivAdd.setLayoutParams(new FrameLayout.LayoutParams(UIUtils.px2dip(50),UIUtils.px2dip(50)));
        ivAdd.setImageResource(R.mipmap.icon_zenjia);
        ivAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LifeAddressListActivity.this,LifeAddRessActivity.class));
            }
        });
        return ivAdd;
    }

    @Override
    protected int getContentId() {
        return R.layout.activity_life_address_list;
    }

    @Override
    public void setData(AddressList addressList) {

        LogTool.e("test", addressList.toString());
        adapter.setDatas(addressList.getData());
    }

    @Override
    public void startLogin() {
        startActivity(new Intent(this, LoginActivity.class));
    }
}
