package com.bawei.wangguanhua2020224.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.util.Log;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Time: 2020/2/24
 * Author: 王冠华
 * Description:
 * 网络工具类,更新数据到主线程
 */
public class NetUtils {
    //饿汉单例模式
    private static NetUtils netUtils=new NetUtils();
    private NetUtils(){}
    public static NetUtils getInstance(){
        return netUtils;
    }
    //创建Handle
    private Handler handler=new Handler();
    //创建接口
    public interface ICallBack{
        void onSuccess(String json);
        void onFailer(String msg);
    }
    //添加网络判断方法
    public boolean isNetWork(Context context){
       @SuppressLint("ServiceCast") ConnectivityManager cm= (ConnectivityManager) context.getSystemService(context.NETWORK_STATS_SERVICE);
        NetworkInfo info = cm.getActiveNetworkInfo();
        //判断是否有网
        if(info!=null){
            return true;
        }else {
            return false;
        }
    }
    //获取json数据方法
    public void getJson(final String path, final ICallBack iCallBack){
        //创建线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL(path);
                    //建立连接
                    HttpURLConnection conn= (HttpURLConnection) url.openConnection();
                    //请求方式
                    conn.setRequestMethod("GET");
                    conn.setReadTimeout(5000);
                    conn.setConnectTimeout(7000);
                    //获取状态码
                    int responseCode = conn.getResponseCode();
                    //判断
                    if(responseCode==200){
                        //成功就获取流
                        InputStream inputStream = conn.getInputStream();
                        //通过循环读取
                        int len=0;
                        StringBuilder sb = new StringBuilder();
                        byte[] bt=new byte[1024];
                        //循环读出
                        while ((len=inputStream.read(bt))!=-1){
                            String s = new String(bt, 0, len);
                            //追加到StringBuilder
                            sb.append(s);
                        }
                        //转换成字符串
                        final String json = sb.toString();
                        //使用Log输出请求成功后的数据
                        Log.i("xxx",json);
                        //关闭流
                        inputStream.close();
                        //更新UI
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                iCallBack.onSuccess(json);
                            }
                        });

                    }else {
                        //更新UI
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                iCallBack.onFailer("获取失败");
                            }
                        });
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }).start();
    }
}
