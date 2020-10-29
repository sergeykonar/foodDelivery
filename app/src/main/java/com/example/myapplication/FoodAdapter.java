package com.example.myapplication;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class FoodAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Food> arrayListFood;
    private TextView foodName, foodDescription, foodPrice;
    private Button addToCart;
    public FoodAdapter(Context context, ArrayList<Food> arrayListFood) {
        this.context = context;
        this.arrayListFood = arrayListFood;
    }

    @Override
    public int getCount() {
        return arrayListFood.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.item_list_food_menu, parent, false);
        foodName = convertView.findViewById(R.id.foodName);
        foodDescription = convertView.findViewById(R.id.foodDescription);
        foodName.setText(arrayListFood.get(position).getDishName());
        foodDescription.setText(arrayListFood.get(position).getDishDescription());

        foodPrice = convertView.findViewById(R.id.foodPrice);
        foodPrice.setText(arrayListFood.get(position).getDishPrice());
//        Picasso.get().load(arrayList.get(position).getUrl()).resize(185, 185).placeholder(R.drawable.common_full_open_on_phone).into(categoryImg);

        addToCart = convertView.findViewById(R.id.button);
        View finalConvertView = convertView;
        addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("TAG", String.valueOf(position));

                ConfirmFoodDialog confirmFoodDialog = new ConfirmFoodDialog();
                confirmFoodDialog.show(((CategoryMenu) context).getSupportFragmentManager(), "Title");

//                Intent intent = new Intent(MainActivity.class, CategoryMenu.class);
                // Отслеживание нажатия на кнопку внутри элемента списка
            }
        });

        return convertView;
    }

}
