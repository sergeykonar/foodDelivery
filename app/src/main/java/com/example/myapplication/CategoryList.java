package com.example.myapplication;

import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class CategoryList {
    private String categoryName;
    private String categoryDescription;
    private ImageView categoryImg;
    private String url;

    public CategoryList(String categoryName, String categoryDescription, String url) {
        this.categoryName = categoryName;
        this.categoryDescription = categoryDescription;
        this.url = url;
        //this.categoryImg = categoryImg;
    }
    public CategoryList() {

    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }

    public ImageView getCategoryImg() {
        return categoryImg;
    }

    public void setCategoryImg(ImageView categoryImg) {
        this.categoryImg = categoryImg;
    }

    public String getUrl() {
        return url;
    }
}
