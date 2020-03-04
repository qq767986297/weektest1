package com.bawei.wangguanhua2020224.custom;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.bawei.wangguanhua2020224.R;

/**
 * Time: 2020/3/4
 * Author: 王冠华
 * Description:
 */
public class CustomViewGroup extends LinearLayout {

    private EditText et;
    private Button bt;

    public CustomViewGroup(Context context) {
        super(context);
        init(context);
    }

    public CustomViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public CustomViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @SuppressLint("NewApi")
    public CustomViewGroup(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
    public void init(Context context ){
        //关联布局
        View view = View.inflate(context, R.layout.customview, null);
        //找控件
        et = view.findViewById(R.id.et);
        bt = view.findViewById(R.id.bt_search);
        //按钮点击事件
        bt.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(miClick!=null){
                    //点击方法调用点击接口
                    miClick.onSearch(et.getText().toString());
                }
            }
        });

    }
    private IClick miClick;
    //点击方法
    public void setOnClick(IClick iClick){
        miClick=iClick;
    }
    //点击接口
    interface IClick{
        void onSearch(String str);
    }
}
