package com.example.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class HealthProductsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<HealthProductItem> healthProdList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_products);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        healthProdList = new ArrayList<>();
        for(int i = 0;i <= 10; i++) {
            HealthProductItem currentProd = new HealthProductItem(
                    "heading " + i,
                    "Lorem ipsum"
            );
            healthProdList.add(currentProd);
        }
        adapter = new CustomAdapter(healthProdList, this);
        recyclerView.setAdapter(adapter);
    }

}