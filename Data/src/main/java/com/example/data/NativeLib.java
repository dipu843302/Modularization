package com.example.data;

public class NativeLib {

    // Used to load the 'data' library on application startup.
    static {
        System.loadLibrary("data");
    }

    /**
     * A native method that is implemented by the 'data' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}