package com.example.clothes.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.clothes.Adapter.CategoriesAdapter;
import com.example.clothes.HomePage;
import com.example.clothes.R;
import com.example.clothes.model.Categories;

import java.util.ArrayList;


public class ChildrenFragment extends Fragment {



    private RecyclerView recyclerViewChildren;
    private View mView;
    private HomePage mhomePage;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        mView= inflater.inflate(R.layout.fragment_children, container, false);
        recyclerViewChildren= mView.findViewById(R.id.recyclercategories);
        mhomePage=(HomePage)getActivity();
        LinearLayoutManager linearLayoutManager= new LinearLayoutManager(mhomePage);
        recyclerViewChildren.setLayoutManager(linearLayoutManager);
        CategoriesAdapter categoriesAdapter= new CategoriesAdapter(getarr_Categories());
        recyclerViewChildren.setAdapter(categoriesAdapter);
        return mView;
    }



}