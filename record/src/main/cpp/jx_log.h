//
// Created by Administrator on 2019/11/25.
//

#ifndef JIANXIFFMPEG_JX_LOG_H
#define JIANXIFFMPEG_JX_LOG_H

#include <android/log.h>

extern int JNI_DEBUG;

#define LOGE(debug, format, ...) if(debug){__android_log_print(ANDROID_LOG_ERROR, "jianxi_ffmpeg", format, ##__VA_ARGS__);}
#define LOGI(debug, format, ...) if(debug){__android_log_print(ANDROID_LOG_INFO, "jianxi_ffmpeg", format, ##__VA_ARGS__);}

#endif //JIANXIFFMPEG_JX_LOG_H
