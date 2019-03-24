package org.oz.ntv;

public class CodecHelper {

    // Used to load the 'native-lib' library on application startup.
    static {

//        System.loadLibrary("postproc");
        System.loadLibrary("swresample");
        System.loadLibrary("swscale");
        System.loadLibrary("avutil");
        System.loadLibrary("avformat");
        System.loadLibrary("avfilter");
        System.loadLibrary("avdevice");
        System.loadLibrary("avcodec");
        System.loadLibrary("native-lib");

    }


    public native void log(String msg);

}
