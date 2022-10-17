package com.example.appbanhang.adapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.appbanhang.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appbanhang.activity.ChiTietSP;
import com.example.appbanhang.activity.ItemOnCickListener;
import com.example.appbanhang.model.SanPham;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class SanPhamAdapter extends RecyclerView.Adapter<SanPhamAdapter.ItemHolder> {

    Context context;
    ArrayList<SanPham> arrayListSanPham;

    public SanPhamAdapter(Context context, ArrayList<SanPham> listProduct) {
        this.context = context;
        this.arrayListSanPham = listProduct;
    }


    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sanpham,null);
        ItemHolder itemHolder = new ItemHolder(v);
        return itemHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, int position) {

        SanPham product = arrayListSanPham.get(position);
        holder.txtTenSP.setText(product.getTenSP());
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        holder.txtGiaSP.setText(decimalFormat.format(product.getGiaSP()) + "Đ");
        holder.txtPriceSale.setText(decimalFormat.format(product.getGiaSale()) + "Đ");
        holder.txtPriceSale.setPaintFlags(holder.txtPriceSale.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        Picasso.with(context).load(product.getHinhAnhSP()).placeholder(R.drawable.loading_img)
                .error(R.drawable.no_image)
                .into(holder.imgHinhSanPham);
//        holder.txtMoTaSP.setText(product.getMoTaSP());
        Picasso.with(context).load(product.getStar1()).placeholder(R.drawable.loading_img)
                .error(R.drawable.no_image)
                .into(holder.imgStar1);
        Picasso.with(context).load(product.getStar2()).placeholder(R.drawable.loading_img)
                .error(R.drawable.no_image)
                .into(holder.imgStar2);
        Picasso.with(context).load(product.getStar3()).placeholder(R.drawable.loading_img)
                .error(R.drawable.no_image)
                .into(holder.imgStar3);
        Picasso.with(context).load(product.getStar4()).placeholder(R.drawable.loading_img)
                .error(R.drawable.no_image)
                .into(holder.imgStar4);
        Picasso.with(context).load(product.getStar5()).placeholder(R.drawable.loading_img)
                .error(R.drawable.no_image)
                .into(holder.imgStar5);
        Picasso.with(context).load(product.getHeart()).placeholder(R.drawable.loading_img)
                .error(R.drawable.no_image)
                .into(holder.imgHear);

        holder.setOnclickListener(new ItemOnCickListener() {

            @Override
            public void onClick(View view, int pos, boolean isLongClick) {
                if(!isLongClick) {
                    Intent intent = new Intent(context, ChiTietSP.class);
                    intent.putExtra("chitiet", product);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayListSanPham.size();
    }

    //
    public class ItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView imgHinhSanPham;
        public TextView txtTenSP, txtGiaSP, txtMoTaSP;
        public ImageView imgStar1,imgStar2, imgStar3, imgStar4, imgStar5, imgHear;
        public TextView txtPriceSale;
        private ItemOnCickListener onclickListener;

        public ItemHolder(@NonNull View itemView) {
            super(itemView);
            imgHinhSanPham = itemView.findViewById(R.id.imgHinh);
            txtTenSP = itemView.findViewById(R.id.txtName);
            txtGiaSP = itemView.findViewById(R.id.txtPrice);
//            txtMoTaSP = itemView.findViewById(R.id.txtDes);
            imgStar1 = itemView.findViewById(R.id.star1);
            imgStar2 = itemView.findViewById(R.id.star2);
            imgStar3 = itemView.findViewById(R.id.star3);
            imgStar4 = itemView.findViewById(R.id.star4);
            imgStar5 = itemView.findViewById(R.id.star5);
            imgHear = itemView.findViewById(R.id.heart);
            txtPriceSale = itemView.findViewById(R.id.txtPriceSale);
            itemView.setOnClickListener(this);
        }

        public void setOnclickListener(ItemOnCickListener onclickListener) {
            this.onclickListener = onclickListener;
        }

        @Override
        public void onClick(View view) {
            onclickListener.onClick(view, getAdapterPosition(), false);
        }
    }

}