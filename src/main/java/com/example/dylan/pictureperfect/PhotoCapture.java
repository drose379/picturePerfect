package com.example.dylan.pictureperfect;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Created by dylan on 10/19/15.
 */
public abstract class PhotoCapture {

    public interface PhotoCaptureCallback {
        void getPhotoResult( PhotoResult result );
    }

    protected PhotoCaptureCallback callback = null;
    protected Context context;
    protected boolean crop = false;
    protected Bitmap.CompressFormat photoFormat = Bitmap.CompressFormat.JPEG;

    public PhotoCapture( Context context ) {
        this.context = context;
    }

    public void setCrop( boolean crop ) {
        this.crop = crop;
    }

    public void setPhotoFormat( Bitmap.CompressFormat format ) { this.photoFormat = format; }

    public void setCallback( PhotoCaptureCallback callback ) {
        this.callback = callback;
    }

    public void parseUri( Uri photo ) {

        String[] projection = {MediaStore.Images.Media.DATA};
        Cursor imageCursor = MediaStore.Images.Media.query( context.getContentResolver(), photo, projection);
        while ( imageCursor.moveToNext() ) {
            int pathCol = imageCursor.getColumnIndex( MediaStore.Images.Media.DATA );
            File selected = new File( imageCursor.getString( pathCol ) );
            //TODO:: Compress file into the correct fileType
            compressToFormat( selected, photoFormat );
            callback.getPhotoResult( new PhotoResult( selected, photo ) );
        }

    }

    //TODO::Allow dev to set quality with GalleryBuilder [0-100], this will set the quality in the compress.
    public void compressToFormat( File photo, Bitmap.CompressFormat format ) {
        Bitmap temp = BitmapFactory.decodeFile(photo.getPath());

        try {
            FileOutputStream outputStream = new FileOutputStream( photo );
            temp.compress( format, 100, outputStream );
        } catch ( FileNotFoundException e ) {
            throw new RuntimeException( e.getMessage() );
        }

    }


    public void start() {

    }
    
    public void getPickerResult( Intent data ) {

    }





}
