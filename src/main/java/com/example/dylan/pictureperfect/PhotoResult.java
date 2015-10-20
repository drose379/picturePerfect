package com.example.dylan.pictureperfect;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import java.io.File;

/**
 * Created by dylan on 10/19/15.
 */
public class PhotoResult {

    private File image;
    private Uri uri;

    public PhotoResult( File image, @Nullable Uri uri ) {
        this.image = image;
        this.uri = uri;
    }

    public String getPath() {
        return image.getPath();
    }

    public File getFile() {
        return image;
    }

    public Uri getUri() {
        return uri != null ? uri : Uri.parse("NULL");
    }

    public Bitmap getBitmap() {
        return BitmapFactory.decodeFile( getPath() );
    }

    public Drawable getDrawable() {
        return Drawable.createFromPath( getPath() );
    }


    public void loadInto( ImageView view ) {
        view.setImageDrawable(getDrawable());
    }



}
