package com.bawei.wangguanhua2020224.custom;

import android.content.Context;

import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.EditText;

/**
 * Time: 2020/3/4
 * Author: 王冠华
 * Description:
 */
    public class CustomStemView extends  android.support.v7.widget.AppCompatEditText{
    private String s1;
    public CustomStemView(Context context) {
        super(context);
        init();
    }

    public CustomStemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomStemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    public void init(){
        addTextChangedListener(new TextWatcher() {


            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                s1 = s.toString();
                handler.removeCallbacks(run);
                handler.postDelayed(run,1000);

            }
        });
    }
    //创建handel
    private Handler handler=new Handler();

   Runnable run= new Runnable() {
       @Override
       public void run() {

       }
   };


}
