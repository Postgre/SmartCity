package com.smartcity.activity.circle;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.SimpleBitmapDisplayer;
import com.nostra13.universalimageloader.core.imageaware.ImageViewAware;
import com.smartcity.R;
import com.smartcity.activity.LocalAlbum;
import com.smartcity.adapter.circle.Circle_CodeAdapter;
import com.smartcity.adapter.circle.Circle_CreateAdapter;
import com.smartcity.base.BaseActivity;
import com.smartcity.config.Constant;
import com.smartcity.customview.AlbumViewPager;
import com.smartcity.customview.FilterImageView;
import com.smartcity.customview.MatrixImageView;
import com.smartcity.customview.MyGridView;
import com.smartcity.utils.CommonAdapter;
import com.smartcity.utils.CommonUtils;
import com.smartcity.utils.GsonUtils;
import com.smartcity.utils.ImageUtils;
import com.smartcity.utils.LocalImageHelper;
import com.smartcity.utils.LogTool;
import com.smartcity.utils.StringUtils;
import com.zhy.base.adapter.ViewHolder;
import com.zhy.base.adapter.recyclerview.OnItemClickListener;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import butterknife.Bind;


/**
 * @author linjizong
 * @Description:发布动态界面
 * @date 2015-5-14
 */
public class Circle_CreateActivity extends BaseActivity implements OnClickListener, MatrixImageView.OnSingleTapListener {
    public static final int ADD_CIRCLECODE = 100;
    private ImageView mBack;//返回键
    @Bind(R.id.title_tv)
    TextView title_tv;
    private TextView mSend;//发送
    @Bind(R.id.grid)
    MyGridView grid;
    @Bind(R.id.biaoqian)
    ImageView biaoqian;
    @Bind(R.id.biaoqian_list)
    RecyclerView biaoqian_list;
    private EditText mContent;//动态内容编辑框
    private InputMethodManager imm;//软键盘管理
    private TextView textRemain;//字数提示
    private TextView picRemain;//图片数量提示
    private ImageView add;//添加图片按钮
    private LinearLayout picContainer;//图片容器
    private List<LocalImageHelper.LocalFile> pictures = new ArrayList<>();//图片路径数组
    private Circle_CreateAdapter adapter;
    HorizontalScrollView scrollView;//滚动的图片容器
    View editContainer;//动态编辑部分
    View pagerContainer;//图片显示部分

    //显示大图的viewpager 集成到了Actvity中 下面是和viewpager相关的控件
    AlbumViewPager viewpager;//大图显示pager
    ImageView mBackView;//返回/关闭大图
    TextView mCountView;//大图数量提示
    View mHeaderBar;//大图顶部栏
    ImageView delete;//删除按钮

    int size;//小图大小
    int padding;//小图间距
    DisplayImageOptions options;
    List<Map<Object, Object>> list;
    List<String> stringlist;
    Circle_CodeAdapter codeAdapter;
    List<LocalImageHelper.LocalFile> files;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.post_dynamic);
        imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        //设置ImageLoader参数
        options = new DisplayImageOptions.Builder()
                .cacheInMemory(true)
                .cacheOnDisk(false)
                .showImageForEmptyUri(R.mipmap.df)
                .showImageOnFail(R.mipmap.df)
                .showImageOnLoading(R.mipmap.df)
                .bitmapConfig(Bitmap.Config.RGB_565)
                .displayer(new SimpleBitmapDisplayer()).build();
        initViews();
        initData();
    }

    @Override
    public void init() {

    }
