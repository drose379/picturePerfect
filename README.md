##picturePerfect
A photo handling library for Android 

Handling images coming from the users Gallery / Camera can get messy and confusing. This library offers simplicity when it comes to photo handline

_Selecting Photos From Gallery, with a crop_

```
public void getGalleryImage() {

    GalleryCapture galleryCapture = new GalleryCapture.Builder( this )
        .crop( true )
        .build();
    
    galleryCapture.setCallback( this )
    galleryCapture.start();

}

@Override
public void getPhotoResult( PhotoResult result ) {
   
    Drawable d = result.getDrawable();
    Bitmap b = result.getBitmap();
    File f = result.getFile();
    String path = result.getPath();
    
    result.loadInto( imageView );

}
```
