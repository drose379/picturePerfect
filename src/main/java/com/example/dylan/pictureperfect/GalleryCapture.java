package com.example.dylan.pictureperfect;

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
public class GalleryCapture extends PhotoCapture {

    private GalleryCapture( Context context ) {
        super(context);
    }

    private static GalleryCapture galleryCapture = null;

    public static GalleryCapture getInstance( Context context ) {
        galleryCapture = galleryCapture == null ? new GalleryCapture( context ) : galleryCapture;
        return galleryCapture;
    }

    @Override
    public void start() {
        Intent galleryPick = new Intent( context, GalleryPick.class );
        context.startActivity( galleryPick );
    }

    @Override
    public void getPickerResult( Intent photoData ) {
        //TODO:: Get the location of the selected photo, if crop is true, crop it, then parse it into PhotoResult object
        Uri selectedUri = photoData.getData();
        if ( crop ) {
            //TODO:: Show a cropping actiivty that passes the cropped photo back to here
        } else {
            String[] projection = {MediaStore.Images.Media.DATA};
            Cursor imageCursor = MediaStore.Images.Media.query( context.getContentResolver(), selectedUri, projection);
            while ( imageCursor.moveToNext() ) {
                int pathCol = imageCursor.getColumnIndex( MediaStore.Images.Media.DATA );
                File selected = new File( imageCursor.getString( pathCol ) );
                
            }
        }
    }


    public static class Builder {
        //TODO:: If GaleryCapture extends PhotoCapture, does GalleryCapture need its own Builder class? Or can Builder here extend the superclass Builder

        protected GalleryCapture galleryCapture;
        private Context context;

        public Builder( Context context ) {
            this.context = context;
        }

        public Builder crop( boolean crop ) {
            galleryCapture = galleryCapture == null ? GalleryCapture.getInstance( context ) : galleryCapture;
            galleryCapture.setCrop(crop);
            return this;
        }

        public GalleryCapture build() {
            return galleryCapture;
        }

    }


}