//    public List<Map<Object, Integer>> getList() {
//        return list;
//    }
    @Override
    public int getLayoutId() {
        return R.layout.circle_create;
    }

    /**
     * @Description： 初始化Views
     */
    private void initViews() {
        // TODO Auto-generated method stub
        title_tv.setText("创建圈子");
        mBack = (ImageView) findViewById(R.id.back_img);
        mSend = (TextView) findViewById(R.id.right_text);
        mSend.setText("提交");
        mSend.setVisibility(View.VISIBLE);
        mContent = (EditText) findViewById(R.id.post_content);
        textRemain = (TextView) findViewById(R.id.post_text_remain);
        picRemain = (TextView) findViewById(R.id.post_pic_remain);
        add = (ImageView) findViewById(R.id.post_add_pic);
        picContainer = (LinearLayout) findViewById(R.id.post_pic_container);
        scrollView = (HorizontalScrollView) findViewById(R.id.post_scrollview);
        viewpager = (AlbumViewPager) findViewById(R.id.albumviewpager);
        mBackView = (ImageView) findViewById(R.id.header_bar_photo_back);
        mCountView = (TextView) findViewById(R.id.header_bar_photo_count);
        mHeaderBar = findViewById(R.id.album_item_header_bar);
        delete = (ImageView) findViewById(R.id.header_bar_photo_delete);
        editContainer = findViewById(R.id.post_edit_container);
        pagerContainer = findViewById(R.id.pagerview);
        delete.setVisibility(View.VISIBLE);

        viewpager.setOnPageChangeListener(pageChangeListener);
        viewpager.setOnSingleTapListener(this);
        biaoqian.setOnClickListener(this);
        mBackView.setOnClickListener(this);
        mCountView.setOnClickListener(this);
        mBack.setOnClickListener(this);
        mSend.setOnClickListener(this);
        add.setOnClickListener(this);
        delete.setOnClickListener(this);

        biaoqian_list.setAdapter(new com.zhy.base.adapter.recyclerview.CommonAdapter(this,R.layout.circle_biaoqian,Circle_Biaoqian.list) {
            @Override
            public void convert(ViewHolder viewHolder, Object o) {

            }
        });

        mContent.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
                // TODO Auto-generated method stub

            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                                          int arg3) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable content) {
                textRemain.setText(content.toString().length() + "/140");
            }
        });
        sss();
    }

    private void initData() {
        size = (int) getResources().getDimension(R.dimen.dp_100);
        padding = (int) getResources().getDimension(R.dimen.dp_10);
    }

    @Override
    public void onBackPressed() {
        if (pagerContainer.getVisibility() != View.VISIBLE) {
//        showSaveDialog();
            finish();
    }
    else {
        hideViewPager();
    }
}




    @Override
    public void onClick(View view) {
        // TODO Auto-generated method stub
        switch (view.getId()) {
            case R.id.back_img:
                finish();
               // showSaveDialog();
                break;
            case R.id.biaoqian:
//                CommonUtils.launchActivity(this,Circle_Biaoqian.class);
                Intent intent = new Intent(Circle_CreateActivity.this, Circle_Biaoqian.class);
                startActivityForResult(intent, 1000);
                break;
            case R.id.header_bar_photo_back:
            case R.id.header_bar_photo_count:
                hideViewPager();
                break;
            case R.id.header_bar_photo_delete:
                final int index = viewpager.getCurrentItem();
                new AlertDialog.Builder(this)
                        .setTitle("提示")
                        .setMessage("要删除这张照片吗?")
                        .setPositiveButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .setNegativeButton("是", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                pictures.remove(index);
                                if (pictures.size() == 9) {
                                    add.setVisibility(View.GONE);
                                } else {
                                    add.setVisibility(View.VISIBLE);
                                }
                                if (pictures.size() == 0) {
                                    hideViewPager();
                                }
                                picContainer.removeView(picContainer.getChildAt(index));
                                picRemain.setText(pictures.size() + "/9");
                                mCountView.setText((viewpager.getCurrentItem() + 1) + "/" + pictures.size());
                                adapter.notifyDataSetChanged();
                                sss();
                                viewpager.getAdapter().notifyDataSetChanged();
                                LocalImageHelper.getInstance().setCurrentSize(pictures.size());
                            }
                        })
                        .show();
                break;
            case R.id.right_text:
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
                String content = mContent.getText().toString();
                if (StringUtils.isEmpty(content) && pictures.isEmpty()) {
                    Toast.makeText(this, "请添写动态内容或至少添加一张图片", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    //设置为不可点击，防止重复提交
                    view.setEnabled(false);
                }
                break;
            case R.id.post_add_pic:
                intent = new Intent(Circle_CreateActivity.this, LocalAlbum.class);
                startActivityForResult(intent, ImageUtils.REQUEST_CODE_GETIMAGE_BYCROP);
                break;
            default:
                if (view instanceof FilterImageView) {
                    for (int i = 0; i < picContainer.getChildCount(); i++) {
                        if (view == picContainer.getChildAt(i)) {
                            showViewPager(i);
                        }
                    }
                }
                break;
        }
    }





    private OnPageChangeListener pageChangeListener = new OnPageChangeListener() {

        @Override
        public void onPageSelected(int position) {
            if (viewpager.getAdapter() != null) {
                String text = (position + 1) + "/" + viewpager.getAdapter().getCount();
                mCountView.setText(text);
            } else {
                mCountView.setText("0/0");
            }
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {
            // TODO Auto-generated method stub

        }

        @Override
        public void onPageScrollStateChanged(int arg0) {
            // TODO Auto-generated method stub

        }
    };

    //显示大图pager
    private void showViewPager(int index) {
        pagerContainer.setVisibility(View.VISIBLE);
        editContainer.setVisibility(View.GONE);
        viewpager.setAdapter(viewpager.new LocalViewPagerAdapter(pictures));
        viewpager.setCurrentItem(index);
        mCountView.setText((index + 1) + "/" + pictures.size());
        AnimationSet set = new AnimationSet(true);
        ScaleAnimation scaleAnimation = new ScaleAnimation((float) 0.9, 1, (float) 0.9, 1, pagerContainer.getWidth() / 2, pagerContainer.getHeight() / 2);
        scaleAnimation.setDuration(200);
        set.addAnimation(scaleAnimation);
        AlphaAnimation alphaAnimation = new AlphaAnimation((float) 0.1, 1);
        alphaAnimation.setDuration(200);
        set.addAnimation(alphaAnimation);
        pagerContainer.startAnimation(set);
    }

    //关闭大图显示
    private void hideViewPager() {
        pagerContainer.setVisibility(View.GONE);
        editContainer.setVisibility(View.VISIBLE);
        AnimationSet set = new AnimationSet(true);
        ScaleAnimation scaleAnimation = new ScaleAnimation(1, (float) 0.9, 1, (float) 0.9, pagerContainer.getWidth() / 2, pagerContainer.getHeight() / 2);
        scaleAnimation.setDuration(200);
        set.addAnimation(scaleAnimation);
        AlphaAnimation alphaAnimation = new AlphaAnimation(1, 0);
        alphaAnimation.setDuration(200);
        set.addAnimation(alphaAnimation);
        pagerContainer.startAnimation(set);
    }

    @Override
    public void onSingleTap() {
        hideViewPager();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 1000 && resultCode == 1001)
        {
            stringlist = data.getStringArrayListExtra("list");
            LogTool.e("ttt",stringlist.toString() + "sssss");
            codeAdapter = new Circle_CodeAdapter(this,R.layout.circle_code_item,stringlist);
            LinearLayoutManager manager = new LinearLayoutManager(this);
            manager.setOrientation(LinearLayoutManager.HORIZONTAL);
            biaoqian_list.setLayoutManager(manager);
            biaoqian_list.setAdapter(codeAdapter);
            codeAdapter.setOnItemClickListener(new OnItemClickListener() {
                @Override
                public void onItemClick(ViewGroup viewGroup, View view, Object o, int i) {
                    stringlist.remove(stringlist.get(i));
                    LogTool.e("ttt",stringlist.toString() + "eeeee");
                    codeAdapter.notifyDataSetChanged();
                }

                @Override
                public boolean onItemLongClick(ViewGroup viewGroup, View view, Object o, int i) {
                    return false;
                }
            });
        }
        switch (requestCode) {
            case ImageUtils.REQUEST_CODE_GETIMAGE_BYCROP:
                if (LocalImageHelper.getInstance().isResultOk()) {
                    LocalImageHelper.getInstance().setResultOk(false);
                    //获取选中的图片
                    files = LocalImageHelper.getInstance().getCheckedItems();
                    for (int i = 0; i < files.size(); i++) {
                        LayoutParams params = new LayoutParams(size, size);
                        params.rightMargin = padding;
                        FilterImageView imageView = new FilterImageView(this);
                        imageView.setLayoutParams(params);
                        imageView.setScaleType(ScaleType.CENTER_CROP);
//                        ImageLoader.getInstance().displayImage(files.get(i).getThumbnailUri(), new ImageViewAware(imageView), options,
//                                null, null, files.get(i).getOrientation());
//                        imageView.setOnClickListener(this);
                        pictures.add(files.get(i));
                        if (pictures.size() == 9) {
                            add.setVisibility(View.GONE);
                        } else {
                            add.setVisibility(View.VISIBLE);
                        }
                        picContainer.addView(imageView, picContainer.getChildCount() - 1);
                        picRemain.setText(pictures.size() + "/9");
                        LocalImageHelper.getInstance().setCurrentSize(pictures.size());
                        sss();
                    }
                    //清空选中的图片
                    files.clear();
                    //设置当前选中的图片数量
                    LocalImageHelper.getInstance().setCurrentSize(pictures.size());
                    //延迟滑动至最右边
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            scrollView.fullScroll(HorizontalScrollView.FOCUS_RIGHT);
                        }
                    }, 50L);
                }
                //清空选中的图片
                LocalImageHelper.getInstance().getCheckedItems().clear();
                break;
            default:
                break;
        }
    }
    public void sss(){
        list = new ArrayList<>();
        Map<Object, Object> map;
        for (int i = 0; i < pictures.size() + 1; i++) {
            map = new HashMap<>();
            if(i == pictures.size()){
                map.put("img", "0");
            }else {
                map.put("img", pictures.get(i).getThumbnailUri());
            }
            list.add(map);
        }
        adapter = new Circle_CreateAdapter(Circle_CreateActivity.this,list,R.layout.image_add);
//        grid.setLayoutManager(new GridLayoutManager(this,4));
        grid.setAdapter(adapter);
        adapter.addClickListenerFromId(R.id.img,R.id.jian);
        adapter.setOnChildItemClickListener(new CommonAdapter.OnChildItemOnClickListener() {
            @Override
            public void OnChildItemOnClick(int position, View v, List<Map<String, Object>> list) {
                switch (v.getId()){
                    case R.id.img:
                        for (int j = 0; j < list.size()-1; j++) {
                            if(position == j)
                                showViewPager(j);
                        }
                        if(position == list.size() -1){
                            Intent intent = new Intent(Circle_CreateActivity.this, LocalAlbum.class);
                            startActivityForResult(intent, ImageUtils.REQUEST_CODE_GETIMAGE_BYCROP);
                        }
                        break;
                    case R.id.jian:
                        pictures.remove(position);
                        if (pictures.size() == 9) {
                            add.setVisibility(View.GONE);
                        } else {
                            add.setVisibility(View.VISIBLE);
                        }
                        if (pictures.size() == 0) {
                            hideViewPager();
                        }
                        picContainer.removeView(picContainer.getChildAt(position));
                        picRemain.setText(pictures.size() + "/9");
                        mCountView.setText((viewpager.getCurrentItem() + 1) + "/" + pictures.size());
                        adapter.notifyDataSetChanged();
                        sss();
//                        viewpager.getAdapter().notifyDataSetChanged();
                        LocalImageHelper.getInstance().setCurrentSize(pictures.size());
                        break;
                }
            }
        });
//        adapter.setOnItemClickListener(new OnItemClickListener() {
//            @Override
//            public void onItemClick(ViewGroup viewGroup, View view, Object o, final int i) {
//                for (int j = 0; j < list.size()-1; j++) {
//                    if(i == j)
//                    showViewPager(j);
//                }
//                if(i == list.size() -1){
//                    Intent intent = new Intent(Circle_CreateActivity.this, LocalAlbum.class);
//                    startActivityForResult(intent, ImageUtils.REQUEST_CODE_GETIMAGE_BYCROP);
//                }
//            }
//
//            @Override
//            public boolean onItemLongClick(ViewGroup viewGroup, View view, Object o, int i) {
//                return false;
//            }
//        });
    }
}
