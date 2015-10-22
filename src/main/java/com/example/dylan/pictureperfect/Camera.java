package com.example.dylan.pictureperfect;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.io.File;
import java.io.IOException;
import java.util.Random;

/**
 * Created by dylan on 10/21/15.
 */
public class Camera extends AppCompatActivity {

    private File currentFile;
    private boolean shouldCapture = true;

    @Override
    public void onCreate( Bundle savedInstance ) {
        super.onCreate(savedInstance);

        if ( shouldCapture ) {
            Intent photoCapture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE );
            photoCapture.putExtra( MediaStore.EXTRA_OUTPUT, Uri.fromFile( generator() ) );
            startActivityForResult(photoCapture, 1);
        }

        if ( savedInstance != null ) {
            currentFile = (File) savedInstance.getSerializable("currentImage");
        }

        shouldCapture = false;

    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i("STOP","STOPED");

    }

    @Override
    public void onSaveInstanceState( Bundle savedInstance ) {
        savedInstance.putSerializable( "currentFile", currentFile );
        super.onSaveInstanceState( savedInstance );
    }


    public File generator() {
        File photo = null;
        Random random = new Random();

        int randomNumber = random.nextInt();
        String fileName = "picture_perfect_" + randomNumber;
        //TODO:: Account for file type that is set in Builder here
        try {
            photo = File.createTempFile( fileName, ".jpg", Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES) );
        } catch( IOException e) {
            throw new RuntimeException( e.getMessage() );
        }
        currentFile = photo;
        return photo;
    }

    @Override
    public void onActivityResult( int requestCode, int resultCode, Intent data ) {

        if ( resultCode == RESULT_OK && currentFile != null ) {
            CameraCapture.getInstance( this ).getPickerResult( currentFile );
        }

        this.finish();

    }

}
