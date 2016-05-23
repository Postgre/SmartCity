package com.smartcity.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.smartcity.R;

public class Store_PopupWindow extends Activity implements OnClickListener{  
  
    private LinearLayout qq,wx,wxpy,xl,qz;
    private LinearLayout layout;  
    private TextView qx;
      
    @Override  
    protected void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.share_popview);
        inview();
        layout=(LinearLayout)findViewById(R.id.pop_layout);
          
        //添加选择窗口范围监听可以优先获取触点，即不再执行onTouchEvent()函数，点击其他地方时执行onTouchEvent()函数销毁Activity  
        layout.setOnClickListener(new OnClickListener() {  
              
            public void onClick(View v) {  
                // TODO Auto-generated method stub  
                Toast.makeText(getApplicationContext(), "提示：点击窗口外部关闭窗口！",   
                        Toast.LENGTH_SHORT).show();   
            }  
        });  
    }  
    public void inview(){
    	qq = (LinearLayout) findViewById(R.id.store_popup_qq);
    	wx = (LinearLayout) findViewById(R.id.store_popup_wx);
    	wxpy = (LinearLayout) findViewById(R.id.store_popup_wxpy);
    	xl = (LinearLayout) findViewById(R.id.store_popup_xl);
    	qz = (LinearLayout) findViewById(R.id.store_popup_qz);
    	qx = (TextView) findViewById(R.id.store_popup_qx);
    	qq.setOnClickListener(this);
    	wx.setOnClickListener(this);
    	wxpy.setOnClickListener(this);
    	xl.setOnClickListener(this);
    	qz.setOnClickListener(this);
    	qx.setOnClickListener(this);
    }
      
    //实现onTouchEvent触屏函数但点击屏幕时销毁本Activity  
    @Override  
    public boolean onTouchEvent(MotionEvent event){  
        finish();  
        return true;  
    }  
  
    public void onClick(View v) {  
        switch (v.getId()) {  
        case R.id.store_popup_qq:
        	Toast.makeText(getApplicationContext(), "qq",   
                    Toast.LENGTH_SHORT).show();  
            break;  
        case R.id.store_popup_wx:
        	Toast.makeText(getApplicationContext(), "wx",   
                    Toast.LENGTH_SHORT).show();  
            break;  
        case R.id.store_popup_wxpy:
        	Toast.makeText(getApplicationContext(), "wxpy",   
                    Toast.LENGTH_SHORT).show();  
            break;  
        case R.id.store_popup_xl:
        	Toast.makeText(getApplicationContext(), "xl",   
                    Toast.LENGTH_SHORT).show();  
            break;  
        case R.id.store_popup_qz:
        	Toast.makeText(getApplicationContext(), "qz",   
                    Toast.LENGTH_SHORT).show();  
            break;  
        case R.id.store_popup_qx:
        	Toast.makeText(getApplicationContext(), "qx",   
                    Toast.LENGTH_SHORT).show();  
            break;  
        default:  
            break;  
        }   
    }  
      
}  