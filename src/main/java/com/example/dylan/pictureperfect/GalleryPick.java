package com.example.dylan.pictureperfect;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by dylan on 10/19/15.
 */
public class GalleryPick extends AppCompatActivity {

    public interface GalleryResult {
        void getGallerySelection( Intent data );
    }

    @Override
    public void onCreate( Bundle savedInstance ) {
        super.onCreate( savedInstance );
        Intent galleryPick = new Intent( Intent.ACTION_PICK );
        galleryPick.setType("image/*");
        startActivityForResult( galleryPick,1 );
    }

    @Override
    public void onActivityResult( int requestCode, int resultCode, Intent data ) {
        if ( resultCode == RESULT_OK ) {
            GalleryCapture.getInstance( this ).getPickerResult( data );
            this.finish();
        }
        //TODO:: IF result is not OK, throw exception
    }

}
