package com.example.dylan.pictureperfect;

import java.io.File;

/**
 * Created by dylan on 10/19/15.
 */
public class PhotoResult {

    private String locationPath;
    private File image;

    public void setImage( File image ) {
        this.image = image;
    }

    public String getLocationPath() {
        return image.getPath();
    }



}
