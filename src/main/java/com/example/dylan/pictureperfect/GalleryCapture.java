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

    public void getPickerResult( Intent photoData ) {
        Uri selectedUri = photoData.getData();
        if ( crop ) {

            Intent crop = new Intent( context, Cropper.class );
            crop.putExtra( "selectedUri", selectedUri.toString() );
            context.startActivity( crop );

        } else {
            parseUri( selectedUri );
        }
    }

    public void getCropperResult( File croppedPhoto ) {
        //TODO:: Convert filetype into correct type stored in PhotoCapture
        compressToFormat( croppedPhoto, photoFormat );
        callback.getPhotoResult( new PhotoResult( croppedPhoto, null ) );
    }

    public static class Builder {

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

        public Builder photoFormat( Bitmap.CompressFormat format ) {
            galleryCapture = galleryCapture == null ? GalleryCapture.getInstance( context ) : galleryCapture;
            galleryCapture.setPhotoFormat( format );
            return this;
        }

        public Builder filename ( String fileName ) {

            return this;
        }

        public GalleryCapture build() {
            return galleryCapture;
        }

    }


}
