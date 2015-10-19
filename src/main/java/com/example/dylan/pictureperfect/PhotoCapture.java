package com.example.dylan.pictureperfect;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

/**
 * Created by dylan on 10/19/15.
 */
public class PhotoCapture {

    public interface PhotoCaptureCallback {
        void getPhotoResult( PhotoResult result );
    }

    protected PhotoCaptureCallback callback = null;
    protected Context context;
    protected boolean crop = true;

    public PhotoCapture( Context context ) {
        this.context = context;
    }

    public void setCrop( boolean crop ) {
        this.crop = crop;
    }

    public void setCallback( PhotoCaptureCallback callback ) {
        this.callback = callback;
    }


    public void start() {

    }
    
    public void getPickerResult( Intent data ) {

    }





}
