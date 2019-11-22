#include <jni.h>

#ifndef _Included_FFmpeg_Cmd
#define _Included_FFmpeg_Cmd
#ifdef __cplusplus
extern "C" {
#endif

JNIEXPORT jint JNICALL Java_com_jqk_cmd_FFmpegCmd_exec(JNIEnv *, jclass, jint, jobjectArray);

JNIEXPORT void JNICALL Java_com_jqk_cmd_FFmpegCmd_exit(JNIEnv *, jclass);

#ifdef __cplusplus
}
#endif
#endif

void ffmpeg_progress(float progress);