package com.smartcity.activity.circle;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.smartcity.R;
import com.smartcity.base.BaseActivity;
import com.smartcity.http.HttpApi;
import com.smartcity.http.model.CircleBean;
import com.smartcity.http.service.CircleService;
import com.smartcity.presenter.SearchPresenter;
import com.smartcity.presenterImpl.SearchPresenterImpl;
import com.smartcity.utils.GsonUtils;
import com.smartcity.view.ISearchView;
import com.zhy.base.adapter.ViewHolder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016/5/11.
 */
public class SearchActivity extends BaseActivity implements ISearchView {
    @Bind(R.id.tv_back)
    TextView tvBack;
    @Bind(R.id.edittext_search)
    EditText edittextSearch;
    @Bind(R.id.serach_recyclerview)
    ListView searchRecyclerview;
    private SearchPresenter presenter;

    private List<String> list = new ArrayList<>();

    @Override
    public void init() {
        presenter = new SearchPresenterImpl(this);
        getLocalDataHistory();
        initSearchView();
        initRecy();

    }


    private void getLocalDataHistory() {
        // 获取搜索记录文件内容
        SharedPreferences sp = getSharedPreferences("search_history", 0);
        String history = sp.getString("history", "");

        // 用逗号分割内容返回数组
        String[] history_arr = history.split(",");
        list = Arrays.asList(history_arr);

    }

    private void initSearchView() {
        edittextSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                     /*隐藏软键盘*/
                    InputMethodManager imm = (InputMethodManager) v
                            .getContext().getSystemService(
                                    Context.INPUT_METHOD_SERVICE);
                    if (imm.isActive()) {
                        imm.hideSoftInputFromWindow(
                                v.getApplicationWindowToken(), 0);
                    }

//                    Toast.makeText(SearchActivity.this, "go", Toast.LENGTH_SHORT).show();
                    search(edittextSearch.getText().toString());
                    save();
                }
                return true;
            }


        });
    }

    //搜索
    private void search(String s) {
        presenter.getSearchData(s, "1", "2");
    }

    private void initRecy() {
        LayoutInflater inflater = LayoutInflater.from(this);
        View headerView = inflater.inflate(R.layout.search_header, null);
        searchRecyclerview.addHeaderView(headerView);
        searchRecyclerview.setAdapter(new com.zhy.base.adapter.abslistview.CommonAdapter<String>(this, R.layout.search_item, list) {
            @Override
            public void convert(ViewHolder viewHolder, String s) {
                viewHolder.setText(R.id.sr_name, s);
            }
        });
    }


    @Override
    public int getLayoutId() {
        return R.layout.activity_search;
    }


    @OnClick({R.id.tv_back, R.id.iv})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_back:
                finish();
                break;
        }
    }

    public void save() {
        // 获取搜索框信息
        String text = edittextSearch.getText().toString();
        SharedPreferences mysp = getSharedPreferences("search_history", 0);
        String old_text = mysp.getString("history", "");

        // 利用StringBuilder.append新增内容，逗号便于读取内容时用逗号拆分开
        StringBuilder builder = new StringBuilder(old_text);
        builder.append(text + ",");

        // 判断搜索内容是否已经存在于历史文件，已存在则不重复添加
        if (!old_text.contains(text + ",")) {
            SharedPreferences.Editor myeditor = mysp.edit();
            myeditor.putString("history", builder.toString());
            myeditor.commit();
//            Toast.makeText(this, text + "添加成功", Toast.LENGTH_SHORT).show();
        } else {
//            Toast.makeText(this, text + "已存在", Toast.LENGTH_SHORT).show();
        }

    }


    @Override
    public void addList(List<CircleBean.CirDataEntity> list) {

    }
}
