package com.smartcity.activity;

import android.content.Context;
import android.os.AsyncTask;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;

import com.smartcity.R;
import com.smartcity.adapter.CityAdapter;
import com.smartcity.base.BaseActivity;
import com.smartcity.base.CityItem;
import com.smartcity.dao.CityData;
import com.smartcity.utils.ToastTool;
import com.smartcity.view.cittlist.ChoseAreaFragment;
import com.smartcity.view.cittlist.ContactItemInterface;
import com.smartcity.view.cittlist.ContactListViewImpl;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by Yancy on 2016/5/9.
 */
public class SelectCityActivity extends BaseActivity implements TextWatcher {


    private static final String TAG = "fragment";
    List<ContactItemInterface> contactList;
    List<ContactItemInterface> filterList;

    @Bind(R.id.select_city_lv)
    ContactListViewImpl listview ;

    @Bind(R.id.input_search_query)
    EditText etSeacher;


    private ChoseAreaFragment fragment;

    @Override
    public void init() {
        initHead();

        fragment = new ChoseAreaFragment();
    }

    private String searchString;
    private Context context_ = SelectCityActivity.this;
    private Object searchLock = new Object();
    boolean inSearchMode = false;

    private void initHead() {

        filterList = new ArrayList<>();
        contactList = CityData.getSampleContactList();

        CityAdapter adapter = new CityAdapter(this,R.layout.city_item, contactList);
        View view = LayoutInflater.from(this).inflate(R.layout.select_city_head,null);

        listview.addHeaderView(view);
        etSeacher.addTextChangedListener(this);

        listview.setFastScrollEnabled(true);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                List<ContactItemInterface> searchList = inSearchMode ? filterList: contactList;

                if(position >0)
                {
                    ToastTool.showShort(SelectCityActivity.this, searchList.get(position-1).getDisplayInfo());
                }

            }
        });

    }
    private SearchListTask curSearchTask = null;
    @Override
    public int getLayoutId() {
        return R.layout.activity_select_city;
    }
    @Override
    public void afterTextChanged(Editable s)
    {
        searchString = etSeacher.getText().toString().trim().toUpperCase();

        if (curSearchTask != null
                && curSearchTask.getStatus() != AsyncTask.Status.FINISHED)
        {
            try
            {
                curSearchTask.cancel(true);
            } catch (Exception e)
            {

            }

        }
        curSearchTask = new SearchListTask();
        curSearchTask.execute(searchString);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count,
                                  int after)
    {
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count)
    {
        // do nothing
    }



    private class SearchListTask extends AsyncTask<String, Void, String>
    {

        @Override
        protected String doInBackground(String... params)
        {
            filterList.clear();

            String keyword = params[0];

            inSearchMode = (keyword.length() > 0);

            if (inSearchMode)
            {
                // get all the items matching this
                for (ContactItemInterface item : contactList)
                {
                    CityItem contact = (CityItem) item;

                    boolean isPinyin = contact.getFullName().toUpperCase()
                            .indexOf(keyword) > -1;
                    boolean isChinese = contact.getNickName().indexOf(keyword) > -1;

                    if (isPinyin || isChinese)
                    {
                        filterList.add(item);
                    }

                }

            }
            return null;
        }

        protected void onPostExecute(String result)
        {

            synchronized (searchLock)
            {

                if (inSearchMode)
                {

                    CityAdapter adapter = new CityAdapter(context_,
                            R.layout.city_item, filterList);
                    adapter.setInSearchMode(true);
                    listview.setInSearchMode(true);
                    listview.setAdapter(adapter);
                } else
                {
                    CityAdapter adapter = new CityAdapter(context_,
                            R.layout.city_item, contactList);
                    adapter.setInSearchMode(false);
                    listview.setInSearchMode(false);
                    listview.setAdapter(adapter);
                }
            }

        }
    }

    @OnClick(R.id.select_city_tv_shode_area)
    public void showArea()
    {
        //选择地区
        fragment.show(getSupportFragmentManager(),TAG);
    }

    @OnClick(R.id.select_city_iv_cance)
    public void back()
    {
        finish();
    }
}
