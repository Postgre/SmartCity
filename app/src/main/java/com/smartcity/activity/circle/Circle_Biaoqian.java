package com.smartcity.activity.circle;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.smartcity.R;
import com.smartcity.base.BaseActivity;
import com.smartcity.utils.ImageUtils;
import com.smartcity.utils.LocalImageHelper;
import com.smartcity.utils.LogTool;
import com.smartcity.utils.ToastTool;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016/5/13.
 */
public class Circle_Biaoqian extends BaseActivity {
    @Bind(R.id.back_img)
    ImageView back;
    @Bind(R.id.right_text)
    TextView tijiao;
    @Bind(R.id.id_flowlayout)
    TagFlowLayout mFlowLayout;
//    public static Set<Integer> list;
    public static List<String> list;
    String[] mVals = {"品牌圈", "汽车世界", "美丽计划", "我爱运动", "母婴同盟", "健康养生", "微胖界", "摄影圈", "戏曲"
            , "户外资源", "时尚生活", "萌宠", "美妆", "教育培训", "吃喝玩乐", "公益活动", "比赛汇演", "户外旅游", "美容美体", "数码科技",};

    @Override
    public void init() {
        tijiao.setVisibility(View.VISIBLE);
        tijiao.setText("提交");
        mFlowLayout.setAdapter(new TagAdapter<String>(mVals) {
            @Override
            public View getView(FlowLayout parent, int position, String s) {
                TextView tv = (TextView) LayoutInflater.from(Circle_Biaoqian.this).inflate(R.layout.circle_biaoqian_item,
                        mFlowLayout, false);
                tv.setText(s);
                return tv;
            }
        });
        mFlowLayout.setOnTagClickListener(new TagFlowLayout.OnTagClickListener() {
            @Override
            public boolean onTagClick(View view, int position, FlowLayout parent) {
                Toast.makeText(Circle_Biaoqian.this, mVals[position], Toast.LENGTH_SHORT).show();
                return true;
            }
        });
        mFlowLayout.setOnSelectListener(new TagFlowLayout.OnSelectListener() {
            @Override
            public void onSelected(Set<Integer> selectPosSet) {
                Circle_Biaoqian.this.setTitle("choose:" + selectPosSet.toString());
//                list.add(selectPosSet.toString());
            }
        });
//        //预先设置选中
//        mAdapter.setSelectedList(1,3,5,7,8,9);
//获得所有选中的pos集合
//        list = mFlowLayout.getSelectedList();
    }
    Set<Integer>  set;
    @OnClick({R.id.back_img,R.id.right_text})
    public void onclick(View v){
        switch (v.getId()){
            case R.id.back_img:
                finish();
                break;
            case R.id.right_text:
                list = new ArrayList<>();
                set = mFlowLayout.getSelectedList();
                for (Integer integer : set) {
//                    ToastTool.showShort(this,String.valueOf(integer));
                    list.add(mVals[integer]);
                }
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
//                bundle.putSerializable("list",list);
                intent.putStringArrayListExtra("list",(ArrayList)list);
                setResult(1001,intent);
                finish();
//                intent.putExtra("list", (Set<Integer>)mFlowLayout.getSelectedList());
//                startActivityForResult(intent,
//                        Circle_CreateActivity.ADD_CIRCLECODE);
                break;
        }
    }
    @Override
    public int getLayoutId() {
        return R.layout.circle_biaoqian;
    }
}
