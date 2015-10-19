package com.example.dylan.pictureperfect;

/**
 * Created by dylan on 10/19/15.
 */
public class PhotoCapture {

    private String from = PhotoCaptureBuilder.PICKER;

    public void setFrom( String source ) {
        from = source;
    }


    public void start() {

    }


    public class PhotoCaptureBuilder {

        public static final String GALLERY = "GALLERY";
        public static final String CAMERA = "CAMERA";
        public static final String PICKER = "PICKER";

        private PhotoCapture photoCapture;

        public PhotoCaptureBuilder from( String photoSource ) {

            if ( photoCapture != null ) {
                //set the from field
            } else {

            }

            return this;
        }

        public PhotoCaptureBuilder crop( boolean crop ) {

            return this;
        }

        public PhotoCapture build() {

            
        }


    }

}
