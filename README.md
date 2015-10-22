##picturePerfect

_Handling images coming from the users Gallery / Camera can get messy and confusing. This library offers simplicity when it comes to photo capture and handling_

###Usage

#####_Selecting Photos From Gallery, with a crop_

```java
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
```java
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
        result.loadThumbnailInto( imageView );
    }


```
#####_Selecting photos from gallery with crop and aspect ratio_
_In order to use the aspect ratio, the crop() option must be set to true_
```java
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

####All available options in GalleryCapture.Builder ( So Far ) :
```java
.crop( boolean )
.photoFormat( Bitmap.CompressFormat )
.photoQuality( QUALITY [HIGH,MED,LOW] )  
.photoAspect( ASPECT [FREE,SQUARE,LANDSCAPE,PORTRAIT] )
```

####PhotoResult class ( So Far )
```java

    String getPath();
    File getFile();
    Uri getUri();
    Bitmap getBitmap();
    Bitmap getThumbnail();
    Bitmap getThumbnail( int width, int height );
    Drawable getDrawable();

    void loadInto( ImageView );
    void loadThumbnailInto( ImageView );
    void loadThumbnailInto( ImageView, int width, int height );

```

####Required Permissions
_android.permission.READ_EXTERNAL_STORAGE_ 
_android.permission.WRITE_EXTERNAL_STORAGE_
_android.hardware.camera_


#####_In Progress_


####Licence

The MIT License (MIT)

Copyright (c) [2015] [Dylan Rose]

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
