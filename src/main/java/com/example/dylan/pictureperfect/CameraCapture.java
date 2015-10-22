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

    @Override
    public void getPickerResult( Intent data ) {
        //TODO:: The handling of the photo from the camera will be different from handling of Gallery photo, may not be calling super method here
        //TODO:: Must save the new photo to a file first, may need seperate methods for getting Camera result from other Gallery result handling
        Log.i("CAMERA_RESULT",data.getData().toString());
        //super.getPickerResult( data );
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
