package com.example.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class HealthProductsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<HealthProductItem> healthProdList;

    private List<String> fruits = new ArrayList<>();
    private List<String> benefits = new ArrayList<>();

    private void initList() {
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");
        fruits.add("Grapes");
        fruits.add("Watermelon");

        benefits.add("Helps lower risk of heart disease");
        benefits.add("Rich in potassium, which can lower blood pressure");
        benefits.add("High in vitamin C, which boosts the immune system");
        benefits.add("Rich in antioxidants, which can help protect against chronic diseases.");
        benefits.add("High in water content and contains essential nutrients such as vitamin C and potassium.");

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.initList();
        setContentView(R.layout.activity_health_products);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        healthProdList = new ArrayList<>();
        for(int i = 0; i < fruits.size(); i++) {
            HealthProductItem currentProd = new HealthProductItem(
                    fruits.get(i),
                    benefits.get(i)
            );
            healthProdList.add(currentProd);
        }
        adapter = new CustomAdapter(healthProdList, this);
        recyclerView.setAdapter(adapter);

        Button btnBackProducts = findViewById(R.id.btnBackProducts);
        btnBackProducts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent( HealthProductsActivity.this, HomeActivity.class));

            }
        });
    }

}