//
// Created by oz on 2018/1/1.
//

#ifndef NATIVECODETRAINING_LOG_H
#define NATIVECODETRAINING_LOG_H

#include <android/log.h>

//log
#define LOGE(format, ...)  __android_log_print(ANDROID_LOG_ERROR, "(*_*)", format, ##__VA_ARGS__)
#define LOGI(format, ...)  __android_log_print(ANDROID_LOG_INFO, "(^_^)", format, ##__VA_ARGS__)



#endif //NATIVECODETRAINING_LOG_H
