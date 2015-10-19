package com.example.dylan.pictureperfect;

import android.content.Context;

/**
 * Created by dylan on 10/19/15.
 */
public class PhotoCapture {

    public interface PhotoCaptureCallback {
        void getPhotoResult( PhotoResult result );
    }

    public PhotoCapture( Context context ) {
        //cast context to Callback
    }

    private String from = PhotoCaptureBuilder.PICKER;
    private boolean crop = true;

    public void setFrom( String source ) {
        from = source;
    }
    public void setCrop( boolean crop ) {
        this.crop = crop;
    }


    public void start() {
        //make sure source is one of the Builder's constants, if not, default to PICKER
        //call one of below methods, use the CROP boolean when the photo is picked, either show a cropper or not
    }

    private void launchPicker() {

    }
    private void launchGalleryPicker() {

    }
    private void launchCamera() {

    }


    public class PhotoCaptureBuilder {

        public static final String GALLERY = "GALLERY";
        public static final String CAMERA = "CAMERA";
        public static final String PICKER = "PICKER";

        private Context context;
        private PhotoCapture photoCapture;


        public PhotoCaptureBuilder( Context context ) {
            this.context = context;
        }

        public PhotoCaptureBuilder from( String photoSource ) {
            photoCapture = photoCapture == null ? new PhotoCapture( context ) : photoCapture;
            photoCapture.setFrom( photoSource );
            return this;
        }

        public PhotoCaptureBuilder crop( boolean crop ) {
            photoCapture = photoCapture == null ? new PhotoCapture( context ) : photoCapture;
            photoCapture.setCrop( crop );
            return this;
        }

        public PhotoCapture build() {
            return photoCapture;
        }


    }

}
