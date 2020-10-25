package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.icu.util.ULocale;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ListView categories;
    ArrayList<CategoryList> arrayList = new ArrayList<>();
    CategoriesAdapter adapter;

    public String categoryName1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        categories = findViewById(R.id.categoriesList);
        adapter = new CategoriesAdapter(this, arrayList);
        categories.setAdapter(adapter);

        FirebaseDatabase database = FirebaseDatabase.getInstance();

        for(int i = 1; i<=5; i++) {

            DatabaseReference myRef = database.getReference("categories/category" + i);
            myRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String categoryName = dataSnapshot.child("categoryName").getValue(String.class);
                    String categoryDescription = dataSnapshot.child("categoryDescription").getValue(String.class);

                    arrayList.add(new CategoryList(categoryName, categoryDescription));
                    adapter.notifyDataSetChanged();
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    // Failed to read value
                    Log.w("TAG", "Failed to read value.", error.toException());
                }
            });
        }
    }

}