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
 * Created by Dylan Rose on 10/19/15.
 */
public abstract class PhotoCapture {

    public interface PhotoCaptureCallback {
        void getPhotoResult( PhotoResult result );
    }

    //TODO:: Show the default values for each option in the README and in documentation
    protected PhotoCaptureCallback callback = null;
    protected Context context;
    protected boolean crop = false;
    protected Bitmap.CompressFormat photoFormat = Bitmap.CompressFormat.JPEG;
    protected int photoQuality = 100;
    protected GalleryCapture.Builder.ASPECT photoAspect = GalleryCapture.Builder.ASPECT.FREE;

    public PhotoCapture( Context context ) {
        this.context = context;
    }


    public void start() {

    }

    public void getPickerResult( Intent data ) {
        Uri selectedUri = data.getData();
        if ( crop ) {

            Intent crop = new Intent( context, Cropper.class );
            crop.putExtra( "selectedUri", selectedUri.toString() );
            crop.putExtra( "aspect", photoAspect );

            context.startActivity( crop );

        } else {
            parseUri( selectedUri );
        }
    }

    public void getCropperResult( File croppedPhoto ) {

    }

    public void parseUri( Uri photo ) {

        String[] projection = {MediaStore.Images.Media.DATA};
        Cursor imageCursor = MediaStore.Images.Media.query( context.getContentResolver(), photo, projection);
        while ( imageCursor.moveToNext() ) {
            int pathCol = imageCursor.getColumnIndex( MediaStore.Images.Media.DATA );
            File selected = new File( imageCursor.getString( pathCol ) );
            compressToFormat( selected, photoFormat );
            callback.getPhotoResult( new PhotoResult( selected, photo, photoAspect ) );
        }

    }

    public void compressToFormat( File photo, Bitmap.CompressFormat format ) {
        Bitmap temp = BitmapFactory.decodeFile(photo.getPath());

        try {
            FileOutputStream outputStream = new FileOutputStream( photo );
            temp.compress( format, photoQuality, outputStream );
        } catch ( FileNotFoundException e ) {
            throw new RuntimeException( e.getMessage() );
        }

    }


}
