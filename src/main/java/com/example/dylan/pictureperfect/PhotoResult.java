package com.example.dylan.pictureperfect;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.example.dylan.pictureperfect.GalleryCapture.Builder.ASPECT;

import java.io.File;

/**
 * Created by dylan on 10/19/15.
 */
public class PhotoResult {

    private File image;
    private Uri uri;
    private ASPECT photoAspect;

    private static int THUMBNAIL_DEFAULT_WIDTH = 70;
    private static int THUMBNAIL_DEFAULT_HEIGHT = 70;
    private static int THUMBNAIL_LANDSCAPE_WIDTH = 210;
    private static int THUMBNAIL_PORTRAIT_HEIGHT = 210;

    public PhotoResult( File image, @Nullable Uri uri, ASPECT aspect ) {
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

    public Bitmap getThumbnail( ) {
        Bitmap thumbnail;

        switch ( photoAspect ) {
            case LANDSCAPE :

                break;
            case PORTRAIT:

                break;
            default:

                break;

        }


        return thumbnail;
        //return ThumbnailUtils.extractThumbnail( getBitmap(), THUMBNAIL_DEFAULT, THUMBNAIL_DEFAULT );
    }

    public Drawable getDrawable() {
        return Drawable.createFromPath( getPath() );
    }


    public void loadInto( ImageView view ) {
        view.setImageDrawable(getDrawable());
    }
    public void loadThumbnailInto( ImageView view ) { view.setImageBitmap( getThumbnail( ) ); }



}
