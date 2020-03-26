package com.example.tutorialspoint7.myapplication.Model;

public class MyModel {
    private int bg;
    private String title;
    private int imgId;

    public MyModel(int bg, String title, int drawable){
        super();
        this.bg = bg;
        this.title = title;
        this.imgId = drawable;
    }

    public int getBg() {
        return bg;
    }

    public void setBg(int bg) {
        this.bg = bg;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImageUil() {
        return imgId;
    }

    public void setImageUil(int imageUil) {
        this.imgId = imageUil;
    }
}
