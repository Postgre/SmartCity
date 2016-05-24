package com.smartcity.activity.chw.service;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.smartcity.R;
import com.smartcity.adapter.chw.service.HotServiceAdapter;
import com.smartcity.adapter.chw.service.ServiceFenNeiAdapter;
import com.smartcity.application.MyApplication;
import com.smartcity.config.Constant;
import com.smartcity.http.model.ServiceRecommendBean;
import com.smartcity.http.service.CallService;
import com.smartcity.utils.SharedPreferencesUtil;
import com.smartcity.utils.ToastTool;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by chenyuan on 2016/5/19.
 */
public class ServiceFirstPageActivity extends Activity {
    List<String> titles, titles3;
    GridView gridView;
    private ListView lv, lv_need;
    private View header, footer;
    private LinearLayout ll_fennei;
    private LinearLayout ll_wecan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_firstpage);
        initView();
        initData();
    }

    private void initView() {
        header = View.inflate(this, R.layout.header_listview_hot_service, null);
        footer = View.inflate(this, R.layout.footer_listview_hot_service, null);
        lv_need = (ListView) footer.findViewById(R.id.lv_need);
        ll_fennei = (LinearLayout) header.findViewById(R.id.ll_fennei);
        LinearLayout ll_fabu = (LinearLayout) header.findViewById(R.id.ll_fabu);
        ll_wecan = (LinearLayout) header.findViewById(R.id.ll_wecan);
        LinearLayout ll_weneed = (LinearLayout) header.findViewById(R.id.ll_weneed);
        EditText et_searchservice = (EditText) header.findViewById(R.id.et_searchservice);
        ImageView iv_more = (ImageView) header.findViewById(R.id.iv_more);

        gridView = (GridView) header.findViewById(R.id.gribview);
        lv = (ListView) findViewById(R.id.lv);
        ininListener();

    }

    private void ininListener() {
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //进入我能的个人详情
                Intent intent = new Intent(ServiceFirstPageActivity.this, WecanDetialActivity.class);
                startActivity(intent);
            }
        });
        lv_need.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //进入我要的个人详情
            }
        });
        ll_wecan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ServiceFirstPageActivity.this, WecanDetialActivity.class);
                startActivity(intent);
            }
        });

    }


    private void initData() {
        //获取接口数据的方法
        //getMyCircle();
        titles = new ArrayList<>();
        titles3 = new ArrayList<>();
        titles.add("租房");
        titles.add("教育");
        titles.add("招聘");
        titles3.add("租房");
        titles3.add("教育");
        titles3.add("招聘");
        titles.add("美妆");
        titles.add("健康");
        titles.add("商务");
        titles.add("维修");
        titles.add("专家团");

        ServiceFenNeiAdapter neiAdapter = new ServiceFenNeiAdapter(titles, this);
        gridView.setAdapter(neiAdapter);

        HotServiceAdapter serviceAdapter = new HotServiceAdapter(titles3, this);
        lv_need.setAdapter(serviceAdapter);
        lv.addHeaderView(header);
        lv.addFooterView(footer);
        lv.setAdapter(serviceAdapter);

    }

    public void getMyCircle() {
        SharedPreferencesUtil spUtils = MyApplication.getSpUtils();
        String apikey = spUtils.getString(Constant.API_KEY, "");
        String personUserId = spUtils.getString(Constant.ID, "");
      /*  LogTool.e("lists", apikey + "apikey" + personUserId + "personUserId");*/
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Constant.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        CallService service = retrofit.create(CallService.class);
        /*Map<String, Object> pam = new HashMap<>();*/
       /* pam.put("personUserId", "61");
        pam.put("sStartpage", "1");
        pam.put("sPagerows", "10");*/
        service.getServiceRecommend(apikey, Constant.VALUE_VERSION).enqueue(new Callback<ServiceRecommendBean>() {

            @Override
            public void onResponse(Call<ServiceRecommendBean> call, Response<ServiceRecommendBean> response) {

            }

            @Override
            public void onFailure(Call<ServiceRecommendBean> call, Throwable t) {

            }

            public void onResponse(Response<ServiceRecommendBean> response, Retrofit retrofit) {

//                Log.e("getMyCircle", "response.body():" + response.body().getCode());
//                LogTool.e("lists",response.body().getCode()+"code");
                ServiceRecommendBean circleBean = response.body();
                circleBean.toString();
             /*   if (null != circleBean) {
                    if (circleBean.getCode() == Constant.STATUS_SUCCESS) {
                        ServiceRecommendBean.DataBean circleLists = circleBean.getData();
                        adaper = new CircleGalleryAdapter(getActivity(), circleLists,R.layout.card_new);
                        viewpager.setAdapter(adaper);
                    } else {
                        CommonUtils.launchActivity(ServiceFirstPageActivity.this, LoginActivity.class);
                    }
                }*/
            }


            public void onFailure(Throwable t) {
                ToastTool.showShort(ServiceFirstPageActivity.this, "获取接口失败");
            }
        });
    }

}



