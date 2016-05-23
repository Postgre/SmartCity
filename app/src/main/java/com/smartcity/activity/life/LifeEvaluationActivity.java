package com.smartcity.activity.life;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.smartcity.R;
import com.smartcity.utils.ToastTool;
import com.zhy.base.adapter.ViewHolder;
import com.zhy.base.adapter.recyclerview.CommonAdapter;

import java.util.ArrayList;

import butterknife.Bind;
import me.nereo.multi_image_selector.MultiImageSelectorActivity;


/**
 * Created by Yancy on 2016/5/13.
 */
public class LifeEvaluationActivity extends LifeBaseActivity {

    private static final int REQUEST_CODE = 5;
    private ArrayList<String> datas;

   @Bind(R.id.lisfe_eval_chose_photo)
    RecyclerView recyclerView;
    private int maxNum =4;
    private ChosePhotoAdapter adapter;

    @Override
    protected void initViews() {

        frameRightContainer.setVisibility(View.GONE);

        initChosePhoto();
    }

    private void initChosePhoto() {
        adapter = new ChosePhotoAdapter();
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected String getName() {
        return "评价";
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
        return R.layout.activity_life_evaluation;
    }

    private class ChosePhotoAdapter extends RecyclerView.Adapter<ChosePhotoViewHodler>
    {

        @Override
        public ChosePhotoViewHodler onCreateViewHolder(ViewGroup parent, int viewType) {
           View view =  LayoutInflater.from(LifeEvaluationActivity.this).inflate(R.layout.life_eval_item,null);
            return new ChosePhotoViewHodler(view);
        }

        @Override
        public void onBindViewHolder(ChosePhotoViewHodler holder,final int position) {
            if(null == datas || position == datas.size())
            {
                if(position<maxNum)
                {
                    holder.iv.setImageResource(R.mipmap.icon_shangchuang);
                }
            }
            else
            {
                if(position <=datas.size()-1)
                {
                    holder.iv.setImageURI(Uri.parse(datas.get(position)));
                }

            }
            holder.iv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(maxNum <=position)
                    {
                        ToastTool.showShort(LifeEvaluationActivity.this, "最多只能选择8张!");
                    }
                    else
                    {
                        if(null == datas || position == datas.size())
                        {
                            //选择图片
                            Intent intent = new Intent(LifeEvaluationActivity.this, MultiImageSelectorActivity.class);
                            // 是否显示拍摄图片
                            intent.putExtra(MultiImageSelectorActivity.EXTRA_SHOW_CAMERA, true);
                            // 最大可选择图片数量
                            intent.putExtra(MultiImageSelectorActivity.EXTRA_SELECT_COUNT, maxNum);
                            // 选择模式
                            intent.putExtra(MultiImageSelectorActivity.EXTRA_SELECT_MODE, MultiImageSelectorActivity.MODE_MULTI);
                            // 默认选择
                            if(datas != null && datas.size()>0){
                                intent.putExtra(MultiImageSelectorActivity.EXTRA_DEFAULT_SELECTED_LIST, datas);
                            }
                             LifeEvaluationActivity.this.startActivityForResult(intent, REQUEST_CODE);

                            }

                        }
                }
            });

        }

        @Override
        public int getItemCount() {
            return null == datas?1:datas.size()+1;
        }
    }

    private class ChosePhotoViewHodler extends RecyclerView.ViewHolder
    {
        public ImageView iv;
        public ImageView  delIV;
        public ChosePhotoViewHodler(View itemView) {
            super(itemView);
            iv = (ImageView) itemView.findViewById(R.id.life_eval_item_iv);
            delIV = (ImageView) itemView.findViewById(R.id.life_eval_item_del_iv);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == REQUEST_CODE){
            if(resultCode == Activity.RESULT_OK){
                datas = data.getStringArrayListExtra(MultiImageSelectorActivity.EXTRA_RESULT);
                adapter.notifyDataSetChanged();
            }
        }
    }
}
