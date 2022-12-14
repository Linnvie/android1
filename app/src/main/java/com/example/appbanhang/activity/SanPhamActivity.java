package com.example.appbanhang.activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.appbanhang.R;
import com.example.appbanhang.adapter.LoaiSanPhamAdapter;
import com.example.appbanhang.adapter.SanPhamAdapter;
import com.example.appbanhang.model.SanPham;
import com.example.appbanhang.utils.CheckConnection;
import com.example.appbanhang.utils.server;
import com.google.gson.JsonArray;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SanPhamActivity extends AppCompatActivity {
    RecyclerView recyclerViewSanPham;
    Toolbar toolbarLoai;
    ImageView cartSP;
    ArrayList<SanPham> mangSP;
    SanPhamAdapter sanPhamAdapter;
    int idLoai=0;
    String tenLoai="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_san_pham);
        recyclerViewSanPham= findViewById(R.id.recyclerViewSanPham);
        toolbarLoai= findViewById(R.id.tenLoaiSP);
        idLoai=getIntent().getIntExtra("idloaisanpham",-1);
        tenLoai=getIntent().getStringExtra("tenloaisanpham");
        CheckConnection.ShowToast(this, idLoai+"");
        setSupportActionBar(toolbarLoai);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbarLoai.setTitle(tenLoai);
        toolbarLoai.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        mangSP= new ArrayList<>();
        sanPhamAdapter = new SanPhamAdapter(getApplicationContext(), mangSP);
        recyclerViewSanPham.setHasFixedSize(true);
        recyclerViewSanPham.setLayoutManager(new GridLayoutManager(getApplicationContext(),2));
        recyclerViewSanPham.setAdapter(sanPhamAdapter);
        if (CheckConnection.isConnected(this)) {
            DuLieuSanPham();
        } else {
            CheckConnection.ShowToast(this, "B???n h??y ki???m tra l???i k???t n???i Internet");
            finish();
        }

//        if(server.listGioHang!=null){
//            themGioHang();
//        }else {
//            server.listGioHang= new ArrayList<>();
//        }

    }



    private void DuLieuSanPham() {
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        StringRequest stringRequest= new StringRequest(Request.Method.POST, server.urlSanPhamTheoLoai, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                int ID = 0;
                    String TenSP = "";
                    Integer GiaSP = 0;
                    Integer GiaSPSale = 0;
                    String HinhAnhSP = "";
                    String MoTaSP = "";
                    String Star1 = "";
                    String Star2 = "";
                    String Star3 = "";
                    String Star4 = "";
                    String Star5 = "";
                    String Heart = "";
                    int IdSP = 0;
                    if(response!=null){
                        try {
                            JSONArray jsonArray= new JSONArray(response);
                            for(int i = 0; i <jsonArray.length(); i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                            ID = jsonObject.getInt("id");
                            TenSP = jsonObject.getString("tensanpham");
                            GiaSP = jsonObject.getInt("giasanpham");
                            GiaSPSale = jsonObject.getInt("pricesale");
                            HinhAnhSP = jsonObject.getString("hinhanhsanpham");
                            MoTaSP = jsonObject.getString("moTasanpham");
                            Star1 = jsonObject.getString("star");
                            Star2 = jsonObject.getString("star");
                            Star3 = jsonObject.getString("star");
                            Star4 = jsonObject.getString("star");
                            Star5 = jsonObject.getString("star");
                            Heart = jsonObject.getString("heart");
                            IdSP = jsonObject.getInt("idsanpham");
                            mangSP.add(new SanPham(ID, TenSP, GiaSPSale, GiaSP, HinhAnhSP, MoTaSP, Star1, Star2, Star3, Star4, Star5, Heart, IdSP));
                            sanPhamAdapter.notifyDataSetChanged();
                            }
                        }catch (JSONException e){
                            e.printStackTrace();
                        }

                    }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String,String> param= new HashMap<String,String>();
                param.put("idloai", String.valueOf(idLoai));
                return param;
            }
        };
        requestQueue.add(stringRequest);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.cart, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.cart:
                CheckConnection.ShowToast(this,"ch???n cart");
                Intent intent = new Intent(this, GioHang.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
//    public void themGioHang() {
//        cartSP.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if(server.listGioHang.size()>0){
//
//                }else {
//                    int soluong=1;
        //              int gia= Integer.parseInt(product)
//                }
//            }
//        });

 //   }

}