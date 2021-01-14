package com.erensaridag.landmarkbook;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class Singleton {

   private   Bitmap chosenImage;
   private  static Singleton singleton;

    private Singleton() {

    }
    public Bitmap getChosenImage() {
        return chosenImage;
    }

    public void setChosenImage(Bitmap chosenImage) {
        this.chosenImage = chosenImage;
    }
    public  static  Singleton getInstance() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;

    }
    }


