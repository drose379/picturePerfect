package com.example.dylan.pictureperfect;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;

import java.io.File;

/**
 * Created by dylan on 10/19/15.
 */
public abstract class PhotoCapture {

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

    public void parseUri( Uri photo ) {

        String[] projection = {MediaStore.Images.Media.DATA};
        Cursor imageCursor = MediaStore.Images.Media.query( context.getContentResolver(), photo, projection);
        Log.i("CURSORSIZE",String.valueOf(imageCursor.getCount()));
        while ( imageCursor.moveToNext() ) {
            int pathCol = imageCursor.getColumnIndex( MediaStore.Images.Media.DATA );
            File selected = new File( imageCursor.getString( pathCol ) );
            callback.getPhotoResult( new PhotoResult( selected, photo ) );
        }

    }


    public void start() {

    }
    
    public void getPickerResult( Intent data ) {

    }





}
