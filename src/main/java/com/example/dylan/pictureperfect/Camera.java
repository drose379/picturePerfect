package com.example.dylan.pictureperfect;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by dylan on 10/21/15.
 */
public class Camera extends AppCompatActivity {

    @Override
    public void onCreate( Bundle savedInstance ) {
        super.onCreate( savedInstance );

        Intent photoCapture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE );
        startActivityForResult( photoCapture, 1 );
    }

    @Override
    public void onActivityResult( int requestCode, int resultCode, Intent data ) {
        if ( resultCode == RESULT_OK ) {
            CameraCapture.getInstance( this ).getPickerResult( data );
        }

        finish();
    }

}
