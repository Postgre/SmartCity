package com.smartcity.adapter.life;

import android.content.Context;
import android.media.Image;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.smartcity.R;
import com.smartcity.base.BaseRecyclerViewAdapter;
import com.smartcity.base.RecyclerViewHolderBase;
import com.smartcity.http.model.AddressList;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Yancy on 2016/5/25.
 */
public class LifeAddressListAdapter  extends BaseRecyclerViewAdapter<AddressList.LifeAddressModel> {

    private DeleteDialogCallback callback;

    private EditeAddressCallback editeCallback;

    public void setEditeCallback(EditeAddressCallback editeCallback) {
        this.editeCallback = editeCallback;
    }

    public LifeAddressListAdapter(Context context, List<AddressList.LifeAddressModel> mData) {
        super(context, mData);
    }

    @Override
    public void bindView(RecyclerViewHolderBase viewHolder, final int position, List<AddressList.LifeAddressModel> list) {
        final AddressList.LifeAddressModel addressModel = list.get(position);
        AddressListViewHodler hodler = (AddressListViewHodler) viewHolder;
        hodler.tvName.setText(addressModel.getName());
        hodler.tvAddress.setText(addressModel.getAddress());
        hodler.cbIsDefaule.setChecked( 0== addressModel.getIsDefault());

        hodler.ivDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(null != callback)
                {
                    callback.showDelete(position);
                }
            }
        });

        hodler.ivEdite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(null != editeCallback){
                    editeCallback.eciteAddress(addressModel,position);
                }
            }
        });
    }

    @Override
    public View createView(ViewGroup viewGroup, int viewType) {
        return layoutInflater.inflate(R.layout.life_address_item, null);
    }

    @Override
    public RecyclerViewHolderBase createViewHolder(View view) {
        return new AddressListViewHodler(view);
    }

    static class AddressListViewHodler extends RecyclerViewHolderBase {

        @Bind(R.id.address_list_tv_name)
        TextView tvName;

        @Bind(R.id.address_list_tv_address)
        TextView tvAddress;

        @Bind(R.id.address_list_delete)
        ImageView ivDelete;

        @Bind(R.id.address_item_cb_isdefault)
        CheckBox cbIsDefaule;


        @Bind(R.id.address_list_iv_edite)
        ImageView ivEdite;

        public AddressListViewHodler(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public void setCallback(DeleteDialogCallback callback) {
        this.callback = callback;
    }


    public interface  DeleteDialogCallback
    {
        void showDelete(int postion);
    }

    public  interface EditeAddressCallback
    {
        void  eciteAddress(AddressList.LifeAddressModel model,int postion);
    }

}