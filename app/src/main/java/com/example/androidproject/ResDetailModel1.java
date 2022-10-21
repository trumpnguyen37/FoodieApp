package com.example.androidproject;

public class ResDetailModel1 {

    private int img;
    private int pos;

    public ResDetailModel1(int img, int pos){
        this.img = img;
        this.pos = pos;
    }

    public void setImg(int img){
        this.img = img;
    }

    public int getImg(){
        return img;
    }

    public int getPos(){
        return pos;
    }
}
