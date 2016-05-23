package com.smartcity.activity.life;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;

import com.smartcity.R;
import com.smartcity.customview.LifeListView;
import com.smartcity.http.model.LifeOrderSelectType;
import com.zhy.base.adapter.ViewHolder;
import com.zhy.base.adapter.abslistview.CommonAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by Yancy on 2016/5/14.
 * 提交订单
 */
public class LifeOrderActivity extends LifeBaseActivity {

    @Bind(R.id.life_order_select_time)
    LifeListView lvSelectTime;

    @Bind(R.id.iv_shop_time)
    ImageView ivTime;


    @Bind(R.id.life_order_pay_type)
    LifeListView lvPayType;

    @Bind(R.id.iv_shop_pay_state)
    ImageView ivPayState;

    @Bind(R.id.life_order_ship_method)
    LifeListView lvShipMethod;

    @Bind(R.id.iv_ship_method)
    ImageView ivShipMethod;

    @Override
    protected void initViews() {
        initTime();
        initPayType();
        initShipMethod();
    }

    private void initShipMethod() {
        List<LifeOrderSelectType> datas = new ArrayList<>();
        datas.add(new LifeOrderSelectType("快递", 1, 1));
        datas.add(new LifeOrderSelectType("送货上门", 2, 0));
        datas.add(new LifeOrderSelectType("自取", 3, 0));
        final CommonAdapter<LifeOrderSelectType> adapter;
        lvShipMethod.setAdapter(adapter = new CommonAdapter<LifeOrderSelectType>(this, R.layout.life_order_select_type_item, datas) {
            @Override
            public void convert(ViewHolder viewHolder, final LifeOrderSelectType lifeOrderSelectType) {
                viewHolder.setText(R.id.select_type_item_name, lifeOrderSelectType.name);
                viewHolder.setImageResource(R.id.select_type_item_iv, lifeOrderSelectType.showImg == 1 ? R.mipmap.zhifuxuanzhong : R.mipmap.zhifuweixuanzhong);
            }
        });
        lvShipMethod.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                List<LifeOrderSelectType> lifeOrderSelectTypes = adapter.getmDatas();
                for (LifeOrderSelectType nLifeOrderSelectType : lifeOrderSelectTypes) {
                    if (nLifeOrderSelectType.equals(lifeOrderSelectTypes.get(position))) {
                        nLifeOrderSelectType.showImg = 1;
                    } else {
                        nLifeOrderSelectType.showImg = 0;
                    }
                }
                adapter.notifyDataSetChanged();
                ivShipMethod.setImageResource(R.mipmap.shangjiantou);
                lvShipMethod.setVisibility(View.GONE);
            }
        });
    }

    private void initPayType() {
        List<LifeOrderSelectType> datas = new ArrayList<>();
        datas.add(new LifeOrderSelectType("微信支付", 1, 1));
        datas.add(new LifeOrderSelectType("支付宝支付", 1, 0));
        final CommonAdapter<LifeOrderSelectType> adapter;
        lvPayType.setAdapter(adapter = new CommonAdapter<LifeOrderSelectType>(this, R.layout.life_order_select_type_item, datas) {
            @Override
            public void convert(ViewHolder viewHolder, final LifeOrderSelectType lifeOrderSelectType) {
                viewHolder.setText(R.id.select_type_item_name, lifeOrderSelectType.name);
                viewHolder.setImageResource(R.id.select_type_item_iv, lifeOrderSelectType.showImg == 1 ? R.mipmap.zhifuxuanzhong : R.mipmap.zhifuweixuanzhong);
            }
        });
        lvPayType.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                List<LifeOrderSelectType> lifeOrderSelectTypes = adapter.getmDatas();
                for (LifeOrderSelectType nLifeOrderSelectType : lifeOrderSelectTypes) {
                    if (nLifeOrderSelectType.equals(lifeOrderSelectTypes.get(position))) {
                        nLifeOrderSelectType.showImg = 1;
                    } else {
                        nLifeOrderSelectType.showImg = 0;
                    }
                }
                adapter.notifyDataSetChanged();
                ivPayState.setImageResource(R.mipmap.shangjiantou);
                lvPayType.setVisibility(View.GONE);
            }
        });
    }

    private void initTime() {
        List<LifeOrderSelectType> datas = new ArrayList<>();
        datas.add(new LifeOrderSelectType("只双休日.节假日送货(工作日不送货) ", 1, 1));
        datas.add(new LifeOrderSelectType("工作日送货(双休日.节假日不送货)", 2, 0));
        datas.add(new LifeOrderSelectType("工作日,双休日.节假日都可送货", 2, 0));
        final CommonAdapter<LifeOrderSelectType> adapter;
        lvSelectTime.setAdapter(adapter = new CommonAdapter<LifeOrderSelectType>(this, R.layout.life_order_select_type_item, datas) {
            @Override
            public void convert(ViewHolder viewHolder, final LifeOrderSelectType lifeOrderSelectType) {
                viewHolder.setText(R.id.select_type_item_name, lifeOrderSelectType.name);
                viewHolder.setImageResource(R.id.select_type_item_iv, lifeOrderSelectType.showImg == 1 ? R.mipmap.zhifuxuanzhong : R.mipmap.zhifuweixuanzhong);
            }
        });
        lvSelectTime.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                List<LifeOrderSelectType> lifeOrderSelectTypes = adapter.getmDatas();
                for (LifeOrderSelectType nLifeOrderSelectType : lifeOrderSelectTypes) {
                    if (nLifeOrderSelectType.equals(lifeOrderSelectTypes.get(position))) {
                        nLifeOrderSelectType.showImg = 1;
                    } else {
                        nLifeOrderSelectType.showImg = 0;
                    }
                }
                adapter.notifyDataSetChanged();
                ivTime.setImageResource(R.mipmap.shangjiantou);
                lvSelectTime.setVisibility(View.GONE);
            }
        });
    }

    @Override
    protected String getName() {
        return "订单页面";
    }

    @Override
    protected View getCenterView() {
        return null;
    }

    @Override
    protected View getRightView() {
        return null;
    }

    @Override
    protected int getContentId() {
        return R.layout.activity_life__order;
    }

    @OnClick({R.id.life_order_rl_time, R.id.life_order_rl_paystate,R.id.life_order_rl_ship_method})
    public void showSelectTime(View view) {
        switch (view.getId()) {
            case R.id.life_order_rl_time:
                ivTime.setImageResource(R.mipmap.shangjiantou);
                lvSelectTime.setVisibility(lvSelectTime.getVisibility() == View.VISIBLE ? View.GONE : View.VISIBLE);
                ivTime.setImageResource(lvSelectTime.getVisibility() == View.VISIBLE ? R.mipmap.xiajiantou : R.mipmap.shangjiantou);
                break;
            case R.id.life_order_rl_paystate:
                ivPayState.setImageResource(R.mipmap.shangjiantou);
                lvPayType.setVisibility(lvPayType.getVisibility() == View.VISIBLE ? View.GONE : View.VISIBLE);
                ivPayState.setImageResource(lvPayType.getVisibility() == View.VISIBLE ? R.mipmap.xiajiantou : R.mipmap.shangjiantou);
                break;
            case R.id.life_order_rl_ship_method:
                ivShipMethod.setImageResource(R.mipmap.shangjiantou);
                lvShipMethod.setVisibility(lvShipMethod.getVisibility() == View.VISIBLE ? View.GONE : View.VISIBLE);
                ivShipMethod.setImageResource(lvShipMethod.getVisibility() == View.VISIBLE ? R.mipmap.xiajiantou : R.mipmap.shangjiantou);
                break;
            default:
                break;
        }

    }

}
