package com.example.appbanhang.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

public class CheckConnection {
    public static boolean isConnected(Context context){
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo wifi = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        NetworkInfo mobile = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        if ( (wifi!=null && wifi.isConnected()) || (mobile!=null && mobile.isConnected()) ){
            return  true;
        }else {
            return false;
        }
    }
    public static void getToken(){

    }

    public static void ShowToast(Context context, String thongBao){
        Toast.makeText(context,thongBao,Toast.LENGTH_LONG).show();

    }
}
