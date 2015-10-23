package com.example.dylan.pictureperfect;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;

import java.io.File;

/**
 * Created by Dylan Rose on 10/19/15.
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

    public void getPickerResult( Intent photoData ) {
        Uri selectedUri = photoData.getData();
        if ( crop ) {

            Intent crop = new Intent( context, Cropper.class );
            crop.putExtra( "selectedUri", selectedUri.toString() );
            crop.putExtra( "aspect", photoAspect );

            Log.i("URI",selectedUri.toString());

            context.startActivity( crop );

        } else {
            parseUri( selectedUri );
        }
    }

    @Override
    public void getCropperResult( File croppedPhoto ) {
        compressToFormat( croppedPhoto, photoFormat );
        callback.getPhotoResult( new PhotoResult( croppedPhoto, null, photoAspect ) );
    }

    //TODO:: No need to use setters here, all fields in PhotoCapture are protected, so I have access to them here
    public static class Builder {

        public enum QUALITY {
            HIGH,MED,LOW
        }

        public enum ASPECT {
            SQUARE,LANDSCAPE,PORTRAIT,FREE
        }

        private Context context;

        public Builder( Context context ) {
            this.context = context;
        }

        public Builder callback( PhotoCaptureCallback callback ) {
            GalleryCapture.getInstance( context ).callback = callback;
            return this;
        }

        public Builder crop( boolean crop ) {
            GalleryCapture.getInstance( context ).crop = crop;
            return this;
        }

        public Builder photoFormat( Bitmap.CompressFormat format ) {
            GalleryCapture.getInstance( context ).photoFormat = format;
            return this;
        }

        public Builder photoQuality( QUALITY quality ) {
            GalleryCapture galleryCapture = GalleryCapture.getInstance( context );
            switch ( quality ) {

                case HIGH :
                    galleryCapture.photoQuality =  100;
                    break;
                case MED :
                    galleryCapture.photoQuality = 65;
                    break;
                case LOW :
                    galleryCapture.photoQuality = 25;
                    break;
            }

            return this;
        }

        public Builder photoAspect( ASPECT aspect ) {
            GalleryCapture.getInstance( context ).photoAspect =  aspect;
            return this;
        }

        public Builder filename ( String fileName ) {

            return this;
        }

        public GalleryCapture build() {
            return GalleryCapture.getInstance( context );
        }

    }


}
