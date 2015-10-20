package com.example.dylan.pictureperfect;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.soundcloud.android.crop.Crop;

import java.io.File;
import java.util.Random;

/**
 * Created by dylan on 10/20/15.
 */
public class Cropper extends AppCompatActivity {

    private Uri croppedImage;

    @Override
    public void onCreate( Bundle savedInstance ) {
        super.onCreate( savedInstance );
        Uri imageUri = Uri.parse( getIntent().getStringExtra("selectedUri") );
        croppedImage = Uri.fromFile( new File(getFilesDir(), new Random().nextInt() + "_crop") );

        Crop.of(imageUri, croppedImage ).start( this );
    }

    @Override
    public void onActivityResult( int requestCode, int resultCode, Intent result ) {
        if ( resultCode == RESULT_OK ) {
            GalleryCapture.getInstance( this ).getCropperResult( new File(Crop.getOutput( result ).getPath()) );
        }

        finish();
    }

}
