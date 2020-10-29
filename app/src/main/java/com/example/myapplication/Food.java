package com.example.myapplication;

public class Food {
    private String dishName;
    private String dishDescription;
    private String dishPrice;

    public Food(String dishName, String dishDescription, String dishPrice) {
        this.dishName = dishName;
        this.dishDescription = dishDescription;
        this.dishPrice = dishPrice;
    }
    public Food() {

    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String foodName) {
        this.dishName = dishName;
    }

    public String getDishDescription() {
        return dishDescription;
    }

    public void setFoodDescription(String foodDescription) {
        this.dishDescription = foodDescription;
    }

    public String getDishPrice() {
        return dishPrice;
    }

    public void setDishPrice(String dishPrice) {
        this.dishPrice = dishPrice;
    }
}
