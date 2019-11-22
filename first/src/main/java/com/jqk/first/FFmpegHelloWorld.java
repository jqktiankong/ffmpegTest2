package com.jqk.first;

public class FFmpegHelloWorld {
    static {
        System.loadLibrary("helloworld");
    }

    public static native String urlprotocolinfo();

    public static native String avformatinfo();

    public static native String avcodecinfo();

    public static native String avfilterinfo();

    public static native String configurationinfo();
}
