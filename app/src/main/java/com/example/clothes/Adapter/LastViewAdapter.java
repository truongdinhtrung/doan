package com.example.clothes.Adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.clothes.R;
import com.example.clothes.model.LastView;

import java.util.ArrayList;

public class LastViewAdapter extends RecyclerView.Adapter<LastViewAdapter.ViewHolder> {
    Activity context;
    ArrayList<LastView> arr_LastView;
    public LastViewAdapter(Activity context, ArrayList<LastView> arr_LastView){
        this.context=context;
        this.arr_LastView=arr_LastView;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        View viewLastView=layoutInflater.inflate(R.layout.item,parent,false);
        return new ViewHolder(viewLastView);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        LastView lastView =arr_LastView.get(position);
        holder.ivHinh.setImageResource(lastView.getHinh());
        holder.txtTenSp.setText(lastView.getTensp());
        holder.txtGia.setText(lastView.getGia()+"$");

    }

    @Override
    public int getItemCount() {
        return arr_LastView.size();
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
