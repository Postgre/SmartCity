package com.smartcity.activity.life;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.smartcity.R;
import com.smartcity.activity.LoginActivity;
import com.smartcity.adapter.life.ShopcartExpandableListViewAdapter;
import com.smartcity.http.model.CartInfo;
import com.smartcity.http.model.ScShopCartGoodsDetail;
import com.smartcity.http.model.ScShopCartVo;
import com.smartcity.presenterImpl.CartPresenter;
import com.smartcity.utils.LogTool;
import com.smartcity.view.ICartView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

public class LifeCartActivity extends LifeBaseActivity implements ShopcartExpandableListViewAdapter.CheckInterface, ShopcartExpandableListViewAdapter.ModifyCountInterface, ICartView, ShopcartExpandableListViewAdapter.EditeInterface, ShopcartExpandableListViewAdapter.DeleteInterface {

    @Bind(R.id.cart_exListView)
    ExpandableListView carContainer;

    @Bind(R.id.all_chekbox)
    CheckBox allCheck;


    @Bind(R.id.tv_go_to_pay)
    TextView tvGoPay;

    @Bind(R.id.tv_pay_money)
    TextView tvPayMoney;

    private ShopcartExpandableListViewAdapter selva;

    private double totalPrice = 0.00;// 购买的商品总价
    private int totalCount = 0;// 购买的商品总数量
    private CartPresenter cartPresenter;
    private List<ScShopCartVo> groups;

    @Override
    protected void initViews() {
        cartPresenter = new CartPresenter(this);
    }


    @Override
    protected String getName() {
        return "购物车";
    }

    @Override
    protected View getCenterView() {
        return null;
    }


