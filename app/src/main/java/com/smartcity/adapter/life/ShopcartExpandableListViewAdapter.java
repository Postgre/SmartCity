package com.smartcity.adapter.life;

import java.util.List;
import java.util.Map;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.smartcity.R;
import com.smartcity.http.model.CartInfo;
import com.smartcity.http.model.GroupInfo;
import com.smartcity.http.model.ProductInfo;
import com.smartcity.http.model.ScShopCartGoodsDetail;
import com.smartcity.http.model.ScShopCartVo;
import com.smartcity.utils.LogTool;


public class ShopcartExpandableListViewAdapter extends BaseExpandableListAdapter {
    private List<ScShopCartVo> groups;
    private List<List<ScShopCartGoodsDetail>> children;
    private Context context;


    private  EditeInterface editeInterface;

    private CheckInterface checkInterface;

    private ModifyCountInterface modifyCountInterface;

    private DeleteInterface deleteInterface;

    public void setDeleteInterface(DeleteInterface deleteInterface) {
        this.deleteInterface = deleteInterface;
    }

    public void setEditeInterface(EditeInterface editeInterface) {
        this.editeInterface = editeInterface;
    }

    /**
     * 构造函数
     *
     * @param groups   组元素列表
     * @param children 子元素列表
     * @param context
     */
    public ShopcartExpandableListViewAdapter(List<ScShopCartVo> groups, List<List<ScShopCartGoodsDetail>> children, Context context) {
        super();
        this.groups = groups;
        this.children = children;
        this.context = context;
    }

    public void setCheckInterface(CheckInterface checkInterface) {
        this.checkInterface = checkInterface;
    }

    public void setModifyCountInterface(ModifyCountInterface modifyCountInterface) {
        this.modifyCountInterface = modifyCountInterface;
    }

