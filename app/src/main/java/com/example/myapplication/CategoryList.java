package com.example.myapplication;

import android.widget.ImageView;

public class CategoryList {
    private String categoryName;
    private String categoryDescription;
    private ImageView categoryImg;

    public CategoryList(String categoryName, String categoryDescription) {
        this.categoryName = categoryName;
        this.categoryDescription = categoryDescription;
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
}
