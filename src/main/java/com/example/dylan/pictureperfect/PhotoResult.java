package com.example.dylan.pictureperfect;

import android.graphics.Bitmap;

import java.io.File;

/**
 * Created by dylan on 10/19/15.
 */
public class PhotoResult {

    private File image;

    public void setImage( File image ) {
        this.image = image;
    }

    public String getLocationPath() {
        return image.getPath();
    }



}
