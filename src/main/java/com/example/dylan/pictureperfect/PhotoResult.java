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
        this.photoAspect = aspect;
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
                thumbnail = ThumbnailUtils.extractThumbnail( getBitmap(), THUMBNAIL_LANDSCAPE_WIDTH, THUMBNAIL_DEFAULT_HEIGHT );
                break;
            case PORTRAIT:
                thumbnail = ThumbnailUtils.extractThumbnail( getBitmap(), THUMBNAIL_DEFAULT_WIDTH, THUMBNAIL_PORTRAIT_HEIGHT );
                break;
            default:
                thumbnail = ThumbnailUtils.extractThumbnail( getBitmap(), THUMBNAIL_DEFAULT_WIDTH, THUMBNAIL_DEFAULT_HEIGHT );
                break;

        }

        return thumbnail;
    }

    public Bitmap getThumbnail( int x, int y ) {
        return ThumbnailUtils.extractThumbnail( getBitmap(), x, y );
    }

    public Drawable getDrawable() {
        return Drawable.createFromPath(getPath());
    }


    public void loadInto( ImageView view ) {
        view.setImageDrawable(getDrawable());
    }
    public void loadThumbnailInto( ImageView view ) { view.setImageBitmap( getThumbnail( ) ); }

    public void loadThumbnailInto ( ImageView view, int x, int y ) {
        view.setImageBitmap( getThumbnail( x, y ) );
    }



}
