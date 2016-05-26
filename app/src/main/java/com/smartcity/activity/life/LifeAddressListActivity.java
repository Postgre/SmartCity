package com.smartcity.activity.life;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Rect;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.smartcity.R;
import com.smartcity.activity.LoginActivity;
import com.smartcity.adapter.life.LifeAddressListAdapter;
import com.smartcity.http.model.AddressList;
import com.smartcity.presenterImpl.AddressPresenter;
import com.smartcity.utils.LogTool;
import com.smartcity.utils.UIUtils;
import com.smartcity.view.IAddressView;

import butterknife.Bind;

public class LifeAddressListActivity extends LifeBaseActivity implements IAddressView, LifeAddressListAdapter.DeleteDialogCallback {

    private static final int REQUESRT_CODE = 0x002;
    public static final String POSTION = "postion";
    @Bind(R.id.address_list_container)
    RecyclerView addressContainer;
    private AddressPresenter presenter;
    private com.zhy.base.adapter.abslistview.CommonAdapter<AddressList.LifeAddressModel> addressAdapter;
    private LifeAddressListAdapter adapter;

    public static final int EDITE_MODE =0x001;

    public static final String PARAMS = "params";
    public static final String PARAMS_TYPE = "type";

    @Override
    protected void initViews() {
        lifeBg.setBackgroundColor(Color.WHITE);
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
        ivAdd.setLayoutParams(new FrameLayout.LayoutParams(UIUtils.px2dip(50),FrameLayout.LayoutParams.MATCH_PARENT));
        ivAdd.setImageResource(R.mipmap.icon_zenjia);
        ivAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LifeAddressListActivity.this, LifeAddRessActivity.class);
                startActivityForResult(intent,REQUESRT_CODE);
            }
        });
        return ivAdd;
    }

    @Override
    protected int getContentId() {
        return R.layout.activity_life_address_list;
    }

    @Override
    public void setListData(AddressList addressList) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        addressContainer.setLayoutManager(layoutManager);
        addressContainer.addItemDecoration(new SpaceItemDecoration(20));
        addressContainer.setHasFixedSize(true);

        adapter = new LifeAddressListAdapter(this,addressList.getData());
        adapter.setCallback(this);
        adapter.setEditeCallback(new LifeAddressListAdapter.EditeAddressCallback() {
            @Override
            public void eciteAddress(AddressList.LifeAddressModel model, int postion) {

                Intent intent = new Intent(LifeAddressListActivity.this,LifeAddRessActivity.class);
                intent.putExtra(PARAMS,model);
                intent.putExtra(POSTION,postion);
                intent.putExtra(PARAMS_TYPE,EDITE_MODE);
                startActivityForResult(intent,REQUESRT_CODE);
            }
        });
        addressContainer.setAdapter(adapter);
    }

    @Override
    public void startLogin() {
        startActivity(new Intent(this, LoginActivity.class));
    }

    @Override
    public void showDelete(final int postion) {
         AlertDialog alertDialog = new AlertDialog.Builder(this).setTitle("删除收货地址").setMessage("确认删除?").setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(final DialogInterface dialog, int which) {
                if(null != adapter)
                {
                    AddressList.LifeAddressModel addressModel = adapter.getDatas().get(postion);
                    presenter.deleteAddress(postion, addressModel.getId(), new AddressPresenter.DeleteAddressCallback() {
                        @Override
                        public void deleteSuccess(int postion) {
                            adapter.remove(postion);
                            adapter.notifyDataSetChanged();
                            dialog.dismiss();
                        }

                        @Override
                        public void deleteError() {
                            dialog.dismiss();
                        }
                    });
                }

            }
        }).setNegativeButton("取消", null).setCancelable(false).show();

    }


    private class SpaceItemDecoration extends RecyclerView.ItemDecoration
    {

        private  int offset;

        public  SpaceItemDecoration(int offset)
        {
            this.offset = offset;
        }
        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            outRect.top = offset;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(REQUESRT_CODE == requestCode && LifeAddRessActivity.RESULT_CODE == resultCode)
        {
           AddressList.LifeAddressModel model = (AddressList.LifeAddressModel) data.getSerializableExtra(PARAMS);
            int postion = data.getIntExtra(POSTION, -1);
            LogTool.e("test",String.valueOf(postion));
            if(postion>0)
            {
                adapter.remove(postion);
            }

            adapter.add(model);
            adapter.notifyDataSetChanged();
        }
    }
}