    @Override
    public int getGroupCount() {
        return groups.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {

        return children.get(groupPosition).size();
    }

    @Override
    public ScShopCartVo getGroup(int groupPosition) {
        return groups.get(groupPosition);
    }

    @Override
    public ScShopCartGoodsDetail getChild(int groupPosition, int childPosition) {
        return children.get(groupPosition).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(final int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        GroupHolder gholder;
        if (convertView == null) {
            gholder = new GroupHolder();
            convertView = View.inflate(context, R.layout.item_shopcart_group, null);
            gholder.cb_check = (CheckBox) convertView.findViewById(R.id.cart_group_box);
            gholder.tv_group_name = (TextView) convertView.findViewById(R.id.cart_group_shop_name);
            gholder.tv_group_edite = (TextView) convertView.findViewById(R.id.car_group_tv_edite);
            convertView.setTag(gholder);
        } else {
            gholder = (GroupHolder) convertView.getTag();
        }
        final ScShopCartVo group = (ScShopCartVo) getGroup(groupPosition);

        if (group != null) {
            gholder.tv_group_name.setText(group.getShopName());

            gholder.tv_group_edite.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    group.setEdite(!group.isEdite());
                    editeInterface.editeGroup(groupPosition,group.isEdite());
                }
            });
            gholder.cb_check.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v)
                {
                    group.setChoosed(((CheckBox) v).isChecked());
                    checkInterface.checkGroup(groupPosition, ((CheckBox) v).isChecked());// 暴露组选接口
                }
            });
            gholder.tv_group_edite.setText(group.isEdite() ? "完成" : "编辑");
            gholder.cb_check.setChecked(group.isChoosed());
        }
        return convertView;
    }

    @Override
    public View getChildView(final int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        ScShopCartVo groupData = getGroup(groupPosition);

        final ScShopCartGoodsDetail product = (ScShopCartGoodsDetail) getChild(groupPosition, childPosition);

        final ChildHolder cholder;
        if (convertView == null) {
            cholder = new ChildHolder();
            convertView = View.inflate(context, R.layout.item_shopcart_product, null);

            cholder.cb_check = (CheckBox) convertView.findViewById(R.id.cart_product_box);
            cholder.tv_product_name = (TextView) convertView.findViewById(R.id.cart_product_shop_name);
            cholder.cart_product_iv = (SimpleDraweeView) convertView.findViewById(R.id.cart_product_iv);
            cholder.llShowInfoContainer = (LinearLayout) convertView.findViewById(R.id.cart_product_ll_info_container);
            cholder.rlEditeContainer = (RelativeLayout) convertView.findViewById(R.id.cart_product_rl_edite_container);


            convertView.setTag(cholder);
        } else {
            cholder = (ChildHolder) convertView.getTag();
        }


        //显示编辑界面
        if (groupData.isEdite()) {
            cholder.rlEditeContainer.setVisibility(View.VISIBLE);
            cholder.llShowInfoContainer.setVisibility(View.INVISIBLE);

            cholder.iv_increase = (TextView) convertView.findViewById(R.id.tv_add);
            cholder.iv_decrease = (TextView) convertView.findViewById(R.id.tv_reduce);
            cholder.tv_count = (TextView) convertView.findViewById(R.id.tv_num);
            cholder.iv_delete = (ImageView) convertView.findViewById(R.id.cart_product_rl_iv_delete);
            cholder.tv_rl_guige = (TextView) convertView.findViewById(R.id.cart_product_rl_guige);
        } else {
            cholder.rlEditeContainer.setVisibility(View.INVISIBLE);
            cholder.llShowInfoContainer.setVisibility(View.VISIBLE);

            cholder.tv_product_name = (TextView) convertView.findViewById(R.id.cart_product_shop_name);
            cholder.cart_tv_top_guige = (TextView) convertView.findViewById(R.id.car_tv_guige);
            cholder.cart_tv_top_count = (TextView) convertView.findViewById(R.id.cart_tv_top_count);
            cholder.tv_top_money = (TextView) convertView.findViewById(R.id.car_money_icon);
        }
        if (product != null) {


            String goodsImageUrl = product.getGoodsImageUrl();
            if (!TextUtils.isEmpty(goodsImageUrl)) {
                cholder.cart_product_iv.setImageURI(Uri.parse(goodsImageUrl));
            }
            cholder.cb_check.setChecked(product.isChoosed());
            cholder.cb_check.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    product.setChoosed(((CheckBox) v).isChecked());
                    cholder.cb_check.setChecked(((CheckBox) v).isChecked());
                    checkInterface.checkChild(groupPosition, childPosition, ((CheckBox) v).isChecked());// 暴露子选接口
                }
            });
            if (groupData.isEdite()) {
                cholder.tv_rl_guige.setText(TextUtils.isEmpty(product.getStockName())?"":product.getStockName());
                cholder.tv_count.setText(String.valueOf(product.getNumber()));

                cholder.iv_increase.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        modifyCountInterface.doIncrease(groupPosition, childPosition, cholder.tv_count, cholder.cb_check.isChecked());// 暴露增加接口
                    }
                });
                cholder.iv_decrease.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        modifyCountInterface.doDecrease(groupPosition, childPosition, cholder.tv_count, cholder.cb_check.isChecked());// 暴露删减接口
                    }
                });
                cholder.iv_delete.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        deleteInterface.deleteChilder(groupPosition,childPosition);
                    }
                });
            } else {
                cholder.tv_product_name.setText(product.getGoodsName());
                cholder.cart_tv_top_guige.setText(product.getStockName());
                cholder.cart_tv_top_count.setText(String.valueOf(product.getNumber()));
                cholder.tv_top_money.setText("￥" + product.getGoodsPrice());
            }

        }
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }

    /**
     * 组元素绑定器
     */
    private class GroupHolder {
        CheckBox cb_check;
        TextView tv_group_name;
        TextView tv_group_mj;
        TextView tv_group_by;
        TextView tv_group_edite;
    }

    /**
     * 子元素绑定器
     */
    private class ChildHolder {
        CheckBox cb_check;

        //图片
        SimpleDraweeView cart_product_iv;

        //展示信息容器
        LinearLayout llShowInfoContainer;

        //商品名称
        TextView tv_product_name;

        //商品数量
        TextView cart_tv_top_count;

        //商品规格
        TextView cart_tv_top_guige;

        //商品单价
        TextView tv_top_money;


        //编辑界面容器
        RelativeLayout rlEditeContainer;

        //规格
        TextView tv_rl_guige;


        TextView tv_price;

        //添加
        TextView iv_increase;

        //数量
        TextView tv_count;

        //递减
        TextView iv_decrease;

        //删除
        ImageView iv_delete;


    }


    /**
     * 编辑接口
     */
    public interface EditeInterface {
        /**
         * 组编辑状态改变触发的事件
         *
         * @param groupPosition 组元素位置
         * @param isEdite     组元素是否编辑
         */
        void editeGroup(int groupPosition, boolean isEdite);

        /**
         * 子编辑状态改变时触发的事件
         *
         * @param groupPosition 组元素位置
         * @param childPosition 子元素位置
         * @param isEdite     子元素是否编辑
         */
        void editeChilder(int groupPosition, int childPosition, boolean isEdite);
    }


    /**
     * 删除接口
     */
    public interface DeleteInterface {

        /**
         * 子编辑状态改变时触发的事件
         *
         * @param groupPosition 组元素位置
         * @param childPosition 子元素位置
         */
        void deleteChilder(int groupPosition, int childPosition);
    }
    /**
     * 复选框接口
     */
    public interface CheckInterface {
        /**
         * 组选框状态改变触发的事件
         *
         * @param groupPosition 组元素位置
         * @param isChecked     组元素选中与否
         */
        public void checkGroup(int groupPosition, boolean isChecked);

        /**
         * 子选框状态改变时触发的事件
         *
         * @param groupPosition 组元素位置
         * @param childPosition 子元素位置
         * @param isChecked     子元素选中与否
         */
        public void checkChild(int groupPosition, int childPosition, boolean isChecked);
    }

    /**
     * 改变数量的接口
     */
    public interface ModifyCountInterface {
        /**
         * 增加操作
         *
         * @param groupPosition 组元素位置
         * @param childPosition 子元素位置
         * @param showCountView 用于展示变化后数量的View
         * @param isChecked     子元素选中与否
         */
        public void doIncrease(int groupPosition, int childPosition, View showCountView, boolean isChecked);

        /**
         * 删减操作
         *
         * @param groupPosition 组元素位置
         * @param childPosition 子元素位置
         * @param showCountView 用于展示变化后数量的View
         * @param isChecked     子元素选中与否
         */
        public void doDecrease(int groupPosition, int childPosition, View showCountView, boolean isChecked);
    }

}
