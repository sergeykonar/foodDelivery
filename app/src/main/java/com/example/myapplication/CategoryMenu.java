package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class CategoryMenu extends AppCompatActivity {

    private String category;
    private FoodAdapter adapter;
    private ArrayList<Food> arrayList = new ArrayList<>();
    private ListView foodList;
    private Button backButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_menu);

        Intent intent = getIntent();
        category = intent.getStringExtra("Category");
        Log.d("TAG", category);

        backButton = (Button) findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        foodList = findViewById(R.id.foodList);
        adapter = new FoodAdapter(this, arrayList);
        foodList.setAdapter(adapter);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("menu/"+category);
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (arrayList.size() > 0) arrayList.clear();
                for (DataSnapshot ds : dataSnapshot.getChildren()){
                    String dishName = ds.child("dishName").getValue(String.class);
                    String dishDescription = ds.child("dishDescription").getValue(String.class);
                    String dishPrice = ds.child("dishPrice").getValue(String.class);
                    arrayList.add(new Food(dishName, dishDescription, dishPrice));
                    adapter.notifyDataSetChanged();
                    System.out.println(dishName);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Failed to read value
                Log.w("TAG", "Failed to read value.", error.toException());
            }
        });
    }



}