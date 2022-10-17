package com.example.appbanhang.utils;

import com.example.appbanhang.model.GioHang;

import java.util.List;

public class server {
    public static String localHost= "192.168.1.13";
  //    public static String localHost= "192.168.212.11";
    public static String ID_NHAN="100";
    public static final String ID_SEND="idsend";
    public static final String ID_RECEIVE="received";
    public static final String MESS="message";
    public static final String DATE="datetime";
    public static final String PATH_CHAT="chat";
    public static int user_current;

 //   public static String localHost= "192.168.95.141";
    public static List<GioHang> listGioHang;
    public  static String urlLoaiSP="http://"+localHost+":8080/android_appbanhang/getLoaiSanPham.php";
    public  static String urlSanPhamTheoLoai="http://"+localHost+":8080/android_appbanhang/getSPTheoLoai.php";

}
