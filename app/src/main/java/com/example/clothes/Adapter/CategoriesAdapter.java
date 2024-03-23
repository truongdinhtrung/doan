package com.example.clothes.Adapter;

import android.annotation.SuppressLint;
import android.app.Activity;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.clothes.R;
import com.example.clothes.model.Categories;

import java.util.ArrayList;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.ViewHolder> {
    //khai bao bien
    Activity context;
    ArrayList<Categories>arr_Categories;

    public CategoriesAdapter(Activity context, ArrayList<Categories> arr_Categories){
        this.context=context;
        this.arr_Categories=arr_Categories;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        View viewCategories=layoutInflater.inflate(R.layout.item,parent,false);
        return new ViewHolder(viewCategories);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
     Categories categories=arr_Categories.get(position);
     if(categories==null){
         return;
     }
     holder.ivHinh.setImageResource(categories.getHinh());
     holder.txtTenSp.setText(categories.getTensp());
     holder.txtGia.setText(categories.getGia()+"$");
    }

    @Override
    public int getItemCount() {
        if(arr_Categories !=null){
            return arr_Categories.size();
        }
        return 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView ivHinh;
        TextView txtTenSp, txtGia;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivHinh=itemView.findViewById(R.id.ivHinh);
            txtTenSp=itemView.findViewById(R.id.txtTenSp);
            txtGia=itemView.findViewById(R.id.txtGia);
        }
    }
}
