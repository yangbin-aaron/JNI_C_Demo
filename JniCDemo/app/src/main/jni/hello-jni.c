
#include <string.h>
#include <jni.h>

#include "Operate.h"

jint Java_com_aaron_jnicdemo_MainActivity_add( JNIEnv* env,
                                                  jobject thiz,
                                                   jint x,jint y)
{
    return add(x,y);
}
