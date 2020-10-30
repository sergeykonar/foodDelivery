package com.example.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CategoriesAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<CategoryList> arrayList;
    private TextView categoryName, categoryDescription;
    private ImageView categoryImg;
    private Button more;
    private Activity mActivity;

    public CategoriesAdapter(Context context, ArrayList<CategoryList> arrayList, Activity mActivity) {
        this.context = context;
        this.arrayList = arrayList;
        this.mActivity = mActivity;
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

        more = convertView.findViewById(R.id.button);

        View finalConvertView = convertView;
        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("TAG", String.valueOf(position));
                TextView s = (TextView) finalConvertView.findViewById(R.id.categoryName);

                Log.d("TAGS", s.getText().toString());
                Intent a = new Intent(finalConvertView.getContext(), CategoryMenu.class);
                a.putExtra("Category", s.getText().toString());
                finalConvertView.getContext().startActivity(a);
                mActivity.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
//                Intent intent = new Intent(MainActivity.class, CategoryMenu.class);
                // Отслеживание нажатия на кнопку внутри элемента списка
            }
        });
        return convertView;
    }
}
