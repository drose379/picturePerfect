package com.example.dylan.pictureperfect;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.soundcloud.android.crop.Crop;

import java.io.File;
import java.util.Random;

import com.example.dylan.pictureperfect.GalleryCapture.Builder.ASPECT;

/**
 * Created by dylan on 10/20/15.
 */
public class Cropper extends AppCompatActivity {

    private Uri croppedImage;
    private ASPECT photoAspect;

    @Override
    public void onCreate( Bundle savedInstance ) {
        super.onCreate( savedInstance );

        photoAspect = (ASPECT) getIntent().getSerializableExtra("aspect");
        Uri imageUri = Uri.parse( getIntent().getStringExtra("selectedUri") );
        croppedImage = Uri.fromFile( new File(getFilesDir(), new Random().nextInt() + "_crop") );

        switch ( photoAspect ) {
            case FREE:
                Crop.of(imageUri, croppedImage ).start(this);
                break;
            case SQUARE:
                Crop.of(imageUri, croppedImage ).asSquare().start(this);
                break;
            case LANDSCAPE:
                Crop.of(imageUri, croppedImage ).withAspect( 2, 1 ).start(this);
                break;
            case PORTRAIT:
                Crop.of(imageUri, croppedImage ).withAspect( 1, 2 ).start(this);
                break;
        }

    }

    @Override
    public void onActivityResult( int requestCode, int resultCode, Intent result ) {
        if ( resultCode == RESULT_OK ) {
            GalleryCapture.getInstance( this ).getCropperResult( new File(Crop.getOutput( result ).getPath()) );
        }

        finish();
    }

}