    @Override
    protected View getRightView() {
        TextView tv = new TextView(this);
        tv.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT));
        tv.setGravity(Gravity.CENTER);
        tv.setTextColor(getResources().getColor(R.color.black1));
        tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
        tv.setText("编辑全部");
        return tv;
    }

    @Override
    protected int getContentId() {
        return R.layout.activity_life_crat;
    }

    @Override
    public void checkGroup(int groupPosition, boolean isChecked) {
        ScShopCartVo group = groups.get(groupPosition);
        List<ScShopCartGoodsDetail> goodsLists = group.getGoodsList();


        for (int i = 0; i < goodsLists.size(); i++) {
            goodsLists.get(i).setChoosed(isChecked);
        }
        if (isAllCheck()) {
            allCheck.setChecked(true);
        } else {
            allCheck.setChecked(false);
        }
        selva.notifyDataSetChanged();
        calculate();
    }


    @Override
    public void checkChild(int groupPosition, int childPosition, boolean isChecked) {
        boolean allChildSameState = true;// 判断改组下面的所有子元素是否是同一种状态
        ScShopCartVo group = groups.get(groupPosition);

        List<ScShopCartGoodsDetail> childs = children.get(groupPosition);
        for (int i = 0; i < childs.size(); i++) {
            if (childs.get(i).isChoosed() != isChecked) {
                allChildSameState = false;
                break;
            }
        }
        if (allChildSameState) {
            group.setChoosed(isChecked);// 如果所有子元素状态相同，那么对应的组元素被设为这种统一状态
        } else {
            group.setChoosed(false);// 否则，组元素一律设置为未选中状态
        }

        if (isAllCheck())
            allCheck.setChecked(true);
        else
            allCheck.setChecked(false);
        selva.notifyDataSetChanged();
        calculate();
    }


    private int currentCount = 0;

    @Override
    public void doIncrease(int groupPosition, int childPosition, final View showCountView, boolean isChecked) {
        final ScShopCartGoodsDetail product = (ScShopCartGoodsDetail) selva.getChild(groupPosition, childPosition);

        //调用更新接口

        currentCount = 0;
        currentCount = product.getNumber();
        ++currentCount;
        LogTool.e("test", String.valueOf(currentCount));
        cartPresenter.upDateCartNumber(product.getGoodsId(), currentCount, product.getStockId(), new CartPresenter.UpDataListener() {
            @Override
            public void success() {
                product.setNumber(currentCount);
                ((TextView) showCountView).setText(String.valueOf(currentCount));

                selva.notifyDataSetChanged();
                calculate();
            }

            @Override
            public void error() {
            }
        });

    }

    @Override
    public void doDecrease(int groupPosition, int childPosition, final View showCountView, boolean isChecked) {
        final ScShopCartGoodsDetail product = (ScShopCartGoodsDetail) selva.getChild(groupPosition, childPosition);
        currentCount = 0;
        currentCount = product.getNumber();
        if (currentCount == 1)
            return;
        //调用更新接口
        ++currentCount;
        LogTool.e("test", String.valueOf(currentCount));
        cartPresenter.upDateCartNumber(product.getGoodsId(), currentCount, product.getStockId(), new CartPresenter.UpDataListener() {
            @Override
            public void success() {
                product.setNumber(currentCount);
                ((TextView) showCountView).setText(String.valueOf(currentCount));

                selva.notifyDataSetChanged();
                calculate();
            }

            @Override
            public void error() {
            }
        });
    }

    private boolean isAllCheck() {

        for (ScShopCartVo group : groups) {
            if (!group.isChoosed())
                return false;
        }
        return true;
    }

    /**
     * 全选与反选
     */
    @OnClick(R.id.all_chekbox)
    public void doCheckAll() {
        if (null != groups && groups.size() > 0) {
            for (int i = 0; i < groups.size(); i++) {
                groups.get(i).setChoosed(allCheck.isChecked());

                ScShopCartVo datas = groups.get(i);
                List<ScShopCartGoodsDetail> goodsLists = datas.getGoodsList();
                for (int j = 0; j < goodsLists.size(); j++) {
                    children.get(i).get(j).setChoosed(allCheck.isChecked());
                }
            }
            selva.notifyDataSetChanged();
        }
    }

    /**
     * 统计操作
     * 1.先清空全局计数器
     * 2.遍历所有子元素，只要是被选中状态的，就进行相关的计算操作
     * 3.给底部的textView进行数据填充
     */
    private void calculate() {
        totalCount = 0;
        totalPrice = 0.00;
        for (int i = 0; i < groups.size(); i++) {
            ScShopCartVo group = groups.get(i);

            List<ScShopCartGoodsDetail> childs = group.getGoodsList();

            for (int j = 0; j < childs.size(); j++) {
                ScShopCartGoodsDetail product = childs.get(j);
                if (product.isChoosed()) {
                    totalCount++;
                    totalPrice += product.getGoodsPrice() * product.getNumber();
                }
            }
        }
        tvPayMoney.setText("￥" + totalPrice);
        tvGoPay.setText("去结算(" + totalCount + ")");
    }

    @Override
    public void startLogin() {
        startActivity(new Intent(this, LoginActivity.class));
    }

    private List<List<ScShopCartGoodsDetail>> children = new ArrayList<>();

    @Override
    public void setList(CartInfo info) {

        if (null != info && info.getData().size() > 0) {

            List<ScShopCartVo> data = info.getData();

            for (ScShopCartVo listda : data) {
                children.add(listda.getGoodsList());
            }

            groups = info.getData();
            selva = new ShopcartExpandableListViewAdapter(groups, children, this);
            selva.setCheckInterface(this);// 关键步骤1,设置复选框接口
            selva.setModifyCountInterface(this);// 关键步骤2,设置数量增减接口
            selva.setEditeInterface(this);//编辑界面
            selva.setDeleteInterface(this);//删除
            carContainer.setAdapter(selva);

            for (int i = 0; i < info.getData().size(); i++) {
                carContainer.expandGroup(i);// 关键步骤3,初始化时，将ExpandableListView以展开的方式呈现
            }

            //tv_delete.setOnClickListener(this);
        }

    }

    @Override
    public void editeGroup(int groupPosition, boolean isEdite) {
        ScShopCartVo group = groups.get(groupPosition);
        group.setEdite(isEdite);
        selva.notifyDataSetChanged();
    }

    @Override
    public void editeChilder(int groupPosition, int childPosition, boolean isEdite) {

    }

    //删除
    @Override
    public void deleteChilder(final int groupPosition, final int childPosition) {
        final AlertDialog alertDialog = new AlertDialog.Builder(this).setTitle("删除商品").setMessage("确定删除?").setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(final DialogInterface dialog, int which) {
                            cartPresenter.deleteGood(children.get(groupPosition).get(childPosition).getGoodsId(), new CartPresenter.DeleteGoodListener() {
                                @Override
                                public void deleteSuccess() {
                                   dialog.dismiss();
                                    children.get(groupPosition).remove(childPosition);
                                    selva.notifyDataSetChanged();

                                }

                                @Override
                                public void delteteError() {
                                    dialog.dismiss();
                                }
                            });
                    }
                }
        ).setNegativeButton("取消", null).setCancelable(false).show();
    }
}
