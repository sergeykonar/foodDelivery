package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CategoriesAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<CategoryList> arrayList;
    private TextView categoryName, categoryDescription;
    private ImageView categoryImg;

    public CategoriesAdapter(Context context, ArrayList<CategoryList> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
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
        convertView = LayoutInflater.from(context).inflate(R.layout.item_list, parent, false);
        categoryName = convertView.findViewById(R.id.categoryName);
        categoryDescription = convertView.findViewById(R.id.categoryDescription);
        categoryName.setText(arrayList.get(position).getCategoryName());
        categoryDescription.setText(arrayList.get(position).getCategoryDescription());

        categoryImg = convertView.findViewById(R.id.imageView);
        Picasso.get().load(arrayList.get(position).getUrl()).resize(185, 185).placeholder(R.drawable.common_full_open_on_phone).into(categoryImg);

        return convertView;
    }
}
