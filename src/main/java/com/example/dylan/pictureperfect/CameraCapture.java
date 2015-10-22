package com.example.dylan.pictureperfect;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;

import java.io.File;

/**
 * Created by Dylan Rose on 10/20/15.
 */
public class CameraCapture extends PhotoCapture {

    public CameraCapture( Context context ) {
        super( context );
    }

    private static CameraCapture cameraCapture = null;
    public static CameraCapture getInstance( Context context ) {
        cameraCapture = cameraCapture == null ? new CameraCapture( context ) : cameraCapture;
        return cameraCapture;
    }

    @Override
    public void start() {
        Intent cameraCapture = new Intent( context, Camera.class );
        context.startActivity( cameraCapture );
    }

    public void getPickerResult( File data ) {
        if ( crop ) {

        } else {
            callback.getPhotoResult( new PhotoResult( data, null, photoAspect ) ); // workin
        }
    }

    @Override
    public void getCropperResult( File croppedPhoto ) {

    }


    public static class Builder {
        private Context context;

        public Builder( Context context ) {
            this.context = context;
        }

        public Builder callback( PhotoCaptureCallback callback ) {
            CameraCapture.getInstance( context ).callback = callback;
            return this;
        }

        public Builder crop( boolean crop ) {
            CameraCapture.getInstance( context ).crop = crop;
            return this;
        }

        public CameraCapture build() {
            return CameraCapture.getInstance( context );
        }
    }
}
