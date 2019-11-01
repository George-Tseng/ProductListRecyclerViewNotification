package com.tester.productlistrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import java.util.ArrayList;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    //RecyclerView宣告
    private RecyclerView recyclerView0;
    //Adapter宣告(見ProductAdapter.java)
    public ProductAdapter productAdapter0 = null;
    //ArrayList宣告
    public ArrayList<ProductSet> productData = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView0 = (RecyclerView) findViewById(R.id.productList);
        //開始填入ArrayList
        productData = new ArrayList<ProductSet>();
        productData.add(new ProductSet(R.drawable.storage_icon_sshd,getString(R.string.productName8),getString(R.string.productPrice8),getString(R.string.productIntro8)));
        productData.add(new ProductSet(R.drawable.storage_icon_enterprise_hdd,getString(R.string.productName10),getString(R.string.productPrice10),getString(R.string.productIntro10)));
        productData.add(new ProductSet(R.drawable.storage_icon_surveillance_hdd,getString(R.string.productName11),getString(R.string.productPrice11),getString(R.string.productIntro11)));
        productData.add(new ProductSet(R.drawable.storage_icon_nas_hdd,getString(R.string.productName12),getString(R.string.productPrice12),getString(R.string.productIntro12)));
        productData.add(new ProductSet(R.drawable.storage_icon_hdd,getString(R.string.productName13),getString(R.string.productPrice13),getString(R.string.productIntro13)));
        //加入資料中止！開始設定RecyclerView上的Adapter
        productAdapter0 = new ProductAdapter(MainActivity.this,productData);
        final LinearLayoutManager layoutManager0 = new LinearLayoutManager(this);
        layoutManager0.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView0.setLayoutManager(layoutManager0);
        recyclerView0.setAdapter(productAdapter0);
    }
}
