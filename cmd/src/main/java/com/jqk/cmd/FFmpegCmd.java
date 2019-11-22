package com.jqk.cmd;

import android.util.Log;

public class FFmpegCmd {
    static
    {
        System.loadLibrary("ffmpeg-cmd");
    }

    private static OnCmdExecListener sOnCmdExecListener;
    private static long sDuration;

    public static native int exec(int argc, String[] argv);

    public static native void exit();

    public static void exec(String[] cmds, long duration, OnCmdExecListener listener) {
        sOnCmdExecListener = listener;
        sDuration = duration;
        exec(cmds.length, cmds);
    }

    /**
     * FFmpeg执行结束回调，由C代码中调用
     */
    public static void onExecuted(int ret) {
        if (sOnCmdExecListener != null) {
            if (ret == 0) {
                sOnCmdExecListener.onProgress(sDuration);
                sOnCmdExecListener.onSuccess();
            } else {
                sOnCmdExecListener.onFailure();
            }
        }
    }

    /**
     * FFmpeg执行进度回调，由C代码调用
     */
    public static void onProgress(float progress) {
        if (sOnCmdExecListener != null) {
            if (sDuration != 0) {
                sOnCmdExecListener.onProgress(progress / (sDuration / 1000) * 0.95f);
            }
        }
    }

    public interface OnCmdExecListener {
        void onSuccess();

        void onFailure();

        void onProgress(float progress);
    }
}