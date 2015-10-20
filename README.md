##picturePerfect
A photo handling library for Android 

Handling images coming from the users Gallery / Camera can get messy and confusing. This library offers simplicity when it comes to photo handline

_Selecting Photos From Gallery, with a crop_

```
GalleryCapture galleryCapture = new GalleryCapture.Builder( this )
    .crop( true )
    .build();
    
galleryCapture.setCallback( this )
galleryCapture.start();

@Override
public void getPhotoResult( PhotoResult result ) {
  // PhotoResult contains Drawable, Bitmap, File 
  // Also contains convenience method for loading the image into an ImageView
  result.loadInto( ImageView );
}
```
