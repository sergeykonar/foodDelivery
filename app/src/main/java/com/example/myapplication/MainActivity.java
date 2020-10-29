 package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.icu.util.ULocale;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ListView categories;
    ArrayList<CategoryList> arrayList = new ArrayList<>();
    CategoriesAdapter adapter;
    public Button more;
    public String categoryName1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        categories = findViewById(R.id.categoriesList);
        adapter = new CategoriesAdapter(this, arrayList, this);
        categories.setAdapter(adapter);


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("categories");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(arrayList.size()>0) arrayList.clear();
                for (DataSnapshot ds : dataSnapshot.getChildren()){

                    String categoryName = ds.child("categoryName").getValue(String.class);
                    String categoryDescription = ds.child("categoryDescription").getValue(String.class);
                    String url = ds.child("categoryImg").getValue(String.class);
                    arrayList.add(new CategoryList(categoryName, categoryDescription, url));
                    adapter.notifyDataSetChanged();

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