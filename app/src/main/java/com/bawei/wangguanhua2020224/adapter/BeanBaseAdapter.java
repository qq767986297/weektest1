package com.bawei.wangguanhua2020224.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.wangguanhua2020224.R;
import com.bawei.wangguanhua2020224.bean.Bean;
import com.bawei.wangguanhua2020224.bean.ListBean;
import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Time: 2020/2/24
 * Author: 王冠华
 * Description:
 * 加载条目,优化列表
 */
public class BeanBaseAdapter extends BaseAdapter {
    Context context;
    List<ListBean.ResultBean.PzshBean.CommodityListBeanX> list;

    public BeanBaseAdapter(Context context, List<ListBean.ResultBean.PzshBean.CommodityListBeanX> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //实例化ViewHolder
        ViewHolder holder = new ViewHolder();
        //判断
        if(convertView==null){
            //加载布局
       convertView=  View.inflate(context,R.layout.item,null);
         //关联控件
         holder.tt=convertView.findViewById(R.id.life_tt);
         holder.tv=convertView.findViewById(R.id.life_pirce);
         holder.iv=convertView.findViewById(R.id.life_iv);
         convertView.setTag(holder);
        }else {
            holder= (ViewHolder) convertView.getTag();
        }
        //获取集合对应的数据
        ListBean.ResultBean.PzshBean.CommodityListBeanX bean = list.get(position);
        String name = bean.getCommodityName();
        String pic = bean.getMasterPic();
        int price = bean.getPrice();
        //设置值
        holder.tt.setText(name);
        holder.tv.setText(price+"");
        Glide.with(context).load(pic).into(holder.iv);
        return convertView;
    }
    private class ViewHolder{
        private TextView tv;
        private TextView tt;
        private ImageView iv;
    }
}
