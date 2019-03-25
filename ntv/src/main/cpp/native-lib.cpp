
extern "C" {

#include <jni.h>
#include "libavutil/log.h"

}

extern "C"
JNIEXPORT void JNICALL
Java_org_oz_ntv_CodecHelper_log(JNIEnv *env, jobject obj, jstring _msg) {

    av_log_set_level(AV_LOG_DEBUG);

    jboolean isCopy = 1;

    const char *msg = env->GetStringUTFChars(_msg, &isCopy);

    av_log(nullptr, AV_LOG_INFO, "%s", msg);

}


