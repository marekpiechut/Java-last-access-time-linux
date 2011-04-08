#include <jni.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#include <time.h>


Java_com_wordpress_jdevel_utils_JAccessTimeUnix_getLastAccessTime
  (JNIEnv * env, jclass clazz, jstring path){

    char* filename = (*env)->GetStringUTFChars(env, path, NULL);
    struct stat buf;
    long time = 0;

    if (!stat(filename, &buf)) {
        time = buf.st_atime;
    }

    return (jint) time;
}

int main(int argc, char** argv) {

    if(argc > 1) {
        struct stat buf;
        char* filename = argv[1];

        if (!stat(filename, &buf)) {
            struct tm* atime = localtime(&buf.st_atime);
            char* val = asctime(atime);
            printf(val);
        } else {
            return NULL;
        }
    } else {
        printf("Pass file name\n");
    }
    return (0);
}