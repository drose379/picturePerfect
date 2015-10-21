##picturePerfect

_Handling images coming from the users Gallery / Camera can get messy and confusing. This library offers simplicity when it comes to photo capture and handling_

###Usage

#####_Selecting Photos From Gallery, with a crop_

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

#####_Selecting photos from gallery with crop and filetype to convert to_
```
    public void getGalleryImage() {
    
        GalleryCapture galleryCapture = new GalleryCapture.Builder()
            .crop( true )
            .photoFormat( Bitmap.CompressFormat.JPEG )
            .build();

        galleryCapture.setCallback( this );
        galleryCapture.start();

    }   

    @Override
    public void getPhotoResult( PhotoResult result ) {

    }


```
#####_Selecting photos from gallery with crop and aspect ratio_
_In order to use the aspect ratio, the crop() option must be set to true_
```
    public void getGalleryImage() {
    
        GalleryCapture galleryCapture = new GalleryCapture.Builder()
            .crop( true )
            .setPhotoAspect( ASPECT.LANDSCAPE )
            .build();

        galleryCapture.setCallback( this );
        galleryCapture.start();

    }   

    @Override
    public void getPhotoResult( PhotoResult result ) {

    }

```


####Required Permissions
_android.permission.READ_EXTERNAL_STORAGE_ ,
_android.permission.WRITE_EXTERNAL_STORAGE_


#####_In Progress_