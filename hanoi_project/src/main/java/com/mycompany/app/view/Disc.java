package com.mycompany.app.view;


public class Disc {
    private int size;

    public static final int MIN_SIZE = 1;

    Disc(int initSize){
        if(initSize<MIN_SIZE){
            initSize = MIN_SIZE;
        }
        this.size = initSize;
    }

    public int getSize() {
        return size;
    }



}
