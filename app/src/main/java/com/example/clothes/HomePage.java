package com.example.clothes;

import static com.example.clothes.R.id.bottom_account;
import static com.example.clothes.R.id.bottom_home;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.clothes.Adapter.CategoriesAdapter;
import com.example.clothes.Adapter.LastViewAdapter;
import com.example.clothes.Fragment.AllFragment;
import com.example.clothes.Fragment.ChildrenFragment;
import com.example.clothes.Fragment.MenFragment;
import com.example.clothes.model.Categories;
import com.example.clothes.model.LastView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class HomePage extends AppCompatActivity {
Button btnAll, btnWomen, btnMen, btnChildren;
FrameLayout HomeFrame;
RecyclerView recyclerViewCategories;

RecyclerView recyclerViewLastView;
LastViewAdapter lastViewAdapter;
    CategoriesAdapter categoriesAdapter;
ArrayList<Categories>arr_Categories;
ArrayList<LastView> arr_LastView;


    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);
        BottomNavigationView bottomNavigationView= findViewById(R.id.bottomnavagation);
        bottomNavigationView.setSelectedItemId(bottom_home);
        addCin1();
        bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.bottom_home)
                return true;
            else if (item.getItemId() == R.id.bottom_heart) {
                startActivity(new Intent(getApplicationContext(), heart.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
                return true;
            }
            else if (item.getItemId() == bottom_account) {
                startActivity(new Intent(getApplicationContext(), Account.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
                return true;
            }
            else if (item.getItemId() == R.id.bottom_shoppingcart) {
                startActivity(new Intent(getApplicationContext(), shoppingcart.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
                return true;
            }

return false;
        });

        addControls();
        addEvent();
        AddData();
    }



    private void AddData() {
    arr_Categories.add(new Categories("Nike Jacket",110,R.drawable.jaket));
        arr_Categories.add(new Categories("Nike Air Max 90",119,R.drawable.nikeairmax));
        arr_Categories.add(new Categories("Tommy Hilfiger Hat",29,R.drawable.tommy));
      arr_LastView.add(new LastView("Borealis Backpack",99,R.drawable.borealisbackpack));
     arr_LastView.add(new LastView("Wawona 6 Tent",500,R.drawable.wawona6tent));
      arr_LastView.add(new LastView("One Bag",360,R.drawable.onebag));
    }

    void loadFragment(Fragment fmNew){
    FragmentTransaction fmTran=getSupportFragmentManager().beginTransaction();
    fmTran.replace(R.id.HomeFrame,fmNew);
    fmTran.addToBackStack(null);
    fmTran.commit();
}

    private void addEvent() {
btnMen.setOnClickListener(v -> {
    Fragment fragment=new MenFragment();
    loadFragment(fragment);
});
btnAll.setOnClickListener(v -> {
    Fragment fragment=new AllFragment();
    loadFragment(fragment);
});
btnWomen.setOnClickListener(v -> {
    Fragment fragment=new MenFragment();
    loadFragment(fragment);
});
btnChildren.setOnClickListener(v -> {
    Fragment fragment=new ChildrenFragment();
    loadFragment(fragment);
});
    }

    private void addControls() {

        btnAll=findViewById(R.id.btnAll);
        btnWomen=findViewById(R.id.btnWomen);
        btnMen=findViewById(R.id.btnMen);
        btnChildren=findViewById(R.id.btnChildren);

       HomeFrame=findViewById(R.id.HomeFrame);
        Fragment fragment=new AllFragment();
        loadFragment(fragment);
        recyclerViewCategories=findViewById(R.id.recyclercategories);
        arr_Categories=new ArrayList<>();
        categoriesAdapter=new CategoriesAdapter(this,arr_Categories);
        recyclerViewCategories.setLayoutManager(new GridLayoutManager(HomePage.this,3));
        recyclerViewCategories.setAdapter(categoriesAdapter);
    }
    private void addCin1() {
        recyclerViewLastView=findViewById(R.id.recyclerLastView);
        arr_LastView=new ArrayList<>();
        lastViewAdapter= new LastViewAdapter(this,arr_LastView);
        recyclerViewLastView.setLayoutManager(new GridLayoutManager( HomePage.this, 3));
        recyclerViewLastView.setAdapter(lastViewAdapter);
    }
}