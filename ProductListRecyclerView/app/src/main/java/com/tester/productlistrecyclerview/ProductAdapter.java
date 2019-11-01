package com.tester.productlistrecyclerview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder>{
    //繼承RecyclerView.Adapter<ProductAdapter.ViewHolder>

    //宣告LayoutInflater
    LayoutInflater layoutInflater0;
    //宣告Intent與Bundle
    private Intent intent0;
    private Bundle bundle0;
    //宣告ArrayList與Context
    public ArrayList<ProductSet> productList;
    Context context0;

    //建構子
    public ProductAdapter(Context context0, ArrayList<ProductSet> productList) {
        this.context0 = context0;
        this.productList = productList;
    }

    //以下與ViewHolder有關
    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgCover;
        private TextView txtName,txtPrice,txtIntro;
        private Button btnClick;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            imgCover = itemView.findViewById(R.id.imgCover);
            txtName = itemView.findViewById(R.id.txtName);
            txtPrice = itemView.findViewById(R.id.txtPrice);
            txtIntro = itemView.findViewById(R.id.txtIntro);
            //設定按下按鈕的相關部份
            btnClick = itemView.findViewById(R.id.btnClick);
            btnClick.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    intent0 = new Intent();
                    //將資料送出到下個頁面
                    bundle0 = new Bundle();
                    bundle0.putInt("imgCover2",productList.get(getAdapterPosition()).getImg());
                    bundle0.putString("txtName2",txtName.getText().toString());
                    bundle0.putString("txtPrice2",txtPrice.getText().toString());
                    bundle0.putString("txtIntro2",txtIntro.getText().toString());
                    intent0.putExtras(bundle0);
                    intent0.setClass(v.getContext(),ResultActivity.class);
                    //開始執行intent0
                    context0.startActivity(intent0);
                    ((Activity)context0).finish();
                }
            });
        }
    }

    @NonNull
    @Override
    //LayoutInflater，輸入View、回傳ViewHolder
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = layoutInflater0.from(parent.getContext()).inflate(R.layout.item_view,parent,false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    //把值傳遞到用LayoutInflater所建立的空間裡
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imgCover.setImageResource(productList.get(position).getImg());
        holder.txtName.setText(productList.get(position).getName());
        holder.txtPrice.setText(productList.get(position).getPrice());
        holder.txtIntro.setText(productList.get(position).getIntro());
    }

    @Override
    //算資料總數
    public int getItemCount() {
        return productList.size();
    }
}
